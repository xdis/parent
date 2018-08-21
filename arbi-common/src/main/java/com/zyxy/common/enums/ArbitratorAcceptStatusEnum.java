package com.zyxy.common.enums;


/**
 * 案件仲裁员关系状态Enum
 */
public enum ArbitratorAcceptStatusEnum {
	/**
	 * 接案中
	 */
	PICK_UP_CASE("0"),
	/**
	 * 不接案
	 */
	DONT_PICK_UP_CASE("1");

	private String code;

	private ArbitratorAcceptStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static ArbitratorAcceptStatusEnum getCode(String code) {
		for (ArbitratorAcceptStatusEnum c : ArbitratorAcceptStatusEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
