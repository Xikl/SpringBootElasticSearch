package com.ximo.springbootes.service;

import org.elasticsearch.action.get.GetResponse;

/**
 * 图书馆服务类
 * Created by 朱文赵
 * 2017/9/26
 */
public interface LibraryService {

    GetResponse get(String id);

}
