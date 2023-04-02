package com.farm;

import cn.hutool.core.util.StrUtil;
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
        System.out.println("-----------------------------------");
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        path = StrUtil.isNotEmpty(path) ? path:"";
        log.info("\n----------------------------------------------------------\n\t"
                + "Application Jeecg-Boot is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:" + port + path
                + "/\n\t" + "External: \thttp://" + ip + ":" + port + path + "/\n\t" +"\n"+"--------------------------------------");
        log.info("启动成功 V0.0.1{}", System.currentTimeMillis());
    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(FarmSpringbootApplication.class);
    }
}
