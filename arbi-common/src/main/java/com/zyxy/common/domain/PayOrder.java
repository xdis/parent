package com.zyxy.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   支付缴费记录表
 *
 * pay_order
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="PayOrder")
public class PayOrder implements Serializable {

    /**
     * ID pay_order.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 应收总金额（元） pay_order.RECEIVABLE_AMT
     * @mbggenerated
     */
    @ApiModelProperty(value = "应收总金额（元）")
    private BigDecimal receivableAmt;
    /**
     * 客户端执收单位编码 pay_order.UNIT_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端执收单位编码")
    private String unitNo;
    /**
     * 客户端执收单位收费系统产生的通知书号码 pay_order.PN_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端执收单位收费系统产生的通知书号码")
    private String pnNo;
    /**
     * 缴费单位/人名称 pay_order.PAYER_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "缴费单位/人名称")
    private String payerName;
    /**
     * 备注 pay_order.REMARK
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 区域编码 pay_order.REGION_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域编码")
    private String regionCode;
    /**
     * 区域邮政编码 pay_order.REGION_ZIP_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域邮政编码")
    private String regionZipCode;
    /**
     * 号码校验码 pay_order.CHECK_DIGIT_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "号码校验码")
    private String checkDigitNo;
    /**
     * 全书校验码 pay_order.CHECK_DIGIT_ALL
     * @mbggenerated
     */
    @ApiModelProperty(value = "全书校验码")
    private String checkDigitAll;
    /**
     * 收费项目数 pay_order.CHARGE_ITEM_COUNT
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项目数")
    private Integer chargeItemCount;
    /**
     * 渠道追踪单号 pay_order.CHANNEL_VOUCHER_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道追踪单号")
    private String channelVoucherNo;
    /**
     * 渠道返回结果信息 pay_order.CHANNEL_MSG
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道返回结果信息")
    private String channelMsg;
    /**
     * 实际支付时间 pay_order.PAYED_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际支付时间")
    private Date payedTime;
    /**
     * 实收金额（元） pay_order.RECEIVED_AMT
     * @mbggenerated
     */
    @ApiModelProperty(value = "实收金额（元）")
    private BigDecimal receivedAmt;
    /**
     * 票据类型编码 pay_order.RT_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "票据类型编码")
    private String rtNo;
    /**
     * 票据号码 pay_order.RECEIPT_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "票据号码")
    private String receiptNo;
    /**
     * 代收银行名称 pay_order.BANK_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "代收银行名称")
    private String bankName;
    /**
     * 用户ID  pay_order.USER_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID ")
    private String userId;
    /**
     * 业务ID（冗余） pay_order.BUZZ_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务ID（冗余）")
    private String buzzId;
    /**
     * 订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功 pay_order.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功")
    private Integer status;
    /**
     * 取消订单时间 pay_order.CANCEL_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "取消订单时间")
    private Date cancelTime;
    /**
     * 创建时间 pay_order.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 pay_order.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..] pay_order.ITEMS
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..]")
    private String items;
    /**
     * pay_order
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * @return  ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id  ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 应收总金额（元）
     * @return  应收总金额（元）
     * @mbggenerated
     */
    public BigDecimal getReceivableAmt() {
        return receivableAmt;
    }

    /**
     * 应收总金额（元）
     * @param receivableAmt  应收总金额（元）
     * @mbggenerated
     */
    public void setReceivableAmt(BigDecimal receivableAmt) {
        this.receivableAmt = receivableAmt;
    }

    /**
     * 客户端执收单位编码
     * @return  客户端执收单位编码
     * @mbggenerated
     */
    public String getUnitNo() {
        return unitNo;
    }

    /**
     * 客户端执收单位编码
     * @param unitNo  客户端执收单位编码
     * @mbggenerated
     */
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    /**
     * 客户端执收单位收费系统产生的通知书号码
     * @return  客户端执收单位收费系统产生的通知书号码
     * @mbggenerated
     */
    public String getPnNo() {
        return pnNo;
    }

    /**
     * 客户端执收单位收费系统产生的通知书号码
     * @param pnNo  客户端执收单位收费系统产生的通知书号码
     * @mbggenerated
     */
    public void setPnNo(String pnNo) {
        this.pnNo = pnNo == null ? null : pnNo.trim();
    }

    /**
     * 缴费单位/人名称
     * @return  缴费单位/人名称
     * @mbggenerated
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * 缴费单位/人名称
     * @param payerName  缴费单位/人名称
     * @mbggenerated
     */
    public void setPayerName(String payerName) {
        this.payerName = payerName == null ? null : payerName.trim();
    }

    /**
     * 备注
     * @return  备注
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark  备注
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 区域编码
     * @return  区域编码
     * @mbggenerated
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 区域编码
     * @param regionCode  区域编码
     * @mbggenerated
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    /**
     * 区域邮政编码
     * @return  区域邮政编码
     * @mbggenerated
     */
    public String getRegionZipCode() {
        return regionZipCode;
    }

    /**
     * 区域邮政编码
     * @param regionZipCode  区域邮政编码
     * @mbggenerated
     */
    public void setRegionZipCode(String regionZipCode) {
        this.regionZipCode = regionZipCode == null ? null : regionZipCode
                .trim();
    }

    /**
     * 号码校验码
     * @return  号码校验码
     * @mbggenerated
     */
    public String getCheckDigitNo() {
        return checkDigitNo;
    }

    /**
     * 号码校验码
     * @param checkDigitNo  号码校验码
     * @mbggenerated
     */
    public void setCheckDigitNo(String checkDigitNo) {
        this.checkDigitNo = checkDigitNo == null ? null : checkDigitNo.trim();
    }

    /**
     * 全书校验码
     * @return  全书校验码
     * @mbggenerated
     */
    public String getCheckDigitAll() {
        return checkDigitAll;
    }

    /**
     * 全书校验码
     * @param checkDigitAll  全书校验码
     * @mbggenerated
     */
    public void setCheckDigitAll(String checkDigitAll) {
        this.checkDigitAll = checkDigitAll == null ? null : checkDigitAll
                .trim();
    }

    /**
     * 收费项目数
     * @return  收费项目数
     * @mbggenerated
     */
    public Integer getChargeItemCount() {
        return chargeItemCount;
    }

    /**
     * 收费项目数
     * @param chargeItemCount  收费项目数
     * @mbggenerated
     */
    public void setChargeItemCount(Integer chargeItemCount) {
        this.chargeItemCount = chargeItemCount;
    }

    /**
     * 渠道追踪单号
     * @return  渠道追踪单号
     * @mbggenerated
     */
    public String getChannelVoucherNo() {
        return channelVoucherNo;
    }

    /**
     * 渠道追踪单号
     * @param channelVoucherNo  渠道追踪单号
     * @mbggenerated
     */
    public void setChannelVoucherNo(String channelVoucherNo) {
        this.channelVoucherNo = channelVoucherNo == null ? null
                : channelVoucherNo.trim();
    }

    /**
     * 渠道返回结果信息
     * @return  渠道返回结果信息
     * @mbggenerated
     */
    public String getChannelMsg() {
        return channelMsg;
    }

    /**
     * 渠道返回结果信息
     * @param channelMsg  渠道返回结果信息
     * @mbggenerated
     */
    public void setChannelMsg(String channelMsg) {
        this.channelMsg = channelMsg == null ? null : channelMsg.trim();
    }

    /**
     * 实际支付时间
     * @return  实际支付时间
     * @mbggenerated
     */
    public Date getPayedTime() {
        return payedTime;
    }

    /**
     * 实际支付时间
     * @param payedTime  实际支付时间
     * @mbggenerated
     */
    public void setPayedTime(Date payedTime) {
        this.payedTime = payedTime;
    }

    /**
     * 实收金额（元）
     * @return  实收金额（元）
     * @mbggenerated
     */
    public BigDecimal getReceivedAmt() {
        return receivedAmt;
    }

    /**
     * 实收金额（元）
     * @param receivedAmt  实收金额（元）
     * @mbggenerated
     */
    public void setReceivedAmt(BigDecimal receivedAmt) {
        this.receivedAmt = receivedAmt;
    }

    /**
     * 票据类型编码
     * @return  票据类型编码
     * @mbggenerated
     */
    public String getRtNo() {
        return rtNo;
    }

    /**
     * 票据类型编码
     * @param rtNo  票据类型编码
     * @mbggenerated
     */
    public void setRtNo(String rtNo) {
        this.rtNo = rtNo == null ? null : rtNo.trim();
    }

    /**
     * 票据号码
     * @return  票据号码
     * @mbggenerated
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * 票据号码
     * @param receiptNo  票据号码
     * @mbggenerated
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo == null ? null : receiptNo.trim();
    }

    /**
     * 代收银行名称
     * @return  代收银行名称
     * @mbggenerated
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 代收银行名称
     * @param bankName  代收银行名称
     * @mbggenerated
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 用户ID 
     * @return  用户ID 
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID 
     * @param userId  用户ID 
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 业务ID（冗余）
     * @return  业务ID（冗余）
     * @mbggenerated
     */
    public String getBuzzId() {
        return buzzId;
    }

    /**
     * 业务ID（冗余）
     * @param buzzId  业务ID（冗余）
     * @mbggenerated
     */
    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId == null ? null : buzzId.trim();
    }

    /**
     * 订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功
     * @return  订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功
     * @param status  订单状态：0-处理中，1-待缴费，2-缴费接口调用失败，3-取消订单，4-缴费成功
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 取消订单时间
     * @return  取消订单时间
     * @mbggenerated
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 取消订单时间
     * @param cancelTime  取消订单时间
     * @mbggenerated
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 创建时间
     * @return  创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime  创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return  更新时间
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime  更新时间
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..]
     * @return  收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..]
     * @mbggenerated
     */
    public String getItems() {
        return items;
    }

    /**
     * 收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..]
     * @param items  收费项[{\"itemNo\":\"收费项目编码\",\"itemName\":\"收费项目名称\",\"price\":\"单价\",\"quantity\":\"数量\"},..]
     * @mbggenerated
     */
    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }
}