package com.zyxy.common.enums;


import java.math.BigDecimal;

/**
 * 标的金额分割线
 */
public enum DisputeAmountEnum {

    /**
     * 标的金额分割线
     */
    AMOUNT_SPLIT(new BigDecimal(50000), "标的金额分割线");

    private BigDecimal value;

    private String remark;

    DisputeAmountEnum(BigDecimal value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static DisputeAmountEnum getByValue(String userTypeStr) {
        for (DisputeAmountEnum o : DisputeAmountEnum.values()) {
            if (o.toString().equals(userTypeStr)) {
                return o;
            }
        }
        return null;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public String getRemark() {
        return remark;
    }
}
