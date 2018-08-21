package com.zyxy.service.micro.gate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;

@Configuration
public class ZuulConfig {
    @Bean
    public ZuulFilter getFilter () {
        return new MyServletDetectionFilter();
    }
}
