package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsRecordExample {
    /**
     * sms_record
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sms_record
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sms_record
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sms_record
     * @mbggenerated
     */
    public SmsRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sms_record
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
     * sms_record
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sms_record
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sms_record
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

        public Criteria andPhoneNoIsNull() {
            addCriterion("PHONE_NO is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("PHONE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("PHONE_NO =", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("PHONE_NO <>", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("PHONE_NO >", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NO >=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("PHONE_NO <", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NO <=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("PHONE_NO like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("PHONE_NO not like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIn(List<String> values) {
            addCriterion("PHONE_NO in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotIn(List<String> values) {
            addCriterion("PHONE_NO not in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("PHONE_NO between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("PHONE_NO not between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andTplIdIsNull() {
            addCriterion("TPL_ID is null");
            return (Criteria) this;
        }

        public Criteria andTplIdIsNotNull() {
            addCriterion("TPL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTplIdEqualTo(String value) {
            addCriterion("TPL_ID =", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdNotEqualTo(String value) {
            addCriterion("TPL_ID <>", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdGreaterThan(String value) {
            addCriterion("TPL_ID >", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdGreaterThanOrEqualTo(String value) {
            addCriterion("TPL_ID >=", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdLessThan(String value) {
            addCriterion("TPL_ID <", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdLessThanOrEqualTo(String value) {
            addCriterion("TPL_ID <=", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdLike(String value) {
            addCriterion("TPL_ID like", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdNotLike(String value) {
            addCriterion("TPL_ID not like", value, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdIn(List<String> values) {
            addCriterion("TPL_ID in", values, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdNotIn(List<String> values) {
            addCriterion("TPL_ID not in", values, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdBetween(String value1, String value2) {
            addCriterion("TPL_ID between", value1, value2, "tplId");
            return (Criteria) this;
        }

        public Criteria andTplIdNotBetween(String value1, String value2) {
            addCriterion("TPL_ID not between", value1, value2, "tplId");
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

        public Criteria andChannelCodeIsNull() {
            addCriterion("CHANNEL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("CHANNEL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("CHANNEL_CODE =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("CHANNEL_CODE <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("CHANNEL_CODE >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_CODE >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("CHANNEL_CODE <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_CODE <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("CHANNEL_CODE like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("CHANNEL_CODE not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("CHANNEL_CODE in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("CHANNEL_CODE not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("CHANNEL_CODE between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_CODE not between", value1, value2,
                    "channelCode");
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
     * For table sms_record
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
     * sms_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}