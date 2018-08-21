package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_node_oper
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseNodeOper")
public class CaseNodeOper implements Serializable {
    /**
     * case_node_oper.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 
     *   请求ID
     * case_node_oper.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求ID")
    private String requestId;

    /**
     * 
     *   案件ID
     * case_node_oper.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     * 
     *   节点ID
     * case_node_oper.NODE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节点ID")
    private Integer nodeId;

    /**
     * 
     *   流转节点ID
     * case_node_oper.NEXT_NODE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "流转节点ID")
    private Integer nextNodeId;

    /**
     * 
     *   操作记录
     * case_node_oper.OPER_RECORD
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作记录")
    private String operRecord;

    /**
     * 
     *   包括缴费ID，审批ID
     * case_node_oper.BUSS_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "包括缴费ID，审批ID")
    private String bussId;

    /**
     * 
     *   0-初始，1-成功，2-失败，3-终止
     * case_node_oper.DEAL_STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "0-初始，1-成功，2-失败，3-终止")
    private String dealStatus;

    /**
     * 
     *   开始时间
     * case_node_oper.START_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 
     *   计划结束时间
     * case_node_oper.PLAN_END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "计划结束时间")
    private Date planEndTime;

    /**
     * 
     *   实际结束时间
     * case_node_oper.REAL_END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际结束时间")
    private Date realEndTime;

    /**
     * 
     *   操作人ID
     * case_node_oper.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作人ID")
    private String createrId;

    /**
     * case_node_oper.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * case_node_oper
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
    public String getId() {
        return id;
    }

    /**
     * 
     * 
     * @param id 
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 请求ID
     * 
     * @return 请求ID
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求ID
     * 
     * @param requestId 请求ID
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
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
     * 节点ID
     * 
     * @return 节点ID
     *
     * @mbggenerated
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 节点ID
     * 
     * @param nodeId 节点ID
     *
     * @mbggenerated
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 流转节点ID
     * 
     * @return 流转节点ID
     *
     * @mbggenerated
     */
    public Integer getNextNodeId() {
        return nextNodeId;
    }

    /**
     * 流转节点ID
     * 
     * @param nextNodeId 流转节点ID
     *
     * @mbggenerated
     */
    public void setNextNodeId(Integer nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    /**
     * 操作记录
     * 
     * @return 操作记录
     *
     * @mbggenerated
     */
    public String getOperRecord() {
        return operRecord;
    }

    /**
     * 操作记录
     * 
     * @param operRecord 操作记录
     *
     * @mbggenerated
     */
    public void setOperRecord(String operRecord) {
        this.operRecord = operRecord == null ? null : operRecord.trim();
    }

    /**
     * 包括缴费ID，审批ID
     * 
     * @return 包括缴费ID，审批ID
     *
     * @mbggenerated
     */
    public String getBussId() {
        return bussId;
    }

    /**
     * 包括缴费ID，审批ID
     * 
     * @param bussId 包括缴费ID，审批ID
     *
     * @mbggenerated
     */
    public void setBussId(String bussId) {
        this.bussId = bussId == null ? null : bussId.trim();
    }

    /**
     * 0-初始，1-成功，2-失败，3-终止
     * 
     * @return 0-初始，1-成功，2-失败，3-终止
     *
     * @mbggenerated
     */
    public String getDealStatus() {
        return dealStatus;
    }

    /**
     * 0-初始，1-成功，2-失败，3-终止
     * 
     * @param dealStatus 0-初始，1-成功，2-失败，3-终止
     *
     * @mbggenerated
     */
    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus == null ? null : dealStatus.trim();
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
     * 计划结束时间
     * 
     * @return 计划结束时间
     *
     * @mbggenerated
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * 计划结束时间
     * 
     * @param planEndTime 计划结束时间
     *
     * @mbggenerated
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * 实际结束时间
     * 
     * @return 实际结束时间
     *
     * @mbggenerated
     */
    public Date getRealEndTime() {
        return realEndTime;
    }

    /**
     * 实际结束时间
     * 
     * @param realEndTime 实际结束时间
     *
     * @mbggenerated
     */
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * 操作人ID
     * 
     * @return 操作人ID
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 操作人ID
     * 
     * @param createrId 操作人ID
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
}