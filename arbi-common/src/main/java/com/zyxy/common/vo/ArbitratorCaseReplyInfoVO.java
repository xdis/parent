package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 仲裁员案件请求答辩信息VO
 */
@ApiModel("仲裁员案件请求答辩信息")
public class ArbitratorCaseReplyInfoVO {


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
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    private String applicantName;

    /**
     * 案号
     */
    @ApiModelProperty("案号")
    private String caseNo;

    /**
     * 案由
     */
    @ApiModelProperty("案由")
    private String caseType;

    /**
     * 答辩内容
     */
    @ApiModelProperty("答辩内容")
    private String replyContent;

    /**
     * 答辩人
     */
    @ApiModelProperty("答辩人")
    private String replyName;

    /**
     * 答辩时间
     */
    @ApiModelProperty("答辩时间")
    private Date replyTime;

    /**
     * 是否延期答辩
     */
    @ApiModelProperty("是否延期答辩")
    private String delayedReply;

    /**
     * 管辖权异议
     */
    @ApiModelProperty("管辖权异议")
    private CaseJurisDisVO caseJurisDis;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据列表")
    private List<CaseEvidenceVO> caseEvidences;

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

    public String getBeApplicantAttorneyJob() {
        return beApplicantAttorneyJob;
    }

    public void setBeApplicantAttorneyJob(String beApplicantAttorneyJob) {
        this.beApplicantAttorneyJob = beApplicantAttorneyJob;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getDelayedReply() {
        return delayedReply;
    }

    public void setDelayedReply(String delayedReply) {
        this.delayedReply = delayedReply;
    }

    public CaseJurisDisVO getCaseJurisDis() {
        return caseJurisDis;
    }

    public void setCaseJurisDis(CaseJurisDisVO caseJurisDis) {
        this.caseJurisDis = caseJurisDis;
    }

    public List<CaseEvidenceVO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseEvidenceVO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }
}