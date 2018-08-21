package com.zyxy.common.vo;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 当事人问答VO
 */
@ApiModel("当事人问答VO")
public class QuestionAnswerVO {
	
	/**
	 * 问题ID
	 */
	@ApiModelProperty("问题ID")
	private String id;
	
	/**
	 * 问题
	 */
	@ApiModelProperty("问题")
	private String question;
	
	/**
	 * 提问时间
	 */
	@ApiModelProperty("提问时间")
	private Date questionTime;
	
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty("仲裁员姓名")
	private String arbiName;
	
	/**
	 * 问题回答
	 */
	@ApiModelProperty("问题回答")
	List<QuizAnswerVO> quizAnswers;

	public String getArbiName() {
		return arbiName;
	}

	public void setArbiName(String arbiName) {
		this.arbiName = arbiName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getQuestionTime() {
		return questionTime;
	}

	public void setQuestionTime(Date questionTime) {
		this.questionTime = questionTime;
	}
	
	public List<QuizAnswerVO> getQuizAnswers() {
		return quizAnswers;
	}

	public void setQuizAnswers(List<QuizAnswerVO> quizAnswers) {
		this.quizAnswers = quizAnswers;
	}

	@Override
	public String toString() {
		return "QuestionAnswerVO [id=" + id + ", question=" + question
				+ ", questionTime=" + questionTime + ", arbiName=" + arbiName
				+ ", quizAnswers=" + quizAnswers + "]";
	}
	
}
