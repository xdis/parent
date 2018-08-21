package com.zyxy.common.enums;

/**
 * 授权状态枚举类
 */
public enum AuthorizationDelegateStatusEnum {
    /**
     * 有效
     */
    EFFECTIVE("0"),
    /**
     * 无效
     */
    INVALID("1"),
    ;

    private String code;

    AuthorizationDelegateStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
