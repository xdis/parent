package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.AdjudicationAmendmentRecordWithBLOBs;
/**
 * 补正书内容
 */
@ApiModel(value="补正书内容")
public class AmendmentContentVO {
	/**
	 * 仲裁委审核意见
	 */
	@ApiModelProperty(value="仲裁委审核意见")
	private List<CaseApproveSuggestVO> caseApproveSuggests;
	
	/**
	 * 当前身份
	 */
	@ApiModelProperty(value="当前身份")
	private String currentDuties;
	
	/**
	 * 裁决补正记录
	 */
	@ApiModelProperty(value="裁决补正记录")
	private List<AdjudicationAmendmentRecordWithBLOBs> adjudicationAmendentRecords;
	
	/**
	 * 历史补正记录
	 */
	@ApiModelProperty(value="文书内容")
	private List<HistoryAmendRecordVO> adjudicationAmendentHistoryRecords;

	/**
	 * 当前审批补正记录
	 */
	@ApiModelProperty(value="当前补正记录")
	private AdjudicationAmendmentRecordWithBLOBs adjudicationAmendmentRecord;
	
	/**
	 * 案件基本信息
	 */
	@ApiModelProperty(value="案件基本信息")
	private CaseBaseInfoVO caseBaseInfo;
	
	/**
	 * 文书内容
	 */
	private CaseDocContentVO caseDocContent;
	
	/**
	 * 审批id
	 */
	@ApiModelProperty(value="审批id")
	private String approveId;
	
	/**
	 * 裁决补正记录分页
	 */
	@ApiModelProperty(value="裁决补正记录分页")
	private PageInfo<AdjudicationAmendmentRecordWithBLOBs> pageInfoAdjudication;
	
	/**
	 * 裁决补正记录对象
	 */
	@ApiModelProperty(value="裁决补正记录对象")
	private AdjudicationAmendmentRecordWithBLOBs adjudicationWithBLOBs;

	public List<CaseApproveSuggestVO> getCaseApproveSuggests() {
		return caseApproveSuggests;
	}

	public void setCaseApproveSuggests(
			List<CaseApproveSuggestVO> caseApproveSuggests) {
		this.caseApproveSuggests = caseApproveSuggests;
	}

	public String getCurrentDuties() {
		return currentDuties;
	}

	public void setCurrentDuties(String currentDuties) {
		this.currentDuties = currentDuties;
	}

	public List<HistoryAmendRecordVO> getAdjudicationAmendentHistoryRecords() {
		return adjudicationAmendentHistoryRecords;
	}

	public void setAdjudicationAmendentHistoryRecords(
			List<HistoryAmendRecordVO> adjudicationAmendentHistoryRecords) {
		this.adjudicationAmendentHistoryRecords = adjudicationAmendentHistoryRecords;
	}

	public AdjudicationAmendmentRecordWithBLOBs getAdjudicationAmendmentRecord() {
		return adjudicationAmendmentRecord;
	}

	public void setAdjudicationAmendmentRecord(
			AdjudicationAmendmentRecordWithBLOBs adjudicationAmendmentRecord) {
		this.adjudicationAmendmentRecord = adjudicationAmendmentRecord;
	}

	public CaseBaseInfoVO getCaseBaseInfo() {
		return caseBaseInfo;
	}

	public void setCaseBaseInfo(CaseBaseInfoVO caseBaseInfo) {
		this.caseBaseInfo = caseBaseInfo;
	}

	public CaseDocContentVO getCaseDocContent() {
		return caseDocContent;
	}

	public void setCaseDocContent(CaseDocContentVO caseDocContent) {
		this.caseDocContent = caseDocContent;
	}

	public List<AdjudicationAmendmentRecordWithBLOBs> getAdjudicationAmendentRecords() {
		return adjudicationAmendentRecords;
	}

	public void setAdjudicationAmendentRecords(
			List<AdjudicationAmendmentRecordWithBLOBs> adjudicationAmendentRecords) {
		this.adjudicationAmendentRecords = adjudicationAmendentRecords;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public PageInfo<AdjudicationAmendmentRecordWithBLOBs> getPageInfoAdjudication() {
		return pageInfoAdjudication;
	}

	public void setPageInfoAdjudication(
			PageInfo<AdjudicationAmendmentRecordWithBLOBs> pageInfoAdjudication) {
		this.pageInfoAdjudication = pageInfoAdjudication;
	}

	public AdjudicationAmendmentRecordWithBLOBs getAdjudicationWithBLOBs() {
		return adjudicationWithBLOBs;
	}

	public void setAdjudicationWithBLOBs(
			AdjudicationAmendmentRecordWithBLOBs adjudicationWithBLOBs) {
		this.adjudicationWithBLOBs = adjudicationWithBLOBs;
	}
}
