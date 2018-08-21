package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CaseDocExample {
    /**
     * case_doc
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * case_doc
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * case_doc
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_doc
     * @mbggenerated
     */
    public CaseDocExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_doc
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
     * case_doc
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_doc
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_doc
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

        public Criteria andDocNameIsNull() {
            addCriterion("DOC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNotNull() {
            addCriterion("DOC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDocNameEqualTo(String value) {
            addCriterion("DOC_NAME =", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("DOC_NAME <>", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("DOC_NAME >", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_NAME >=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThan(String value) {
            addCriterion("DOC_NAME <", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("DOC_NAME <=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLike(String value) {
            addCriterion("DOC_NAME like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotLike(String value) {
            addCriterion("DOC_NAME not like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameIn(List<String> values) {
            addCriterion("DOC_NAME in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("DOC_NAME not in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("DOC_NAME between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("DOC_NAME not between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNull() {
            addCriterion("DOC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNotNull() {
            addCriterion("DOC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("DOC_TYPE =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotEqualTo(String value) {
            addCriterion("DOC_TYPE <>", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThan(String value) {
            addCriterion("DOC_TYPE >", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_TYPE >=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThan(String value) {
            addCriterion("DOC_TYPE <", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThanOrEqualTo(String value) {
            addCriterion("DOC_TYPE <=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLike(String value) {
            addCriterion("DOC_TYPE like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotLike(String value) {
            addCriterion("DOC_TYPE not like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeIn(List<String> values) {
            addCriterion("DOC_TYPE in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotIn(List<String> values) {
            addCriterion("DOC_TYPE not in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeBetween(String value1, String value2) {
            addCriterion("DOC_TYPE between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotBetween(String value1, String value2) {
            addCriterion("DOC_TYPE not between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andSignStatusIsNull() {
            addCriterion("SIGN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSignStatusIsNotNull() {
            addCriterion("SIGN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSignStatusEqualTo(String value) {
            addCriterion("SIGN_STATUS =", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotEqualTo(String value) {
            addCriterion("SIGN_STATUS <>", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThan(String value) {
            addCriterion("SIGN_STATUS >", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_STATUS >=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThan(String value) {
            addCriterion("SIGN_STATUS <", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThanOrEqualTo(String value) {
            addCriterion("SIGN_STATUS <=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLike(String value) {
            addCriterion("SIGN_STATUS like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotLike(String value) {
            addCriterion("SIGN_STATUS not like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusIn(List<String> values) {
            addCriterion("SIGN_STATUS in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotIn(List<String> values) {
            addCriterion("SIGN_STATUS not in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusBetween(String value1, String value2) {
            addCriterion("SIGN_STATUS between", value1, value2, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotBetween(String value1, String value2) {
            addCriterion("SIGN_STATUS not between", value1, value2,
                    "signStatus");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("FILE_ID =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("FILE_ID <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("FILE_ID >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ID >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("FILE_ID <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("FILE_ID <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("FILE_ID like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("FILE_ID not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("FILE_ID in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("FILE_ID not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("FILE_ID between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("FILE_ID not between", value1, value2, "fileId");
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

        public Criteria andLogisticsStatusIsNull() {
            addCriterion("LOGISTICS_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusIsNotNull() {
            addCriterion("LOGISTICS_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusEqualTo(String value) {
            addCriterion("LOGISTICS_STATUS =", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotEqualTo(String value) {
            addCriterion("LOGISTICS_STATUS <>", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusGreaterThan(String value) {
            addCriterion("LOGISTICS_STATUS >", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("LOGISTICS_STATUS >=", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusLessThan(String value) {
            addCriterion("LOGISTICS_STATUS <", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusLessThanOrEqualTo(String value) {
            addCriterion("LOGISTICS_STATUS <=", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusLike(String value) {
            addCriterion("LOGISTICS_STATUS like", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotLike(String value) {
            addCriterion("LOGISTICS_STATUS not like", value, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusIn(List<String> values) {
            addCriterion("LOGISTICS_STATUS in", values, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotIn(List<String> values) {
            addCriterion("LOGISTICS_STATUS not in", values, "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusBetween(String value1, String value2) {
            addCriterion("LOGISTICS_STATUS between", value1, value2,
                    "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsStatusNotBetween(String value1,
                String value2) {
            addCriterion("LOGISTICS_STATUS not between", value1, value2,
                    "logisticsStatus");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberIsNull() {
            addCriterion("DOC_YEAR_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberIsNotNull() {
            addCriterion("DOC_YEAR_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberEqualTo(String value) {
            addCriterion("DOC_YEAR_NUMBER =", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberNotEqualTo(String value) {
            addCriterion("DOC_YEAR_NUMBER <>", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberGreaterThan(String value) {
            addCriterion("DOC_YEAR_NUMBER >", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_YEAR_NUMBER >=", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberLessThan(String value) {
            addCriterion("DOC_YEAR_NUMBER <", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberLessThanOrEqualTo(String value) {
            addCriterion("DOC_YEAR_NUMBER <=", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberLike(String value) {
            addCriterion("DOC_YEAR_NUMBER like", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberNotLike(String value) {
            addCriterion("DOC_YEAR_NUMBER not like", value, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberIn(List<String> values) {
            addCriterion("DOC_YEAR_NUMBER in", values, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberNotIn(List<String> values) {
            addCriterion("DOC_YEAR_NUMBER not in", values, "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberBetween(String value1, String value2) {
            addCriterion("DOC_YEAR_NUMBER between", value1, value2,
                    "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocYearNumberNotBetween(String value1, String value2) {
            addCriterion("DOC_YEAR_NUMBER not between", value1, value2,
                    "docYearNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberIsNull() {
            addCriterion("DOC_SERIAL_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberIsNotNull() {
            addCriterion("DOC_SERIAL_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberEqualTo(String value) {
            addCriterion("DOC_SERIAL_NUMBER =", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberNotEqualTo(String value) {
            addCriterion("DOC_SERIAL_NUMBER <>", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberGreaterThan(String value) {
            addCriterion("DOC_SERIAL_NUMBER >", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_SERIAL_NUMBER >=", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberLessThan(String value) {
            addCriterion("DOC_SERIAL_NUMBER <", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("DOC_SERIAL_NUMBER <=", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberLike(String value) {
            addCriterion("DOC_SERIAL_NUMBER like", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberNotLike(String value) {
            addCriterion("DOC_SERIAL_NUMBER not like", value, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberIn(List<String> values) {
            addCriterion("DOC_SERIAL_NUMBER in", values, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberNotIn(List<String> values) {
            addCriterion("DOC_SERIAL_NUMBER not in", values, "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberBetween(String value1, String value2) {
            addCriterion("DOC_SERIAL_NUMBER between", value1, value2,
                    "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDocSerialNumberNotBetween(String value1,
                String value2) {
            addCriterion("DOC_SERIAL_NUMBER not between", value1, value2,
                    "docSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdIsNull() {
            addCriterion("SIGN_SIGNET_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdIsNotNull() {
            addCriterion("SIGN_SIGNET_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdEqualTo(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID =", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdNotEqualTo(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID <>", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdGreaterThan(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID >", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID >=", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdLessThan(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID <", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdLessThanOrEqualTo(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID <=", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdLike(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID like", value, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdNotLike(String value) {
            addCriterion("SIGN_SIGNET_LOG_ID not like", value,
                    "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdIn(List<String> values) {
            addCriterion("SIGN_SIGNET_LOG_ID in", values, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdNotIn(List<String> values) {
            addCriterion("SIGN_SIGNET_LOG_ID not in", values, "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdBetween(String value1, String value2) {
            addCriterion("SIGN_SIGNET_LOG_ID between", value1, value2,
                    "signSignetLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignetLogIdNotBetween(String value1,
                String value2) {
            addCriterion("SIGN_SIGNET_LOG_ID not between", value1, value2,
                    "signSignetLogId");
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
            addCriterion("UPDATE_TIME not between", value1, value2,
                    "updateTime");
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
    }

    /**
     * For table case_doc
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
     * case_doc
     * @mbggenerated  do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}