package com.example.commons.test.protocol.response;

import com.example.commons.test.protocol.Packet;
import lombok.Data;

import static com.example.commons.test.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @Author: Lc
 * @Date: 2020-09-08
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    private String userName;

    private String userId;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
