package com.example.commons.server;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


/**
 * @Author: Lc
 * @Date: 2020-03-19
 */
public class ServerHandle extends ChannelInboundHandlerAdapter {
    /**
     * 客户端与服务端创建连接的时候调用
     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("客户端与服务端连接开始...");
//        NettyConfig.group.add(ctx.channel());
//    }
//    @Override
//    public void channelActive(final ChannelHandlerContext ctx) { // (1)
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//        System.out.println("客户端与服务端连接开始...");
//        NettyConfig.group.add(ctx.channel());
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//        f.addListener(ChannelFutureListener.CLOSE);
//    }
//    /**
//     * 客户端与服务端断开连接时调用
//     */
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("客户端与服务端连接关闭...");
//        NettyConfig.group.remove(ctx.channel());
//    }





    /**
     * 服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object info) throws Exception {
        //异步执行业务
        //NIOEventLoop 的 taskQueue中

        //解决方案1 用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~2",CharsetUtil.UTF_8));
                }catch (Exception e){
                    System.out.println("发生异常"+e.getMessage());
                }

            }
        });

        //解决方案2 用户自定义定时任务 -》 该任务是提交到 scheduleTaskQueue中


        System.out.println("go on...");
//        System.out.println("接收到了： ctx" + ctx);
//        //将msg转成一个byteBuf
//        //ByteBuf是Netty提供的，不是NIO的ByteBuffer。
//        ByteBuf buf = (ByteBuf) info;
//        System.out.println("客户端发送的消息是:"+buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址:"+ctx.channel().remoteAddress());

        //服务端使用这个就能向 每个连接上来的客户端群发消息
//        NettyConfig.group.writeAndFlush("接收到了");
//        Iterator<Channel> iterator = NettyConfig.group.iterator();
//        while (iterator.hasNext()) {
//            //打印出所有客户端的远程地址
//            System.out.println((iterator.next()).remoteAddress());
//        }
//        channelHandlerContext.writeAndFlush(body); // (1)
    }

    /**
     * 服务端接收客户端发送过来的数据结束之后调用
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~",CharsetUtil.UTF_8));
        System.out.println("信息接收完毕...");
    }

    /**
     * 工程出现异常的时候调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
