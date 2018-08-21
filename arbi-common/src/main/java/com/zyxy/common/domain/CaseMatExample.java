package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.List;

public class CaseMatExample {
    /**
     * case_mat
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * case_mat
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * case_mat
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_mat
     * @mbggenerated
     */
    public CaseMatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_mat
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
     * case_mat
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_mat
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_mat
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

        public Criteria andAttachNameIsNull() {
            addCriterion("ATTACH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAttachNameIsNotNull() {
            addCriterion("ATTACH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAttachNameEqualTo(String value) {
            addCriterion("ATTACH_NAME =", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotEqualTo(String value) {
            addCriterion("ATTACH_NAME <>", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameGreaterThan(String value) {
            addCriterion("ATTACH_NAME >", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameGreaterThanOrEqualTo(String value) {
            addCriterion("ATTACH_NAME >=", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLessThan(String value) {
            addCriterion("ATTACH_NAME <", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLessThanOrEqualTo(String value) {
            addCriterion("ATTACH_NAME <=", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameLike(String value) {
            addCriterion("ATTACH_NAME like", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotLike(String value) {
            addCriterion("ATTACH_NAME not like", value, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameIn(List<String> values) {
            addCriterion("ATTACH_NAME in", values, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotIn(List<String> values) {
            addCriterion("ATTACH_NAME not in", values, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameBetween(String value1, String value2) {
            addCriterion("ATTACH_NAME between", value1, value2, "attachName");
            return (Criteria) this;
        }

        public Criteria andAttachNameNotBetween(String value1, String value2) {
            addCriterion("ATTACH_NAME not between", value1, value2,
                    "attachName");
            return (Criteria) this;
        }

        public Criteria andMatTypeIsNull() {
            addCriterion("MAT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMatTypeIsNotNull() {
            addCriterion("MAT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMatTypeEqualTo(String value) {
            addCriterion("MAT_TYPE =", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeNotEqualTo(String value) {
            addCriterion("MAT_TYPE <>", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeGreaterThan(String value) {
            addCriterion("MAT_TYPE >", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MAT_TYPE >=", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeLessThan(String value) {
            addCriterion("MAT_TYPE <", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeLessThanOrEqualTo(String value) {
            addCriterion("MAT_TYPE <=", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeLike(String value) {
            addCriterion("MAT_TYPE like", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeNotLike(String value) {
            addCriterion("MAT_TYPE not like", value, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeIn(List<String> values) {
            addCriterion("MAT_TYPE in", values, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeNotIn(List<String> values) {
            addCriterion("MAT_TYPE not in", values, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeBetween(String value1, String value2) {
            addCriterion("MAT_TYPE between", value1, value2, "matType");
            return (Criteria) this;
        }

        public Criteria andMatTypeNotBetween(String value1, String value2) {
            addCriterion("MAT_TYPE not between", value1, value2, "matType");
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

        public Criteria andEvidenceMatIsNull() {
            addCriterion("EVIDENCE_MAT is null");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatIsNotNull() {
            addCriterion("EVIDENCE_MAT is not null");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatEqualTo(String value) {
            addCriterion("EVIDENCE_MAT =", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatNotEqualTo(String value) {
            addCriterion("EVIDENCE_MAT <>", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatGreaterThan(String value) {
            addCriterion("EVIDENCE_MAT >", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatGreaterThanOrEqualTo(String value) {
            addCriterion("EVIDENCE_MAT >=", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatLessThan(String value) {
            addCriterion("EVIDENCE_MAT <", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatLessThanOrEqualTo(String value) {
            addCriterion("EVIDENCE_MAT <=", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatLike(String value) {
            addCriterion("EVIDENCE_MAT like", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatNotLike(String value) {
            addCriterion("EVIDENCE_MAT not like", value, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatIn(List<String> values) {
            addCriterion("EVIDENCE_MAT in", values, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatNotIn(List<String> values) {
            addCriterion("EVIDENCE_MAT not in", values, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatBetween(String value1, String value2) {
            addCriterion("EVIDENCE_MAT between", value1, value2, "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andEvidenceMatNotBetween(String value1, String value2) {
            addCriterion("EVIDENCE_MAT not between", value1, value2,
                    "evidenceMat");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceIsNull() {
            addCriterion("PURPOSE_EVIDENCE is null");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceIsNotNull() {
            addCriterion("PURPOSE_EVIDENCE is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceEqualTo(String value) {
            addCriterion("PURPOSE_EVIDENCE =", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceNotEqualTo(String value) {
            addCriterion("PURPOSE_EVIDENCE <>", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceGreaterThan(String value) {
            addCriterion("PURPOSE_EVIDENCE >", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceGreaterThanOrEqualTo(String value) {
            addCriterion("PURPOSE_EVIDENCE >=", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceLessThan(String value) {
            addCriterion("PURPOSE_EVIDENCE <", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceLessThanOrEqualTo(String value) {
            addCriterion("PURPOSE_EVIDENCE <=", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceLike(String value) {
            addCriterion("PURPOSE_EVIDENCE like", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceNotLike(String value) {
            addCriterion("PURPOSE_EVIDENCE not like", value, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceIn(List<String> values) {
            addCriterion("PURPOSE_EVIDENCE in", values, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceNotIn(List<String> values) {
            addCriterion("PURPOSE_EVIDENCE not in", values, "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceBetween(String value1, String value2) {
            addCriterion("PURPOSE_EVIDENCE between", value1, value2,
                    "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andPurposeEvidenceNotBetween(String value1,
                String value2) {
            addCriterion("PURPOSE_EVIDENCE not between", value1, value2,
                    "purposeEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceIsNull() {
            addCriterion("SOURCE_EVIDENCE is null");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceIsNotNull() {
            addCriterion("SOURCE_EVIDENCE is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceEqualTo(String value) {
            addCriterion("SOURCE_EVIDENCE =", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceNotEqualTo(String value) {
            addCriterion("SOURCE_EVIDENCE <>", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceGreaterThan(String value) {
            addCriterion("SOURCE_EVIDENCE >", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_EVIDENCE >=", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceLessThan(String value) {
            addCriterion("SOURCE_EVIDENCE <", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_EVIDENCE <=", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceLike(String value) {
            addCriterion("SOURCE_EVIDENCE like", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceNotLike(String value) {
            addCriterion("SOURCE_EVIDENCE not like", value, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceIn(List<String> values) {
            addCriterion("SOURCE_EVIDENCE in", values, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceNotIn(List<String> values) {
            addCriterion("SOURCE_EVIDENCE not in", values, "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceBetween(String value1, String value2) {
            addCriterion("SOURCE_EVIDENCE between", value1, value2,
                    "sourceEvidence");
            return (Criteria) this;
        }

        public Criteria andSourceEvidenceNotBetween(String value1, String value2) {
            addCriterion("SOURCE_EVIDENCE not between", value1, value2,
                    "sourceEvidence");
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

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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

        public Criteria andCounterclaimFlagIsNull() {
            addCriterion("COUNTERCLAIM_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagIsNotNull() {
            addCriterion("COUNTERCLAIM_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagEqualTo(String value) {
            addCriterion("COUNTERCLAIM_FLAG =", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagNotEqualTo(String value) {
            addCriterion("COUNTERCLAIM_FLAG <>", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagGreaterThan(String value) {
            addCriterion("COUNTERCLAIM_FLAG >", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTERCLAIM_FLAG >=", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagLessThan(String value) {
            addCriterion("COUNTERCLAIM_FLAG <", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagLessThanOrEqualTo(String value) {
            addCriterion("COUNTERCLAIM_FLAG <=", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagLike(String value) {
            addCriterion("COUNTERCLAIM_FLAG like", value, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagNotLike(String value) {
            addCriterion("COUNTERCLAIM_FLAG not like", value,
                    "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagIn(List<String> values) {
            addCriterion("COUNTERCLAIM_FLAG in", values, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagNotIn(List<String> values) {
            addCriterion("COUNTERCLAIM_FLAG not in", values, "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagBetween(String value1, String value2) {
            addCriterion("COUNTERCLAIM_FLAG between", value1, value2,
                    "counterclaimFlag");
            return (Criteria) this;
        }

        public Criteria andCounterclaimFlagNotBetween(String value1,
                String value2) {
            addCriterion("COUNTERCLAIM_FLAG not between", value1, value2,
                    "counterclaimFlag");
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

        public Criteria andSignSignatureLogIdIsNull() {
            addCriterion("SIGN_SIGNATURE_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdIsNotNull() {
            addCriterion("SIGN_SIGNATURE_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdEqualTo(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID =", value, "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdNotEqualTo(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID <>", value,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdGreaterThan(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID >", value, "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID >=", value,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdLessThan(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID <", value, "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdLessThanOrEqualTo(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID <=", value,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdLike(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID like", value,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdNotLike(String value) {
            addCriterion("SIGN_SIGNATURE_LOG_ID not like", value,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdIn(List<String> values) {
            addCriterion("SIGN_SIGNATURE_LOG_ID in", values,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdNotIn(List<String> values) {
            addCriterion("SIGN_SIGNATURE_LOG_ID not in", values,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdBetween(String value1,
                String value2) {
            addCriterion("SIGN_SIGNATURE_LOG_ID between", value1, value2,
                    "signSignatureLogId");
            return (Criteria) this;
        }

        public Criteria andSignSignatureLogIdNotBetween(String value1,
                String value2) {
            addCriterion("SIGN_SIGNATURE_LOG_ID not between", value1, value2,
                    "signSignatureLogId");
            return (Criteria) this;
        }
    }

    /**
     * For table case_mat
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
     * case_mat
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}