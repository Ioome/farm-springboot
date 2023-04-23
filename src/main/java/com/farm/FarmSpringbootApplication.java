package com.farm;

import cn.hutool.core.util.StrUtil;
import com.farm.data.nio.server.MyChannelInitializer;
import com.farm.data.nio.server.NettyServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * @author: sutton
 * @date: 2023/4/2
 * @description: SpringbootSchemaApplication
 */
@SpringBootApplication
@EnableSwagger2
@Slf4j
@EnableScheduling
@MapperScan(basePackages = "com.farm.dao")
public class FarmSpringbootApplication extends SpringBootServletInitializer {

    public static void main (String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(FarmSpringbootApplication.class, args);
        log.info("-----------------------------------");
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = StrUtil.isNotEmpty(path) ? path:"";
        log.info("\n----------------------------------------------------------\n\t"
                + "Application Jeecg-Boot is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + path + "/\n\t" +"\n"+"--------------------------------------");
        new FarmSpringbootApplication().bing();
        log.info("启动成功 V0.0.1{}", System.currentTimeMillis());

    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(FarmSpringbootApplication.class);
    }

    private void bing() {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer());
            ChannelFuture f = b.bind(2345).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }

    }
}
