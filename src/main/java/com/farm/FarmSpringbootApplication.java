package com.farm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @author: sutton
 * @date: 2023/4/2
 * @description: SpringbootSchemaApplication
 */
@SpringBootApplication
@MapperScan(basePackages = "com.farm.dao")
public class FarmSpringbootApplication extends SpringBootServletInitializer {

    public static void main (String[] args) {
        SpringApplication.run(FarmSpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(FarmSpringbootApplication.class);
    }
}
