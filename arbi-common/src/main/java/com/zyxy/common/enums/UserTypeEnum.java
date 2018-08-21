package com.zyxy.common.enums;

public enum UserTypeEnum {

    /**
     * 系统
     */
    Applicant(0, "申请人"),
    Claimant(1, "被申请人"),
    ARBITRATOR(2, "仲裁员"),
    SECRETARY(3,"仲裁秘书");

    private int value;

    private String remark;

    UserTypeEnum(int value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static UserTypeEnum getByValue(String userTypeStr) {
        for (UserTypeEnum o : UserTypeEnum.values()) {
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
