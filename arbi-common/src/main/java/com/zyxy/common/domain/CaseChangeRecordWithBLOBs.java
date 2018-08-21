package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_change_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseChangeRecord")
public class CaseChangeRecordWithBLOBs extends CaseChangeRecord implements Serializable {
    /**
     * 
     *   请求事项
     * case_change_record.CHANGE_REQUEST
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求事项")
    private String changeRequest;

    /**
     * 
     *   变更内容
     * case_change_record.CHANGE_CONTENT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变更内容")
    private String changeContent;

    /**
     * 
     *   未通过原因
     * case_change_record.REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "未通过原因")
    private String reason;

    /**
     * case_change_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 请求事项
     * 
     * @return 请求事项
     *
     * @mbggenerated
     */
    public String getChangeRequest() {
        return changeRequest;
    }

    /**
     * 请求事项
     * 
     * @param changeRequest 请求事项
     *
     * @mbggenerated
     */
    public void setChangeRequest(String changeRequest) {
        this.changeRequest = changeRequest == null ? null : changeRequest.trim();
    }

    /**
     * 变更内容
     * 
     * @return 变更内容
     *
     * @mbggenerated
     */
    public String getChangeContent() {
        return changeContent;
    }

    /**
     * 变更内容
     * 
     * @param changeContent 变更内容
     *
     * @mbggenerated
     */
    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent == null ? null : changeContent.trim();
    }

    /**
     * 未通过原因
     * 
     * @return 未通过原因
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 未通过原因
     * 
     * @param reason 未通过原因
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}