package com.zyxy.common.enums;

/**
 * 文书出具类型模板枚举类
 */
public enum CaseDocIssueTypeEnum {
    /**
     * 0-同意模板
      */
    AGREE("0"),
    /**
     * 1-不同意模板
     */
    NOT_AGREE("1"),
    ;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private CaseDocIssueTypeEnum(String code) {
        this.code = code;
    }
}
