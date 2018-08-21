package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;

/**
 * 管辖权异议回应书
 */
@ApiModel("管辖权异议回应书VO")
public class JurisdictionObjectionFeedbackDocVO {
	
	private String feedBack;
	
	private String applicantName;
	
	private Date feedBackTime;

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Date getFeedBackTime() {
		return feedBackTime;
	}

	public void setFeedBackTime(Date feedBackTime) {
		this.feedBackTime = feedBackTime;
	}

	@Override
	public String toString() {
		return "JurisdictionObjectionFeedbackDocVO [feedBack=" + feedBack
				+ ", applicantName=" + applicantName + ", feedBackTime="
				+ feedBackTime + "]";
	}
	
}
