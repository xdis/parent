package com.zyxy.common.enums;

/**
 *	问答枚举
 */
public enum QuizObjectEnum {
	
	PROPOSER("0","申请方"),
	
	DEFENDANT("1","被申请方"),
	
	BOTH("2","双方当事人");
	
	private String value;
	
	private String remark;

	private QuizObjectEnum(String value, String remark) {
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
