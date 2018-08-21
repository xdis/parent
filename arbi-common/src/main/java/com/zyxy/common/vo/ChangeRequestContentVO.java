package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 变更请求内容信息
 *
 */
@ApiModel(value =" 变更请求内容信息")
public class ChangeRequestContentVO {
	
	 //变更仲裁请求Id
    @ApiModelProperty("变更仲裁请求Id")
    private String  changeId ;
    
    //变更请求事项
    @ApiModelProperty("变更请求事项")
    private String  changeRequest ;
    
    //变更事实与理由
    @ApiModelProperty("变更事实与理由")
    private String  factReason ;
    
    // 标的金额
	@ApiModelProperty(value = "标的金额")
	private String markAmount;

	// 应补缴
	@ApiModelProperty(value = "处理费")
	private String paymentShouldBe;
	
	//创建时间
	@ApiModelProperty("创建时间")
	private String  createTime;
    
	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getChangeRequest() {
		return changeRequest;
	}

	public void setChangeRequest(String changeRequest) {
		this.changeRequest = changeRequest;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public String getMarkAmount() {
		return markAmount;
	}

	public void setMarkAmount(String markAmount) {
		this.markAmount = markAmount;
	}

	public String getPaymentShouldBe() {
		return paymentShouldBe;
	}

	public void setPaymentShouldBe(String paymentShouldBe) {
		this.paymentShouldBe = paymentShouldBe;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

    

}
