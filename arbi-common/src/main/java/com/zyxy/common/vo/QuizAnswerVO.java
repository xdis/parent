package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问题回答VO
 */
@ApiModel("问题回答VO")
public class QuizAnswerVO {
	
	/**
	 * 问题回答
	 */
	@ApiModelProperty("问题回答")
	private String quizAnswer;
	
	/**
	 * 回答时间
	 */
	@ApiModelProperty("回答时间")
	private String answerTime;
	
	/**
	 * 回答类型
	 */
	@ApiModelProperty("回答类型0申请人1被申请人")
	private String answerType;
	
	/**
	 * 回答ID
	 */
	@ApiModelProperty("回答ID")
	private String id;

	public String getQuizAnswer() {
		return quizAnswer;
	}

	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuizAnswerVO [quizAnswer=" + quizAnswer + ", answerTime="
				+ answerTime + ", answerType=" + answerType + ", id=" + id
				+ "]";
	}
	
}
