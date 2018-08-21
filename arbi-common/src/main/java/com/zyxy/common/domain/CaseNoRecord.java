package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案号生成记录表
 * <p>
 * case_no_record
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseNoRecord")
public class CaseNoRecord implements Serializable {
    /**
     * case_no_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * case_no_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String caseId;

    /**
     * 关联case_no_seq
     * case_no_record.CASE_SEQ_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联case_no_seq")
    private String caseSeqId;

    /**
     * case_no_record
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
     * 关联case_no_seq
     *
     * @return 关联case_no_seq
     * @mbggenerated
     */
    public String getCaseSeqId() {
        return caseSeqId;
    }

    /**
     * 关联case_no_seq
     *
     * @param caseSeqId 关联case_no_seq
     * @mbggenerated
     */
    public void setCaseSeqId(String caseSeqId) {
        this.caseSeqId = caseSeqId == null ? null : caseSeqId.trim();
    }
}