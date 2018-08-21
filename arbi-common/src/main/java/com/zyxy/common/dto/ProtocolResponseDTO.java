package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 协议书回应DTO
 */
@ApiModel("协议书回应DTO")
public class ProtocolResponseDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull
	private String caseId;
	
	/**
	 * 回应状态
	 */
	@ApiModelProperty("回应状态0同意 1拒绝")
	@NotNull
	@Pattern(regexp=RegexpConstant.COMPROMISE_RESPONSE_STATUS)
	private String status;
	
	/**
	 * 回应方
	 */
	@ApiParam(hidden=true)
	private String responseType;
	
	/**
	 * 用户ID
	 */
	@ApiParam(hidden=true)
	@NotNull
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the responseType
	 */
	public String getResponseType() {
		return responseType;
	}

	/**
	 * @param responseType the responseType to set
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
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
		return "ProtocolResponseDTO [caseId=" + caseId + ", status=" + status
				+ ", responseType=" + responseType + ", userId=" + userId + "]";
	}
	
}
