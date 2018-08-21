package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 用户认证状态查询
 * @author sonta
 *
 */
public class ReqUserLabourAuthDTO extends ReqBaseDTO{
    
    @ApiModelProperty("用户ID")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_COMMON_REGEX, message="格式非法")
    private String userID;
    
    @ApiModelProperty("手持身份证照片（jpg base64 str）")
    @NotNull(message="不能为空")
    private String idcardInHandImgBase64Str;
    
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
    /**
     * @return the idcardInHandImgBase64Str
     */
    public String getIdcardInHandImgBase64Str() {
        return idcardInHandImgBase64Str;
    }
    /**
     * @param idcardInHandImgBase64Str the idcardInHandImgBase64Str to set
     */
    public void setIdcardInHandImgBase64Str(String idcardInHandImgBase64Str) {
        this.idcardInHandImgBase64Str = idcardInHandImgBase64Str;
    }
}
