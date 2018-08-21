package com.zyxy.common.enums;


/**
 * 是否加入黑名单Enum
 */
public enum BlackListStatusEnum {
	/**
	 * 不加入
	 */
	NOT_TO_JOIN("0"),
	/**
	 * 加入
	 */
	JOIN_IN("1");
	
	private String code;

	private BlackListStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static BlackListStatusEnum getCode(String code) {
		for (BlackListStatusEnum c : BlackListStatusEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
