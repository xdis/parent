package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仲裁委审核意见
 */
@ApiModel(value="仲裁委审核意见")
public class ArbitrationCaseAuditOpinionVO {
	/**
	 * 意见
	 */
	@ApiModelProperty(value="意见")
	private String suggest;
	
	/**
	 * 审核内容
	 */
	@ApiModelProperty(value="审核内容")
	private String content;

	/**
	 * 发表意见时间
	 */
	@ApiModelProperty(value="发表意见时间")
	private Date suggestTime;
	
	/**
	 * 当前身份
	 */
	@ApiModelProperty(value="当前身份")
	private String identify;

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSuggestTime() {
		return suggestTime;
	}

	public void setSuggestTime(Date suggestTime) {
		this.suggestTime = suggestTime;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}
	
}