package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * arbi_change_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="ArbiChangeRecord")
public class ArbiChangeRecord implements Serializable {
    /**
     * arbi_change_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 
     *   案件ID
     * arbi_change_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     * arbi_change_record.CHANGE_CONTENT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String changeContent;

    /**
     * 
     *   变更人ID
     * arbi_change_record.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更人ID")
    private String userId;

    /**
     * 
     *   请求ID
     * arbi_change_record.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求ID")
    private Integer requestId;

    /**
     * 
     *   请求标志。0-正请求，1-反请求
     * arbi_change_record.COUNTERCLAIM_FLAG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求标志。0-正请求，1-反请求")
    private String counterclaimFlag;

    /**
     * 
     *   状态。0-待审核,1-审核通过,2-审核未通过
     * arbi_change_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态。0-待审核,1-审核通过,2-审核未通过")
    private String status;

    /**
     * 
     *   创建人
     * arbi_change_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     * arbi_change_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * 
     *   未通过原因
     * arbi_change_record.REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "未通过原因")
    private String reason;

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * 
     * @param id 
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 案件ID
     * 
     * @return 案件ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件ID
     * 
     * @param caseId 案件ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getChangeContent() {
        return changeContent;
    }

    /**
     * 
     * 
     * @param changeContent 
     *
     * @mbggenerated
     */
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent == null ? null : changeContent.trim();
    }

    /**
     * 变更人ID
     * 
     * @return 变更人ID
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 变更人ID
     * 
     * @param userId 变更人ID
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 请求ID
     * 
     * @return 请求ID
     *
     * @mbggenerated
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * 请求ID
     * 
     * @param requestId 请求ID
     *
     * @mbggenerated
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * 请求标志。0-正请求，1-反请求
     * 
     * @return 请求标志。0-正请求，1-反请求
     *
     * @mbggenerated
     */
    public String getCounterclaimFlag() {
        return counterclaimFlag;
    }

    /**
     * 请求标志。0-正请求，1-反请求
     * 
     * @param counterclaimFlag 请求标志。0-正请求，1-反请求
     *
     * @mbggenerated
     */
    public void setCounterclaimFlag(String counterclaimFlag) {
        this.counterclaimFlag = counterclaimFlag == null ? null : counterclaimFlag.trim();
    }

    /**
     * 状态。0-待审核,1-审核通过,2-审核未通过
     * 
     * @return 状态。0-待审核,1-审核通过,2-审核未通过
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态。0-待审核,1-审核通过,2-审核未通过
     * 
     * @param status 状态。0-待审核,1-审核通过,2-审核未通过
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建人
     * 
     * @return 创建人
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人
     * 
     * @param createrId 创建人
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * 
     * @param createTime 
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 未通过原因
     * 
     * @return 未通过原因
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 未通过原因
     * 
     * @param reason 未通过原因
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}