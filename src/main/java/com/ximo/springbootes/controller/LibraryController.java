package com.ximo.springbootes.controller;

import com.ximo.springbootes.utils.ResultUtils;
import com.ximo.springbootes.vo.Result;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@RestController
public class LibraryController {

    @Autowired
    private TransportClient client;

    @GetMapping("/get/book/novel/{id}")
    public Result get(@PathVariable("id") String id){
        return ResultUtils.success(client.prepareGet("book", "novel", id).get());
    }




}
