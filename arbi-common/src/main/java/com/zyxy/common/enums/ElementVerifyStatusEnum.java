package com.zyxy.common.enums;

/**
 * 用户四要素认证状态枚举
 */
public enum ElementVerifyStatusEnum {
	
	/**
	 * 通过
	 */
	PASS("0","通过"),
	
	/**
	 * 不通过
	 */
	NOT_PASEE("1","未通过")
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private ElementVerifyStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
