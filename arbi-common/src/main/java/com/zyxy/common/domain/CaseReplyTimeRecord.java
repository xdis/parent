package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   答辩时间记录表
 *
 * case_reply_time_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseReplyTimeRecord")
public class CaseReplyTimeRecord implements Serializable {
    /**
     *
     *   ID
     * case_reply_time_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     *
     *   业务ID,对应请求Id或变更请求Id
     * case_reply_time_record.BUSI_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务ID,对应请求Id或变更请求Id")
    private String busiId;

    /**
     *
     *   开始时间
     * case_reply_time_record.START_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     *
     *   结束时间
     * case_reply_time_record.END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     *
     *   类型，0- 请求答辩，1- 变更请求答辩
     * case_reply_time_record.TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型，0- 请求答辩，1- 变更请求答辩")
    private String type;

    /**
     *
     *   是否延期，0- 是，1- 否
     * case_reply_time_record.DELAY_FLAG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否延期，0- 是，1- 否")
    private String delayFlag;

    /**
     *
     *   请求标志,0- 正请求,1- 反请求
     * case_reply_time_record.REQUEST_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求标志,0- 正请求,1- 反请求")
    private String requestType;

    /**
     *
     *   案件Id
     * case_reply_time_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件Id")
    private String caseId;

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * 
     * @return ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * 
     * @param id ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 业务ID,对应请求Id或变更请求Id
     *
     * @return 业务ID, 对应请求Id或变更请求Id
     *
     * @mbggenerated
     */
    public String getBusiId() {
        return busiId;
    }

    /**
     * 业务ID,对应请求Id或变更请求Id
     * 
     * @param busiId 业务ID,对应请求Id或变更请求Id
     *
     * @mbggenerated
     */
    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    /**
     * 开始时间
     * 
     * @return 开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * 
     * @param startTime 开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * 
     * @return 结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * 
     * @param endTime 结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 类型，0- 请求答辩，1- 变更请求答辩
     * 
     * @return 类型，0- 请求答辩，1- 变更请求答辩
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 类型，0- 请求答辩，1- 变更请求答辩
     * 
     * @param type 类型，0- 请求答辩，1- 变更请求答辩
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 是否延期，0- 是，1- 否
     * 
     * @return 是否延期，0- 是，1- 否
     *
     * @mbggenerated
     */
    public String getDelayFlag() {
        return delayFlag;
    }

    /**
     * 是否延期，0- 是，1- 否
     * 
     * @param delayFlag 是否延期，0- 是，1- 否
     *
     * @mbggenerated
     */
    public void setDelayFlag(String delayFlag) {
        this.delayFlag = delayFlag == null ? null : delayFlag.trim();
    }

    /**
     * 请求标志,0- 正请求,1- 反请求
     *
     * @return 请求标志, 0- 正请求,1- 反请求
     *
     * @mbggenerated
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * 请求标志,0- 正请求,1- 反请求
     * 
     * @param requestType 请求标志,0- 正请求,1- 反请求
     *
     * @mbggenerated
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    /**
     * 案件Id
     * 
     * @return 案件Id
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件Id
     * 
     * @param caseId 案件Id
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }
}