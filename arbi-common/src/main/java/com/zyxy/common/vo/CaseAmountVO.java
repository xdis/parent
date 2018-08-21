package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件金额相关信息
 */
@ApiModel(value="案件金额相关信息")
public class CaseAmountVO {
	/**
	 * 涉案金额
	 */
	@ApiModelProperty(value="涉案金额")
	private String caseAmount;
	
	/**
	 * 受理费
	 */
	@ApiModelProperty(value="受理费")
	private String caseAdmissibleAmount;
	
	/**
	 * 处理费
	 */
	@ApiModelProperty(value="处理费")
	private String caseHandlingAmount;
	public String getCaseAmount() {
		return caseAmount;
	}
	public void setCaseAmount(String caseAmount) {
		this.caseAmount = caseAmount;
	}
	public String getCaseAdmissibleAmount() {
		return caseAdmissibleAmount;
	}
	public void setCaseAdmissibleAmount(String caseAdmissibleAmount) {
		this.caseAdmissibleAmount = caseAdmissibleAmount;
	}
	public String getCaseHandlingAmount() {
		return caseHandlingAmount;
	}
	public void setCaseHandlingAmount(String caseHandlingAmount) {
		this.caseHandlingAmount = caseHandlingAmount;
	}
	
}
