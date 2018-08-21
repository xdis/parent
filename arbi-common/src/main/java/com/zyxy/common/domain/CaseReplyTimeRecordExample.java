package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseReplyTimeRecordExample {
    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public CaseReplyTimeRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_reply_time_record
     *
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
     * case_reply_time_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_reply_time_record
     *
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andBusiIdIsNull() {
            addCriterion("BUSI_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusiIdIsNotNull() {
            addCriterion("BUSI_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusiIdEqualTo(String value) {
            addCriterion("BUSI_ID =", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotEqualTo(String value) {
            addCriterion("BUSI_ID <>", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdGreaterThan(String value) {
            addCriterion("BUSI_ID >", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_ID >=", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdLessThan(String value) {
            addCriterion("BUSI_ID <", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdLessThanOrEqualTo(String value) {
            addCriterion("BUSI_ID <=", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdLike(String value) {
            addCriterion("BUSI_ID like", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotLike(String value) {
            addCriterion("BUSI_ID not like", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdIn(List<String> values) {
            addCriterion("BUSI_ID in", values, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotIn(List<String> values) {
            addCriterion("BUSI_ID not in", values, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdBetween(String value1, String value2) {
            addCriterion("BUSI_ID between", value1, value2, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotBetween(String value1, String value2) {
            addCriterion("BUSI_ID not between", value1, value2, "busiId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDelayFlagIsNull() {
            addCriterion("DELAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelayFlagIsNotNull() {
            addCriterion("DELAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelayFlagEqualTo(String value) {
            addCriterion("DELAY_FLAG =", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagNotEqualTo(String value) {
            addCriterion("DELAY_FLAG <>", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagGreaterThan(String value) {
            addCriterion("DELAY_FLAG >", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_FLAG >=", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagLessThan(String value) {
            addCriterion("DELAY_FLAG <", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagLessThanOrEqualTo(String value) {
            addCriterion("DELAY_FLAG <=", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagLike(String value) {
            addCriterion("DELAY_FLAG like", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagNotLike(String value) {
            addCriterion("DELAY_FLAG not like", value, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagIn(List<String> values) {
            addCriterion("DELAY_FLAG in", values, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagNotIn(List<String> values) {
            addCriterion("DELAY_FLAG not in", values, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagBetween(String value1, String value2) {
            addCriterion("DELAY_FLAG between", value1, value2, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andDelayFlagNotBetween(String value1, String value2) {
            addCriterion("DELAY_FLAG not between", value1, value2, "delayFlag");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("REQUEST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("REQUEST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(String value) {
            addCriterion("REQUEST_TYPE =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(String value) {
            addCriterion("REQUEST_TYPE <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(String value) {
            addCriterion("REQUEST_TYPE >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_TYPE >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(String value) {
            addCriterion("REQUEST_TYPE <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_TYPE <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLike(String value) {
            addCriterion("REQUEST_TYPE like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotLike(String value) {
            addCriterion("REQUEST_TYPE not like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<String> values) {
            addCriterion("REQUEST_TYPE in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<String> values) {
            addCriterion("REQUEST_TYPE not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(String value1, String value2) {
            addCriterion("REQUEST_TYPE between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(String value1, String value2) {
            addCriterion("REQUEST_TYPE not between", value1, value2, "requestType");
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
    }

    /**
     * case_reply_time_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_reply_time_record
     *
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}