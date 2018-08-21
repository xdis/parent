package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *	当事人查询问题
 */
@ApiModel("当事人查询问题")
public class LitigantQuizRecordListDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull
	private String caseId;
	
	/**
	 * 申请方标志
	 */
	@ApiModelProperty("申请方标志 0-申请方 1-被申请方")
	@NotNull(message="申请方标志不为空")
	@Pattern(regexp=RegexpConstant.PROPESER_FLAG,message="申请方标志不为空")
	private String litigantType;
	
	/**
	 * 当前用户user_id
	 */
	@ApiModelProperty("当前用户user_id")
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
		return "LitigantQuizRecordQueryDTO [caseId=" + caseId
				+ ", litigantType=" + litigantType + ", userId=" + userId + "]";
	}
	
}
