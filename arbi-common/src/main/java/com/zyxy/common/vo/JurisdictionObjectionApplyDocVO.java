package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 管辖权异议申请书VO
 */
@ApiModel("管辖权异议申请书VO")
public class JurisdictionObjectionApplyDocVO {
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 请求
	 */
	@ApiModelProperty("请求")
	private String requset;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	private String reasonFact;
	
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

	public String getRequset() {
		return requset;
	}

	public void setRequset(String requset) {
		this.requset = requset;
	}

	public String getReasonFact() {
		return reasonFact;
	}

	public void setReasonFact(String reasonFact) {
		this.reasonFact = reasonFact;
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
		return "JurisdictionObjectionApplyDocVO [caseType=" + caseType
				+ ", requset=" + requset + ", reasonFact=" + reasonFact
				+ ", applicantName=" + applicantName + ", applyTime="
				+ applyTime + "]";
	}
	
}
