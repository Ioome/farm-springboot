package com.farm.data.nio.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

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
        log.info("链接报告开始");
        log.info("链接报告信息：有一客户端链接到本服务端");
        log.info("链接报告IP:" + socketChannel.localAddress().getHostString());
        log.info("链接报告Port:" + socketChannel.localAddress().getPort());
        log.info("链接报告完毕");

        //在管道中添加我们自己的接收数据实现方法
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
