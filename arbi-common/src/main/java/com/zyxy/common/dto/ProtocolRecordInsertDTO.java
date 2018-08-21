package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 调节协议申请
 */
@ApiModel("调节协议申请DTO")
public class ProtocolRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty(value="案件ID")
	@NotNull(message="案件ID不为空")
	private String CaseId;
	
	/**
	 * 协议内容
	 */
	@ApiModelProperty(value="协议内容")
	@NotNull(message="协议内容不为空")
	private String protocolContent;
	
	/**
	 * 申请类型
	 */
	/*@ApiModelProperty(value="申请类型0申请方 1被申请方")
	@NotNull(message="申请类型不为空")*/
	private String createrType;
	
	/**
	 * 用户userId
	 */
	@ApiModelProperty(value="用户userId")
	@NotNull(message="用户userId不为空")
	private String userId;

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return CaseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		CaseId = caseId;
	}

	/**
	 * @return the protocolContent
	 */
	public String getProtocolContent() {
		return protocolContent;
	}

	/**
	 * @param protocolContent the protocolContent to set
	 */
	public void setProtocolContent(String protocolContent) {
		this.protocolContent = protocolContent;
	}

	/**
	 * @return the createrType
	 */
	public String getCreaterType() {
		return createrType;
	}

	/**
	 * @param createrType the createrType to set
	 */
	public void setCreaterType(String createrType) {
		this.createrType = createrType;
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
		return "ProtocolRecordInsertDTO [CaseId=" + CaseId
				+ ", protocolContent=" + protocolContent + ", createrType="
				+ createrType + ", userId=" + userId + "]";
	}
	
}
