package com.example.commons.test.util;

import com.example.commons.test.attr.Attributes;
import com.example.commons.test.session.Session;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Lc
 * @Date: 2020-09-15
 */
public class SessionUtil {
    // userId -> channel 的映射
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();


    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {

        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }


    public int sharedState;
    public synchronized void nonSafeAction() {
        while (sharedState < 100000) {
            int former = sharedState++;
            int latter = sharedState;
            if (former != latter - 1) {
                System.out.printf("Observed data race, former is " +
                        former + ", " + "latter is " + latter);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//            SessionUtil sample = new SessionUtil();
//        Thread threadA = new Thread(){
//            public void run(){
//                sample.nonSafeAction();
//            }
//        };
//        Thread threadB = new Thread(){
//            public void run(){
//                sample.nonSafeAction();
//            }
//        };
//        threadA.start();
//        threadB.start();
//        threadA.join();
//        threadB.join();
        String a = "佳音暑假提高班即日起可报名！转发朋友圈集38个赞前十位报名交费优惠50至200元并送精美礼品一份！小班教学额满为止！多谢转发，欢迎咨询！ 喜报:佳音辅导近期取得辉煌成绩！陈雨轩考上榕实免费；光正、岐山全免生！刘昊楠、陈昊宇(镇考第一名)、陈培腾荣获揭东区数学竞赛一等奖";
        System.out.println(a.length());
    }

}
