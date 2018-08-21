package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("和解信息")
public class CompromiseApplyInfoVO {
	
	/**
	 * 回应时间
	 */
	@ApiModelProperty("回应时间")
	private Date responseTime;
	
	/**
	 * 消息
	 */
	@ApiModelProperty("消息")
	private String message;

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CompromiseApplyInfoVO(Date responseTime, String message) {
		this.responseTime = responseTime;
		this.message = message;
	}

	public CompromiseApplyInfoVO() {
	}

	@Override
	public String toString() {
		return "CompromiseApplyInfoVO [responseTime=" + responseTime
				+ ", message=" + message + "]";
	}
	
}
