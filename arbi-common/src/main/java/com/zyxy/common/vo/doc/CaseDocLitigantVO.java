package com.zyxy.common.vo.doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件文书当事人VO
 */
@ApiModel(value = "案件文书当事人VO")
public class CaseDocLitigantVO {

    /**
     * 类型: 0-个人,1-企业
     */
    @ApiModelProperty("类型: 0-个人,1-企业")
    private String type;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 民族
     */
    @ApiModelProperty("民族")
    private String ethnic;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private String birthday;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String cardId;

    /**
     * 住所
     */
    @ApiModelProperty("住所")
    private String address;

    /**
     * 法定代表人姓名
     */
    @ApiModelProperty("法定代表人姓名")
    private String certName;

    /**
     * 法定代表人职务
     */
    @ApiModelProperty("法定代表人职务")
    private String certDuties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertDuties() {
        return certDuties;
    }

    public void setCertDuties(String certDuties) {
        this.certDuties = certDuties;
    }

    @Override
    public String toString() {
        return "CaseDocLitigantVO{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                ", certName='" + certName + '\'' +
                ", certDuties='" + certDuties + '\'' +
                '}';
    }
}
