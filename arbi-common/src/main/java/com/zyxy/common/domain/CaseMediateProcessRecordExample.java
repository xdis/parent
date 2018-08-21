package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.List;

public class CaseMediateProcessRecordExample {
    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public CaseMediateProcessRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_mediate_process_record
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
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_mediate_process_record
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

        public Criteria andProposerSignStatusIsNull() {
            addCriterion("PROPOSER_SIGN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusIsNotNull() {
            addCriterion("PROPOSER_SIGN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusEqualTo(String value) {
            addCriterion("PROPOSER_SIGN_STATUS =", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusNotEqualTo(String value) {
            addCriterion("PROPOSER_SIGN_STATUS <>", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusGreaterThan(String value) {
            addCriterion("PROPOSER_SIGN_STATUS >", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PROPOSER_SIGN_STATUS >=", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusLessThan(String value) {
            addCriterion("PROPOSER_SIGN_STATUS <", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusLessThanOrEqualTo(String value) {
            addCriterion("PROPOSER_SIGN_STATUS <=", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusLike(String value) {
            addCriterion("PROPOSER_SIGN_STATUS like", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusNotLike(String value) {
            addCriterion("PROPOSER_SIGN_STATUS not like", value, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusIn(List<String> values) {
            addCriterion("PROPOSER_SIGN_STATUS in", values, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusNotIn(List<String> values) {
            addCriterion("PROPOSER_SIGN_STATUS not in", values, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusBetween(String value1, String value2) {
            addCriterion("PROPOSER_SIGN_STATUS between", value1, value2, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andProposerSignStatusNotBetween(String value1, String value2) {
            addCriterion("PROPOSER_SIGN_STATUS not between", value1, value2, "proposerSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusIsNull() {
            addCriterion("DEFENDANT_SIGN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusIsNotNull() {
            addCriterion("DEFENDANT_SIGN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusEqualTo(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS =", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusNotEqualTo(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS <>", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusGreaterThan(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS >", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS >=", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusLessThan(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS <", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusLessThanOrEqualTo(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS <=", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusLike(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS like", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusNotLike(String value) {
            addCriterion("DEFENDANT_SIGN_STATUS not like", value, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusIn(List<String> values) {
            addCriterion("DEFENDANT_SIGN_STATUS in", values, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusNotIn(List<String> values) {
            addCriterion("DEFENDANT_SIGN_STATUS not in", values, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusBetween(String value1, String value2) {
            addCriterion("DEFENDANT_SIGN_STATUS between", value1, value2, "defendantSignStatus");
            return (Criteria) this;
        }

        public Criteria andDefendantSignStatusNotBetween(String value1, String value2) {
            addCriterion("DEFENDANT_SIGN_STATUS not between", value1, value2, "defendantSignStatus");
            return (Criteria) this;
        }
    }

    /**
     * case_mediate_process_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_mediate_process_record
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