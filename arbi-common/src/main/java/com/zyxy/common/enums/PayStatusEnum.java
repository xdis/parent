package com.zyxy.common.enums;

/**
 * 支付状态枚举
 */
public enum PayStatusEnum {
    /**
     * 未支付
     */
    NOT_PAY("0", "未支付"),

    /**
     * 已支付
     */
    PAY("1", "已支付");

    private String value;
    private String remark;

    private PayStatusEnum(String value, String remark) {
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
