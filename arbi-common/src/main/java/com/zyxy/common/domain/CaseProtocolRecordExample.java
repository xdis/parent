package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseProtocolRecordExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public CaseProtocolRecordExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("ID like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("ID not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNull() {
			addCriterion("CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(String value) {
			addCriterion("CASE_ID =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(String value) {
			addCriterion("CASE_ID <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(String value) {
			addCriterion("CASE_ID >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_ID >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(String value) {
			addCriterion("CASE_ID <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(String value) {
			addCriterion("CASE_ID <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLike(String value) {
			addCriterion("CASE_ID like", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotLike(String value) {
			addCriterion("CASE_ID not like", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<String> values) {
			addCriterion("CASE_ID in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<String> values) {
			addCriterion("CASE_ID not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(String value1, String value2) {
			addCriterion("CASE_ID between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(String value1, String value2) {
			addCriterion("CASE_ID not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andApplyTypeIsNull() {
			addCriterion("APPLY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andApplyTypeIsNotNull() {
			addCriterion("APPLY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andApplyTypeEqualTo(String value) {
			addCriterion("APPLY_TYPE =", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeNotEqualTo(String value) {
			addCriterion("APPLY_TYPE <>", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeGreaterThan(String value) {
			addCriterion("APPLY_TYPE >", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
			addCriterion("APPLY_TYPE >=", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeLessThan(String value) {
			addCriterion("APPLY_TYPE <", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeLessThanOrEqualTo(String value) {
			addCriterion("APPLY_TYPE <=", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeLike(String value) {
			addCriterion("APPLY_TYPE like", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeNotLike(String value) {
			addCriterion("APPLY_TYPE not like", value, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeIn(List<String> values) {
			addCriterion("APPLY_TYPE in", values, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeNotIn(List<String> values) {
			addCriterion("APPLY_TYPE not in", values, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeBetween(String value1, String value2) {
			addCriterion("APPLY_TYPE between", value1, value2, "applyType");
			return (Criteria) this;
		}

		public Criteria andApplyTypeNotBetween(String value1, String value2) {
			addCriterion("APPLY_TYPE not between", value1, value2, "applyType");
			return (Criteria) this;
		}

		public Criteria andPropOpinionIsNull() {
			addCriterion("PROP_OPINION is null");
			return (Criteria) this;
		}

		public Criteria andPropOpinionIsNotNull() {
			addCriterion("PROP_OPINION is not null");
			return (Criteria) this;
		}

		public Criteria andPropOpinionEqualTo(String value) {
			addCriterion("PROP_OPINION =", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionNotEqualTo(String value) {
			addCriterion("PROP_OPINION <>", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionGreaterThan(String value) {
			addCriterion("PROP_OPINION >", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionGreaterThanOrEqualTo(String value) {
			addCriterion("PROP_OPINION >=", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionLessThan(String value) {
			addCriterion("PROP_OPINION <", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionLessThanOrEqualTo(String value) {
			addCriterion("PROP_OPINION <=", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionLike(String value) {
			addCriterion("PROP_OPINION like", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionNotLike(String value) {
			addCriterion("PROP_OPINION not like", value, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionIn(List<String> values) {
			addCriterion("PROP_OPINION in", values, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionNotIn(List<String> values) {
			addCriterion("PROP_OPINION not in", values, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionBetween(String value1, String value2) {
			addCriterion("PROP_OPINION between", value1, value2, "propOpinion");
			return (Criteria) this;
		}

		public Criteria andPropOpinionNotBetween(String value1, String value2) {
			addCriterion("PROP_OPINION not between", value1, value2,
					"propOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionIsNull() {
			addCriterion("DEFE_OPINION is null");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionIsNotNull() {
			addCriterion("DEFE_OPINION is not null");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionEqualTo(String value) {
			addCriterion("DEFE_OPINION =", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionNotEqualTo(String value) {
			addCriterion("DEFE_OPINION <>", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionGreaterThan(String value) {
			addCriterion("DEFE_OPINION >", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionGreaterThanOrEqualTo(String value) {
			addCriterion("DEFE_OPINION >=", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionLessThan(String value) {
			addCriterion("DEFE_OPINION <", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionLessThanOrEqualTo(String value) {
			addCriterion("DEFE_OPINION <=", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionLike(String value) {
			addCriterion("DEFE_OPINION like", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionNotLike(String value) {
			addCriterion("DEFE_OPINION not like", value, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionIn(List<String> values) {
			addCriterion("DEFE_OPINION in", values, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionNotIn(List<String> values) {
			addCriterion("DEFE_OPINION not in", values, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionBetween(String value1, String value2) {
			addCriterion("DEFE_OPINION between", value1, value2, "defeOpinion");
			return (Criteria) this;
		}

		public Criteria andDefeOpinionNotBetween(String value1, String value2) {
			addCriterion("DEFE_OPINION not between", value1, value2,
					"defeOpinion");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeIsNull() {
			addCriterion("CREATER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeIsNotNull() {
			addCriterion("CREATER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeEqualTo(String value) {
			addCriterion("CREATER_TYPE =", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeNotEqualTo(String value) {
			addCriterion("CREATER_TYPE <>", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeGreaterThan(String value) {
			addCriterion("CREATER_TYPE >", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeGreaterThanOrEqualTo(String value) {
			addCriterion("CREATER_TYPE >=", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeLessThan(String value) {
			addCriterion("CREATER_TYPE <", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeLessThanOrEqualTo(String value) {
			addCriterion("CREATER_TYPE <=", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeLike(String value) {
			addCriterion("CREATER_TYPE like", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeNotLike(String value) {
			addCriterion("CREATER_TYPE not like", value, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeIn(List<String> values) {
			addCriterion("CREATER_TYPE in", values, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeNotIn(List<String> values) {
			addCriterion("CREATER_TYPE not in", values, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeBetween(String value1, String value2) {
			addCriterion("CREATER_TYPE between", value1, value2, "createrType");
			return (Criteria) this;
		}

		public Criteria andCreaterTypeNotBetween(String value1, String value2) {
			addCriterion("CREATER_TYPE not between", value1, value2,
					"createrType");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("STATUS =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("STATUS <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("STATUS >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("STATUS >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("STATUS <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("STATUS <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("STATUS like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("STATUS not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("STATUS in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("STATUS not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andCreaterIdIsNull() {
			addCriterion("CREATER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreaterIdIsNotNull() {
			addCriterion("CREATER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreaterIdEqualTo(String value) {
			addCriterion("CREATER_ID =", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdNotEqualTo(String value) {
			addCriterion("CREATER_ID <>", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdGreaterThan(String value) {
			addCriterion("CREATER_ID >", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdGreaterThanOrEqualTo(String value) {
			addCriterion("CREATER_ID >=", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdLessThan(String value) {
			addCriterion("CREATER_ID <", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdLessThanOrEqualTo(String value) {
			addCriterion("CREATER_ID <=", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdLike(String value) {
			addCriterion("CREATER_ID like", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdNotLike(String value) {
			addCriterion("CREATER_ID not like", value, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdIn(List<String> values) {
			addCriterion("CREATER_ID in", values, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdNotIn(List<String> values) {
			addCriterion("CREATER_ID not in", values, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdBetween(String value1, String value2) {
			addCriterion("CREATER_ID between", value1, value2, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreaterIdNotBetween(String value1, String value2) {
			addCriterion("CREATER_ID not between", value1, value2, "createrId");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2,
					"createTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeIsNull() {
			addCriterion("OTHER_OPERATING_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeIsNotNull() {
			addCriterion("OTHER_OPERATING_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeEqualTo(Date value) {
			addCriterion("OTHER_OPERATING_TIME =", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeNotEqualTo(Date value) {
			addCriterion("OTHER_OPERATING_TIME <>", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeGreaterThan(Date value) {
			addCriterion("OTHER_OPERATING_TIME >", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("OTHER_OPERATING_TIME >=", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeLessThan(Date value) {
			addCriterion("OTHER_OPERATING_TIME <", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeLessThanOrEqualTo(Date value) {
			addCriterion("OTHER_OPERATING_TIME <=", value, "otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeIn(List<Date> values) {
			addCriterion("OTHER_OPERATING_TIME in", values,
					"otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeNotIn(List<Date> values) {
			addCriterion("OTHER_OPERATING_TIME not in", values,
					"otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeBetween(Date value1, Date value2) {
			addCriterion("OTHER_OPERATING_TIME between", value1, value2,
					"otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andOtherOperatingTimeNotBetween(Date value1, Date value2) {
			addCriterion("OTHER_OPERATING_TIME not between", value1, value2,
					"otherOperatingTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdIsNull() {
			addCriterion("ARBITRATOR_ID is null");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdIsNotNull() {
			addCriterion("ARBITRATOR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdEqualTo(String value) {
			addCriterion("ARBITRATOR_ID =", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdNotEqualTo(String value) {
			addCriterion("ARBITRATOR_ID <>", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdGreaterThan(String value) {
			addCriterion("ARBITRATOR_ID >", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdGreaterThanOrEqualTo(String value) {
			addCriterion("ARBITRATOR_ID >=", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdLessThan(String value) {
			addCriterion("ARBITRATOR_ID <", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdLessThanOrEqualTo(String value) {
			addCriterion("ARBITRATOR_ID <=", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdLike(String value) {
			addCriterion("ARBITRATOR_ID like", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdNotLike(String value) {
			addCriterion("ARBITRATOR_ID not like", value, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdIn(List<String> values) {
			addCriterion("ARBITRATOR_ID in", values, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdNotIn(List<String> values) {
			addCriterion("ARBITRATOR_ID not in", values, "arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdBetween(String value1, String value2) {
			addCriterion("ARBITRATOR_ID between", value1, value2,
					"arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorIdNotBetween(String value1, String value2) {
			addCriterion("ARBITRATOR_ID not between", value1, value2,
					"arbitratorId");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeIsNull() {
			addCriterion("ARBITRATOR_TIME is null");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeIsNotNull() {
			addCriterion("ARBITRATOR_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeEqualTo(Date value) {
			addCriterion("ARBITRATOR_TIME =", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeNotEqualTo(Date value) {
			addCriterion("ARBITRATOR_TIME <>", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeGreaterThan(Date value) {
			addCriterion("ARBITRATOR_TIME >", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ARBITRATOR_TIME >=", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeLessThan(Date value) {
			addCriterion("ARBITRATOR_TIME <", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeLessThanOrEqualTo(Date value) {
			addCriterion("ARBITRATOR_TIME <=", value, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeIn(List<Date> values) {
			addCriterion("ARBITRATOR_TIME in", values, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeNotIn(List<Date> values) {
			addCriterion("ARBITRATOR_TIME not in", values, "arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeBetween(Date value1, Date value2) {
			addCriterion("ARBITRATOR_TIME between", value1, value2,
					"arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andArbitratorTimeNotBetween(Date value1, Date value2) {
			addCriterion("ARBITRATOR_TIME not between", value1, value2,
					"arbitratorTime");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIsNull() {
			addCriterion("PROTOCOL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIsNotNull() {
			addCriterion("PROTOCOL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeEqualTo(String value) {
			addCriterion("PROTOCOL_TYPE =", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotEqualTo(String value) {
			addCriterion("PROTOCOL_TYPE <>", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeGreaterThan(String value) {
			addCriterion("PROTOCOL_TYPE >", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PROTOCOL_TYPE >=", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLessThan(String value) {
			addCriterion("PROTOCOL_TYPE <", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLessThanOrEqualTo(String value) {
			addCriterion("PROTOCOL_TYPE <=", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeLike(String value) {
			addCriterion("PROTOCOL_TYPE like", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotLike(String value) {
			addCriterion("PROTOCOL_TYPE not like", value, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeIn(List<String> values) {
			addCriterion("PROTOCOL_TYPE in", values, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotIn(List<String> values) {
			addCriterion("PROTOCOL_TYPE not in", values, "protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeBetween(String value1, String value2) {
			addCriterion("PROTOCOL_TYPE between", value1, value2,
					"protocolType");
			return (Criteria) this;
		}

		public Criteria andProtocolTypeNotBetween(String value1, String value2) {
			addCriterion("PROTOCOL_TYPE not between", value1, value2,
					"protocolType");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table case_protocol_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}