package com.zyxy.service.micro.file;


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
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
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
@EnableFeignClients(basePackages = {"com.zyxy"})
@EnableEurekaClient
@EnableHystrixDashboard
public class FileApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(FileApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FileApplication.class, args);
		logger.info("【项目file-service启动成功......】");
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(FileApplication.class);  
    }
}
