package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   案件仲裁员关系表
 *
 * case_arbitrator
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseArbitrator")
public class CaseArbitrator implements Serializable {
    /**
     *
     *   编号
     * case_arbitrator.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private Integer id;

    /**
     *
     *   案件ID
     * case_arbitrator.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     *
     *   仲裁员ID
     * case_arbitrator.ARBITRATOR_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁员ID")
    private String arbitratorId;

    /**
     *
     *   状态，0-待受理，1-不受理，2-有效，3-回避
     * case_arbitrator.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0-待受理，1-不受理，2-有效，3-回避")
    private String status;

    /**
     *
     *   类型，0-指派，1-选定
     * case_arbitrator.TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型，0-指派，1-选定")
    private String type;

    /**
     *
     *   受理时间
     * case_arbitrator.ACCEPT_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "受理时间")
    private Date acceptTime;

    /**
     *
     *   备注
     * case_arbitrator.REMARK
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     *
     *   创建人
     * case_arbitrator.CREATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createId;

    /**
     *
     *   创建时间
     * case_arbitrator.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *
     *   修改人
     * case_arbitrator.UPDATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改人")
    private String updateId;

    /**
     *
     *   修改时间
     * case_arbitrator.UPDATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     *
     *   是否下发组庭通知书，0- 未下发，1- 已下发
     * case_arbitrator.SEND_GROUP_NOTICE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否下发组庭通知书，0- 未下发，1- 已下发")
    private String sendGroupNotice;

    /**
     * 下发组庭通知书时间
     * case_arbitrator.SEND_GROUP_NOTICE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下发组庭通知书时间")
    private Date sendGroupNoticeTime;

    /**
     * case_arbitrator
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
    public Integer getId() {
        return id;
    }

    /**
     * 编号
     *
     * @param id 编号
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
     * 仲裁员ID
     *
     * @return 仲裁员ID
     *
     * @mbggenerated
     */
    public String getArbitratorId() {
        return arbitratorId;
    }

    /**
     * 仲裁员ID
     *
     * @param arbitratorId 仲裁员ID
     *
     * @mbggenerated
     */
    public void setArbitratorId(String arbitratorId) {
        this.arbitratorId = arbitratorId == null ? null : arbitratorId.trim();
    }

    /**
     * 状态，0-待受理，1-不受理，2-有效，3-回避
     *
     * @return 状态，0-待受理，1-不受理，2-有效，3-回避
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0-待受理，1-不受理，2-有效，3-回避
     *
     * @param status 状态，0-待受理，1-不受理，2-有效，3-回避
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 类型，0-指派，1-选定
     *
     * @return 类型，0-指派，1-选定
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 类型，0-指派，1-选定
     *
     * @param type 类型，0-指派，1-选定
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 受理时间
     *
     * @return 受理时间
     *
     * @mbggenerated
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * 受理时间
     *
     * @param acceptTime 受理时间
     *
     * @mbggenerated
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * 备注
     *
     * @return 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人
     *
     * @return 创建人
     *
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人
     *
     * @param createId 创建人
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

    /**
     * 修改人
     *
     * @return 修改人
     *
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 修改人
     *
     * @param updateId 修改人
     *
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 修改时间
     *
     * @return 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @param updateTime 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否下发组庭通知书，0- 未下发，1- 已下发
     *
     * @return 是否下发组庭通知书，0- 未下发，1- 已下发
     *
     * @mbggenerated
     */
    public String getSendGroupNotice() {
        return sendGroupNotice;
    }

    /**
     * 是否下发组庭通知书，0- 未下发，1- 已下发
     *
     * @param sendGroupNotice 是否下发组庭通知书，0- 未下发，1- 已下发
     *
     * @mbggenerated
     */
    public void setSendGroupNotice(String sendGroupNotice) {
        this.sendGroupNotice = sendGroupNotice == null ? null : sendGroupNotice.trim();
    }

    /**
     * 下发组庭通知书时间
     *
     * @return 下发组庭通知书时间
     *
     * @mbggenerated
     */
    public Date getSendGroupNoticeTime() {
        return sendGroupNoticeTime;
    }

    /**
     * 下发组庭通知书时间
     *
     * @param sendGroupNoticeTime 下发组庭通知书时间
     * @mbggenerated
     */
    public void setSendGroupNoticeTime(Date sendGroupNoticeTime) {
        this.sendGroupNoticeTime = sendGroupNoticeTime;
    }
}