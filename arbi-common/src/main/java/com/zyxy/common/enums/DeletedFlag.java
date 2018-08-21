package com.zyxy.common.enums;


public enum DeletedFlag {

    /**
     * 是
     */
    YES("1", "是"),
	/**
     * 否
     */
    NO("0", "否");


    private String value;
    private String remark;

    DeletedFlag(String value, String remark) {
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
