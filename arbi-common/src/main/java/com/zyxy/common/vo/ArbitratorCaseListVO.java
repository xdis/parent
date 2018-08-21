package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员案件列表VO
 */
@ApiModel("仲裁员案件列表")
public class ArbitratorCaseListVO {

    /**
     * id
     */
    @ApiModelProperty("案件Id")
    private String id;

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
     * 右上角状态
     */
    @ApiModelProperty("右上角状态,0- 待受理, 1- 进行中, 2- 已完结")
    private Integer rightStatus;

    /**
     * 状态
     */
    @ApiModelProperty("状态,0- 待提交, 1- 和解中, 2- 答辩中, 3- 裁决中, 4- 已结案，5- 补正")
    private Integer status;

    /**
     * 主流程状态
     */
    @ApiModelProperty("主流程状态")
    private String mainStatus;

    /**
     * 子流程状态
     */
    @ApiModelProperty("子流程状态")
    private String childStatus;

    /**
     * 申请人
     */
    @ApiModelProperty("申请人")
    private String applicant;

    /**
     * 被申请人
     */
    @ApiModelProperty("被申请人")
    private String beApplicant;

    /**
     * 代理人名称
     */
    @ApiModelProperty("代理人名称")
    private String agentName;

    /**
     * 是否有反请求
     */
    @ApiModelProperty("是否有反请求")
    private Boolean isBack;

    /**
     * 受理日期
     */
    @ApiModelProperty("受理日期")
    private String acceptDate;

    /**
     * 案件来源
     */
    @ApiModelProperty("案件来源,0-指派，1-选定")
    private String type;

    /**
     * 被邀时间
     */
    @ApiModelProperty("被邀时间")
    private String beInviteDate;

    public String getAcceptanceNo() {
        return acceptanceNo;
    }

    public void setAcceptanceNo(String acceptanceNo) {
        this.acceptanceNo = acceptanceNo;
    }

    public String getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(String mainStatus) {
        this.mainStatus = mainStatus;
    }

    public String getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(String childStatus) {
        this.childStatus = childStatus;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeInviteDate() {
        return beInviteDate;
    }

    public void setBeInviteDate(String beInviteDate) {
        this.beInviteDate = beInviteDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getRightStatus() {
        return rightStatus;
    }

    public void setRightStatus(Integer rightStatus) {
        this.rightStatus = rightStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBeApplicant() {
        return beApplicant;
    }

    public void setBeApplicant(String beApplicant) {
        this.beApplicant = beApplicant;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Boolean getIsBack() {
        return isBack;
    }

    public void setIsBack(Boolean isBack) {
        this.isBack = isBack;
    }
}
