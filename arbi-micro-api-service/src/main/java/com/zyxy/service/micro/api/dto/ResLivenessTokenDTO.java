package com.zyxy.service.micro.api.dto;

/**
 * 活体认证token及url获取
 * @author sonta
 *
 */
public class ResLivenessTokenDTO {
    /**
     * token
     */
    private String token;
    
    /**
     * 认证访问地址
     */
    private String url;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
