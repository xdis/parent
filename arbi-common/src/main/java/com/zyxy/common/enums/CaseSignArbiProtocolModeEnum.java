package com.zyxy.common.enums;

/**
 * 案件仲裁协议签订方式
 */
public enum CaseSignArbiProtocolModeEnum {
	
	
	SIGN_AGREEMENT("0","合同约定仲裁条款"),
	
	SIGE_ARBI_PROTOCOL("1","单独仲裁协议")
	
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private CaseSignArbiProtocolModeEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
