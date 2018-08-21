package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * 案件审批基本信息
 * @author Administrator
 *
 */
@ApiModel("案件审批基本信息")
public class InitiateAuditVO {
   
	//案件基本信息
    @ApiModelProperty("案件基本信息对象")
    private ArbitratorCaseBaseInfoVO  arbitratorCaseBaseInfo ;
  
    //证据清单列表
    @ApiModelProperty("证据清单列表")
    private List<EvidenceVO> evidenceList ;
  
    // 案件请求基本信息对象
    @ApiModelProperty("案件请求基本信息对象")
    private CaseRequestInfoVO caseRequestInfoVO;


    //审批记录列表
    @ApiModelProperty("审批记录列表")
    private List<ApproveRecordVO> approveRecordList ;
    
    //当前登录仲裁委身份
    @ApiModelProperty("当前仲裁委身份")
    private String duties;
    
   
    //获取当前案件的审批id
    @ApiModelProperty("审批Id")
    private String approveId;
    
    //获取当前案件id
    @ApiModelProperty("案件Id")
    private String caseId;
    
    //审批表中当前案件仲裁委身份
    @ApiModelProperty("审批表中当前案件仲裁委身份")
    private String approveDuties;


    /**
     * 案件公共流程信息
     */
    @ApiModelProperty(value = "案件公共流程信息")
    private CaseCommProgressInfoVO caseProgressInfo;


    //案件仲裁委信息
    private CaseArbitrationPersonnelInfoVO arbiInfo;

    /**
     * 案件审批
     */
    private List<CaseApproveVO> caseApproveVoList;

    public ArbitratorCaseBaseInfoVO getArbitratorCaseBaseInfo() {
        return arbitratorCaseBaseInfo;
    }

    public void setArbitratorCaseBaseInfo(ArbitratorCaseBaseInfoVO arbitratorCaseBaseInfo) {
        this.arbitratorCaseBaseInfo = arbitratorCaseBaseInfo;
    }

 

    public List<EvidenceVO> getEvidenceList() {
        return evidenceList;
    }

    public void setEvidenceList(List<EvidenceVO> evidenceList) {
        this.evidenceList = evidenceList;
    }

    public List<ApproveRecordVO> getApproveRecordList() {
        return approveRecordList;
    }

    public void setApproveRecordList(List<ApproveRecordVO> approveRecordList) {
        this.approveRecordList = approveRecordList;
    }

	public CaseRequestInfoVO getCaseRequestInfoVO() {
		return caseRequestInfoVO;
	}

	public void setCaseRequestInfoVO(CaseRequestInfoVO caseRequestInfoVO) {
		this.caseRequestInfoVO = caseRequestInfoVO;
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

    public CaseCommProgressInfoVO getCaseProgressInfo() {
        return caseProgressInfo;
    }

    public void setCaseProgressInfo(CaseCommProgressInfoVO caseProgressInfo) {
        this.caseProgressInfo = caseProgressInfo;
    }

    public CaseArbitrationPersonnelInfoVO getArbiInfo() {
        return arbiInfo;
    }

    public void setArbiInfo(CaseArbitrationPersonnelInfoVO arbiInfo) {
        this.arbiInfo = arbiInfo;
    }


    public List<CaseApproveVO> getCaseApproveVoList() {
        return caseApproveVoList;
    }

    public void setCaseApproveVoList(List<CaseApproveVO> caseApproveVoList) {
        this.caseApproveVoList = caseApproveVoList;
    }
}
