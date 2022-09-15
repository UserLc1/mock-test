package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.example.xo.async.AsyncTaskService;
import com.example.xo.dto.Result;
import com.example.xo.entity.ActivityBargainHelp;
import com.example.xo.entity.zb.ZbUser;
import com.example.xo.service.xgdb.user.ActivityBargainHelpService;
import com.example.xo.service.xgdb.user.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Lc
 * @Date: 2021-07-03
 */
@RestController
@RefreshScope//支持Nacos的动态刷新功能。
public class ConfigClientController {
    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private AsyncTaskService asyncTaskService;
    @Autowired
    private UserMemberService userMemberService;
    @Autowired
    private ActivityBargainHelpService activityBargainHelpService;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String info() {
        return configInfo;
    }
    @GetMapping("/config/infos")
    @SentinelResource(value = "infos",blockHandler = "info")
    public String getConfigInfos(@RequestParam(value = "p1", required = false) String p1){
//        return restTemplate.getForObject("http://nacos-config-client/config/info",String.class);
        return "hao"+p1;
    }

    @GetMapping("/config/testFun")
    public String testFun() throws ExecutionException, InterruptedException {

        return  asyncTaskService.testFun().get();
    }

    @GetMapping("/config/testFutureTask")
    public String testFutureTask() throws ExecutionException, InterruptedException {

        return  asyncTaskService.testFutureTask().get();
    }

    @GetMapping("/config/getByAll")
    public String getByAll(){
        return JSONObject.toJSONString(userMemberService.getByAll());
    }

    @GetMapping("/config/saveEntity")
    public String saveEntity(){
        return JSONObject.toJSONString(activityBargainHelpService.saveEntity());
    }


}
