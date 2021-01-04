package com.aku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class)
@EnableZuulProxy
@EnableDiscoveryClient
public class RailWayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(RailWayZuulApplication.class);
    }
}
