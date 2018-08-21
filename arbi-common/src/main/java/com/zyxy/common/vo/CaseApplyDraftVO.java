package com.zyxy.common.vo;

import com.zyxy.common.dto.BaseDTO;
import com.zyxy.common.dto.CaseEvidenceDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 立案草稿VO
 */
@ApiModel(value = "立案草稿VO")
public class CaseApplyDraftVO extends BaseDTO {

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    private String caseId;

    /**
     * 立案人类型，0本人立案，1代理立案
     */
    @ApiModelProperty("立案人类型,0- 本人立案，1- 代理立案")
    private String filingType;

    /**
     * 案件类型
     */
    @ApiModelProperty("案件类型")
    private String caseType;

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
     * 申请人民族,申请人为自然人时存在
     */
    @ApiModelProperty("申请人民族,申请人为自然人时存在")
    private String applicantEthnic;

    /**
     * 申请人性别
     * 格式0-男,1-女
     * 申请人为自然人时存在
     */
    @ApiModelProperty("申请人性别,0-男,1-女,申请人为自然人时存在")
    private String applicantSex;

    /**
     * 申请人联系电话
     */
    @ApiModelProperty("申请人联系电话")
    private String applicantPhone;

    /**
     * 申请人身份证号,申请人为自然人时存在
     */
    @ApiModelProperty("申请人身份证号,申请人为自然人时存在")
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
     * 申请人为自然人时存在
     */
    @ApiModelProperty("申请人出生,格式'yyyyMMdd',申请人为自然人时存在")
    private String applicantBirthday;

    /**
     * 申请人统一社会信用代码,申请人为法人时存在
     */
    @ApiModelProperty("申请人统一社会信用代码,申请人为法人时存在")
    private String applicantUnifiedSocialCode;

    /**
     * 申请人法定代表人姓名,申请人为法人时存在
     */
    @ApiModelProperty("申请人法定代表人姓名,申请人为法人时存在")
    private String applicantCertName;

    /**
     * 申请人法定代表人职务,申请人为法人时存在
     */
    @ApiModelProperty("申请人法定代表人职务,申请人为法人时存在")
    private String applicantCertDuties;

    /**
     * 被申请人名称
     */
    @ApiModelProperty("被申请人名称")
    private String beApplicantName;

    /**
     * 被申请人类型
     * 0- 自然人，1- 法人
     */
    @ApiModelProperty("被申请人类型,0- 自然人，1- 法人")
    private String beApplicantType;

    /**
     * 被申请人民族,申请人为自然人时存在
     */
    @ApiModelProperty("被申请人民族,申请人为自然人时存在")
    private String beApplicantEthnic;

    /**
     * 被申请人性别
     * 格式 0-男,1-女
     * 申请人为自然人时存在
     */
    @ApiModelProperty("被申请人性别,0-男,1-女,申请人为自然人时存在")
    private String beApplicantSex;

    /**
     * 被申请人联系电话,申请人为自然人时存在
     */
    @ApiModelProperty("被申请人联系电话,申请人为自然人时存在")
    private String beApplicantPhone;

    /**
     * 被申请人身份证号,申请人为自然人时存在
     */
    @ApiModelProperty("被申请人身份证号,申请人为自然人时存在")
    private String beApplicantCardId;

    /**
     * 被申请人邮箱
     */
    @ApiModelProperty("被申请人邮箱")
    private String beApplicantEmail;

    /**
     * 被申请人住所
     */
    @ApiModelProperty("被申请人住所")
    private String beApplicantAddress;

    /**
     * 被申请人出生,申请人为自然人时存在
     * 格式'yyyyMMdd'
     */
    @ApiModelProperty("被申请人出生,格式'yyyyMMdd',申请人为自然人时存在")
    private String beApplicantBirthday;

    /**
     * 被申请人统一社会信用代码,申请人为法人时存在
     */
    @ApiModelProperty("被申请人统一社会信用代码,申请人为法人时存在")
    private String beApplicantUnifiedSocialCode;

    /**
     * 被申请人法定代表人姓名,申请人为法人时存在
     */
    @ApiModelProperty("被申请人法定代表人姓名,申请人为法人时存在")
    private String beApplicantCertName;

    /**
     * 被申请人法定代表人职务,申请人为法人时存在
     */
    @ApiModelProperty("被申请人法定代表人职务,申请人为法人时存在")
    private String beApplicantCertDuties;

    /**
     * 仲裁请求
     */
    @ApiModelProperty("仲裁请求")
    private String arbClaim;

    /**
     * 事实
     */
    @ApiModelProperty("事实")
    private String fact;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    private List<CaseDraftEvidenceVO> caseEvidences;
    
    /**
     * 协议签订方式
     */
    @ApiModelProperty("协议签订方式")
    private String arbiProtocolSignMode;
    
    /**
     * 签订时间
     */
    @ApiModelProperty("签订时间")
    private Date signTime;
    
    /**
     * 协议内容
     */
    @ApiModelProperty("协议内容")
    private String protocolName;

    /**
     * 所函,委托代理合同,授权委托书
     */
    @ApiModelProperty("所函,委托代理合同,授权委托书")
    private String agentMaterial;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
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

    public String getBeApplicantName() {
        return beApplicantName;
    }

    public void setBeApplicantName(String beApplicantName) {
        this.beApplicantName = beApplicantName;
    }

    public String getBeApplicantType() {
        return beApplicantType;
    }

    public void setBeApplicantType(String beApplicantType) {
        this.beApplicantType = beApplicantType;
    }

    public String getBeApplicantEthnic() {
        return beApplicantEthnic;
    }

    public void setBeApplicantEthnic(String beApplicantEthnic) {
        this.beApplicantEthnic = beApplicantEthnic;
    }

    public String getBeApplicantSex() {
        return beApplicantSex;
    }

    public void setBeApplicantSex(String beApplicantSex) {
        this.beApplicantSex = beApplicantSex;
    }

    public String getBeApplicantPhone() {
        return beApplicantPhone;
    }

    public void setBeApplicantPhone(String beApplicantPhone) {
        this.beApplicantPhone = beApplicantPhone;
    }

    public String getBeApplicantCardId() {
        return beApplicantCardId;
    }

    public void setBeApplicantCardId(String beApplicantCardId) {
        this.beApplicantCardId = beApplicantCardId;
    }

    public String getBeApplicantEmail() {
        return beApplicantEmail;
    }

    public void setBeApplicantEmail(String beApplicantEmail) {
        this.beApplicantEmail = beApplicantEmail;
    }

    public String getBeApplicantAddress() {
        return beApplicantAddress;
    }

    public void setBeApplicantAddress(String beApplicantAddress) {
        this.beApplicantAddress = beApplicantAddress;
    }

    public String getBeApplicantBirthday() {
        return beApplicantBirthday;
    }

    public void setBeApplicantBirthday(String beApplicantBirthday) {
        this.beApplicantBirthday = beApplicantBirthday;
    }

    public String getBeApplicantUnifiedSocialCode() {
        return beApplicantUnifiedSocialCode;
    }

    public void setBeApplicantUnifiedSocialCode(String beApplicantUnifiedSocialCode) {
        this.beApplicantUnifiedSocialCode = beApplicantUnifiedSocialCode;
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

    public String getArbClaim() {
        return arbClaim;
    }

    public void setArbClaim(String arbClaim) {
        this.arbClaim = arbClaim;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public List<CaseDraftEvidenceVO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseDraftEvidenceVO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }

    public String getAgentMaterial() {
        return agentMaterial;
    }

    public void setAgentMaterial(String agentMaterial) {
        this.agentMaterial = agentMaterial;
    }

	public String getArbiProtocolSignMode() {
		return arbiProtocolSignMode;
	}

	public void setArbiProtocolSignMode(String arbiProtocolSignMode) {
		this.arbiProtocolSignMode = arbiProtocolSignMode;
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
