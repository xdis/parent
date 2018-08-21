package com.zyxy.common.dto;

/**
 * 仲裁委后台用户管理DTO
 */
public class ArbitrationUserInfoDTO extends BasePageDTO{

    /**
     * 姓名或者手机号
     */
    private String nameOrPhone;

    /**
     * 职务
     */
    private String duties;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 账号状态
     */
    private String sysStatus;

    /**
     * 仲裁委工作人员状态
     */
    private String managerStatus;

    public String getNameOrPhone() {
        return nameOrPhone;
    }

    public void setNameOrPhone(String nameOrPhone) {
        this.nameOrPhone = nameOrPhone;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
}
