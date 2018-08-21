package com.zyxy.common.enums;


public enum ComproiseApplyStatusEnum {

    /**
     * 待审核
     */
    WAIT_CHECK("0", "待审核"),
    /**
     * 和解中
     */
    DOING("1", "和解中"),
    /**
     * 拒绝和解
     */
    REFUSED("2", "拒绝和解"),
    /**
     * 和解完成
     */
    FINISH("3", "和解完成");


    private String value;
    private String remark;

    ComproiseApplyStatusEnum(String value, String remark) {
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
