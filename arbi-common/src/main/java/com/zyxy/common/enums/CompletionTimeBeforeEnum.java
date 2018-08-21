package com.zyxy.common.enums;

public enum CompletionTimeBeforeEnum {
	/**
	 * 审限前1天
	 */
	THE_DAY_BEFORE("1", "审限前1天"),

	/**
	 * 审限前2天
	 */
	TWO_DAYS_BEFORE("2", "审限前2天");

	private String code;

	private String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private CompletionTimeBeforeEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
}
