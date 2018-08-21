package com.zyxy.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public class PayOrderExample {
    /**
     * pay_order
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * pay_order
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * pay_order
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * pay_order
     * @mbggenerated
     */
    public PayOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * pay_order
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
     * pay_order
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * pay_order
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table pay_order
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

        protected void addCriterionForJDBCTime(String condition, Date value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()),
                    property);
        }

        protected void addCriterionForJDBCTime(String condition,
                List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property
                        + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1,
                Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()),
                    new java.sql.Time(value2.getTime()), property);
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

        public Criteria andReceivableAmtIsNull() {
            addCriterion("RECEIVABLE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtIsNotNull() {
            addCriterion("RECEIVABLE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT =", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT <>", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT >", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT >=", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT <", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE_AMT <=", value, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_AMT in", values, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE_AMT not in", values, "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("RECEIVABLE_AMT between", value1, value2,
                    "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andReceivableAmtNotBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("RECEIVABLE_AMT not between", value1, value2,
                    "receivableAmt");
            return (Criteria) this;
        }

        public Criteria andUnitNoIsNull() {
            addCriterion("UNIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andUnitNoIsNotNull() {
            addCriterion("UNIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNoEqualTo(String value) {
            addCriterion("UNIT_NO =", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotEqualTo(String value) {
            addCriterion("UNIT_NO <>", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoGreaterThan(String value) {
            addCriterion("UNIT_NO >", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_NO >=", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLessThan(String value) {
            addCriterion("UNIT_NO <", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLessThanOrEqualTo(String value) {
            addCriterion("UNIT_NO <=", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoLike(String value) {
            addCriterion("UNIT_NO like", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotLike(String value) {
            addCriterion("UNIT_NO not like", value, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoIn(List<String> values) {
            addCriterion("UNIT_NO in", values, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotIn(List<String> values) {
            addCriterion("UNIT_NO not in", values, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoBetween(String value1, String value2) {
            addCriterion("UNIT_NO between", value1, value2, "unitNo");
            return (Criteria) this;
        }

        public Criteria andUnitNoNotBetween(String value1, String value2) {
            addCriterion("UNIT_NO not between", value1, value2, "unitNo");
            return (Criteria) this;
        }

        public Criteria andPnNoIsNull() {
            addCriterion("PN_NO is null");
            return (Criteria) this;
        }

        public Criteria andPnNoIsNotNull() {
            addCriterion("PN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPnNoEqualTo(String value) {
            addCriterion("PN_NO =", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoNotEqualTo(String value) {
            addCriterion("PN_NO <>", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoGreaterThan(String value) {
            addCriterion("PN_NO >", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoGreaterThanOrEqualTo(String value) {
            addCriterion("PN_NO >=", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoLessThan(String value) {
            addCriterion("PN_NO <", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoLessThanOrEqualTo(String value) {
            addCriterion("PN_NO <=", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoLike(String value) {
            addCriterion("PN_NO like", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoNotLike(String value) {
            addCriterion("PN_NO not like", value, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoIn(List<String> values) {
            addCriterion("PN_NO in", values, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoNotIn(List<String> values) {
            addCriterion("PN_NO not in", values, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoBetween(String value1, String value2) {
            addCriterion("PN_NO between", value1, value2, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPnNoNotBetween(String value1, String value2) {
            addCriterion("PN_NO not between", value1, value2, "pnNo");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNull() {
            addCriterion("PAYER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNotNull() {
            addCriterion("PAYER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPayerNameEqualTo(String value) {
            addCriterion("PAYER_NAME =", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotEqualTo(String value) {
            addCriterion("PAYER_NAME <>", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThan(String value) {
            addCriterion("PAYER_NAME >", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("PAYER_NAME >=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThan(String value) {
            addCriterion("PAYER_NAME <", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThanOrEqualTo(String value) {
            addCriterion("PAYER_NAME <=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLike(String value) {
            addCriterion("PAYER_NAME like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotLike(String value) {
            addCriterion("PAYER_NAME not like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameIn(List<String> values) {
            addCriterion("PAYER_NAME in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotIn(List<String> values) {
            addCriterion("PAYER_NAME not in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameBetween(String value1, String value2) {
            addCriterion("PAYER_NAME between", value1, value2, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotBetween(String value1, String value2) {
            addCriterion("PAYER_NAME not between", value1, value2, "payerName");
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

        public Criteria andRegionZipCodeIsNull() {
            addCriterion("REGION_ZIP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeIsNotNull() {
            addCriterion("REGION_ZIP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeEqualTo(String value) {
            addCriterion("REGION_ZIP_CODE =", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeNotEqualTo(String value) {
            addCriterion("REGION_ZIP_CODE <>", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeGreaterThan(String value) {
            addCriterion("REGION_ZIP_CODE >", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_ZIP_CODE >=", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeLessThan(String value) {
            addCriterion("REGION_ZIP_CODE <", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeLessThanOrEqualTo(String value) {
            addCriterion("REGION_ZIP_CODE <=", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeLike(String value) {
            addCriterion("REGION_ZIP_CODE like", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeNotLike(String value) {
            addCriterion("REGION_ZIP_CODE not like", value, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeIn(List<String> values) {
            addCriterion("REGION_ZIP_CODE in", values, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeNotIn(List<String> values) {
            addCriterion("REGION_ZIP_CODE not in", values, "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeBetween(String value1, String value2) {
            addCriterion("REGION_ZIP_CODE between", value1, value2,
                    "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andRegionZipCodeNotBetween(String value1, String value2) {
            addCriterion("REGION_ZIP_CODE not between", value1, value2,
                    "regionZipCode");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoIsNull() {
            addCriterion("CHECK_DIGIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoIsNotNull() {
            addCriterion("CHECK_DIGIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoEqualTo(String value) {
            addCriterion("CHECK_DIGIT_NO =", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoNotEqualTo(String value) {
            addCriterion("CHECK_DIGIT_NO <>", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoGreaterThan(String value) {
            addCriterion("CHECK_DIGIT_NO >", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DIGIT_NO >=", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoLessThan(String value) {
            addCriterion("CHECK_DIGIT_NO <", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DIGIT_NO <=", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoLike(String value) {
            addCriterion("CHECK_DIGIT_NO like", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoNotLike(String value) {
            addCriterion("CHECK_DIGIT_NO not like", value, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoIn(List<String> values) {
            addCriterion("CHECK_DIGIT_NO in", values, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoNotIn(List<String> values) {
            addCriterion("CHECK_DIGIT_NO not in", values, "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoBetween(String value1, String value2) {
            addCriterion("CHECK_DIGIT_NO between", value1, value2,
                    "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitNoNotBetween(String value1, String value2) {
            addCriterion("CHECK_DIGIT_NO not between", value1, value2,
                    "checkDigitNo");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllIsNull() {
            addCriterion("CHECK_DIGIT_ALL is null");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllIsNotNull() {
            addCriterion("CHECK_DIGIT_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllEqualTo(String value) {
            addCriterion("CHECK_DIGIT_ALL =", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllNotEqualTo(String value) {
            addCriterion("CHECK_DIGIT_ALL <>", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllGreaterThan(String value) {
            addCriterion("CHECK_DIGIT_ALL >", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DIGIT_ALL >=", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllLessThan(String value) {
            addCriterion("CHECK_DIGIT_ALL <", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DIGIT_ALL <=", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllLike(String value) {
            addCriterion("CHECK_DIGIT_ALL like", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllNotLike(String value) {
            addCriterion("CHECK_DIGIT_ALL not like", value, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllIn(List<String> values) {
            addCriterion("CHECK_DIGIT_ALL in", values, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllNotIn(List<String> values) {
            addCriterion("CHECK_DIGIT_ALL not in", values, "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllBetween(String value1, String value2) {
            addCriterion("CHECK_DIGIT_ALL between", value1, value2,
                    "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andCheckDigitAllNotBetween(String value1, String value2) {
            addCriterion("CHECK_DIGIT_ALL not between", value1, value2,
                    "checkDigitAll");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountIsNull() {
            addCriterion("CHARGE_ITEM_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountIsNotNull() {
            addCriterion("CHARGE_ITEM_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountEqualTo(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT =", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountNotEqualTo(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT <>", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountGreaterThan(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT >", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT >=", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountLessThan(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT <", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGE_ITEM_COUNT <=", value, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountIn(List<Integer> values) {
            addCriterion("CHARGE_ITEM_COUNT in", values, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountNotIn(List<Integer> values) {
            addCriterion("CHARGE_ITEM_COUNT not in", values, "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountBetween(Integer value1, Integer value2) {
            addCriterion("CHARGE_ITEM_COUNT between", value1, value2,
                    "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChargeItemCountNotBetween(Integer value1,
                Integer value2) {
            addCriterion("CHARGE_ITEM_COUNT not between", value1, value2,
                    "chargeItemCount");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoIsNull() {
            addCriterion("CHANNEL_VOUCHER_NO is null");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoIsNotNull() {
            addCriterion("CHANNEL_VOUCHER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoEqualTo(String value) {
            addCriterion("CHANNEL_VOUCHER_NO =", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoNotEqualTo(String value) {
            addCriterion("CHANNEL_VOUCHER_NO <>", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoGreaterThan(String value) {
            addCriterion("CHANNEL_VOUCHER_NO >", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_VOUCHER_NO >=", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoLessThan(String value) {
            addCriterion("CHANNEL_VOUCHER_NO <", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_VOUCHER_NO <=", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoLike(String value) {
            addCriterion("CHANNEL_VOUCHER_NO like", value, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoNotLike(String value) {
            addCriterion("CHANNEL_VOUCHER_NO not like", value,
                    "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoIn(List<String> values) {
            addCriterion("CHANNEL_VOUCHER_NO in", values, "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoNotIn(List<String> values) {
            addCriterion("CHANNEL_VOUCHER_NO not in", values,
                    "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoBetween(String value1, String value2) {
            addCriterion("CHANNEL_VOUCHER_NO between", value1, value2,
                    "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelVoucherNoNotBetween(String value1,
                String value2) {
            addCriterion("CHANNEL_VOUCHER_NO not between", value1, value2,
                    "channelVoucherNo");
            return (Criteria) this;
        }

        public Criteria andChannelMsgIsNull() {
            addCriterion("CHANNEL_MSG is null");
            return (Criteria) this;
        }

        public Criteria andChannelMsgIsNotNull() {
            addCriterion("CHANNEL_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMsgEqualTo(String value) {
            addCriterion("CHANNEL_MSG =", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgNotEqualTo(String value) {
            addCriterion("CHANNEL_MSG <>", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgGreaterThan(String value) {
            addCriterion("CHANNEL_MSG >", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_MSG >=", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgLessThan(String value) {
            addCriterion("CHANNEL_MSG <", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_MSG <=", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgLike(String value) {
            addCriterion("CHANNEL_MSG like", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgNotLike(String value) {
            addCriterion("CHANNEL_MSG not like", value, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgIn(List<String> values) {
            addCriterion("CHANNEL_MSG in", values, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgNotIn(List<String> values) {
            addCriterion("CHANNEL_MSG not in", values, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgBetween(String value1, String value2) {
            addCriterion("CHANNEL_MSG between", value1, value2, "channelMsg");
            return (Criteria) this;
        }

        public Criteria andChannelMsgNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_MSG not between", value1, value2,
                    "channelMsg");
            return (Criteria) this;
        }

        public Criteria andPayedTimeIsNull() {
            addCriterion("PAYED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayedTimeIsNotNull() {
            addCriterion("PAYED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayedTimeEqualTo(Date value) {
            addCriterionForJDBCTime("PAYED_TIME =", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("PAYED_TIME <>", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("PAYED_TIME >", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PAYED_TIME >=", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeLessThan(Date value) {
            addCriterionForJDBCTime("PAYED_TIME <", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("PAYED_TIME <=", value, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeIn(List<Date> values) {
            addCriterionForJDBCTime("PAYED_TIME in", values, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("PAYED_TIME not in", values, "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PAYED_TIME between", value1, value2,
                    "payedTime");
            return (Criteria) this;
        }

        public Criteria andPayedTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("PAYED_TIME not between", value1, value2,
                    "payedTime");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtIsNull() {
            addCriterion("RECEIVED_AMT is null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtIsNotNull() {
            addCriterion("RECEIVED_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_AMT =", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_AMT <>", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtGreaterThan(BigDecimal value) {
            addCriterion("RECEIVED_AMT >", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_AMT >=", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtLessThan(BigDecimal value) {
            addCriterion("RECEIVED_AMT <", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVED_AMT <=", value, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtIn(List<BigDecimal> values) {
            addCriterion("RECEIVED_AMT in", values, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVED_AMT not in", values, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("RECEIVED_AMT between", value1, value2, "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andReceivedAmtNotBetween(BigDecimal value1,
                BigDecimal value2) {
            addCriterion("RECEIVED_AMT not between", value1, value2,
                    "receivedAmt");
            return (Criteria) this;
        }

        public Criteria andRtNoIsNull() {
            addCriterion("RT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRtNoIsNotNull() {
            addCriterion("RT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRtNoEqualTo(String value) {
            addCriterion("RT_NO =", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoNotEqualTo(String value) {
            addCriterion("RT_NO <>", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoGreaterThan(String value) {
            addCriterion("RT_NO >", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoGreaterThanOrEqualTo(String value) {
            addCriterion("RT_NO >=", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoLessThan(String value) {
            addCriterion("RT_NO <", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoLessThanOrEqualTo(String value) {
            addCriterion("RT_NO <=", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoLike(String value) {
            addCriterion("RT_NO like", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoNotLike(String value) {
            addCriterion("RT_NO not like", value, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoIn(List<String> values) {
            addCriterion("RT_NO in", values, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoNotIn(List<String> values) {
            addCriterion("RT_NO not in", values, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoBetween(String value1, String value2) {
            addCriterion("RT_NO between", value1, value2, "rtNo");
            return (Criteria) this;
        }

        public Criteria andRtNoNotBetween(String value1, String value2) {
            addCriterion("RT_NO not between", value1, value2, "rtNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoIsNull() {
            addCriterion("RECEIPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andReceiptNoIsNotNull() {
            addCriterion("RECEIPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptNoEqualTo(String value) {
            addCriterion("RECEIPT_NO =", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoNotEqualTo(String value) {
            addCriterion("RECEIPT_NO <>", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoGreaterThan(String value) {
            addCriterion("RECEIPT_NO >", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIPT_NO >=", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoLessThan(String value) {
            addCriterion("RECEIPT_NO <", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoLessThanOrEqualTo(String value) {
            addCriterion("RECEIPT_NO <=", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoLike(String value) {
            addCriterion("RECEIPT_NO like", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoNotLike(String value) {
            addCriterion("RECEIPT_NO not like", value, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoIn(List<String> values) {
            addCriterion("RECEIPT_NO in", values, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoNotIn(List<String> values) {
            addCriterion("RECEIPT_NO not in", values, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoBetween(String value1, String value2) {
            addCriterion("RECEIPT_NO between", value1, value2, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andReceiptNoNotBetween(String value1, String value2) {
            addCriterion("RECEIPT_NO not between", value1, value2, "receiptNo");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
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

        public Criteria andBuzzIdIsNull() {
            addCriterion("BUZZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuzzIdIsNotNull() {
            addCriterion("BUZZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuzzIdEqualTo(String value) {
            addCriterion("BUZZ_ID =", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdNotEqualTo(String value) {
            addCriterion("BUZZ_ID <>", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdGreaterThan(String value) {
            addCriterion("BUZZ_ID >", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUZZ_ID >=", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdLessThan(String value) {
            addCriterion("BUZZ_ID <", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdLessThanOrEqualTo(String value) {
            addCriterion("BUZZ_ID <=", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdLike(String value) {
            addCriterion("BUZZ_ID like", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdNotLike(String value) {
            addCriterion("BUZZ_ID not like", value, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdIn(List<String> values) {
            addCriterion("BUZZ_ID in", values, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdNotIn(List<String> values) {
            addCriterion("BUZZ_ID not in", values, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdBetween(String value1, String value2) {
            addCriterion("BUZZ_ID between", value1, value2, "buzzId");
            return (Criteria) this;
        }

        public Criteria andBuzzIdNotBetween(String value1, String value2) {
            addCriterion("BUZZ_ID not between", value1, value2, "buzzId");
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

        public Criteria andCancelTimeIsNull() {
            addCriterion("CANCEL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("CANCEL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("CANCEL_TIME =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("CANCEL_TIME <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("CANCEL_TIME >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CANCEL_TIME >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("CANCEL_TIME <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("CANCEL_TIME <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("CANCEL_TIME in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("CANCEL_TIME not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("CANCEL_TIME between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("CANCEL_TIME not between", value1, value2,
                    "cancelTime");
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
     * For table pay_order
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
     * pay_order
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}