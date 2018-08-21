package com.zyxy.common.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SysUserExample {
    /**
     * sys_user
     * @mbggenerated
     */
    protected String orderByClause;
    /**
     * sys_user
     * @mbggenerated
     */
    protected boolean distinct;
    /**
     * sys_user
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * sys_user
     * @mbggenerated
     */
    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * sys_user
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
     * sys_user
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * sys_user
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * For table sys_user
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

        public Criteria andUserInfoIdIsNull() {
            addCriterion("USER_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIsNotNull() {
            addCriterion("USER_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdEqualTo(String value) {
            addCriterion("USER_INFO_ID =", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotEqualTo(String value) {
            addCriterion("USER_INFO_ID <>", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThan(String value) {
            addCriterion("USER_INFO_ID >", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_INFO_ID >=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThan(String value) {
            addCriterion("USER_INFO_ID <", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThanOrEqualTo(String value) {
            addCriterion("USER_INFO_ID <=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLike(String value) {
            addCriterion("USER_INFO_ID like", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotLike(String value) {
            addCriterion("USER_INFO_ID not like", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIn(List<String> values) {
            addCriterion("USER_INFO_ID in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotIn(List<String> values) {
            addCriterion("USER_INFO_ID not in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdBetween(String value1, String value2) {
            addCriterion("USER_INFO_ID between", value1, value2, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotBetween(String value1, String value2) {
            addCriterion("USER_INFO_ID not between", value1, value2,
                    "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("USER_NO is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("USER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("USER_NO =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("USER_NO <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("USER_NO >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NO >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("USER_NO <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("USER_NO <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("USER_NO like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("USER_NO not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("USER_NO in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("USER_NO not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("USER_NO between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("USER_NO not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USER_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USER_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USER_PWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USER_PWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USER_PWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USER_PWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_PWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USER_PWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USER_PWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USER_PWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USER_PWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USER_PWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USER_PWD not between", value1, value2, "userPwd");
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

        public Criteria andRegisterIpIsNull() {
            addCriterion("REGISTER_IP is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIsNotNull() {
            addCriterion("REGISTER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpEqualTo(String value) {
            addCriterion("REGISTER_IP =", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotEqualTo(String value) {
            addCriterion("REGISTER_IP <>", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThan(String value) {
            addCriterion("REGISTER_IP >", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_IP >=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThan(String value) {
            addCriterion("REGISTER_IP <", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_IP <=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLike(String value) {
            addCriterion("REGISTER_IP like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotLike(String value) {
            addCriterion("REGISTER_IP not like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIn(List<String> values) {
            addCriterion("REGISTER_IP in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotIn(List<String> values) {
            addCriterion("REGISTER_IP not in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpBetween(String value1, String value2) {
            addCriterion("REGISTER_IP between", value1, value2, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotBetween(String value1, String value2) {
            addCriterion("REGISTER_IP not between", value1, value2,
                    "registerIp");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdIsNull() {
            addCriterion("RESOURCE_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdIsNotNull() {
            addCriterion("RESOURCE_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdEqualTo(String value) {
            addCriterion("RESOURCE_ORG_ID =", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdNotEqualTo(String value) {
            addCriterion("RESOURCE_ORG_ID <>", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdGreaterThan(String value) {
            addCriterion("RESOURCE_ORG_ID >", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ORG_ID >=", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdLessThan(String value) {
            addCriterion("RESOURCE_ORG_ID <", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ORG_ID <=", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdLike(String value) {
            addCriterion("RESOURCE_ORG_ID like", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdNotLike(String value) {
            addCriterion("RESOURCE_ORG_ID not like", value, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdIn(List<String> values) {
            addCriterion("RESOURCE_ORG_ID in", values, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdNotIn(List<String> values) {
            addCriterion("RESOURCE_ORG_ID not in", values, "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdBetween(String value1, String value2) {
            addCriterion("RESOURCE_ORG_ID between", value1, value2,
                    "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andResourceOrgIdNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_ORG_ID not between", value1, value2,
                    "resourceOrgId");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIsNull() {
            addCriterion("LOGIN_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIsNotNull() {
            addCriterion("LOGIN_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimesEqualTo(Integer value) {
            addCriterion("LOGIN_TIMES =", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotEqualTo(Integer value) {
            addCriterion("LOGIN_TIMES <>", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesGreaterThan(Integer value) {
            addCriterion("LOGIN_TIMES >", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_TIMES >=", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesLessThan(Integer value) {
            addCriterion("LOGIN_TIMES <", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesLessThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_TIMES <=", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIn(List<Integer> values) {
            addCriterion("LOGIN_TIMES in", values, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotIn(List<Integer> values) {
            addCriterion("LOGIN_TIMES not in", values, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_TIMES between", value1, value2, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_TIMES not between", value1, value2,
                    "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("LAST_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("LAST_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("LAST_LOGIN_IP >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("LAST_LOGIN_IP <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("LAST_LOGIN_IP like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("LAST_LOGIN_IP not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP not between", value1, value2,
                    "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2,
                    "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2,
                    "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleIsNull() {
            addCriterion("LAST_SELECT_ROLE is null");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleIsNotNull() {
            addCriterion("LAST_SELECT_ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleEqualTo(Integer value) {
            addCriterion("LAST_SELECT_ROLE =", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleNotEqualTo(Integer value) {
            addCriterion("LAST_SELECT_ROLE <>", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleGreaterThan(Integer value) {
            addCriterion("LAST_SELECT_ROLE >", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAST_SELECT_ROLE >=", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleLessThan(Integer value) {
            addCriterion("LAST_SELECT_ROLE <", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleLessThanOrEqualTo(Integer value) {
            addCriterion("LAST_SELECT_ROLE <=", value, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleIn(List<Integer> values) {
            addCriterion("LAST_SELECT_ROLE in", values, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleNotIn(List<Integer> values) {
            addCriterion("LAST_SELECT_ROLE not in", values, "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleBetween(Integer value1, Integer value2) {
            addCriterion("LAST_SELECT_ROLE between", value1, value2,
                    "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andLastSelectRoleNotBetween(Integer value1,
                Integer value2) {
            addCriterion("LAST_SELECT_ROLE not between", value1, value2,
                    "lastSelectRole");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("NICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("NICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("NICK_NAME =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("NICK_NAME <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("NICK_NAME >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("NICK_NAME >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("NICK_NAME <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("NICK_NAME <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("NICK_NAME like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("NICK_NAME not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("NICK_NAME in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("NICK_NAME not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("NICK_NAME between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("NICK_NAME not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIsNull() {
            addCriterion("HEADPHOTO is null");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIsNotNull() {
            addCriterion("HEADPHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andHeadphotoEqualTo(String value) {
            addCriterion("HEADPHOTO =", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotEqualTo(String value) {
            addCriterion("HEADPHOTO <>", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoGreaterThan(String value) {
            addCriterion("HEADPHOTO >", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoGreaterThanOrEqualTo(String value) {
            addCriterion("HEADPHOTO >=", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLessThan(String value) {
            addCriterion("HEADPHOTO <", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLessThanOrEqualTo(String value) {
            addCriterion("HEADPHOTO <=", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLike(String value) {
            addCriterion("HEADPHOTO like", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotLike(String value) {
            addCriterion("HEADPHOTO not like", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIn(List<String> values) {
            addCriterion("HEADPHOTO in", values, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotIn(List<String> values) {
            addCriterion("HEADPHOTO not in", values, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoBetween(String value1, String value2) {
            addCriterion("HEADPHOTO between", value1, value2, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotBetween(String value1, String value2) {
            addCriterion("HEADPHOTO not between", value1, value2, "headphoto");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("LOGIN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("LOGIN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(Integer value) {
            addCriterion("LOGIN_TYPE =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(Integer value) {
            addCriterion("LOGIN_TYPE <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(Integer value) {
            addCriterion("LOGIN_TYPE >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_TYPE >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(Integer value) {
            addCriterion("LOGIN_TYPE <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_TYPE <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<Integer> values) {
            addCriterion("LOGIN_TYPE in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<Integer> values) {
            addCriterion("LOGIN_TYPE not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_TYPE between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_TYPE not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andRealAuthIsNull() {
            addCriterion("REAL_AUTH is null");
            return (Criteria) this;
        }

        public Criteria andRealAuthIsNotNull() {
            addCriterion("REAL_AUTH is not null");
            return (Criteria) this;
        }

        public Criteria andRealAuthEqualTo(Integer value) {
            addCriterion("REAL_AUTH =", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthNotEqualTo(Integer value) {
            addCriterion("REAL_AUTH <>", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthGreaterThan(Integer value) {
            addCriterion("REAL_AUTH >", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthGreaterThanOrEqualTo(Integer value) {
            addCriterion("REAL_AUTH >=", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthLessThan(Integer value) {
            addCriterion("REAL_AUTH <", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthLessThanOrEqualTo(Integer value) {
            addCriterion("REAL_AUTH <=", value, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthIn(List<Integer> values) {
            addCriterion("REAL_AUTH in", values, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthNotIn(List<Integer> values) {
            addCriterion("REAL_AUTH not in", values, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthBetween(Integer value1, Integer value2) {
            addCriterion("REAL_AUTH between", value1, value2, "realAuth");
            return (Criteria) this;
        }

        public Criteria andRealAuthNotBetween(Integer value1, Integer value2) {
            addCriterion("REAL_AUTH not between", value1, value2, "realAuth");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesIsNull() {
            addCriterion("PWD_WRONG_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesIsNotNull() {
            addCriterion("PWD_WRONG_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesEqualTo(Integer value) {
            addCriterion("PWD_WRONG_TIMES =", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesNotEqualTo(Integer value) {
            addCriterion("PWD_WRONG_TIMES <>", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesGreaterThan(Integer value) {
            addCriterion("PWD_WRONG_TIMES >", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("PWD_WRONG_TIMES >=", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesLessThan(Integer value) {
            addCriterion("PWD_WRONG_TIMES <", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesLessThanOrEqualTo(Integer value) {
            addCriterion("PWD_WRONG_TIMES <=", value, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesIn(List<Integer> values) {
            addCriterion("PWD_WRONG_TIMES in", values, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesNotIn(List<Integer> values) {
            addCriterion("PWD_WRONG_TIMES not in", values, "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesBetween(Integer value1, Integer value2) {
            addCriterion("PWD_WRONG_TIMES between", value1, value2,
                    "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andPwdWrongTimesNotBetween(Integer value1,
                Integer value2) {
            addCriterion("PWD_WRONG_TIMES not between", value1, value2,
                    "pwdWrongTimes");
            return (Criteria) this;
        }

        public Criteria andBelockedIsNull() {
            addCriterion("BELOCKED is null");
            return (Criteria) this;
        }

        public Criteria andBelockedIsNotNull() {
            addCriterion("BELOCKED is not null");
            return (Criteria) this;
        }

        public Criteria andBelockedEqualTo(Integer value) {
            addCriterion("BELOCKED =", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedNotEqualTo(Integer value) {
            addCriterion("BELOCKED <>", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedGreaterThan(Integer value) {
            addCriterion("BELOCKED >", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedGreaterThanOrEqualTo(Integer value) {
            addCriterion("BELOCKED >=", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedLessThan(Integer value) {
            addCriterion("BELOCKED <", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedLessThanOrEqualTo(Integer value) {
            addCriterion("BELOCKED <=", value, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedIn(List<Integer> values) {
            addCriterion("BELOCKED in", values, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedNotIn(List<Integer> values) {
            addCriterion("BELOCKED not in", values, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedBetween(Integer value1, Integer value2) {
            addCriterion("BELOCKED between", value1, value2, "belocked");
            return (Criteria) this;
        }

        public Criteria andBelockedNotBetween(Integer value1, Integer value2) {
            addCriterion("BELOCKED not between", value1, value2, "belocked");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdIsNull() {
            addCriterion("CURR_THIRD_OAUTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdIsNotNull() {
            addCriterion("CURR_THIRD_OAUTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdEqualTo(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID =", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdNotEqualTo(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID <>", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdGreaterThan(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID >", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID >=", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdLessThan(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID <", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdLessThanOrEqualTo(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID <=", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdLike(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID like", value, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdNotLike(String value) {
            addCriterion("CURR_THIRD_OAUTH_ID not like", value,
                    "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdIn(List<String> values) {
            addCriterion("CURR_THIRD_OAUTH_ID in", values, "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdNotIn(List<String> values) {
            addCriterion("CURR_THIRD_OAUTH_ID not in", values,
                    "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdBetween(String value1, String value2) {
            addCriterion("CURR_THIRD_OAUTH_ID between", value1, value2,
                    "currThirdOauthId");
            return (Criteria) this;
        }

        public Criteria andCurrThirdOauthIdNotBetween(String value1,
                String value2) {
            addCriterion("CURR_THIRD_OAUTH_ID not between", value1, value2,
                    "currThirdOauthId");
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

        public Criteria andUpdateIdIsNull() {
            addCriterion("UPDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("UPDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(String value) {
            addCriterion("UPDATE_ID =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(String value) {
            addCriterion("UPDATE_ID <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(String value) {
            addCriterion("UPDATE_ID >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(String value) {
            addCriterion("UPDATE_ID <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLike(String value) {
            addCriterion("UPDATE_ID like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotLike(String value) {
            addCriterion("UPDATE_ID not like", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<String> values) {
            addCriterion("UPDATE_ID in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<String> values) {
            addCriterion("UPDATE_ID not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(String value1, String value2) {
            addCriterion("UPDATE_ID between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_ID not between", value1, value2, "updateId");
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
     * For table sys_user
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
     * sys_user
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}