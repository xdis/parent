package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 仲裁员回避审核返回信息对象
 */
@ApiModel(value = "仲裁员回避审核返回信息对象")
public class AvoidListVO {

	// 仲裁员回避申请书对象
	@ApiModelProperty("仲裁员回避申请书对象")
	private AvoidVO avoidVO;

	// 仲裁员回避决定书对象
	@ApiModelProperty("仲裁员回避决定书对象")
	private DocumentContentVO contentVO;

	//审批记录List对象
	@ApiModelProperty("审批记录List对象")
	private List<ApproveRecordVO> approveRecordList;
	
	
	//当前登录的仲裁委身份
    @ApiModelProperty("当前仲裁委身份")
    private String duties;
    
    //审批表中当前案件仲裁委身份
    @ApiModelProperty("审批表中当前案件仲裁委身份")
    private String approveDuties;
    
   
    //获取当前案件的审批id
    @ApiModelProperty("审批Id")
    private String approveId;
    
    //获取当前案件id
    @ApiModelProperty("案件Id")
    private String caseId;

	/**
	 * 案件仲裁员类型
	 * 0-指派
	 * 1-选定
	 */
	@ApiModelProperty("案件仲裁员类型，0-指派，1-选定")
	private String caseArbiType;

	/**
	 * 仲裁秘书分配时间
	 */
	@ApiModelProperty("仲裁秘书分配时间")
	private Date caseManagerTime;

	public AvoidVO getAvoidVO() {
		return avoidVO;
	}

	public void setAvoidVO(AvoidVO avoidVO) {
		this.avoidVO = avoidVO;
	}

	public DocumentContentVO getContentVO() {
		return contentVO;
	}

	public void setContentVO(DocumentContentVO contentVO) {
		this.contentVO = contentVO;
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

	public String getCaseArbiType() {
		return caseArbiType;
	}

	public void setCaseArbiType(String caseArbiType) {
		this.caseArbiType = caseArbiType;
	}

	public Date getCaseManagerTime() {
		return caseManagerTime;
	}

	public void setCaseManagerTime(Date caseManagerTime) {
		this.caseManagerTime = caseManagerTime;
	}
}
