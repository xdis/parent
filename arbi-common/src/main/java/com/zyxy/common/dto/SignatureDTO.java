package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("签名信息")
public class SignatureDTO {
    /**
     * 签名文件ID
     */
    @ApiModelProperty("签名文件ID")
    private String fileId;
    /**
     * 签名用户信息
     */
    @ApiModelProperty("签名用户信息")
    private SignatoryDTO signatoryDTO;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String preservationTitle;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String sourceRegistryId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public SignatoryDTO getSignatoryDTO() {
        return signatoryDTO;
    }

    public void setSignatoryDTO(SignatoryDTO signatoryDTO) {
        this.signatoryDTO = signatoryDTO;
    }

    public String getPreservationTitle() {
        return preservationTitle;
    }

    public void setPreservationTitle(String preservationTitle) {
        this.preservationTitle = preservationTitle;
    }

    public String getSourceRegistryId() {
        return sourceRegistryId;
    }

    public void setSourceRegistryId(String sourceRegistryId) {
        this.sourceRegistryId = sourceRegistryId;
    }
}
