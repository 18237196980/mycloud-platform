package com.zzsm.platform.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.zzsm.platform")
public class SmAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmAuthApplication.class, args);
    }
}
