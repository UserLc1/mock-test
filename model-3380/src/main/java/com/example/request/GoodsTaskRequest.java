package com.example.request;

import com.example.bean.GoodsQueueSetting;
import com.example.bean.SuperTestSetting;
import com.example.bean.TestQueue;

/**
 * @Author: Lc
 * @Date: 2022-02-28
 * @apiNote
 */
public class GoodsTaskRequest extends AbstractTaskRequest{

    public GoodsTaskRequest(TestQueue queue) {
        super(queue, GoodsQueueSetting.class);
    }


    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public void taskOver() {

    }
}
