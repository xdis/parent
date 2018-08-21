package com.zyxy.common.enums;

/**
 * 签章记录状态
 */
public enum SignSignatureLogStatusEnum {

    /**
     * 签约未初始化完成
     */
    INIT(-1, "签约未初始化完成"),
    /**
     * 签名成功
     */
    SUCCESS(1, "签名成功"),
    /**
     * 签名失败
     */
    FAILURE(2, "签名失败");

    private int value;


    private String remark;

    private SignSignatureLogStatusEnum(int value, String remark) {
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
