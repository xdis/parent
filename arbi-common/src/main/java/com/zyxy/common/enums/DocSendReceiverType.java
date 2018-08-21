package com.zyxy.common.enums;

import java.net.ResponseCache;

/**
 * 文书下发记录接收人类别枚举类
 */
public enum DocSendReceiverType {
    /**
     * 0-申请人
      */
    APPLICANT("0"),

    /**
     * 1-被申请人
     */
    RESPONDENT("1"),

    /**
     * 2-申请人的代理人
     */
    APPLICANT_AGNET("2"),

    /**
     * 3-被申请人的代理人
     */
    RESPONDENT_AGENT("3"),
    /**
     * 4-仲裁员
     */
    ARBITRATOR("4"),
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    DocSendReceiverType(String code) {
        this.code = code;
    }
}
