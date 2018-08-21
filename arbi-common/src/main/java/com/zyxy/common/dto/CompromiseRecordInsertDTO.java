package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 发送和解沟通记录DTO
 */
@ApiModel("发送和解沟通记录")
public class CompromiseRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 发送方类型
	 */
	/*@ApiModelProperty("发送方类型")
	@NotNull(message="发送方类型不为空")
	@Pattern(regexp=RegexpConstant.COMPROMISE_RECORD_SEND_TYPE,message="消息发送方类型出错")*/
	@ApiParam(hidden=true)
	private String sendType;
	
	/**
	 * 发送内容
	 */
	@ApiModelProperty("发送内容")
	@NotNull(message="发送内容不为空")
	private String content;
	
	/**
	 * 消息类型
	 */
	@ApiModelProperty("消息类型0组庭前 1组庭后")
	@NotNull(message="消息类型不为空")
	@Pattern(regexp=RegexpConstant.COMPROMISE_RECORD_MESSAGE_TYPE,message="消息类型出错")
	private String contentType;
	
	/**
	 * 当前用户USER_ID
	 */
	@ApiModelProperty("当前用户USER_ID")
	private String userId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CompromiseRecordInsertDTO [caseId=" + caseId + ", sendType="
				+ sendType + ", content=" + content + ", contentType="
				+ contentType + ", userId=" + userId + "]";
	}
	
}
