package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 补正记录申请DTO
 */
@ApiModel(value="补正记录申请DTO")
public class AdjudiAmendRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	@NotNull(message="请求事项不为空")
	private String application;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	@NotNull(message="事实与理由不为空")
	private String factReason;

	/**
	 * 当前用户user_id
	 */
	@ApiModelProperty("当前用户user_id")
	@NotNull(message="当前用户user_id不为空")
	private String userId;

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
	}

	/**
	 * @return the factReason
	 */
	public String getFactReason() {
		return factReason;
	}

	/**
	 * @param factReason the factReason to set
	 */
	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdjudiAmendRecordInsertDTO [caseId=" + caseId
				+ ", application=" + application + ", factReason=" + factReason
				+ ", userId=" + userId + "]";
	}
	
}
