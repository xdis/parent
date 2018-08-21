package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文书头内容
 */
@ApiModel("文书头")
public class DocHeadVO {
	
	 /**
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    private String applicantName;

    /**
     * 申请人类型
     */
    @ApiModelProperty("申请人类型。0- 自然人，1- 法定代表人")
    private String applicantType;

    /**
     * 申请人性别
     */
    @ApiModelProperty("申请人性别")
    private String applicantSex;
    
    /**
     * 申请人民族
     */
    @ApiModelProperty("申请人民族")
    private String applicantEthnic;

    /**
     * 申请人出生
     */
    @ApiModelProperty("申请人出生")
    private String applicantBirthday;

    /**
     * 申请人身份证号
     */
    @ApiModelProperty("申请人身份证号")
    private String applicantCardId;

    /**
     * 申请人住所
     */
    @ApiModelProperty("申请人住所")
    private String applicantAddress;
    
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

    /**
     * 申请人统一社会信用代码
     */
    @ApiModelProperty("申请人统一社会信用代码")
    private String applicantUnifiedSocialCode;

    /**
     * 申请人联系电话
     */
    @ApiModelProperty("申请人联系电话")
    private String applicantPhone;

    /**
     * 申请人邮箱
     */
    @ApiModelProperty("申请人邮箱")
    private String applicantEmail;

    /**
     * 申请方代理人
     */
    @ApiModelProperty("申请方代理人")
    private String applicantAttorney;

    /**
     * 申请方代理人职业
     */
    @ApiModelProperty("申请方代理人职业")
    private String applicantAttorneyJob;

    /**
     * 被申请人
     */
    @ApiModelProperty("被申请人")
    private String beApplicantName;

    /**
     * 被申请人性别
     */
    @ApiModelProperty("被申请人性别")
    private String beApplicantSex;
    
    /**
     * 被申请人民族
     */
    @ApiModelProperty("被申请人民族")
    private String beApplicantEthnic;

    /**
     * 被申请人类型
     */
    @ApiModelProperty("被申请人类型")
    private String beApplicantType;

    /**
     * 被申请人出生
     */
    @ApiModelProperty("被申请人出生")
    private String beApplicantBirthday;

    /**
     * 被申请人住所
     */
    @ApiModelProperty("被申请人住所")
    private String beApplicantAddress;

    /**
     * 被申请人身份证号
     */
    @ApiModelProperty("被申请人身份证号")
    private String beApplicantCardId;

    /**
     * 被申请人法定代表人姓名
     */
    @ApiModelProperty("被申请人法定代表人姓名")
    private String beApplicantCertName;

    /**
     * 被申请人法定代表人职务
     */
    @ApiModelProperty("被申请人法定代表人职务")
    private String beApplicantCertDuties;

    /**
     * 被申请人统一社会信用代码
     */
    @ApiModelProperty("被申请人统一社会信用代码")
    private String beApplicantUnifiedSocialCode;

    /**
     * 被申请人联系电话
     */
    @ApiModelProperty("被申请人联系电话")
    private String beApplicantPhone;

    /**
     * 被申请人邮箱
     */
    @ApiModelProperty("被申请人邮箱")
    private String beApplicantEmail;

    /**
     * 被申请方代理人
     */
    @ApiModelProperty("被申请方代理人")
    private String beApplicantAttorney;

    /**
     * 被申请方代理人职业
     */
    @ApiModelProperty("被申请方代理人职业")
    private String beApplicantAttorneyJob;

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

	public String getApplicantSex() {
		return applicantSex;
	}

	public void setApplicantSex(String applicantSex) {
		this.applicantSex = applicantSex;
	}

	public String getApplicantEthnic() {
		return applicantEthnic;
	}

	public void setApplicantEthnic(String applicantEthnic) {
		this.applicantEthnic = applicantEthnic;
	}

	public String getApplicantBirthday() {
		return applicantBirthday;
	}

	public void setApplicantBirthday(String applicantBirthday) {
		this.applicantBirthday = applicantBirthday;
	}

	public String getApplicantCardId() {
		return applicantCardId;
	}

	public void setApplicantCardId(String applicantCardId) {
		this.applicantCardId = applicantCardId;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
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

	public String getApplicantUnifiedSocialCode() {
		return applicantUnifiedSocialCode;
	}

	public void setApplicantUnifiedSocialCode(String applicantUnifiedSocialCode) {
		this.applicantUnifiedSocialCode = applicantUnifiedSocialCode;
	}

	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public String getApplicantAttorney() {
		return applicantAttorney;
	}

	public void setApplicantAttorney(String applicantAttorney) {
		this.applicantAttorney = applicantAttorney;
	}

	public String getApplicantAttorneyJob() {
		return applicantAttorneyJob;
	}

	public void setApplicantAttorneyJob(String applicantAttorneyJob) {
		this.applicantAttorneyJob = applicantAttorneyJob;
	}

	public String getBeApplicantName() {
		return beApplicantName;
	}

	public void setBeApplicantName(String beApplicantName) {
		this.beApplicantName = beApplicantName;
	}

	public String getBeApplicantSex() {
		return beApplicantSex;
	}

	public void setBeApplicantSex(String beApplicantSex) {
		this.beApplicantSex = beApplicantSex;
	}

	public String getBeApplicantEthnic() {
		return beApplicantEthnic;
	}

	public void setBeApplicantEthnic(String beApplicantEthnic) {
		this.beApplicantEthnic = beApplicantEthnic;
	}

	public String getBeApplicantType() {
		return beApplicantType;
	}

	public void setBeApplicantType(String beApplicantType) {
		this.beApplicantType = beApplicantType;
	}

	public String getBeApplicantBirthday() {
		return beApplicantBirthday;
	}

	public void setBeApplicantBirthday(String beApplicantBirthday) {
		this.beApplicantBirthday = beApplicantBirthday;
	}

	public String getBeApplicantAddress() {
		return beApplicantAddress;
	}

	public void setBeApplicantAddress(String beApplicantAddress) {
		this.beApplicantAddress = beApplicantAddress;
	}

	public String getBeApplicantCardId() {
		return beApplicantCardId;
	}

	public void setBeApplicantCardId(String beApplicantCardId) {
		this.beApplicantCardId = beApplicantCardId;
	}

	public String getBeApplicantCertName() {
		return beApplicantCertName;
	}

	public void setBeApplicantCertName(String beApplicantCertName) {
		this.beApplicantCertName = beApplicantCertName;
	}

	public String getBeApplicantCertDuties() {
		return beApplicantCertDuties;
	}

	public void setBeApplicantCertDuties(String beApplicantCertDuties) {
		this.beApplicantCertDuties = beApplicantCertDuties;
	}

	public String getBeApplicantUnifiedSocialCode() {
		return beApplicantUnifiedSocialCode;
	}

	public void setBeApplicantUnifiedSocialCode(String beApplicantUnifiedSocialCode) {
		this.beApplicantUnifiedSocialCode = beApplicantUnifiedSocialCode;
	}

	public String getBeApplicantPhone() {
		return beApplicantPhone;
	}

	public void setBeApplicantPhone(String beApplicantPhone) {
		this.beApplicantPhone = beApplicantPhone;
	}

	public String getBeApplicantEmail() {
		return beApplicantEmail;
	}

	public void setBeApplicantEmail(String beApplicantEmail) {
		this.beApplicantEmail = beApplicantEmail;
	}

	public String getBeApplicantAttorney() {
		return beApplicantAttorney;
	}

	public void setBeApplicantAttorney(String beApplicantAttorney) {
		this.beApplicantAttorney = beApplicantAttorney;
	}

	public String getBeApplicantAttorneyJob() {
		return beApplicantAttorneyJob;
	}

	public void setBeApplicantAttorneyJob(String beApplicantAttorneyJob) {
		this.beApplicantAttorneyJob = beApplicantAttorneyJob;
	}

	@Override
	public String toString() {
		return "DocHeadVO [applicantName=" + applicantName + ", applicantType="
				+ applicantType + ", applicantSex=" + applicantSex
				+ ", applicantEthnic=" + applicantEthnic
				+ ", applicantBirthday=" + applicantBirthday
				+ ", applicantCardId=" + applicantCardId
				+ ", applicantAddress=" + applicantAddress
				+ ", applicantCertName=" + applicantCertName
				+ ", applicantCertDuties=" + applicantCertDuties
				+ ", applicantUnifiedSocialCode=" + applicantUnifiedSocialCode
				+ ", applicantPhone=" + applicantPhone + ", applicantEmail="
				+ applicantEmail + ", applicantAttorney=" + applicantAttorney
				+ ", applicantAttorneyJob=" + applicantAttorneyJob
				+ ", beApplicantName=" + beApplicantName + ", beApplicantSex="
				+ beApplicantSex + ", beApplicantEthnic=" + beApplicantEthnic
				+ ", beApplicantType=" + beApplicantType
				+ ", beApplicantBirthday=" + beApplicantBirthday
				+ ", beApplicantAddress=" + beApplicantAddress
				+ ", beApplicantCardId=" + beApplicantCardId
				+ ", beApplicantCertName=" + beApplicantCertName
				+ ", beApplicantCertDuties=" + beApplicantCertDuties
				+ ", beApplicantUnifiedSocialCode="
				+ beApplicantUnifiedSocialCode + ", beApplicantPhone="
				+ beApplicantPhone + ", beApplicantEmail=" + beApplicantEmail
				+ ", beApplicantAttorney=" + beApplicantAttorney
				+ ", beApplicantAttorneyJob=" + beApplicantAttorneyJob + "]";
	}
}
