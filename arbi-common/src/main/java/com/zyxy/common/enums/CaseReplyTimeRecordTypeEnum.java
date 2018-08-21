package com.zyxy.common.enums;


public enum CaseReplyTimeRecordTypeEnum {

    /**
     * 请求答辩
     */
    CASE_REPLY("0", "请求答辩"),
    /**
     * 变更请求答辩
     */
    CASE_CHANGE_REPLY("1", "变更请求答辩");

    private String value;

    private String remark;

    CaseReplyTimeRecordTypeEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static CaseReplyTimeRecordTypeEnum getByValue(String userTypeStr) {
        for (CaseReplyTimeRecordTypeEnum o : CaseReplyTimeRecordTypeEnum.values()) {
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
