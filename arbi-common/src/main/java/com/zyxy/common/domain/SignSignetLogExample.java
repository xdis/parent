package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignSignetLogExample {
    /**
     * sign_signet_log
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sign_signet_log
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sign_signet_log
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public SignSignetLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sign_signet_log
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
     * sign_signet_log
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sign_signet_log
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sign_signet_log
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

        public Criteria andDocFileIdIsNull() {
            addCriterion("DOC_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocFileIdIsNotNull() {
            addCriterion("DOC_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocFileIdEqualTo(String value) {
            addCriterion("DOC_FILE_ID =", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdNotEqualTo(String value) {
            addCriterion("DOC_FILE_ID <>", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdGreaterThan(String value) {
            addCriterion("DOC_FILE_ID >", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_FILE_ID >=", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdLessThan(String value) {
            addCriterion("DOC_FILE_ID <", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_FILE_ID <=", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdLike(String value) {
            addCriterion("DOC_FILE_ID like", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdNotLike(String value) {
            addCriterion("DOC_FILE_ID not like", value, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdIn(List<String> values) {
            addCriterion("DOC_FILE_ID in", values, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdNotIn(List<String> values) {
            addCriterion("DOC_FILE_ID not in", values, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdBetween(String value1, String value2) {
            addCriterion("DOC_FILE_ID between", value1, value2, "docFileId");
            return (Criteria) this;
        }

        public Criteria andDocFileIdNotBetween(String value1, String value2) {
            addCriterion("DOC_FILE_ID not between", value1, value2, "docFileId");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("CONTRACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("CONTRACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("CONTRACT_NAME =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("CONTRACT_NAME <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("CONTRACT_NAME >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("CONTRACT_NAME <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NAME <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("CONTRACT_NAME like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("CONTRACT_NAME not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("CONTRACT_NAME in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("CONTRACT_NAME not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME between", value1, value2,
                    "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NAME not between", value1, value2,
                    "contractName");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeIsNull() {
            addCriterion("SIGN_LEVEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeIsNotNull() {
            addCriterion("SIGN_LEVEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeEqualTo(String value) {
            addCriterion("SIGN_LEVEL_CODE =", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeNotEqualTo(String value) {
            addCriterion("SIGN_LEVEL_CODE <>", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeGreaterThan(String value) {
            addCriterion("SIGN_LEVEL_CODE >", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_LEVEL_CODE >=", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeLessThan(String value) {
            addCriterion("SIGN_LEVEL_CODE <", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("SIGN_LEVEL_CODE <=", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeLike(String value) {
            addCriterion("SIGN_LEVEL_CODE like", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeNotLike(String value) {
            addCriterion("SIGN_LEVEL_CODE not like", value, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeIn(List<String> values) {
            addCriterion("SIGN_LEVEL_CODE in", values, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeNotIn(List<String> values) {
            addCriterion("SIGN_LEVEL_CODE not in", values, "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeBetween(String value1, String value2) {
            addCriterion("SIGN_LEVEL_CODE between", value1, value2,
                    "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andSignLevelCodeNotBetween(String value1, String value2) {
            addCriterion("SIGN_LEVEL_CODE not between", value1, value2,
                    "signLevelCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeIsNull() {
            addCriterion("DEAL_TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeIsNotNull() {
            addCriterion("DEAL_TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeEqualTo(String value) {
            addCriterion("DEAL_TYPE_CODE =", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeNotEqualTo(String value) {
            addCriterion("DEAL_TYPE_CODE <>", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeGreaterThan(String value) {
            addCriterion("DEAL_TYPE_CODE >", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_TYPE_CODE >=", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeLessThan(String value) {
            addCriterion("DEAL_TYPE_CODE <", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("DEAL_TYPE_CODE <=", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeLike(String value) {
            addCriterion("DEAL_TYPE_CODE like", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeNotLike(String value) {
            addCriterion("DEAL_TYPE_CODE not like", value, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeIn(List<String> values) {
            addCriterion("DEAL_TYPE_CODE in", values, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeNotIn(List<String> values) {
            addCriterion("DEAL_TYPE_CODE not in", values, "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeBetween(String value1, String value2) {
            addCriterion("DEAL_TYPE_CODE between", value1, value2,
                    "dealTypeCode");
            return (Criteria) this;
        }

        public Criteria andDealTypeCodeNotBetween(String value1, String value2) {
            addCriterion("DEAL_TYPE_CODE not between", value1, value2,
                    "dealTypeCode");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNull() {
            addCriterion("APPLY_NO is null");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNotNull() {
            addCriterion("APPLY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNoEqualTo(String value) {
            addCriterion("APPLY_NO =", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotEqualTo(String value) {
            addCriterion("APPLY_NO <>", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThan(String value) {
            addCriterion("APPLY_NO >", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_NO >=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThan(String value) {
            addCriterion("APPLY_NO <", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThanOrEqualTo(String value) {
            addCriterion("APPLY_NO <=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLike(String value) {
            addCriterion("APPLY_NO like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotLike(String value) {
            addCriterion("APPLY_NO not like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoIn(List<String> values) {
            addCriterion("APPLY_NO in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotIn(List<String> values) {
            addCriterion("APPLY_NO not in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoBetween(String value1, String value2) {
            addCriterion("APPLY_NO between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotBetween(String value1, String value2) {
            addCriterion("APPLY_NO not between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNull() {
            addCriterion("RECORD_NO is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("RECORD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(String value) {
            addCriterion("RECORD_NO =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(String value) {
            addCriterion("RECORD_NO <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(String value) {
            addCriterion("RECORD_NO >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_NO >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(String value) {
            addCriterion("RECORD_NO <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(String value) {
            addCriterion("RECORD_NO <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLike(String value) {
            addCriterion("RECORD_NO like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotLike(String value) {
            addCriterion("RECORD_NO not like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<String> values) {
            addCriterion("RECORD_NO in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<String> values) {
            addCriterion("RECORD_NO not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(String value1, String value2) {
            addCriterion("RECORD_NO between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(String value1, String value2) {
            addCriterion("RECORD_NO not between", value1, value2, "recordNo");
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
            addCriterion("UPDATE_TIME not between", value1, value2,
                    "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * For table sign_signet_log
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
     * sign_signet_log
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}