package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * withdraw_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="WithdrawRecord")
public class WithdrawRecordWithBLOBs extends WithdrawRecord implements Serializable {
    /**
     * 
     *   事实与理由
     * withdraw_record.FACT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "事实与理由")
    private String fact;

    /**
     * 
     *   保留
     * withdraw_record.REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "保留")
    private String reason;

    /**
     * 
     *   申请事项
     * withdraw_record.APPLICATION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请事项")
    private String application;

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 事实与理由
     * 
     * @return 事实与理由
     *
     * @mbggenerated
     */
    public String getFact() {
        return fact;
    }

    /**
     * 事实与理由
     * 
     * @param fact 事实与理由
     *
     * @mbggenerated
     */
    public void setFact(String fact) {
        this.fact = fact == null ? null : fact.trim();
    }

    /**
     * 保留
     * 
     * @return 保留
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 保留
     * 
     * @param reason 保留
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 申请事项
     * 
     * @return 申请事项
     *
     * @mbggenerated
     */
    public String getApplication() {
        return application;
    }

    /**
     * 申请事项
     * 
     * @param application 申请事项
     *
     * @mbggenerated
     */
    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }
}