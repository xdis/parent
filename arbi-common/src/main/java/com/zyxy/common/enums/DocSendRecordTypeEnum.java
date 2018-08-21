package com.zyxy.common.enums;

/**
 * 文件下放记录类型Enum
 */
public enum DocSendRecordTypeEnum {

    /**
     * 短信
     */
    SHORT_MESSAGE("0"),

    /**
     * 邮件
     */
    MAIL("1"),

    /**
     * 快递
     */
    EXPRESS("2");

    private String code;

    private DocSendRecordTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
