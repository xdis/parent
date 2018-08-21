package com.zyxy.common.enums;

/**
 * 当事人四要素验证状态Enum
 */
public enum LitigantElementVerifyStatusEnum {

	/**
	 * 通过
	 */
	GET_THROUGH("0"),

	/**
	 * 不通过
	 */
	NOT_THROUGH("1");

	private String code;

	private LitigantElementVerifyStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
