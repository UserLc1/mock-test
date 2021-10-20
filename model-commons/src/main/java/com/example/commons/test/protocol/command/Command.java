package com.example.commons.test.protocol.command;

/**
 * @Author: Lc
 * @Date: 2020-09-07
 */
public interface Command {
    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte JOIN_GROUP_REQUEST = 11;
}
