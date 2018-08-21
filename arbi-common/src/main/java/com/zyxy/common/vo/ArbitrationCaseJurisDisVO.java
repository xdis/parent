package com.zyxy.common.vo;

import com.zyxy.common.vo.doc.CaseDocHeadVO;

import java.util.List;

/**
 * 仲裁委管辖权异议返回对象
 */
public class ArbitrationCaseJurisDisVO {

	/**
	 * 文书头部信息
	 */
	private CaseDocHeadVO caseDocHead;

	/**
	 * 管辖权异议基本信息对象
	 */
	private ArbiCaseJurisDisVO arbiCaseJurisDisVO;

	/**
	 * 案件文书返回对象
	 */
	private DocumentContentVO documentContentVO;

	/**
	 * 审批记录List对象
	 */
	private List<ApproveRecordVO> approveRecordVOList;

	/**
	 * 案件请求基本信息对象
	 */
	private CaseRequestInfoVO caseRequestInfoVO;

	public ArbiCaseJurisDisVO getArbiCaseJurisDisVO() {
		return arbiCaseJurisDisVO;
	}

	public void setArbiCaseJurisDisVO(ArbiCaseJurisDisVO arbiCaseJurisDisVO) {
		this.arbiCaseJurisDisVO = arbiCaseJurisDisVO;
	}

	public DocumentContentVO getDocumentContentVO() {
		return documentContentVO;
	}

	public void setDocumentContentVO(DocumentContentVO documentContentVO) {
		this.documentContentVO = documentContentVO;
	}

	public List<ApproveRecordVO> getApproveRecordVOList() {
		return approveRecordVOList;
	}

	public void setApproveRecordVOList(List<ApproveRecordVO> approveRecordVOList) {
		this.approveRecordVOList = approveRecordVOList;
	}

	public CaseRequestInfoVO getCaseRequestInfoVO() {
		return caseRequestInfoVO;
	}

	public void setCaseRequestInfoVO(CaseRequestInfoVO caseRequestInfoVO) {
		this.caseRequestInfoVO = caseRequestInfoVO;
	}

	public CaseDocHeadVO getCaseDocHead() {
		return caseDocHead;
	}

	public void setCaseDocHead(CaseDocHeadVO caseDocHead) {
		this.caseDocHead = caseDocHead;
	}
}
