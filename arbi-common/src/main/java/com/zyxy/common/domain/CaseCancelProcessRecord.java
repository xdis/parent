package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   撤案处理表
 *
 * case_cancel_process_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseCancelProcessRecord")
public class CaseCancelProcessRecord implements Serializable {
    /**
     * case_cancel_process_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * case_cancel_process_record.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String caseId;

    /**
     *
     *   状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过
     * case_cancel_process_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过")
    private String status;

    /**
     *
     *   请求类型
     * case_cancel_process_record.RETUEST_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求类型")
    private String retuestType;

    /**
     *
     *   不通过意见
     * case_cancel_process_record.OPINION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "不通过意见")
    private String opinion;

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     *
     * @return
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     *
     *
     * @param id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     *
     *
     * @return
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     *
     *
     * @param caseId
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过
     * 
     * @return 状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过
     * 
     * @param status 状态，0- 等待仲裁员出具撤案决定书(审核中也是这个状态)，1- 完成，2- 不通过
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 请求类型
     * 
     * @return 请求类型
     *
     * @mbggenerated
     */
    public String getRetuestType() {
        return retuestType;
    }

    /**
     * 请求类型
     * 
     * @param retuestType 请求类型
     *
     * @mbggenerated
     */
    public void setRetuestType(String retuestType) {
        this.retuestType = retuestType == null ? null : retuestType.trim();
    }

    /**
     * 不通过意见
     * 
     * @return 不通过意见
     *
     * @mbggenerated
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * 不通过意见
     * 
     * @param opinion 不通过意见
     *
     * @mbggenerated
     */
    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }
}