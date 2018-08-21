package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class ResCasePayInfoDTO {
    
    /**
     * 缴费状态,0- 已缴费,1- 未缴费,2- 过期
     */
    @ApiModelProperty("缴费状态,0- 缴费,1- 未缴费,2- 过期")
    private Integer status;

    /**
     * 通知书号
     */
    @ApiModelProperty(value = "通知书号")
    private String pnNo;

    /**
     * 票据类型编码
     */
    @ApiModelProperty(value = "票据类型编码")
    private String rtNo;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 执收单位编码
     */
    @ApiModelProperty(value = "执收单位编码")
    private String unitNo;

    /**
     * 缴费单位/人名称
     */
    @ApiModelProperty(value = "缴费单位/人名称")
    private String payerName;

    /**
     * 缴费项目列表
     */
    private List<Item> items;

    /**
     * 号码校验码
     */
    @ApiModelProperty(value = "号码校验码")
    private String checkDigitNo;

    /**
     * 全书校验码
     */
    @ApiModelProperty(value = "全书校验码")
    private String checkDigitAll;

    /**
     * 缴费截止时间
     */
    @ApiModelProperty(value = "缴费截止时间")
    private Date dealTime;

    /**
     * 应收总金额(元)
     */
    @ApiModelProperty(value = "应收总金额(元)")
    private BigDecimal receivableAmt;

    /**
     * 缴费二维码连接
     */
    @ApiModelProperty(value = "缴费二维码连接")
    private String qrCode;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPnNo() {
        return pnNo;
    }

    public void setPnNo(String pnNo) {
        this.pnNo = pnNo;
    }

    public String getRtNo() {
        return rtNo;
    }

    public void setRtNo(String rtNo) {
        this.rtNo = rtNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCheckDigitNo() {
        return checkDigitNo;
    }

    public void setCheckDigitNo(String checkDigitNo) {
        this.checkDigitNo = checkDigitNo;
    }

    public String getCheckDigitAll() {
        return checkDigitAll;
    }

    public void setCheckDigitAll(String checkDigitAll) {
        this.checkDigitAll = checkDigitAll;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getReceivableAmt() {
        return receivableAmt;
    }

    public void setReceivableAmt(BigDecimal receivableAmt) {
        this.receivableAmt = receivableAmt;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public static class Item {

        /**
         * 缴费项目编号
         */
        @ApiModelProperty("缴费项目编号")
        private String no;

        /**
         * 缴费项目名称
         */
        @ApiModelProperty("缴费项目名称")
        private String name;

        /**
         * 单价（元）
         */
        @ApiModelProperty("单价（元）")
        private BigDecimal price;

        /**
         * 数量
         */
        @ApiModelProperty("数量")
        private int quantity;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
