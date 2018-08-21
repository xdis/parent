package com.zyxy.common.enums;

/**
 * 账号状态枚举类
 */
public enum SysUserStatusEnum {
    /**
     * 正常
     */
    NORMAL("1"),
    /**
     * 不可用
     */
    DISABLE("0"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    SysUserStatusEnum(String code) {
        this.code = code;
    }
}
