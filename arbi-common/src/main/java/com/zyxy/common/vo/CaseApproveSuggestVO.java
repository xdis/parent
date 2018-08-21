
package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;

import com.zyxy.common.domain.CaseApproveSuggest;

/**
 * 审批记录展示vo
 */
@ApiModel(value="审批记录展示vo")
public class CaseApproveSuggestVO extends CaseApproveSuggest{
	private static final long serialVersionUID = 1L;
	/**
	 * 审批人姓名
	 */
	private String approverName;
	
	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	
}
