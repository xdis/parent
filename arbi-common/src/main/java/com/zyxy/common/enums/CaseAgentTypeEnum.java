package com.zyxy.common.enums;

/**
 * 案件的代理人类型Enum
 */
public enum CaseAgentTypeEnum {

    /**案件的代理人类型**/

    /**
     * 0-申请人的代理人
     *
     */
    PROP_AGENT("0"),

    /**
     * 1-被申请人的代理人
     */
    DEFE_AGENT("1");

    /**
     *
     */

    private String code;

    private CaseAgentTypeEnum(String code) {
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
