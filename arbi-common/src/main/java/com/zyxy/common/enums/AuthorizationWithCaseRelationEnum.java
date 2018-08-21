package com.zyxy.common.enums;

/**
 * 是否与案件有关系枚举类
 */
public enum AuthorizationWithCaseRelationEnum {
    /**
     * 有关系
     */
    HAVE_RELATION("0"),

    /**
     * 无关系
     */
    NOT_RELATION("1"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    AuthorizationWithCaseRelationEnum(String code) {
        this.code = code;
    }
}
