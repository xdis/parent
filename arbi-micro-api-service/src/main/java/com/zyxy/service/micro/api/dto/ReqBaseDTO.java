package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class ReqBaseDTO {
    
    /**
     * 用户/机构ID（最长不超过32位）
     */
    @ApiModelProperty("用户/机构ID（最长不超过32位）")
    private String orgNo;
    
    /**
     * 客户备注（最长不超过50位）
     */
    @ApiModelProperty("客户备注（最长不超过50位）")
    @Size(max=50, message="不能超过50位")
    private String remark;
    
    /**
     * 签名
     */
    @ApiModelProperty("签名")
    @NotNull(message="不能为空")
    private String sign;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
    /**
     * 定义需要加解密的字段
     * @return
     */
    public abstract String[] getSecretKeys();
    
    /**
     * 定义无需参与签名的字段
     * @return
     */
    public String[] noSignKeys() {
        return null;
    }
    
}
