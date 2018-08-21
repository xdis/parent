package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailRecordExample {
    /**
     * mail_record
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * mail_record
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * mail_record
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * mail_record
     * @mbggenerated
     */
    public MailRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * mail_record
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
     * mail_record
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * mail_record
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table mail_record
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

        public Criteria andSubjuctIsNull() {
            addCriterion("SUBJUCT is null");
            return (Criteria) this;
        }

        public Criteria andSubjuctIsNotNull() {
            addCriterion("SUBJUCT is not null");
            return (Criteria) this;
        }

        public Criteria andSubjuctEqualTo(String value) {
            addCriterion("SUBJUCT =", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctNotEqualTo(String value) {
            addCriterion("SUBJUCT <>", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctGreaterThan(String value) {
            addCriterion("SUBJUCT >", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJUCT >=", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctLessThan(String value) {
            addCriterion("SUBJUCT <", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctLessThanOrEqualTo(String value) {
            addCriterion("SUBJUCT <=", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctLike(String value) {
            addCriterion("SUBJUCT like", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctNotLike(String value) {
            addCriterion("SUBJUCT not like", value, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctIn(List<String> values) {
            addCriterion("SUBJUCT in", values, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctNotIn(List<String> values) {
            addCriterion("SUBJUCT not in", values, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctBetween(String value1, String value2) {
            addCriterion("SUBJUCT between", value1, value2, "subjuct");
            return (Criteria) this;
        }

        public Criteria andSubjuctNotBetween(String value1, String value2) {
            addCriterion("SUBJUCT not between", value1, value2, "subjuct");
            return (Criteria) this;
        }

        public Criteria andMailToIsNull() {
            addCriterion("MAIL_TO is null");
            return (Criteria) this;
        }

        public Criteria andMailToIsNotNull() {
            addCriterion("MAIL_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMailToEqualTo(String value) {
            addCriterion("MAIL_TO =", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotEqualTo(String value) {
            addCriterion("MAIL_TO <>", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToGreaterThan(String value) {
            addCriterion("MAIL_TO >", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_TO >=", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLessThan(String value) {
            addCriterion("MAIL_TO <", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLessThanOrEqualTo(String value) {
            addCriterion("MAIL_TO <=", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToLike(String value) {
            addCriterion("MAIL_TO like", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotLike(String value) {
            addCriterion("MAIL_TO not like", value, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToIn(List<String> values) {
            addCriterion("MAIL_TO in", values, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotIn(List<String> values) {
            addCriterion("MAIL_TO not in", values, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToBetween(String value1, String value2) {
            addCriterion("MAIL_TO between", value1, value2, "mailTo");
            return (Criteria) this;
        }

        public Criteria andMailToNotBetween(String value1, String value2) {
            addCriterion("MAIL_TO not between", value1, value2, "mailTo");
            return (Criteria) this;
        }

        public Criteria andCcIsNull() {
            addCriterion("CC is null");
            return (Criteria) this;
        }

        public Criteria andCcIsNotNull() {
            addCriterion("CC is not null");
            return (Criteria) this;
        }

        public Criteria andCcEqualTo(String value) {
            addCriterion("CC =", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotEqualTo(String value) {
            addCriterion("CC <>", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThan(String value) {
            addCriterion("CC >", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcGreaterThanOrEqualTo(String value) {
            addCriterion("CC >=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThan(String value) {
            addCriterion("CC <", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLessThanOrEqualTo(String value) {
            addCriterion("CC <=", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcLike(String value) {
            addCriterion("CC like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotLike(String value) {
            addCriterion("CC not like", value, "cc");
            return (Criteria) this;
        }

        public Criteria andCcIn(List<String> values) {
            addCriterion("CC in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotIn(List<String> values) {
            addCriterion("CC not in", values, "cc");
            return (Criteria) this;
        }

        public Criteria andCcBetween(String value1, String value2) {
            addCriterion("CC between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andCcNotBetween(String value1, String value2) {
            addCriterion("CC not between", value1, value2, "cc");
            return (Criteria) this;
        }

        public Criteria andStautsIsNull() {
            addCriterion("STAUTS is null");
            return (Criteria) this;
        }

        public Criteria andStautsIsNotNull() {
            addCriterion("STAUTS is not null");
            return (Criteria) this;
        }

        public Criteria andStautsEqualTo(Integer value) {
            addCriterion("STAUTS =", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotEqualTo(Integer value) {
            addCriterion("STAUTS <>", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThan(Integer value) {
            addCriterion("STAUTS >", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAUTS >=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThan(Integer value) {
            addCriterion("STAUTS <", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThanOrEqualTo(Integer value) {
            addCriterion("STAUTS <=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsIn(List<Integer> values) {
            addCriterion("STAUTS in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotIn(List<Integer> values) {
            addCriterion("STAUTS not in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsBetween(Integer value1, Integer value2) {
            addCriterion("STAUTS between", value1, value2, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotBetween(Integer value1, Integer value2) {
            addCriterion("STAUTS not between", value1, value2, "stauts");
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
    }

    /**
     * For table mail_record
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
     * mail_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}