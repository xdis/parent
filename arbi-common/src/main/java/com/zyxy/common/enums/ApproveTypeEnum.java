package com.zyxy.common.enums;

/**
 * 审批类型枚举
 *
 */
public enum ApproveTypeEnum {
	
	/** 0-立案审批*/
	INITIATE_APPROVAL("INITIATE_APPROVAL","立案审批"),
	
	/**1-变更仲裁请求审批*/
	ALTERATION_ARBITRATION_REQUEST("ALTERATION_ARBITRATION_REQUEST","变更仲裁请求审批"),
	
	/** 2-反请求审批*/
	COUNTERCLAIM_APPROVAL("COUNTERCLAIM_APPROVAL","反请求审批"),
	
	/** 3-变更反请求审批 */
	ALTERATION_COUNTERCLAIM_APPROVAL("ALTERATION_COUNTERCLAIM_APPROVAL","变更反请求审批"),
	
	/** 4-管辖权异议审批*/
	JURISDICTION_OBJECTION_APPROVAL("JURISDICTION_OBJECTION_APPROVAL","管辖权异议审批"),
	
	/** 5-反请求管辖权异议审批*/
	COUNTERCLAIM_JURISDICTION_APPROVAL("COUNTERCLAIM_JURISDICTION_APPROVAL","反请求管辖权异议审批"),
	
	/** 6-秘书申请回避审批 */
	APPLY_SIDESTEP_APPROVAL("APPLY_SIDESTEP_APPROVAL","秘书申请回避审批"),
	
	/** 7-裁决书审批*/
	ARBITRAL_AWARD_APPROVAL("ARBITRAL_AWARD_APPROVAL","裁决书审批"),
	
	/** 8-决定书审批*/
	DECISION_APPROVAL("DECISION_APPROVAL","决定书审批"),
	
	/**9-调解书审批*/
	CONCILIATION_BOOK_APPROVAL("CONCILIATION_BOOK_APPROVAL","调解书审批"),
	
	/**10- 调解申请审批*/
	CONCILIATION_APPLY_APPROVAL("CONCILIATION_APPLY_APPROVAL","调解申请审批"),
	
	/**11-补正书审批*/
	CORRECTION_BOOK_APPROVAL("CORRECTION_BOOK_APPROVAL","补正书审批"),

	/**
	 * 12-仲裁员回避审核
	 */
	ARBITRATOR_AVOID_EXAMINE("ARBITRATOR_AVOID_EXAMINE","仲裁员回避审核"),

	/**
	 * 13-本请求撤案审批
	 */
	THIS_REQUEST_WITHDRAW_CASE_APPROVE("THIS_REQUEST_WITHDRAW_CASE_APPROVE","本请求撤案审批"),


	/**
	 * 14-反请求撤案审批
	 */
	COUNTER_CLAIM_CASE_APPROVE("COUNTER_CLAIM_CASE_APPROVE", "反请求撤案审批"),

	/**
	 * 15-仲裁员审批
	 */
	ARBITRATOR_APPROVE("ARBITRATOR_APPROVE", "仲裁员审批"),
	
	/**
	 * 16-案件转线下申请审批
	 */
	TURNS_OFFLINE_APPROVE("TURNS_OFFLINE_APPROVE", "案件转线下申请审批");

	private String typeName;
	
	private String typeValue;
	
	private ApproveTypeEnum(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	

	public static ApproveTypeEnum getTypeName(String typeName) {
        for (ApproveTypeEnum c : ApproveTypeEnum.values()) {
            if (c.getTypeName().equals(typeName)) {
                return c;
            }
        }
        return null;
    }
	
}
