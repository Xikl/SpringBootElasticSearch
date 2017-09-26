package com.ximo.springbootes.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * es配置类
 * Created by 朱文赵
 * 2017/9/26
 */
@Configuration
public class ESConfig {

    /**
     * 构造一个TransportClient的bean
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public TransportClient client() throws UnknownHostException {
        //指定tcp端口号
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );
        //替换为自己的集群名字
        Settings settings = Settings.builder()
                .put("cluster.name", "ximo")
                .build();
        //可以继续添加其他的集群
        //...
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }


}
