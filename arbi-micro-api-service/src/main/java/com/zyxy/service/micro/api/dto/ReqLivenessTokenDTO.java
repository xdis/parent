package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 活体认证token及url获取
 * @author sonta
 *
 */
public class ReqLivenessTokenDTO extends ReqBaseDTO{
    
    @ApiModelProperty("用户ID")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_COMMON_REGEX, message="格式非法")
    private String userID;
    
    @ApiModelProperty("认证returnUrl")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.HTTP_URL_REGEX, message="格式非法")
    private String returnURL;
    
    
    
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the returnURL
     */
    public String getReturnURL() {
        return returnURL;
    }
    /**
     * @param returnURL the returnURL to set
     */
    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }
    @Override
    public String[] getSecretKeys() {
        return null;
    }
}
