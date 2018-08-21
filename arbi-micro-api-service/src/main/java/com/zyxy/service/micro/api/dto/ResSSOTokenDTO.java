package com.zyxy.service.micro.api.dto;


public class ResSSOTokenDTO {
    /**
     * token
     */
    private String token;
    
    /**
     * 过期时间（秒）
     */
    private Long expire;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }
    
}
