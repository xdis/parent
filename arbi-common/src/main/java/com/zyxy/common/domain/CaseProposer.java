package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_proposer
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseProposer")
public class CaseProposer implements Serializable {
    /**
     * case_proposer.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 
     *   案件
     * case_proposer.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件")
    private String caseId;

    /**
     * 
     *   申请人名称
     * case_proposer.PROP_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人名称")
    private String propName;

    /**
     * 
     *   身份证号
     * case_proposer.CARD_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证号")
    private String cardId;

    /**
     * 
     *   住址
     * case_proposer.ADDRESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "住址")
    private String address;

    /**
     * 
     *   手机号码
     * case_proposer.PHONE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 
     *   身份证正面照
     * case_proposer.CARD_IMAGE_FRONT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证正面照")
    private String cardImageFront;

    /**
     * 
     *   身份证反面照
     * case_proposer.CARD_IMAGE_CON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证反面照")
    private String cardImageCon;

    /**
     * case_proposer.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     * case_proposer.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * case_proposer.BIRTHDAY
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String birthday;

    /**
     * case_proposer.SEX
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String sex;

    /**
     * case_proposer.EMAIL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String email;

    /**
     * case_proposer.PROP_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String propType;

    /**
     * case_proposer.CERT_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String certName;

    /**
     * case_proposer.CERT_DUTIES
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String certDuties;

    /**
     * case_proposer.UNIFIED_SOCIAL_CODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String unifiedSocialCode;

    /**
     * case_proposer.ETHNIC
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String ethnic;

    /**
     * case_proposer
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
     * 案件
     * 
     * @return 案件
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件
     * 
     * @param caseId 案件
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 申请人名称
     * 
     * @return 申请人名称
     *
     * @mbggenerated
     */
    public String getPropName() {
        return propName;
    }

    /**
     * 申请人名称
     * 
     * @param propName 申请人名称
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
     * 手机号码
     * 
     * @return 手机号码
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * 
     * @param phone 手机号码
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
    public String getCardImageFront() {
        return cardImageFront;
    }

    /**
     * 身份证正面照
     * 
     * @param cardImageFront 身份证正面照
     *
     * @mbggenerated
     */
    public void setCardImageFront(String cardImageFront) {
        this.cardImageFront = cardImageFront == null ? null : cardImageFront.trim();
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
}