package com.zyxy.service.micro.file.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 * @author tanquan
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * 静态资源位置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
			.addResourceLocations("/static/");
	}

	/**
	 * 视图位置
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	/**
	 * 错误页面
	 * @return
	 */
	@Bean
	public ServerProperties getErrorConfig() {
	    return new ServerConfig();
	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new MyInterceptor());
//	}
//
//	/**
//	 * 过滤器
//	 * @return
//	 */
//	@Bean
//	public FilterRegistrationBean checkUrlFilterRegistration(){
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//	    registration.setFilter(new CheckURLFilter());
//	    String[] interceptController = {"/public/*","/account/*","/role/*","/user/*","/accountCheck/*","/cash/*","/queryrefund/*","/refund/*","/trans/*","/recharge/*"};
//	    registration.addUrlPatterns(interceptController);
//	    registration.setName("checkURLFilter");
//	    return registration;
//	}
}
