package com.example.design;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

/**
 * @Author: Lc
 * @Date: 2022-09-15
 * @apiNote
 */
public class TestMain {

    /**
     * 建造者模式
     */
    public static void buliderPatternTest(){
        ResourcePoolConfig name = new ResourcePoolConfig.Builder()
                .setName("name")
                .setMaxIdle(3)
                .setMaxTotal(4)
                .setMinIdle(2)
                .build();
        System.out.println(JSONObject.toJSONString(name));
    }

    public static void main(String[] args) {

        //建造者模式
        buliderPatternTest();

        //动态代理
        ResourcePoolProxy proxy = new ResourcePoolProxy();

    }
}
