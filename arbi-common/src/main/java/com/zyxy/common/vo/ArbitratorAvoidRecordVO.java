package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员回避记录
 */
@ApiModel("仲裁员回避记录")
public class ArbitratorAvoidRecordVO {
	
	/**
	 * 记录ID
	 */
	@ApiModelProperty("记录ID")
	private String id;
	
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty("仲裁员姓名")
	private String name;

    /**
     * 仲裁员年龄
     */
    @ApiModelProperty("仲裁员年龄")
    private String age;

    /**
     * 仲裁员职业
     */
    @ApiModelProperty("仲裁员职业")
    private String job;

    /**
     * 仲裁员专长
     */
    @ApiModelProperty("仲裁员专长")
    private String specialty;

	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	private String caseId;
	
	/**
	 * 回避状态
	 */
	@ApiModelProperty("回避状态状态 0 -待审核 1 审核通过 2 审核失败")
	private String status;
	
	/**
	 * 回避申请时间
	 */
	@ApiModelProperty("回避申请时间")
	private String createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ArbitratorAvoidRecordVO [id=" + id + ", name=" + name
				+ ", age=" + age + ", job=" + job + ", specialty=" + specialty
				+ ", caseId=" + caseId + ", status=" + status + ", createTime="
				+ createTime + "]";
	}

}
