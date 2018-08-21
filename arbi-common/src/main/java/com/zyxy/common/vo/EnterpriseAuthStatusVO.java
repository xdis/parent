package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 企业认证状态VO
 */
@ApiModel("企业认证状态VO")
public class EnterpriseAuthStatusVO {

    /**
     * 状态。0- 未提交，1- 审核中，2- 审核通过，3- 审核不通过
     */
    @ApiModelProperty("状态。0- 未提交，1- 审核中，2- 审核通过，3- 审核不通过")
    private String status;

    /**
     * 转账账户
     */
    @ApiModelProperty("转账账户")
    private String account;

    /**
     * 转账金额
     */
    @ApiModelProperty("转账金额")
    private BigDecimal amount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
