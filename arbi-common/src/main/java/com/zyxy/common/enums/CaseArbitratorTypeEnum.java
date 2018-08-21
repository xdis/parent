package com.zyxy.common.enums;


/**
 * 案件仲裁员关系状态Enum
 */
public enum CaseArbitratorTypeEnum {
	/**
	 * 系统指派
	 */
	SYSTEM_ASSIGN("0"),
	/**
	 * 当事人选定
	 */
	PARTY_SELECTED("1");
	private String code;

	private CaseArbitratorTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static CaseArbitratorTypeEnum getCode(String code) {
		for (CaseArbitratorTypeEnum c : CaseArbitratorTypeEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
