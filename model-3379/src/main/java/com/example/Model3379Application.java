package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication()
@Configuration
@EnableFeignClients
public class Model3379Application {

    public static void main(String[] args) {
        SpringApplication.run(Model3379Application.class, args);
    }

}
