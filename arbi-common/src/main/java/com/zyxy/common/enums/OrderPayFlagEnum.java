package com.zyxy.common.enums;

/**
 *	订单支付状态枚举类 
 *
 */
public enum OrderPayFlagEnum {
	
	/**
     * 待支付
     */
    UN_PAY("0", "待支付"),
    
	/**
     * 支付成功
     */
    SUCCESS_PAY("1", "支付成功"),
    
    /**
     * 支付失败
     */
    FAIL_PAY("2","支付失败");

    
    private String value;
    private String remark;

    OrderPayFlagEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public String getRemark() {
        return remark;
    }

}
