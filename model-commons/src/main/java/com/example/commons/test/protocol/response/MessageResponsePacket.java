package com.example.commons.test.protocol.response;

import com.example.commons.test.protocol.Packet;
import lombok.Data;

import static com.example.commons.test.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @Author: Lc
 * @Date: 2020-09-08
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
