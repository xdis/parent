package com.zyxy.service.micro.api.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件下载
 * @author sonta
 *
 */
public class ReqFileDownloadDTO extends ReqBaseDTO{
	
	@ApiModelProperty("文件ID")
	@NotNull
	private String fileId;

	@Override
	public String[] getSecretKeys() {
		return null;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
