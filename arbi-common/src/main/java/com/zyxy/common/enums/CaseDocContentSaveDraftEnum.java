package com.zyxy.common.enums;
/**
 * 文书内容是否是草稿枚举
 */
public enum CaseDocContentSaveDraftEnum {
	/**
	 * 是草稿
	 */
	SAVE_AS_DRAFT("0"),
	
	/**
	 * 不是草稿
	 */
	NO_SAVE_AS_DRAFT("1");
	
	private String code;
	
	private CaseDocContentSaveDraftEnum(String code){
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
