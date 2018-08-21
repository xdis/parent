package com.zyxy.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   案件请求基本信息表
 *
 * case_request_info
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseRequestInfo")
public class CaseRequestInfo implements Serializable {
    /**
     *
     *   编号
     * case_request_info.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     *
     *   案号
     * case_request_info.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案号")
    private String caseId;

    /**
     *
     *   受案号
     * case_request_info.ACCEPTANCE_NO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "受案号")
    private String acceptanceNo;

    /**
     *
     *   请求类型，0-本请求，1-反请求
     * case_request_info.REQUEST_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求类型，0-本请求，1-反请求")
    private String requestType;

    /**
     *
     *   代理标志
     * case_request_info.AGENT_FLAG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "代理标志")
    private String agentFlag;

    /**
     * case_request_info.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     *
     *   收案时间
     * case_request_info.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收案时间")
    private Date createTime;

    /**
     * case_request_info.UPDATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String updateId;

    /**
     * case_request_info.UPDATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date updateTime;

    /**
     *
     *   0-未延期答辩，1-延期答辩
     * case_request_info.DELAYED_REPLY
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "0-未延期答辩，1-延期答辩")
    private String delayedReply;

    /**
     *
     *   涉案金额
     * case_request_info.CASE_AMOUNT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "涉案金额")
    private BigDecimal caseAmount;

    /**
     *
     *   受理费
     * case_request_info.CASE_ADMISSIBLE_AMOUNT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "受理费")
    private BigDecimal caseAdmissibleAmount;

    /**
     *
     *   处理费
     * case_request_info.CASE_HANDLING_AMOUNT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理费")
    private BigDecimal caseHandlingAmount;

    /**
     *
     *   支付ID
     * case_request_info.PAY_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付ID")
    private String payId;

    /**
     * 状态，0- 正常，1- 撤案
     * case_request_info.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 正常，1- 撤案")
    private String status;

    /**
     *
     *   支付状态，0- 未支付，1- 已支付
     * case_request_info.PAY_STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付状态，0- 未支付，1- 已支付")
    private String payStatus;

    /**
     * 缴费截止时间
     * case_request_info.PAY_END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "缴费截止时间")
    private Date payEndTime;

    /**
     * 应退费
     * case_request_info.SHOULD_BE_REFUND
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应退费")
    private BigDecimal shouldBeRefund;

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     *
     * @return 编号
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     *
     * @param id 编号
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案号
     *
     * @return 案号
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案号
     *
     * @param caseId 案号
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 受案号
     *
     * @return 受案号
     *
     * @mbggenerated
     */
    public String getAcceptanceNo() {
        return acceptanceNo;
    }

    /**
     * 受案号
     *
     * @param acceptanceNo 受案号
     *
     * @mbggenerated
     */
    public void setAcceptanceNo(String acceptanceNo) {
        this.acceptanceNo = acceptanceNo == null ? null : acceptanceNo.trim();
    }

    /**
     * 请求类型，0-本请求，1-反请求
     *
     * @return 请求类型，0-本请求，1-反请求
     *
     * @mbggenerated
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * 请求类型，0-本请求，1-反请求
     *
     * @param requestType 请求类型，0-本请求，1-反请求
     *
     * @mbggenerated
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    /**
     * 代理标志
     *
     * @return 代理标志
     *
     * @mbggenerated
     */
    public String getAgentFlag() {
        return agentFlag;
    }

    /**
     * 代理标志
     *
     * @param agentFlag 代理标志
     *
     * @mbggenerated
     */
    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag == null ? null : agentFlag.trim();
    }

    /**
     *
     *
     * @return
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     *
     *
     * @param createrId
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 收案时间
     *
     * @return 收案时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 收案时间
     *
     * @param createTime 收案时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     *
     * @return
     *
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     *
     *
     * @param updateId
     *
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     *
     *
     * @return
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     *
     * @param updateTime
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 0-未延期答辩，1-延期答辩
     *
     * @return 0-未延期答辩，1-延期答辩
     *
     * @mbggenerated
     */
    public String getDelayedReply() {
        return delayedReply;
    }

    /**
     * 0-未延期答辩，1-延期答辩
     *
     * @param delayedReply 0-未延期答辩，1-延期答辩
     *
     * @mbggenerated
     */
    public void setDelayedReply(String delayedReply) {
        this.delayedReply = delayedReply == null ? null : delayedReply.trim();
    }

    /**
     * 涉案金额
     *
     * @return 涉案金额
     *
     * @mbggenerated
     */
    public BigDecimal getCaseAmount() {
        return caseAmount;
    }

    /**
     * 涉案金额
     *
     * @param caseAmount 涉案金额
     *
     * @mbggenerated
     */
    public void setCaseAmount(BigDecimal caseAmount) {
        this.caseAmount = caseAmount;
    }

    /**
     * 受理费
     *
     * @return 受理费
     *
     * @mbggenerated
     */
    public BigDecimal getCaseAdmissibleAmount() {
        return caseAdmissibleAmount;
    }

    /**
     * 受理费
     *
     * @param caseAdmissibleAmount 受理费
     *
     * @mbggenerated
     */
    public void setCaseAdmissibleAmount(BigDecimal caseAdmissibleAmount) {
        this.caseAdmissibleAmount = caseAdmissibleAmount;
    }

    /**
     * 处理费
     *
     * @return 处理费
     *
     * @mbggenerated
     */
    public BigDecimal getCaseHandlingAmount() {
        return caseHandlingAmount;
    }

    /**
     * 处理费
     *
     * @param caseHandlingAmount 处理费
     *
     * @mbggenerated
     */
    public void setCaseHandlingAmount(BigDecimal caseHandlingAmount) {
        this.caseHandlingAmount = caseHandlingAmount;
    }

    /**
     * 支付ID
     *
     * @return 支付ID
     *
     * @mbggenerated
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 支付ID
     *
     * @param payId 支付ID
     *
     * @mbggenerated
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    /**
     * 状态，0- 正常，1- 撤案
     *
     * @return 状态，0- 正常，1- 撤案
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 正常，1- 撤案
     *
     * @param status 状态，0- 正常，1- 撤案
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 支付状态，0- 未支付，1- 已支付
     *
     * @return 支付状态，0- 未支付，1- 已支付
     * @mbggenerated
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态，0- 未支付，1- 已支付
     *
     * @param payStatus 支付状态，0- 未支付，1- 已支付
     * @mbggenerated
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * 缴费截止时间
     *
     * @return 缴费截止时间
     * @mbggenerated
     */
    public Date getPayEndTime() {
        return payEndTime;
    }

    /**
     * 缴费截止时间
     *
     * @param payEndTime 缴费截止时间
     * @mbggenerated
     */
    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    public BigDecimal getShouldBeRefund() {
        return shouldBeRefund;
    }

    public void setShouldBeRefund(BigDecimal shouldBeRefund) {
        this.shouldBeRefund = shouldBeRefund;
    }
}