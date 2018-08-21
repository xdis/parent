package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 补正仲裁员审核DTO
 */
@ApiModel("补正仲裁员审核")
public class AdjudiAmendRecordAuditDTO {
	
	/**
	 * 补正记录ID
	 */
	@ApiModelProperty(value="补正记录ID")
	@NotNull(message="补正记录ID不为空")
	private String id;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty(value="案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 用户userId
	 */
	@ApiModelProperty(value="用户userId")
	@NotNull(message="用户userId不为空")
	private String userId;
	
	/**
	 * 审核状态
	 */
	@ApiModelProperty(value="审核状态 1通过 2不通过")
	@NotNull(message="审核状态不为空")
	@Pattern(regexp=RegexpConstant.ARBITRATOR_ACCEPT_STATUS_REGEX,message="审核状态出错")
	private String status;

    /**
     * 补正内容
     */
    @ApiModelProperty(value = "补正内容")
    private String content;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdjudiAmendRecordAuditDTO [id=" + id + ", caseId=" + caseId
				+ ", userId=" + userId + "]";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
