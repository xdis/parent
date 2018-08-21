package com.zyxy.common.enums;

/**
 * 和解申请审核人类型
 */
public enum  ComproiseApplyAuditTypeEnum {

    /**
     * 仲裁秘书审核
     */
    ARBITRATION_SECRETARIES("0"),

    /**
     * 仲裁员审核
     */
    ARBITRATOR("1");

    private String code;

    private ComproiseApplyAuditTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
