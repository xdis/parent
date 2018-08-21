package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 用户
 */
@ApiModel(value ="用户修改密码对象")
public class SysUserPwdDTO extends BaseDTO{

	/**
     *原密码
     */
	@ApiModelProperty("原密码")
	@NotNull
    private String userPwd;
    
    /**
     *新密码
     */
	@ApiModelProperty("新密码")
    private String newUserPwd;

	public String getNewUserPwd() {
		return newUserPwd;
	}

	public void setNewUserPwd(String newUserPwd) {
		this.newUserPwd = newUserPwd;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
