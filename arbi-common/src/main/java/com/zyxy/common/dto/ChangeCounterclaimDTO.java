package com.zyxy.common.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 变更仲裁请求DTO
 */
@ApiModel(value = "变更仲裁请求DTO")
public class ChangeCounterclaimDTO extends BaseDTO{
	
	/**
	 * 案件id
	 */
	@NotNull(message = "案件id不能为空")
	@ApiModelProperty(value = "案件id")
	private String caseId;

	/**
	 * 审批意见
	 */
	@ApiModelProperty(value = "审批意见")
	private String approveSuggest;

	/**
	 * 意见状态
	 */
	@NotNull(message = "意见状态")
	@ApiModelProperty(value = "意见状态")
	private String opinionStatus;

	/**
	 * 标的金额
	 */
	@ApiModelProperty(value = "标的金额")
	private BigDecimal markAmount;

	/**
	 * 受理费
	 */
	@ApiModelProperty(value = "受理费")
	private BigDecimal theFeeFor;
	
	/**
	 * 处理费
	 */
	@ApiModelProperty(value = "处理费")
	private BigDecimal handling;
	
	/**
	 * 应补缴
	 */
	@ApiModelProperty(value = "应补缴")
	private BigDecimal paymentShouldBe;

	/**
	 * 当前审批id
	 */
	@NotNull(message = "审批Id不能为空")
	@ApiModelProperty(value = "当前审批id")
	private String approveId;
	
	/**
	 * 变更仲裁请求Id
	 */
	@ApiModelProperty(value = "变更仲裁请求Id")
	private String changeId;


	/**
	 * 操作者职务
	 */
	private String duties;


	/**
	 * 是否授权
	 */
	private String isAuthorized;

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getApproveSuggest() {
		return approveSuggest;
	}

	public void setApproveSuggest(String approveSuggest) {
		this.approveSuggest = approveSuggest;
	}

	public String getOpinionStatus() {
		return opinionStatus;
	}

	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public BigDecimal getMarkAmount() {
		return markAmount;
	}

	public void setMarkAmount(BigDecimal markAmount) {
		this.markAmount = markAmount;
	}

	public BigDecimal getTheFeeFor() {
		return theFeeFor;
	}

	public void setTheFeeFor(BigDecimal theFeeFor) {
		this.theFeeFor = theFeeFor;
	}

	public BigDecimal getHandling() {
		return handling;
	}

	public void setHandling(BigDecimal handling) {
		this.handling = handling;
	}

	public BigDecimal getPaymentShouldBe() {
		return paymentShouldBe;
	}

	public void setPaymentShouldBe(BigDecimal paymentShouldBe) {
		this.paymentShouldBe = paymentShouldBe;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
}
