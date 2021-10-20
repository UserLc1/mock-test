package com.example.commons.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: Lc
 * @Date: 2020-07-13
 */
public class NettyClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建客户端启动对象
            //注意客户端使用不是ServerBootstrap而是Bootstrap
            Bootstrap b = new Bootstrap();
            //设置相关参数
            b.group(workerGroup); //设置线程组
            b.channel(NioSocketChannel.class); // 设置客户端通道的实现类(反射)
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyClientHandler());  //加入自己的处理器。解码器
                }
            });

            System.out.println("客户端 ok....");
            // 启动客户端去连接服务器端
            //关于ChannelFuture 要分析,涉及到netty的异步模型
            ChannelFuture f = b.connect("localhost", 6668).sync();

            // 给关闭通道监听
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
