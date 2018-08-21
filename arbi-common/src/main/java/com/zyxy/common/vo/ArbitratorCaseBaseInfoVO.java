package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仲裁员案件基本信息VO
 */
@ApiModel("仲裁员案件基本信息")
public class ArbitratorCaseBaseInfoVO {

    /**
     * 案件id
     */
    @ApiModelProperty("案件id")
    private String caseId;

	/**
     * 收案号
     */
    @ApiModelProperty("收案号")
    private String acceptanceNO;
    
    /**
     * 案号
     */
    @ApiModelProperty("案号")
    private String caseNO;

    /**
     * 案由
     */
    @ApiModelProperty("案由")
    private String caseType;

    /**
     * 案件来源
     */
    @ApiModelProperty("案件来源,0-指派，1-选定")
    private String type;

    /**
     * 立案时间
     */
    @ApiModelProperty("立案时间")
    private Date registerTime;

    /**
     * 涉案金额
     */
    @ApiModelProperty("涉案金额")
    private Double caseAmount;

    /**
     * 右上角状态
     */
    @ApiModelProperty("右上角状态,0- 待受理, 1- 进行中, 2- 已完结")
    private Integer rightStatus;

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
     * 仲裁请求
     */
    @ApiModelProperty("仲裁请求")
    private String arbClaim;

    /**
     * 事实
     */
    @ApiModelProperty(value = "事实")
    private String fact;

    /**
     * 理由
     */
    @ApiModelProperty(value = "理由")
    private String reason;

    /**
     * 受理状态
     */
    @ApiModelProperty(value = "受理状态。0-待受理，1-不受理，2-有效，3-回避")
    private String acceptStatus;
    
    /**
     * 仲裁协议签订方式
     */
    @ApiModelProperty("仲裁协议签订方式0合同约定仲裁条款1单独仲裁协议")
    private String signAbriProtocolMode;
    
    /**
     * 签订协议时间
     */
    @ApiModelProperty("签订协议时间")
    private Date signTime;
    
    /**
     * 协议名称
     */
    @ApiModelProperty("协议名称")
    private String protocolName;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Double getCaseAmount() {
        return caseAmount;
    }

    public void setCaseAmount(Double caseAmount) {
        this.caseAmount = caseAmount;
    }

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

    public String getApplicantBirthday() {
        return applicantBirthday;
    }

    public void setApplicantBirthday(String applicantBirthday) {
        this.applicantBirthday = applicantBirthday;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantCardId() {
        return applicantCardId;
    }

    public void setApplicantCardId(String applicantCardId) {
        this.applicantCardId = applicantCardId;
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

    public String getApplicantEthnic() {
        return applicantEthnic;
    }

    public void setApplicantEthnic(String applicantEthnic) {
        this.applicantEthnic = applicantEthnic;
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

    public String getBeApplicantEthnic() {
        return beApplicantEthnic;
    }

    public void setBeApplicantEthnic(String beApplicantEthnic) {
        this.beApplicantEthnic = beApplicantEthnic;
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

    public String getArbClaim() {
        return arbClaim;
    }

    public void setArbClaim(String arbClaim) {
        this.arbClaim = arbClaim;
    }

    public String getApplicantAttorneyJob() {
        return applicantAttorneyJob;
    }

    public void setApplicantAttorneyJob(String applicantAttorneyJob) {
        this.applicantAttorneyJob = applicantAttorneyJob;
    }

    public String getBeApplicantAttorneyJob() {
        return beApplicantAttorneyJob;
    }

    public void setBeApplicantAttorneyJob(String beApplicantAttorneyJob) {
        this.beApplicantAttorneyJob = beApplicantAttorneyJob;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(String acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public Integer getRightStatus() {
        return rightStatus;
    }

    public void setRightStatus(Integer rightStatus) {
        this.rightStatus = rightStatus;
    }

	public String getAcceptanceNO() {
		return acceptanceNO;
	}

	public void setAcceptanceNO(String acceptanceNO) {
		this.acceptanceNO = acceptanceNO;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getCaseNO() {
		return caseNO;
	}

	public void setCaseNO(String caseNO) {
		this.caseNO = caseNO;
	}

	public String getSignAbriProtocolMode() {
		return signAbriProtocolMode;
	}

	public void setSignAbriProtocolMode(String signAbriProtocolMode) {
		this.signAbriProtocolMode = signAbriProtocolMode;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}
	
	
    
    
}
