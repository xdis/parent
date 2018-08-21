package com.zyxy.common.vo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 变更仲裁请求审核VO
 * @author Administrator
 *
 */
@ApiModel(value="变更仲裁请求审核VO")
public class AhangeCounterclaimtVO {
	
	
	//案件基本信息
    @ApiModelProperty("案件基本信息对象")
    private ArbitratorCaseBaseInfoVO  arbitratorCaseBaseInfo ;
    
    //变更请求内容信息
    @ApiModelProperty("变更请求内容信息")
    private ChangeRequestContentVO  changeRequestContentVO ;
    
    // 案件请求基本信息对象
    @ApiModelProperty("案件请求基本信息对象")
    private CaseRequestInfoVO caseRequestInfoVO;
    
    //审批记录列表
    @ApiModelProperty("审批记录列表")
    private List<ApproveRecordVO> approveRecordList ;
    
    //所有已通过的变更仲裁请求，应补缴的费用
    @ApiModelProperty("已通过的应缴费List")
    private List<BigDecimal> paymentShouldBeList;
    
    //当前登录仲裁委身份
    @ApiModelProperty("当前登录仲裁委身份")
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

	public ArbitratorCaseBaseInfoVO getArbitratorCaseBaseInfo() {
		return arbitratorCaseBaseInfo;
	}

	public void setArbitratorCaseBaseInfo(
			ArbitratorCaseBaseInfoVO arbitratorCaseBaseInfo) {
		this.arbitratorCaseBaseInfo = arbitratorCaseBaseInfo;
	}

	public ChangeRequestContentVO getChangeRequestContentVO() {
		return changeRequestContentVO;
	}

	public void setChangeRequestContentVO(
			ChangeRequestContentVO changeRequestContentVO) {
		this.changeRequestContentVO = changeRequestContentVO;
	}

	public CaseRequestInfoVO getCaseRequestInfoVO() {
		return caseRequestInfoVO;
	}

	public void setCaseRequestInfoVO(CaseRequestInfoVO caseRequestInfoVO) {
		this.caseRequestInfoVO = caseRequestInfoVO;
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

	public List<BigDecimal> getPaymentShouldBeList() {
		return paymentShouldBeList;
	}

	public void setPaymentShouldBeList(List<BigDecimal> paymentShouldBeList) {
		this.paymentShouldBeList = paymentShouldBeList;
	}

	public String getApproveDuties() {
		return approveDuties;
	}

	public void setApproveDuties(String approveDuties) {
		this.approveDuties = approveDuties;
	}


	
	

	
	
	
    
}
