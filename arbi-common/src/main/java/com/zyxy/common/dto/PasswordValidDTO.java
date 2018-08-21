package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 密码验证DTO
 */
@ApiModel("密码验证dto")
public class PasswordValidDTO {

	@ApiParam(hidden=true)
	private String userId;
	
	@ApiModelProperty("密码")
	@NotNull(message="密码不为空")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PasswordValidDTO [userId=" + userId + ", password=" + password
				+ "]";
	}
	
}
