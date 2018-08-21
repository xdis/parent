package com.zyxy.common.custom;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

/**
 * tomcat定制器
 */
@Component
public class TomcatContainerCustomizer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.addConnectorCustomizers((connector -> {
            //设置所有请求都解析form-data
            connector.setParseBodyMethods("POST,PUT,DELETE");
            connector.setURIEncoding("UTF-8");
        }));
    }
}