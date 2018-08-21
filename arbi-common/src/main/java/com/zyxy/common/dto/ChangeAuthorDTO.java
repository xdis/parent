package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 更改权限DTO
 */
@ApiModel("更改权限DTO")
public class ChangeAuthorDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 授权类型1一般授权 2 特殊授权
	 */
	@ApiModelProperty("授权类型1一般授权 2 特殊授权")
	@NotNull(message="授权类型1一般授权 2 特殊授权不为空")
	private String agentType;
	
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

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ChangeAuthorDTO [caseId=" + caseId + ", agentType="
				+ agentType + ", userId=" + userId + "]";
	}
}
