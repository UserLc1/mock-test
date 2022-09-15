package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.feign.UserMemberClient;
import com.example.xo.dto.Result;
import com.example.xo.entity.zb.ZbUser;
import com.example.xo.service.xgdb.user.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Lc
 * @Date: 2021-08-09
 * @apiNote
 */
@RestController
public class ZbUserController {
    @Resource
    UserMemberClient userMemberClient;
    @Autowired
    TestService testService;

    @GetMapping("/config/getByAll")
    public String getByAll(){
        return JSONObject.toJSONString(userMemberClient.getByAll());
    }

    @GetMapping("/config/saveEntity")
    public String saveEntity(){
        userMemberClient.saveEntity();
        return testService.saveEntity();
    }


}
