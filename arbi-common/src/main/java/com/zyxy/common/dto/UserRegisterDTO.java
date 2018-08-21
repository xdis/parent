package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户注册对象
 */
@ApiModel(value ="用户注册对象")
public class UserRegisterDTO extends BaseDTO{

	/**
     * 用户类型
     */
	@ApiModelProperty("用户类型,0-自然人,1-法人机构")
	@NotNull
	@Pattern(regexp = RegexpConstant.USER_TYPE_REGEX)
    private String type;

	/**
     * 手机号
     */
	@ApiModelProperty("手机号")
	@NotNull
    private String phone;

	/**
     * 手机验证码
     */
	@ApiModelProperty("手机验证码")
	@NotNull
    private String smsVerifyCode;

	/**
     * 密码
     */
	@ApiModelProperty("密码")
	@Length(min = 6, max = 32)
	@NotNull
    private String password;

	/**
     * ip
     */
	@ApiParam(hidden = true)
    private String ip;
	
	/**
	 * 注册来源
	 */
	@ApiParam(hidden = true)
	private String resourceOrgId;

	public String getResourceOrgId() {
        return resourceOrgId;
    }

    public void setResourceOrgId(String resourceOrgId) {
        this.resourceOrgId = resourceOrgId;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSmsVerifyCode() {
		return smsVerifyCode;
	}

	public void setSmsVerifyCode(String smsVerifyCode) {
		this.smsVerifyCode = smsVerifyCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
