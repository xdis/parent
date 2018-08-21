package com.zyxy.common.enums;
/**
 * 审批是否授权枚举
 */
public enum ApproveIsAuthorizedEnum {
	/**  被授权    **/
	AUTHORIZED("0","被授权"),
	
	/**  未被授权   **/
	NOT_AUTHORIZED("1","未被授权"),
	;
	private String code;
	private String mark;
	
	private ApproveIsAuthorizedEnum(String code,String mark){
		this.code = code;
		this.mark = mark;
	}

	public String getCode() {
		return code;
	}

	public String getMark() {
		return mark;
	}
	
	public static ApproveIsAuthorizedEnum getCode(String code){
		for (ApproveIsAuthorizedEnum approveIsAuthorizedEnum : ApproveIsAuthorizedEnum.values()) {
			if(approveIsAuthorizedEnum.getCode().equals(code)){
				return approveIsAuthorizedEnum;
			}
		}
		return null;
	}
}
