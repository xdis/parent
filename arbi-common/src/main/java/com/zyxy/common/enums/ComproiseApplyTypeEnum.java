package com.zyxy.common.enums;

/**
 * 和解申请类型Enum
 */
public enum ComproiseApplyTypeEnum {


    /**
     * 申请人发起
     */
    APPLICANT_INITIATED("0"),
    /**
     * 被申请人发起
     */
    COVER_APPLICANT_INITIATED("1");


    private String code;

    private ComproiseApplyTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
