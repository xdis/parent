package com.zyxy.common.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 附件DTO
 */
public class CaseAttachmentDTO {

	@ApiParam(hidden=true)
	private String id;
	
    @ApiModelProperty("附件名称")
    private String attachName;

    @ApiModelProperty("附件内容")
    private String attachContent;

    @ApiModelProperty("附件文件ID")
    private String fileId;

    @ApiParam(hidden = true)
    private String docType;

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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
    
    
}
