package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 辩论记录DTO
 */
@ApiModel("辩论记录DTO")
public class ArgueRecordInsertDTO {
	/**
	 * 案件ID 
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	/**
	 * 内容
	 */
	@ApiModelProperty("内容")
	@NotNull(message="内容不为空")
	private String content;
	/**
	 * 辩论方类型
	 */
	/*@ApiModelProperty("辩论方类型")
	@NotNull(message="辩论方类型不为空")*/
	@ApiParam(hidden=true)
	private String sendType;
	/**
	 * 用户userId
	 */
	/*@ApiModelProperty("用户userId")
	@NotNull(message="用户userId不为空")*/
	@ApiParam(hidden=true)
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the sendType
	 */
	public String getSendType() {
		return sendType;
	}
	/**
	 * @param sendType the sendType to set
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
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
		return "ArgueRecordInsertDTO [caseId=" + caseId + ", content="
				+ content + ", sendType=" + sendType + ", userId=" + userId
				+ "]";
	}
	
}
