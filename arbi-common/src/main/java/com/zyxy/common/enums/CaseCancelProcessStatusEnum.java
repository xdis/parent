package com.zyxy.common.enums;
/**
 * 案件取消流程状态枚举
 */
public enum CaseCancelProcessStatusEnum {
	
	/**
	 *  等待仲裁员出具撤案决定书(审核中也是这个状态)
	 */
	WAIT_DECISION("0"," 等待仲裁员出具撤案决定书(审核中也是这个状态)"),
	
	/**
	 * 完成
	 */
	FINISH("1","完成")
	
	;
	private String value;
	
	private String remark;

	private CaseCancelProcessStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}
	
}
