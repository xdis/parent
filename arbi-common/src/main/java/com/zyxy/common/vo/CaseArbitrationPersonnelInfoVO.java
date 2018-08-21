package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 案件相关仲裁委人员职位姓名vo
 */
@ApiModel(value="案件相关仲裁委人员职位姓名vo")
public class CaseArbitrationPersonnelInfoVO {
	/**
	 * 案号
	 */
	@ApiModelProperty(value="案号")
	private String caseNo;
	
	/**
	 * 立案时间
	 */
	@ApiModelProperty(value="立案时间")
	private Date registerTime;
	
	/**
	 * 立案秘书姓名
	 */
	@ApiModelProperty(value="立案秘书姓名")
	private String caseSecretaryName;
	
	/**
	 * 立案主任姓名
	 */
	@ApiModelProperty(value="立案部长姓名")
	private String caseMinisterName;
	
	/**
	 * 仲裁秘书姓名
	 */
	@ApiModelProperty(value="仲裁秘书姓名")
	private String arbiSecretaryName;

	/**
	 * 仲裁部长姓名
	 */
	@ApiModelProperty(value="仲裁部长")
	private String arbiMinisterName;
	
	/**
	 * 副主任姓名
	 */
	@ApiModelProperty(value="副主任姓名")
	private String deputyDirectorName;
	
	/**
	 * 主任姓名
	 */
	@ApiModelProperty(value="主任姓名")
	private String directorName;

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

	public String getCaseSecretaryName() {
		return caseSecretaryName;
	}

	public void setCaseSecretaryName(String caseSecretaryName) {
		this.caseSecretaryName = caseSecretaryName;
	}

	public String getCaseMinisterName() {
		return caseMinisterName;
	}

	public void setCaseMinisterName(String caseMinisterName) {
		this.caseMinisterName = caseMinisterName;
	}

	public String getArbiSecretaryName() {
		return arbiSecretaryName;
	}

	public void setArbiSecretaryName(String arbiSecretaryName) {
		this.arbiSecretaryName = arbiSecretaryName;
	}

	public String getArbiMinisterName() {
		return arbiMinisterName;
	}

	public void setArbiMinisterName(String arbiMinisterName) {
		this.arbiMinisterName = arbiMinisterName;
	}

	public String getDeputyDirectorName() {
		return deputyDirectorName;
	}

	public void setDeputyDirectorName(String deputyDirectorName) {
		this.deputyDirectorName = deputyDirectorName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

}
