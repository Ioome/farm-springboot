package com.farm.data.nio.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @name: MyChannelInitializer
 * @author: sutton
 * @date: 2023-04-24 09:48
 * @description: MyChannelInitializer
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final Logger logger = LoggerFactory.getLogger(MyChannelInitializer.class);


    @Override
    protected void initChannel (SocketChannel channel) {

        logger.info("链接报告开始");
        logger.info("链接报告信息：有一客户端链接到本服务端");
        logger.info("链接报告IP: {}",channel.localAddress().getHostString());
        logger.info("链接报告Port: {}",  channel.localAddress().getPort());
        logger.info("链接报告完毕");
        channel.pipeline().addLast(new MyServerHandler());

    }
}
