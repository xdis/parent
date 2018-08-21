package com.zyxy.common.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 *  案件本请求的信息(包括本请求信息，变更请求信息，答辩信息，缴费)
 */
@ApiModel(value="案件请求信息")
public class CaseInfoVO {
	
	private LitigantCaseInfoVO litigantCaseInfoVO;
	
	private List<CaseChangeInfoVO>  caseChangeInfos;

	/**
	 * @return the litigantCaseInfoVO
	 */
	private LitigantCaseInfoVO getLitigantCaseInfoVO() {
		return litigantCaseInfoVO;
	}

	/**
	 * @param litigantCaseInfoVO the litigantCaseInfoVO to set
	 */
	private void setLitigantCaseInfoVO(LitigantCaseInfoVO litigantCaseInfoVO) {
		this.litigantCaseInfoVO = litigantCaseInfoVO;
	}

	/**
	 * @return the caseChangeInfos
	 */
	private List<CaseChangeInfoVO> getCaseChangeInfos() {
		return caseChangeInfos;
	}

	/**
	 * @param caseChangeInfos the caseChangeInfos to set
	 */
	private void setCaseChangeInfos(List<CaseChangeInfoVO> caseChangeInfos) {
		this.caseChangeInfos = caseChangeInfos;
	}

}
