package com.zyxy.common.enums;
/**
 * 审批描述枚举类
 */
public enum CaseApproveDescribeEnum {
	/** 立案秘书审核完成 **/
	INITIATE_SECRETARY_FIRST_TRIAL("立案秘书审核完成"),
	
	/** 立案部长审核完成 **/
	INITIATE_MINISTER_REVIEW("立案部长审核完成"),
	
	/** 仲裁秘书审核完成 **/
	ARBITRATION_SECRETARY_FIRST_TRIAL("仲裁秘书审核完成"),
	
	/** 仲裁部长审核完成(若部长不能驳回) **/
	ARBITRATION_MINISTER_REVIEW("仲裁部长审核完成"),
	
	/** 仲裁部长审核通过  **/
	ARBITRATION_MINISTER_PASS("仲裁部长审核通过"),
	
	/** 仲裁部长驳回 **/
	ARBITRATION_MINISTER_NO_PASS("仲裁部长驳回"),
	
	/** 仲裁部长给出修改建议 **/
	ARBITRATION_MINISTER_SUGGESTION("仲裁部长给出修改建议"),
	
	/** 副主任审核通过 **/
	DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS("副主任审核通过"),
	
	/** 副主任驳回 **/
	DEPUTY_DIRECTOR_FINAL_JUDGMENT_NO_PASS("副主任审批驳回"),
	
	/** 副主任给给出修改建议 **/
	DEPUTY_DIRECTOR_FINAL_JUDGMENT_SUGGESTION("副主任给出修改建议"),
	
	/** 主任审核通过 **/
	DIRECTOR_FINAL_JUDGMENT_PASS("主任审核通过"),
	
	/** 主任驳回 **/
	DIRECTOR_FINAL_JUDGMENT_NO_PASS("主任驳回"),
	
	/** 主任给给出修改建议 **/
	DIRECTOR_FINAL_JUDGMENT_SUGGESTION("主任给出修改建议");
	
	private String describe;
	
	private CaseApproveDescribeEnum(String describe){
		this.describe = describe;
	}
	public String getDescribe() {
		return describe;
	}
}
