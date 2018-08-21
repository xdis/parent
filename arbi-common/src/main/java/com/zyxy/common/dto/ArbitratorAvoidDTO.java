package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 审核仲裁员回避DTO
 */
@ApiModel(value ="审核仲裁员回避")
public class ArbitratorAvoidDTO extends  AuditPublicDTO {
	
	 /**
     * 仲裁员回避id
     */
	@ApiModelProperty("仲裁员回避id")
    @NotNull(message="仲裁员回避id不能为空")
    private String id;

    /**
     * 仲裁员回避审核状态
     * 0-待审核
     * 1-审核通过
     * 2-审核未通过
     */
    @ApiModelProperty("仲裁员回避审核状态")
    @NotNull(message="仲裁员回避审核状态不能为空")
    private String status;
    
    
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
     * 审批意见
     */
    @ApiModelProperty(value="审批意见")
    private String failReason;

    /**
     * 意见状态
     */
    @NotNull(message="意见状态")
    @ApiModelProperty(value="意见状态")
    private String opinionStatus;

    /**
     * 当前审批人userId
     */
    @NotNull(message="当前审批人userId不能为空")
    @ApiModelProperty(value="当前审批人userId")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

 


}
