package com.zyxy.common.enums;

/**
 * 仲裁委案件关系Enum
 */
public enum CaseManagerStatusEnum {

    /**
     * 有效
     */
    OK("0"),
    /**
     * 回避
     */
    AVOID("1");

    private CaseManagerStatusEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static CaseManagerStatusEnum getCode(String code) {
        for (CaseManagerStatusEnum c : CaseManagerStatusEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
