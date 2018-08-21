package com.zyxy.common.enums;

/**
 * 仲裁委类型Enum
 */
public enum FaceAuthRecordStatusEnum {

    /**
     * 0- 待验证
     */
    WAIT_VERIFY("0"),

    /**
     * 1- 通过
     */
    SUCCESS("1"),

    /**
     * 2- 不通过
     */
    FAIL("2"),

    /**
     * 3- getToken接口异常
     */
    GET_TOKEN_EXCEPTION("3"),

    /**
     * 4- token过期
     */
    TOKEN_EXPIRE("4");

    private String code;

    private FaceAuthRecordStatusEnum(String code) {
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
