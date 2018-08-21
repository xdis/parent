package com.zyxy.service.micro.message.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource({"classpath:sms-template.properties"})
@Configuration
@ConfigurationProperties(prefix = "sms")
public class SmsTplConfig {
    private Map<String, String> tpls;
    private String sign;
    private String provider;
    private Boolean debug;
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getProvider() {
        return provider; 
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public Map<String, String> getTpls() {
        return tpls;
    }
    public void setTpls(Map<String, String> tpls) {
        this.tpls = tpls;
    }
    public Boolean getDebug() {
        return debug;
    }
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }
}
