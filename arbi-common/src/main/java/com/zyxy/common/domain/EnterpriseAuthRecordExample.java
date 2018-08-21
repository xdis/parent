package com.zyxy.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseAuthRecordExample {
    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public EnterpriseAuthRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * enterprise_auth_record
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
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table enterprise_auth_record
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeIsNull() {
            addCriterion("UNIFIED_SOCIAL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeIsNotNull() {
            addCriterion("UNIFIED_SOCIAL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeEqualTo(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE =", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeNotEqualTo(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE <>", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeGreaterThan(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE >", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE >=", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeLessThan(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE <", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeLessThanOrEqualTo(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE <=", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeLike(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE like", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeNotLike(String value) {
            addCriterion("UNIFIED_SOCIAL_CODE not like", value, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeIn(List<String> values) {
            addCriterion("UNIFIED_SOCIAL_CODE in", values, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeNotIn(List<String> values) {
            addCriterion("UNIFIED_SOCIAL_CODE not in", values, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeBetween(String value1, String value2) {
            addCriterion("UNIFIED_SOCIAL_CODE between", value1, value2, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andUnifiedSocialCodeNotBetween(String value1, String value2) {
            addCriterion("UNIFIED_SOCIAL_CODE not between", value1, value2, "unifiedSocialCode");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCertNameIsNull() {
            addCriterion("CERT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCertNameIsNotNull() {
            addCriterion("CERT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCertNameEqualTo(String value) {
            addCriterion("CERT_NAME =", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotEqualTo(String value) {
            addCriterion("CERT_NAME <>", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameGreaterThan(String value) {
            addCriterion("CERT_NAME >", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NAME >=", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLessThan(String value) {
            addCriterion("CERT_NAME <", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLessThanOrEqualTo(String value) {
            addCriterion("CERT_NAME <=", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameLike(String value) {
            addCriterion("CERT_NAME like", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotLike(String value) {
            addCriterion("CERT_NAME not like", value, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameIn(List<String> values) {
            addCriterion("CERT_NAME in", values, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotIn(List<String> values) {
            addCriterion("CERT_NAME not in", values, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameBetween(String value1, String value2) {
            addCriterion("CERT_NAME between", value1, value2, "certName");
            return (Criteria) this;
        }

        public Criteria andCertNameNotBetween(String value1, String value2) {
            addCriterion("CERT_NAME not between", value1, value2, "certName");
            return (Criteria) this;
        }

        public Criteria andCertDutiesIsNull() {
            addCriterion("CERT_DUTIES is null");
            return (Criteria) this;
        }

        public Criteria andCertDutiesIsNotNull() {
            addCriterion("CERT_DUTIES is not null");
            return (Criteria) this;
        }

        public Criteria andCertDutiesEqualTo(String value) {
            addCriterion("CERT_DUTIES =", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesNotEqualTo(String value) {
            addCriterion("CERT_DUTIES <>", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesGreaterThan(String value) {
            addCriterion("CERT_DUTIES >", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_DUTIES >=", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesLessThan(String value) {
            addCriterion("CERT_DUTIES <", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesLessThanOrEqualTo(String value) {
            addCriterion("CERT_DUTIES <=", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesLike(String value) {
            addCriterion("CERT_DUTIES like", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesNotLike(String value) {
            addCriterion("CERT_DUTIES not like", value, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesIn(List<String> values) {
            addCriterion("CERT_DUTIES in", values, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesNotIn(List<String> values) {
            addCriterion("CERT_DUTIES not in", values, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesBetween(String value1, String value2) {
            addCriterion("CERT_DUTIES between", value1, value2, "certDuties");
            return (Criteria) this;
        }

        public Criteria andCertDutiesNotBetween(String value1, String value2) {
            addCriterion("CERT_DUTIES not between", value1, value2, "certDuties");
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

        public Criteria andCardImageFrontIsNull() {
            addCriterion("CARD_IMAGE_FRONT is null");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontIsNotNull() {
            addCriterion("CARD_IMAGE_FRONT is not null");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontEqualTo(String value) {
            addCriterion("CARD_IMAGE_FRONT =", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontNotEqualTo(String value) {
            addCriterion("CARD_IMAGE_FRONT <>", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontGreaterThan(String value) {
            addCriterion("CARD_IMAGE_FRONT >", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_IMAGE_FRONT >=", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontLessThan(String value) {
            addCriterion("CARD_IMAGE_FRONT <", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontLessThanOrEqualTo(String value) {
            addCriterion("CARD_IMAGE_FRONT <=", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontLike(String value) {
            addCriterion("CARD_IMAGE_FRONT like", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontNotLike(String value) {
            addCriterion("CARD_IMAGE_FRONT not like", value, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontIn(List<String> values) {
            addCriterion("CARD_IMAGE_FRONT in", values, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontNotIn(List<String> values) {
            addCriterion("CARD_IMAGE_FRONT not in", values, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontBetween(String value1, String value2) {
            addCriterion("CARD_IMAGE_FRONT between", value1, value2, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageFrontNotBetween(String value1, String value2) {
            addCriterion("CARD_IMAGE_FRONT not between", value1, value2, "cardImageFront");
            return (Criteria) this;
        }

        public Criteria andCardImageConIsNull() {
            addCriterion("CARD_IMAGE_CON is null");
            return (Criteria) this;
        }

        public Criteria andCardImageConIsNotNull() {
            addCriterion("CARD_IMAGE_CON is not null");
            return (Criteria) this;
        }

        public Criteria andCardImageConEqualTo(String value) {
            addCriterion("CARD_IMAGE_CON =", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConNotEqualTo(String value) {
            addCriterion("CARD_IMAGE_CON <>", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConGreaterThan(String value) {
            addCriterion("CARD_IMAGE_CON >", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_IMAGE_CON >=", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConLessThan(String value) {
            addCriterion("CARD_IMAGE_CON <", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConLessThanOrEqualTo(String value) {
            addCriterion("CARD_IMAGE_CON <=", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConLike(String value) {
            addCriterion("CARD_IMAGE_CON like", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConNotLike(String value) {
            addCriterion("CARD_IMAGE_CON not like", value, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConIn(List<String> values) {
            addCriterion("CARD_IMAGE_CON in", values, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConNotIn(List<String> values) {
            addCriterion("CARD_IMAGE_CON not in", values, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConBetween(String value1, String value2) {
            addCriterion("CARD_IMAGE_CON between", value1, value2, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andCardImageConNotBetween(String value1, String value2) {
            addCriterion("CARD_IMAGE_CON not between", value1, value2, "cardImageCon");
            return (Criteria) this;
        }

        public Criteria andThreeInOneIsNull() {
            addCriterion("three_in_one is null");
            return (Criteria) this;
        }

        public Criteria andThreeInOneIsNotNull() {
            addCriterion("three_in_one is not null");
            return (Criteria) this;
        }

        public Criteria andThreeInOneEqualTo(String value) {
            addCriterion("three_in_one =", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneNotEqualTo(String value) {
            addCriterion("three_in_one <>", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneGreaterThan(String value) {
            addCriterion("three_in_one >", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneGreaterThanOrEqualTo(String value) {
            addCriterion("three_in_one >=", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneLessThan(String value) {
            addCriterion("three_in_one <", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneLessThanOrEqualTo(String value) {
            addCriterion("three_in_one <=", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneLike(String value) {
            addCriterion("three_in_one like", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneNotLike(String value) {
            addCriterion("three_in_one not like", value, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneIn(List<String> values) {
            addCriterion("three_in_one in", values, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneNotIn(List<String> values) {
            addCriterion("three_in_one not in", values, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneBetween(String value1, String value2) {
            addCriterion("three_in_one between", value1, value2, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andThreeInOneNotBetween(String value1, String value2) {
            addCriterion("three_in_one not between", value1, value2, "threeInOne");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthIsNull() {
            addCriterion("PLATFORM_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthIsNotNull() {
            addCriterion("PLATFORM_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthEqualTo(String value) {
            addCriterion("PLATFORM_AUTH =", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthNotEqualTo(String value) {
            addCriterion("PLATFORM_AUTH <>", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthGreaterThan(String value) {
            addCriterion("PLATFORM_AUTH >", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORM_AUTH >=", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthLessThan(String value) {
            addCriterion("PLATFORM_AUTH <", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthLessThanOrEqualTo(String value) {
            addCriterion("PLATFORM_AUTH <=", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthLike(String value) {
            addCriterion("PLATFORM_AUTH like", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthNotLike(String value) {
            addCriterion("PLATFORM_AUTH not like", value, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthIn(List<String> values) {
            addCriterion("PLATFORM_AUTH in", values, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthNotIn(List<String> values) {
            addCriterion("PLATFORM_AUTH not in", values, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthBetween(String value1, String value2) {
            addCriterion("PLATFORM_AUTH between", value1, value2, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andPlatformAuthNotBetween(String value1, String value2) {
            addCriterion("PLATFORM_AUTH not between", value1, value2, "platformAuth");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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
    }

    /**
     * enterprise_auth_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table enterprise_auth_record
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