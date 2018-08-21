package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 忘记密码短信发送对象
 */
@ApiModel("忘记密码短信发送对象")
public class LostSmsSendDTO extends BaseDTO {

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull
    @Pattern(regexp = RegexpConstant.PHONE_REGEX)
    private String phone;

    /**
     * 图像验证码
     */
    @ApiModelProperty("图像验证码")
    @NotNull
    private String imgCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }
}
