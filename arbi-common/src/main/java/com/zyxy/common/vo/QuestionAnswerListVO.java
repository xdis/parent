package com.zyxy.common.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * 问答列表VO
 */
@ApiModel("问答列表VO")
public class QuestionAnswerListVO {

	/**
	 * 申请方问答列表
	 */
	private List<QuestionAnswerVO> propQuestionAnswers;
	
	/**
	 * 被申请方问答列表
	 */
	private List<QuestionAnswerVO> defeQuestionAnswers;

	public List<QuestionAnswerVO> getPropQuestionAnswers() {
		return propQuestionAnswers;
	}

	public void setPropQuestionAnswers(List<QuestionAnswerVO> propQuestionAnswers) {
		this.propQuestionAnswers = propQuestionAnswers;
	}

	public List<QuestionAnswerVO> getDefeQuestionAnswers() {
		return defeQuestionAnswers;
	}

	public void setDefeQuestionAnswers(List<QuestionAnswerVO> defeQuestionAnswers) {
		this.defeQuestionAnswers = defeQuestionAnswers;
	}

	@Override
	public String toString() {
		return "QuestionAnswerListVO [propQuestionAnswers="
				+ propQuestionAnswers + ", defeQuestionAnswers="
				+ defeQuestionAnswers + "]";
	}
	
}
