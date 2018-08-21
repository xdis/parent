package com.zyxy.common.enums;

/**
 * 签章记录状态
 */
public enum SignSignetLogStatusEnum {

    /**
     * 签约未初始化完成
     */
    INIT(-1, "签约未初始化完成"),
    /**
     * 未签
     */
    NOT_SIGN(0, "未签"),
    /**
     * 已签
     */
    SIGNED(1, "已签"),
    /**
     * 拒签
     */
    REJECT(2, "拒签"),
    /**
     * 保全
     */
    SUCCESS(3, "保全"),
    /**
     * 失败
     */
    FAILURE(4, "失败");

    private int value;


    private String remark;

    private SignSignetLogStatusEnum(int value, String remark) {
        this.value = value;
        this.remark = remark;
    }


    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }


    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }


}
