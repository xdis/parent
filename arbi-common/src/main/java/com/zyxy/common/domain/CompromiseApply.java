package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * compromise_apply
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CompromiseApply")
public class CompromiseApply implements Serializable {
    /**
     *
     *   id
     * compromise_apply.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     *
     *   申请类型，0-申请人发起，1-被申请人发起
     * compromise_apply.APPLY_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请类型，0-申请人发起，1-被申请人发起")
    private String applyType;

    /**
     *
     *   案件id
     * compromise_apply.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件id")
    private String caseId;

    /**
     *
     *   创建人id
     * compromise_apply.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private String createrId;

    /**
     *
     *   创建时间
     * compromise_apply.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *
     *   和解开始时间
     * compromise_apply.START_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "和解开始时间")
    private Date startTime;

    /**
     *
     *   申请人意见，0-同意，1-拒绝
     * compromise_apply.PROP_OPINION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人意见，0-同意，1-拒绝")
    private String propOpinion;

    /**
     *
     *   被申请人意见，0-同意，1-拒绝
     * compromise_apply.DEFE_OPINION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "被申请人意见，0-同意，1-拒绝")
    private String defeOpinion;

    /**
     *
     *   仲裁委/仲裁员意见，0-同意，1-拒绝
     * compromise_apply.MANAGER_OPINION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁委/仲裁员意见，0-同意，1-拒绝")
    private String managerOpinion;

    /**
     *
     *   和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应
     * compromise_apply.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应")
    private String status;

    /**
     *
     *   对方操作时间
     * compromise_apply.OTHER_OPERATING_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对方操作时间")
    private Date otherOperatingTime;

    /**
     *
     *   仲裁委/仲裁员操作时间
     * compromise_apply.MANAGER_OPERATING_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁委/仲裁员操作时间")
    private Date managerOperatingTime;

    /**
     *
     *   计划结束时间
     * compromise_apply.PLAN_END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "计划结束时间")
    private Date planEndTime;

    /**
     *
     *   实际结束时间
     * compromise_apply.REAL_END_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际结束时间")
    private Date realEndTime;

    /**
     * 审核人类型，0- 仲裁秘书审核 1- 仲裁员审核
     * compromise_apply.AUDIT_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核人类型，0- 仲裁秘书审核 1- 仲裁员审核")
    private String auditType;

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @return id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 申请类型，0-申请人发起，1-被申请人发起
     *
     * @return 申请类型，0-申请人发起，1-被申请人发起
     *
     * @mbggenerated
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * 申请类型，0-申请人发起，1-被申请人发起
     *
     * @param applyType 申请类型，0-申请人发起，1-被申请人发起
     *
     * @mbggenerated
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
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
     * 创建人id
     *
     * @return 创建人id
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人id
     *
     * @param createrId 创建人id
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
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
     * 和解开始时间
     *
     * @return 和解开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 和解开始时间
     *
     * @param startTime 和解开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 申请人意见，0-同意，1-拒绝
     *
     * @return 申请人意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public String getPropOpinion() {
        return propOpinion;
    }

    /**
     * 申请人意见，0-同意，1-拒绝
     *
     * @param propOpinion 申请人意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public void setPropOpinion(String propOpinion) {
        this.propOpinion = propOpinion == null ? null : propOpinion.trim();
    }

    /**
     * 被申请人意见，0-同意，1-拒绝
     *
     * @return 被申请人意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public String getDefeOpinion() {
        return defeOpinion;
    }

    /**
     * 被申请人意见，0-同意，1-拒绝
     *
     * @param defeOpinion 被申请人意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public void setDefeOpinion(String defeOpinion) {
        this.defeOpinion = defeOpinion == null ? null : defeOpinion.trim();
    }

    /**
     * 仲裁委/仲裁员意见，0-同意，1-拒绝
     *
     * @return 仲裁委/仲裁员意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public String getManagerOpinion() {
        return managerOpinion;
    }

    /**
     * 仲裁委/仲裁员意见，0-同意，1-拒绝
     *
     * @param managerOpinion 仲裁委/仲裁员意见，0-同意，1-拒绝
     *
     * @mbggenerated
     */
    public void setManagerOpinion(String managerOpinion) {
        this.managerOpinion = managerOpinion == null ? null : managerOpinion.trim();
    }

    /**
     * 和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应
     *
     * @return 和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应
     *
     * @param status 和解状态，0-待审核，1-和解中，2-拒绝和解，3-和解完成，4- 等待开始和解，5- 等待对方回应
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 对方操作时间
     *
     * @return 对方操作时间
     *
     * @mbggenerated
     */
    public Date getOtherOperatingTime() {
        return otherOperatingTime;
    }

    /**
     * 对方操作时间
     *
     * @param otherOperatingTime 对方操作时间
     *
     * @mbggenerated
     */
    public void setOtherOperatingTime(Date otherOperatingTime) {
        this.otherOperatingTime = otherOperatingTime;
    }

    /**
     * 仲裁委/仲裁员操作时间
     *
     * @return 仲裁委/仲裁员操作时间
     *
     * @mbggenerated
     */
    public Date getManagerOperatingTime() {
        return managerOperatingTime;
    }

    /**
     * 仲裁委/仲裁员操作时间
     *
     * @param managerOperatingTime 仲裁委/仲裁员操作时间
     *
     * @mbggenerated
     */
    public void setManagerOperatingTime(Date managerOperatingTime) {
        this.managerOperatingTime = managerOperatingTime;
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
     * 审核人类型，0- 仲裁秘书审核 1- 仲裁员审核
     *
     * @return 审核人类型，0- 仲裁秘书审核 1- 仲裁员审核
     *
     * @mbggenerated
     */
    public String getAuditType() {
        return auditType;
    }

    /**
     * 审核人类型，0- 仲裁秘书审核 1- 仲裁员审核
     *
     * @param auditType 审核人类型，0- 仲裁秘书审核 1- 仲裁员审核
     * @mbggenerated
     */
    public void setAuditType(String auditType) {
        this.auditType = auditType == null ? null : auditType.trim();
    }
}