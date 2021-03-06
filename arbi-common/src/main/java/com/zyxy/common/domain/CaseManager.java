package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table case_manager
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class CaseManager implements Serializable {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   案件id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.CASE_ID
     *
     * @mbggenerated
     */
    private String caseId;

    /**
     * Database Column Remarks:
     *   仲裁委工作人员ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.MANAGER_ID
     *
     * @mbggenerated
     */
    private String managerId;

    /**
     * Database Column Remarks:
     *   工作人员身份 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.MANAGER_TYPE
     *
     * @mbggenerated
     */
    private String managerType;

    /**
     * Database Column Remarks:
     *   状态 0-有效，1-回避
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.REMARK
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   创建人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.CREATE _ID
     *
     * @mbggenerated
     */
    private String createId;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column case_manager.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table case_manager
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.ID
     *
     * @return the value of case_manager.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.ID
     *
     * @param id the value for case_manager.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.CASE_ID
     *
     * @return the value of case_manager.CASE_ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.CASE_ID
     *
     * @param caseId the value for case_manager.CASE_ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.MANAGER_ID
     *
     * @return the value of case_manager.MANAGER_ID
     *
     * @mbggenerated
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.MANAGER_ID
     *
     * @param managerId the value for case_manager.MANAGER_ID
     *
     * @mbggenerated
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.MANAGER_TYPE
     *
     * @return the value of case_manager.MANAGER_TYPE
     *
     * @mbggenerated
     */
    public String getManagerType() {
        return managerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.MANAGER_TYPE
     *
     * @param managerType the value for case_manager.MANAGER_TYPE
     *
     * @mbggenerated
     */
    public void setManagerType(String managerType) {
        this.managerType = managerType == null ? null : managerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.STATUS
     *
     * @return the value of case_manager.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.STATUS
     *
     * @param status the value for case_manager.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.REMARK
     *
     * @return the value of case_manager.REMARK
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.REMARK
     *
     * @param remark the value for case_manager.REMARK
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.CREATE _ID
     *
     * @return the value of case_manager.CREATE _ID
     *
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.CREATE _ID
     *
     * @param createId the value for case_manager.CREATE _ID
     *
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column case_manager.CREATE_TIME
     *
     * @return the value of case_manager.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column case_manager.CREATE_TIME
     *
     * @param createTime the value for case_manager.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}