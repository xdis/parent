package com.zyxy.common.vo;

/**
 * 当事人问题VO
 */
public class QuizRecordVO {
	
	/**
	 * 仲裁员姓名
	 */
	private String arbiName;
	
	/**
	 * 问题
	 */
	private String quizContent;
	
	/**
	 * 问题ID
	 */
	private String id;
	
	/**
	 * 提问对象
	 */
	private String quizObject;

	public String getArbiName() {
		return arbiName;
	}

	public void setArbiName(String arbiName) {
		this.arbiName = arbiName;
	}

	public String getQuizContent() {
		return quizContent;
	}

	public void setQuizContent(String quizContent) {
		this.quizContent = quizContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuizObject() {
		return quizObject;
	}

	public void setQuizObject(String quizObject) {
		this.quizObject = quizObject;
	}

	

	@Override
	public String toString() {
		return "QuizRecordVO [arbiName=" + arbiName + ", quizContent="
				+ quizContent + ",  id=" + id
				+ ", quizObject=" + quizObject + ",]";
	}
	
	
}
