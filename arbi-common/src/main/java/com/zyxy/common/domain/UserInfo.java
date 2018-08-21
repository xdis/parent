package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * user_info
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="UserInfo")
public class UserInfo implements Serializable {
    /**
     * 
     *   用户编号
     * user_info.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户编号")
    private String id;

    /**
     * 
     *   手机号
     * user_info.PHONE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 
     *   姓名
     * user_info.NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 
     *   性别,0-男,1-女
     * user_info.SEX
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "性别,0-男,1-女")
    private String sex;

    /**
     * 
     *   当前用户身份,0-申请人,1-被申请人,2-代理人
     * user_info.CURRENT_ROLE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前用户身份,0-申请人,1-被申请人,2-代理人")
    private String currentRole;

    /**
     * 
     *   微信公众号OPENID
     * user_info.OPENID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "微信公众号OPENID")
    private String openid;

    /**
     * 
     *   创建人
     * user_info.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     * 
     *   创建时间
     * user_info.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 
     *   更新时间
     * user_info.UPDATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 
     *   更新人
     * user_info.UPDATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    private String updateId;

    /**
     * user_info.EMAIL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String email;

    /**
     * user_info.CARD_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String cardId;

    /**
     * user_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     * 
     * @return 用户编号
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 用户编号
     * 
     * @param id 用户编号
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 手机号
     * 
     * @return 手机号
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * 
     * @param phone 手机号
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 姓名
     * 
     * @return 姓名
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * 
     * @param name 姓名
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别,0-男,1-女
     * 
     * @return 性别,0-男,1-女
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别,0-男,1-女
     * 
     * @param sex 性别,0-男,1-女
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 当前用户身份,0-申请人,1-被申请人,2-代理人
     * 
     * @return 当前用户身份,0-申请人,1-被申请人,2-代理人
     *
     * @mbggenerated
     */
    public String getCurrentRole() {
        return currentRole;
    }

    /**
     * 当前用户身份,0-申请人,1-被申请人,2-代理人
     * 
     * @param currentRole 当前用户身份,0-申请人,1-被申请人,2-代理人
     *
     * @mbggenerated
     */
    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole == null ? null : currentRole.trim();
    }

    /**
     * 微信公众号OPENID
     * 
     * @return 微信公众号OPENID
     *
     * @mbggenerated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信公众号OPENID
     * 
     * @param openid 微信公众号OPENID
     *
     * @mbggenerated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 创建人
     * 
     * @return 创建人
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人
     * 
     * @param createrId 创建人
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * 
     * @return 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * 
     * @param updateTime 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新人
     * 
     * @return 更新人
     *
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人
     * 
     * @param updateId 更新人
     *
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * 
     * @param email 
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 
     * 
     * @param cardId 
     *
     * @mbggenerated
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }
}