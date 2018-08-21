package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayRLItemsExample {
    /**
     * pay_rl_items
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * pay_rl_items
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * pay_rl_items
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public PayRLItemsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * pay_rl_items
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
     * pay_rl_items
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * pay_rl_items
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table pay_rl_items
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

        public Criteria andSyncTypeEqualTo(String value) {
            addCriterion("SYNC_TYPE =", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotEqualTo(String value) {
            addCriterion("SYNC_TYPE <>", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThan(String value) {
            addCriterion("SYNC_TYPE >", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SYNC_TYPE >=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThan(String value) {
            addCriterion("SYNC_TYPE <", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThanOrEqualTo(String value) {
            addCriterion("SYNC_TYPE <=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLike(String value) {
            addCriterion("SYNC_TYPE like", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotLike(String value) {
            addCriterion("SYNC_TYPE not like", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIn(List<String> values) {
            addCriterion("SYNC_TYPE in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotIn(List<String> values) {
            addCriterion("SYNC_TYPE not in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeBetween(String value1, String value2) {
            addCriterion("SYNC_TYPE between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotBetween(String value1, String value2) {
            addCriterion("SYNC_TYPE not between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andItemNoIsNull() {
            addCriterion("ITEM_NO is null");
            return (Criteria) this;
        }

        public Criteria andItemNoIsNotNull() {
            addCriterion("ITEM_NO is not null");
            return (Criteria) this;
        }

        public Criteria andItemNoEqualTo(String value) {
            addCriterion("ITEM_NO =", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotEqualTo(String value) {
            addCriterion("ITEM_NO <>", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoGreaterThan(String value) {
            addCriterion("ITEM_NO >", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NO >=", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLessThan(String value) {
            addCriterion("ITEM_NO <", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NO <=", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoLike(String value) {
            addCriterion("ITEM_NO like", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotLike(String value) {
            addCriterion("ITEM_NO not like", value, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoIn(List<String> values) {
            addCriterion("ITEM_NO in", values, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotIn(List<String> values) {
            addCriterion("ITEM_NO not in", values, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoBetween(String value1, String value2) {
            addCriterion("ITEM_NO between", value1, value2, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNoNotBetween(String value1, String value2) {
            addCriterion("ITEM_NO not between", value1, value2, "itemNo");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andManangerTypeIsNull() {
            addCriterion("MANANGER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andManangerTypeIsNotNull() {
            addCriterion("MANANGER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andManangerTypeEqualTo(String value) {
            addCriterion("MANANGER_TYPE =", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeNotEqualTo(String value) {
            addCriterion("MANANGER_TYPE <>", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeGreaterThan(String value) {
            addCriterion("MANANGER_TYPE >", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MANANGER_TYPE >=", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeLessThan(String value) {
            addCriterion("MANANGER_TYPE <", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeLessThanOrEqualTo(String value) {
            addCriterion("MANANGER_TYPE <=", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeLike(String value) {
            addCriterion("MANANGER_TYPE like", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeNotLike(String value) {
            addCriterion("MANANGER_TYPE not like", value, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeIn(List<String> values) {
            addCriterion("MANANGER_TYPE in", values, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeNotIn(List<String> values) {
            addCriterion("MANANGER_TYPE not in", values, "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeBetween(String value1, String value2) {
            addCriterion("MANANGER_TYPE between", value1, value2,
                    "manangerType");
            return (Criteria) this;
        }

        public Criteria andManangerTypeNotBetween(String value1, String value2) {
            addCriterion("MANANGER_TYPE not between", value1, value2,
                    "manangerType");
            return (Criteria) this;
        }

        public Criteria andChargeMaxIsNull() {
            addCriterion("CHARGE_MAX is null");
            return (Criteria) this;
        }

        public Criteria andChargeMaxIsNotNull() {
            addCriterion("CHARGE_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMaxEqualTo(Long value) {
            addCriterion("CHARGE_MAX =", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxNotEqualTo(Long value) {
            addCriterion("CHARGE_MAX <>", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxGreaterThan(Long value) {
            addCriterion("CHARGE_MAX >", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxGreaterThanOrEqualTo(Long value) {
            addCriterion("CHARGE_MAX >=", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxLessThan(Long value) {
            addCriterion("CHARGE_MAX <", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxLessThanOrEqualTo(Long value) {
            addCriterion("CHARGE_MAX <=", value, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxIn(List<Long> values) {
            addCriterion("CHARGE_MAX in", values, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxNotIn(List<Long> values) {
            addCriterion("CHARGE_MAX not in", values, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxBetween(Long value1, Long value2) {
            addCriterion("CHARGE_MAX between", value1, value2, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMaxNotBetween(Long value1, Long value2) {
            addCriterion("CHARGE_MAX not between", value1, value2, "chargeMax");
            return (Criteria) this;
        }

        public Criteria andChargeMinIsNull() {
            addCriterion("CHARGE_MIN is null");
            return (Criteria) this;
        }

        public Criteria andChargeMinIsNotNull() {
            addCriterion("CHARGE_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMinEqualTo(Long value) {
            addCriterion("CHARGE_MIN =", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinNotEqualTo(Long value) {
            addCriterion("CHARGE_MIN <>", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinGreaterThan(Long value) {
            addCriterion("CHARGE_MIN >", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinGreaterThanOrEqualTo(Long value) {
            addCriterion("CHARGE_MIN >=", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinLessThan(Long value) {
            addCriterion("CHARGE_MIN <", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinLessThanOrEqualTo(Long value) {
            addCriterion("CHARGE_MIN <=", value, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinIn(List<Long> values) {
            addCriterion("CHARGE_MIN in", values, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinNotIn(List<Long> values) {
            addCriterion("CHARGE_MIN not in", values, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinBetween(Long value1, Long value2) {
            addCriterion("CHARGE_MIN between", value1, value2, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeMinNotBetween(Long value1, Long value2) {
            addCriterion("CHARGE_MIN not between", value1, value2, "chargeMin");
            return (Criteria) this;
        }

        public Criteria andChargeUnitIsNull() {
            addCriterion("CHARGE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andChargeUnitIsNotNull() {
            addCriterion("CHARGE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andChargeUnitEqualTo(String value) {
            addCriterion("CHARGE_UNIT =", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitNotEqualTo(String value) {
            addCriterion("CHARGE_UNIT <>", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitGreaterThan(String value) {
            addCriterion("CHARGE_UNIT >", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_UNIT >=", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitLessThan(String value) {
            addCriterion("CHARGE_UNIT <", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_UNIT <=", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitLike(String value) {
            addCriterion("CHARGE_UNIT like", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitNotLike(String value) {
            addCriterion("CHARGE_UNIT not like", value, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitIn(List<String> values) {
            addCriterion("CHARGE_UNIT in", values, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitNotIn(List<String> values) {
            addCriterion("CHARGE_UNIT not in", values, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitBetween(String value1, String value2) {
            addCriterion("CHARGE_UNIT between", value1, value2, "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andChargeUnitNotBetween(String value1, String value2) {
            addCriterion("CHARGE_UNIT not between", value1, value2,
                    "chargeUnit");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoIsNull() {
            addCriterion("ITEM_TYPE_NO is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoIsNotNull() {
            addCriterion("ITEM_TYPE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoEqualTo(String value) {
            addCriterion("ITEM_TYPE_NO =", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoNotEqualTo(String value) {
            addCriterion("ITEM_TYPE_NO <>", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoGreaterThan(String value) {
            addCriterion("ITEM_TYPE_NO >", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE_NO >=", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoLessThan(String value) {
            addCriterion("ITEM_TYPE_NO <", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE_NO <=", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoLike(String value) {
            addCriterion("ITEM_TYPE_NO like", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoNotLike(String value) {
            addCriterion("ITEM_TYPE_NO not like", value, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoIn(List<String> values) {
            addCriterion("ITEM_TYPE_NO in", values, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoNotIn(List<String> values) {
            addCriterion("ITEM_TYPE_NO not in", values, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE_NO between", value1, value2, "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNoNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE_NO not between", value1, value2,
                    "itemTypeNo");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameIsNull() {
            addCriterion("ITEM_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameIsNotNull() {
            addCriterion("ITEM_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameEqualTo(String value) {
            addCriterion("ITEM_TYPE_NAME =", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameNotEqualTo(String value) {
            addCriterion("ITEM_TYPE_NAME <>", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameGreaterThan(String value) {
            addCriterion("ITEM_TYPE_NAME >", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE_NAME >=", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameLessThan(String value) {
            addCriterion("ITEM_TYPE_NAME <", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE_NAME <=", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameLike(String value) {
            addCriterion("ITEM_TYPE_NAME like", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameNotLike(String value) {
            addCriterion("ITEM_TYPE_NAME not like", value, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameIn(List<String> values) {
            addCriterion("ITEM_TYPE_NAME in", values, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameNotIn(List<String> values) {
            addCriterion("ITEM_TYPE_NAME not in", values, "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE_NAME between", value1, value2,
                    "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andItemTypeNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE_NAME not between", value1, value2,
                    "itemTypeName");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutIsNull() {
            addCriterion("CHARGE_IN_ACCOUT is null");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutIsNotNull() {
            addCriterion("CHARGE_IN_ACCOUT is not null");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutEqualTo(String value) {
            addCriterion("CHARGE_IN_ACCOUT =", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutNotEqualTo(String value) {
            addCriterion("CHARGE_IN_ACCOUT <>", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutGreaterThan(String value) {
            addCriterion("CHARGE_IN_ACCOUT >", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_IN_ACCOUT >=", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutLessThan(String value) {
            addCriterion("CHARGE_IN_ACCOUT <", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_IN_ACCOUT <=", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutLike(String value) {
            addCriterion("CHARGE_IN_ACCOUT like", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutNotLike(String value) {
            addCriterion("CHARGE_IN_ACCOUT not like", value, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutIn(List<String> values) {
            addCriterion("CHARGE_IN_ACCOUT in", values, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutNotIn(List<String> values) {
            addCriterion("CHARGE_IN_ACCOUT not in", values, "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutBetween(String value1, String value2) {
            addCriterion("CHARGE_IN_ACCOUT between", value1, value2,
                    "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInAccoutNotBetween(String value1, String value2) {
            addCriterion("CHARGE_IN_ACCOUT not between", value1, value2,
                    "chargeInAccout");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeIsNull() {
            addCriterion("CHARGE_IN_BANK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeIsNotNull() {
            addCriterion("CHARGE_IN_BANK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeEqualTo(String value) {
            addCriterion("CHARGE_IN_BANK_CODE =", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeNotEqualTo(String value) {
            addCriterion("CHARGE_IN_BANK_CODE <>", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeGreaterThan(String value) {
            addCriterion("CHARGE_IN_BANK_CODE >", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHARGE_IN_BANK_CODE >=", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeLessThan(String value) {
            addCriterion("CHARGE_IN_BANK_CODE <", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeLessThanOrEqualTo(String value) {
            addCriterion("CHARGE_IN_BANK_CODE <=", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeLike(String value) {
            addCriterion("CHARGE_IN_BANK_CODE like", value, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeNotLike(String value) {
            addCriterion("CHARGE_IN_BANK_CODE not like", value,
                    "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeIn(List<String> values) {
            addCriterion("CHARGE_IN_BANK_CODE in", values, "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeNotIn(List<String> values) {
            addCriterion("CHARGE_IN_BANK_CODE not in", values,
                    "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeBetween(String value1, String value2) {
            addCriterion("CHARGE_IN_BANK_CODE between", value1, value2,
                    "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andChargeInBankCodeNotBetween(String value1,
                String value2) {
            addCriterion("CHARGE_IN_BANK_CODE not between", value1, value2,
                    "chargeInBankCode");
            return (Criteria) this;
        }

        public Criteria andApproveLevelIsNull() {
            addCriterion("APPROVE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andApproveLevelIsNotNull() {
            addCriterion("APPROVE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andApproveLevelEqualTo(Integer value) {
            addCriterion("APPROVE_LEVEL =", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelNotEqualTo(Integer value) {
            addCriterion("APPROVE_LEVEL <>", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelGreaterThan(Integer value) {
            addCriterion("APPROVE_LEVEL >", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_LEVEL >=", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelLessThan(Integer value) {
            addCriterion("APPROVE_LEVEL <", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelLessThanOrEqualTo(Integer value) {
            addCriterion("APPROVE_LEVEL <=", value, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelIn(List<Integer> values) {
            addCriterion("APPROVE_LEVEL in", values, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelNotIn(List<Integer> values) {
            addCriterion("APPROVE_LEVEL not in", values, "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_LEVEL between", value1, value2,
                    "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("APPROVE_LEVEL not between", value1, value2,
                    "approveLevel");
            return (Criteria) this;
        }

        public Criteria andApproveNoIsNull() {
            addCriterion("APPROVE_NO is null");
            return (Criteria) this;
        }

        public Criteria andApproveNoIsNotNull() {
            addCriterion("APPROVE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andApproveNoEqualTo(String value) {
            addCriterion("APPROVE_NO =", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotEqualTo(String value) {
            addCriterion("APPROVE_NO <>", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoGreaterThan(String value) {
            addCriterion("APPROVE_NO >", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_NO >=", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLessThan(String value) {
            addCriterion("APPROVE_NO <", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_NO <=", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoLike(String value) {
            addCriterion("APPROVE_NO like", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotLike(String value) {
            addCriterion("APPROVE_NO not like", value, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoIn(List<String> values) {
            addCriterion("APPROVE_NO in", values, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotIn(List<String> values) {
            addCriterion("APPROVE_NO not in", values, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoBetween(String value1, String value2) {
            addCriterion("APPROVE_NO between", value1, value2, "approveNo");
            return (Criteria) this;
        }

        public Criteria andApproveNoNotBetween(String value1, String value2) {
            addCriterion("APPROVE_NO not between", value1, value2, "approveNo");
            return (Criteria) this;
        }

        public Criteria andIsFreeIsNull() {
            addCriterion("IS_FREE is null");
            return (Criteria) this;
        }

        public Criteria andIsFreeIsNotNull() {
            addCriterion("IS_FREE is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreeEqualTo(Integer value) {
            addCriterion("IS_FREE =", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeNotEqualTo(Integer value) {
            addCriterion("IS_FREE <>", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeGreaterThan(Integer value) {
            addCriterion("IS_FREE >", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_FREE >=", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeLessThan(Integer value) {
            addCriterion("IS_FREE <", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeLessThanOrEqualTo(Integer value) {
            addCriterion("IS_FREE <=", value, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeIn(List<Integer> values) {
            addCriterion("IS_FREE in", values, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeNotIn(List<Integer> values) {
            addCriterion("IS_FREE not in", values, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeBetween(Integer value1, Integer value2) {
            addCriterion("IS_FREE between", value1, value2, "isFree");
            return (Criteria) this;
        }

        public Criteria andIsFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_FREE not between", value1, value2, "isFree");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeIsNull() {
            addCriterion("BUDGET_SUBJECT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeIsNotNull() {
            addCriterion("BUDGET_SUBJECT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_CODE =", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeNotEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_CODE <>", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeGreaterThan(String value) {
            addCriterion("BUDGET_SUBJECT_CODE >", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_CODE >=", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeLessThan(String value) {
            addCriterion("BUDGET_SUBJECT_CODE <", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeLessThanOrEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_CODE <=", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeLike(String value) {
            addCriterion("BUDGET_SUBJECT_CODE like", value, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeNotLike(String value) {
            addCriterion("BUDGET_SUBJECT_CODE not like", value,
                    "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeIn(List<String> values) {
            addCriterion("BUDGET_SUBJECT_CODE in", values, "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeNotIn(List<String> values) {
            addCriterion("BUDGET_SUBJECT_CODE not in", values,
                    "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeBetween(String value1, String value2) {
            addCriterion("BUDGET_SUBJECT_CODE between", value1, value2,
                    "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectCodeNotBetween(String value1,
                String value2) {
            addCriterion("BUDGET_SUBJECT_CODE not between", value1, value2,
                    "budgetSubjectCode");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameIsNull() {
            addCriterion("BUDGET_SUBJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameIsNotNull() {
            addCriterion("BUDGET_SUBJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_NAME =", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameNotEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_NAME <>", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameGreaterThan(String value) {
            addCriterion("BUDGET_SUBJECT_NAME >", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_NAME >=", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameLessThan(String value) {
            addCriterion("BUDGET_SUBJECT_NAME <", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameLessThanOrEqualTo(String value) {
            addCriterion("BUDGET_SUBJECT_NAME <=", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameLike(String value) {
            addCriterion("BUDGET_SUBJECT_NAME like", value, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameNotLike(String value) {
            addCriterion("BUDGET_SUBJECT_NAME not like", value,
                    "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameIn(List<String> values) {
            addCriterion("BUDGET_SUBJECT_NAME in", values, "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameNotIn(List<String> values) {
            addCriterion("BUDGET_SUBJECT_NAME not in", values,
                    "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameBetween(String value1, String value2) {
            addCriterion("BUDGET_SUBJECT_NAME between", value1, value2,
                    "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andBudgetSubjectNameNotBetween(String value1,
                String value2) {
            addCriterion("BUDGET_SUBJECT_NAME not between", value1, value2,
                    "budgetSubjectName");
            return (Criteria) this;
        }

        public Criteria andChargeTargetIsNull() {
            addCriterion("CHARGE_TARGET is null");
            return (Criteria) this;
        }

        public Criteria andChargeTargetIsNotNull() {
            addCriterion("CHARGE_TARGET is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTargetEqualTo(Integer value) {
            addCriterion("CHARGE_TARGET =", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetNotEqualTo(Integer value) {
            addCriterion("CHARGE_TARGET <>", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetGreaterThan(Integer value) {
            addCriterion("CHARGE_TARGET >", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_TARGET >=", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetLessThan(Integer value) {
            addCriterion("CHARGE_TARGET <", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_TARGET <=", value, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetIn(List<Integer> values) {
            addCriterion("CHARGE_TARGET in", values, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetNotIn(List<Integer> values) {
            addCriterion("CHARGE_TARGET not in", values, "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetBetween(Integer value1, Integer value2) {
            addCriterion("CHARGE_TARGET between", value1, value2,
                    "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARGE_TARGET not between", value1, value2,
                    "chargeTarget");
            return (Criteria) this;
        }

        public Criteria andChargeTermIsNull() {
            addCriterion("CHARGE_TERM is null");
            return (Criteria) this;
        }

        public Criteria andChargeTermIsNotNull() {
            addCriterion("CHARGE_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTermEqualTo(Integer value) {
            addCriterion("CHARGE_TERM =", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermNotEqualTo(Integer value) {
            addCriterion("CHARGE_TERM <>", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermGreaterThan(Integer value) {
            addCriterion("CHARGE_TERM >", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_TERM >=", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermLessThan(Integer value) {
            addCriterion("CHARGE_TERM <", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_TERM <=", value, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermIn(List<Integer> values) {
            addCriterion("CHARGE_TERM in", values, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermNotIn(List<Integer> values) {
            addCriterion("CHARGE_TERM not in", values, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermBetween(Integer value1, Integer value2) {
            addCriterion("CHARGE_TERM between", value1, value2, "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andChargeTermNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARGE_TERM not between", value1, value2,
                    "chargeTerm");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateIsNull() {
            addCriterion("LATE_FEE_RATE is null");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateIsNotNull() {
            addCriterion("LATE_FEE_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateEqualTo(Long value) {
            addCriterion("LATE_FEE_RATE =", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateNotEqualTo(Long value) {
            addCriterion("LATE_FEE_RATE <>", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateGreaterThan(Long value) {
            addCriterion("LATE_FEE_RATE >", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateGreaterThanOrEqualTo(Long value) {
            addCriterion("LATE_FEE_RATE >=", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateLessThan(Long value) {
            addCriterion("LATE_FEE_RATE <", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateLessThanOrEqualTo(Long value) {
            addCriterion("LATE_FEE_RATE <=", value, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateIn(List<Long> values) {
            addCriterion("LATE_FEE_RATE in", values, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateNotIn(List<Long> values) {
            addCriterion("LATE_FEE_RATE not in", values, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateBetween(Long value1, Long value2) {
            addCriterion("LATE_FEE_RATE between", value1, value2, "lateFeeRate");
            return (Criteria) this;
        }

        public Criteria andLateFeeRateNotBetween(Long value1, Long value2) {
            addCriterion("LATE_FEE_RATE not between", value1, value2,
                    "lateFeeRate");
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

        public Criteria andUsagesIsNull() {
            addCriterion("USAGES is null");
            return (Criteria) this;
        }

        public Criteria andUsagesIsNotNull() {
            addCriterion("USAGES is not null");
            return (Criteria) this;
        }

        public Criteria andUsagesEqualTo(Integer value) {
            addCriterion("USAGES =", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesNotEqualTo(Integer value) {
            addCriterion("USAGES <>", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesGreaterThan(Integer value) {
            addCriterion("USAGES >", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesGreaterThanOrEqualTo(Integer value) {
            addCriterion("USAGES >=", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesLessThan(Integer value) {
            addCriterion("USAGES <", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesLessThanOrEqualTo(Integer value) {
            addCriterion("USAGES <=", value, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesIn(List<Integer> values) {
            addCriterion("USAGES in", values, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesNotIn(List<Integer> values) {
            addCriterion("USAGES not in", values, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesBetween(Integer value1, Integer value2) {
            addCriterion("USAGES between", value1, value2, "usages");
            return (Criteria) this;
        }

        public Criteria andUsagesNotBetween(Integer value1, Integer value2) {
            addCriterion("USAGES not between", value1, value2, "usages");
            return (Criteria) this;
        }
    }

    /**
     * For table pay_rl_items
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
     * pay_rl_items
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}