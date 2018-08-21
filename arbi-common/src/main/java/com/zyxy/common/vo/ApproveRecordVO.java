package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 审批记录对象
 */
@ApiModel(value="审批记录对象")
public class ApproveRecordVO {
    /**
     * 审批人职务
     * 
     */
	@ApiModelProperty("审批人职务")
    private String duties;
   
    /**
     * 审批状态
     * 
     */
    @ApiModelProperty("审批状态")
    private String approveStatus;
    
    /**
     * 审批标注
     */
    @ApiModelProperty(value="审批标注")
    private String mark;
    
    /**
     * 审批时间
     * 
     */
    @ApiModelProperty("审批时间")
    private Date createTime;
    /**
     * 审批意见
     *
     */
    @ApiModelProperty("审批意见")
    private String approveSuggest;

	/**
	 * 审批人姓名
	 */
	@ApiModelProperty("审批人姓名")
    private String approveName;
	
	/**
	 * 意见状态
	 */
	@ApiModelProperty(value="意见状态")
	private String opinionStatus;
	
	/**
	 * 审批id
	 */
	@ApiModelProperty("审批id")
    private String approveId;
	
	/**
	 * 业务id
	 */
	@ApiModelProperty("业务id")
	private String busiId;
	
	/**
	 * 案件id
	 */
	@ApiModelProperty("案件id")
	private String caseId;

	/**
	 * 组庭标志
	 * 0-未组庭
	 * 1-已组庭
	 */
	@ApiModelProperty("组庭标志，0-未组庭，1-已组庭")
	private String tribunalMark;
	
	

	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public String getMark() {
		return mark;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getApproveSuggest() {
		return approveSuggest;
	}
	public void setApproveSuggest(String approveSuggest) {
		this.approveSuggest = approveSuggest;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}
	public String getOpinionStatus() {
		return opinionStatus;
	}
	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}
	public String getApproveId() {
		return approveId;
	}
	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getTribunalMark() {
		return tribunalMark;
	}

	public void setTribunalMark(String tribunalMark) {
		this.tribunalMark = tribunalMark;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	
}
