package com.zyxy.common.enums;


public enum CaseTimeSetTypeEnum {

    CASE_CHECK("1", "立案审核"),
    CASE_PAY("2", "缴费"),
    CASE_ACCEPT_ADVICE_NOTE("3", "下发受理通知书"),
    CASE_REPLY_UPPER("4", "答辩期(标的五万以上)"),
    CASE_REPLY_LOWER("5", "答辩期(标的不超过五万，含五万)"),
    CASE_PROCESSING_UPPER("6", "审理期(标的五万以上)"),
    CASE_PROCESSING_LOWER("7", "审理期(标的不超过五万，含五万)"),
    CASE_OFFSET("8", "补正期"),
    MENDING_PAY_LOWER("9","补缴(标的不超过五万，含五万)"),
    MENDING_PAY_UPPER("10","补缴(标的五万以上)"),
    COMPROMISE_TRIBUNAL("11","和解");

    private String value;

    private String remark;

    CaseTimeSetTypeEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static CaseTimeSetTypeEnum getByValue(String userTypeStr) {
        for (CaseTimeSetTypeEnum o : CaseTimeSetTypeEnum.values()) {
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
