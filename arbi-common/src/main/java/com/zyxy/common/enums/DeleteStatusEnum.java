package com.zyxy.common.enums;


/**
 * 是否删除枚举类Enum
 */
public enum DeleteStatusEnum {
	/**
	 * 不删除
	 */
	NORMAL("0"),
	/**
	 * 删除
	 */
	DELETE("1");
	
	private String code;

	private DeleteStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static DeleteStatusEnum getCode(String code) {
		for (DeleteStatusEnum c : DeleteStatusEnum.values()) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		return null;
	}
}
