package com.zyxy.common.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;
/**
 *	问题详情
 */
public class QuestionInfoDTO {
	
	/**
	 * 案件ID
	 */
	@ApiParam(hidden=true)
	private String id;
	
	/**
	 * 提问对象
	 */
	@ApiModelProperty("提问对象0-申请方 1-被申请方 2-双方当事人")
	@NotNull(message="提问对象不为空")
	@Pattern(regexp=RegexpConstant.ARBITRATOR_QUSETION_OBJECT,message="提问对象出错")
	private String quizObject;
	
	/**
	 * 提问内容
	 */
	@ApiModelProperty("提问内容")
	@NotNull(message="提问内容不为空")
	private String quizContent;

	public String getQuizObject() {
		return quizObject;
	}

	public void setQuizObject(String quizObject) {
		this.quizObject = quizObject;
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

	@Override
	public String toString() {
		return "QuestionInfoDTO [id=" + id + ", quizObject=" + quizObject
				+ ", quizContent=" + quizContent + "]";
	}
	
	
}
