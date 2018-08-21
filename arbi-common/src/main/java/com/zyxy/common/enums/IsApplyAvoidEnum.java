package com.zyxy.common.enums;

/**
 * 是否回避过枚举类
 */
public enum IsApplyAvoidEnum {
    /**
     * 回避过
     */
    IS_APPLY_AVOID("0"),
    /**
     * 没有回避过
     */
    NOT_IS_APPLY_AVOID("1"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    IsApplyAvoidEnum(String code) {
        this.code = code;
    }
}
