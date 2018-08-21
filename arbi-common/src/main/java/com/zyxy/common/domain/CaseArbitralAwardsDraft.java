package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案件裁决书草稿
 * <p>
 * case_arbitral_awards_draft
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseArbitralAwardsDraft")
public class CaseArbitralAwardsDraft implements Serializable {
    /**
     * 主键
     * case_arbitral_awards_draft.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 案件Id
     * case_arbitral_awards_draft.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件Id")
    private String caseId;

    /**
     * case_arbitral_awards_draft.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     * case_arbitral_awards_draft.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @return 主键
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     *
     * @param id 主键
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件Id
     *
     * @return 案件Id
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件Id
     *
     * @param caseId 案件Id
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
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
     * @return
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}