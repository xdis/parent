package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel("请求列表输出")
public class RequestListVO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty(value="案件ID")
	private String caseId;
	
	/**
	 * 请求ID
	 */
	@ApiModelProperty(value="请求ID")
	private String requestId;
	
	/**
	 * 请求变更记录ID
	 */
	@ApiModelProperty(value="请求变更记录ID")
	private String changeId;
	
	/**
	 * 时间
	 */
	@ApiModelProperty(value="时间")
	private Date createTime;
	
	/**
	 * 状态
	 */
	@ApiModelProperty(value="状态")
	private String status;
	
	/**
	 * 请求类型
	 */
	@ApiModelProperty(value="请求类型")
	private String requestType;
	
	/**
	 * 文书名称
	 */
	@ApiModelProperty(value="")
	private String dcoName;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the dcoName
	 */
	public String getDcoName() {
		return dcoName;
	}

	/**
	 * @param dcoName the dcoName to set
	 */
	public void setDcoName(String dcoName) {
		this.dcoName = dcoName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestListVO [caseId=" + caseId + ", requestId=" + requestId
				+ ", changeId=" + changeId + ", createTime=" + createTime
				+ ", status=" + status + ", requestType=" + requestType
				+ ", dcoName=" + dcoName + "]";
	}
	
}
