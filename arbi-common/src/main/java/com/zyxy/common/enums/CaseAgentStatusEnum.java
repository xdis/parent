package com.zyxy.common.enums;

/**
 * 代理状态枚举
 */
public enum CaseAgentStatusEnum {
	
	/**
	 * 待接受
	 */
	WAIT_ACCEPT("0","待接受"),
	
	/**
	 * 代理中
	 */
	ON_AGENT("1","代理中"),
	
	/**
	 * 被拒绝
	 */
	BE_REFUSE("2","被拒绝"),
	;
	
	private String code;
	
	private String remark;

	public String getCode() {
		return code;
	}

	public String getRemark() {
		return remark;
	}

	private CaseAgentStatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}
	
	
}
