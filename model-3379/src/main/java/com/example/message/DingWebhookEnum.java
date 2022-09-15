package com.example.message;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Lc
 * @Date: 2022-09-07
 * @apiNote
 */
public enum DingWebhookEnum {

    /** YTS业务群推送 */
    TEST_BUS("28ff337741dda48618e5e4962a1e970706b6bbfc7945f8dd62dd60fec96d4bd7",
            "SEC8ed4d180721c2f9d15aa75fc0bafafcbb93665a8382deb4d1bafab581512e229"),
    ;

    DingWebhookEnum(String accessToken, String secret){
        this.accessToken = accessToken;
        this.secret = secret;
    }

    private static final String DING_WEBHOOK = "https://oapi.dingtalk.com/robot/send?access_token=";
    /** accessToken */
    private final String accessToken;
    /** secret */
    private final String secret;

    /**
     * 获取钉钉推送URL
     * @return url
     */
    public String getDingPushUrl(){
        long timestamp = System.currentTimeMillis();
        String sercet = this.secret;
        String stringToSign = timestamp + "\n" + sercet;
        StringBuilder url = new StringBuilder(DING_WEBHOOK + this.accessToken);
        url.append("&timestamp=").append(timestamp);
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(sercet.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
            url.append("&sign=")
                    .append(sign);
            return url.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
