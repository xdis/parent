package com.zyxy.common.enums;

/**
 * sys_user是否锁定
 */
public enum SysUserBelockedEnum {
    /**
     * 没有锁定
     */
    NO("0"),

    /**
     * 被锁定
     */
    YES("1"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    SysUserBelockedEnum(String code) {
        this.code = code;
    }
}
