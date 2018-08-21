package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   当事人基本信息表
 *
 * litigant_info
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="LitigantInfo")
public class LitigantInfo implements Serializable {
    /**
     * 当事人ID
     * litigant_info.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当事人ID")
    private String id;

    /**
     * 用户ID
     * litigant_info.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 姓名
     * litigant_info.NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 职业
     * litigant_info.VOCATION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职业")
    private String vocation;

    /**
     * 身份证号
     * litigant_info.CARD_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证号")
    private String cardId;

    /**
     * 地址
     * litigant_info.ADDRESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 统一社会征用码
     * litigant_info.UNIFIED_SOCIAL_CODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统一社会征用码")
    private String unifiedSocialCode;

    /**
     * 营业执照照片ID
     * litigant_info.BUSI_IMG_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "营业执照照片ID")
    private String busiImgId;

    /**
     * 法人代表任职证明照片地址
     * litigant_info.CERT_OFFICE_IMG_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人代表任职证明照片地址")
    private String certOfficeImgId;

    /**
     * 类型,0-个人,1-企业
     * litigant_info.TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型,0-个人,1-企业")
    private String type;

    /**
     * 创建人
     * litigant_info.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createrId;

    /**
     * 创建时间
     * litigant_info.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改人
     * litigant_info.UPDATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改人")
    private String updateId;

    /**
     * 修改时间
     * litigant_info.UPDATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 生日
     * litigant_info.BIRTHDAY
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "生日")
    private String birthday;

    /**
     * 法人职务
     * litigant_info.CERT_DUTIES
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人职务")
    private String certDuties;

    /**
     * 法人姓名
     * litigant_info.CERT_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人姓名")
    private String certName;

    /**
     * 民族
     * litigant_info.ETHNIC
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "民族")
    private String ethnic;

    /**
     * 身份证正面
     * litigant_info.CARD_IMAGE_FRONT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证正面")
    private String cardImageFront;

    /**
     * 身份证反面
     * litigant_info.CARD_IMAGE_CON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证反面")
    private String cardImageCon;

    /**
     * 四要素验证状态0- 通过,1- 未通过
     * litigant_info.ELEMENT_VERIFY_STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "四要素验证状态0- 通过,1- 未通过")
    private String elementVerifyStatus;

    /**
     * 银行卡预留手机号
     * litigant_info.BANK_PHONE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "银行卡预留手机号")
    private String bankPhone;

    /**
     * 银行卡号
     * litigant_info.BANK_CARD
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "银行卡号")
    private String bankCard;

    /**
     * 平台授权书扫描件
     * litigant_info.PLATFORM_AUTH
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台授权书扫描件")
    private String platformAuth;

    /**
     * 法人单位类型，0- 企业，1- 事业单位
     * litigant_info.ENTERPRISE_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "法人单位类型，0- 企业，1- 事业单位")
    private String enterpriseType;

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 当事人ID
     *
     * @return 当事人ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 当事人ID
     *
     * @param id 当事人ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户ID
     *
     * @return 用户ID
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     *
     * @param userId 用户ID
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 姓名
     *
     * @return 姓名
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     *
     * @param name 姓名
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 职业
     *
     * @return 职业
     * @mbggenerated
     */
    public String getVocation() {
        return vocation;
    }

    /**
     * 职业
     *
     * @param vocation 职业
     * @mbggenerated
     */
    public void setVocation(String vocation) {
        this.vocation = vocation == null ? null : vocation.trim();
    }

    /**
     * 身份证号
     *
     * @return 身份证号
     * @mbggenerated
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 身份证号
     *
     * @param cardId 身份证号
     * @mbggenerated
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    /**
     * 地址
     *
     * @return 地址
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     *
     * @param address 地址
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 统一社会征用码
     *
     * @return 统一社会征用码
     * @mbggenerated
     */
    public String getUnifiedSocialCode() {
        return unifiedSocialCode;
    }

    /**
     * 统一社会征用码
     *
     * @param unifiedSocialCode 统一社会征用码
     * @mbggenerated
     */
    public void setUnifiedSocialCode(String unifiedSocialCode) {
        this.unifiedSocialCode = unifiedSocialCode == null ? null : unifiedSocialCode.trim();
    }

    /**
     * 营业执照照片ID
     *
     * @return 营业执照照片ID
     * @mbggenerated
     */
    public String getBusiImgId() {
        return busiImgId;
    }

    /**
     * 营业执照照片ID
     *
     * @param busiImgId 营业执照照片ID
     * @mbggenerated
     */
    public void setBusiImgId(String busiImgId) {
        this.busiImgId = busiImgId == null ? null : busiImgId.trim();
    }

    /**
     * 法人代表任职证明照片地址
     *
     * @return 法人代表任职证明照片地址
     * @mbggenerated
     */
    public String getCertOfficeImgId() {
        return certOfficeImgId;
    }

    /**
     * 法人代表任职证明照片地址
     *
     * @param certOfficeImgId 法人代表任职证明照片地址
     * @mbggenerated
     */
    public void setCertOfficeImgId(String certOfficeImgId) {
        this.certOfficeImgId = certOfficeImgId == null ? null : certOfficeImgId.trim();
    }

    /**
     * 类型,0-个人,1-企业
     *
     * @return 类型, 0-个人,1-企业
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 类型,0-个人,1-企业
     *
     * @param type 类型,0-个人,1-企业
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 创建人
     *
     * @return 创建人
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人
     *
     * @param createrId 创建人
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
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
     * 修改人
     *
     * @return 修改人
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 修改人
     *
     * @param updateId 修改人
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 修改时间
     *
     * @return 修改时间
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @param updateTime 修改时间
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 生日
     *
     * @return 生日
     * @mbggenerated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @param birthday 生日
     * @mbggenerated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
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
     * 民族
     *
     * @return 民族
     * @mbggenerated
     */
    public String getEthnic() {
        return ethnic;
    }

    /**
     * 民族
     *
     * @param ethnic 民族
     * @mbggenerated
     */
    public void setEthnic(String ethnic) {
        this.ethnic = ethnic == null ? null : ethnic.trim();
    }

    /**
     * 身份证正面
     *
     * @return 身份证正面
     * @mbggenerated
     */
    public String getCardImageFront() {
        return cardImageFront;
    }

    /**
     * 身份证正面
     *
     * @param cardImageFront 身份证正面
     * @mbggenerated
     */
    public void setCardImageFront(String cardImageFront) {
        this.cardImageFront = cardImageFront == null ? null : cardImageFront.trim();
    }

    /**
     * 身份证反面
     *
     * @return 身份证反面
     * @mbggenerated
     */
    public String getCardImageCon() {
        return cardImageCon;
    }

    /**
     * 身份证反面
     *
     * @param cardImageCon 身份证反面
     * @mbggenerated
     */
    public void setCardImageCon(String cardImageCon) {
        this.cardImageCon = cardImageCon == null ? null : cardImageCon.trim();
    }

    /**
     * 四要素验证状态0- 通过,1- 未通过
     *
     * @return 四要素验证状态0- 通过,1- 未通过
     * @mbggenerated
     */
    public String getElementVerifyStatus() {
        return elementVerifyStatus;
    }

    /**
     * 四要素验证状态0- 通过,1- 未通过
     *
     * @param elementVerifyStatus 四要素验证状态0- 通过,1- 未通过
     * @mbggenerated
     */
    public void setElementVerifyStatus(String elementVerifyStatus) {
        this.elementVerifyStatus = elementVerifyStatus == null ? null : elementVerifyStatus.trim();
    }

    /**
     * 银行卡预留手机号
     *
     * @return 银行卡预留手机号
     * @mbggenerated
     */
    public String getBankPhone() {
        return bankPhone;
    }

    /**
     * 银行卡预留手机号
     *
     * @param bankPhone 银行卡预留手机号
     * @mbggenerated
     */
    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone == null ? null : bankPhone.trim();
    }

    /**
     * 银行卡号
     *
     * @return 银行卡号
     * @mbggenerated
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 银行卡号
     *
     * @param bankCard 银行卡号
     * @mbggenerated
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
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
     * 法人单位类型，0- 企业，1- 事业单位
     *
     * @return 法人单位类型，0- 企业，1- 事业单位
     * @mbggenerated
     */
    public String getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * 法人单位类型，0- 企业，1- 事业单位
     *
     * @param enterpriseType 法人单位类型，0- 企业，1- 事业单位
     * @mbggenerated
     */
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }
}