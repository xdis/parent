package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignSignatureLogExample {
    /**
     * sign_signature_log
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sign_signature_log
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sign_signature_log
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public SignSignatureLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sign_signature_log
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
     * sign_signature_log
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sign_signature_log
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sign_signature_log
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

        public Criteria andPreservationTitleIsNull() {
            addCriterion("PRESERVATION_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleIsNotNull() {
            addCriterion("PRESERVATION_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleEqualTo(String value) {
            addCriterion("PRESERVATION_TITLE =", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleNotEqualTo(String value) {
            addCriterion("PRESERVATION_TITLE <>", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleGreaterThan(String value) {
            addCriterion("PRESERVATION_TITLE >", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PRESERVATION_TITLE >=", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleLessThan(String value) {
            addCriterion("PRESERVATION_TITLE <", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleLessThanOrEqualTo(String value) {
            addCriterion("PRESERVATION_TITLE <=", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleLike(String value) {
            addCriterion("PRESERVATION_TITLE like", value, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleNotLike(String value) {
            addCriterion("PRESERVATION_TITLE not like", value,
                    "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleIn(List<String> values) {
            addCriterion("PRESERVATION_TITLE in", values, "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleNotIn(List<String> values) {
            addCriterion("PRESERVATION_TITLE not in", values,
                    "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleBetween(String value1, String value2) {
            addCriterion("PRESERVATION_TITLE between", value1, value2,
                    "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andPreservationTitleNotBetween(String value1,
                String value2) {
            addCriterion("PRESERVATION_TITLE not between", value1, value2,
                    "preservationTitle");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdIsNull() {
            addCriterion("SOURCE_REGISTRY_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdIsNotNull() {
            addCriterion("SOURCE_REGISTRY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdEqualTo(String value) {
            addCriterion("SOURCE_REGISTRY_ID =", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdNotEqualTo(String value) {
            addCriterion("SOURCE_REGISTRY_ID <>", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdGreaterThan(String value) {
            addCriterion("SOURCE_REGISTRY_ID >", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_REGISTRY_ID >=", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdLessThan(String value) {
            addCriterion("SOURCE_REGISTRY_ID <", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_REGISTRY_ID <=", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdLike(String value) {
            addCriterion("SOURCE_REGISTRY_ID like", value, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdNotLike(String value) {
            addCriterion("SOURCE_REGISTRY_ID not like", value,
                    "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdIn(List<String> values) {
            addCriterion("SOURCE_REGISTRY_ID in", values, "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdNotIn(List<String> values) {
            addCriterion("SOURCE_REGISTRY_ID not in", values,
                    "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdBetween(String value1, String value2) {
            addCriterion("SOURCE_REGISTRY_ID between", value1, value2,
                    "sourceRegistryId");
            return (Criteria) this;
        }

        public Criteria andSourceRegistryIdNotBetween(String value1,
                String value2) {
            addCriterion("SOURCE_REGISTRY_ID not between", value1, value2,
                    "sourceRegistryId");
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

        public Criteria andPreservationIdIsNull() {
            addCriterion("PRESERVATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreservationIdIsNotNull() {
            addCriterion("PRESERVATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreservationIdEqualTo(String value) {
            addCriterion("PRESERVATION_ID =", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdNotEqualTo(String value) {
            addCriterion("PRESERVATION_ID <>", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdGreaterThan(String value) {
            addCriterion("PRESERVATION_ID >", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRESERVATION_ID >=", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdLessThan(String value) {
            addCriterion("PRESERVATION_ID <", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdLessThanOrEqualTo(String value) {
            addCriterion("PRESERVATION_ID <=", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdLike(String value) {
            addCriterion("PRESERVATION_ID like", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdNotLike(String value) {
            addCriterion("PRESERVATION_ID not like", value, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdIn(List<String> values) {
            addCriterion("PRESERVATION_ID in", values, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdNotIn(List<String> values) {
            addCriterion("PRESERVATION_ID not in", values, "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdBetween(String value1, String value2) {
            addCriterion("PRESERVATION_ID between", value1, value2,
                    "preservationId");
            return (Criteria) this;
        }

        public Criteria andPreservationIdNotBetween(String value1, String value2) {
            addCriterion("PRESERVATION_ID not between", value1, value2,
                    "preservationId");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNull() {
            addCriterion("RECORD_NO is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("RECORD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(String value) {
            addCriterion("RECORD_NO =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(String value) {
            addCriterion("RECORD_NO <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(String value) {
            addCriterion("RECORD_NO >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_NO >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(String value) {
            addCriterion("RECORD_NO <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(String value) {
            addCriterion("RECORD_NO <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLike(String value) {
            addCriterion("RECORD_NO like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotLike(String value) {
            addCriterion("RECORD_NO not like", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<String> values) {
            addCriterion("RECORD_NO in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<String> values) {
            addCriterion("RECORD_NO not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(String value1, String value2) {
            addCriterion("RECORD_NO between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(String value1, String value2) {
            addCriterion("RECORD_NO not between", value1, value2, "recordNo");
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
     * For table sign_signature_log
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
     * sign_signature_log
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}