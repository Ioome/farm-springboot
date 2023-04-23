package com.farm.data.nio.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @name: MyServerHandler
 * @author: sutton
 * @date: 2023-04-23 20:49
 * @description: 处理器
 * @version: 1.0
 */
@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 接收msg消息
     *
     * @param param 参数
     * @param msg   消息
     * @throws Exception 异常
     */
    @Override
    public void channelRead (ChannelHandlerContext param, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] msgByte = new byte[buf.readableBytes()];
        buf.readBytes(msgByte);
        log.info("接收到消息：{}", new Date() + new String(msgByte, Charset.forName("GBK")));
    }
}
