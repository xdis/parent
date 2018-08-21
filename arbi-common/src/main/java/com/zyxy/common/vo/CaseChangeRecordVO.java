package com.zyxy.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 变更仲裁请求VO
 *
 */
public class CaseChangeRecordVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 案件id
	 */
	private String caseId;
	/**
	 * 申请人名称
	 */
	private String propName;

	/**
	 * 申请人性别
	 */
	private String propSex;

	/**
	 * 申请人民族
	 */
	private String pronEthnic;

	/**
	 * 申请人身份证
	 */
	private String propCardId;

	/**
	 * 申请人地址
	 */
	private String propAddress;

	/**
	 * 申请人法定代表人姓名
	 */
	private String propCertName;

	/**
	 * 申请人法定代表人职务
	 */
	private String propCertDuties;

	/**
	 * 被申请人姓名
	 */
	private String defePropName;

	/**
	 * 被申请人性别
	 */
	private String defeSex;

	/**
	 * 被申请人民族
	 */
	private String defeEthnic;

	/**
	 * 被申请人身份证
	 */
	private String defeCardId;

	/**
	 * 被申请人地址
	 */
	private String defeAddress;

	/**
	 * 被申请人法定代表人
	 */
	private String defeCertName;

	/**
	 * 被申请人法定代表人职务
	 */
	private String defeCertDuties;

	/**
	 * 申请人的代理人姓名
	 */
	private String propAgentName;

	/**
	 * 申请人的代理人性别
	 */
	private String propAgentSex;

	/**
	 * 申请人的代理人身份证
	 */
	private String propAgentCardId;

	/**
	 * 申请人的代理人民族
	 */
	private String propAgentEthnic;

	/**
	 * 申请人代理人地址
	 */
	private String propAgentAddress;

	/**
	 * 被申请人的代理人名字
	 */
	private String defeAgentName;

	/**
	 * 被申请人的代理人性别
	 */
	private String defeAgentSex;

	/**
	 * 被申请人的代理人身份证
	 */
	private String defeAgentCardId;

	/**
	 * 被申请人的代理人民族
	 */
	private String defeAgentEthnic;

	/**
	 * 被申请人的代理人地址
	 */
	private String defeAgentAddress;

	/**
	 * 变更记录id
	 */
	private String caseChangeRecordId;

	/**
	 * 请求事项
	 */
	private String changeRequest;

	/**
	 * 事实与理由
	 */
	private String factReason;

	/**
	 * 变更内容
	 */
	private String changeContent;

	/**
	 * 申请时间
	 */
	private Timestamp createTime;

	/**
	 * 异议人
	 */
	private String applyName;

	/**
	 * 审批id
	 */
	private String approveId;

	/**
	 * 请求id
	 */
	private String requestId;

	/**
	 * 审批权限 0-有审批权限 1-无审批权限
	 */
	private String primiss;

	/**
	 * 是否申请过回避 0-申请过 1-未申请
	 */
	private String isApplyAvoid;

	/**
	 * 0-未组庭 1-已组庭
	 */
	private String isTribunal;

	/**
	 * 仲裁委职务
	 */
	private String duties;

	/**
	 * 标的金额
	 */
	private BigDecimal markAmount;

	/**
	 * 受理费
	 */
	private BigDecimal caseAdmissibleAmount;

	/**
	 * 处理费
	 */
	private BigDecimal caseHandlingAmount;

	/**
	 * 应退费
	 */
	private BigDecimal shouldBeRefund;

	/**
	 * 应补缴
	 */
	private BigDecimal paymentShouldBe;

	/**
	 * 审批记录
	 */
	private List<ApproveRecordVO> approveRecordVOList;

	/**
	 * 请求标志 0-正请求 1-反请求
	 */
	private String counterclaimFlag;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropSex() {
		return propSex;
	}

	public void setPropSex(String propSex) {
		this.propSex = propSex;
	}

	public String getPronEthnic() {
		return pronEthnic;
	}

	public void setPronEthnic(String pronEthnic) {
		this.pronEthnic = pronEthnic;
	}

	public String getPropCardId() {
		return propCardId;
	}

	public void setPropCardId(String propCardId) {
		this.propCardId = propCardId;
	}

	public String getPropAddress() {
		return propAddress;
	}

	public void setPropAddress(String propAddress) {
		this.propAddress = propAddress;
	}

	public String getPropCertName() {
		return propCertName;
	}

	public void setPropCertName(String propCertName) {
		this.propCertName = propCertName;
	}

	public String getPropCertDuties() {
		return propCertDuties;
	}

	public void setPropCertDuties(String propCertDuties) {
		this.propCertDuties = propCertDuties;
	}

	public String getDefePropName() {
		return defePropName;
	}

	public void setDefePropName(String defePropName) {
		this.defePropName = defePropName;
	}

	public String getDefeSex() {
		return defeSex;
	}

	public void setDefeSex(String defeSex) {
		this.defeSex = defeSex;
	}

	public String getDefeEthnic() {
		return defeEthnic;
	}

	public void setDefeEthnic(String defeEthnic) {
		this.defeEthnic = defeEthnic;
	}

	public String getDefeCardId() {
		return defeCardId;
	}

	public void setDefeCardId(String defeCardId) {
		this.defeCardId = defeCardId;
	}

	public String getDefeAddress() {
		return defeAddress;
	}

	public void setDefeAddress(String defeAddress) {
		this.defeAddress = defeAddress;
	}

	public String getDefeCertName() {
		return defeCertName;
	}

	public void setDefeCertName(String defeCertName) {
		this.defeCertName = defeCertName;
	}

	public String getDefeCertDuties() {
		return defeCertDuties;
	}

	public void setDefeCertDuties(String defeCertDuties) {
		this.defeCertDuties = defeCertDuties;
	}

	public String getPropAgentName() {
		return propAgentName;
	}

	public void setPropAgentName(String propAgentName) {
		this.propAgentName = propAgentName;
	}

	public String getPropAgentSex() {
		return propAgentSex;
	}

	public void setPropAgentSex(String propAgentSex) {
		this.propAgentSex = propAgentSex;
	}

	public String getPropAgentCardId() {
		return propAgentCardId;
	}

	public void setPropAgentCardId(String propAgentCardId) {
		this.propAgentCardId = propAgentCardId;
	}

	public String getPropAgentEthnic() {
		return propAgentEthnic;
	}

	public void setPropAgentEthnic(String propAgentEthnic) {
		this.propAgentEthnic = propAgentEthnic;
	}

	public String getPropAgentAddress() {
		return propAgentAddress;
	}

	public void setPropAgentAddress(String propAgentAddress) {
		this.propAgentAddress = propAgentAddress;
	}

	public String getDefeAgentName() {
		return defeAgentName;
	}

	public void setDefeAgentName(String defeAgentName) {
		this.defeAgentName = defeAgentName;
	}

	public String getDefeAgentSex() {
		return defeAgentSex;
	}

	public void setDefeAgentSex(String defeAgentSex) {
		this.defeAgentSex = defeAgentSex;
	}

	public String getDefeAgentCardId() {
		return defeAgentCardId;
	}

	public void setDefeAgentCardId(String defeAgentCardId) {
		this.defeAgentCardId = defeAgentCardId;
	}

	public String getDefeAgentEthnic() {
		return defeAgentEthnic;
	}

	public void setDefeAgentEthnic(String defeAgentEthnic) {
		this.defeAgentEthnic = defeAgentEthnic;
	}

	public String getDefeAgentAddress() {
		return defeAgentAddress;
	}

	public void setDefeAgentAddress(String defeAgentAddress) {
		this.defeAgentAddress = defeAgentAddress;
	}

	public String getCaseChangeRecordId() {
		return caseChangeRecordId;
	}

	public void setCaseChangeRecordId(String caseChangeRecordId) {
		this.caseChangeRecordId = caseChangeRecordId;
	}

	public String getChangeRequest() {
		return changeRequest;
	}

	public void setChangeRequest(String changeRequest) {
		this.changeRequest = changeRequest;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public String getChangeContent() {
		return changeContent;
	}

	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public String getIsTribunal() {
		return isTribunal;
	}

	public void setIsTribunal(String isTribunal) {
		this.isTribunal = isTribunal;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public BigDecimal getMarkAmount() {
		return markAmount;
	}

	public void setMarkAmount(BigDecimal markAmount) {
		this.markAmount = markAmount;
	}

	public List<ApproveRecordVO> getApproveRecordVOList() {
		return approveRecordVOList;
	}

	public void setApproveRecordVOList(List<ApproveRecordVO> approveRecordVOList) {
		this.approveRecordVOList = approveRecordVOList;
	}

	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}

	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}

	public BigDecimal getCaseAdmissibleAmount() {
		return caseAdmissibleAmount;
	}

	public void setCaseAdmissibleAmount(BigDecimal caseAdmissibleAmount) {
		this.caseAdmissibleAmount = caseAdmissibleAmount;
	}

	public BigDecimal getCaseHandlingAmount() {
		return caseHandlingAmount;
	}

	public void setCaseHandlingAmount(BigDecimal caseHandlingAmount) {
		this.caseHandlingAmount = caseHandlingAmount;
	}

	public BigDecimal getShouldBeRefund() {
		return shouldBeRefund;
	}

	public void setShouldBeRefund(BigDecimal shouldBeRefund) {
		this.shouldBeRefund = shouldBeRefund;
	}

	public BigDecimal getPaymentShouldBe() {
		return paymentShouldBe;
	}

	public void setPaymentShouldBe(BigDecimal paymentShouldBe) {
		this.paymentShouldBe = paymentShouldBe;
	}

}
