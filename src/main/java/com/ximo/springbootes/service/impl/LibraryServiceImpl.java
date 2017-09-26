package com.ximo.springbootes.service.impl;

import com.ximo.springbootes.domain.Novel;
import com.ximo.springbootes.enums.ResultEnums;
import com.ximo.springbootes.exception.LibraryException;
import com.ximo.springbootes.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@Service
@Slf4j
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private TransportClient client;

    /**
     * 根据id查询方法
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> get(String id) {
        this.checkId(id);
        GetResponse result = client.prepareGet("book", "novel", id).get();
        if( !result.isExists()){
            throw new LibraryException(ResultEnums.NOVEL_NOT_EXIST);
        }
        return result.getSource();
    }

    /**
     * 添加的方法
     * @param novel
     * @return
     */
    @Override
    public Map<String, Object> add(Novel novel) {
        try {
            //构建数据
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", novel.getTitle())
                    .field("author", novel.getAuthor())
                    .field("word_count", novel.getWordCount())
                    .field("publish_date", novel.getPublishDate().getTime())
                    .endObject();//构建结束

            //构建索引
            IndexResponse result = this.client.prepareIndex("book","novel")
                    .setSource(content)//放入文档
                    .get();
            //由于返回的是id，所以构建一个id的map
            Map<String, Object> map = new HashMap<>();
            map.put("id", result.getId());
            return map;
        } catch (IOException e) {
            log.error("【添加novel】 io错误， novel={}, e={}", novel, e);
            throw new LibraryException(ResultEnums.UNKNOWN_ERROR);
        }
    }

    /**
     * 检查id是否为空
     * @param id
     */
    private void checkId(String id){
        if(StringUtils.isBlank(id)){
            throw new LibraryException(ResultEnums.ID_IS_BLANK);
        }
    }

}
