package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 答辩书
 */
@ApiModel("答辩书DTO")
public class ReplyDocDTO {

	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String CaseId;
	
	@ApiModelProperty("答辩书类型0请求答辩书1变更请求答辩书")
	@NotNull(message="答辩书类型不为空")
	@Pattern(regexp="[01]",message="答辩书类型出错")
	private String type;
	
	@ApiParam(hidden=true)
	private String userId;

	public String getCaseId() {
		return CaseId;
	}

	public void setCaseId(String caseId) {
		CaseId = caseId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReplyDocDTO [CaseId=" + CaseId + ", type=" + type + ", userId="
				+ userId + "]";
	}
	
}
