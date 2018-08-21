package com.zyxy.common.enums;

/**
 * 请求类型枚举
 */
public enum RequestTypeEnum {
	/**
	 * 本请求
	 */
	REQUEST("0","本请求"),
	
	/**
	 * 反请求
	 */
	BACK_REQUEST("1","反请求");
	
	private String value;
	private String mark;
	private RequestTypeEnum(String value, String mark) {
		this.value = value;
		this.mark = mark;
	}
	public String getValue() {
		return value;
	}
	public String getMark() {
		return mark;
	}

	public static RequestTypeEnum getValue(String value) {
		for (RequestTypeEnum c : RequestTypeEnum.values()) {
			if (c.getValue().equals(value)) {
				return c;
			}
		}
		return null;
	}
	
	
}
