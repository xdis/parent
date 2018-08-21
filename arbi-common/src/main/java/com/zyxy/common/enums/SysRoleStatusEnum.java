package com.zyxy.common.enums;

/**
 * 角色状态
 */
public enum SysRoleStatusEnum {
    /**
     * 不可用
     */
    DO_NOT_USE("0"),

    /**
     * 正常
     */
    NORMAL("1"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    SysRoleStatusEnum(String code) {
        this.code = code;
    }
}
