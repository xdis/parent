package com.zyxy.common.enums;

/**
 *	案件回避方式
 */
public enum CaseAvoidStyleEnum {

	/**
	 * 申请方人
	 */
	PROPOSER_APPLIED("0","申请方人回避"),
	
	/**
	 * 被申请方
	 */
	DEFENDANT_APPLIED("1","被申请人回避"),
	
	/**
	 * 自己回避
	 */
	SELF_APPLIED("2","自己回避")
	;
	
	private String value;
	
	private String remark;

	private CaseAvoidStyleEnum(String value, String remark) {
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
