package com.example.commons.test.client.console;

import java.nio.channels.Channel;
import java.util.Scanner;

/**
 * @Author: Lc
 * @Date: 2020-09-22
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
