package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案件仲裁员审核记录表
 * <p>
 * case_arbitrator_approve
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseArbitratorApprove")
public class CaseArbitratorApprove implements Serializable {
    /**
     * 编号
     * case_arbitrator_approve.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 案件ID
     * case_arbitrator_approve.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     * 仲裁员ID
     * case_arbitrator_approve.ARBITRATOR_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁员ID")
    private String arbitratorId;

    /**
     * 选择类型，0- 系统指派，1- 当事人选定
     * case_arbitrator_approve.TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "选择类型，0- 系统指派，1- 当事人选定")
    private String type;

    /**
     * 状态。0-待审核，1-审核通过，2-审核未通过
     * case_arbitrator_approve.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态。0-待审核，1-审核通过，2-审核未通过")
    private String status;

    /**
     * case_arbitrator_approve.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     * 创建时间
     * case_arbitrator_approve.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     *
     * @return 编号
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     *
     * @param id 编号
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件ID
     *
     * @return 案件ID
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件ID
     *
     * @param caseId 案件ID
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 仲裁员ID
     *
     * @return 仲裁员ID
     * @mbggenerated
     */
    public String getArbitratorId() {
        return arbitratorId;
    }

    /**
     * 仲裁员ID
     *
     * @param arbitratorId 仲裁员ID
     * @mbggenerated
     */
    public void setArbitratorId(String arbitratorId) {
        this.arbitratorId = arbitratorId == null ? null : arbitratorId.trim();
    }

    /**
     * 选择类型，0- 系统指派，1- 当事人选定
     *
     * @return 选择类型，0- 系统指派，1- 当事人选定
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 选择类型，0- 系统指派，1- 当事人选定
     *
     * @param type 选择类型，0- 系统指派，1- 当事人选定
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 状态。0-待审核，1-审核通过，2-审核未通过
     *
     * @return 状态。0-待审核，1-审核通过，2-审核未通过
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态。0-待审核，1-审核通过，2-审核未通过
     *
     * @param status 状态。0-待审核，1-审核通过，2-审核未通过
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * @param createrId
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 创建时间
     *
     * @return 创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}