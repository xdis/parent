package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 公共立案DTO
 */
@ApiModel(value ="公共立案DTO")
public class RegisterCaseDTO extends BaseDTO {

    /**
     * 案件Id,立案操作中代表对某个草稿进行提交,存草稿操作中表示对某个草稿进行更新
     */
    @ApiModelProperty("案件Id,立案操作中代表对某个草稿进行提交,存草稿操作中表示对某个草稿进行更新")
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id错误")
    private String caseId;

    /**
     * 立案人类型，0本人立案，1代理立案
     */
    @ApiModelProperty("立案人类型,0- 本人立案，1- 代理立案")
    @ApiParam(required = true)
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_FILING_TYPE_REGEX, message = "立案人类型错误")
    private String filingType;
//
//    /**
//     * 案件类型
//     */
//    @ApiModelProperty("案件类型")
//    @NotNull
//    @Length(min = 0, max = 10)
//    @ApiParam(required = true)
//    private String caseType;

    /**
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    @NotNull
    @Length(max = 64)
    @ApiParam(required = true)
    private String applicantName;

    /**
     * 申请人类型
     * 0- 自然人，1- 法人
     */
    @ApiModelProperty("申请人类型,0- 自然人，1- 法人")
    @NotNull
    @ApiParam(required = true)
    @Pattern(regexp = RegexpConstant.DE_APPLICANT_TYPE_REGEX, message = "申请人类型错误")
    private String applicantType;

    /**
     * 申请人民族,申请人为自然人时必传
     */
    @ApiModelProperty("申请人民族,申请人为自然人时必传")
    private String applicantEthnic;

    /**
     * 申请人性别
     * 格式0-男,1-女
     * 申请人为自然人时必传
     */
    @Length(max = 1)
    @Pattern(regexp = RegexpConstant.SEX_REGEX, message = "性别输入错误")
    @ApiModelProperty("申请人性别,0-男,1-女,申请人为自然人时必传")
    private String applicantSex;

    /**
     * 申请人联系电话
     */
    @ApiModelProperty("申请人联系电话")
    private String applicantPhone;

    /**
     * 申请人身份证号,申请人为自然人时必传
     */
    @ApiModelProperty("申请人身份证号,申请人为自然人时必传")
    private String applicantCardId;

    /**
     * 申请人邮箱
     */
    @Email
    @ApiModelProperty("申请人邮箱")
    private String applicantEmail;

    /**
     * 申请人住所
     */
    @NotNull
    @ApiModelProperty("申请人住所")
    @Length(max = 128)
    @ApiParam(required = true)
    private String applicantAddress;

    /**
     * 申请人出生
     * 格式'yyyyMMdd'
     * 申请人为自然人时必传
     */
    @ApiModelProperty("申请人出生,格式'yyyyMMdd',申请人为自然人时必传")
    private String applicantBirthday;

    /**
     * 申请人统一社会信用代码,申请人为法人时必传
     */
    @ApiModelProperty("申请人统一社会信用代码,申请人为法人时必传")
    private String applicantUnifiedSocialCode;

    /**
     * 申请人法定代表人姓名,申请人为法人时必传
     */
    @ApiModelProperty("申请人法定代表人姓名,申请人为法人时必传")
    private String applicantCertName;

    /**
     * 申请人法定代表人职务,申请人为法人时必传
     */
    @ApiModelProperty("申请人法定代表人职务,申请人为法人时必传")
    private String applicantCertDuties;

    /**
     * 被申请人名称
     */
    @ApiModelProperty("被申请人名称")
    @NotNull
    @Length(max = 64)
    @ApiParam(required = true)
    private String beApplicantName;

    /**
     * 被申请人类型
     * 0- 自然人，1- 法人
     */
    @ApiModelProperty("被申请人类型,0- 自然人，1- 法人")
    @NotNull
    @Pattern(regexp = RegexpConstant.DE_APPLICANT_TYPE_REGEX, message = "被申请人类型错误")
    @ApiParam(required = true)
    private String beApplicantType;

    /**
     * 被申请人民族,申请人为自然人时必传
     */
    @ApiModelProperty("被申请人民族,申请人为自然人时必传")
    private String beApplicantEthnic;

    /**
     * 被申请人性别
     * 格式 0-男,1-女
     * 申请人为自然人时必传
     */
    @Length(max = 1)
    @Pattern(regexp = RegexpConstant.SEX_REGEX, message = "性别输入错误")
    @ApiModelProperty("被申请人性别,0-男,1-女,申请人为自然人时必传")
    private String beApplicantSex;

    /**
     * 被申请人联系电话,申请人为自然人时必传
     */
    @ApiModelProperty("被申请人联系电话,申请人为自然人时必传")
    private String beApplicantPhone;

    /**
     * 被申请人身份证号,申请人为自然人时必传
     */
    @ApiModelProperty("被申请人身份证号,申请人为自然人时必传")
    private String beApplicantCardId;

    /**
     * 被申请人邮箱
     */
    @Email
    @ApiModelProperty("被申请人邮箱")
    private String beApplicantEmail;

    /**
     * 被申请人住所
     */
    @NotNull
    @ApiModelProperty("被申请人住所")
    @Length(max = 128)
    @ApiParam(required = true)
    private String beApplicantAddress;

    /**
     * 被申请人出生,申请人为自然人时必传
     * 格式'yyyyMMdd'
     */
    @ApiModelProperty("被申请人出生,格式'yyyyMMdd',申请人为自然人时必传")
    private String beApplicantBirthday;

    /**
     * 被申请人统一社会信用代码,申请人为法人时必传
     */
    @ApiModelProperty("被申请人统一社会信用代码,申请人为法人时必传")
    private String beApplicantUnifiedSocialCode;

    /**
     * 被申请人法定代表人姓名,申请人为法人时必传
     */
    @ApiModelProperty("被申请人法定代表人姓名,申请人为法人时必传")
    private String beApplicantCertName;

    /**
     * 被申请人法定代表人职务,申请人为法人时必传
     */
    @ApiModelProperty("被申请人法定代表人职务,申请人为法人时必传")
    private String beApplicantCertDuties;

    /**
     * 仲裁请求
     */
    @ApiModelProperty("仲裁请求")
    @NotNull
    @ApiParam(required = true)
    private String arbClaim;

    /**
     * 事实
     */
    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty("事实")
    private String fact;

    /**
     * 理由
     */
//    @NotNull
//    @ApiParam(required = true)
    @ApiModelProperty("理由")
    private String reason;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    private List<CaseEvidenceDTO> caseEvidences;
    
    /**
     * 所函,代理人立案时必传
     */
    @ApiModelProperty("所函,代理人立案时必传")
    private String lawFirm;

    /**
     * 委托代理合同,代理人立案时必传
     */
  /*  @ApiModelProperty("委托代理合同,代理人立案时必传")
    private String agreementOfAgency;*/

    /**
     * 授权委托书,代理人立案时必传
     */
   /* @ApiModelProperty("授权委托书,代理人立案时必传")
    private String powerOfAttorney;*/
    
    @ApiModelProperty("案件来源（与api_orgnazation.id关联），null-本系统")
    private String sourceOrgId;
    
    @ApiModelProperty("仲裁协议签订方式")
    @NotNull(message="仲裁协议签订方式不为空")
    @Pattern(regexp="[01]",message="仲裁协议签订方式出错")
    private String arbiProtocolSignMode;
    
    @ApiModelProperty("签订时间")
    @NotNull(message="签订时间不为空")
    private Date signTime;
    
    @ApiModelProperty("合同名称")
    private String protocolName;
    
    
    /**
     * 律师证
     */
    @ApiModelProperty("律师证fileId")
    private String lawyerCertificate;

    /**
	 * 授权类型1一般代理 2特殊代理
	 */
	@ApiModelProperty("代理类型1一般代理2特殊代理")
	private String  agentType;
    
	/**
	 * 代理人身份类型0律师1公民
	 */
	@ApiModelProperty("代理人身份类型0律师1公民")
	private String agentStyle;
	
	/**
	 * 代理职业(律师所)
	 */
	@ApiModelProperty("代理职业(律师所)")
	private String duties;
    
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 用户id
	 */
	private String userId;
	
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
//
//    public String getCaseType() {
//        return caseType;
//    }
//
//    public void setCaseType(String caseType) {
//        this.caseType = caseType;
//    }

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

    public String getLawFirm() {
        return lawFirm;
    }

    public void setLawFirm(String lawFirm) {
        this.lawFirm = lawFirm;
    }

   /* public String getAgreementOfAgency() {
        return agreementOfAgency;
    }

    public void setAgreementOfAgency(String agreementOfAgency) {
        this.agreementOfAgency = agreementOfAgency;
    }

    public String getPowerOfAttorney() {
        return powerOfAttorney;
    }

    public void setPowerOfAttorney(String powerOfAttorney) {
        this.powerOfAttorney = powerOfAttorney;
    }*/

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<CaseEvidenceDTO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseEvidenceDTO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }

    /**
     * @return the sourceOrgId
     */
    public String getSourceOrgId() {
        return sourceOrgId;
    }

    /**
     * @param sourceOrgId the sourceOrgId to set
     */
    public void setSourceOrgId(String sourceOrgId) {
        this.sourceOrgId = sourceOrgId;
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

	public String getLawyerCertificate() {
		return lawyerCertificate;
	}

	public void setLawyerCertificate(String lawyerCertificate) {
		this.lawyerCertificate = lawyerCertificate;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAgentStyle() {
		return agentStyle;
	}

	public void setAgentStyle(String agentStyle) {
		this.agentStyle = agentStyle;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
    
}
