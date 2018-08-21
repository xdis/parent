package com.zyxy.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("仲裁员提问")
public class ArbitratorQuestionDTO {
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message = "案件ID不为空")
	private String caseId;
	
	/**
	 * 当前用户id
	 */
	@ApiModelProperty("当前用户id")
	private String userId;
	
	List<QuestionInfoDTO> questions;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<QuestionInfoDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionInfoDTO> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "ArbitratorQuestionDTO [caseId=" + caseId + ", userId=" + userId
				+ ", questions=" + questions + "]";
	}

	
}
