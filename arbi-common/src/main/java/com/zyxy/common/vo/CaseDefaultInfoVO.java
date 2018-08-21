package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 本人立案申请缺省信息
 */
@ApiModel(value = "本人立案申请缺省信息")
public class CaseDefaultInfoVO {

    /**
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    private String applicantName;

    /**
     * 申请人类型
     * 0- 自然人，1- 法人
     */
    @ApiModelProperty("申请人类型,0- 自然人，1- 法人")
    private String applicantType;

    /**
     * 申请人民族
     */
    @ApiModelProperty("申请人民族")
    private String applicantEthnic;

    /**
     * 申请人性别
     * 格式0-男,1-女
     */
    @ApiModelProperty("申请人性别,0-男,1-女")
    private String applicantSex;

    /**
     * 申请人联系电话
     */
    @ApiModelProperty("申请人联系电话")
    private String applicantPhone;

    /**
     * 申请人身份证号
     */
    @ApiModelProperty("申请人身份证号")
    private String applicantCardId;

    /**
     * 申请人邮箱
     */
    @ApiModelProperty("申请人邮箱")
    private String applicantEmail;

    /**
     * 申请人住所
     */
    @ApiModelProperty("申请人住所")
    private String applicantAddress;

    /**
     * 申请人出生
     * 格式'yyyyMMdd'
     */
    @ApiModelProperty("申请人出生,格式'yyyyMMdd'")
    private String applicantBirthday;

    /**
     * 申请人统一社会信用代码
     */
    @ApiModelProperty("申请人统一社会信用代码")
    private String applicantUnifiedSocialCode;

    /**
     * 申请人法定代表人姓名
     */
    @ApiModelProperty("申请人法定代表人姓名")
    private String applicantCertName;

    /**
     * 申请人法定代表人职务
     */
    @ApiModelProperty("申请人法定代表人职务")
    private String applicantCertDuties;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getApplicantEthnic() {
        return applicantEthnic;
    }

    public void setApplicantEthnic(String applicantEthnic) {
        this.applicantEthnic = applicantEthnic;
    }

    public String getApplicantSex() {
        return applicantSex;
    }

    public void setApplicantSex(String applicantSex) {
        this.applicantSex = applicantSex;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantCardId() {
        return applicantCardId;
    }

    public void setApplicantCardId(String applicantCardId) {
        this.applicantCardId = applicantCardId;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantBirthday() {
        return applicantBirthday;
    }

    public void setApplicantBirthday(String applicantBirthday) {
        this.applicantBirthday = applicantBirthday;
    }

    public String getApplicantUnifiedSocialCode() {
        return applicantUnifiedSocialCode;
    }

    public void setApplicantUnifiedSocialCode(String applicantUnifiedSocialCode) {
        this.applicantUnifiedSocialCode = applicantUnifiedSocialCode;
    }

    public String getApplicantCertName() {
        return applicantCertName;
    }

    public void setApplicantCertName(String applicantCertName) {
        this.applicantCertName = applicantCertName;
    }

    public String getApplicantCertDuties() {
        return applicantCertDuties;
    }

    public void setApplicantCertDuties(String applicantCertDuties) {
        this.applicantCertDuties = applicantCertDuties;
    }
}
