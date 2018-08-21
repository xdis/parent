package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 当事人回答
 */
@ApiModel("当事人-问答")
public class LitigantAnswerQuestionDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 申请方标志
	 */
	@ApiParam(hidden=true)
	private String litigantType;
	
	/**
	 * 当前用户user_id
	 */
	@ApiModelProperty("当前用户user_id")
	private String userId;
	
	/**
	 * 问题ID
	 */
	@ApiModelProperty("问题ID")
	@NotNull(message="问题ID不为空")
	private String id;
	
	/**
	 * 回答内容
	 */
	@ApiModelProperty("回答内容")
	@NotNull(message="回答内容不为空")
	private String quizAnswer;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getLitigantType() {
		return litigantType;
	}

	public void setLitigantType(String litigantType) {
		this.litigantType = litigantType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuizAnswer() {
		return quizAnswer;
	}

	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}

	@Override
	public String toString() {
		return "LitigantAnswerQuestionDTO [caseId=" + caseId
				+ ", litigantType=" + litigantType + ", userId=" + userId
				+ ", id=" + id + ", quizAnswer=" + quizAnswer + "]";
	}

}
