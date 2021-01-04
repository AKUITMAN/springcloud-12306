package com.aku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//标注当前工程是配置中心的服务端
@EnableConfigServer
@EnableDiscoveryClient
public class AkuShopConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(AkuShopConfigApplication.class,args);
    }
}
