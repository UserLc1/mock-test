package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication()
@Configuration
public class Model3380Application {

    public static void main(String[] args) {
        SpringApplication.run(Model3380Application.class, args);
    }

}
