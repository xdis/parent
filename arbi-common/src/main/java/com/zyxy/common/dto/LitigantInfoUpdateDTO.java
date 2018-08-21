package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 当事人信息修改
 */
@ApiModel("当事人信息修改")
public class LitigantInfoUpdateDTO {

	@ApiParam(hidden=true)
	private String userId;
	
	/**
	 * 职业
	 */
	@ApiModelProperty("职业")
	@NotNull(message="职业不为空")
	private String vocation;
	
	/**
	 * 地址
	 */
	@ApiModelProperty("地址")
	@NotNull(message="地址不为空")
	private String address;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "LitigantInfoUpdateDTO [userId=" + userId + ", vocation="
				+ vocation + ", address=" + address + "]";
	}
	
}
