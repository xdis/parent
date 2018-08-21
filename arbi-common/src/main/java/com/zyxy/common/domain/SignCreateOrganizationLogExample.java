package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignCreateOrganizationLogExample {
    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public SignCreateOrganizationLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sign_create_organization_log
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
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sign_create_organization_log
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

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNull() {
            addCriterion("ORGANIZATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNotNull() {
            addCriterion("ORGANIZATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeEqualTo(Integer value) {
            addCriterion("ORGANIZATION_TYPE =", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotEqualTo(Integer value) {
            addCriterion("ORGANIZATION_TYPE <>", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThan(Integer value) {
            addCriterion("ORGANIZATION_TYPE >", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORGANIZATION_TYPE >=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThan(Integer value) {
            addCriterion("ORGANIZATION_TYPE <", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ORGANIZATION_TYPE <=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIn(List<Integer> values) {
            addCriterion("ORGANIZATION_TYPE in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotIn(List<Integer> values) {
            addCriterion("ORGANIZATION_TYPE not in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeBetween(Integer value1, Integer value2) {
            addCriterion("ORGANIZATION_TYPE between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ORGANIZATION_TYPE not between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIsNull() {
            addCriterion("IDENTIFICATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIsNotNull() {
            addCriterion("IDENTIFICATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeEqualTo(Integer value) {
            addCriterion("IDENTIFICATION_TYPE =", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotEqualTo(Integer value) {
            addCriterion("IDENTIFICATION_TYPE <>", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeGreaterThan(Integer value) {
            addCriterion("IDENTIFICATION_TYPE >", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IDENTIFICATION_TYPE >=", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeLessThan(Integer value) {
            addCriterion("IDENTIFICATION_TYPE <", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("IDENTIFICATION_TYPE <=", value, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeIn(List<Integer> values) {
            addCriterion("IDENTIFICATION_TYPE in", values, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotIn(List<Integer> values) {
            addCriterion("IDENTIFICATION_TYPE not in", values, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeBetween(Integer value1, Integer value2) {
            addCriterion("IDENTIFICATION_TYPE between", value1, value2, "identificationType");
            return (Criteria) this;
        }

        public Criteria andIdentificationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("IDENTIFICATION_TYPE not between", value1, value2, "identificationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoIsNull() {
            addCriterion("ORGANIZATION_REG_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoIsNotNull() {
            addCriterion("ORGANIZATION_REG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_NO =", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoNotEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_NO <>", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoGreaterThan(String value) {
            addCriterion("ORGANIZATION_REG_NO >", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_NO >=", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoLessThan(String value) {
            addCriterion("ORGANIZATION_REG_NO <", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_NO <=", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoLike(String value) {
            addCriterion("ORGANIZATION_REG_NO like", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoNotLike(String value) {
            addCriterion("ORGANIZATION_REG_NO not like", value, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoIn(List<String> values) {
            addCriterion("ORGANIZATION_REG_NO in", values, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoNotIn(List<String> values) {
            addCriterion("ORGANIZATION_REG_NO not in", values, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_REG_NO between", value1, value2, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegNoNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_REG_NO not between", value1, value2, "organizationRegNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgIsNull() {
            addCriterion("ORGANIZATION_REG_IMG is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgIsNotNull() {
            addCriterion("ORGANIZATION_REG_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_IMG =", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgNotEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_IMG <>", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgGreaterThan(String value) {
            addCriterion("ORGANIZATION_REG_IMG >", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_IMG >=", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgLessThan(String value) {
            addCriterion("ORGANIZATION_REG_IMG <", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_REG_IMG <=", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgLike(String value) {
            addCriterion("ORGANIZATION_REG_IMG like", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgNotLike(String value) {
            addCriterion("ORGANIZATION_REG_IMG not like", value, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgIn(List<String> values) {
            addCriterion("ORGANIZATION_REG_IMG in", values, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgNotIn(List<String> values) {
            addCriterion("ORGANIZATION_REG_IMG not in", values, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_REG_IMG between", value1, value2, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andOrganizationRegImgNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_REG_IMG not between", value1, value2, "organizationRegImg");
            return (Criteria) this;
        }

        public Criteria andSignApplicationIsNull() {
            addCriterion("SIGN_APPLICATION is null");
            return (Criteria) this;
        }

        public Criteria andSignApplicationIsNotNull() {
            addCriterion("SIGN_APPLICATION is not null");
            return (Criteria) this;
        }

        public Criteria andSignApplicationEqualTo(String value) {
            addCriterion("SIGN_APPLICATION =", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationNotEqualTo(String value) {
            addCriterion("SIGN_APPLICATION <>", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationGreaterThan(String value) {
            addCriterion("SIGN_APPLICATION >", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_APPLICATION >=", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationLessThan(String value) {
            addCriterion("SIGN_APPLICATION <", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationLessThanOrEqualTo(String value) {
            addCriterion("SIGN_APPLICATION <=", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationLike(String value) {
            addCriterion("SIGN_APPLICATION like", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationNotLike(String value) {
            addCriterion("SIGN_APPLICATION not like", value, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationIn(List<String> values) {
            addCriterion("SIGN_APPLICATION in", values, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationNotIn(List<String> values) {
            addCriterion("SIGN_APPLICATION not in", values, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationBetween(String value1, String value2) {
            addCriterion("SIGN_APPLICATION between", value1, value2, "signApplication");
            return (Criteria) this;
        }

        public Criteria andSignApplicationNotBetween(String value1, String value2) {
            addCriterion("SIGN_APPLICATION not between", value1, value2, "signApplication");
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
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * sign_create_organization_log
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * For table sign_create_organization_log
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