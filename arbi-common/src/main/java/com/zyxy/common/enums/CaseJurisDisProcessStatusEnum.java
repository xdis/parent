package com.zyxy.common.enums;

/**
 *  等待仲裁员出具管辖权异议决定书(审核中也是这个状态)
 */
public enum CaseJurisDisProcessStatusEnum {
	
	/**
	 * 等待仲裁员出具管辖权异议决定书(审核中也是这个状态)
	 */
	WAIT_DECISION("0","等待仲裁员出具管辖权异议决定书(审核中也是这个状态)"),
	
	/**
	 * 完成
	 */
	FINISH("1","完成")
	
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private CaseJurisDisProcessStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
	
}
