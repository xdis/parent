package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 仲裁员变更信息申请DTO
 */
@ApiModel(value = "仲裁员变更信息申请DTO")
public class ArbitratorChangeProfileDTO extends BaseDTO {

    /**
     * 职业
     */
    @ApiModelProperty("职业")
    @NotNull(message = "职业不能为空")
    @Length(max = 32, message = "职业不能超过32字")
    private String job;

    /**
     * 特长
     */
    @ApiModelProperty("特长")
    @NotNull(message = "特长不能为空")
    @Length(max = 32, message = "特长不能超过32字")
    private String speciality;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    @NotNull(message = "地址不能为空")
    @Length(max = 32, message = "地址不能超过32字")
    private String address;

    /**
     * 地址
     */
    @ApiModelProperty("身份证")
    @NotNull(message = "身份证不能为空")
    @Length(max = 32, message = "身份证不能超过32字")
    private String idCard;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
