package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 消息列表VO
 *
 */
@ApiModel("消息列表")
public class MessageRecordListVO {
	
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
	 * 消息正文
	 */
	@ApiModelProperty("消息正文")
	private String messageBody;
	
	/**
	 * 消息发布对象
	 */
	@ApiModelProperty("消息发布对象")
	private String releaseType;
	
	/**
	 * 消息创建人
	 */
	@ApiModelProperty("消息创建人")
	private String createrId;
	
	/**
	 * 消息创建时间
	 */
	@ApiModelProperty("消息创建时间")
	private Date createTime;
	
	/**
	 * 收信人ID
	 */
	@ApiModelProperty("收信人ID")
	private String userId;
	
	/**
	 * 消息状态
	 */
	@ApiModelProperty("消息状态")
	private String status;

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

	public String getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * toString 方法
	 */
	@Override
	public String toString() {
		return "MessageRecordListVO [id=" + id + ", title=" + title
				+ ", messageBody=" + messageBody + ", releaseType="
				+ releaseType + ", createrId=" + createrId + ", createTime="
				+ createTime + ", userId=" + userId + ", status=" + status
				+ "]";
	}
	
}
