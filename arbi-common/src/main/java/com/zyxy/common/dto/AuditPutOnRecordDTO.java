package com.zyxy.common.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 案件审核DTO
 */
@ApiModel(value = "案件审核DTO")
public class AuditPutOnRecordDTO extends BaseDTO {

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
	 * 涉案金额
	 */
	@ApiModelProperty(value = "涉案金额")
	private BigDecimal amounts;

	/**
	 * 仲裁费用
	 */
	@ApiModelProperty(value = "仲裁费用")
	private BigDecimal arbitrationFee;

	/**
	 * 处理费
	 */
	@ApiModelProperty(value = "处理费")
	private BigDecimal handling;

	/**
	 * 当前审批id
	 */
	@NotNull(message = "审批Id不能为空")
	@ApiModelProperty(value = "当前审批id")
	private String approveId;
	
	/**
	 * 案由
	 */
	@ApiModelProperty(value = "案由")
	private String caseTypeId;
	
	/**
	 * 行为费
	 */
	@ApiModelProperty("行为费")
	private BigDecimal behaviorCharges;


	/**
	 * 是否授权
	 */
	@ApiModelProperty("是否授权")
	private String isAuthorized;

	/**
	 * 操作者职务
	 */
	@ApiModelProperty("操作者职务")
	private String duties;
	
	

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

	public BigDecimal getAmounts() {
		return amounts;
	}

	public void setAmounts(BigDecimal amounts) {
		this.amounts = amounts;
	}

	public BigDecimal getArbitrationFee() {
		return arbitrationFee;
	}

	public void setArbitrationFee(BigDecimal arbitrationFee) {
		this.arbitrationFee = arbitrationFee;
	}

	public BigDecimal getHandling() {
		return handling;
	}

	public void setHandling(BigDecimal handling) {
		this.handling = handling;
	}

	public String getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(String caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public BigDecimal getBehaviorCharges() {
		return behaviorCharges;
	}

	public void setBehaviorCharges(BigDecimal behaviorCharges) {
		this.behaviorCharges = behaviorCharges;
	}

	public String getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}
}
