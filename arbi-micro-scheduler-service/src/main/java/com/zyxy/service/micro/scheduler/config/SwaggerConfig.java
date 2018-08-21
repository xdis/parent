package com.zyxy.service.micro.scheduler.config;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				@SuppressWarnings("deprecation")
                Class<?> declaringClass = input.declaringClass();
				if (declaringClass == BasicErrorController.class) { // 排除
					return false;
				}
				if (declaringClass.toString().contains("point")) { // 排除
					return false;
				}
				return true;
			}
		};
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.useDefaultResponseMessages(false).select().apis(predicate)
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("zyxy-swagger-API")// 大标题
				.version("1.0")// 版本
				.build();
	}
}
