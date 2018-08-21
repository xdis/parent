package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;

/**
 * 裁决书补正申请书
 */
@ApiModel("裁决书补正申请书VO")
public class AdjudicationAmendApplyDocVO {
	
	private String caseNo;
	
	private String applicantName;
	
	private String applyTime;
	
	private String amendContent;
	
	private String factReason;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
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

	public String getAmendContent() {
		return amendContent;
	}

	public void setAmendContent(String amendContent) {
		this.amendContent = amendContent;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	@Override
	public String toString() {
		return "AdjudicationAmendApplyDocVO [caseNo=" + caseNo
				+ ", applicantName=" + applicantName + ", applyTime="
				+ applyTime + ", amendContent=" + amendContent
				+ ", factReason=" + factReason + "]";
	}
	
}
