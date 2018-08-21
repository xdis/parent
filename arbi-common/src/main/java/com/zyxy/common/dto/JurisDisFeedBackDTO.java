package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 *	管辖权异议反馈
 */
@ApiModel("管辖权异议反馈DTO")
public class JurisDisFeedBackDTO {
	
	/**
	 * 案件Id
	 */
	@ApiModelProperty(value="案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 用户userId
	 */
	@ApiParam(hidden=true)
	private String userId;
	
	/**
	 * 反馈内容
	 */
	@ApiModelProperty(value="反馈内容")
	private String feedBack;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	@Override
	public String toString() {
		return "JurisDisFeedBackDTO [caseId=" + caseId + ", userId=" + userId
				+ ", feedBack=" + feedBack + "]";
	}
	
}
