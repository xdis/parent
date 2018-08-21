package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 仲裁委案件详情vo
 */
@ApiModel(value = "仲裁委案件详情vo")
public class ArbitrationCaseArbitrationApplyVO {
	/**
	 * 案件进展
	 */
	@ApiModelProperty(value = "案件进展")
	private List<CaseProgressListVO> progressList;

	/**
	 * 案件基本信息
	 */
	@ApiModelProperty(value = "案件基本信息")
	private ArbitratorCaseBaseInfoVO caseBaseInfo;

	/**
	 * 案件证据目录
	 */
	@ApiModelProperty(value = "案件证据目录")
	private List<EvidenceVO> evidences;

	/**
	 * 审批记录
	 */
	@ApiModelProperty(value = "审批记录")
	private List<ApproveRecordVO> approveRecords;

	/**
	 * 金额相关
	 */
	@ApiModelProperty(value = "金额相关")
	private CaseAmountVO caseAmount;

	/**
	 * 案件详情左侧仲裁信息
	 */
	@ApiModelProperty(value = "案件详情左侧仲裁信息")
	private CaseArbitrationPersonnelInfoVO arbiInfo;

	/**
	 * 案件公共流程信息
	 */
	@ApiModelProperty(value = "案件公共流程信息")
	private CaseCommProgressInfoVO caseProgressInfo;

	/**
	 * 案件审批
	 */
	private List<CaseApproveVO> caseApproveVoList;

	public List<CaseProgressListVO> getProgressList() {
		return progressList;
	}

	public void setProgressList(List<CaseProgressListVO> progressList) {
		this.progressList = progressList;
	}

	public ArbitratorCaseBaseInfoVO getCaseBaseInfo() {
		return caseBaseInfo;
	}

	public void setCaseBaseInfo(ArbitratorCaseBaseInfoVO caseBaseInfo) {
		this.caseBaseInfo = caseBaseInfo;
	}

	public List<EvidenceVO> getEvidences() {
		return evidences;
	}

	public void setEvidences(List<EvidenceVO> evidences) {
		this.evidences = evidences;
	}

	public List<ApproveRecordVO> getApproveRecords() {
		return approveRecords;
	}

	public void setApproveRecords(List<ApproveRecordVO> approveRecords) {
		this.approveRecords = approveRecords;
	}

	public CaseAmountVO getCaseAmount() {
		return caseAmount;
	}

	public void setCaseAmount(CaseAmountVO caseAmount) {
		this.caseAmount = caseAmount;
	}

	public CaseArbitrationPersonnelInfoVO getArbiInfo() {
		return arbiInfo;
	}

	public void setArbiInfo(CaseArbitrationPersonnelInfoVO arbiInfo) {
		this.arbiInfo = arbiInfo;
	}

	public CaseCommProgressInfoVO getCaseProgressInfo() {
		return caseProgressInfo;
	}

	public void setCaseProgressInfo(CaseCommProgressInfoVO caseProgressInfo) {
		this.caseProgressInfo = caseProgressInfo;
	}

	public List<CaseApproveVO> getCaseApproveVoList() {
		return caseApproveVoList;
	}

	public void setCaseApproveVoList(List<CaseApproveVO> caseApproveVoList) {
		this.caseApproveVoList = caseApproveVoList;
	}
}
