package com.zyxy.service.micro.file.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;

/**
 * web 服务配置
 * @author zzw
 * @date 2016-07-08
 *
 */
public class  ServerConfig extends ServerProperties{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		super.customize(container);
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404"));
		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500"));
		container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,"/error/403"));
		container.addErrorPages(new ErrorPage("/error/error"));
	}
	
}
