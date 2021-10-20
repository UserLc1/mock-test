package com.example.commons.test.protocol.request;


import com.example.commons.test.protocol.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.commons.test.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @Author: Lc
 * @Date: 2020-09-08
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {
    private String message;

    private String toUserId;

    public MessageRequestPacket(String message, String toUserId) {
        this.message = message;
        this.toUserId = toUserId;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
