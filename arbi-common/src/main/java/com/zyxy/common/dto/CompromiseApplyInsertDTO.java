package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 和解申请DTO
 */
@ApiModel("和解申请")
public class CompromiseApplyInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 申请类型
	 */
	/*@ApiModelProperty("申请类型0-申请人 1-被申请人")
	@NotNull(message="申请类型不为空")
	@Pattern(regexp=RegexpConstant.PROPESER_FLAG,message="申请类型出错")*/
	@ApiParam(hidden=true)
	private String applyType;
	
	/**
	 * 当前用户USERID
	 */
	@ApiModelProperty("当前用户USERID")
	@NotNull(message="当前用户USERID不为空")
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
	 * @return the applyType
	 */
	public String getApplyType() {
		return applyType;
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

	/**
	 * @param applyType the applyType to set
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompromiseApplyInsertDTO [caseId=" + caseId + ", applyType="
				+ applyType + ", userId=" + userId + "]";
	}

	

}
