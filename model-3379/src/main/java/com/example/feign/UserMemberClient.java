package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Lc
 * @Date: 2021-08-09
 * @apiNote
 */
@FeignClient(name = "nacos-config-client")
public interface  UserMemberClient {

    @GetMapping("/config/getByAll")
    String getByAll();

    @GetMapping("/config/saveEntity")
    String saveEntity();
}
