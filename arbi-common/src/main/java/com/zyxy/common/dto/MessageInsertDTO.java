package com.zyxy.common.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 *	发布消息 
 *
 */
@ApiModel("发送消息")
public class MessageInsertDTO {
	
	/**
	 * 消息标题
	 */
	@ApiModelProperty("消息标题")
	@NotNull
	private String title;
	
	/**
	 * 消息正文
	 */
	@ApiModelProperty("消息正文")
	@NotNull
	private String messageBody;
	
	/**
	 * 消息接受人ID
	 */
	@ApiModelProperty("消息接受人ID")
	private String userId;
	
	/**
	 * 接收人类型
	 */
	@ApiModelProperty("接收人类型0全部1申请人 2被申请人 31代理人 4仲裁员 ")
	@NotNull
	@Pattern(regexp=RegexpConstant.SYS_MESSAGE_RECEIVE_TYPE, message="接收人类型")
	private String releaseType;
	
	
	/**
	 * 消息创建人
	 */
	@ApiParam(hidden=true)
	private String createrId;
	
	/**
	 * 消息创建时间
	 */
	@ApiParam(hidden=true)
	private Date createTime;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "MessageInsertDTO [title=" + title + ", messageBody="
				+ messageBody + ", userId=" + userId + ", releaseType="
				+ releaseType + ", createrId=" + createrId + ", createTime="
				+ createTime + "]";
	}
}
