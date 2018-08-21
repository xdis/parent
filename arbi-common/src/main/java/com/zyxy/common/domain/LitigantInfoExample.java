package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LitigantInfoExample {
    /**
     * litigant_info
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public LitigantInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * litigant_info
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
     * litigant_info
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table litigant_info
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

        public Criteria andCardIdIsNull() {
            addCriterion("CARD_ID is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("CARD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("CARD_ID =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("CARD_ID <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("CARD_ID >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_ID >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("CARD_ID <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("CARD_ID <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("CARD_ID like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("CARD_ID not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("CARD_ID in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("CARD_ID not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("CARD_ID between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("CARD_ID not between", value1, value2, "cardId");
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

        public Criteria andBusiImgIdIsNull() {
            addCriterion("BUSI_IMG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdIsNotNull() {
            addCriterion("BUSI_IMG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdEqualTo(String value) {
            addCriterion("BUSI_IMG_ID =", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdNotEqualTo(String value) {
            addCriterion("BUSI_IMG_ID <>", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdGreaterThan(String value) {
            addCriterion("BUSI_IMG_ID >", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_IMG_ID >=", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdLessThan(String value) {
            addCriterion("BUSI_IMG_ID <", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdLessThanOrEqualTo(String value) {
            addCriterion("BUSI_IMG_ID <=", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdLike(String value) {
            addCriterion("BUSI_IMG_ID like", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdNotLike(String value) {
            addCriterion("BUSI_IMG_ID not like", value, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdIn(List<String> values) {
            addCriterion("BUSI_IMG_ID in", values, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdNotIn(List<String> values) {
            addCriterion("BUSI_IMG_ID not in", values, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdBetween(String value1, String value2) {
            addCriterion("BUSI_IMG_ID between", value1, value2, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andBusiImgIdNotBetween(String value1, String value2) {
            addCriterion("BUSI_IMG_ID not between", value1, value2, "busiImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdIsNull() {
            addCriterion("CERT_OFFICE_IMG_ID is null");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdIsNotNull() {
            addCriterion("CERT_OFFICE_IMG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdEqualTo(String value) {
            addCriterion("CERT_OFFICE_IMG_ID =", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdNotEqualTo(String value) {
            addCriterion("CERT_OFFICE_IMG_ID <>", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdGreaterThan(String value) {
            addCriterion("CERT_OFFICE_IMG_ID >", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_OFFICE_IMG_ID >=", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdLessThan(String value) {
            addCriterion("CERT_OFFICE_IMG_ID <", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdLessThanOrEqualTo(String value) {
            addCriterion("CERT_OFFICE_IMG_ID <=", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdLike(String value) {
            addCriterion("CERT_OFFICE_IMG_ID like", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdNotLike(String value) {
            addCriterion("CERT_OFFICE_IMG_ID not like", value, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdIn(List<String> values) {
            addCriterion("CERT_OFFICE_IMG_ID in", values, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdNotIn(List<String> values) {
            addCriterion("CERT_OFFICE_IMG_ID not in", values, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdBetween(String value1, String value2) {
            addCriterion("CERT_OFFICE_IMG_ID between", value1, value2, "certOfficeImgId");
            return (Criteria) this;
        }

        public Criteria andCertOfficeImgIdNotBetween(String value1, String value2) {
            addCriterion("CERT_OFFICE_IMG_ID not between", value1, value2, "certOfficeImgId");
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

        public Criteria andEthnicIsNull() {
            addCriterion("ETHNIC is null");
            return (Criteria) this;
        }

        public Criteria andEthnicIsNotNull() {
            addCriterion("ETHNIC is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicEqualTo(String value) {
            addCriterion("ETHNIC =", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotEqualTo(String value) {
            addCriterion("ETHNIC <>", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThan(String value) {
            addCriterion("ETHNIC >", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThanOrEqualTo(String value) {
            addCriterion("ETHNIC >=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThan(String value) {
            addCriterion("ETHNIC <", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThanOrEqualTo(String value) {
            addCriterion("ETHNIC <=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLike(String value) {
            addCriterion("ETHNIC like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotLike(String value) {
            addCriterion("ETHNIC not like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicIn(List<String> values) {
            addCriterion("ETHNIC in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotIn(List<String> values) {
            addCriterion("ETHNIC not in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicBetween(String value1, String value2) {
            addCriterion("ETHNIC between", value1, value2, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotBetween(String value1, String value2) {
            addCriterion("ETHNIC not between", value1, value2, "ethnic");
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

        public Criteria andElementVerifyStatusIsNull() {
            addCriterion("ELEMENT_VERIFY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusIsNotNull() {
            addCriterion("ELEMENT_VERIFY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusEqualTo(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS =", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusNotEqualTo(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS <>", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusGreaterThan(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS >", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS >=", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusLessThan(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS <", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusLessThanOrEqualTo(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS <=", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusLike(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS like", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusNotLike(String value) {
            addCriterion("ELEMENT_VERIFY_STATUS not like", value, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusIn(List<String> values) {
            addCriterion("ELEMENT_VERIFY_STATUS in", values, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusNotIn(List<String> values) {
            addCriterion("ELEMENT_VERIFY_STATUS not in", values, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusBetween(String value1, String value2) {
            addCriterion("ELEMENT_VERIFY_STATUS between", value1, value2, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andElementVerifyStatusNotBetween(String value1, String value2) {
            addCriterion("ELEMENT_VERIFY_STATUS not between", value1, value2, "elementVerifyStatus");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNull() {
            addCriterion("BANK_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNotNull() {
            addCriterion("BANK_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneEqualTo(String value) {
            addCriterion("BANK_PHONE =", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotEqualTo(String value) {
            addCriterion("BANK_PHONE <>", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThan(String value) {
            addCriterion("BANK_PHONE >", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_PHONE >=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThan(String value) {
            addCriterion("BANK_PHONE <", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThanOrEqualTo(String value) {
            addCriterion("BANK_PHONE <=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLike(String value) {
            addCriterion("BANK_PHONE like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotLike(String value) {
            addCriterion("BANK_PHONE not like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIn(List<String> values) {
            addCriterion("BANK_PHONE in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotIn(List<String> values) {
            addCriterion("BANK_PHONE not in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneBetween(String value1, String value2) {
            addCriterion("BANK_PHONE between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotBetween(String value1, String value2) {
            addCriterion("BANK_PHONE not between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNull() {
            addCriterion("BANK_CARD is null");
            return (Criteria) this;
        }

        public Criteria andBankCardIsNotNull() {
            addCriterion("BANK_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardEqualTo(String value) {
            addCriterion("BANK_CARD =", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotEqualTo(String value) {
            addCriterion("BANK_CARD <>", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThan(String value) {
            addCriterion("BANK_CARD >", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CARD >=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThan(String value) {
            addCriterion("BANK_CARD <", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLessThanOrEqualTo(String value) {
            addCriterion("BANK_CARD <=", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardLike(String value) {
            addCriterion("BANK_CARD like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotLike(String value) {
            addCriterion("BANK_CARD not like", value, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardIn(List<String> values) {
            addCriterion("BANK_CARD in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotIn(List<String> values) {
            addCriterion("BANK_CARD not in", values, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardBetween(String value1, String value2) {
            addCriterion("BANK_CARD between", value1, value2, "bankCard");
            return (Criteria) this;
        }

        public Criteria andBankCardNotBetween(String value1, String value2) {
            addCriterion("BANK_CARD not between", value1, value2, "bankCard");
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

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("ENTERPRISE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("ENTERPRISE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(String value) {
            addCriterion("ENTERPRISE_TYPE >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(String value) {
            addCriterion("ENTERPRISE_TYPE <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(String value) {
            addCriterion("ENTERPRISE_TYPE <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLike(String value) {
            addCriterion("ENTERPRISE_TYPE like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotLike(String value) {
            addCriterion("ENTERPRISE_TYPE not like", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<String> values) {
            addCriterion("ENTERPRISE_TYPE not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(String value1, String value2) {
            addCriterion("ENTERPRISE_TYPE not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }
    }

    /**
     * litigant_info
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table litigant_info
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