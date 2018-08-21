package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 仲裁委
 *
 */
@ApiModel(value ="仲裁委案件列表对象")
public class ArbitrationCaseListVO {

	/**
	 * 案件id
	 */
	@ApiModelProperty("案件id")
	private String caseId;
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	private String caseNo;
	
	/**
	 * 收案号
	 */
	@ApiModelProperty("收案号")
	private String acceptanceNo;
	
	/**
	 * 当前节点名称，又为案件状态
	 */
	@ApiModelProperty("当前节点名称，又为案件状态")
	private String nodeName;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date createTime; 
	
	/**
	 * 接案时间
	 */
	@ApiModelProperty("仲裁员接案时间")
	private Date acceptTime;
	
	/**
	 * 当前责任人姓名
	 */
	@ApiModelProperty("当前责任人姓名")
	private String name;
	
	/**
	 * 当前责任人职务
	 */
	@ApiModelProperty("当前责任人职务")
	private String duties;

	/**
	 * 秘书查看案件详情的权限，0-有，1-无
	 */
	@ApiModelProperty("秘书查看案件详情的权限，0-有，1-无")
	private String primiss;

	
	
	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getAcceptanceNo() {
		return acceptanceNo;
	}

	public void setAcceptanceNo(String acceptanceNo) {
		this.acceptanceNo = acceptanceNo;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getPrimiss() {
		return primiss;
	}

	public void setPrimiss(String primiss) {
		this.primiss = primiss;
	}
}
