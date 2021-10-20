package com.example.commons.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @Author: Lc
 * @Date: 2020-07-04
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;
        //循环的读取
        while (true){
            int byteRead = 0;

            while (byteRead < messageLength){
                long l = socketChannel.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead="+byteRead);
                Arrays.asList(byteBuffers).stream().map(buffer -> "postion=" +
                        buffer.position() +",limit=" + buffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
            long byteWrite = 0;
            while (byteWrite < messageLength){
                long l = socketChannel.write(byteBuffers);
                byteWrite += l;
            }
            //将所有的buffer 进行clear
            Arrays.asList(byteBuffers).forEach(buffer->{
                buffer.clear();
            });

            System.out.println("byteRead="+byteRead+"byteWrite="+byteWrite+",messagelength="+messageLength);
        }
    }
}
