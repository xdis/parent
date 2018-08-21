package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 企业认证DTO
 */
@ApiModel(value = "企业认证DTO")
public class EnterpriseAuthDTO extends BaseDTO {

    /**
     * 单位类型，0- 企业，1- 事业单位
     */
    @ApiModelProperty(value = "单位类型，0- 企业，1- 事业单位")
    @NotNull
    @Pattern(regexp = RegexpConstant.ENT_TYPE_REGEX)
    private String type;

    /**
     * 公司名
     */
    @ApiModelProperty(value = "公司名")
    @NotNull
    private String name;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty(value = "统一社会信用代码")
    @NotNull
    private String unifiedSocialCode;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @NotNull
    @Email
    private String email;

    /**
     * 法人姓名
     */
    @ApiModelProperty(value = "法人姓名")
    @NotNull
    private String certName;

    /**
     * 法人职务
     */
    @ApiModelProperty(value = "法人职务")
    @NotNull
    private String certDuties;

    /**
     * 住所
     */
    @ApiModelProperty(value = "住所")
    @NotNull
    private String address;

    /**
     * 法人身份证正面照
     */
    @ApiModelProperty(value = "法人身份证正面照")
    @NotNull
    private String cardImageFront;

    /**
     * 法人身份证背面照
     */
    @ApiModelProperty(value = "法人身份证背面照")
    @NotNull
    private String cardImageCon;

    /**
     * 彩色三证合一营业执照
     */
    @ApiModelProperty(value = "彩色三证合一营业执照")
    @NotNull
    private String threeInOne;

    /**
     * 平台授权书扫描件
     */
    @ApiModelProperty(value = "平台授权书扫描件")
    @NotNull
    private String platformAuth;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnifiedSocialCode() {
        return unifiedSocialCode;
    }

    public void setUnifiedSocialCode(String unifiedSocialCode) {
        this.unifiedSocialCode = unifiedSocialCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertDuties() {
        return certDuties;
    }

    public void setCertDuties(String certDuties) {
        this.certDuties = certDuties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardImageFront() {
        return cardImageFront;
    }

    public void setCardImageFront(String cardImageFront) {
        this.cardImageFront = cardImageFront;
    }

    public String getCardImageCon() {
        return cardImageCon;
    }

    public void setCardImageCon(String cardImageCon) {
        this.cardImageCon = cardImageCon;
    }

    public String getThreeInOne() {
        return threeInOne;
    }

    public void setThreeInOne(String threeInOne) {
        this.threeInOne = threeInOne;
    }

    public String getPlatformAuth() {
        return platformAuth;
    }

    public void setPlatformAuth(String platformAuth) {
        this.platformAuth = platformAuth;
    }
}