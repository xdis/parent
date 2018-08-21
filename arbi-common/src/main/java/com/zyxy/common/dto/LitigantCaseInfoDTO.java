package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 当事人案件信息
 *
 */
@ApiModel("当事人-案件信息")
public class LitigantCaseInfoDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 当事人类型
	 */
	@ApiModelProperty("当事人类型")
	@NotNull(message="当事人类型不为空")
	@Pattern(regexp=RegexpConstant.PARTY_CURRENT_ROLE_REGEX,message="当事人类型出错")
	private String litigantType;
	
	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getLitigantType() {
		return litigantType;
	}

	public void setLitigantType(String litigantType) {
		this.litigantType = litigantType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LitigantCaseInfoDTO [caseId=" + caseId + ", litigantType="
				+ litigantType + ", userId=" + userId + "]";
	}
	
}
