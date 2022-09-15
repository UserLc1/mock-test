package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.GoodsQueueSetting;
import com.example.bean.TestQueue;
import com.example.request.AbstractTaskRequest;
import com.example.request.GoodsTaskRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author: Lc
 * @Date: 2022-03-01
 * @apiNote
 */
public class test {
    public static final Logger LOGGER = LogManager.getLogger("elk.test");
    public static void main(String[] args) {
        LOGGER.info("helow world!");
        GoodsQueueSetting goodsQueueSetting = new GoodsQueueSetting();
        goodsQueueSetting.setGoodsId(11L);
        goodsQueueSetting.setLimits("11");
        TestQueue testQueue = new TestQueue();
        testQueue.setSetting(JSONObject.toJSONString(goodsQueueSetting));
        testQueue.setId(1L);
        AbstractTaskRequest taskRequest = new GoodsTaskRequest(testQueue);
        taskRequest.getSetting();
    }
}
