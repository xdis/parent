package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseNodeOperExample {
    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public CaseNodeOperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_node_oper
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
     * case_node_oper
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_node_oper
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

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNull() {
            addCriterion("NEXT_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIsNotNull() {
            addCriterion("NEXT_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID =", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID <>", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThan(Integer value) {
            addCriterion("NEXT_NODE_ID >", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID >=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThan(Integer value) {
            addCriterion("NEXT_NODE_ID <", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("NEXT_NODE_ID <=", value, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdIn(List<Integer> values) {
            addCriterion("NEXT_NODE_ID in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotIn(List<Integer> values) {
            addCriterion("NEXT_NODE_ID not in", values, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("NEXT_NODE_ID between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andNextNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NEXT_NODE_ID not between", value1, value2, "nextNodeId");
            return (Criteria) this;
        }

        public Criteria andOperRecordIsNull() {
            addCriterion("OPER_RECORD is null");
            return (Criteria) this;
        }

        public Criteria andOperRecordIsNotNull() {
            addCriterion("OPER_RECORD is not null");
            return (Criteria) this;
        }

        public Criteria andOperRecordEqualTo(String value) {
            addCriterion("OPER_RECORD =", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordNotEqualTo(String value) {
            addCriterion("OPER_RECORD <>", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordGreaterThan(String value) {
            addCriterion("OPER_RECORD >", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_RECORD >=", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordLessThan(String value) {
            addCriterion("OPER_RECORD <", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordLessThanOrEqualTo(String value) {
            addCriterion("OPER_RECORD <=", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordLike(String value) {
            addCriterion("OPER_RECORD like", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordNotLike(String value) {
            addCriterion("OPER_RECORD not like", value, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordIn(List<String> values) {
            addCriterion("OPER_RECORD in", values, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordNotIn(List<String> values) {
            addCriterion("OPER_RECORD not in", values, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordBetween(String value1, String value2) {
            addCriterion("OPER_RECORD between", value1, value2, "operRecord");
            return (Criteria) this;
        }

        public Criteria andOperRecordNotBetween(String value1, String value2) {
            addCriterion("OPER_RECORD not between", value1, value2, "operRecord");
            return (Criteria) this;
        }

        public Criteria andBussIdIsNull() {
            addCriterion("BUSS_ID is null");
            return (Criteria) this;
        }

        public Criteria andBussIdIsNotNull() {
            addCriterion("BUSS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBussIdEqualTo(String value) {
            addCriterion("BUSS_ID =", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotEqualTo(String value) {
            addCriterion("BUSS_ID <>", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdGreaterThan(String value) {
            addCriterion("BUSS_ID >", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSS_ID >=", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLessThan(String value) {
            addCriterion("BUSS_ID <", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLessThanOrEqualTo(String value) {
            addCriterion("BUSS_ID <=", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdLike(String value) {
            addCriterion("BUSS_ID like", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotLike(String value) {
            addCriterion("BUSS_ID not like", value, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdIn(List<String> values) {
            addCriterion("BUSS_ID in", values, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotIn(List<String> values) {
            addCriterion("BUSS_ID not in", values, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdBetween(String value1, String value2) {
            addCriterion("BUSS_ID between", value1, value2, "bussId");
            return (Criteria) this;
        }

        public Criteria andBussIdNotBetween(String value1, String value2) {
            addCriterion("BUSS_ID not between", value1, value2, "bussId");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("DEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("DEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(String value) {
            addCriterion("DEAL_STATUS =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(String value) {
            addCriterion("DEAL_STATUS <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(String value) {
            addCriterion("DEAL_STATUS >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_STATUS >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(String value) {
            addCriterion("DEAL_STATUS <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(String value) {
            addCriterion("DEAL_STATUS <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLike(String value) {
            addCriterion("DEAL_STATUS like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotLike(String value) {
            addCriterion("DEAL_STATUS not like", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<String> values) {
            addCriterion("DEAL_STATUS in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<String> values) {
            addCriterion("DEAL_STATUS not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(String value1, String value2) {
            addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(String value1, String value2) {
            addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
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

        public Criteria andPlanEndTimeIsNull() {
            addCriterion("PLAN_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIsNotNull() {
            addCriterion("PLAN_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeEqualTo(Date value) {
            addCriterion("PLAN_END_TIME =", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotEqualTo(Date value) {
            addCriterion("PLAN_END_TIME <>", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThan(Date value) {
            addCriterion("PLAN_END_TIME >", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PLAN_END_TIME >=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThan(Date value) {
            addCriterion("PLAN_END_TIME <", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("PLAN_END_TIME <=", value, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeIn(List<Date> values) {
            addCriterion("PLAN_END_TIME in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotIn(List<Date> values) {
            addCriterion("PLAN_END_TIME not in", values, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeBetween(Date value1, Date value2) {
            addCriterion("PLAN_END_TIME between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andPlanEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("PLAN_END_TIME not between", value1, value2, "planEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeIsNull() {
            addCriterion("REAL_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeIsNotNull() {
            addCriterion("REAL_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeEqualTo(Date value) {
            addCriterion("REAL_END_TIME =", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeNotEqualTo(Date value) {
            addCriterion("REAL_END_TIME <>", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeGreaterThan(Date value) {
            addCriterion("REAL_END_TIME >", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REAL_END_TIME >=", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeLessThan(Date value) {
            addCriterion("REAL_END_TIME <", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("REAL_END_TIME <=", value, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeIn(List<Date> values) {
            addCriterion("REAL_END_TIME in", values, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeNotIn(List<Date> values) {
            addCriterion("REAL_END_TIME not in", values, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeBetween(Date value1, Date value2) {
            addCriterion("REAL_END_TIME between", value1, value2, "realEndTime");
            return (Criteria) this;
        }

        public Criteria andRealEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("REAL_END_TIME not between", value1, value2, "realEndTime");
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
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * case_node_oper
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_node_oper
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