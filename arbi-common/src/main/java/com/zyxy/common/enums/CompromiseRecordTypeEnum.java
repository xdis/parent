package com.zyxy.common.enums;

/**
 * 和解类型枚举类
 */
public enum CompromiseRecordTypeEnum {

    /**
     * 0-和解
     */
    COMPROMISE("0","和解"),

    /**
     * 1-调解
     */
    CONCILIATION("1","调解");


    private String value;

    private String remark;

    private CompromiseRecordTypeEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public String getRemark() {
        return remark;
    }
}
