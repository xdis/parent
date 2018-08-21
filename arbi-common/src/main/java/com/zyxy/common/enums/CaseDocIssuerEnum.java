package com.zyxy.common.enums;

/**
 * 文书出具人枚举
 */
public enum CaseDocIssuerEnum {
	/** 仲裁秘书  **/
	ARBITRATION_SECRETARY("0","仲裁秘书"),
	
	/** 仲裁员  **/
	ARBITRATOR("1","仲裁员");
	
	private String code;
	private String mark;
	
	private CaseDocIssuerEnum(String code,String mark){
		this.code=code;
		this.mark=mark;
	}
	public String getCode() {
		return code;
	}
	public String getMark() {
		return mark;
	}
	
	public static CaseDocIssuerEnum getCode(String code){
		for(CaseDocIssuerEnum caseDocIssuerEnum: CaseDocIssuerEnum.values()){
			if(caseDocIssuerEnum.getCode().equals(code)){
				return caseDocIssuerEnum;
			}
		}
		return null;
	}
}
