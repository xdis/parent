package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;


public class ReqSmsCodeDTO extends ReqBaseDTO{
    
    @ApiModelProperty("手机号")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.PHONE_REGEX, message="格式非法")
    private String phoneNo;
    
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String[] getSecretKeys() {
        return null;
    }
}
