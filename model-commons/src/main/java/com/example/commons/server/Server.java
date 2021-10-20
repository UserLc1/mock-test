package com.example.commons.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @Author: Lc
 * @Date: 2020-03-19
 */
public class Server {
    private int port;
    private ServerSocketChannel serverSocketChannel;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        //1.创建两个线程组bossGroup 和 workerGroup
        //2.bossGroup 只是处理连接请求，真正的和客户端业务处理，会交给workerGroup完成
        //3.两个都是是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //创建服务器端的启动对象,配置参数
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)     //设置两个线程组
                    .channel(NioServerSocketChannel.class) // (3)  使用NioSocketChannel作为服务器的通道实现
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4) 过我们的workerGroup 的 EventLoop 对应的管道设置处理器
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("客户的socketchannel hashcode="+ch.hashCode()); //可以使用一个集合管理 SocketChannel，再推送消息时,可以
                            // 将业务加入到各个 channel 对应的 NIOEventLoop 的 taskQueue 或者 scheduleTaskQueue
                            ch.pipeline().addLast(new ServerHandle());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5) 设置线程队列得到的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6) 设置保持活动连接状态

            System.out.println("...服务端 is ready...");
            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 6668;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new Server(port).run();
    }

    public void sendMessage(Object msg) {
        if (serverSocketChannel != null) {
            serverSocketChannel.writeAndFlush(msg);
        }
    }

}
