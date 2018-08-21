package com.zyxy.common.enums;

/**
 * 案件操作权限
 */
public enum CaseOperationPrimissEnum {
    /**
     * 有权限
     */
    HAVE_PRIMISS("0"),

    /**
     * 无权限
     */
    NOT_PRIMISS("1"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    CaseOperationPrimissEnum(String code) {
        this.code = code;
    }
}
