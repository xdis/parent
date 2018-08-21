package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 撤案信息VO
 */
public class WithdrawMessageVO {

	/**
	 * 撤案信息
	 */
	@ApiModelProperty("撤案信息")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WithdrawMessageVO [message=" + message + "]";
	}

}
