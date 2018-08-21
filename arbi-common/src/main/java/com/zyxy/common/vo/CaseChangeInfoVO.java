package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * 变更请求信息
 */
public class CaseChangeInfoVO {
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
     * 申请人出生
     */
    @ApiModelProperty("申请人出生")
    private String applicantBirthday;

    /**
     * 申请人住所
     */
    @ApiModelProperty("申请人住所")
    private String applicantAddress;

    /**
     * 申请人身份证号
     */
    @ApiModelProperty("申请人身份证号")
    private String applicantCardId;

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
     * 申请人民族
     */
    @ApiModelProperty("申请人民族")
    private String applicantEthnic;

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
     * 被申请人民族
     */
    @ApiModelProperty("被申请人民族")
    private String beApplicantEthnic;

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
    
    /**
     * 申请时间
     */
    @ApiModelProperty("变更申请时间")
    private Date applyTime;
    
    /**
     * 请求事项
     */
    @ApiModelProperty("请求事项")
    private String requestItem;
    
    /**
     * 事实与理由
     */
    @ApiModelProperty("事实与理由")
    private String factReason;
    
    /**
     * 状态
     */
    @ApiModelProperty("变更请求状态  0待审核 1通过 2未通过")
    private String status;
    
    /**
     * 是否答辩
     */
    @ApiModelProperty("是否答辩0未答辩1已答辩")
    private String isReply;
    
    /**
     * 请求id
     */
    @ApiModelProperty("请求id")
    private String requestId;
    
    /**
     * 结尾时间
     */
    @ApiModelProperty("结尾时间")
    private String caseApplyTime;

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the applicantType
	 */
	public String getApplicantType() {
		return applicantType;
	}

	/**
	 * @param applicantType the applicantType to set
	 */
	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}

	/**
	 * @return the applicantSex
	 */
	public String getApplicantSex() {
		return applicantSex;
	}

	/**
	 * @param applicantSex the applicantSex to set
	 */
	public void setApplicantSex(String applicantSex) {
		this.applicantSex = applicantSex;
	}

	/**
	 * @return the applicantBirthday
	 */
	public String getApplicantBirthday() {
		return applicantBirthday;
	}

	/**
	 * @param applicantBirthday the applicantBirthday to set
	 */
	public void setApplicantBirthday(String applicantBirthday) {
		this.applicantBirthday = applicantBirthday;
	}

	/**
	 * @return the applicantAddress
	 */
	public String getApplicantAddress() {
		return applicantAddress;
	}

	/**
	 * @param applicantAddress the applicantAddress to set
	 */
	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	/**
	 * @return the applicantCardId
	 */
	public String getApplicantCardId() {
		return applicantCardId;
	}

	/**
	 * @param applicantCardId the applicantCardId to set
	 */
	public void setApplicantCardId(String applicantCardId) {
		this.applicantCardId = applicantCardId;
	}

	/**
	 * @return the applicantCertName
	 */
	public String getApplicantCertName() {
		return applicantCertName;
	}

	/**
	 * @param applicantCertName the applicantCertName to set
	 */
	public void setApplicantCertName(String applicantCertName) {
		this.applicantCertName = applicantCertName;
	}

	/**
	 * @return the applicantCertDuties
	 */
	public String getApplicantCertDuties() {
		return applicantCertDuties;
	}

	/**
	 * @param applicantCertDuties the applicantCertDuties to set
	 */
	public void setApplicantCertDuties(String applicantCertDuties) {
		this.applicantCertDuties = applicantCertDuties;
	}

	/**
	 * @return the applicantUnifiedSocialCode
	 */
	public String getApplicantUnifiedSocialCode() {
		return applicantUnifiedSocialCode;
	}

	/**
	 * @param applicantUnifiedSocialCode the applicantUnifiedSocialCode to set
	 */
	public void setApplicantUnifiedSocialCode(String applicantUnifiedSocialCode) {
		this.applicantUnifiedSocialCode = applicantUnifiedSocialCode;
	}

	/**
	 * @return the applicantEthnic
	 */
	public String getApplicantEthnic() {
		return applicantEthnic;
	}

	/**
	 * @param applicantEthnic the applicantEthnic to set
	 */
	public void setApplicantEthnic(String applicantEthnic) {
		this.applicantEthnic = applicantEthnic;
	}

	/**
	 * @return the applicantPhone
	 */
	public String getApplicantPhone() {
		return applicantPhone;
	}

	/**
	 * @param applicantPhone the applicantPhone to set
	 */
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	/**
	 * @return the applicantEmail
	 */
	public String getApplicantEmail() {
		return applicantEmail;
	}

	/**
	 * @param applicantEmail the applicantEmail to set
	 */
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	/**
	 * @return the applicantAttorney
	 */
	public String getApplicantAttorney() {
		return applicantAttorney;
	}

	/**
	 * @param applicantAttorney the applicantAttorney to set
	 */
	public void setApplicantAttorney(String applicantAttorney) {
		this.applicantAttorney = applicantAttorney;
	}

	/**
	 * @return the applicantAttorneyJob
	 */
	public String getApplicantAttorneyJob() {
		return applicantAttorneyJob;
	}

	/**
	 * @param applicantAttorneyJob the applicantAttorneyJob to set
	 */
	public void setApplicantAttorneyJob(String applicantAttorneyJob) {
		this.applicantAttorneyJob = applicantAttorneyJob;
	}

	/**
	 * @return the beApplicantName
	 */
	public String getBeApplicantName() {
		return beApplicantName;
	}

	/**
	 * @param beApplicantName the beApplicantName to set
	 */
	public void setBeApplicantName(String beApplicantName) {
		this.beApplicantName = beApplicantName;
	}

	/**
	 * @return the beApplicantSex
	 */
	public String getBeApplicantSex() {
		return beApplicantSex;
	}

	/**
	 * @param beApplicantSex the beApplicantSex to set
	 */
	public void setBeApplicantSex(String beApplicantSex) {
		this.beApplicantSex = beApplicantSex;
	}

	/**
	 * @return the beApplicantType
	 */
	public String getBeApplicantType() {
		return beApplicantType;
	}

	/**
	 * @param beApplicantType the beApplicantType to set
	 */
	public void setBeApplicantType(String beApplicantType) {
		this.beApplicantType = beApplicantType;
	}

	/**
	 * @return the beApplicantBirthday
	 */
	public String getBeApplicantBirthday() {
		return beApplicantBirthday;
	}

	/**
	 * @param beApplicantBirthday the beApplicantBirthday to set
	 */
	public void setBeApplicantBirthday(String beApplicantBirthday) {
		this.beApplicantBirthday = beApplicantBirthday;
	}

	/**
	 * @return the beApplicantAddress
	 */
	public String getBeApplicantAddress() {
		return beApplicantAddress;
	}

	/**
	 * @param beApplicantAddress the beApplicantAddress to set
	 */
	public void setBeApplicantAddress(String beApplicantAddress) {
		this.beApplicantAddress = beApplicantAddress;
	}

	/**
	 * @return the beApplicantCardId
	 */
	public String getBeApplicantCardId() {
		return beApplicantCardId;
	}

	/**
	 * @param beApplicantCardId the beApplicantCardId to set
	 */
	public void setBeApplicantCardId(String beApplicantCardId) {
		this.beApplicantCardId = beApplicantCardId;
	}

	/**
	 * @return the beApplicantCertName
	 */
	public String getBeApplicantCertName() {
		return beApplicantCertName;
	}

	/**
	 * @param beApplicantCertName the beApplicantCertName to set
	 */
	public void setBeApplicantCertName(String beApplicantCertName) {
		this.beApplicantCertName = beApplicantCertName;
	}

	/**
	 * @return the beApplicantCertDuties
	 */
	public String getBeApplicantCertDuties() {
		return beApplicantCertDuties;
	}

	/**
	 * @param beApplicantCertDuties the beApplicantCertDuties to set
	 */
	public void setBeApplicantCertDuties(String beApplicantCertDuties) {
		this.beApplicantCertDuties = beApplicantCertDuties;
	}

	/**
	 * @return the beApplicantUnifiedSocialCode
	 */
	public String getBeApplicantUnifiedSocialCode() {
		return beApplicantUnifiedSocialCode;
	}

	/**
	 * @param beApplicantUnifiedSocialCode the beApplicantUnifiedSocialCode to set
	 */
	public void setBeApplicantUnifiedSocialCode(String beApplicantUnifiedSocialCode) {
		this.beApplicantUnifiedSocialCode = beApplicantUnifiedSocialCode;
	}

	/**
	 * @return the beApplicantEthnic
	 */
	public String getBeApplicantEthnic() {
		return beApplicantEthnic;
	}

	/**
	 * @param beApplicantEthnic the beApplicantEthnic to set
	 */
	public void setBeApplicantEthnic(String beApplicantEthnic) {
		this.beApplicantEthnic = beApplicantEthnic;
	}

	/**
	 * @return the beApplicantPhone
	 */
	public String getBeApplicantPhone() {
		return beApplicantPhone;
	}

	/**
	 * @param beApplicantPhone the beApplicantPhone to set
	 */
	public void setBeApplicantPhone(String beApplicantPhone) {
		this.beApplicantPhone = beApplicantPhone;
	}

	/**
	 * @return the beApplicantEmail
	 */
	public String getBeApplicantEmail() {
		return beApplicantEmail;
	}

	/**
	 * @param beApplicantEmail the beApplicantEmail to set
	 */
	public void setBeApplicantEmail(String beApplicantEmail) {
		this.beApplicantEmail = beApplicantEmail;
	}

	/**
	 * @return the beApplicantAttorney
	 */
	public String getBeApplicantAttorney() {
		return beApplicantAttorney;
	}

	/**
	 * @param beApplicantAttorney the beApplicantAttorney to set
	 */
	public void setBeApplicantAttorney(String beApplicantAttorney) {
		this.beApplicantAttorney = beApplicantAttorney;
	}

	/**
	 * @return the beApplicantAttorneyJob
	 */
	public String getBeApplicantAttorneyJob() {
		return beApplicantAttorneyJob;
	}

	/**
	 * @param beApplicantAttorneyJob the beApplicantAttorneyJob to set
	 */
	public void setBeApplicantAttorneyJob(String beApplicantAttorneyJob) {
		this.beApplicantAttorneyJob = beApplicantAttorneyJob;
	}

	/**
	 * @return the applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * @param applyTime the applyTime to set
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @return the changeRequest
	 */
	public String getRequestItem() {
		return requestItem;
	}

	/**
	 * @param changeRequest the changeRequest to set
	 */
	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}

	/**
	 * @return the factReason
	 */
	public String getFactReason() {
		return factReason;
	}

	/**
	 * @param factReason the factReason to set
	 */
	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the isReply
	 */
	public String getIsReply() {
		return isReply;
	}

	/**
	 * @param isReply the isReply to set
	 */
	public void setIsReply(String isReply) {
		this.isReply = isReply;
	}
	
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	public String getCaseApplyTime() {
		return caseApplyTime;
	}

	public void setCaseApplyTime(String caseApplyTime) {
		this.caseApplyTime = caseApplyTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CaseChangeInfoVO [applicantName=" + applicantName
				+ ", applicantType=" + applicantType + ", applicantSex="
				+ applicantSex + ", applicantBirthday=" + applicantBirthday
				+ ", applicantAddress=" + applicantAddress
				+ ", applicantCardId=" + applicantCardId
				+ ", applicantCertName=" + applicantCertName
				+ ", applicantCertDuties=" + applicantCertDuties
				+ ", applicantUnifiedSocialCode=" + applicantUnifiedSocialCode
				+ ", applicantEthnic=" + applicantEthnic + ", applicantPhone="
				+ applicantPhone + ", applicantEmail=" + applicantEmail
				+ ", applicantAttorney=" + applicantAttorney
				+ ", applicantAttorneyJob=" + applicantAttorneyJob
				+ ", beApplicantName=" + beApplicantName + ", beApplicantSex="
				+ beApplicantSex + ", beApplicantType=" + beApplicantType
				+ ", beApplicantBirthday=" + beApplicantBirthday
				+ ", beApplicantAddress=" + beApplicantAddress
				+ ", beApplicantCardId=" + beApplicantCardId
				+ ", beApplicantCertName=" + beApplicantCertName
				+ ", beApplicantCertDuties=" + beApplicantCertDuties
				+ ", beApplicantUnifiedSocialCode="
				+ beApplicantUnifiedSocialCode + ", beApplicantEthnic="
				+ beApplicantEthnic + ", beApplicantPhone=" + beApplicantPhone
				+ ", beApplicantEmail=" + beApplicantEmail
				+ ", beApplicantAttorney=" + beApplicantAttorney
				+ ", beApplicantAttorneyJob=" + beApplicantAttorneyJob
				+ ", applyTime=" + applyTime + ", requestItem="
				+ requestItem + ", factReason=" + factReason + ", status="
				+ status + ", isReply=" + isReply
				+ ", requestId=" + requestId + "]";
	}
	
}
