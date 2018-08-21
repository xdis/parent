package com.zyxy.service.micro.api.dto;


public class ResUserAuthStatusDTO {
    /**
     * 认证结果：0-待认证，1-已认证
     */
    private String authFlag;

    /**
     * @return the authFlag
     */
    public String getAuthFlag() {
        return authFlag;
    }

    /**
     * @param authFlag the authFlag to set
     */
    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }
    
    
}
