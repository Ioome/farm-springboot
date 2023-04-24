package com.farm;

import cn.hutool.core.util.StrUtil;
import com.farm.data.nio.server.NettyServer;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


/**
 * @author: sutton
 * @date: 2023/4/2
 * @description: SpringbootSchemaApplication
 */
@SpringBootApplication
@EnableSwagger2
@Slf4j
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.farm.dao")
public class FarmSpringbootApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Value("${netty.host}")
    private String host;
    @Value("${netty.port}")
    private int port;
    @Resource
    private NettyServer nettyServer;

    public static void main (String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(FarmSpringbootApplication.class, args);
        log.info("-----------------------------------");
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = StrUtil.isNotEmpty(path) ? path : "";
        log.info("\n----------------------------------------------------------\n\t"
                + "Application Jeecg-Boot is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + path + "/\n\t" + "\n" + "--------------------------------------");
        log.info("启动成功 V0.0.1{}", System.currentTimeMillis());

    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(FarmSpringbootApplication.class);
    }

    @Override
    public void run (String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(host, port);
        ChannelFuture channelFuture = nettyServer.bing(address);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
//        channelFuture.channel().closeFuture().syncUninterruptibly();
    }
}
