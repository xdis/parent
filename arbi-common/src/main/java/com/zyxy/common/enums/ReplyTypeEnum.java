package com.zyxy.common.enums;

/**
 * 答辩类型枚举
 */
public enum ReplyTypeEnum {
	
	/**
	 * 请求答辩
	 */
	REQUEST("0","请求答辩"),
	
	/**
	 * 变更请求答辩
	 */
	CHANGE_REUEST("1","变更请求答辩");
	
	private String value;
	
	private String remark;

	private ReplyTypeEnum(String value, String remark) {
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
