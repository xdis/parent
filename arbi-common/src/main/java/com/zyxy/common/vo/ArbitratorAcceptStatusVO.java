package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员接案状态
 */
@ApiModel(value="仲裁员接案状态对象")
public class ArbitratorAcceptStatusVO {
	
	/**
	 * 接案状态
	 */
	@ApiModelProperty(value="仲裁员接案状态")
	private String acceptStatus;

	public String getAcceptStatus() {
		return acceptStatus;
	}

	public void setAcceptStatus(String acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
}
