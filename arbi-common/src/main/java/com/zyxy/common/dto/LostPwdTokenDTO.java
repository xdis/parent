package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 得到忘记密码token对象
 */
@ApiModel("得到忘记密码token对象")
public class LostPwdTokenDTO extends BaseDTO {

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull
    @Pattern(regexp = RegexpConstant.PHONE_REGEX)
    private String phone;

    /**
     * 短信验证码
     */
    @ApiModelProperty("短信验证码")
    @NotNull
    private String smsCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
