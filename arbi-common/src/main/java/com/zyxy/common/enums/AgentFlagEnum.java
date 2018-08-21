package com.zyxy.common.enums;

/**
 * 代理类型枚举
 *
 */
public enum AgentFlagEnum {
	
	/**
	 * 本人
	 */
	SELF("0","本人"),
	
	/**
	 * 代理
	 */
	AGENT("1","代理");
	
	private String value;
	
	private String remark;

	private AgentFlagEnum(String value, String remark) {
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
