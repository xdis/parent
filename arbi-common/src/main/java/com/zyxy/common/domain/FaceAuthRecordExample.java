package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaceAuthRecordExample {
    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public FaceAuthRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * face_auth_record
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
     * face_auth_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table face_auth_record
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNull() {
            addCriterion("id_card_name is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNotNull() {
            addCriterion("id_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameEqualTo(String value) {
            addCriterion("id_card_name =", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotEqualTo(String value) {
            addCriterion("id_card_name <>", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThan(String value) {
            addCriterion("id_card_name >", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_name >=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThan(String value) {
            addCriterion("id_card_name <", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThanOrEqualTo(String value) {
            addCriterion("id_card_name <=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLike(String value) {
            addCriterion("id_card_name like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotLike(String value) {
            addCriterion("id_card_name not like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIn(List<String> values) {
            addCriterion("id_card_name in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotIn(List<String> values) {
            addCriterion("id_card_name not in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameBetween(String value1, String value2) {
            addCriterion("id_card_name between", value1, value2, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotBetween(String value1, String value2) {
            addCriterion("id_card_name not between", value1, value2, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNull() {
            addCriterion("id_card_num is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNotNull() {
            addCriterion("id_card_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumEqualTo(String value) {
            addCriterion("id_card_num =", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotEqualTo(String value) {
            addCriterion("id_card_num <>", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThan(String value) {
            addCriterion("id_card_num >", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_num >=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThan(String value) {
            addCriterion("id_card_num <", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThanOrEqualTo(String value) {
            addCriterion("id_card_num <=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLike(String value) {
            addCriterion("id_card_num like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotLike(String value) {
            addCriterion("id_card_num not like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIn(List<String> values) {
            addCriterion("id_card_num in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotIn(List<String> values) {
            addCriterion("id_card_num not in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumBetween(String value1, String value2) {
            addCriterion("id_card_num between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotBetween(String value1, String value2) {
            addCriterion("id_card_num not between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andSimilarityIsNull() {
            addCriterion("similarity is null");
            return (Criteria) this;
        }

        public Criteria andSimilarityIsNotNull() {
            addCriterion("similarity is not null");
            return (Criteria) this;
        }

        public Criteria andSimilarityEqualTo(Float value) {
            addCriterion("similarity =", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityNotEqualTo(Float value) {
            addCriterion("similarity <>", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityGreaterThan(Float value) {
            addCriterion("similarity >", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityGreaterThanOrEqualTo(Float value) {
            addCriterion("similarity >=", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityLessThan(Float value) {
            addCriterion("similarity <", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityLessThanOrEqualTo(Float value) {
            addCriterion("similarity <=", value, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityIn(List<Float> values) {
            addCriterion("similarity in", values, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityNotIn(List<Float> values) {
            addCriterion("similarity not in", values, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityBetween(Float value1, Float value2) {
            addCriterion("similarity between", value1, value2, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityNotBetween(Float value1, Float value2) {
            addCriterion("similarity not between", value1, value2, "similarity");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultIsNull() {
            addCriterion("similarity_result is null");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultIsNotNull() {
            addCriterion("similarity_result is not null");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultEqualTo(Float value) {
            addCriterion("similarity_result =", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultNotEqualTo(Float value) {
            addCriterion("similarity_result <>", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultGreaterThan(Float value) {
            addCriterion("similarity_result >", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultGreaterThanOrEqualTo(Float value) {
            addCriterion("similarity_result >=", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultLessThan(Float value) {
            addCriterion("similarity_result <", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultLessThanOrEqualTo(Float value) {
            addCriterion("similarity_result <=", value, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultIn(List<Float> values) {
            addCriterion("similarity_result in", values, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultNotIn(List<Float> values) {
            addCriterion("similarity_result not in", values, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultBetween(Float value1, Float value2) {
            addCriterion("similarity_result between", value1, value2, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andSimilarityResultNotBetween(Float value1, Float value2) {
            addCriterion("similarity_result not between", value1, value2, "similarityResult");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLike(String value) {
            addCriterion("request_id like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotLike(String value) {
            addCriterion("request_id not like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeIsNull() {
            addCriterion("token_expired_time is null");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeIsNotNull() {
            addCriterion("token_expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeEqualTo(Date value) {
            addCriterion("token_expired_time =", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeNotEqualTo(Date value) {
            addCriterion("token_expired_time <>", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeGreaterThan(Date value) {
            addCriterion("token_expired_time >", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("token_expired_time >=", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeLessThan(Date value) {
            addCriterion("token_expired_time <", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("token_expired_time <=", value, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeIn(List<Date> values) {
            addCriterion("token_expired_time in", values, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeNotIn(List<Date> values) {
            addCriterion("token_expired_time not in", values, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("token_expired_time between", value1, value2, "tokenExpiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("token_expired_time not between", value1, value2, "tokenExpiredTime");
            return (Criteria) this;
        }
    }

    /**
     * face_auth_record
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table face_auth_record
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