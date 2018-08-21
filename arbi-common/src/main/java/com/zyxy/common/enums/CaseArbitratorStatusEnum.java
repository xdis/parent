package com.zyxy.common.enums;


/**
 * 案件仲裁员关系状态Enum
 */
public enum CaseArbitratorStatusEnum {
	/**
	 * 待受理
	 */
	WAIT_ACCEPT("0"),
	/**
	 * 不受理
	 */
	NOT_ACCEPT("1"),
	/**
	 * 有效
	 */
	OK("2"),
	/**
	 * 回避
	 */
	AVOID("3");
	private String code;

	private CaseArbitratorStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static CaseArbitratorStatusEnum getCode(String code) {
		for (CaseArbitratorStatusEnum c : CaseArbitratorStatusEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
