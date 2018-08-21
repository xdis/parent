package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseDocContentExample {
    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public CaseDocContentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_doc_content
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
     * case_doc_content
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_doc_content
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

        public Criteria andRequestIdIsNull() {
            addCriterion("REQUEST_ID is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("REQUEST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("REQUEST_ID =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("REQUEST_ID <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("REQUEST_ID >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_ID >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("REQUEST_ID <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_ID <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLike(String value) {
            addCriterion("REQUEST_ID like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotLike(String value) {
            addCriterion("REQUEST_ID not like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("REQUEST_ID in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("REQUEST_ID not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("REQUEST_ID between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("REQUEST_ID not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andIssueTypeIsNull() {
            addCriterion("ISSUE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIssueTypeIsNotNull() {
            addCriterion("ISSUE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTypeEqualTo(Integer value) {
            addCriterion("ISSUE_TYPE =", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeNotEqualTo(Integer value) {
            addCriterion("ISSUE_TYPE <>", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeGreaterThan(Integer value) {
            addCriterion("ISSUE_TYPE >", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISSUE_TYPE >=", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeLessThan(Integer value) {
            addCriterion("ISSUE_TYPE <", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ISSUE_TYPE <=", value, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeIn(List<Integer> values) {
            addCriterion("ISSUE_TYPE in", values, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeNotIn(List<Integer> values) {
            addCriterion("ISSUE_TYPE not in", values, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeBetween(Integer value1, Integer value2) {
            addCriterion("ISSUE_TYPE between", value1, value2, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ISSUE_TYPE not between", value1, value2, "issueType");
            return (Criteria) this;
        }

        public Criteria andIssueIdIsNull() {
            addCriterion("ISSUE_ID is null");
            return (Criteria) this;
        }

        public Criteria andIssueIdIsNotNull() {
            addCriterion("ISSUE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIssueIdEqualTo(String value) {
            addCriterion("ISSUE_ID =", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotEqualTo(String value) {
            addCriterion("ISSUE_ID <>", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThan(String value) {
            addCriterion("ISSUE_ID >", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThanOrEqualTo(String value) {
            addCriterion("ISSUE_ID >=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThan(String value) {
            addCriterion("ISSUE_ID <", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThanOrEqualTo(String value) {
            addCriterion("ISSUE_ID <=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLike(String value) {
            addCriterion("ISSUE_ID like", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotLike(String value) {
            addCriterion("ISSUE_ID not like", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdIn(List<String> values) {
            addCriterion("ISSUE_ID in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotIn(List<String> values) {
            addCriterion("ISSUE_ID not in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdBetween(String value1, String value2) {
            addCriterion("ISSUE_ID between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotBetween(String value1, String value2) {
            addCriterion("ISSUE_ID not between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssusTimeIsNull() {
            addCriterion("ISSUS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andIssusTimeIsNotNull() {
            addCriterion("ISSUS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andIssusTimeEqualTo(Date value) {
            addCriterion("ISSUS_TIME =", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeNotEqualTo(Date value) {
            addCriterion("ISSUS_TIME <>", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeGreaterThan(Date value) {
            addCriterion("ISSUS_TIME >", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ISSUS_TIME >=", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeLessThan(Date value) {
            addCriterion("ISSUS_TIME <", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeLessThanOrEqualTo(Date value) {
            addCriterion("ISSUS_TIME <=", value, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeIn(List<Date> values) {
            addCriterion("ISSUS_TIME in", values, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeNotIn(List<Date> values) {
            addCriterion("ISSUS_TIME not in", values, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeBetween(Date value1, Date value2) {
            addCriterion("ISSUS_TIME between", value1, value2, "issusTime");
            return (Criteria) this;
        }

        public Criteria andIssusTimeNotBetween(Date value1, Date value2) {
            addCriterion("ISSUS_TIME not between", value1, value2, "issusTime");
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
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNull() {
            addCriterion("DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(String value) {
            addCriterion("DOC_ID =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(String value) {
            addCriterion("DOC_ID <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(String value) {
            addCriterion("DOC_ID >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_ID >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(String value) {
            addCriterion("DOC_ID <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_ID <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLike(String value) {
            addCriterion("DOC_ID like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotLike(String value) {
            addCriterion("DOC_ID not like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<String> values) {
            addCriterion("DOC_ID in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<String> values) {
            addCriterion("DOC_ID not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(String value1, String value2) {
            addCriterion("DOC_ID between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(String value1, String value2) {
            addCriterion("DOC_ID not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdIsNull() {
            addCriterion("SECRETARY_ID is null");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdIsNotNull() {
            addCriterion("SECRETARY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdEqualTo(String value) {
            addCriterion("SECRETARY_ID =", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdNotEqualTo(String value) {
            addCriterion("SECRETARY_ID <>", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdGreaterThan(String value) {
            addCriterion("SECRETARY_ID >", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("SECRETARY_ID >=", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdLessThan(String value) {
            addCriterion("SECRETARY_ID <", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdLessThanOrEqualTo(String value) {
            addCriterion("SECRETARY_ID <=", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdLike(String value) {
            addCriterion("SECRETARY_ID like", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdNotLike(String value) {
            addCriterion("SECRETARY_ID not like", value, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdIn(List<String> values) {
            addCriterion("SECRETARY_ID in", values, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdNotIn(List<String> values) {
            addCriterion("SECRETARY_ID not in", values, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdBetween(String value1, String value2) {
            addCriterion("SECRETARY_ID between", value1, value2, "secretaryId");
            return (Criteria) this;
        }

        public Criteria andSecretaryIdNotBetween(String value1, String value2) {
            addCriterion("SECRETARY_ID not between", value1, value2, "secretaryId");
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
            addCriterion("ARBITRATOR_ID between", value1, value2, "arbitratorId");
            return (Criteria) this;
        }

        public Criteria andArbitratorIdNotBetween(String value1, String value2) {
            addCriterion("ARBITRATOR_ID not between", value1, value2, "arbitratorId");
            return (Criteria) this;
        }

        public Criteria andSaveADraftIsNull() {
            addCriterion("SAVE_A_DRAFT is null");
            return (Criteria) this;
        }

        public Criteria andSaveADraftIsNotNull() {
            addCriterion("SAVE_A_DRAFT is not null");
            return (Criteria) this;
        }

        public Criteria andSaveADraftEqualTo(String value) {
            addCriterion("SAVE_A_DRAFT =", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftNotEqualTo(String value) {
            addCriterion("SAVE_A_DRAFT <>", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftGreaterThan(String value) {
            addCriterion("SAVE_A_DRAFT >", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftGreaterThanOrEqualTo(String value) {
            addCriterion("SAVE_A_DRAFT >=", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftLessThan(String value) {
            addCriterion("SAVE_A_DRAFT <", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftLessThanOrEqualTo(String value) {
            addCriterion("SAVE_A_DRAFT <=", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftLike(String value) {
            addCriterion("SAVE_A_DRAFT like", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftNotLike(String value) {
            addCriterion("SAVE_A_DRAFT not like", value, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftIn(List<String> values) {
            addCriterion("SAVE_A_DRAFT in", values, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftNotIn(List<String> values) {
            addCriterion("SAVE_A_DRAFT not in", values, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftBetween(String value1, String value2) {
            addCriterion("SAVE_A_DRAFT between", value1, value2, "saveADraft");
            return (Criteria) this;
        }

        public Criteria andSaveADraftNotBetween(String value1, String value2) {
            addCriterion("SAVE_A_DRAFT not between", value1, value2, "saveADraft");
            return (Criteria) this;
        }
    }

    /**
     * case_doc_content
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_doc_content
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