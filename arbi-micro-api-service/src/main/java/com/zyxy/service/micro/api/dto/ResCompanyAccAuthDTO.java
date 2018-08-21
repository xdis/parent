package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 企业对公转账认证状态返回
 * @author sonta
 *
 */
public class ResCompanyAccAuthDTO {
    
    @ApiModelProperty("状态：0-未提交，1-待审核（待转账），2-审核通过，3-审核不通过")
    private String status;

    @ApiModelProperty("平台对公账户号")
    private String platAccountNo;
    
    @ApiModelProperty("平台对公账户开户名")
    private String platAccountName;
    
    @ApiModelProperty("平台对公账户开户行")
    private String platAccountBank;
    
    @ApiModelProperty("转账金额")
    private BigDecimal amount;
    
    @ApiModelProperty("转账备注")
    private String remark;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the platAccountNo
     */
    public String getPlatAccountNo() {
        return platAccountNo;
    }

    /**
     * @param platAccountNo the platAccountNo to set
     */
    public void setPlatAccountNo(String platAccountNo) {
        this.platAccountNo = platAccountNo;
    }

    /**
     * @return the platAccountName
     */
    public String getPlatAccountName() {
        return platAccountName;
    }

    /**
     * @param platAccountName the platAccountName to set
     */
    public void setPlatAccountName(String platAccountName) {
        this.platAccountName = platAccountName;
    }

    /**
     * @return the platAccountBank
     */
    public String getPlatAccountBank() {
        return platAccountBank;
    }

    /**
     * @param platAccountBank the platAccountBank to set
     */
    public void setPlatAccountBank(String platAccountBank) {
        this.platAccountBank = platAccountBank;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
    
}
