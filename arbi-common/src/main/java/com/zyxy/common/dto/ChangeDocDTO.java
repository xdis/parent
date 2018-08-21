package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 变更文书DTO
 */
@ApiModel("变更文书DTO")
public class ChangeDocDTO {
	
	/**
	 *案件ID
	 */
	@ApiModelProperty(value="案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 变更请求ID
	 */
	@ApiModelProperty(value="变更请求ID")
	@NotNull(message="变更请求ID不为空")
	private String changeId;
	
	/**
	 * 用户ID
	 */
	@ApiParam(hidden=true)
	private String userId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ChangeDocDTO [caseId=" + caseId + ", changeId=" + changeId
				+ ", userId=" + userId + "]";
	}
	
	

}
