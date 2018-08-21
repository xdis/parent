package com.zyxy.service.micro.gate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class GateApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(GateApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);
        logger.info("【项目gate启动成功......】");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GateApplication.class);
    }
}
