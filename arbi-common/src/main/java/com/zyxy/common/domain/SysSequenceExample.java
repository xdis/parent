package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSequenceExample {
    /**
     * sys_sequence
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sys_sequence
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sys_sequence
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sys_sequence
     * @mbggenerated
     */
    public SysSequenceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sys_sequence
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
     * sys_sequence
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sys_sequence
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sys_sequence
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

        public Criteria andSnameIsNull() {
            addCriterion("SNAME is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("SNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("SNAME =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("SNAME <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("SNAME >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("SNAME >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("SNAME <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("SNAME <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("SNAME like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("SNAME not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("SNAME in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("SNAME not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("SNAME between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("SNAME not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSminIsNull() {
            addCriterion("SMIN is null");
            return (Criteria) this;
        }

        public Criteria andSminIsNotNull() {
            addCriterion("SMIN is not null");
            return (Criteria) this;
        }

        public Criteria andSminEqualTo(Integer value) {
            addCriterion("SMIN =", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminNotEqualTo(Integer value) {
            addCriterion("SMIN <>", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminGreaterThan(Integer value) {
            addCriterion("SMIN >", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminGreaterThanOrEqualTo(Integer value) {
            addCriterion("SMIN >=", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminLessThan(Integer value) {
            addCriterion("SMIN <", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminLessThanOrEqualTo(Integer value) {
            addCriterion("SMIN <=", value, "smin");
            return (Criteria) this;
        }

        public Criteria andSminIn(List<Integer> values) {
            addCriterion("SMIN in", values, "smin");
            return (Criteria) this;
        }

        public Criteria andSminNotIn(List<Integer> values) {
            addCriterion("SMIN not in", values, "smin");
            return (Criteria) this;
        }

        public Criteria andSminBetween(Integer value1, Integer value2) {
            addCriterion("SMIN between", value1, value2, "smin");
            return (Criteria) this;
        }

        public Criteria andSminNotBetween(Integer value1, Integer value2) {
            addCriterion("SMIN not between", value1, value2, "smin");
            return (Criteria) this;
        }

        public Criteria andSmaxIsNull() {
            addCriterion("SMAX is null");
            return (Criteria) this;
        }

        public Criteria andSmaxIsNotNull() {
            addCriterion("SMAX is not null");
            return (Criteria) this;
        }

        public Criteria andSmaxEqualTo(Integer value) {
            addCriterion("SMAX =", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxNotEqualTo(Integer value) {
            addCriterion("SMAX <>", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxGreaterThan(Integer value) {
            addCriterion("SMAX >", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("SMAX >=", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxLessThan(Integer value) {
            addCriterion("SMAX <", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxLessThanOrEqualTo(Integer value) {
            addCriterion("SMAX <=", value, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxIn(List<Integer> values) {
            addCriterion("SMAX in", values, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxNotIn(List<Integer> values) {
            addCriterion("SMAX not in", values, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxBetween(Integer value1, Integer value2) {
            addCriterion("SMAX between", value1, value2, "smax");
            return (Criteria) this;
        }

        public Criteria andSmaxNotBetween(Integer value1, Integer value2) {
            addCriterion("SMAX not between", value1, value2, "smax");
            return (Criteria) this;
        }

        public Criteria andScurrentIsNull() {
            addCriterion("SCURRENT is null");
            return (Criteria) this;
        }

        public Criteria andScurrentIsNotNull() {
            addCriterion("SCURRENT is not null");
            return (Criteria) this;
        }

        public Criteria andScurrentEqualTo(Integer value) {
            addCriterion("SCURRENT =", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentNotEqualTo(Integer value) {
            addCriterion("SCURRENT <>", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentGreaterThan(Integer value) {
            addCriterion("SCURRENT >", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCURRENT >=", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentLessThan(Integer value) {
            addCriterion("SCURRENT <", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentLessThanOrEqualTo(Integer value) {
            addCriterion("SCURRENT <=", value, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentIn(List<Integer> values) {
            addCriterion("SCURRENT in", values, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentNotIn(List<Integer> values) {
            addCriterion("SCURRENT not in", values, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentBetween(Integer value1, Integer value2) {
            addCriterion("SCURRENT between", value1, value2, "scurrent");
            return (Criteria) this;
        }

        public Criteria andScurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("SCURRENT not between", value1, value2, "scurrent");
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
     * For table sys_sequence
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
     * sys_sequence
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}