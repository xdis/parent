package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaseProposerExample {
    /**
     * case_proposer
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public CaseProposerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * case_proposer
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
     * case_proposer
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table case_proposer
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

        public Criteria andPropNameIsNull() {
            addCriterion("PROP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPropNameIsNotNull() {
            addCriterion("PROP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPropNameEqualTo(String value) {
            addCriterion("PROP_NAME =", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotEqualTo(String value) {
            addCriterion("PROP_NAME <>", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThan(String value) {
            addCriterion("PROP_NAME >", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_NAME >=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThan(String value) {
            addCriterion("PROP_NAME <", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThanOrEqualTo(String value) {
            addCriterion("PROP_NAME <=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLike(String value) {
            addCriterion("PROP_NAME like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotLike(String value) {
            addCriterion("PROP_NAME not like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameIn(List<String> values) {
            addCriterion("PROP_NAME in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotIn(List<String> values) {
            addCriterion("PROP_NAME not in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameBetween(String value1, String value2) {
            addCriterion("PROP_NAME between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotBetween(String value1, String value2) {
            addCriterion("PROP_NAME not between", value1, value2, "propName");
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

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
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

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
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

        public Criteria andPropTypeIsNull() {
            addCriterion("PROP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPropTypeIsNotNull() {
            addCriterion("PROP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPropTypeEqualTo(String value) {
            addCriterion("PROP_TYPE =", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotEqualTo(String value) {
            addCriterion("PROP_TYPE <>", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThan(String value) {
            addCriterion("PROP_TYPE >", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_TYPE >=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThan(String value) {
            addCriterion("PROP_TYPE <", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLessThanOrEqualTo(String value) {
            addCriterion("PROP_TYPE <=", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeLike(String value) {
            addCriterion("PROP_TYPE like", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotLike(String value) {
            addCriterion("PROP_TYPE not like", value, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeIn(List<String> values) {
            addCriterion("PROP_TYPE in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotIn(List<String> values) {
            addCriterion("PROP_TYPE not in", values, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeBetween(String value1, String value2) {
            addCriterion("PROP_TYPE between", value1, value2, "propType");
            return (Criteria) this;
        }

        public Criteria andPropTypeNotBetween(String value1, String value2) {
            addCriterion("PROP_TYPE not between", value1, value2, "propType");
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
    }

    /**
     * case_proposer
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table case_proposer
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