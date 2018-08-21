package com.zyxy.common.enums;

/**
 * 收费项用途枚举类
 */
public enum PayItemsUsagesEnum {
    /**
     * 案件处理费
     */
    CASE_HANDLING_FEE(0),

    /**
     * 案件受理费
     */
    CASE_ADMISSIBLE_FEE(1),

    
    /**
     * 案件行为收费
     */
    CASE_BEHAVIOR_FEE(2);
    

    private Integer code;

    public Integer getCode() {
        return code;
    }

    PayItemsUsagesEnum(Integer code) {
        this.code = code;
    }
}
