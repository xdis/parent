package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiOrgCertExample {
    /**
     * api_org_cert
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * api_org_cert
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * api_org_cert
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * api_org_cert
     * @mbggenerated
     */
    public ApiOrgCertExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * api_org_cert
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
     * api_org_cert
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * api_org_cert
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table api_org_cert
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

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassIsNull() {
            addCriterion("CLT_PRIVATE_KEY_PASS is null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassIsNotNull() {
            addCriterion("CLT_PRIVATE_KEY_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS =", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassNotEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS <>", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassGreaterThan(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS >", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassGreaterThanOrEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS >=", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassLessThan(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS <", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassLessThanOrEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS <=", value, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassLike(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS like", value,
                    "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassNotLike(String value) {
            addCriterion("CLT_PRIVATE_KEY_PASS not like", value,
                    "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassIn(List<String> values) {
            addCriterion("CLT_PRIVATE_KEY_PASS in", values, "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassNotIn(List<String> values) {
            addCriterion("CLT_PRIVATE_KEY_PASS not in", values,
                    "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassBetween(String value1, String value2) {
            addCriterion("CLT_PRIVATE_KEY_PASS between", value1, value2,
                    "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyPassNotBetween(String value1,
                String value2) {
            addCriterion("CLT_PRIVATE_KEY_PASS not between", value1, value2,
                    "cltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassIsNull() {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS is null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassIsNotNull() {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS =", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassNotEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS <>", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassGreaterThan(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS >", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassGreaterThanOrEqualTo(
                String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS >=", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassLessThan(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS <", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassLessThanOrEqualTo(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS <=", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassLike(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS like", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassNotLike(String value) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS not like", value,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassIn(List<String> values) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS in", values,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassNotIn(List<String> values) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS not in", values,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassBetween(String value1,
                String value2) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS between", value1, value2,
                    "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPrivateKeyStorePassNotBetween(String value1,
                String value2) {
            addCriterion("CLT_PRIVATE_KEY_STORE_PASS not between", value1,
                    value2, "cltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameIsNull() {
            addCriterion("CLT_PUBLIC_KEY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameIsNotNull() {
            addCriterion("CLT_PUBLIC_KEY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameEqualTo(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME =", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameNotEqualTo(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME <>", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameGreaterThan(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME >", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME >=", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameLessThan(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME <", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameLessThanOrEqualTo(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME <=", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameLike(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME like", value, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameNotLike(String value) {
            addCriterion("CLT_PUBLIC_KEY_NAME not like", value,
                    "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameIn(List<String> values) {
            addCriterion("CLT_PUBLIC_KEY_NAME in", values, "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameNotIn(List<String> values) {
            addCriterion("CLT_PUBLIC_KEY_NAME not in", values,
                    "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameBetween(String value1, String value2) {
            addCriterion("CLT_PUBLIC_KEY_NAME between", value1, value2,
                    "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPublicKeyNameNotBetween(String value1,
                String value2) {
            addCriterion("CLT_PUBLIC_KEY_NAME not between", value1, value2,
                    "cltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameIsNull() {
            addCriterion("CLT_PRIVATE_CERT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameIsNotNull() {
            addCriterion("CLT_PRIVATE_CERT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameEqualTo(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME =", value, "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameNotEqualTo(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME <>", value,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameGreaterThan(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME >", value, "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME >=", value,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameLessThan(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME <", value, "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameLessThanOrEqualTo(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME <=", value,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameLike(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME like", value,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameNotLike(String value) {
            addCriterion("CLT_PRIVATE_CERT_NAME not like", value,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameIn(List<String> values) {
            addCriterion("CLT_PRIVATE_CERT_NAME in", values,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameNotIn(List<String> values) {
            addCriterion("CLT_PRIVATE_CERT_NAME not in", values,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameBetween(String value1,
                String value2) {
            addCriterion("CLT_PRIVATE_CERT_NAME between", value1, value2,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andCltPrivateCertNameNotBetween(String value1,
                String value2) {
            addCriterion("CLT_PRIVATE_CERT_NAME not between", value1, value2,
                    "cltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassIsNull() {
            addCriterion("PLT_PRIVATE_KEY_PASS is null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassIsNotNull() {
            addCriterion("PLT_PRIVATE_KEY_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS =", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassNotEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS <>", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassGreaterThan(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS >", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassGreaterThanOrEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS >=", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassLessThan(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS <", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassLessThanOrEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS <=", value, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassLike(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS like", value,
                    "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassNotLike(String value) {
            addCriterion("PLT_PRIVATE_KEY_PASS not like", value,
                    "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassIn(List<String> values) {
            addCriterion("PLT_PRIVATE_KEY_PASS in", values, "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassNotIn(List<String> values) {
            addCriterion("PLT_PRIVATE_KEY_PASS not in", values,
                    "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassBetween(String value1, String value2) {
            addCriterion("PLT_PRIVATE_KEY_PASS between", value1, value2,
                    "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyPassNotBetween(String value1,
                String value2) {
            addCriterion("PLT_PRIVATE_KEY_PASS not between", value1, value2,
                    "pltPrivateKeyPass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassIsNull() {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS is null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassIsNotNull() {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS =", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassNotEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS <>", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassGreaterThan(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS >", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassGreaterThanOrEqualTo(
                String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS >=", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassLessThan(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS <", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassLessThanOrEqualTo(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS <=", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassLike(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS like", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassNotLike(String value) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS not like", value,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassIn(List<String> values) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS in", values,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassNotIn(List<String> values) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS not in", values,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassBetween(String value1,
                String value2) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS between", value1, value2,
                    "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPrivateKeyStorePassNotBetween(String value1,
                String value2) {
            addCriterion("PLT_PRIVATE_KEY_STORE_PASS not between", value1,
                    value2, "pltPrivateKeyStorePass");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameIsNull() {
            addCriterion("PLT_PUBLIC_KEY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameIsNotNull() {
            addCriterion("PLT_PUBLIC_KEY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameEqualTo(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME =", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameNotEqualTo(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME <>", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameGreaterThan(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME >", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME >=", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameLessThan(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME <", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameLessThanOrEqualTo(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME <=", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameLike(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME like", value, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameNotLike(String value) {
            addCriterion("PLT_PUBLIC_KEY_NAME not like", value,
                    "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameIn(List<String> values) {
            addCriterion("PLT_PUBLIC_KEY_NAME in", values, "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameNotIn(List<String> values) {
            addCriterion("PLT_PUBLIC_KEY_NAME not in", values,
                    "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameBetween(String value1, String value2) {
            addCriterion("PLT_PUBLIC_KEY_NAME between", value1, value2,
                    "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPublicKeyNameNotBetween(String value1,
                String value2) {
            addCriterion("PLT_PUBLIC_KEY_NAME not between", value1, value2,
                    "pltPublicKeyName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameIsNull() {
            addCriterion("PLT_PRIVATE_CERT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameIsNotNull() {
            addCriterion("PLT_PRIVATE_CERT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameEqualTo(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME =", value, "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameNotEqualTo(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME <>", value,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameGreaterThan(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME >", value, "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME >=", value,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameLessThan(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME <", value, "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameLessThanOrEqualTo(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME <=", value,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameLike(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME like", value,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameNotLike(String value) {
            addCriterion("PLT_PRIVATE_CERT_NAME not like", value,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameIn(List<String> values) {
            addCriterion("PLT_PRIVATE_CERT_NAME in", values,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameNotIn(List<String> values) {
            addCriterion("PLT_PRIVATE_CERT_NAME not in", values,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameBetween(String value1,
                String value2) {
            addCriterion("PLT_PRIVATE_CERT_NAME between", value1, value2,
                    "pltPrivateCertName");
            return (Criteria) this;
        }

        public Criteria andPltPrivateCertNameNotBetween(String value1,
                String value2) {
            addCriterion("PLT_PRIVATE_CERT_NAME not between", value1, value2,
                    "pltPrivateCertName");
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
     * For table api_org_cert
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
     * api_org_cert
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}