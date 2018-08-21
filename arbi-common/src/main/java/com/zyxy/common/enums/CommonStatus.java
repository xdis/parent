package com.zyxy.common.enums;

public enum CommonStatus {


    STATUS_TRUE("0","可用"),
    STATUS_FALSE("1","不可用");

    private String value;
    private String remark;

    CommonStatus(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static CommonStatus getValue(String value) {
        for (CommonStatus c : CommonStatus.values()) {
            if (c.getValue().equals(value)) {
                return c;
            }
        }
        return null;
    }
}
