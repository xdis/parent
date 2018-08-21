package com.zyxy.common.vo;

import java.util.Date;

/**
 * 仲裁委后台用户管理VO
 */
public class ArbitrationUserInfoVO {

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职务
     */
    private String duties;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 账号状态
     */
    private String sysStatus;

    /**
     * 仲裁委工作人员状态
     */
    private String managerStatus;

    /**
     * 用户id
     */
    private String userId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus;
    }

    public String getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(String managerStatus) {
        this.managerStatus = managerStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
