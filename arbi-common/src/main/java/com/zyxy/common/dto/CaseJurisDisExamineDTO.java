package com.zyxy.common.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 管辖权异议审核DTO
 */
@ApiModel(value="管辖权异议审核DTO")
public class CaseJurisDisExamineDTO extends BaseDTO{

    /**
     * 管辖权异议id
     */
    @NotNull(message="管辖权异议id不能为空")
    @ApiModelProperty(value="管辖权异议id")
    private String caseJurisId;

    /**
     * 案件id
     */
    @NotNull(message="案件id不能为空")
    @ApiModelProperty(value="案件id")
    private String caseId;

    /**
     * 请求id
     */
    @NotNull(message="请求id不能为空")
    @ApiModelProperty(value="请求id")
    private String requestId;

    /**
     * 不通过原因
     */
    @ApiModelProperty(value="不通过原因")
    private String failReason;

    /**
     * 意见状态
     */
    @NotNull(message="意见状态")
    @ApiModelProperty(value="意见状态")
    private String opinionStatus;

    /**
     * 审批人userId
     */
    @NotNull(message="审批人userId不能为空")
    @ApiModelProperty(value="审批人userId")
    private String approveUserId;

    /**
     * 审批类型不能为空
     */
    @NotNull(message="审批类型不能为空")
    @ApiModelProperty(value="审批类型不能为空")
    private String approveType;
    
    /**
     * 审批id
     */
    @ApiModelProperty(value="审批id")
    private String approveId;

    public String getCaseJurisId() {
        return caseJurisId;
    }

    public void setCaseJurisId(String caseJurisId) {
        this.caseJurisId = caseJurisId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getOpinionStatus() {
		return opinionStatus;
	}

	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}

	public String getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(String approveUserId) {
        this.approveUserId = approveUserId;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}
    
}
