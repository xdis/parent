package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 变更文书DTO
 */
@ApiModel("变更文书DTO")
public class DelayedReplyDTO extends BaseDTO {

    /**
     * 案件ID
     */
    @ApiModelProperty(value = "案件ID")
    @NotNull(message = "案件ID不为空")
    private String caseId;
    
    /**
	 * 延期原因
	 */
	@ApiModelProperty("延期原因")
    @NotNull(message="答辩延期原因")
	private String delayReason;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

	public String getDelayReason() {
		return delayReason;
	}

	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}

	@Override
	public String toString() {
		return "DelayedReplyDTO [caseId=" + caseId + ", delayReason="
				+ delayReason + "]";
	}
	
}
