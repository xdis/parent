package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel("FaceId活体认证")
public class FaceIdDTO {

    @ApiModelProperty("返回地址")
    @NotNull(message = "返回地址不能为空")
    private String returnUrl;

    @ApiModelProperty("结果通知地址")
    @NotNull(message = "结果通知地址不能为空")
    private String notifyUrl;

    @ApiModelProperty("业务流水号")
    @NotNull(message = "业务流水号不能为空")
    private String bizNo;

    @ApiModelProperty("身份证姓名")
    @NotNull(message = "身份证姓名不能为空")
    private String idCardName;

    @ApiModelProperty("身份证号")
    @NotNull(message = "身份证号不能为空")
    private String idCardNo;


    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getIdCardName() {
        return idCardName;
    }

    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Override
    public String toString() {
        return "FaceIdDTO{" +
                "returnUrl='" + returnUrl + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", bizNo='" + bizNo + '\'' +
                ", idCardName='" + idCardName + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                '}';
    }
}
