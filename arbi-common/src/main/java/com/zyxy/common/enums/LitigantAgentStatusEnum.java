package com.zyxy.common.enums;
/**
 * 当事人代理关系状态枚举
 */
public enum LitigantAgentStatusEnum {
	
	/**
	 * 有效的
	 */
	OK("0","有效的"),
	
	/**
	 * 失效的
	 */
	NO("1","失效的");
	
	private String code;
	
	private String remark;

	private LitigantAgentStatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public String getRemark() {
		return remark;
	}
}
