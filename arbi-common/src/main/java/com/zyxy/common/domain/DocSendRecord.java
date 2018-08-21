package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table doc_send_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class DocSendRecord implements Serializable {
    /**
     * Database Column Remarks:
     *   id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   文书id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.DOC_ID
     *
     * @mbggenerated
     */
    private String docId;

    /**
     * Database Column Remarks:
     *   案件id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.CASE_ID
     *
     * @mbggenerated
     */
    private String caseId;

    /**
     * Database Column Remarks:
     *   接收人ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.RECEIVER_ID
     *
     * @mbggenerated
     */
    private String receiverId;

    /**
     * Database Column Remarks:
     *   接收人类别 0-申请人，1-被申请人，2-申请人的代理人，3-被申请人的代理人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.RECEIVER_TYPE
     *
     * @mbggenerated
     */
    private String receiverType;

    /**
     * Database Column Remarks:
     *   发送方式 0-短信，
     *   1-邮件，2-快递
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.SEND_TYPE
     *
     * @mbggenerated
     */
    private String sendType;

    /**
     * Database Column Remarks:
     *   状态，0-正常，1-失败
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.STATUS
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   创建人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.CREATER_ID
     *
     * @mbggenerated
     */
    private String createrId;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column doc_send_record.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table doc_send_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.ID
     *
     * @return the value of doc_send_record.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.ID
     *
     * @param id the value for doc_send_record.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.DOC_ID
     *
     * @return the value of doc_send_record.DOC_ID
     *
     * @mbggenerated
     */
    public String getDocId() {
        return docId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.DOC_ID
     *
     * @param docId the value for doc_send_record.DOC_ID
     *
     * @mbggenerated
     */
    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.CASE_ID
     *
     * @return the value of doc_send_record.CASE_ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.CASE_ID
     *
     * @param caseId the value for doc_send_record.CASE_ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.RECEIVER_ID
     *
     * @return the value of doc_send_record.RECEIVER_ID
     *
     * @mbggenerated
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.RECEIVER_ID
     *
     * @param receiverId the value for doc_send_record.RECEIVER_ID
     *
     * @mbggenerated
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.RECEIVER_TYPE
     *
     * @return the value of doc_send_record.RECEIVER_TYPE
     *
     * @mbggenerated
     */
    public String getReceiverType() {
        return receiverType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.RECEIVER_TYPE
     *
     * @param receiverType the value for doc_send_record.RECEIVER_TYPE
     *
     * @mbggenerated
     */
    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType == null ? null : receiverType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.SEND_TYPE
     *
     * @return the value of doc_send_record.SEND_TYPE
     *
     * @mbggenerated
     */
    public String getSendType() {
        return sendType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.SEND_TYPE
     *
     * @param sendType the value for doc_send_record.SEND_TYPE
     *
     * @mbggenerated
     */
    public void setSendType(String sendType) {
        this.sendType = sendType == null ? null : sendType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.STATUS
     *
     * @return the value of doc_send_record.STATUS
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.STATUS
     *
     * @param status the value for doc_send_record.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.CREATER_ID
     *
     * @return the value of doc_send_record.CREATER_ID
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.CREATER_ID
     *
     * @param createrId the value for doc_send_record.CREATER_ID
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column doc_send_record.CREATE_TIME
     *
     * @return the value of doc_send_record.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column doc_send_record.CREATE_TIME
     *
     * @param createTime the value for doc_send_record.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}