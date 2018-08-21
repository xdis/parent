package com.zyxy.service.micro.api.dto;

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
 * 案件发布（立案）
 */
@ApiModel(value ="案件发布（立案）")
public class ReqCaseRegisterDTO extends ReqBaseDTO {
    
    @ApiModelProperty("案件ID（为空时代表新发布，否则为修改，修改时需重新提交所有内容）")
    @ApiParam(required = true)
    private String caseId;
    
    @ApiModelProperty("代理人用户ID")
    @NotNull(message="不能为空")
    private String agentUserId;

    @ApiModelProperty("代理授权范围：1-一般代理，2-特殊代理")
    @NotNull(message="不能为空")
    @Pattern(regexp="[12]", message="格式不正确")
    private String agentAuthType;
    
    @ApiModelProperty("代理人身份：0-律师，1-公民")
    @NotNull(message="不能为空")
    @Pattern(regexp="[01]", message="格式不正确")
    private String agentIdentityType;
    
    @ApiModelProperty("律师证件照（Base64）")
    private String lawyerCertBase64Img;
    
    /**
     * 案件类型
     *//*
    @ApiModelProperty("案件类型")
    @NotNull
    @Length(min = 0, max = 10)
    @ApiParam(required = true)
    private String caseType;*/

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
    @NotNull
    @Email
    @ApiModelProperty("申请人邮箱")
    @ApiParam(required = true)
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
    @NotNull
    @Email
    @ApiModelProperty("被申请人邮箱")
    @ApiParam(required = true)
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
    @ApiModelProperty("理由")
    private String reason;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    private List<ReqCaseEvidenceDTO> caseEvidences;

    /**
     * 所函,代理人立案时必传
     */
    @ApiModelProperty("所函,代理人立案时必传")
    private String lawFirm;

    /**
     * 委托代理合同,代理人立案时必传
     */
    @ApiModelProperty("委托代理合同,代理人立案时必传")
    private String agreementOfAgency;

    /**
     * 授权委托书,代理人立案时必传
     */
    /*@ApiModelProperty("授权委托书,代理人立案时必传")
    private String powerOfAttorney;*/

   /* public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }*/
    
    @ApiModelProperty("仲裁协议签订方式：0-合同约定仲裁条款，1-单独仲裁协议")
    @NotNull(message="仲裁协议签订方式不为空")
    @Pattern(regexp="[01]",message="仲裁协议签订方式出错")
    private String arbiProtocolSignMode;
    
    @ApiModelProperty("签订时间")
    @NotNull(message="签订时间不为空")
    private Date signTime;
    
    @ApiModelProperty("合同名称")
    private String protocolName;
    
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

    public String getAgreementOfAgency() {
        return agreementOfAgency;
    }

    public void setAgreementOfAgency(String agreementOfAgency) {
        this.agreementOfAgency = agreementOfAgency;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ReqCaseEvidenceDTO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<ReqCaseEvidenceDTO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }

    @Override
    public String[] getSecretKeys() {
        return null;
    }

    /**
     * @return the agentUserId
     */
    public String getAgentUserId() {
        return agentUserId;
    }

    /**
     * @param agentUserId the agentUserId to set
     */
    public void setAgentUserId(String agentUserId) {
        this.agentUserId = agentUserId;
    }

    /**
     * @return the caseId
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * @param caseId the caseId to set
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    /**
     * @return the agentAuthType
     */
    public String getAgentAuthType() {
        return agentAuthType;
    }

    /**
     * @param agentAuthType the agentAuthType to set
     */
    public void setAgentAuthType(String agentAuthType) {
        this.agentAuthType = agentAuthType;
    }

    /**
     * @return the agentIdentityType
     */
    public String getAgentIdentityType() {
        return agentIdentityType;
    }

    /**
     * @param agentIdentityType the agentIdentityType to set
     */
    public void setAgentIdentityType(String agentIdentityType) {
        this.agentIdentityType = agentIdentityType;
    }

    /**
     * @return the lawyerCertBase64Img
     */
    public String getLawyerCertBase64Img() {
        return lawyerCertBase64Img;
    }

    /**
     * @param lawyerCertBase64Img the lawyerCertBase64Img to set
     */
    public void setLawyerCertBase64Img(String lawyerCertBase64Img) {
        this.lawyerCertBase64Img = lawyerCertBase64Img;
    }

    /**
     * @return the arbiProtocolSignMode
     */
    public String getArbiProtocolSignMode() {
        return arbiProtocolSignMode;
    }

    /**
     * @param arbiProtocolSignMode the arbiProtocolSignMode to set
     */
    public void setArbiProtocolSignMode(String arbiProtocolSignMode) {
        this.arbiProtocolSignMode = arbiProtocolSignMode;
    }

    /**
     * @return the signTime
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * @param signTime the signTime to set
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    /**
     * @return the protocolName
     */
    public String getProtocolName() {
        return protocolName;
    }

    /**
     * @param protocolName the protocolName to set
     */
    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    /**
     * @return the duties
     */
    public String getDuties() {
        return duties;
    }

    /**
     * @param duties the duties to set
     */
    public void setDuties(String duties) {
        this.duties = duties;
    }

    /**
     * @return the caseType
     */
    public String getCaseType() {
        return caseType;
    }

    /**
     * @param caseType the caseType to set
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}
