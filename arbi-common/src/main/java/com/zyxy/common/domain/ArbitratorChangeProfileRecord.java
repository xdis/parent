package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 仲裁员申请修改信息表
 * <p>
 * arbitrator_change_profile_record
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "ArbitratorChangeProfileRecord")
public class ArbitratorChangeProfileRecord implements Serializable {
    /**
     * ID
     * arbitrator_change_profile_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * arbitrator_change_profile_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 待审核，1- 审核通过，2- 审核不通过")
    private String status;

    /**
     * 创建时间
     * arbitrator_change_profile_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 申请人userId
     * arbitrator_change_profile_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人userId")
    private String createrId;

    /**
     * 职业
     * arbitrator_change_profile_record.job
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职业")
    private String job;

    /**
     * 专长
     * arbitrator_change_profile_record.speciality
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "专长")
    private String speciality;

    /**
     * 居住地
     * arbitrator_change_profile_record.address
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "居住地")
    private String address;

    /**
     * 证件照
     * arbitrator_change_profile_record.id_card
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "证件照")
    private String idCard;

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @return ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     *
     * @param id ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     *
     * @return 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     *
     * @param status 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    /**
     * 申请人userId
     *
     * @return 申请人userId
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 申请人userId
     *
     * @param createrId 申请人userId
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 职业
     *
     * @return 职业
     * @mbggenerated
     */
    public String getJob() {
        return job;
    }

    /**
     * 职业
     *
     * @param job 职业
     * @mbggenerated
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * 专长
     *
     * @return 专长
     * @mbggenerated
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * 专长
     *
     * @param speciality 专长
     * @mbggenerated
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    /**
     * 居住地
     *
     * @return 居住地
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 居住地
     *
     * @param address 居住地
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 证件照
     *
     * @return 证件照
     * @mbggenerated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 证件照
     *
     * @param idCard 证件照
     * @mbggenerated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }
}