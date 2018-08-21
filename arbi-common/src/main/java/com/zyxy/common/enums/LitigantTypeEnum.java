package com.zyxy.common.enums;

/**
 * 
 * 当事人身份枚举
 */
public enum LitigantTypeEnum {
	
	/**
	 * 申请人
	 */
	PROPESER("0","申请人"),
	
	/**
	 * 被申请人
	 */
	DEFENDANT("1","被申请人"),
	
	/**
	 * 代理
	 */
	AGENT("2","代理"),

	/**
	 *
	 */
	PROPESER_AGENT("3","申请人代理"),


	/**
	 *
	 */
	DEFENDANT_AGENT("4","被申请人代理");



	
	private String value;
	
	private String remark;

	private LitigantTypeEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}


	public static LitigantTypeEnum getCode(String value) {
		for (LitigantTypeEnum c : LitigantTypeEnum.values()) {
			if (c.getValue().equals(value)) {
				return c;
			}
		}
		return null;
	}
	
	
	
}
