package com.zyxy.common.enums;

/**
 * 当事人回应方式
 */
public enum CompromiseResponseStyleEnum {
	/**
	 * 直接回应
	 */
	DIRECT("0","直接"),
	/**
	 * 中途拒绝
	 */
	HALFWAY("1","中途拒绝");
	private String value;
	
	private String remark;

	private CompromiseResponseStyleEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
}
