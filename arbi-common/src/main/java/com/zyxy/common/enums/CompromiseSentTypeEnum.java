package com.zyxy.common.enums;

/**
 * 和解发送方枚举
 */
public enum CompromiseSentTypeEnum {
	
	PROPOSER("0","申请方"),
	
	DEFENDANT("1","被申请方"),
	
	ARBI_SECRETARY("2","仲裁秘书"),
	
	ARBITRATOR("3","仲裁员");
	
	private String value;
	
	private String remark;

	private CompromiseSentTypeEnum(String value, String remark) {
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
