package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.ManagerInfo;

@ApiModel(value="调解书审核相关信息")
public class ConciliationBookVO {
	@ApiModelProperty(value = "当前登录人信息")
	private ManagerInfo managerInfo;
	
	@ApiModelProperty(value = "案件文书对象")
	private CaseDocumentsVO caseDocumentsVO;
	
    @ApiModelProperty("审批记录列表")
    private List<ApproveRecordVO> approveRecordList ;
    
	@ApiModelProperty(value = "申请人的代理人")
	private CaseAgentVO caseAgentVO;
	
	@ApiModelProperty(value = "被申请人的代理人")
	private CaseAgentVO caseAgentsVO;
	
	@ApiModelProperty(value = "调解书协议")
	private CaseProtocolRecordVO caseProtocolRecordVO;
	
    @ApiModelProperty("获取当前审批表审批人职务")
    private String approveDuties;
    
    @ApiModelProperty("审批Id")
    private String approveId;
    
    @ApiModelProperty("案件Id")
    private String caseId;
    
    @ApiModelProperty("案件基本信息")
    private CaseInfo caseInfo;
    
	public ManagerInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}

	public CaseAgentVO getCaseAgentVO() {
		return caseAgentVO;
	}

	public void setCaseAgentVO(CaseAgentVO caseAgentVO) {
		this.caseAgentVO = caseAgentVO;
	}

	public CaseAgentVO getCaseAgentsVO() {
		return caseAgentsVO;
	}

	public void setCaseAgentsVO(CaseAgentVO caseAgentsVO) {
		this.caseAgentsVO = caseAgentsVO;
	}

	public CaseDocumentsVO getCaseDocumentsVO() {
		return caseDocumentsVO;
	}

	public void setCaseDocumentsVO(CaseDocumentsVO caseDocumentsVO) {
		this.caseDocumentsVO = caseDocumentsVO;
	}

	public CaseProtocolRecordVO getCaseProtocolRecordVO() {
		return caseProtocolRecordVO;
	}

	public void setCaseProtocolRecordVO(CaseProtocolRecordVO caseProtocolRecordVO) {
		this.caseProtocolRecordVO = caseProtocolRecordVO;
	}

	public List<ApproveRecordVO> getApproveRecordList() {
		return approveRecordList;
	}

	public void setApproveRecordList(List<ApproveRecordVO> approveRecordList) {
		this.approveRecordList = approveRecordList;
	}

	public String getApproveDuties() {
		return approveDuties;
	}

	public void setApproveDuties(String approveDuties) {
		this.approveDuties = approveDuties;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public CaseInfo getCaseInfo() {
		return caseInfo;
	}

	public void setCaseInfo(CaseInfo caseInfo) {
		this.caseInfo = caseInfo;
	}
}
