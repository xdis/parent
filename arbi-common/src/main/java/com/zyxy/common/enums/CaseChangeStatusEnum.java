package com.zyxy.common.enums;

/**
 *	变更仲裁请求状态枚举类
 */
public enum CaseChangeStatusEnum {
	
	/**
	 * 待审核状态
	 */
	WAIT_AUDIT("0","待审核"),
	
	/**
	 * 审核成功状态
	 */
	SUCCESS_AUDIT("1","审核成功"),
	
	/**
	 * 审核失败状态
	 */
    FAIL_AUDIT("2", "审核失败"),

    /**
     * 待缴费
     */
    WAIT_PAY("3", "待缴费"),

    /**
     * 缴费超时
     */
    PAY_ERROR("4", "缴费超时"),;

    private String value;
	private String remark;
	private CaseChangeStatusEnum(String value, String remark) {
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
