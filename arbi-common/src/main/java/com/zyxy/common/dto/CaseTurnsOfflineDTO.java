package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *	案件转线下申请DTO
 */
@ApiModel(value ="案件转线下申请DTO")
public class CaseTurnsOfflineDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件id不能为空")
	private String caseId;
	
	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userId;
	
	/**
	 * 原因
	 */
	@ApiModelProperty("原因")
	@NotNull(message="原因不能为空")
	private String cause;

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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
}
