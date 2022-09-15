package com.example.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钉钉消息模版
 * @author: Cxc
 * @date: 2020-09-15 16:49
 **/
@Data
public class DingMsgParam {

    /** 默认at 所有人 */
    public DingMsgParam(String content){
        this(content, true, null);
    }
    /** 批量at */
    public DingMsgParam(String content, List<String> atMobiles){
        this(content, false, atMobiles);
    }

    /** at 个人 */
    public DingMsgParam(String content, String atMobile){
        List<String> atMobiles = new ArrayList<>();
        atMobiles.add(atMobile);
        this.content = content;
        this.atMobiles = atMobiles;
    }

    public DingMsgParam(String content, boolean isAtAll, List<String> atMobiles){
        this.content = content;
        this.isAtAll = isAtAll;
        this.atMobiles = atMobiles;
    }

    /** 消息正文 */
    private String content;
    /** 是否at所有人 */
    private boolean isAtAll;
    /** at个人钉钉号 */
    private List<String> atMobiles;

    /**
     * 构建钉钉推送json参数
     * @return json字符串
     */
    public String buildContent(){
        if(StringUtils.isNotBlank(this.content)) {
            this.content = this.content.replace("\"", "")
                    .replace("{", "(")
                    .replace("}", ")");
        }
        String msg = "{\"msgtype\":\"text\",\"text\":{\"content\":\"" + this.content + "\"},\"at\": {";
        if(this.atMobiles != null && !this.atMobiles.isEmpty()){
            msg += "\"atMobiles\":" + JSON.toJSONString(this.atMobiles) + ",";
        }
        return msg + "\"isAtAll\":" + this.isAtAll + "}}";
    }

    /**
     * 构建钉钉推送json参数
     * @return json字符串
     */
    public String buildContentJsonString(){
        if(StringUtils.isNotBlank(this.content)) {
            this.content = this.content.replace("\"", "")
                    .replace("{", "(")
                    .replace("}", ")");
        }
        Map<String, Object> json = new HashMap<>(4);

        Map<String, Object> text = new HashMap<>(4);

        String at = "{";
        if(this.atMobiles != null && !this.atMobiles.isEmpty()){
            at += "\"atMobiles\":" + JSON.toJSONString(this.atMobiles) + ",";
        }
        at += "\"isAtAll\":" + this.isAtAll + "}";
        text.put("content", content);
        text.put("at", at);

        json.put("msgtype","text");
        json.put("text",text);

        return JSONObject.toJSONString(json);
    }



}
