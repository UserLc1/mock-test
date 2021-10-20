package com.example.commons.test.server.websocket.global;

import io.netty.channel.group.ChannelGroup;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChatGroup {
    public  static ConcurrentMap<String, ChannelGroup> chatGroupMap=new ConcurrentHashMap<>();
}
