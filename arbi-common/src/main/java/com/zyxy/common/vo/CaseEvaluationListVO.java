package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论记录VO
 */
@ApiModel("案件评论内容")
public class CaseEvaluationListVO {
	/**
	 * 案件号
	 */
	@ApiModelProperty("案件号")
	private String caseNo;
	
	/**
	 * 当事人编号
	 */
	@ApiModelProperty("当事人姓名")
	private String partyName;
	
	/**
	 * 评价等级
	 */
	@ApiModelProperty("评价等级")
	private String opinionRating;
	
	/**
	 * 评价内容
	 */
	@ApiModelProperty("评价内容")
	private String opinionContent;
	
	/**
	 * 点评时间
	 */
	@ApiModelProperty("点评时间")
	private String commentDate;
	
	/**
	 * 结案时间
	 */
	@ApiModelProperty("结案时间")
	private String completeTime;

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getOpinionRating() {
		return opinionRating;
	}

	public void setOpinionRating(String opinionRating) {
		this.opinionRating = opinionRating;
	}

	public String getOpinionContent() {
		return opinionContent;
	}

	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
}
