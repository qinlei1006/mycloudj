package com.lovo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //客服端
@EnableFeignClients  //feign远程调用
public class OneMain {
    public static void main(String[] args) {
        SpringApplication.run(OneMain.class);
    }
}
