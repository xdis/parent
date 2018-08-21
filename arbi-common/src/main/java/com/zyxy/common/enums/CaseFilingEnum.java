package com.zyxy.common.enums;


/**
 * 系统缓存类型定义
 */
public enum CaseFilingEnum {

	/**
     * 个人
	 */
	PERSON("0"),
	/**
     * 代理
	 */
	AGENT("1");

	private String code;

	private CaseFilingEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
