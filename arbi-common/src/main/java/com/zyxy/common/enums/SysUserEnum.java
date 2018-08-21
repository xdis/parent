package com.zyxy.common.enums;


public enum SysUserEnum {

    /**
     * 系统
     */
    SYSTEM("999999");

    private String value;

    SysUserEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
