package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@ApiModel("签章信息")
public class SignetDTO {
    /**
     * 签章PDF文件ID
     */
    @ApiModelProperty("签章PDF文件ID")
    @NotBlank
    private String docFileId;
    /**
     * 附件文件ID集合
     */
    @ApiModelProperty("附件文件ID集合")
    private List<String> metFileIdList;
    /**
     * 合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）
     */
    @ApiModelProperty("合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）")
    private String contractName;
    /**
     * 签章人信息集合
     */
    @ApiModelProperty("签章人信息集合")
    private List<SignatoryDTO> signatoryDTOList;
    /**
     * 签章等级 0: 标准图形章,1: 公章或手写
     */
    @ApiModelProperty("签章等级 0: 标准图形章,1: 公章或手写")
    private Integer signLevelCode;
    /**
     * 签章类型 0：手动签章,1自动签章
     */
    @ApiModelProperty("签章类型 0：手动签章,1自动签章")
    private Integer dealTypeCode;

    public String getDocFileId() {
        return docFileId;
    }

    public void setDocFileId(String docFileId) {
        this.docFileId = docFileId;
    }

    public List<String> getMetFileIdList() {
        return metFileIdList;
    }

    public void setMetFileIdList(List<String> metFileIdList) {
        this.metFileIdList = metFileIdList;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<SignatoryDTO> getSignatoryDTOList() {
        return signatoryDTOList;
    }

    public void setSignatoryDTOList(List<SignatoryDTO> signatoryDTOList) {
        this.signatoryDTOList = signatoryDTOList;
    }

    public Integer getSignLevelCode() {
        return signLevelCode;
    }

    public void setSignLevelCode(Integer signLevelCode) {
        this.signLevelCode = signLevelCode;
    }

    public Integer getDealTypeCode() {
        return dealTypeCode;
    }

    public void setDealTypeCode(Integer dealTypeCode) {
        this.dealTypeCode = dealTypeCode;
    }
}
