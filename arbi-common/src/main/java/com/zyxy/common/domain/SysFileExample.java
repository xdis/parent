package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysFileExample {
    /**
     * sys_file
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sys_file
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sys_file
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sys_file
     * @mbggenerated
     */
    public SysFileExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sys_file
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
     * sys_file
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sys_file
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sys_file
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

        public Criteria andFileOrignNameIsNull() {
            addCriterion("FILE_ORIGN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameIsNotNull() {
            addCriterion("FILE_ORIGN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameEqualTo(String value) {
            addCriterion("FILE_ORIGN_NAME =", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameNotEqualTo(String value) {
            addCriterion("FILE_ORIGN_NAME <>", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameGreaterThan(String value) {
            addCriterion("FILE_ORIGN_NAME >", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ORIGN_NAME >=", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameLessThan(String value) {
            addCriterion("FILE_ORIGN_NAME <", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_ORIGN_NAME <=", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameLike(String value) {
            addCriterion("FILE_ORIGN_NAME like", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameNotLike(String value) {
            addCriterion("FILE_ORIGN_NAME not like", value, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameIn(List<String> values) {
            addCriterion("FILE_ORIGN_NAME in", values, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameNotIn(List<String> values) {
            addCriterion("FILE_ORIGN_NAME not in", values, "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameBetween(String value1, String value2) {
            addCriterion("FILE_ORIGN_NAME between", value1, value2,
                    "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileOrignNameNotBetween(String value1, String value2) {
            addCriterion("FILE_ORIGN_NAME not between", value1, value2,
                    "fileOrignName");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("FILE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("FILE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("FILE_SIZE =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("FILE_SIZE <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("FILE_SIZE >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("FILE_SIZE >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("FILE_SIZE <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("FILE_SIZE <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("FILE_SIZE in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("FILE_SIZE not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("FILE_SIZE between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("FILE_SIZE not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNull() {
            addCriterion("FILE_EXT is null");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNotNull() {
            addCriterion("FILE_EXT is not null");
            return (Criteria) this;
        }

        public Criteria andFileExtEqualTo(String value) {
            addCriterion("FILE_EXT =", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotEqualTo(String value) {
            addCriterion("FILE_EXT <>", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThan(String value) {
            addCriterion("FILE_EXT >", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_EXT >=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThan(String value) {
            addCriterion("FILE_EXT <", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThanOrEqualTo(String value) {
            addCriterion("FILE_EXT <=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLike(String value) {
            addCriterion("FILE_EXT like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotLike(String value) {
            addCriterion("FILE_EXT not like", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtIn(List<String> values) {
            addCriterion("FILE_EXT in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotIn(List<String> values) {
            addCriterion("FILE_EXT not in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtBetween(String value1, String value2) {
            addCriterion("FILE_EXT between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotBetween(String value1, String value2) {
            addCriterion("FILE_EXT not between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andSysPathIsNull() {
            addCriterion("SYS_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSysPathIsNotNull() {
            addCriterion("SYS_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSysPathEqualTo(String value) {
            addCriterion("SYS_PATH =", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathNotEqualTo(String value) {
            addCriterion("SYS_PATH <>", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathGreaterThan(String value) {
            addCriterion("SYS_PATH >", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_PATH >=", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathLessThan(String value) {
            addCriterion("SYS_PATH <", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathLessThanOrEqualTo(String value) {
            addCriterion("SYS_PATH <=", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathLike(String value) {
            addCriterion("SYS_PATH like", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathNotLike(String value) {
            addCriterion("SYS_PATH not like", value, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathIn(List<String> values) {
            addCriterion("SYS_PATH in", values, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathNotIn(List<String> values) {
            addCriterion("SYS_PATH not in", values, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathBetween(String value1, String value2) {
            addCriterion("SYS_PATH between", value1, value2, "sysPath");
            return (Criteria) this;
        }

        public Criteria andSysPathNotBetween(String value1, String value2) {
            addCriterion("SYS_PATH not between", value1, value2, "sysPath");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeIsNull() {
            addCriterion("BUZZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeIsNotNull() {
            addCriterion("BUZZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeEqualTo(String value) {
            addCriterion("BUZZ_TYPE =", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeNotEqualTo(String value) {
            addCriterion("BUZZ_TYPE <>", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeGreaterThan(String value) {
            addCriterion("BUZZ_TYPE >", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUZZ_TYPE >=", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeLessThan(String value) {
            addCriterion("BUZZ_TYPE <", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeLessThanOrEqualTo(String value) {
            addCriterion("BUZZ_TYPE <=", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeLike(String value) {
            addCriterion("BUZZ_TYPE like", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeNotLike(String value) {
            addCriterion("BUZZ_TYPE not like", value, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeIn(List<String> values) {
            addCriterion("BUZZ_TYPE in", values, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeNotIn(List<String> values) {
            addCriterion("BUZZ_TYPE not in", values, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeBetween(String value1, String value2) {
            addCriterion("BUZZ_TYPE between", value1, value2, "buzzType");
            return (Criteria) this;
        }

        public Criteria andBuzzTypeNotBetween(String value1, String value2) {
            addCriterion("BUZZ_TYPE not between", value1, value2, "buzzType");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("CREATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("CREATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(String value) {
            addCriterion("CREATE_ID =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(String value) {
            addCriterion("CREATE_ID <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(String value) {
            addCriterion("CREATE_ID >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_ID >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(String value) {
            addCriterion("CREATE_ID <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_ID <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLike(String value) {
            addCriterion("CREATE_ID like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotLike(String value) {
            addCriterion("CREATE_ID not like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<String> values) {
            addCriterion("CREATE_ID in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<String> values) {
            addCriterion("CREATE_ID not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(String value1, String value2) {
            addCriterion("CREATE_ID between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_ID not between", value1, value2, "createId");
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

        public Criteria andDeletedFlagIsNull() {
            addCriterion("DELETED_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNotNull() {
            addCriterion("DELETED_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagEqualTo(Integer value) {
            addCriterion("DELETED_FLAG =", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotEqualTo(Integer value) {
            addCriterion("DELETED_FLAG <>", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThan(Integer value) {
            addCriterion("DELETED_FLAG >", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELETED_FLAG >=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThan(Integer value) {
            addCriterion("DELETED_FLAG <", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThanOrEqualTo(Integer value) {
            addCriterion("DELETED_FLAG <=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIn(List<Integer> values) {
            addCriterion("DELETED_FLAG in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotIn(List<Integer> values) {
            addCriterion("DELETED_FLAG not in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagBetween(Integer value1, Integer value2) {
            addCriterion("DELETED_FLAG between", value1, value2, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("DELETED_FLAG not between", value1, value2,
                    "deletedFlag");
            return (Criteria) this;
        }
    }

    /**
     * For table sys_file
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
     * sys_file
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}