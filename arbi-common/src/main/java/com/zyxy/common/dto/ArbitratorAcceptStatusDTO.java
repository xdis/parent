package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 仲裁员接案状态
 */
@ApiModel(value="仲裁员接案状态对象")
public class ArbitratorAcceptStatusDTO extends BaseDTO{
	/**
	 * 裁决员id
	 */
	@ApiParam(hidden=true)
	private String arbitratorId;
	
	/**
	 * 接案状态
	 */
	@ApiModelProperty(value="接案状态")
	@Pattern(regexp= RegexpConstant.ARBITRATOR_ACCEPT_STATUS_REGEX, message="接案装态错误")
	@NotNull
	private String acceptStatus;

	public String getAcceptStatus() {
		return acceptStatus;
	}

	public void setAcceptStatus(String acceptStatus) {
		this.acceptStatus = acceptStatus;
	}

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}
	
}
