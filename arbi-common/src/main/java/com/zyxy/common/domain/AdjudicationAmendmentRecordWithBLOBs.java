package com.zyxy.common.domain;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table adjudication_amendment_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class AdjudicationAmendmentRecordWithBLOBs extends AdjudicationAmendmentRecord implements Serializable {

	/**
	 * Database Column Remarks: 申请事项 This field was generated by MyBatis Generator. This field corresponds to the database column adjudication_amendment_record.APPLICATION
	 * @mbggenerated
	 */
	private String application;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column adjudication_amendment_record.FACT_REASON
	 * @mbggenerated
	 */
	private String factReason;
	/**
	 * Database Column Remarks: 当事人补正内容 This field was generated by MyBatis Generator. This field corresponds to the database column adjudication_amendment_record.CONTENT
	 * @mbggenerated
	 */
	private String content;
	/**
	 * Database Column Remarks: 仲裁员补正内容 This field was generated by MyBatis Generator. This field corresponds to the database column adjudication_amendment_record.ARBITRATOR_CONTENT
	 * @mbggenerated
	 */
	private String arbitratorContent;
	/**
	 * Database Column Remarks: 备注 This field was generated by MyBatis Generator. This field corresponds to the database column adjudication_amendment_record.REMARK
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column adjudication_amendment_record.APPLICATION
	 * @return  the value of adjudication_amendment_record.APPLICATION
	 * @mbggenerated
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column adjudication_amendment_record.APPLICATION
	 * @param application  the value for adjudication_amendment_record.APPLICATION
	 * @mbggenerated
	 */
	public void setApplication(String application) {
		this.application = application == null ? null : application.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column adjudication_amendment_record.FACT_REASON
	 * @return  the value of adjudication_amendment_record.FACT_REASON
	 * @mbggenerated
	 */
	public String getFactReason() {
		return factReason;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column adjudication_amendment_record.FACT_REASON
	 * @param factReason  the value for adjudication_amendment_record.FACT_REASON
	 * @mbggenerated
	 */
	public void setFactReason(String factReason) {
		this.factReason = factReason == null ? null : factReason.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column adjudication_amendment_record.CONTENT
	 * @return  the value of adjudication_amendment_record.CONTENT
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column adjudication_amendment_record.CONTENT
	 * @param content  the value for adjudication_amendment_record.CONTENT
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column adjudication_amendment_record.ARBITRATOR_CONTENT
	 * @return  the value of adjudication_amendment_record.ARBITRATOR_CONTENT
	 * @mbggenerated
	 */
	public String getArbitratorContent() {
		return arbitratorContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column adjudication_amendment_record.ARBITRATOR_CONTENT
	 * @param arbitratorContent  the value for adjudication_amendment_record.ARBITRATOR_CONTENT
	 * @mbggenerated
	 */
	public void setArbitratorContent(String arbitratorContent) {
		this.arbitratorContent = arbitratorContent == null ? null
				: arbitratorContent.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column adjudication_amendment_record.REMARK
	 * @return  the value of adjudication_amendment_record.REMARK
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column adjudication_amendment_record.REMARK
	 * @param remark  the value for adjudication_amendment_record.REMARK
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}