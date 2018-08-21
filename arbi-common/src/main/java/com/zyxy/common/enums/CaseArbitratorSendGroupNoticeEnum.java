package com.zyxy.common.enums;


/**
 * 组庭通知书发放状态Enum
 */
public enum CaseArbitratorSendGroupNoticeEnum {
    /**
     * 未发放
     */
    NO("0"),
    /**
     * 已发放
     */
    YES("1"),;
    private String code;

    private CaseArbitratorSendGroupNoticeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static CaseArbitratorSendGroupNoticeEnum getCode(String code) {
        for (CaseArbitratorSendGroupNoticeEnum c : CaseArbitratorSendGroupNoticeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
