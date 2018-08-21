package com.zyxy.common.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 问题回答DTO
 */
public class QuizRecordDTO {
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
		return "QuizRecordDTO [id=" + id + ", quizAnswer=" + quizAnswer + "]";
	}
	
	
	
}
