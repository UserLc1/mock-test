package com.example.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * @Author: Lc
 * @Date: 2022-09-07
 * @apiNote
 */
public class DingMsg {
    /**
     * 推送钉钉消息
     * @param dingMsgParam 消息内容
     */
    public static void sendDingMsg(DingMsgParam dingMsgParam, DingWebhookEnum dingWebhook){
            String url = dingWebhook.getDingPushUrl();
            if(dingMsgParam != null && dingWebhook != null){
                HttpClient httpClient = HttpClients.createDefault();
                assert url != null;
                HttpPost httpPost = new HttpPost(url);
                httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
                String content = dingMsgParam.buildContent();
                httpPost.setEntity(new StringEntity(content, StandardCharsets.UTF_8));
                try {
                    HttpResponse execute = httpClient.execute(httpPost);
                    JSONObject executeResultJson = JSON.parseObject(EntityUtils.toString(execute.getEntity(),
                            "UTF-8"));
                    if(executeResultJson.getInteger("errcode") != 0){
//                        log.info("钉钉消息推送失败：" + executeResultJson.toJSONString() + ", 推送参数：" +
//                                JSON.toJSONString(dingMsgParam));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
//                    log.info("钉钉消息推送失败：" + e.getMessage(), e);
                }
            }
    }

    public static void main(String[] args) {
        sendDingMsg(new DingMsgParam("测试异常, 日志编号"),DingWebhookEnum.TEST_BUS);
    }

}
