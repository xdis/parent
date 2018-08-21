package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * withdraw_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="WithdrawRecord")
public class WithdrawRecord implements Serializable {
    /**
     * 
     *   编号
     * withdraw_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 
     *   案件id
     * withdraw_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件id")
    private String caseId;

    /**
     * 
     *   请求id
     * withdraw_record.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求id")
    private String requestId;

    /**
     * 
     *   状态  0-待生成  1-已生成
     * withdraw_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态  0-待生成  1-已生成")
    private String status;

    /**
     * 
     *   创建人id
     * withdraw_record.CREATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private String createId;

    /**
     * 
     *   创建时间
     * withdraw_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * withdraw_record
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
     * 案件id
     * 
     * @return 案件id
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件id
     * 
     * @param caseId 案件id
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 请求id
     * 
     * @return 请求id
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求id
     * 
     * @param requestId 请求id
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 状态  0-待生成  1-已生成
     * 
     * @return 状态  0-待生成  1-已生成
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态  0-待生成  1-已生成
     * 
     * @param status 状态  0-待生成  1-已生成
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建人id
     * 
     * @return 创建人id
     *
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人id
     * 
     * @param createId 创建人id
     *
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}