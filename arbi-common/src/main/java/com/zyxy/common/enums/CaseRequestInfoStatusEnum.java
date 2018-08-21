package com.zyxy.common.enums;

/**
 * CaseRequestInfo Status枚举
 */
public enum CaseRequestInfoStatusEnum {

    /**
     * 正常
     */
    NORMAL("0", "正常"),

    /**
     * 撤案
     */
    CANCEL("1", "撤案"),

    /**
     * 支付失败
     */
    PAY_ERROR("1", "支付失败");

    private String value;
    private String remark;

    private CaseRequestInfoStatusEnum(String value, String remark) {
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
