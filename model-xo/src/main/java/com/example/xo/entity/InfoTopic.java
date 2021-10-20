package com.example.xo.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Lc
 * @Date: 2021-07-30
 */
public class InfoTopic {
    final int x;
    int y;
    InfoTopic infoTopic;
    private final Lock lock = new ReentrantLock();
    public InfoTopic() {
        x = 1;
        y = 4;
        infoTopic = this;
    }

    public static void main(String[] args) {
//        InfoTopic infoTopic = new InfoTopic();
//        System.out.println(infoTopic.infoTopic.x);
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
    }
}
