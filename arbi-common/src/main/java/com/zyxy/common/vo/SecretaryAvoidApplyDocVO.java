package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
 * 秘书回避申请书
 */
@ApiModel("秘书回避申请书")
public class SecretaryAvoidApplyDocVO {
	
	/**
	 * 申请人
	 */
	@ApiModelProperty("申请人")
	private String applicantName;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	private String requestItem;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	private String factReason;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private String applyTime;

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "SecretaryAvoidApplyDocVO [applicantName=" + applicantName
				+ ", requestItem=" + requestItem + ", factReason=" + factReason
				+ ", applyTime=" + applyTime + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
