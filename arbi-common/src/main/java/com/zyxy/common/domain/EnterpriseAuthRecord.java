package com.zyxy.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 企业认证表
 * <p>
 * enterprise_auth_record
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "EnterpriseAuthRecord")
public class EnterpriseAuthRecord implements Serializable {
    /**
     * ID
     * enterprise_auth_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 单位类型，0- 企业，1- 事业单位
     * enterprise_auth_record.TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位类型，0- 企业，1- 事业单位")
    private String type;

    /**
     * 公司名
     * enterprise_auth_record.NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司名")
    private String name;

    /**
     * 统一社会信用代码
     * enterprise_auth_record.UNIFIED_SOCIAL_CODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String unifiedSocialCode;

    /**
     * 邮箱
     * enterprise_auth_record.EMAIL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 法人姓名
     * enterprise_auth_record.CERT_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人姓名")
    private String certName;

    /**
     * 法人职务
     * enterprise_auth_record.CERT_DUTIES
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人职务")
    private String certDuties;

    /**
     * 住所
     * enterprise_auth_record.ADDRESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "住所")
    private String address;

    /**
     * 法人身份证正面照
     * enterprise_auth_record.CARD_IMAGE_FRONT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人身份证正面照")
    private String cardImageFront;

    /**
     * 法人身份证背面照
     * enterprise_auth_record.CARD_IMAGE_CON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人身份证背面照")
    private String cardImageCon;

    /**
     * 彩色三证合一营业执照
     * enterprise_auth_record.three_in_one
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "彩色三证合一营业执照")
    private String threeInOne;

    /**
     * 平台授权书扫描件
     * enterprise_auth_record.PLATFORM_AUTH
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台授权书扫描件")
    private String platformAuth;

    /**
     * 打款金额
     * enterprise_auth_record.AMOUNT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打款金额")
    private BigDecimal amount;

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * enterprise_auth_record.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态，0- 待审核，1- 审核通过，2- 审核不通过")
    private String status;

    /**
     * 创建时间
     * enterprise_auth_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 申请人userId
     * enterprise_auth_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人userId")
    private String createrId;

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @return ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     *
     * @param id ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 单位类型，0- 企业，1- 事业单位
     *
     * @return 单位类型，0- 企业，1- 事业单位
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 单位类型，0- 企业，1- 事业单位
     *
     * @param type 单位类型，0- 企业，1- 事业单位
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 公司名
     *
     * @return 公司名
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 公司名
     *
     * @param name 公司名
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 统一社会信用代码
     *
     * @return 统一社会信用代码
     * @mbggenerated
     */
    public String getUnifiedSocialCode() {
        return unifiedSocialCode;
    }

    /**
     * 统一社会信用代码
     *
     * @param unifiedSocialCode 统一社会信用代码
     * @mbggenerated
     */
    public void setUnifiedSocialCode(String unifiedSocialCode) {
        this.unifiedSocialCode = unifiedSocialCode == null ? null : unifiedSocialCode.trim();
    }

    /**
     * 邮箱
     *
     * @return 邮箱
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @param email 邮箱
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 法人姓名
     *
     * @return 法人姓名
     * @mbggenerated
     */
    public String getCertName() {
        return certName;
    }

    /**
     * 法人姓名
     *
     * @param certName 法人姓名
     * @mbggenerated
     */
    public void setCertName(String certName) {
        this.certName = certName == null ? null : certName.trim();
    }

    /**
     * 法人职务
     *
     * @return 法人职务
     * @mbggenerated
     */
    public String getCertDuties() {
        return certDuties;
    }

    /**
     * 法人职务
     *
     * @param certDuties 法人职务
     * @mbggenerated
     */
    public void setCertDuties(String certDuties) {
        this.certDuties = certDuties == null ? null : certDuties.trim();
    }

    /**
     * 住所
     *
     * @return 住所
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住所
     *
     * @param address 住所
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 法人身份证正面照
     *
     * @return 法人身份证正面照
     * @mbggenerated
     */
    public String getCardImageFront() {
        return cardImageFront;
    }

    /**
     * 法人身份证正面照
     *
     * @param cardImageFront 法人身份证正面照
     * @mbggenerated
     */
    public void setCardImageFront(String cardImageFront) {
        this.cardImageFront = cardImageFront == null ? null : cardImageFront.trim();
    }

    /**
     * 法人身份证背面照
     *
     * @return 法人身份证背面照
     * @mbggenerated
     */
    public String getCardImageCon() {
        return cardImageCon;
    }

    /**
     * 法人身份证背面照
     *
     * @param cardImageCon 法人身份证背面照
     * @mbggenerated
     */
    public void setCardImageCon(String cardImageCon) {
        this.cardImageCon = cardImageCon == null ? null : cardImageCon.trim();
    }

    /**
     * 彩色三证合一营业执照
     *
     * @return 彩色三证合一营业执照
     * @mbggenerated
     */
    public String getThreeInOne() {
        return threeInOne;
    }

    /**
     * 彩色三证合一营业执照
     *
     * @param threeInOne 彩色三证合一营业执照
     * @mbggenerated
     */
    public void setThreeInOne(String threeInOne) {
        this.threeInOne = threeInOne == null ? null : threeInOne.trim();
    }

    /**
     * 平台授权书扫描件
     *
     * @return 平台授权书扫描件
     * @mbggenerated
     */
    public String getPlatformAuth() {
        return platformAuth;
    }

    /**
     * 平台授权书扫描件
     *
     * @param platformAuth 平台授权书扫描件
     * @mbggenerated
     */
    public void setPlatformAuth(String platformAuth) {
        this.platformAuth = platformAuth == null ? null : platformAuth.trim();
    }

    /**
     * 打款金额
     *
     * @return 打款金额
     * @mbggenerated
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 打款金额
     *
     * @param amount 打款金额
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     *
     * @return 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态，0- 待审核，1- 审核通过，2- 审核不通过
     *
     * @param status 状态，0- 待审核，1- 审核通过，2- 审核不通过
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建时间
     *
     * @return 创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 申请人userId
     *
     * @return 申请人userId
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 申请人userId
     *
     * @param createrId 申请人userId
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }
}