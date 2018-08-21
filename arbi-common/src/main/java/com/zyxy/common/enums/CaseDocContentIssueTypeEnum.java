package com.zyxy.common.enums;
/**
 * 案件文书内容出具类型枚举类
 */
public enum CaseDocContentIssueTypeEnum {
	/** 同意模板 **/
	AGREE_MODULE(0,"同意模板"),
	/** 不同意模板 **/
	DISAGREE_MODULE(1,"不同意模板");
	
	private Integer code;
	private String mark;
	
	private CaseDocContentIssueTypeEnum(Integer code,String mark){
		this.code = code;
		this.mark = mark;
	}

	public Integer getCode() {
		return code;
	}

	public String getMark() {
		return mark;
	}
}
