package com.zyxy.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动入口 
 * @author tanquan
 */
@SpringBootApplication
@ComponentScan({"com.zyxy"})
@MapperScan({"com.zyxy.common.mapper"})
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zyxy"})
public class AdminApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
		logger.info("【项目zyxy-admin启动成功......】");
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(AdminApplication.class);  
    }
}
