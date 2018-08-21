package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.zyxy.common.constants.RegexpConstant;
import com.zyxy.common.util.ArrayUtil;

/**
 * 自然人注册信息
 * @author sonta
 *
 */
public class ReqPersonRegisterDTO extends ReqRegisterBaseInfoDTO{
    
    /** 
     * 手机号
     */
    
    @ApiModelProperty("手机号")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.PHONE_REGEX, message="手机号格式不正确")
    private String phone;
    
    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    @NotNull(message="不能为空")
    @Size(max=20, message="不能超过20位")
    private String realName;
    
    /**
     * 性别
     */
    @ApiModelProperty("性别：0-女，1-男")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.SEX_REGEX, message="格式不正确")
    private String sex;
    
    @ApiModelProperty("民族")
    @NotNull(message="不能为空")
    private String nation;
    
    @ApiModelProperty("注册类型（0-单注册，1-注册并做四要素实名认证）：当类型为1时，需先调用短信发送接口")
    @NotNull(message="不能为为空")
    @Pattern(regexp="[01]", message="格式非法")
    private String registerType;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_CORD_REGEX, message="身份证号码格式不正确")
    private String idcardNo;
    
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.BANK_CARD_REGEX, message="银行卡号格式不正确")
    private String bankcardNo;
    
    @ApiModelProperty("手机号验证码（当注册类型为1时必填）")
    private String smsVerifyCode;
    
    @ApiModelProperty("身份证正面照（base64）")
    @NotNull(message="不能为空")
    private String idcardBase64ImgFront;
    
    @ApiModelProperty("身份证背面照（base64）")
    @NotNull(message="不能为空")
    private String idcardBase64ImgBack;
    
    @ApiModelProperty("职业")
    @NotNull(message="不能为空")
    private String vocation;
    
    @ApiModelProperty("职业")
    @NotNull(message="不能为空")
    private String address;
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo;
    }
    
    public String getIdcardBase64ImgFront() {
        return idcardBase64ImgFront;
    }

    public void setIdcardBase64ImgFront(String idcardBase64ImgFront) {
        this.idcardBase64ImgFront = idcardBase64ImgFront;
    }

    public String getIdcardBase64ImgBack() {
        return idcardBase64ImgBack;
    }

    public void setIdcardBase64ImgBack(String idcardBase64ImgBack) {
        this.idcardBase64ImgBack = idcardBase64ImgBack;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public String getSmsVerifyCode() {
        return smsVerifyCode;
    }

    public void setSmsVerifyCode(String smsVerifyCode) {
        this.smsVerifyCode = smsVerifyCode;
    }
    
    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    
    @Override
    public String[] getSecretKeys() {
        String[] secretKeys = new String[]{"phone","realName","idcardNo","bankcardNo","sex", "idcardBase64ImgFront", "idcardBase64ImgBack"};
        return ArrayUtil.concatAll(secretKeys, super.getSecretKeys());
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
