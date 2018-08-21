package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 	申请变更仲裁请求DTO
 */
@ApiModel("申请仲裁变更请求")
public class CaseChangeRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@NotNull(message="案件ID不为空")
	@ApiModelProperty("案件ID")
	private String caseId;
	
	/**
	 * 事实与理由
	 */
	@NotNull(message="事实与理由不为空")
	@ApiModelProperty("事实与理由")
	private String factReason;
	
	/**
	 * 请求事项
	 */
	@NotNull(message="请求事项不为空")
	@ApiModelProperty("请求事项")
	private String changeRequest; 
	
	/**
	 * 申请人userId
	 */
	@NotNull(message = "当前用户Id不能为空")
	@ApiModelProperty("当前用户Id")
	private String createrId;
	
	/**
	 * 请求标志
	 */
	/*@ApiModelProperty("请求标志 0正请求1反请求")
	@NotNull(message="请求标志不为空")
	@Pattern(regexp = RegexpConstant.CASE_COUNTERCLAIM_FLAG,message="请求标志出错")*/
	@ApiParam(hidden=true)
	private String counterclaimFlag;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}

	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}
	
	/**
	 * @return the factReason
	 */
	public String getFactReason() {
		return factReason;
	}

	/**
	 * @param factReason the factReason to set
	 */
	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	/**
	 * @return the changeRequest
	 */
	public String getChangeRequest() {
		return changeRequest;
	}

	/**
	 * @param changeRequest the changeRequest to set
	 */
	public void setChangeRequest(String changeRequest) {
		this.changeRequest = changeRequest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CaseChangeRecordInsertDTO [caseId=" + caseId
				+ ",  factReason="
				+ factReason + ", changeRequest=" + changeRequest
				+ ", createrId=" + createrId + ", counterclaimFlag="
				+ counterclaimFlag + "]";
	}
	
	

}
