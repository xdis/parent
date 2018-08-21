package com.zyxy.common.enums;

/**
 * 仲裁员选择类型 
 */
public enum ArbiChoiceRecordTypeEnum {
	
	/**
	 * 申请方
	 */
	PROPOSER_CHOICE("0","申请方"),
	
	/**
	 * 被申请方
	 */
	DEFENDANT_CHOICE("1","被申请方"),
	
	/**
	 * 系统选择
	 */
	SYS_CHOICE("2","系统选择");
	
	private String value;
	
	private String remark;

	private ArbiChoiceRecordTypeEnum(String value, String remark) {
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
