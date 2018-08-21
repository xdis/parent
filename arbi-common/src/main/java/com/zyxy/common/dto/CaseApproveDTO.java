package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("案件审批")
public class CaseApproveDTO {
    /**
     * 案件ID
     * @return
     */
    private String caseId;
    
    /**
     * 审批id
     */
    private String approveId;
    
    /**
     * 当前仲裁委的userId
     */
    private String userId;
    
    /**
     * 审批类型
     * @return
     */
    private String approveType;
    
    /**
     * 审批状态
     * @return
     */
    private String approveStatus;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
}
