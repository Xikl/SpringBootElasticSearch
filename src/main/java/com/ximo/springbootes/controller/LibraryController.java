package com.ximo.springbootes.controller;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@RestController
public class LibraryController {

    @Autowired
    private TransportClient client;




}
