package com.zyxy.common.dto;

import io.swagger.annotations.ApiParam;

/**
 * 案件评论
 */
public class CaseEvaluationDTO extends BasePageDTO{
	
	/**
	 * 裁决员id
	 */
	@ApiParam(hidden=true)
	private String arbitratorId;

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}
}
