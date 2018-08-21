package com.zyxy.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseRequestInfoExample {
    /**
     * case_request_info
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public CaseRequestInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_request_info
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
     * case_request_info
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_request_info
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

        public Criteria andAcceptanceNoIsNull() {
            addCriterion("ACCEPTANCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoIsNotNull() {
            addCriterion("ACCEPTANCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoEqualTo(String value) {
            addCriterion("ACCEPTANCE_NO =", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoNotEqualTo(String value) {
            addCriterion("ACCEPTANCE_NO <>", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoGreaterThan(String value) {
            addCriterion("ACCEPTANCE_NO >", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTANCE_NO >=", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoLessThan(String value) {
            addCriterion("ACCEPTANCE_NO <", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTANCE_NO <=", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoLike(String value) {
            addCriterion("ACCEPTANCE_NO like", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoNotLike(String value) {
            addCriterion("ACCEPTANCE_NO not like", value, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoIn(List<String> values) {
            addCriterion("ACCEPTANCE_NO in", values, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoNotIn(List<String> values) {
            addCriterion("ACCEPTANCE_NO not in", values, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoBetween(String value1, String value2) {
            addCriterion("ACCEPTANCE_NO between", value1, value2, "acceptanceNo");
            return (Criteria) this;
        }

        public Criteria andAcceptanceNoNotBetween(String value1, String value2) {
            addCriterion("ACCEPTANCE_NO not between", value1, value2, "acceptanceNo");
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

        public Criteria andAgentFlagIsNull() {
            addCriterion("AGENT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAgentFlagIsNotNull() {
            addCriterion("AGENT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAgentFlagEqualTo(String value) {
            addCriterion("AGENT_FLAG =", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagNotEqualTo(String value) {
            addCriterion("AGENT_FLAG <>", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagGreaterThan(String value) {
            addCriterion("AGENT_FLAG >", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_FLAG >=", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagLessThan(String value) {
            addCriterion("AGENT_FLAG <", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagLessThanOrEqualTo(String value) {
            addCriterion("AGENT_FLAG <=", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagLike(String value) {
            addCriterion("AGENT_FLAG like", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagNotLike(String value) {
            addCriterion("AGENT_FLAG not like", value, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagIn(List<String> values) {
            addCriterion("AGENT_FLAG in", values, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagNotIn(List<String> values) {
            addCriterion("AGENT_FLAG not in", values, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagBetween(String value1, String value2) {
            addCriterion("AGENT_FLAG between", value1, value2, "agentFlag");
            return (Criteria) this;
        }

        public Criteria andAgentFlagNotBetween(String value1, String value2) {
            addCriterion("AGENT_FLAG not between", value1, value2, "agentFlag");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyIsNull() {
            addCriterion("DELAYED_REPLY is null");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyIsNotNull() {
            addCriterion("DELAYED_REPLY is not null");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyEqualTo(String value) {
            addCriterion("DELAYED_REPLY =", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyNotEqualTo(String value) {
            addCriterion("DELAYED_REPLY <>", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyGreaterThan(String value) {
            addCriterion("DELAYED_REPLY >", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyGreaterThanOrEqualTo(String value) {
            addCriterion("DELAYED_REPLY >=", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyLessThan(String value) {
            addCriterion("DELAYED_REPLY <", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyLessThanOrEqualTo(String value) {
            addCriterion("DELAYED_REPLY <=", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyLike(String value) {
            addCriterion("DELAYED_REPLY like", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyNotLike(String value) {
            addCriterion("DELAYED_REPLY not like", value, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyIn(List<String> values) {
            addCriterion("DELAYED_REPLY in", values, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyNotIn(List<String> values) {
            addCriterion("DELAYED_REPLY not in", values, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyBetween(String value1, String value2) {
            addCriterion("DELAYED_REPLY between", value1, value2, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andDelayedReplyNotBetween(String value1, String value2) {
            addCriterion("DELAYED_REPLY not between", value1, value2, "delayedReply");
            return (Criteria) this;
        }

        public Criteria andCaseAmountIsNull() {
            addCriterion("CASE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCaseAmountIsNotNull() {
            addCriterion("CASE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAmountEqualTo(BigDecimal value) {
            addCriterion("CASE_AMOUNT =", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountNotEqualTo(BigDecimal value) {
            addCriterion("CASE_AMOUNT <>", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountGreaterThan(BigDecimal value) {
            addCriterion("CASE_AMOUNT >", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_AMOUNT >=", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountLessThan(BigDecimal value) {
            addCriterion("CASE_AMOUNT <", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_AMOUNT <=", value, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountIn(List<BigDecimal> values) {
            addCriterion("CASE_AMOUNT in", values, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountNotIn(List<BigDecimal> values) {
            addCriterion("CASE_AMOUNT not in", values, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_AMOUNT between", value1, value2, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_AMOUNT not between", value1, value2, "caseAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountIsNull() {
            addCriterion("CASE_ADMISSIBLE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountIsNotNull() {
            addCriterion("CASE_ADMISSIBLE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountEqualTo(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT =", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountNotEqualTo(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT <>", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountGreaterThan(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT >", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT >=", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountLessThan(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT <", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT <=", value, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountIn(List<BigDecimal> values) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT in", values, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountNotIn(List<BigDecimal> values) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT not in", values, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT between", value1, value2, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseAdmissibleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_ADMISSIBLE_AMOUNT not between", value1, value2, "caseAdmissibleAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountIsNull() {
            addCriterion("CASE_HANDLING_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountIsNotNull() {
            addCriterion("CASE_HANDLING_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountEqualTo(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT =", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountNotEqualTo(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT <>", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountGreaterThan(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT >", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT >=", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountLessThan(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT <", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CASE_HANDLING_AMOUNT <=", value, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountIn(List<BigDecimal> values) {
            addCriterion("CASE_HANDLING_AMOUNT in", values, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountNotIn(List<BigDecimal> values) {
            addCriterion("CASE_HANDLING_AMOUNT not in", values, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_HANDLING_AMOUNT between", value1, value2, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andCaseHandlingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CASE_HANDLING_AMOUNT not between", value1, value2, "caseHandlingAmount");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("PAY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("PAY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(String value) {
            addCriterion("PAY_ID =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(String value) {
            addCriterion("PAY_ID <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(String value) {
            addCriterion("PAY_ID >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_ID >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(String value) {
            addCriterion("PAY_ID <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(String value) {
            addCriterion("PAY_ID <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLike(String value) {
            addCriterion("PAY_ID like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotLike(String value) {
            addCriterion("PAY_ID not like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<String> values) {
            addCriterion("PAY_ID in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<String> values) {
            addCriterion("PAY_ID not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(String value1, String value2) {
            addCriterion("PAY_ID between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(String value1, String value2) {
            addCriterion("PAY_ID not between", value1, value2, "payId");
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

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("PAY_STATUS like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("PAY_STATUS not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIsNull() {
            addCriterion("PAY_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIsNotNull() {
            addCriterion("PAY_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeEqualTo(Date value) {
            addCriterion("PAY_END_TIME =", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotEqualTo(Date value) {
            addCriterion("PAY_END_TIME <>", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeGreaterThan(Date value) {
            addCriterion("PAY_END_TIME >", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAY_END_TIME >=", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeLessThan(Date value) {
            addCriterion("PAY_END_TIME <", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAY_END_TIME <=", value, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeIn(List<Date> values) {
            addCriterion("PAY_END_TIME in", values, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotIn(List<Date> values) {
            addCriterion("PAY_END_TIME not in", values, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeBetween(Date value1, Date value2) {
            addCriterion("PAY_END_TIME between", value1, value2, "payEndTime");
            return (Criteria) this;
        }

        public Criteria andPayEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAY_END_TIME not between", value1, value2, "payEndTime");
            return (Criteria) this;
        }
    }

    /**
     * case_request_info
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_request_info
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