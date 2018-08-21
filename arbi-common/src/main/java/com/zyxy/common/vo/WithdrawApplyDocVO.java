package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 撤案申请书
 */
@ApiModel("撤案申请书VO")
public class WithdrawApplyDocVO {
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 理由
	 */
	@ApiModelProperty("理由")
	private String factAndReason;
	
	/**
	 * 申请人
	 */
	@ApiModelProperty("申请人")
	private String applicantName;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private String applyTime;

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getFactAndReason() {
		return factAndReason;
	}

	public void setFactAndReason(String factAndReason) {
		this.factAndReason = factAndReason;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "WithdrawApplyDocVO [caseType=" + caseType + ", factAndReason="
				+ factAndReason + ", applicantName=" + applicantName
				+ ", applyTime=" + applyTime + "]";
	}
	
}
