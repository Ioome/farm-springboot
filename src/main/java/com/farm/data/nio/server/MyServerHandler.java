package com.farm.data.nio.server;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name: MyServerHandler
 * @author: sutton
 * @date: 2023-04-23 20:49
 * @description: 处理器
 * @version: 1.0
 */

public class MyServerHandler extends ChannelInboundHandlerAdapter  {

    private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);

    @Override
    public void channelActive (ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        logger.debug("链接报告开始");
        logger.debug("链接报告信息：有一客户端链接到本服务端");
        logger.debug("链接报告IP:{}", channel.localAddress().getHostString());
        logger.debug("链接报告Port:{}", channel.localAddress().getPort());
        logger.debug("链接报告完毕");
        //通知客户端链接建立成功
        String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.debug("客户端断开链接{}", ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
        logger.debug(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 服务端接收到消息：" + msg);
        //通知客户端链消息发送成功
        String str = "服务端收到：" + new Date() + " " + msg + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        logger.debug("异常信息：\r\n" + cause.getMessage());
    }


}
