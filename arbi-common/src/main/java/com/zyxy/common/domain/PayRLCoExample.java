package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayRLCoExample {
    /**
     * pay_rl_co
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * pay_rl_co
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * pay_rl_co
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public PayRLCoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * pay_rl_co
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
     * pay_rl_co
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * pay_rl_co
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table pay_rl_co
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

        public Criteria andSyncTypeIsNull() {
            addCriterion("SYNC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIsNotNull() {
            addCriterion("SYNC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSyncTypeEqualTo(Integer value) {
            addCriterion("SYNC_TYPE =", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotEqualTo(Integer value) {
            addCriterion("SYNC_TYPE <>", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThan(Integer value) {
            addCriterion("SYNC_TYPE >", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYNC_TYPE >=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThan(Integer value) {
            addCriterion("SYNC_TYPE <", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SYNC_TYPE <=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIn(List<Integer> values) {
            addCriterion("SYNC_TYPE in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotIn(List<Integer> values) {
            addCriterion("SYNC_TYPE not in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_TYPE between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_TYPE not between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andCoNoIsNull() {
            addCriterion("CO_NO is null");
            return (Criteria) this;
        }

        public Criteria andCoNoIsNotNull() {
            addCriterion("CO_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCoNoEqualTo(String value) {
            addCriterion("CO_NO =", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoNotEqualTo(String value) {
            addCriterion("CO_NO <>", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoGreaterThan(String value) {
            addCriterion("CO_NO >", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoGreaterThanOrEqualTo(String value) {
            addCriterion("CO_NO >=", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoLessThan(String value) {
            addCriterion("CO_NO <", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoLessThanOrEqualTo(String value) {
            addCriterion("CO_NO <=", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoLike(String value) {
            addCriterion("CO_NO like", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoNotLike(String value) {
            addCriterion("CO_NO not like", value, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoIn(List<String> values) {
            addCriterion("CO_NO in", values, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoNotIn(List<String> values) {
            addCriterion("CO_NO not in", values, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoBetween(String value1, String value2) {
            addCriterion("CO_NO between", value1, value2, "coNo");
            return (Criteria) this;
        }

        public Criteria andCoNoNotBetween(String value1, String value2) {
            addCriterion("CO_NO not between", value1, value2, "coNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoIsNull() {
            addCriterion("PARENT_CO_NO is null");
            return (Criteria) this;
        }

        public Criteria andParentCoNoIsNotNull() {
            addCriterion("PARENT_CO_NO is not null");
            return (Criteria) this;
        }

        public Criteria andParentCoNoEqualTo(String value) {
            addCriterion("PARENT_CO_NO =", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoNotEqualTo(String value) {
            addCriterion("PARENT_CO_NO <>", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoGreaterThan(String value) {
            addCriterion("PARENT_CO_NO >", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_CO_NO >=", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoLessThan(String value) {
            addCriterion("PARENT_CO_NO <", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoLessThanOrEqualTo(String value) {
            addCriterion("PARENT_CO_NO <=", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoLike(String value) {
            addCriterion("PARENT_CO_NO like", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoNotLike(String value) {
            addCriterion("PARENT_CO_NO not like", value, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoIn(List<String> values) {
            addCriterion("PARENT_CO_NO in", values, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoNotIn(List<String> values) {
            addCriterion("PARENT_CO_NO not in", values, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoBetween(String value1, String value2) {
            addCriterion("PARENT_CO_NO between", value1, value2, "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andParentCoNoNotBetween(String value1, String value2) {
            addCriterion("PARENT_CO_NO not between", value1, value2,
                    "parentCoNo");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNull() {
            addCriterion("CO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNotNull() {
            addCriterion("CO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCoNameEqualTo(String value) {
            addCriterion("CO_NAME =", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotEqualTo(String value) {
            addCriterion("CO_NAME <>", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThan(String value) {
            addCriterion("CO_NAME >", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThanOrEqualTo(String value) {
            addCriterion("CO_NAME >=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThan(String value) {
            addCriterion("CO_NAME <", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThanOrEqualTo(String value) {
            addCriterion("CO_NAME <=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLike(String value) {
            addCriterion("CO_NAME like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotLike(String value) {
            addCriterion("CO_NAME not like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameIn(List<String> values) {
            addCriterion("CO_NAME in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotIn(List<String> values) {
            addCriterion("CO_NAME not in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameBetween(String value1, String value2) {
            addCriterion("CO_NAME between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotBetween(String value1, String value2) {
            addCriterion("CO_NAME not between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("REGION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("REGION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("REGION_CODE =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("REGION_CODE <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("REGION_CODE >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_CODE >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("REGION_CODE <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("REGION_CODE <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("REGION_CODE like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("REGION_CODE not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("REGION_CODE in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("REGION_CODE not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("REGION_CODE between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("REGION_CODE not between", value1, value2,
                    "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("REGION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("REGION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("REGION_NAME =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("REGION_NAME <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("REGION_NAME >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_NAME >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("REGION_NAME <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("REGION_NAME <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("REGION_NAME like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("REGION_NAME not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("REGION_NAME in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("REGION_NAME not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("REGION_NAME between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("REGION_NAME not between", value1, value2,
                    "regionName");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("ADDR =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("ADDR <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("ADDR >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("ADDR <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("ADDR <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("ADDR like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("ADDR not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("ADDR in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("ADDR not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("ADDR between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("ADDR not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("CONTACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("CONTACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("CONTACT_NAME =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("CONTACT_NAME <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("CONTACT_NAME >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("CONTACT_NAME <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("CONTACT_NAME like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("CONTACT_NAME not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("CONTACT_NAME in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("CONTACT_NAME not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME not between", value1, value2,
                    "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("CONTACT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("CONTACT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("CONTACT_TEL =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("CONTACT_TEL <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("CONTACT_TEL >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("CONTACT_TEL <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("CONTACT_TEL like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("CONTACT_TEL not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("CONTACT_TEL in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("CONTACT_TEL not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL not between", value1, value2,
                    "contactTel");
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

        public Criteria andSyncTimeIsNull() {
            addCriterion("SYNC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSyncTimeIsNotNull() {
            addCriterion("SYNC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSyncTimeEqualTo(Date value) {
            addCriterion("SYNC_TIME =", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotEqualTo(Date value) {
            addCriterion("SYNC_TIME <>", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeGreaterThan(Date value) {
            addCriterion("SYNC_TIME >", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SYNC_TIME >=", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeLessThan(Date value) {
            addCriterion("SYNC_TIME <", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeLessThanOrEqualTo(Date value) {
            addCriterion("SYNC_TIME <=", value, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeIn(List<Date> values) {
            addCriterion("SYNC_TIME in", values, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotIn(List<Date> values) {
            addCriterion("SYNC_TIME not in", values, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeBetween(Date value1, Date value2) {
            addCriterion("SYNC_TIME between", value1, value2, "syncTime");
            return (Criteria) this;
        }

        public Criteria andSyncTimeNotBetween(Date value1, Date value2) {
            addCriterion("SYNC_TIME not between", value1, value2, "syncTime");
            return (Criteria) this;
        }
    }

    /**
     * For table pay_rl_co
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
     * pay_rl_co
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}