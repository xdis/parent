package com.zyxy.common.enums;

/**
 * 文件下放记录状态Enum
 */
public enum DocSendRecordStatusEnum {

    /**
     * 正常
     */
    NORMAL("0"),

    /**
     * 失败
     */
    FAIL("1");

    private String code;

    private DocSendRecordStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
