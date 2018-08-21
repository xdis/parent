package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;


public class ReqCompanyAccAuthDTO extends ReqBaseDTO{
    
    @ApiModelProperty("用户ID")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_COMMON_REGEX, message="格式非法")
    private String userID;
    
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    @Override
    public String[] getSecretKeys() {
        return null;
    }
}
