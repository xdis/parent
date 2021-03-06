package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table approve_type
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ApproveType implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approve_type.TYPE_NAME
     *
     * @mbggenerated
     */
    private String typeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approve_type.TYPE_VALUE
     *
     * @mbggenerated
     */
    private String typeValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approve_type.STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approve_type.CREATE_ID
     *
     * @mbggenerated
     */
    private String createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column approve_type.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approve_type.TYPE_NAME
     *
     * @return the value of approve_type.TYPE_NAME
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approve_type.TYPE_NAME
     *
     * @param typeName the value for approve_type.TYPE_NAME
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approve_type.TYPE_VALUE
     *
     * @return the value of approve_type.TYPE_VALUE
     *
     * @mbggenerated
     */
    public String getTypeValue() {
        return typeValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approve_type.TYPE_VALUE
     *
     * @param typeValue the value for approve_type.TYPE_VALUE
     *
     * @mbggenerated
     */
    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue == null ? null : typeValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approve_type.STATUS
     *
     * @return the value of approve_type.STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approve_type.STATUS
     *
     * @param status the value for approve_type.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approve_type.CREATE_ID
     *
     * @return the value of approve_type.CREATE_ID
     *
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approve_type.CREATE_ID
     *
     * @param createId the value for approve_type.CREATE_ID
     *
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column approve_type.CREATE_TIME
     *
     * @return the value of approve_type.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column approve_type.CREATE_TIME
     *
     * @param createTime the value for approve_type.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}