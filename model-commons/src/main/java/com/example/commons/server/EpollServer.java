package com.example.commons.server;

import com.example.commons.util.LogUtils;
import org.slf4j.Logger;

/**
 * @Author: Lc
 * @Date: 2020-07-13
 */
public class EpollServer {
    private Logger logger = LogUtils.getExceptionLogger();
//    public static void main(String[] args) throws Exception {
//        logger.info("port:"+System.getProperty("port", "8007"));
//        logger.info("isUseEpoll:"+System.getProperty("isUserEpoll","true"));
//        EventLoopGroup bossGroup;
//        EventLoopGroup workerGroup;
//        Class          clazz;
//
//        if (useEpoll()) {
//            bossGroup = new EpollEventLoopGroup(1);
//            workerGroup = new EpollEventLoopGroup();
//            clazz = EpollServerSocketChannel.class;
//        }else{
//            bossGroup = new NioEventLoopGroup(1);
//            workerGroup = new NioEventLoopGroup();
//            clazz = NioServerSocketChannel.class;
//        }
//
//        final EpollServerHandler epollHandler = new EpollServerHandler();
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            logger.info("[socket Type]: {}", clazz.getSimpleName());
//            b.group(bossGroup, workerGroup)
//                    .channel(clazz)
//                    .option(ChannelOption.SO_BACKLOG, 10001)
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ChannelPipeline p = ch.pipeline();
//                            p.addLast(new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
//                            p.addLast(new SimpleChannelInboundHandler(){
//                                @Override
//                                protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                    ByteBuf content = (ByteBuf) msg;
//                                    ctx.channel().writeAndFlush(content.retain());
//                                }
//                            });
//
//                        }
//                    });
//
//            ChannelFuture f = b.bind(PORT).sync();
//            f.channel().closeFuture().sync();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }


//    private static boolean useEpoll() {
//        if(isUseEpoll){
//            return Epoll.isAvailable();
//        }else{
//            return false;
//        }
//    }
}
