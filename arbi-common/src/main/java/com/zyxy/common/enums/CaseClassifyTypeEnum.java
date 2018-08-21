package com.zyxy.common.enums;


/**
 * 系统缓存类型定义
 */
public enum CaseClassifyTypeEnum {

	/**
	 * 个人可选类型
	 */
	PERSON("0"),
	/**
	 * 企业可选类型
	 */
	ENTERPRISE("1");

	private String code;

	private CaseClassifyTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
