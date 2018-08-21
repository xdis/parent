package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 仲裁委撤销申请书内容
 */
@ApiModel(value="仲裁委撤销申请书内容")
public class ArbitrationCaseWithdrawApplyVO {
	/**
	 * 当时人信息
	 */
	@ApiModelProperty(value="案件基本信息")
	LitigantCaseBaseInfoVO caseBaseInfo;
	
	/**
	 * 申请事项
	 */
	@ApiModelProperty(value="申请事项")
	private String application;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty(value="事实与理由")
	private String fact;
	
	/**
	 * 理由(已删除)
	 */
	@ApiParam(hidden=true)
	private String reason;
	
	public LitigantCaseBaseInfoVO getCaseBaseInfo() {
		return caseBaseInfo;
	}

	public void setCaseBaseInfo(LitigantCaseBaseInfoVO caseBaseInfo) {
		this.caseBaseInfo = caseBaseInfo;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}