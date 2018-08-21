package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;


public class ReqSSOTokenDTO extends ReqBaseDTO{
    
    @ApiModelProperty("用户ID")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_COMMON_REGEX, message="格式非法")
    private String userID;
    
    @ApiModelProperty("登录角色：0-申请人，2-代理人")
    @NotNull
    @Pattern(regexp="[02]")
    private String loginRole;
    
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLoginRole() {
        return loginRole;
    }
    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }
    @Override
    public String[] getSecretKeys() {
        return null;
    }
}
