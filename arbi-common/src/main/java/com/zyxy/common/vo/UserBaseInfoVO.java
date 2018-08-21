package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人中心基本信息
 */
@ApiModel("个人中心基本信息")
public class UserBaseInfoVO {
	
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;
	
	/**
	 * 性别
	 */
	@ApiModelProperty("性别")
	private String sex;
	
	/**
	 * 身份证
	 */
	@ApiModelProperty("身份证")
	private String cardId;
	
	/**
	 * 银行
	 */
	@ApiModelProperty("银行")
	private String bankCardId;
	
	/**
	 * 银行预留手机号码
	 */
	@ApiModelProperty("银行预留手机号码")
	private String phone;
	
	/**
	 * 职业
	 */
	@ApiModelProperty("职业")
	private String vocation;
	
	/**
	 * 地址
	 */
	@ApiModelProperty("地址")
	private String address;
	
	/**
	 * 身份证正面
	 */
	@ApiModelProperty("身份证正面")
	private String cardPicture;
	
	/**
	 * 身份证反面
	 */
	@ApiModelProperty("身份证反面")
	private String backCardPicture;
	
	/**
	 * 当事人类型
	 */
	@ApiModelProperty("当事人类型")
	private String type;
	
	/**
	 * 统一社会编码
	 */
	@ApiModelProperty("统一社会编码")
	private String unifiedSocialCode;
	
	/**
	 * 营业执照
	 */
	@ApiModelProperty("营业执照")
	private String busiImgId;
	
	/**
	 * 邮箱
	 */
	@ApiModelProperty("邮箱")
	private String email;
	
	/**
	 * 法人姓名
	 */
	@ApiModelProperty("法人姓名")
	private String certName;
	
	/**
	 * 授权书
	 */
	@ApiModelProperty("授权书")
	private String authorDoc;
	
	/**
	 * 企业类型
	 */
	@ApiModelProperty("企业类型")
	private String enterpriseType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardPicture() {
		return cardPicture;
	}

	public void setCardPicture(String cardPicture) {
		this.cardPicture = cardPicture;
	}

	public String getBackCardPicture() {
		return backCardPicture;
	}

	public void setBackCardPicture(String backCardPicture) {
		this.backCardPicture = backCardPicture;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnifiedSocialCode() {
		return unifiedSocialCode;
	}

	public void setUnifiedSocialCode(String unifiedSocialCode) {
		this.unifiedSocialCode = unifiedSocialCode;
	}

	public String getBusiImgId() {
		return busiImgId;
	}

	public void setBusiImgId(String busiImgId) {
		this.busiImgId = busiImgId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getAuthorDoc() {
		return authorDoc;
	}

	public void setAuthorDoc(String authorDoc) {
		this.authorDoc = authorDoc;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	@Override
	public String toString() {
		return "UserBaseInfoVO [name=" + name + ", sex=" + sex + ", cardId="
				+ cardId + ", bankCardId=" + bankCardId + ", phone=" + phone
				+ ", vocation=" + vocation + ", address=" + address
				+ ", cardPicture=" + cardPicture + ", backCardPicture="
				+ backCardPicture + ", type=" + type + ", unifiedSocialCode="
				+ unifiedSocialCode + ", busiImgId=" + busiImgId + ", email="
				+ email + ", certName=" + certName + ", authorDoc=" + authorDoc
				+ ", enterpriseType=" + enterpriseType + "]";
	}

}
