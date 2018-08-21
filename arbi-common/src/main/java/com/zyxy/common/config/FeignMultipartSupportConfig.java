package com.zyxy.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class FeignMultipartSupportConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        // 解决 传输的参数为对象时报错问题
        return new SpringFormEncoder(new FeignSpringFormEncoder());
    }
    
}
