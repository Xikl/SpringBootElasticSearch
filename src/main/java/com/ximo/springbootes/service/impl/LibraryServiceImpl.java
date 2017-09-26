package com.ximo.springbootes.service.impl;

import com.ximo.springbootes.enums.ResultEnums;
import com.ximo.springbootes.exception.LibraryException;
import com.ximo.springbootes.service.LibraryService;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@Service
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
     * 检查id是否为空
     * @param id
     */
    private void checkId(String id){
        if(StringUtils.isBlank(id)){
            throw new LibraryException(ResultEnums.ID_IS_BLANK);
        }
    }

}
