package com.zyxy.common.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 和解回应
 */
@ApiModel("和解回应")
public class CompromiseResponseDTO {
	
	/**
	 * 和解申请ID
	 */
	@ApiModelProperty("和解申请ID")
	@NotNull(message="和解申请ID不为空")
	private String id;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 回应方
	 */
	@ApiModelProperty("回应方0申请方 1被申请方 2仲裁员或仲裁秘书")
	@NotNull(message="回应方不为空")
	@Pattern(regexp=RegexpConstant.COMPROMISE_RESPONSE_TYPE,message="回应方报错")
	private String responseType;
	
	/**
	 * 回应状态
	 */
	@ApiModelProperty("回应状态0 同意 1拒绝")
	@NotNull(message="回应状态不为空")
	@Pattern(regexp=RegexpConstant.COMPROMISE_RESPONSE_STATUS,message="回应状态报错")
	private String status;
	
	/**
	 * 回应方式
	 */
	@ApiModelProperty("回应方式0直接回应 1中途拒绝")
	@NotNull(message="回应状态不为空")
	@Pattern(regexp=RegexpConstant.COMPROMISE_RESPONSE_STYLE,message="回应方式报错")
	private String responseStyle;
	
	/**
	 * 和解开始时间
	 */
	@ApiModelProperty("和解开始时间,仲裁员或仲裁委必填")
	private Date startTime;
	
	/**
	 * 当前用户ID
	 */
	@ApiModelProperty("当前用户ID")
	@NotNull(message="当前用户ID不为空")
	private String userId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	 * @return the responseStyle
	 */
	public String getResponseStyle() {
		return responseStyle;
	}

	/**
	 * @param responseStyle the responseStyle to set
	 */
	public void setResponseStyle(String responseStyle) {
		this.responseStyle = responseStyle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompromiseResponseDTO [id=" + id + ", caseId=" + caseId
				+ ", responseType=" + responseType + ", status=" + status
				+ ", responseStyle=" + responseStyle + ", startTime="
				+ startTime + ", userId=" + userId + "]";
	}
	
}
