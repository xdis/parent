package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("签章人信息")
public class SignatoryDTO {
    /**
     * 签章人姓名或公司名称
     */
    @ApiModelProperty("签章人姓名或公司名称")
    private String fullName;
    /**
     * 证件类型 1：身份证，11：统一社会信用代码（11这个值在易保全的接口中是营业执照，这是因为易保全那边信用代码和营业执照都是用同一种类型）
     */
    @ApiModelProperty("证件类型 1：身份证，11：统一社会信用代码")
    private Integer identityTypeCode;
    /**
     * 证件号码
     */
    @ApiModelProperty("证件号码")
    private String identityCard;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 邮箱（如果证件类型是机构那么邮箱是必须的，因为易保全的机构上传信息的时候只接收邮箱，如果有签章验证码，也只能发到邮箱上）
     */
    @ApiModelProperty("如果证件类型是机构那么邮箱是必须的")
    private String email;

    /**
     * 0:验证短信（邮箱）验证码，1:不验证短信（邮箱）验证码
     */
    @ApiModelProperty("0:验证短信（邮箱）验证码，1:不验证短信（邮箱）验证码")
    private Integer noNeedVerify;

    /**
     * 签章在文件中页面上的位置坐标（文件页左上角(0.0,0.0)为基准，按百分比进行设置
     */
    @ApiModelProperty("签章在文件中页面上的位置坐标（文件页左上角(0.0,0.0)为基准，按百分比进行设置")
    private List<SignPageDTO> chapteJson;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getIdentityTypeCode() {
        return identityTypeCode;
    }

    public void setIdentityTypeCode(Integer identityTypeCode) {
        this.identityTypeCode = identityTypeCode;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNoNeedVerify() {
        return noNeedVerify;
    }

    public void setNoNeedVerify(Integer noNeedVerify) {
        this.noNeedVerify = noNeedVerify;
    }

    public List<SignPageDTO> getChapteJson() {
        return chapteJson;
    }

    public void setChapteJson(List<SignPageDTO> chapteJson) {
        this.chapteJson = chapteJson;
    }

    @ApiModel("签章文件页信息")
    public static class SignPageDTO {
        @ApiModelProperty("页数从0开始计算，设置为负数就是从最后一页开始算，-1为最后一页")
        private Integer page;
        @ApiModelProperty("坐标列表，如果设置多个，就会在当前页上有多个签章")
        private List<SignChapteDTO> chaptes;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<SignChapteDTO> getChaptes() {
            return chaptes;
        }

        public void setChaptes(List<SignChapteDTO> chaptes) {
            this.chaptes = chaptes;
        }
    }

    @ApiModel("签章位置信息")
    public static class SignChapteDTO {
        @ApiModelProperty("横坐标比例，设置为 0-1 之间")
        private Double offsetX;
        @ApiModelProperty("纵坐标比例，设置为 0-1 之间")
        private Double offsetY;

        public Double getOffsetX() {
            return offsetX;
        }

        public void setOffsetX(Double offsetX) {
            this.offsetX = offsetX;
        }

        public Double getOffsetY() {
            return offsetY;
        }

        public void setOffsetY(Double offsetY) {
            this.offsetY = offsetY;
        }
    }
}
