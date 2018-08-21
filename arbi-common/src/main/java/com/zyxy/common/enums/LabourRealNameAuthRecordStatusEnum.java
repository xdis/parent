package com.zyxy.common.enums;


public enum LabourRealNameAuthRecordStatusEnum {

    /**
     * 待审核
     */
    WAIT_AUDIT("0", "待审核"),
    /**
     * 通过
     */
    SUCCESS("1", "通过"),
    /**
     * 不通过
     */
    FAIL("2", "不通过");

    private String value;

    private String remark;

    LabourRealNameAuthRecordStatusEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static LabourRealNameAuthRecordStatusEnum getByValue(String userTypeStr) {
        for (LabourRealNameAuthRecordStatusEnum o : LabourRealNameAuthRecordStatusEnum.values()) {
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
