package com.zyxy.common.enums;

/**
 * 组庭标志枚举类
 */
public enum TribunalMarkEnum {
	/** 未组庭 **/
    NOT_TRIBUNAL("0","未组庭"),
    /** 已组庭  **/
    ALREADY_TRIBUNAL("1","已组庭");

    private String code;
    private String remark;

    TribunalMarkEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
