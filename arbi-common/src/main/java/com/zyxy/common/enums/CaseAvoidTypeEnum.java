package com.zyxy.common.enums;

/**
 * 
 *	案件回避人类型
 */
public enum CaseAvoidTypeEnum {

	/**
	 * 仲裁秘书
	 */
	SECRETARY("0","仲裁秘书"),
	
	/**
	 * 仲裁员
	 */
	ARBITRATOR("1","仲裁员");
	
	private String value;
	
	private String remark;

	private CaseAvoidTypeEnum(String value, String remark) {
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
