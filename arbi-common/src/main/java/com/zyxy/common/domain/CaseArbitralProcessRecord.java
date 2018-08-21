package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 和解出具裁决书记录表
 * <p>
 * case_arbitral_process_record
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseArbitralProcessRecord")
public class CaseArbitralProcessRecord implements Serializable {
    /**
     * case_arbitral_process_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * case_arbitral_process_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String caseId;

    /**
     * 创建人Id
     * case_arbitral_process_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人Id")
    private String createrId;

    /**
     * 创建时间
     * case_arbitral_process_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * @param caseId
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 创建人Id
     *
     * @return 创建人Id
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人Id
     *
     * @param createrId 创建人Id
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