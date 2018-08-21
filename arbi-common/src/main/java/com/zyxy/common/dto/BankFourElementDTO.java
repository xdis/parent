package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 银行卡四要素认证信息
 * @author tanquan
 *
 */
@ApiModel(value ="银行卡四要素认证信息")
public class BankFourElementDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public BankFourElementDTO(){};
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    @NotNull(message="银行卡号不能为空")
    private String cardNo;
    
    /**
     * 证件类型 00-身份证号
     */
    @ApiModelProperty("证件类型")
    @NotNull(message="证件类型")
    private String certType;
    
    /**
     * 证件号
     */
    @ApiModelProperty("证件号")
    @NotNull(message="证件号")
    private String certNo;
    
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @NotNull(message="姓名")
    private String certName;
    
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull(message="手机号")
    private String phoneNo;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 业务ID，如案件ID/记录ID等（冗余）
     */
    @ApiModelProperty("业务ID，如案件ID/记录ID等（冗余）")
    private String buzzId;
    
    /**
     * 业务备注
     */
    @ApiModelProperty("业务备注")
    private String remark;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuzzId() {
        return buzzId;
    }

    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
