package com.zyxy.common.dto;

/**
 * 案件列表传输对象
 */
public class CaseListDTO extends BasePageDTO {

	/**
	 * 待审核
	 */
	private String toAudit;

	/**
	 * 审核中
	 */
	private String underReview;

	/**
	 * 已审核
	 */
	private String approved;

	/**
	 * 申请人/被申请人/代理人
	 */
	private String propName;

	/**
	 * 申请时间开始时间
	 */
	private String startTime;

	/**
	 * 申请时间结束时间
	 */
	private String endTime;

	/**
	 * 仲裁委工作人员职务 0-立案秘书 1-立案部长 2-仲裁秘书 3-仲裁部长 4-主任 5-副主任 -1 代表查看全部
	 */
	private String duties;

	public String getToAudit() {
		return toAudit;
	}

	public void setToAudit(String toAudit) {
		this.toAudit = toAudit;
	}

	public String getUnderReview() {
		return underReview;
	}

	public void setUnderReview(String underReview) {
		this.underReview = underReview;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}
}
