package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 答辩按钮VO
 */
@ApiModel("答辩按钮VO")
public class ReplyButtonVO {
	
	/**
	 * 查看按钮
	 */
	@ApiModelProperty("查看按钮")
	private Boolean checkBtn; 
	
	/**
	 * 回复按钮
	 */
	@ApiModelProperty("回复按钮")
	private Boolean replyBtn; 
	
	/**
	 * 修改按钮
	 */
	@ApiModelProperty("修改按钮")
	private Boolean amendBtn;

	public Boolean getCheckBtn() {
		return checkBtn;
	}

	public void setCheckBtn(Boolean checkBtn) {
		this.checkBtn = checkBtn;
	}

	public Boolean getReplyBtn() {
		return replyBtn;
	}

	public void setReplyBtn(Boolean replyBtn) {
		this.replyBtn = replyBtn;
	}

	public Boolean getAmendBtn() {
		return amendBtn;
	}

	public void setAmendBtn(Boolean amendBtn) {
		this.amendBtn = amendBtn;
	}

	@Override
	public String toString() {
		return "ReplyButtonVO [checkBtn=" + checkBtn + ", replyBtn=" + replyBtn
				+ ", amendBtn=" + amendBtn + "]";
	}
	
}
