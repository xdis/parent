package com.zyxy.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_change_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseChangeRecord")
public class CaseChangeRecord implements Serializable {
    /**
     * 
     *   主键id
     * case_change_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 
     *   案件ID
     * case_change_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     * 
     *   事实与理由
     * case_change_record.FACT_REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "事实与理由")
    private String factReason;

    /**
     * 
     *   变更人ID
     * case_change_record.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更人ID")
    private String userId;

    /**
     * 
     *   请求ID
     * case_change_record.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求ID")
    private String requestId;

    /**
     * 
     *   请求标志 0-正请求 1-反请求
     * case_change_record.COUNTERCLAIM_FLAG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求标志 0-正请求 1-反请求")
    private String counterclaimFlag;

    /**
     * 
     *   状态 0 待审核 1 通过 2 未通过
     * case_change_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 0 待审核 1 通过 2 未通过")
    private String status;

    /**
     * 
     *   创建人
     * case_change_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     * 
     *   创建时间
     * case_change_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    
    
    /**
     * 标的金额
     */
    private BigDecimal markAmount;
    
    /**
     * 应补缴费用
     */
    private BigDecimal paymentShouldBe;
    
    /**
     * 应退费
     */
    private BigDecimal shouldBeRefund;
    
    /**
     * 受理费
     */
    private BigDecimal caseAdmissibleAmount;
    
    /**
     * 处理费
     */
    private BigDecimal caseHandlingAmount;
    
    

    /**
     * 支付id
     */
    private String payId;

    /**
     * 缴费截止时间
     */
    private Date payEndTime;
    
    /**
     * case_change_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     * 
     * @return 主键id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 主键id
     * 
     * @param id 主键id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件ID
     * 
     * @return 案件ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件ID
     * 
     * @param caseId 案件ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 事实与理由
     * 
     * @return 事实与理由
     *
     * @mbggenerated
     */
    public String getFactReason() {
        return factReason;
    }

    /**
     * 事实与理由
     * 
     * @param factReason 事实与理由
     *
     * @mbggenerated
     */
    public void setFactReason(String factReason) {
        this.factReason = factReason == null ? null : factReason.trim();
    }

    /**
     * 变更人ID
     * 
     * @return 变更人ID
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 变更人ID
     * 
     * @param userId 变更人ID
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 请求ID
     * 
     * @return 请求ID
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求ID
     * 
     * @param requestId 请求ID
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 请求标志 0-正请求 1-反请求
     * 
     * @return 请求标志 0-正请求 1-反请求
     *
     * @mbggenerated
     */
    public String getCounterclaimFlag() {
        return counterclaimFlag;
    }

    /**
     * 请求标志 0-正请求 1-反请求
     * 
     * @param counterclaimFlag 请求标志 0-正请求 1-反请求
     *
     * @mbggenerated
     */
    public void setCounterclaimFlag(String counterclaimFlag) {
        this.counterclaimFlag = counterclaimFlag == null ? null : counterclaimFlag.trim();
    }

    /**
     * 状态 0 待审核 1 通过 2 未通过
     * 
     * @return 状态 0 待审核 1 通过 2 未通过
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 0 待审核 1 通过 2 未通过
     * 
     * @param status 状态 0 待审核 1 通过 2 未通过
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建人
     * 
     * @return 创建人
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人
     * 
     * @param createrId 创建人
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public BigDecimal getMarkAmount() {
		return markAmount;
	}

	public void setMarkAmount(BigDecimal markAmount) {
		this.markAmount = markAmount;
	}

	public BigDecimal getPaymentShouldBe() {
		return paymentShouldBe;
	}

	public void setPaymentShouldBe(BigDecimal paymentShouldBe) {
		this.paymentShouldBe = paymentShouldBe;
	}

	public BigDecimal getShouldBeRefund() {
		return shouldBeRefund;
	}

	public void setShouldBeRefund(BigDecimal shouldBeRefund) {
		this.shouldBeRefund = shouldBeRefund;
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

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

    public Date getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }
}