package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案件调解处理表
 * <p>
 * case_mediate_process_record
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseMediateProcessRecord")
public class CaseMediateProcessRecord implements Serializable {
    /**
     * case_mediate_process_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * case_mediate_process_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String caseId;

    /**
     * 状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功
     * case_mediate_process_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功")
    private String status;

    /**
     * 申请人签名状态，0- 未签名，1- 已签名
     * case_mediate_process_record.PROPOSER_SIGN_STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人签名状态，0- 未签名，1- 已签名")
    private String proposerSignStatus;

    /**
     * 被申请人签名状态，0- 未签名，1- 已签名
     * case_mediate_process_record.DEFENDANT_SIGN_STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "被申请人签名状态，0- 未签名，1- 已签名")
    private String defendantSignStatus;

    /**
     * case_mediate_process_record
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
     * 状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功
     *
     * @return 状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功
     *
     * @param status 状态，0- 等待仲裁员出具调解书(审核中也是这个状态)，1- 等待双方签字，2- 终止调解，3- 调解成功
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 申请人签名状态，0- 未签名，1- 已签名
     *
     * @return 申请人签名状态，0- 未签名，1- 已签名
     * @mbggenerated
     */
    public String getProposerSignStatus() {
        return proposerSignStatus;
    }

    /**
     * 申请人签名状态，0- 未签名，1- 已签名
     *
     * @param proposerSignStatus 申请人签名状态，0- 未签名，1- 已签名
     * @mbggenerated
     */
    public void setProposerSignStatus(String proposerSignStatus) {
        this.proposerSignStatus = proposerSignStatus == null ? null : proposerSignStatus.trim();
    }

    /**
     * 被申请人签名状态，0- 未签名，1- 已签名
     *
     * @return 被申请人签名状态，0- 未签名，1- 已签名
     * @mbggenerated
     */
    public String getDefendantSignStatus() {
        return defendantSignStatus;
    }

    /**
     * 被申请人签名状态，0- 未签名，1- 已签名
     *
     * @param defendantSignStatus 被申请人签名状态，0- 未签名，1- 已签名
     * @mbggenerated
     */
    public void setDefendantSignStatus(String defendantSignStatus) {
        this.defendantSignStatus = defendantSignStatus == null ? null : defendantSignStatus.trim();
    }
}