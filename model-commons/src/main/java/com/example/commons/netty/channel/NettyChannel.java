package com.example.commons.netty.channel;

/**
 * @Author: Lc
 * @Date: 2020-07-09
 */
public class NettyChannel {
//    public void run() {
//        EventLoopGroup bossGroup  = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG,1024)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(65536, 0, 2, 0, 2));
//                            ch.pipeline().addLast("msgpack decoder",new MsgPackDecode());
//                            ch.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
//                            ch.pipeline().addLast("msgpack encoder",new MsgPackEncode());
//                            ch.pipeline().addLast(new ServerHandler());
//                        }
//                    });
//            ChannelFuture f = b.bind(SERVER_PORT).sync();
//            f.channel().closeFuture().sync();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//}
}
