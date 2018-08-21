package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 消息详情
 *
 */
@ApiModel("消息详情")
public class MessageInfoVO {

	/**
	 * 消息ID
	 */
	@ApiModelProperty("消息ID")
	private int id;
	
	/**
	 * 消息标题
	 */
	@ApiModelProperty("消息标题")
	private String title;

	/**
	 * 关联案件Id
	 */
	@ApiModelProperty("关联案件Id")
	private String caseId;

	/**
	 * 消息正文
	 */
	@ApiModelProperty("消息正文")
	private String messageBody;
	
	/**
	 * 消息创建时间
	 */
	@ApiModelProperty("消息创建时间")
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	@Override
	public String toString() {
		return "MessageInfoVO [id=" + id + ", title=" + title
				+ ", messageBody=" + messageBody + ", createTime=" + createTime
				+ "]";
	}
	
	
}
