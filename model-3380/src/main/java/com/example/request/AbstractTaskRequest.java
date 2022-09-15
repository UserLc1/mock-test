package com.example.request;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.SuperTestSetting;
import com.example.bean.TestQueue;

/**
 * @Author: Lc
 * @Date: 2022-02-24
 * @apiNote 任务队列抽象类
 */
public abstract class AbstractTaskRequest implements QueueRequest{
    protected TestQueue queue;
    protected SuperTestSetting setting;

    public AbstractTaskRequest(TestQueue queue, Class<? extends SuperTestSetting> setting){
        this.queue = queue;
        SuperTestSetting superTestSetting = JSONObject.parseObject(queue.getSetting(), setting);
        this.setting = superTestSetting;
        check(queue);
    }


    public void check(TestQueue queue) {
        if(queue.getId()==0){
            throw new RuntimeException();
        }
    }


    public void getSetting(){
        System.out.println(JSONObject.toJSONString(setting));
    }

}
