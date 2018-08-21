package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 案件请求基本信息VO
 */
@ApiModel(value ="案件请求基本信息VO")
public class CaseRequestInfoVO {

    /**
     * 请求id
     */
	@ApiModelProperty(value = "请求id")
    private String requestId;
    /**
     * 涉案金额
     */
    @ApiModelProperty(value = "涉案金额")
    private BigDecimal caseAmount;


    /**
     * 受理费
     */
    @ApiModelProperty(value = "受理费")
    private BigDecimal caseAdmissibleAmount;


    /**
     * 处理费
     */
    @ApiModelProperty(value = "处理费")
    private BigDecimal caseHandlingAmount;
    
    /**
     * 行为费
     */
    @ApiModelProperty(value="行为费")
    private BigDecimal behaviorCharges;


    /**
     * 合计金额
     */
    @ApiModelProperty(value="合计金额")
    private BigDecimal totalAmount;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public BigDecimal getCaseAmount() {
        return caseAmount;
    }

    public void setCaseAmount(BigDecimal caseAmount) {
        this.caseAmount = caseAmount;
    }

    public BigDecimal getCaseAdmissibleAmount() {
        return caseAdmissibleAmount;
    }

    public void setCaseAdmissibleAmount(BigDecimal caseAdmissibleAmount) {
        this.caseAdmissibleAmount = caseAdmissibleAmount;
    }

    public BigDecimal getCaseHandlingAmount() {
        return caseHandlingAmount;
    }

    public void setCaseHandlingAmount(BigDecimal caseHandlingAmount) {
        this.caseHandlingAmount = caseHandlingAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

	public BigDecimal getBehaviorCharges() {
		return behaviorCharges;
	}

	public void setBehaviorCharges(BigDecimal behaviorCharges) {
		this.behaviorCharges = behaviorCharges;
	}
    
    
}
