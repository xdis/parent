package com.zyxy.common.enums;

/**
 * 案件人员类型
 */
public enum CasePersonnelTypeEnum {

	PROPOSER("0","申请方"),
	
	DEFENDANT("1","被申请方");
	
	private String value;
	
	private String remark;

	private CasePersonnelTypeEnum(String value, String remark) {
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
