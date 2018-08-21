package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tanquan
 *
 * sys_user
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysUser")
public class SysUser implements Serializable {

    /**
     * ID sys_user.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 用户信息ID（与user_info.id关联） sys_user.USER_INFO_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户信息ID（与user_info.id关联）")
    private String userInfoId;
    /**
     * 用户编号 sys_user.USER_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户编号")
    private String userNo;
    /**
     * 用户类型：0-当事人，1-仲裁员，2-仲裁委 sys_user.USER_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户类型：0-当事人，1-仲裁员，2-仲裁委")
    private Integer userType;
    /**
     * 用户名 sys_user.USER_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 用户密码 sys_user.USER_PWD
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户密码")
    private String userPwd;
    /**
     * 用户状态：0-不可用，1-正常 sys_user.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户状态：0-不可用，1-正常")
    private Integer status;
    /**
     * 注册IP sys_user.REGISTER_IP
     * @mbggenerated
     */
    @ApiModelProperty(value = "注册IP")
    private String registerIp;
    /**
     * 用户来源（与api_orgnazation.id关联），null-本系统 sys_user.RESOURCE_ORG_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户来源（与api_orgnazation.id关联），null-本系统")
    private String resourceOrgId;
    /**
     * 登录次数 sys_user.LOGIN_TIMES
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录次数")
    private Integer loginTimes;
    /**
     * 最后登录IP sys_user.LAST_LOGIN_IP
     * @mbggenerated
     */
    @ApiModelProperty(value = "最后登录IP")
    private String lastLoginIp;
    /**
     * 最后登录时间 sys_user.LAST_LOGIN_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;
    /**
     * 最后登录的身份：0-申请人，1-被申请人，2-代理人 sys_user.LAST_SELECT_ROLE
     * @mbggenerated
     */
    @ApiModelProperty(value = "最后登录的身份：0-申请人，1-被申请人，2-代理人")
    private Integer lastSelectRole;
    /**
     * 昵称 sys_user.NICK_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 用户头像 sys_user.HEADPHOTO
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户头像")
    private String headphoto;
    /**
     * 登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录 sys_user.LOGIN_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录")
    private Integer loginType;
    /**
     * 是否进行了实名认证：0-否，1-是 sys_user.REAL_AUTH
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否进行了实名认证：0-否，1-是")
    private Integer realAuth;
    /**
     * 登录密码错误次数 sys_user.PWD_WRONG_TIMES
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录密码错误次数")
    private Integer pwdWrongTimes;
    /**
     * 是否锁定：0-否，1-是） sys_user.BELOCKED
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否锁定：0-否，1-是）")
    private Integer belocked;
    /**
     * 当前登录的三方帐号关联ID sys_user.CURR_THIRD_OAUTH_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前登录的三方帐号关联ID")
    private String currThirdOauthId;
    /**
     * 创建人ID sys_user.CREATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人ID")
    private String createId;
    /**
     * 更新人ID sys_user.UPDATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人ID")
    private String updateId;
    /**
     * 创建时间 sys_user.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_user.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 删除标识：0-未删除，1-已删除 sys_user.DELETED_FLAG
     * @mbggenerated
     */
    @ApiModelProperty(value = "删除标识：0-未删除，1-已删除")
    private Integer deletedFlag;
    /**
     * sys_user
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * @return  ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id  ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户信息ID（与user_info.id关联）
     * @return  用户信息ID（与user_info.id关联）
     * @mbggenerated
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 用户信息ID（与user_info.id关联）
     * @param userInfoId  用户信息ID（与user_info.id关联）
     * @mbggenerated
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    /**
     * 用户编号
     * @return  用户编号
     * @mbggenerated
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 用户编号
     * @param userNo  用户编号
     * @mbggenerated
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 用户类型：0-当事人，1-仲裁员，2-仲裁委
     * @return  用户类型：0-当事人，1-仲裁员，2-仲裁委
     * @mbggenerated
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 用户类型：0-当事人，1-仲裁员，2-仲裁委
     * @param userType  用户类型：0-当事人，1-仲裁员，2-仲裁委
     * @mbggenerated
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 用户名
     * @return  用户名
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName  用户名
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户密码
     * @return  用户密码
     * @mbggenerated
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 用户密码
     * @param userPwd  用户密码
     * @mbggenerated
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 用户状态：0-不可用，1-正常
     * @return  用户状态：0-不可用，1-正常
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 用户状态：0-不可用，1-正常
     * @param status  用户状态：0-不可用，1-正常
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 注册IP
     * @return  注册IP
     * @mbggenerated
     */
    public String getRegisterIp() {
        return registerIp;
    }

    /**
     * 注册IP
     * @param registerIp  注册IP
     * @mbggenerated
     */
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    /**
     * 用户来源（与api_orgnazation.id关联），null-本系统
     * @return  用户来源（与api_orgnazation.id关联），null-本系统
     * @mbggenerated
     */
    public String getResourceOrgId() {
        return resourceOrgId;
    }

    /**
     * 用户来源（与api_orgnazation.id关联），null-本系统
     * @param resourceOrgId  用户来源（与api_orgnazation.id关联），null-本系统
     * @mbggenerated
     */
    public void setResourceOrgId(String resourceOrgId) {
        this.resourceOrgId = resourceOrgId == null ? null : resourceOrgId
                .trim();
    }

    /**
     * 登录次数
     * @return  登录次数
     * @mbggenerated
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * 登录次数
     * @param loginTimes  登录次数
     * @mbggenerated
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * 最后登录IP
     * @return  最后登录IP
     * @mbggenerated
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登录IP
     * @param lastLoginIp  最后登录IP
     * @mbggenerated
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * 最后登录时间
     * @return  最后登录时间
     * @mbggenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     * @param lastLoginTime  最后登录时间
     * @mbggenerated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 最后登录的身份：0-申请人，1-被申请人，2-代理人
     * @return  最后登录的身份：0-申请人，1-被申请人，2-代理人
     * @mbggenerated
     */
    public Integer getLastSelectRole() {
        return lastSelectRole;
    }

    /**
     * 最后登录的身份：0-申请人，1-被申请人，2-代理人
     * @param lastSelectRole  最后登录的身份：0-申请人，1-被申请人，2-代理人
     * @mbggenerated
     */
    public void setLastSelectRole(Integer lastSelectRole) {
        this.lastSelectRole = lastSelectRole;
    }

    /**
     * 昵称
     * @return  昵称
     * @mbggenerated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName  昵称
     * @mbggenerated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 用户头像
     * @return  用户头像
     * @mbggenerated
     */
    public String getHeadphoto() {
        return headphoto;
    }

    /**
     * 用户头像
     * @param headphoto  用户头像
     * @mbggenerated
     */
    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto == null ? null : headphoto.trim();
    }

    /**
     * 登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录
     * @return  登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录
     * @mbggenerated
     */
    public Integer getLoginType() {
        return loginType;
    }

    /**
     * 登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录
     * @param loginType  登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录
     * @mbggenerated
     */
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    /**
     * 是否进行了实名认证：0-否，1-是
     * @return  是否进行了实名认证：0-否，1-是
     * @mbggenerated
     */
    public Integer getRealAuth() {
        return realAuth;
    }

    /**
     * 是否进行了实名认证：0-否，1-是
     * @param realAuth  是否进行了实名认证：0-否，1-是
     * @mbggenerated
     */
    public void setRealAuth(Integer realAuth) {
        this.realAuth = realAuth;
    }

    /**
     * 登录密码错误次数
     * @return  登录密码错误次数
     * @mbggenerated
     */
    public Integer getPwdWrongTimes() {
        return pwdWrongTimes;
    }

    /**
     * 登录密码错误次数
     * @param pwdWrongTimes  登录密码错误次数
     * @mbggenerated
     */
    public void setPwdWrongTimes(Integer pwdWrongTimes) {
        this.pwdWrongTimes = pwdWrongTimes;
    }

    /**
     * 是否锁定：0-否，1-是）
     * @return  是否锁定：0-否，1-是）
     * @mbggenerated
     */
    public Integer getBelocked() {
        return belocked;
    }

    /**
     * 是否锁定：0-否，1-是）
     * @param belocked  是否锁定：0-否，1-是）
     * @mbggenerated
     */
    public void setBelocked(Integer belocked) {
        this.belocked = belocked;
    }

    /**
     * 当前登录的三方帐号关联ID
     * @return  当前登录的三方帐号关联ID
     * @mbggenerated
     */
    public String getCurrThirdOauthId() {
        return currThirdOauthId;
    }

    /**
     * 当前登录的三方帐号关联ID
     * @param currThirdOauthId  当前登录的三方帐号关联ID
     * @mbggenerated
     */
    public void setCurrThirdOauthId(String currThirdOauthId) {
        this.currThirdOauthId = currThirdOauthId == null ? null
                : currThirdOauthId.trim();
    }

    /**
     * 创建人ID
     * @return  创建人ID
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人ID
     * @param createId  创建人ID
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 更新人ID
     * @return  更新人ID
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人ID
     * @param updateId  更新人ID
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 创建时间
     * @return  创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime  创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return  更新时间
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime  更新时间
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 删除标识：0-未删除，1-已删除
     * @return  删除标识：0-未删除，1-已删除
     * @mbggenerated
     */
    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * 删除标识：0-未删除，1-已删除
     * @param deletedFlag  删除标识：0-未删除，1-已删除
     * @mbggenerated
     */
    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}