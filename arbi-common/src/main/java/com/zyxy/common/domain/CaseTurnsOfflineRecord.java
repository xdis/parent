package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_turns_offline_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseTurnsOfflineRecord")
public class CaseTurnsOfflineRecord implements Serializable {
    /**
     * 
     *   id
     * case_turns_offline_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 
     *   案件id
     * case_turns_offline_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件id")
    private String caseId;

    /**
     * 
     *   创建人
     * case_turns_offline_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     * 
     *   创建时间
     * case_turns_offline_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 
     *   业务id
     * case_turns_offline_record.BUSI_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务id")
    private String busiId;

    /**
     * 
     *   状态，0-待审核，1-审核通过，2-审核未通过
     * case_turns_offline_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0-待审核，1-审核通过，2-审核未通过")
    private String status;

    /**
     * 
     *   创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任
     * case_turns_offline_record.CREATER_ID_DUTIES
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任")
    private String createrIdDuties;

    /**
     * 
     *   原因
     * case_turns_offline_record.CAUSE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "原因")
    private String cause;

    /**
     * case_turns_offline_record
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
     * 业务id
     * 
     * @return 业务id
     *
     * @mbggenerated
     */
    public String getBusiId() {
        return busiId;
    }

    /**
     * 业务id
     * 
     * @param busiId 业务id
     *
     * @mbggenerated
     */
    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    /**
     * 状态，0-待审核，1-审核通过，2-审核未通过

     * 
     * @return 状态，0-待审核，1-审核通过，2-审核未通过

     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0-待审核，1-审核通过，2-审核未通过

     * 
     * @param status 状态，0-待审核，1-审核通过，2-审核未通过

     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任
     * 
     * @return 创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任
     *
     * @mbggenerated
     */
    public String getCreaterIdDuties() {
        return createrIdDuties;
    }

    /**
     * 创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任
     * 
     * @param createrIdDuties 创建人职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任--5,副主任
     *
     * @mbggenerated
     */
    public void setCreaterIdDuties(String createrIdDuties) {
        this.createrIdDuties = createrIdDuties == null ? null : createrIdDuties.trim();
    }

    /**
     * 原因
     * 
     * @return 原因
     *
     * @mbggenerated
     */
    public String getCause() {
        return cause;
    }

    /**
     * 原因
     * 
     * @param cause 原因
     *
     * @mbggenerated
     */
    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }
}