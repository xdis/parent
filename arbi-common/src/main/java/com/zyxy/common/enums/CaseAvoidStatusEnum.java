package com.zyxy.common.enums;

/**
 * 申请回避状态枚举
 */
public enum CaseAvoidStatusEnum {
	
	/**
	 * 待审核状态
	 */
	WAIT_AUDIT("0","待审核"),
	
	/**
	 * 审核成功状态
	 */
	SUCCESS_AUDIT("1","审核成功"),
	
	/**
	 * 审核失败状态
	 */
	FAIL_AUDIT("2","审核失败");
	private String value;
	private String remark;
	private CaseAvoidStatusEnum(String value, String remark) {
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
