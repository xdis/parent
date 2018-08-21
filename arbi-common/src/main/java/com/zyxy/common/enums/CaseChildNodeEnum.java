package com.zyxy.common.enums;

/**
 * 案件子流程节点Enum
 */
public enum CaseChildNodeEnum {

    /**
     * 调解和解
     */
    CASE_MEDIATION_SETTLEMENT(10),

    /**
     * 变更仲裁请求
     */
    CASE_CHANGE_ARBITRATION_REQUEST(11),

    /**
     * 管辖权异议
     */
    CASE_OBJECTION_JURISDICTION(12),

    /**
     * 反请求
     */
    CASE_COUNTERCLAIM(13),


    /**
     * 反请求答辩
     */
    CASE_COUNTERCLAIM_REPLY(14),


    /**
     * 反请求管辖权异议
     */
    CASE_COUNTERCLAIM_OBJECTION_JURISDICTION(15),

    /**
     * 变更仲裁反请求
     */
    CASE_CHANGE_ARBITRATION_AGAINST_REQUEST(16);

    private Integer code;

    private CaseChildNodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
