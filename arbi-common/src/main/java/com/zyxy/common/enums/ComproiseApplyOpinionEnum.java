package com.zyxy.common.enums;

/**
 * 和解申请意见Enum
 */
public enum ComproiseApplyOpinionEnum {


    /**
     * 同意
     */
	OPINION_AGREE("0"),

    /**
     * 拒绝
     */
	OPINION_REFUSE("1");

    private String code;

    private ComproiseApplyOpinionEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
