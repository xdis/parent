package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
/**
 * 案件基本信息
 */
public class CaseBaseInfoVO {
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	private String caseNo;
	
	/**
	 * 收案号
	 */
	@ApiModelProperty("收案号")
	private String acceptanceNo;
	
    /**
     * 案由
     */
    @ApiModelProperty("案由")
    private String caseType;

    /**
     * 立案时间
     */
    @ApiModelProperty("立案时间")
    private Date registerTime;
    
    /**
     * 申请时间
     */
    @ApiModelProperty("申请时间")
    private Date applyTime;

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
    private String requestItem;

    /**
     * 事实
     */
    @ApiModelProperty("事实")
    private String factReason;

    @ApiModelProperty("理由")
    private String reason;
    
    /**
     * 附件列表
     */
    @ApiModelProperty("附件列表")
    List<CaseAttachmentVO> attachments;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据列表")
    List<CaseEvidenceVO> caseEvidences;
    
    /**
     * 结尾时间
     */
    @ApiModelProperty("结尾时间")
    private String caseApplyTime;

    
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

    public String getRequestItem() {
        return requestItem;
    }

    public void setRequestItem(String requestItem) {
        this.requestItem = requestItem;
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

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getAcceptanceNo() {
		return acceptanceNo;
	}

	public void setAcceptanceNo(String acceptanceNo) {
		this.acceptanceNo = acceptanceNo;
	}
	
	public List<CaseAttachmentVO> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<CaseAttachmentVO> attachments) {
		this.attachments = attachments;
	}

	public List<CaseEvidenceVO> getCaseEvidences() {
		return caseEvidences;
	}

	public void setCaseEvidences(List<CaseEvidenceVO> caseEvidences) {
		this.caseEvidences = caseEvidences;
	}
    
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getCaseApplyTime() {
		return caseApplyTime;
	}

	public void setCaseApplyTime(String caseApplyTime) {
		this.caseApplyTime = caseApplyTime;
	}
}
