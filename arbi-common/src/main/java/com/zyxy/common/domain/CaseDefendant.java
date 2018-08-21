package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_defendant
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseDefendant")
public class CaseDefendant implements Serializable {
    /**
     * case_defendant.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 
     *   案件ID
     * case_defendant.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     * 
     *   被申请人名称
     * case_defendant.PROP_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "被申请人名称")
    private String propName;

    /**
     * 
     *   身份证号
     * case_defendant.CARD_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证号")
    private String cardId;

    /**
     * 
     *   住址
     * case_defendant.ADDRESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "住址")
    private String address;

    /**
     * 
     *   手机号
     * case_defendant.PHONE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 
     *   身份证正面照
     * case_defendant.CARD_IMAGE_PRONT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证正面照")
    private String cardImagePront;

    /**
     * 
     *   身份证反面照
     * case_defendant.CARD_IMAGE_CON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证反面照")
    private String cardImageCon;

    /**
     * case_defendant.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     * case_defendant.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * case_defendant.BIRTHDAY
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String birthday;

    /**
     * case_defendant.EMAIL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String email;

    /**
     * case_defendant.PROP_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String propType;

    /**
     * case_defendant.CERT_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String certName;

    /**
     * case_defendant.CERT_DUTIES
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String certDuties;

    /**
     * case_defendant.UNIFIED_SOCIAL_CODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String unifiedSocialCode;

    /**
     * case_defendant.ETHNIC
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String ethnic;

    /**
     * case_defendant.SEX
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String sex;

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * 
     * @param id 
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件ID
     * 
     * @return 案件ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件ID
     * 
     * @param caseId 案件ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 被申请人名称
     * 
     * @return 被申请人名称
     *
     * @mbggenerated
     */
    public String getPropName() {
        return propName;
    }

    /**
     * 被申请人名称
     * 
     * @param propName 被申请人名称
     *
     * @mbggenerated
     */
    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    /**
     * 身份证号
     * 
     * @return 身份证号
     *
     * @mbggenerated
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 身份证号
     * 
     * @param cardId 身份证号
     *
     * @mbggenerated
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    /**
     * 住址
     * 
     * @return 住址
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住址
     * 
     * @param address 住址
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 身份证正面照
     * 
     * @return 身份证正面照
     *
     * @mbggenerated
     */
    public String getCardImagePront() {
        return cardImagePront;
    }

    /**
     * 身份证正面照
     * 
     * @param cardImagePront 身份证正面照
     *
     * @mbggenerated
     */
    public void setCardImagePront(String cardImagePront) {
        this.cardImagePront = cardImagePront == null ? null : cardImagePront.trim();
    }

    /**
     * 身份证反面照
     * 
     * @return 身份证反面照
     *
     * @mbggenerated
     */
    public String getCardImageCon() {
        return cardImageCon;
    }

    /**
     * 身份证反面照
     * 
     * @param cardImageCon 身份证反面照
     *
     * @mbggenerated
     */
    public void setCardImageCon(String cardImageCon) {
        this.cardImageCon = cardImageCon == null ? null : cardImageCon.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 
     * 
     * @param createrId 
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * 
     * @param createTime 
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 
     * 
     * @param birthday 
     *
     * @mbggenerated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
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
    public String getPropType() {
        return propType;
    }

    /**
     * 
     * 
     * @param propType 
     *
     * @mbggenerated
     */
    public void setPropType(String propType) {
        this.propType = propType == null ? null : propType.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getCertName() {
        return certName;
    }

    /**
     * 
     * 
     * @param certName 
     *
     * @mbggenerated
     */
    public void setCertName(String certName) {
        this.certName = certName == null ? null : certName.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getCertDuties() {
        return certDuties;
    }

    /**
     * 
     * 
     * @param certDuties 
     *
     * @mbggenerated
     */
    public void setCertDuties(String certDuties) {
        this.certDuties = certDuties == null ? null : certDuties.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getUnifiedSocialCode() {
        return unifiedSocialCode;
    }

    /**
     * 
     * 
     * @param unifiedSocialCode 
     *
     * @mbggenerated
     */
    public void setUnifiedSocialCode(String unifiedSocialCode) {
        this.unifiedSocialCode = unifiedSocialCode == null ? null : unifiedSocialCode.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getEthnic() {
        return ethnic;
    }

    /**
     * 
     * 
     * @param ethnic 
     *
     * @mbggenerated
     */
    public void setEthnic(String ethnic) {
        this.ethnic = ethnic == null ? null : ethnic.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     * 
     * @param sex 
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}