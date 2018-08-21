package com.zyxy.common.enums;

/**
 * 仲裁委人员状态Enum
 */
public enum ManagerInfoStatusEnum {

    /**仲裁委人员状态**/

    /**
     * 0-正常
     *
     */
    NORMAL("0"),

    /**
     * 1-注销
     */
    CANCELLATION("1");

    /**
     *
     */

    private String code;

    private ManagerInfoStatusEnum(String code) {
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
