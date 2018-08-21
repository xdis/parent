package com.zyxy.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 管辖权异议VO
 *
 */
public class ArbiCaseJurisDisVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 案件id
	 */
	private String caseId;

	/**
	 * 案号
	 */
	private String caseNo;
	/**
	 * 申请人名称
	 */
	private String propName;

	/**
	 * 被申请人姓名
	 */
	private String defePropName;

	/**
	 * 仲裁协议签订方式
	 * 0-合同约定仲裁条款
	 * 1-单独仲裁协议
	 */
	private String signAbriProtocolMode;

	/**
	 * 协议签订时间
	 */
	private Date signTime;

	/**
	 * 协议名称
	 */
	private String protocolName;

	/**
	 * 案件受理时间
	 */
	private Date caseAcceptanceTime;

	/**
	 * 案由
	 */
	private String caseTypeId;


	/**
	 * 仲裁请求
	 */
	private String arbClaim;

	/**
	 * 管辖权异议记录id
	 */
	private String jurisDisId;

	/**
	 * 管辖权异议申请时间
	 */
	private Date createTime;

	/**
	 * 管辖权异议请求事项
	 */
	private String requestItem;


	/**
	 * 管辖权异议事实与理由
	 */
	private String reason;


	/**
	 * 管辖权异议反馈
	 */
	private String feedBack;


	/**
	 * 仲裁员名字
	 */
	private String arbitratorName;


	/**
	 * 组庭通知书时间
	 */
	private Date tribunalNoticeCreateTime;

	/**
	 * 当前登录人职务
	 */
	private String duties;

	/**
	 * 变更仲裁请求时间
	 */
	private Date caseChangeTime;

	/**
	 * 变更仲裁请求的仲裁请求
	 */
	private String caseChangeRequest;


	/**
	 * 秘书姓名
	 */
	private String secretaryName;

	/**
	 * 当前审批状态
	 */
	private String caseApproveStatus;

	/**
	 * 组庭标志
	 */
	private String tribunalMark;

	/**
	 * 审批权限
	 */
	private String primiss;

	/**
	 * 是否回避过
	 */
	private String isApplyAvoid;

	/**
	 * 请求id
	 */
	private String requestId;

	/**
	 * 请求类型
	 */
	private String requestType;

	/**
	 * 管辖权异议申请人名字
	 */
	private String applyName;


	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getDefePropName() {
		return defePropName;
	}

	public void setDefePropName(String defePropName) {
		this.defePropName = defePropName;
	}

	public String getSignAbriProtocolMode() {
		return signAbriProtocolMode;
	}

	public void setSignAbriProtocolMode(String signAbriProtocolMode) {
		this.signAbriProtocolMode = signAbriProtocolMode;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public Date getCaseAcceptanceTime() {
		return caseAcceptanceTime;
	}

	public void setCaseAcceptanceTime(Date caseAcceptanceTime) {
		this.caseAcceptanceTime = caseAcceptanceTime;
	}

	public String getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(String caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public String getArbClaim() {
		return arbClaim;
	}

	public void setArbClaim(String arbClaim) {
		this.arbClaim = arbClaim;
	}

	public String getJurisDisId() {
		return jurisDisId;
	}

	public void setJurisDisId(String jurisDisId) {
		this.jurisDisId = jurisDisId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}


	public String getArbitratorName() {
		return arbitratorName;
	}

	public void setArbitratorName(String arbitratorName) {
		this.arbitratorName = arbitratorName;
	}

	public Date getTribunalNoticeCreateTime() {
		return tribunalNoticeCreateTime;
	}

	public void setTribunalNoticeCreateTime(Date tribunalNoticeCreateTime) {
		this.tribunalNoticeCreateTime = tribunalNoticeCreateTime;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}


	public Date getCaseChangeTime() {
		return caseChangeTime;
	}

	public void setCaseChangeTime(Date caseChangeTime) {
		this.caseChangeTime = caseChangeTime;
	}

	public String getCaseChangeRequest() {
		return caseChangeRequest;
	}

	public void setCaseChangeRequest(String caseChangeRequest) {
		this.caseChangeRequest = caseChangeRequest;
	}

	public String getSecretaryName() {
		return secretaryName;
	}

	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}

	public String getCaseApproveStatus() {
		return caseApproveStatus;
	}

	public void setCaseApproveStatus(String caseApproveStatus) {
		this.caseApproveStatus = caseApproveStatus;
	}

	public String getTribunalMark() {
		return tribunalMark;
	}

	public void setTribunalMark(String tribunalMark) {
		this.tribunalMark = tribunalMark;
	}

	public String getPrimiss() {
		return primiss;
	}

	public void setPrimiss(String primiss) {
		this.primiss = primiss;
	}


	public String getIsApplyAvoid() {
		return isApplyAvoid;
	}

	public void setIsApplyAvoid(String isApplyAvoid) {
		this.isApplyAvoid = isApplyAvoid;
	}


	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
}
