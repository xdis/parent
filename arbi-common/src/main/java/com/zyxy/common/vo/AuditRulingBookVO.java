package com.zyxy.common.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *裁决书审核信息VO
 *
 */
@ApiModel(value ="裁决书审核信息对象")
public class AuditRulingBookVO {
	//案件文书对象
	@ApiModelProperty("案件文书对象")
	private CaseDocVO caseDocVO;
	
	//审批记录列表
    @ApiModelProperty("审批记录列表")
    private List<ApproveRecordVO> approveRecordList ;
    
    //当前登录的用户身份
    @ApiModelProperty("当前登录的用户身份")
    private String duties;
   
    //获取当前案件的审批id
    @ApiModelProperty("审批Id")
    private String approveId;
    
    //获取当前案件id
    @ApiModelProperty("案件Id")
    private String caseId;
    
    //获取当前审批表审批人身份
    @ApiModelProperty("获取当前审批表审批人身份")
    private String approveDuties;

	public CaseDocVO getCaseDocVO() {
		return caseDocVO;
	}

	public void setCaseDocVO(CaseDocVO caseDocVO) {
		this.caseDocVO = caseDocVO;
	}

	public List<ApproveRecordVO> getApproveRecordList() {
		return approveRecordList;
	}

	public void setApproveRecordList(List<ApproveRecordVO> approveRecordList) {
		this.approveRecordList = approveRecordList;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
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

	public String getApproveDuties() {
		return approveDuties;
	}

	public void setApproveDuties(String approveDuties) {
		this.approveDuties = approveDuties;
	}



}
