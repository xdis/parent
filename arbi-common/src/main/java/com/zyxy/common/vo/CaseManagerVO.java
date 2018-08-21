package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件仲裁委人员信息
 */
@ApiModel(value="案件仲裁委人员信息")
public class CaseManagerVO {
	/**
	 * 职务
	 */
	@ApiModelProperty(value="职务")
	private String duties;
	
	/**
	 * 姓名
	 */
	@ApiModelProperty(value="姓名")
	private String name;
	
	/**
	 * 案号
	 */
	private String caseNo;
	
	/**
	 * 立案时间
	 */
	private Date registerTime;

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	
}
