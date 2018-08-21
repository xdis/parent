package com.zyxy.common.enums;


public enum SysUserTypeEnum {

    /**
     * 系统
     */
    PARTY(0, "当事人"),
    ARBITRATOR(1, "仲裁员"),
    ARBITRATION_COMMITTEE(2, "仲裁委");

    private int value;

    private String remark;

    SysUserTypeEnum(int value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static SysUserTypeEnum getByValue(String userTypeStr) {
        for (SysUserTypeEnum o : SysUserTypeEnum.values()) {
            if (o.toString().equals(userTypeStr)) {
                return o;
            }
        }
        return null;
    }

    public int getValue() {
        return this.value;
    }

    public String getRemark() {
        return remark;
    }
}
