package com.zyxy.common.enums;

/**
 * 案件文书状态Enum
 */
public enum CaseDocStatusEnum {

    /*****文书状态******/

    /**
     * 正常
     */
    NORMAL("0"),

    /**
     * 废弃
     */
    DISUSE("1");

    /*****文书状态******/
    

    private String code;

    private CaseDocStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static CaseArbitratorStatusEnum getCode(String code) {
        for (CaseArbitratorStatusEnum c : CaseArbitratorStatusEnum.values()) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }
}
