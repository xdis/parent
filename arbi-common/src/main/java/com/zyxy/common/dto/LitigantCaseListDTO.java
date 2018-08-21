package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 当事人案件输入
 */
@ApiModel("案件列表输入")
public class LitigantCaseListDTO extends BasePageDTO{
	
	/**
	 * 当事人当前身份
	 */
	@NotNull
	@Pattern(regexp = RegexpConstant.PARTY_CURRENT_ROLE_REGEX, message = "当事人身份错误")
	@ApiModelProperty("当事人当前身份")
	private String currentRole;
	
	/**
	 * 案件当前状态
	 */
	@ApiModelProperty("案件当前状态")
	private String status;
	
	/**
	 * 筛选条件
	 */
	@ApiModelProperty("筛选条件")
	private String fifterCondition;
	
	public String getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFifterCondition() {
		return fifterCondition;
	}

	public void setFifterCondition(String fifterCondition) {
		this.fifterCondition = fifterCondition;
	}

	@Override
	public String toString() {
		return "LitigantCaseListDTO [currentRole=" + currentRole
				+ ", status=" + status + ", fifterCondition="
				+ fifterCondition + ", userId=" + userId + "]";
	}
	
	
	
}
