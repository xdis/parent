package com.zyxy.common.enums;

/**
 * 撤案消息枚举
 */
public enum WithdrawMessageEnum {
	
	PROPOSER_WITHDRAW("申请人已撤回仲裁请求"),
	
	PROPOSER_WITHDRAW_AND_DEFENDANT_GO_ON("申请人已撤回仲裁申请，反请求继续"),
	
	PROPOSER_GO_ON_AND_DEFENDANT_WITHDRAW("本请求继续，被申请人已撤回反请求申请"),
	
	BOTH_WITHDRAW("申请人已撤回仲裁请求，被申请人已撤回反请求申请")
	;
	private String msg;

	public String getMsg() {
		return msg;
	}

	private WithdrawMessageEnum(String msg) {
		this.msg = msg;
	}
}
