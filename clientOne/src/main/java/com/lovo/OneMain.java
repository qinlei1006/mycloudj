package com.lovo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //客服端
public class OneMain {
    public static void main(String[] args) {
        SpringApplication.run(OneMain.class);
    }
}
