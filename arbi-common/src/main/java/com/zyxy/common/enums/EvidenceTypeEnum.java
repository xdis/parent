package com.zyxy.common.enums;
/**
 * 证据来源类型
 */
public enum EvidenceTypeEnum {
	
	PROPOSER("0","申请人"),
	
	DEFENDANT("1","被申请人");
	
	private String value;
	
	private String remark;

	private EvidenceTypeEnum(String value, String remark) {
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
