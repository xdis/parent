package com.zyxy.common.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 双方仲裁申请资料列表
 */
@ApiModel("证据材料列表对象")
public class ApplicantDataVO {

	/**
	 * 编号ID
	 */
	@ApiModelProperty("编号")
	private String id;

	/**
	 * 身份类型,0-申请人，1-被申请人
	 */
	@ApiModelProperty("身份类型,0-申请人，1-被申请人")
	private String createrType;

	/**
	 * 请求标志
	 */
	@ApiModelProperty("请求标志 0-正请求1-反请求")
	private String counterclaimFlag;

	/**
	 * 材料类型
	 */
	@ApiModelProperty("文件名称0附件1请求证据2答辩证据3委托代理人资料")
	private String matType;

	/**
	 * 附件名称
	 *
	 */
	@ApiModelProperty("附件名称")
	private String attachName;

	/**
	 * 附件内容
	 */
	@ApiModelProperty("附件名称")
	private String attachContent;

	/**
	 * 文件名
	 *
	 */
	@ApiModelProperty("文件名称")
	private String docName;

	/**
	 * 文件ID
	 */
	@ApiModelProperty("文件ID")
	private String fileId;

	/**
	 * 文件类型
	 */
	@ApiModelProperty("文件类型")
	private String docType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreaterType() {
		return createrType;
	}

	public void setCreaterType(String createrType) {
		this.createrType = createrType;
	}

	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}

	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}

	public String getMatType() {
		return matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachContent() {
		return attachContent;
	}

	public void setAttachContent(String attachContent) {
		this.attachContent = attachContent;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

}
