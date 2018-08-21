package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 案件公共基础信息
 */
@ApiModel("案件公共基础信息")
public class CaseCommBaseInfoVO {

    /**
     * 案号
     */
    @ApiModelProperty("案号")
    private String caseNo;

    /**
     * 秘书
     */
    @ApiModelProperty("秘书")
    private String secretary;

    /**
     * 仲裁庭组成
     */
    @ApiModelProperty("仲裁庭组成")
    private String arbitralTribunal;

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
     * 申请人联系电话
     */
    @ApiModelProperty("申请人联系电话")
    private String applicantPhone;

    /**
     * 申请方代理人
     */
    @ApiModelProperty("申请方代理人")
    private String applicantAttorney;

    /**
     * 申请方代理人电话
     */
    @ApiModelProperty("申请方代理人职业")
    private String applicantAttorneyJob;

    /**
     * 被申请人名称
     */
    @ApiModelProperty("被申请人名称")
    private String beApplicantName;

    /**
     * 被申请人类型
     */
    @ApiModelProperty("被申请人类型。0- 自然人，1- 法定代表人")
    private String beApplicantType;

    /**
     * 被申请人联系电话
     */
    @ApiModelProperty("被申请人联系电话")
    private String beApplicantPhone;

    /**
     * 被申请方代理人
     */
    @ApiModelProperty("被申请方代理人")
    private String beApplicantAttorney;

    /**
     * 被申请方代理人电话
     */
    @ApiModelProperty("被申请方代理人职业")
    private String beApplicantAttorneyJob;

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public String getArbitralTribunal() {
        return arbitralTribunal;
    }

    public void setArbitralTribunal(String arbitralTribunal) {
        this.arbitralTribunal = arbitralTribunal;
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

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
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

    public String getBeApplicantType() {
        return beApplicantType;
    }

    public void setBeApplicantType(String beApplicantType) {
        this.beApplicantType = beApplicantType;
    }

    public String getBeApplicantPhone() {
        return beApplicantPhone;
    }

    public void setBeApplicantPhone(String beApplicantPhone) {
        this.beApplicantPhone = beApplicantPhone;
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
}
