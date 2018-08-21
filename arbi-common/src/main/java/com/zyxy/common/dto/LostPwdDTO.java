package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 忘记密码对象
 */
@ApiModel("忘记密码对象")
public class LostPwdDTO extends BaseDTO {

    /**
     * token
     */
    @ApiModelProperty("token")
    @NotNull
    private String token;

    /**
     * 新密码
     */
    @ApiModelProperty("新密码")
    @NotNull
    private String passWord;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
