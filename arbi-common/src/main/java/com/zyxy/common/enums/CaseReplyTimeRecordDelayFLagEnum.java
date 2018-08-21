package com.zyxy.common.enums;


public enum CaseReplyTimeRecordDelayFLagEnum {

    /**
     * 是
     */
    YES("0", "是"),
    /**
     * 否
     */
    NO("1", "否");

    private String value;

    private String remark;

    CaseReplyTimeRecordDelayFLagEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static CaseReplyTimeRecordDelayFLagEnum getByValue(String userTypeStr) {
        for (CaseReplyTimeRecordDelayFLagEnum o : CaseReplyTimeRecordDelayFLagEnum.values()) {
            if (o.toString().equals(userTypeStr)) {
                return o;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }

    public String getRemark() {
        return remark;
    }
}
