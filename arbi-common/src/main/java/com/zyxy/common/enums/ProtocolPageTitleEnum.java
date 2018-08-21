package com.zyxy.common.enums;

/**
 * 调节协议申请页面标题显示枚举
 */
public enum ProtocolPageTitleEnum {
	OUR_APPLY_PROTOVOL("1","我方申请和解协议"),
	
	OPPOSITE_APPLY_PROTOCOL("2","对方申请和解协议"),

	OUR_AGREE_PROTOVOL("3","我方同意对方和解协议"),
	
	OPPOSITE_AGREE_PROTOVOL("4","对方同意我方和解协议"),
	
	OUR_REFUSE_PROTOVOL("5","我方拒绝对方和解协议"),
	
	OPPOSITE_REFUSE_PROTOVOL("6","对方拒绝我方和解协议"),	
	
	;
	private String code;
	
	private String titleName;

	private ProtocolPageTitleEnum(String code, String titleName) {
		this.code = code;
		this.titleName = titleName;
	}

	public String getCode() {
		return code;
	}

	public String getTitleName() {
		return titleName;
	}
	
}
