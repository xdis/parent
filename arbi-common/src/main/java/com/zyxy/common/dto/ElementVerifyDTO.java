package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 实名验证表单
 */
@ApiModel(value ="实名验证表单")
public class ElementVerifyDTO extends BaseDTO{
	/**
     * 姓名
     */
	@ApiModelProperty("姓名")
	@NotNull
    private String name;

	/**
	 * 性别,0-男,1-女
	 */
	@ApiModelProperty("性别,0-男,1-女")
	@NotNull
	private String sex;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @NotNull
    @Email
    private String email;

    /**
     * 民族
     */
    @ApiModelProperty("民族")
    @NotNull
    private String ethnic;

	/**
	 * 身份证号
	 */
	@ApiModelProperty("身份证号")
	@NotNull
	@Pattern(regexp = RegexpConstant.ID_CORD_REGEX, message = "身份证号格式错误")
	private String cardId;

	/**
	 * 银行卡号
	 */
	@ApiModelProperty("银行卡号")
	@NotNull
	@Pattern(regexp = RegexpConstant.BANK_CARD_REGEX, message = "银行卡号格式错误")
	private String bankCardId;

	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	@NotNull
	@Pattern(regexp = RegexpConstant.PHONE_REGEX, message = "手机号格式错误")
	private String phone;

	/**
	 * 手机验证码
	 */
	@ApiModelProperty("手机验证码")
	@NotNull
	private String phoneCode;

	/**
	 * 住址
	 */
	@ApiModelProperty("住址")
	@NotNull
	private String address;

	/**
	 * 身份证正面
	 */
	@ApiModelProperty("身份证正面")
	@NotNull
	private String cardImageFront;

	/**
	 * 身份证背面
	 */
	@ApiModelProperty("身份证背面")
	@NotNull
	private String cardImageCon;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardImageFront() {
		return cardImageFront;
	}

	public void setCardImageFront(String cardImageFront) {
		this.cardImageFront = cardImageFront;
	}

	public String getCardImageCon() {
		return cardImageCon;
	}

	public void setCardImageCon(String cardImageCon) {
		this.cardImageCon = cardImageCon;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

}
