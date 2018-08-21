package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *用户身份审核VO
 */
@ApiModel(value = "用户身份审核信息VO")
public class RealUserAuditVO {

	/**
	 * 实名记录id
	 */
	@ApiModelProperty(value = "实名记录id")
	private String id;

	/**
	 * 手持身份证照Id
	 * 
	 */
	@ApiModelProperty("手持身份证照Id")
	private String idCard;

	/**
	 * 身份证照正面
	 * 
	 */
	@ApiModelProperty("手持身份证照Id")
	private String cardImageFront;

	/**
	 * 身份证照反面
	 * 
	 */
	@ApiModelProperty("手持身份证照Id")
	private String cardImageCon;

	/**
	 * 审核状态
	 * 
	 */
	@ApiModelProperty("审核状态")
	private String status;

	/**
	 * 创建人
	 * 
	 */
	@ApiModelProperty("创建人")
	private String createrName;
	
	/**
	 * 身份证号
	 */
	@ApiModelProperty("身份证号")
	private String cardId;

	/**
	 * 创建时间
	 * 
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	

}
