package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 历史裁决补正记录
 */
@ApiModel(value="历史裁决补正记录")
public class HistoryAmendRecordVO {
	/**
	 * 请求类型
	 */
	@ApiModelProperty(value="请求类型")
	private String requestType;
	
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间")
	private Date createTime;
	
	/**
	 * 补正内容
	 */
	@ApiModelProperty(value="补正内容")
	private String content;
	
	/**
	 * 状态
	 */
	@ApiModelProperty(value="状态")
	private String status;
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
