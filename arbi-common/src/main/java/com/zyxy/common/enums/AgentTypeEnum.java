package com.zyxy.common.enums;

/**
 * 代理类型枚举
 */
public enum AgentTypeEnum {
	GENERAL_AGENT("1","一般代理"),
	
	SPECIAL_AGENT("2","特殊代理")
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private AgentTypeEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
