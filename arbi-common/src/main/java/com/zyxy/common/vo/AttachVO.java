package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 附件
 */
@ApiModel(value="附件对象")
public class AttachVO {
    /**
     * 请求类型
     * case_mat COUNTERCLAIM_FLAG 正请求 1反请求
     */
    @ApiModelProperty("请求类型")
    private String counterclamFlag;
    /**
     * 材料类型 0附件
     * case_mat MAT_TYPE=0
     */
    @ApiModelProperty("材料类型")
    private String matType;
    /**
     * 附件名称
     * case_mat ATTACH_NAME ATTACH_CONTENT
     */
    @ApiModelProperty("附件名称")
    private String attachName;
    /**
     * 附件内容
     * case_mat ATTACH_CONTENT MAT_TYPE
     */
    @ApiModelProperty("附件内容")
    private String attachContent;
    /**
     * 文件名
     * case_mat DOC_NAME
     */
    @ApiModelProperty("文件名")
    private String docName;
    /**
     * 文件ID
     * case_mat FILE_ID
     */
    @ApiModelProperty("文件ID")
    private String fileId;
    /**
     * 文件类型
     * case_mat DOC_TYPE
     */
    @ApiModelProperty("文件类型")
    private String docType;
    /**
     * 创建人类型
     */
    @ApiModelProperty("创建人类型")
    private String createrType;
    
	public String getCounterclamFlag() {
		return counterclamFlag;
	}
	public void setCounterclamFlag(String counterclamFlag) {
		this.counterclamFlag = counterclamFlag;
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
	public String getCreaterType() {
		return createrType;
	}
	public void setCreaterType(String createrType) {
		this.createrType = createrType;
	}
}
