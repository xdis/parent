package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel("用户邮箱修改DTO")
public class LitigantEmailUpdateDTO {
	
	@ApiModelProperty("用户密码")
	private String password;
	
	/**
	 * 用户email
	 */
	@ApiModelProperty("用户email")
	@NotNull(message="email不为空")
	@Email(message="邮箱不为空")
	private String email;
	
	@ApiModelProperty("用户ID")
	private String userId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LitigantEmailUpdateDTO [password=" + password + ", email="
				+ email + ", userId=" + userId + "]";
	}
	
	
}
