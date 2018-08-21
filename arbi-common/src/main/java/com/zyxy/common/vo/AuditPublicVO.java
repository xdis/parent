package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 案件审核公共对象
 */
@ApiModel(value = "案件审核公共对象")
public class AuditPublicVO {

	/**
	 * 案件请求基本信息对象
	 */
	@ApiModelProperty("案件请求基本信息对象")
	private CaseRequestInfoVO caseRequestInfoVO;

	/**
	 * 审批记录List对象
	 */
	@ApiModelProperty("审批记录List对象")
	private List<ApproveRecordVO> approveRecordVOList;

	public CaseRequestInfoVO getCaseRequestInfoVO() {
		return caseRequestInfoVO;
	}

	public void setCaseRequestInfoVO(CaseRequestInfoVO caseRequestInfoVO) {
		this.caseRequestInfoVO = caseRequestInfoVO;
	}

	public List<ApproveRecordVO> getApproveRecordVOList() {
		return approveRecordVOList;
	}

	public void setApproveRecordVOList(List<ApproveRecordVO> approveRecordVOList) {
		this.approveRecordVOList = approveRecordVOList;
	}

}
