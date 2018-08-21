package com.zyxy.common.enums;


/**
 * 仲裁员申请修改信息状态Enum
 */
public enum ArbitratorApplyInfoUpdateEnum {
	/**
	 * 待审核
	 */
	WAIT_ACCEPT("0"),
	
	/**
	 * 审核通过
	 */
	AUDIT_APPROVAL("1"),
	
	/**
	 * 审核不通过
	 */
	NOT_ACCEPT("2");
	
	private String code;

	private ArbitratorApplyInfoUpdateEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static ArbitratorApplyInfoUpdateEnum getCode(String code) {
		for (ArbitratorApplyInfoUpdateEnum c : ArbitratorApplyInfoUpdateEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
