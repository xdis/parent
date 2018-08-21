package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 案件裁决补正
 *
 */
@ApiModel(value ="案件裁决补正列表对象")
public class AdjudicationAmendmentVO {
	 /**
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    private String applicantName;
   
    /**
     * 被申请人
     */
    @ApiModelProperty("被申请人")
    private String beApplicantName;

	/**
	 * 申请人类型,0- 申请人,1- 被申请人
	 */
	@ApiModelProperty("申请人类型,0- 申请人,1- 被申请人")
    private String type;
   
    
	/**
	 *  审核状态：
	 *  0-待审核，1-审核通过，2-审核失败
	 */
	@ApiModelProperty("审核状态：0-待审核，1-审核通过，2-审核失败")
	private String stauts;
	/**
	 * 当事人补正内容
	 */
	@ApiModelProperty("当事人补正内容")
	private String content;
	/**
	 * 仲裁员补正内容
	 */
	@ApiModelProperty("仲裁员补正内容")	
	private String arbitratorContent;
	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建时间")	
	private Date createTime;
	
	
	

	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getBeApplicantName() {
		return beApplicantName;
	}
	public void setBeApplicantName(String beApplicantName) {
		this.beApplicantName = beApplicantName;
	}
	
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getArbitratorContent() {
		return arbitratorContent;
	}
	public void setArbitratorContent(String arbitratorContent) {
		this.arbitratorContent = arbitratorContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
