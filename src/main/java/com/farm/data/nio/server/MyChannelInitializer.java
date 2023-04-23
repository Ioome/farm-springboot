package com.farm.data.nio.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @name: MyChannelInitializer
 * @author: sutton
 * @date: 2023-04-23 20:48
 * @description: MyChannelInitializer
 */
@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 初始化
     *
     * @param socketChannel socketChannel
     * @throws Exception 异常
     */
    @Override
    protected void initChannel (SocketChannel socketChannel) throws Exception {
        // 基于换行符号
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
