package com.zyxy.common.enums;

/**
 * 
 * 当事人身份枚举
 */
public enum LitigantUserTypeEnum {

	/**
	 * 个人
	 */
	PROPESER("0","个人"),

	/**
	 * 企业
	 */
	DEFENDANT("1","企业");

	private String value;

	private String remark;

	private LitigantUserTypeEnum(String value, String remark) {
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
