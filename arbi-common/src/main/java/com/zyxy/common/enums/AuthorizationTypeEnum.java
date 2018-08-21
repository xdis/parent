package com.zyxy.common.enums;

/**
 * 授权类型枚举类
 */
public enum AuthorizationTypeEnum {
    /**
     * 被授权方
     */
    BE_AUTHORIZATION_PARTY("0"),
    /**
     * 授权方
     */
    AUTHORIZATION_PARTY("1"),
    ;

    private String code;

    AuthorizationTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
