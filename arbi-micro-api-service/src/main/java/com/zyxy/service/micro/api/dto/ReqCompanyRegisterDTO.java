package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.util.ArrayUtil;

/**
 * 企业（法人）注册信息
 * @author sonta
 *
 */
public class ReqCompanyRegisterDTO extends ReqRegisterBaseInfoDTO{
    
    @ApiModelProperty("公司名")
    @NotNull(message="不能为空")
    private String companyName;
    
    @ApiModelProperty(value = "单位类型，0- 企业，1- 事业单位")
    @NotNull(message="不能为空")
    @Pattern(regexp="[01]", message="格式非法")
    private String companyType;
    
    @ApiModelProperty("统一社会信用代码")
    @NotNull(message="不能为空")
    private String socialCreditCode;
    
    @ApiModelProperty("法人姓名")
    @NotNull(message="不能为空")
    private String legalName;
    
    
    @ApiModelProperty("法人身份证正面照（base64）")
    @NotNull(message="不能为空")
    private String idcardBase64ImgFront;
    
    @ApiModelProperty("法人身份证背面照（base64）")
    @NotNull(message="不能为空")
    private String idcardBase64ImgBack;
    
    @ApiModelProperty("彩色三证合一营业执照（base64）")
    @NotNull(message="不能为空")
    private String busiLicenseBase64Img;
    
    @ApiModelProperty("电子签章授权扫描照（base64）")
    @NotNull(message="不能为空")
    private String esignAuthBase64Img;
    
    @ApiModelProperty("住址")
    private String address;
    
    @ApiModelProperty("法人职务")
    private String legalDuty;
    
    public String getIdcardBase64ImgFront() {
        return idcardBase64ImgFront;
    }

    public void setIdcardBase64ImgFront(String idcardBase64ImgFront) {
        this.idcardBase64ImgFront = idcardBase64ImgFront;
    }

    public String getIdcardBase64ImgBack() {
        return idcardBase64ImgBack;
    }

    public void setIdcardBase64ImgBack(String idcardBase64ImgBack) {
        this.idcardBase64ImgBack = idcardBase64ImgBack;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getBusiLicenseBase64Img() {
        return busiLicenseBase64Img;
    }

    public void setBusiLicenseBase64Img(String busiLicenseBase64Img) {
        this.busiLicenseBase64Img = busiLicenseBase64Img;
    }

    @Override
    public String[] getSecretKeys() {
        String[] secretKeys = new String[]{"idcardBase64ImgFront", "idcardBase64ImgBack", "companyName", "socialCreditCode", "address"};
        return ArrayUtil.concatAll(secretKeys, super.getSecretKeys());
    }

    /**
     * @return the legalName
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * @param legalName the legalName to set
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * @return the esignAuthBase64Img
     */
    public String getEsignAuthBase64Img() {
        return esignAuthBase64Img;
    }

    /**
     * @param esignAuthBase64Img the esignAuthBase64Img to set
     */
    public void setEsignAuthBase64Img(String esignAuthBase64Img) {
        this.esignAuthBase64Img = esignAuthBase64Img;
    }

    /**
     * @return the companyType
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType the companyType to set
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * @return the legalDuty
     */
    public String getLegalDuty() {
        return legalDuty;
    }

    /**
     * @param legalDuty the legalDuty to set
     */
    public void setLegalDuty(String legalDuty) {
        this.legalDuty = legalDuty;
    }
}
