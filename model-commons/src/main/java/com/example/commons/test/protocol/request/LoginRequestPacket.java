package com.example.commons.test.protocol.request;


import com.example.commons.test.protocol.Packet;
import lombok.Data;

import static com.example.commons.test.protocol.command.Command.LOGIN_REQUEST;

/**
 * @Author: Lc
 * @Date: 2020-09-07
 */
@Data
public class LoginRequestPacket extends Packet {
    private String  userId;

    private String userName;

    private String passWord;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
