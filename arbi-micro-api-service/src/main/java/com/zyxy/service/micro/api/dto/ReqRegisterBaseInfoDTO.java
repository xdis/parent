package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.zyxy.common.constants.RegexpConstant;


public class ReqRegisterBaseInfoDTO extends ReqBaseDTO{
    
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotNull(message="不能为空")
    @Size(min=6, max=16, message="应介于6-16位之间")
    private String userName;
    
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotNull(message="不能为空")
    @Size(max=20, message="不能超过20位")
    private String password;
    
    /**
     * 用户类别
     */
    @ApiModelProperty("用户类别：0-申请人，1-被申请人，2-代理人")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.PARTY_CURRENT_ROLE_REGEX, message="")
    private String userType;
    
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.MAIL_REGEX, message="邮箱格式不正确")
    private String email;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String[] getSecretKeys() {
        return new String[]{"userName","password", "email"};
    }
}
