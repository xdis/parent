package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   案件请求基本信息表
 *
 * case_request_info
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseRequestInfo")
public class CaseRequestInfoWithBLOBs extends CaseRequestInfo implements Serializable {
    /**
     * 
     *   仲裁请求
     * case_request_info.ARB_CLAIM
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁请求")
    private String arbClaim;

    /**
     * 
     *   事实
     * case_request_info.FACT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "事实")
    private String fact;

    /**
     * 
     *   理由
     * case_request_info.REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "理由")
    private String reason;

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 仲裁请求
     * 
     * @return 仲裁请求
     *
     * @mbggenerated
     */
    public String getArbClaim() {
        return arbClaim;
    }

    /**
     * 仲裁请求
     * 
     * @param arbClaim 仲裁请求
     *
     * @mbggenerated
     */
    public void setArbClaim(String arbClaim) {
        this.arbClaim = arbClaim == null ? null : arbClaim.trim();
    }

    /**
     * 事实
     * 
     * @return 事实
     *
     * @mbggenerated
     */
    public String getFact() {
        return fact;
    }

    /**
     * 事实
     * 
     * @param fact 事实
     *
     * @mbggenerated
     */
    public void setFact(String fact) {
        this.fact = fact == null ? null : fact.trim();
    }

    /**
     * 理由
     * 
     * @return 理由
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 理由
     * 
     * @param reason 理由
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}