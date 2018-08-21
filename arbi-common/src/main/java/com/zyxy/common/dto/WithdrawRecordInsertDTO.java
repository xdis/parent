package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 撤案申请DTO
 */
@ApiModel(value="撤案申请DTO")
public class WithdrawRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 请求标志
	 */
	@ApiParam(hidden=true)
	private String requestFlag;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	@NotNull(message="事实与理由不为空")
	private String reason;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	@NotNull(message="请求事项不为空")
	private String application;
	
	/**
	 * 当前用户user_id
	 */
	/*@ApiModelProperty("当前用户user_id")
	@NotNull(message="当前用户user_id不为空")*/
	@ApiParam(hidden=true)
	private String userId;
	

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
	 * @return the requestFlag
	 */
	public String getRequestFlag() {
		return requestFlag;
	}

	/**
	 * @param requestFlag the requestFlag to set
	 */
	public void setRequestFlag(String requestFlag) {
		this.requestFlag = requestFlag;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
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
		return "WithdrawRecordInsertDTO [caseId=" + caseId + ", requestFlag="
				+ requestFlag + ", reason=" + reason + ", application="
				+ application + ", userId=" + userId + "]";
	}
	
	
	
}
