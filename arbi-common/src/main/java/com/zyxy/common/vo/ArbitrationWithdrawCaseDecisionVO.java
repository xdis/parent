package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocContent;
import com.zyxy.common.domain.CaseDocContentWithBLOBs;
import com.zyxy.common.domain.WithdrawRecordWithBLOBs;

/**
 * 仲裁委-撤回案件决定书
 */
@ApiModel(value="仲裁委-撤回案件决定书")
public class ArbitrationWithdrawCaseDecisionVO {
	/**
	 * 撤案记录
	 */
	@ApiModelProperty(value="撤案记录")
	private WithdrawRecordWithBLOBs withdrawRecord;
	/**
	 * 案件文书信息
	 */
	@ApiModelProperty(value="案件文书信息")
	private CaseDoc caseDoc;
	
	/**
	 * 案件文书内容
	 */
	@ApiModelProperty(value="案件文书内容")
	private CaseDocContentWithBLOBs caseDocContent;
	
	/**
	 * 案件基本信息
	 */
	@ApiModelProperty(value="案件基本信息")
	private CaseBaseInfoVO caseBaseInfo;
	
	/**
	 * 案件公共流程信息
	 */
	@ApiModelProperty(value="案件公共流程信息")
	private CaseCommProgressInfoVO caseProgressInfo;
	
	/**
	 * 审批记录
	 */
	@ApiModelProperty(value="审批记录")
	private List<CaseApproveSuggestVO> caseApproveSuggests;
	
	/**
	 * 当前身份
	 */
	@ApiModelProperty(value="当前身份")
	private String currentDuties;
	
	/**
	 * 案件受理日期
	 */
	@ApiModelProperty(value="案件受理日期")
	private String caseAcceptTime;
	
	/**
	 * 仲裁员接受类型  0-指派，1-选定
	 */
	@ApiModelProperty(value="仲裁员接受类型  0-指派，1-选定")
	private String arbitratorAcceptType;
	
	/**
	 * 撤案类型  0-当事人撤回  1-双方撤回
	 */
	@ApiModelProperty(value="撤案类型  0-当事人撤回  1-双方撤回")
	private String withdrawCaseType;
	
	/**
	 * 审批对象
	 */
	@ApiParam(hidden = true)
	private CaseApprove caseApprove;
	
	/**
	 * 反请求撤案审批id
	 */
	@ApiParam(hidden = true)
	private String opppsiteWithdrawCaseTypeApproveId;
	
	/**
	 * 请求类型
	 */
	@ApiParam(hidden = true)
	private String requestType;
	
	/**
	 * 相反撤案记录创建时间(正请求/反请求)
	 */
	@ApiParam(hidden = true)
	private Date oppositeWithdrawRecordCreateTime;
	
	/**
	 * 组庭通知书内容
	 */
	@ApiModelProperty(value="组庭通知书内容")
	private CaseDocContent trinualNotice;
	
	/**
	 * 本请求应退费
	 */
	@ApiModelProperty(value="本请求应退费")
	private Integer requestRefund;
	
	/**
	 * 本请求仲裁费
	 */
	@ApiModelProperty(value="本请求仲裁费")
	private Integer requestArbiFee;
	
	/**
	 * 反请求应退费
	 */
	@ApiModelProperty(value="反请求应退费")
	private Integer couterclaimRefund;
	
	/**
	 * 反请求仲裁费
	 */
	@ApiModelProperty(value="反请求仲裁费")
	private Integer couterclaimArbiFee;
	public WithdrawRecordWithBLOBs getWithdrawRecord() {
		return withdrawRecord;
	}

	public void setWithdrawRecord(WithdrawRecordWithBLOBs withdrawRecord) {
		this.withdrawRecord = withdrawRecord;
	}

	public CaseDoc getCaseDoc() {
		return caseDoc;
	}

	public void setCaseDoc(CaseDoc caseDoc) {
		this.caseDoc = caseDoc;
	}

	public CaseDocContentWithBLOBs getCaseDocContent() {
		return caseDocContent;
	}

	public void setCaseDocContent(CaseDocContentWithBLOBs caseDocContent) {
		this.caseDocContent = caseDocContent;
	}

	public CaseBaseInfoVO getCaseBaseInfo() {
		return caseBaseInfo;
	}

	public void setCaseBaseInfo(CaseBaseInfoVO caseBaseInfo) {
		this.caseBaseInfo = caseBaseInfo;
	}

	public CaseCommProgressInfoVO getCaseProgressInfo() {
		return caseProgressInfo;
	}

	public void setCaseProgressInfo(CaseCommProgressInfoVO caseProgressInfo) {
		this.caseProgressInfo = caseProgressInfo;
	}

	public List<CaseApproveSuggestVO> getCaseApproveSuggests() {
		return caseApproveSuggests;
	}

	public void setCaseApproveSuggests(
			List<CaseApproveSuggestVO> caseApproveSuggests) {
		this.caseApproveSuggests = caseApproveSuggests;
	}

	public String getCurrentDuties() {
		return currentDuties;
	}

	public void setCurrentDuties(String currentDuties) {
		this.currentDuties = currentDuties;
	}

	public String getCaseAcceptTime() {
		return caseAcceptTime;
	}

	public void setCaseAcceptTime(String caseAcceptTime) {
		this.caseAcceptTime = caseAcceptTime;
	}

	public String getArbitratorAcceptType() {
		return arbitratorAcceptType;
	}

	public void setArbitratorAcceptType(String arbitratorAcceptType) {
		this.arbitratorAcceptType = arbitratorAcceptType;
	}

	public String getWithdrawCaseType() {
		return withdrawCaseType;
	}

	public void setWithdrawCaseType(String withdrawCaseType) {
		this.withdrawCaseType = withdrawCaseType;
	}

	public CaseApprove getCaseApprove() {
		return caseApprove;
	}

	public void setCaseApprove(CaseApprove caseApprove) {
		this.caseApprove = caseApprove;
	}

	public String getOpppsiteWithdrawCaseTypeApproveId() {
		return opppsiteWithdrawCaseTypeApproveId;
	}

	public void setOpppsiteWithdrawCaseTypeApproveId(
			String opppsiteWithdrawCaseTypeApproveId) {
		this.opppsiteWithdrawCaseTypeApproveId = opppsiteWithdrawCaseTypeApproveId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getOppositeWithdrawRecordCreateTime() {
		return oppositeWithdrawRecordCreateTime;
	}

	public void setOppositeWithdrawRecordCreateTime(
			Date oppositeWithdrawRecordCreateTime) {
		this.oppositeWithdrawRecordCreateTime = oppositeWithdrawRecordCreateTime;
	}

	public CaseDocContent getTrinualNotice() {
		return trinualNotice;
	}

	public void setTrinualNotice(CaseDocContent trinualNotice) {
		this.trinualNotice = trinualNotice;
	}

	public Integer getRequestRefund() {
		return requestRefund;
	}

	public void setRequestRefund(Integer requestRefund) {
		this.requestRefund = requestRefund;
	}

	public Integer getRequestArbiFee() {
		return requestArbiFee;
	}

	public void setRequestArbiFee(Integer requestArbiFee) {
		this.requestArbiFee = requestArbiFee;
	}

	public Integer getCouterclaimRefund() {
		return couterclaimRefund;
	}

	public void setCouterclaimRefund(Integer couterclaimRefund) {
		this.couterclaimRefund = couterclaimRefund;
	}

	public Integer getCouterclaimArbiFee() {
		return couterclaimArbiFee;
	}

	public void setCouterclaimArbiFee(Integer couterclaimArbiFee) {
		this.couterclaimArbiFee = couterclaimArbiFee;
	}

}