package com.aku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//开启熔断
@EnableHystrix
public class RailwayUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(RailwayUserApplication.class);
    }
}
