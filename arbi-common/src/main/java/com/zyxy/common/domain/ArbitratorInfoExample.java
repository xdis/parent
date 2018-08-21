package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.List;

public class ArbitratorInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public ArbitratorInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table arbitrator_info
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("USER_ID like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("USER_ID not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNull() {
			addCriterion("BIRTHDAY is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNotNull() {
			addCriterion("BIRTHDAY is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayEqualTo(String value) {
			addCriterion("BIRTHDAY =", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotEqualTo(String value) {
			addCriterion("BIRTHDAY <>", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThan(String value) {
			addCriterion("BIRTHDAY >", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
			addCriterion("BIRTHDAY >=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThan(String value) {
			addCriterion("BIRTHDAY <", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThanOrEqualTo(String value) {
			addCriterion("BIRTHDAY <=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLike(String value) {
			addCriterion("BIRTHDAY like", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotLike(String value) {
			addCriterion("BIRTHDAY not like", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayIn(List<String> values) {
			addCriterion("BIRTHDAY in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotIn(List<String> values) {
			addCriterion("BIRTHDAY not in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayBetween(String value1, String value2) {
			addCriterion("BIRTHDAY between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotBetween(String value1, String value2) {
			addCriterion("BIRTHDAY not between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andVocationIsNull() {
			addCriterion("VOCATION is null");
			return (Criteria) this;
		}

		public Criteria andVocationIsNotNull() {
			addCriterion("VOCATION is not null");
			return (Criteria) this;
		}

		public Criteria andVocationEqualTo(String value) {
			addCriterion("VOCATION =", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationNotEqualTo(String value) {
			addCriterion("VOCATION <>", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationGreaterThan(String value) {
			addCriterion("VOCATION >", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationGreaterThanOrEqualTo(String value) {
			addCriterion("VOCATION >=", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationLessThan(String value) {
			addCriterion("VOCATION <", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationLessThanOrEqualTo(String value) {
			addCriterion("VOCATION <=", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationLike(String value) {
			addCriterion("VOCATION like", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationNotLike(String value) {
			addCriterion("VOCATION not like", value, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationIn(List<String> values) {
			addCriterion("VOCATION in", values, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationNotIn(List<String> values) {
			addCriterion("VOCATION not in", values, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationBetween(String value1, String value2) {
			addCriterion("VOCATION between", value1, value2, "vocation");
			return (Criteria) this;
		}

		public Criteria andVocationNotBetween(String value1, String value2) {
			addCriterion("VOCATION not between", value1, value2, "vocation");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusIsNull() {
			addCriterion("ACCEPT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusIsNotNull() {
			addCriterion("ACCEPT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusEqualTo(String value) {
			addCriterion("ACCEPT_STATUS =", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusNotEqualTo(String value) {
			addCriterion("ACCEPT_STATUS <>", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusGreaterThan(String value) {
			addCriterion("ACCEPT_STATUS >", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusGreaterThanOrEqualTo(String value) {
			addCriterion("ACCEPT_STATUS >=", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusLessThan(String value) {
			addCriterion("ACCEPT_STATUS <", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusLessThanOrEqualTo(String value) {
			addCriterion("ACCEPT_STATUS <=", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusLike(String value) {
			addCriterion("ACCEPT_STATUS like", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusNotLike(String value) {
			addCriterion("ACCEPT_STATUS not like", value, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusIn(List<String> values) {
			addCriterion("ACCEPT_STATUS in", values, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusNotIn(List<String> values) {
			addCriterion("ACCEPT_STATUS not in", values, "acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusBetween(String value1, String value2) {
			addCriterion("ACCEPT_STATUS between", value1, value2,
					"acceptStatus");
			return (Criteria) this;
		}

		public Criteria andAcceptStatusNotBetween(String value1, String value2) {
			addCriterion("ACCEPT_STATUS not between", value1, value2,
					"acceptStatus");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIsNull() {
			addCriterion("SPECIALTY is null");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIsNotNull() {
			addCriterion("SPECIALTY is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialtyEqualTo(String value) {
			addCriterion("SPECIALTY =", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotEqualTo(String value) {
			addCriterion("SPECIALTY <>", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyGreaterThan(String value) {
			addCriterion("SPECIALTY >", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
			addCriterion("SPECIALTY >=", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLessThan(String value) {
			addCriterion("SPECIALTY <", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLessThanOrEqualTo(String value) {
			addCriterion("SPECIALTY <=", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLike(String value) {
			addCriterion("SPECIALTY like", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotLike(String value) {
			addCriterion("SPECIALTY not like", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIn(List<String> values) {
			addCriterion("SPECIALTY in", values, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotIn(List<String> values) {
			addCriterion("SPECIALTY not in", values, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyBetween(String value1, String value2) {
			addCriterion("SPECIALTY between", value1, value2, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotBetween(String value1, String value2) {
			addCriterion("SPECIALTY not between", value1, value2, "specialty");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("ADDRESS =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("ADDRESS <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("ADDRESS >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("ADDRESS >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("ADDRESS <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("ADDRESS <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("ADDRESS like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("ADDRESS not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("ADDRESS in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("ADDRESS not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("ADDRESS between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("ADDRESS not between", value1, value2, "address");
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

		public Criteria andCreateDateIsNull() {
			addCriterion("CREATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("CREATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("CREATE_DATE =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("CREATE_DATE <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("CREATE_DATE >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_DATE >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(String value) {
			addCriterion("CREATE_DATE <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("CREATE_DATE <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLike(String value) {
			addCriterion("CREATE_DATE like", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotLike(String value) {
			addCriterion("CREATE_DATE not like", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("CREATE_DATE in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("CREATE_DATE not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("CREATE_DATE between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("CREATE_DATE not between", value1, value2,
					"createDate");
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

		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLike(String value) {
			addCriterion("CREATE_TIME like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("CREATE_TIME not like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("CREATE_TIME not between", value1, value2,
					"createTime");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIsNull() {
			addCriterion("UPDATE_ID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIsNotNull() {
			addCriterion("UPDATE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateIdEqualTo(String value) {
			addCriterion("UPDATE_ID =", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotEqualTo(String value) {
			addCriterion("UPDATE_ID <>", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdGreaterThan(String value) {
			addCriterion("UPDATE_ID >", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_ID >=", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLessThan(String value) {
			addCriterion("UPDATE_ID <", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_ID <=", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLike(String value) {
			addCriterion("UPDATE_ID like", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotLike(String value) {
			addCriterion("UPDATE_ID not like", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIn(List<String> values) {
			addCriterion("UPDATE_ID in", values, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotIn(List<String> values) {
			addCriterion("UPDATE_ID not in", values, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdBetween(String value1, String value2) {
			addCriterion("UPDATE_ID between", value1, value2, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotBetween(String value1, String value2) {
			addCriterion("UPDATE_ID not between", value1, value2, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("UPDATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("UPDATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(String value) {
			addCriterion("UPDATE_DATE =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(String value) {
			addCriterion("UPDATE_DATE <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(String value) {
			addCriterion("UPDATE_DATE >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_DATE >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(String value) {
			addCriterion("UPDATE_DATE <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_DATE <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLike(String value) {
			addCriterion("UPDATE_DATE like", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotLike(String value) {
			addCriterion("UPDATE_DATE not like", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<String> values) {
			addCriterion("UPDATE_DATE in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<String> values) {
			addCriterion("UPDATE_DATE not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(String value1, String value2) {
			addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(String value1, String value2) {
			addCriterion("UPDATE_DATE not between", value1, value2,
					"updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("UPDATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("UPDATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2,
					"updateTime");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoIsNull() {
			addCriterion("HEAD_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoIsNotNull() {
			addCriterion("HEAD_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoEqualTo(String value) {
			addCriterion("HEAD_PHOTO =", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoNotEqualTo(String value) {
			addCriterion("HEAD_PHOTO <>", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoGreaterThan(String value) {
			addCriterion("HEAD_PHOTO >", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("HEAD_PHOTO >=", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoLessThan(String value) {
			addCriterion("HEAD_PHOTO <", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoLessThanOrEqualTo(String value) {
			addCriterion("HEAD_PHOTO <=", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoLike(String value) {
			addCriterion("HEAD_PHOTO like", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoNotLike(String value) {
			addCriterion("HEAD_PHOTO not like", value, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoIn(List<String> values) {
			addCriterion("HEAD_PHOTO in", values, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoNotIn(List<String> values) {
			addCriterion("HEAD_PHOTO not in", values, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoBetween(String value1, String value2) {
			addCriterion("HEAD_PHOTO between", value1, value2, "headPhoto");
			return (Criteria) this;
		}

		public Criteria andHeadPhotoNotBetween(String value1, String value2) {
			addCriterion("HEAD_PHOTO not between", value1, value2, "headPhoto");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table arbitrator_info
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
     * arbitrator_info
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}