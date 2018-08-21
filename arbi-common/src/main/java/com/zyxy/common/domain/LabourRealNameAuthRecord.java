package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   人工实名认证记录表
 *
 * labour_real_name_auth_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "LabourRealNameAuthRecord")
public class LabourRealNameAuthRecord implements Serializable {
    /**
     *
     *   ID
     * labour_real_name_auth_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     *
     *   身份证正面
     * labour_real_name_auth_record.ID_CARD
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证正面")
    private String idCard;

    /**
     *
     *   责任人
     * labour_real_name_auth_record.CURRENT_OWNER
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任人")
    private String currentOwner;

    /**
     *
     *   状态，0- 待审核，1- 通过，2- 不通过
     * labour_real_name_auth_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 待审核，1- 通过，2- 不通过")
    private String status;

    /**
     *
     *   创建人
     * labour_real_name_auth_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     *
     *   创建时间
     * labour_real_name_auth_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *
     *   审核时间
     * labour_real_name_auth_record.AUDIT_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    /**
     * labour_real_name_auth_record
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
     * 身份证正面
     * 
     * @return 身份证正面
     *
     * @mbggenerated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证正面
     *
     * @param idCard 身份证正面
     *
     * @mbggenerated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 责任人
     * 
     * @return 责任人
     *
     * @mbggenerated
     */
    public String getCurrentOwner() {
        return currentOwner;
    }

    /**
     * 责任人
     * 
     * @param currentOwner 责任人
     *
     * @mbggenerated
     */
    public void setCurrentOwner(String currentOwner) {
        this.currentOwner = currentOwner == null ? null : currentOwner.trim();
    }

    /**
     * 状态，0- 待审核，1- 通过，2- 不通过
     * 
     * @return 状态，0- 待审核，1- 通过，2- 不通过
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 待审核，1- 通过，2- 不通过
     * 
     * @param status 状态，0- 待审核，1- 通过，2- 不通过
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
     * 审核时间
     * 
     * @return 审核时间
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 审核时间
     * 
     * @param auditTime 审核时间
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}