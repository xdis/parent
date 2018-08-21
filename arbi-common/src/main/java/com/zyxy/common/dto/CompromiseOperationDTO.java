package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 和解按钮相关操作
 */
@ApiModel("和解按钮相关操作")
public class CompromiseOperationDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull
	private String caseId;
	
	/**
	 * 按钮ID
	 */
	@ApiModelProperty("按钮ID")
	@NotNull
	private String menuId;
	
	/**
	 * 用户userId
	 */
	@ApiParam(hidden=true)
	private String userId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CompromiseOperationDTO [caseId=" + caseId + ", menuId="
				+ menuId + ", userId=" + userId + "]";
	}
}
