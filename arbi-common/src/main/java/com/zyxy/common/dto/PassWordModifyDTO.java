package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 当事人修改密码
 */
@ApiModel("当事人修改密码VO")
public class PassWordModifyDTO {
	
	/**
	 * 新密码
	 */
	@ApiModelProperty("新密码")
	@NotNull(message="新密码不为空")
	private String newPassword;
	
	/**
	 * 旧密码
	 */
	@ApiModelProperty("旧密码")
	@NotNull(message="旧密码不为空")
	private String oldPassword;
	
	@ApiParam(hidden=true)
	private String userId;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PassWordModifyDTO [newPassword=" + newPassword
				+ ", oldPassword=" + oldPassword + ", userId=" + userId + "]";
	}
	
	
	
}
