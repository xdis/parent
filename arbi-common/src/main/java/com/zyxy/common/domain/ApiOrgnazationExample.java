package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiOrgnazationExample {
    /**
     * api_orgnazation
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * api_orgnazation
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * api_orgnazation
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public ApiOrgnazationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * api_orgnazation
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
     * api_orgnazation
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * api_orgnazation
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table api_orgnazation
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNull() {
            addCriterion("REG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNotNull() {
            addCriterion("REG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegNameEqualTo(String value) {
            addCriterion("REG_NAME =", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotEqualTo(String value) {
            addCriterion("REG_NAME <>", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThan(String value) {
            addCriterion("REG_NAME >", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThanOrEqualTo(String value) {
            addCriterion("REG_NAME >=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThan(String value) {
            addCriterion("REG_NAME <", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThanOrEqualTo(String value) {
            addCriterion("REG_NAME <=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLike(String value) {
            addCriterion("REG_NAME like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotLike(String value) {
            addCriterion("REG_NAME not like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameIn(List<String> values) {
            addCriterion("REG_NAME in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotIn(List<String> values) {
            addCriterion("REG_NAME not in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameBetween(String value1, String value2) {
            addCriterion("REG_NAME between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotBetween(String value1, String value2) {
            addCriterion("REG_NAME not between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andOrgSiteIsNull() {
            addCriterion("ORG_SITE is null");
            return (Criteria) this;
        }

        public Criteria andOrgSiteIsNotNull() {
            addCriterion("ORG_SITE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSiteEqualTo(String value) {
            addCriterion("ORG_SITE =", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteNotEqualTo(String value) {
            addCriterion("ORG_SITE <>", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteGreaterThan(String value) {
            addCriterion("ORG_SITE >", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_SITE >=", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteLessThan(String value) {
            addCriterion("ORG_SITE <", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteLessThanOrEqualTo(String value) {
            addCriterion("ORG_SITE <=", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteLike(String value) {
            addCriterion("ORG_SITE like", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteNotLike(String value) {
            addCriterion("ORG_SITE not like", value, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteIn(List<String> values) {
            addCriterion("ORG_SITE in", values, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteNotIn(List<String> values) {
            addCriterion("ORG_SITE not in", values, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteBetween(String value1, String value2) {
            addCriterion("ORG_SITE between", value1, value2, "orgSite");
            return (Criteria) this;
        }

        public Criteria andOrgSiteNotBetween(String value1, String value2) {
            addCriterion("ORG_SITE not between", value1, value2, "orgSite");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("COUNTRY <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("COUNTRY >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("COUNTRY <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("COUNTRY like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("COUNTRY not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("COUNTRY in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("COUNTRY not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("COUNTRY between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("COUNTRY not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
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

        public Criteria andIpWhiteListIsNull() {
            addCriterion("IP_WHITE_LIST is null");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListIsNotNull() {
            addCriterion("IP_WHITE_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListEqualTo(String value) {
            addCriterion("IP_WHITE_LIST =", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListNotEqualTo(String value) {
            addCriterion("IP_WHITE_LIST <>", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListGreaterThan(String value) {
            addCriterion("IP_WHITE_LIST >", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListGreaterThanOrEqualTo(String value) {
            addCriterion("IP_WHITE_LIST >=", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListLessThan(String value) {
            addCriterion("IP_WHITE_LIST <", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListLessThanOrEqualTo(String value) {
            addCriterion("IP_WHITE_LIST <=", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListLike(String value) {
            addCriterion("IP_WHITE_LIST like", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListNotLike(String value) {
            addCriterion("IP_WHITE_LIST not like", value, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListIn(List<String> values) {
            addCriterion("IP_WHITE_LIST in", values, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListNotIn(List<String> values) {
            addCriterion("IP_WHITE_LIST not in", values, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListBetween(String value1, String value2) {
            addCriterion("IP_WHITE_LIST between", value1, value2, "ipWhiteList");
            return (Criteria) this;
        }

        public Criteria andIpWhiteListNotBetween(String value1, String value2) {
            addCriterion("IP_WHITE_LIST not between", value1, value2,
                    "ipWhiteList");
            return (Criteria) this;
        }
    }

    /**
     * For table api_orgnazation
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
     * api_orgnazation
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}