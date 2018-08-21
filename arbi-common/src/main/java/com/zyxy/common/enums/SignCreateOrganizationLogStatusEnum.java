package com.zyxy.common.enums;

/**
 * 签章记录状态
 */
public enum SignCreateOrganizationLogStatusEnum {

    /**
     * 上传认证初始化
     */
    INIT(-1, "上传认证初始化"),
    /**
     * 认证成功
     */
    SUCCESS(1, "认证成功"),
    /**
     * 认证失败
     */
    FAILURE(2, "认证失败");

    private int value;


    private String remark;

    private SignCreateOrganizationLogStatusEnum(int value, String remark) {
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
