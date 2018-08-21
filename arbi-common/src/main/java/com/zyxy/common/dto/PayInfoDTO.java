package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 支付请求信息对象
 * @author tanquan
 *
 */
@ApiModel(value ="支付信息对象")
public class PayInfoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public PayInfoDTO(){};
    
    public PayInfoDTO(List<PayItem> items) {
        if(items == null || items.isEmpty()) {
            return;
        }
        BigDecimal total = new BigDecimal(0);
        for (PayItem item : items) {
            total.add(item.getPrice());
        }
        this.receivableAmt = total;
        this.items = items;
    }
    
    /**
     * 缴费单位/个人名称
     */
    @ApiModelProperty("缴费单位/个人名称")
    @NotNull(message="缴费单位/个人名称不能为空")
    private String payerName;
    
    /**
     * 应收总金额（元） 业务系统可不填，由支付服务统一根据收费项目计算
     */
    @ApiModelProperty("应收总金额（元） 业务系统可不填，由支付服务统一根据收费项目计算")
    private BigDecimal receivableAmt;
    
    /**
     * 收费项
     */
    @ApiModelProperty("收费项")
    @NotNull(message="收费项不能为空")
    @NotEmpty(message="收费项不能为空")
    private List<PayItem> items;
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 业务ID，如案件ID/记录ID等（冗余）
     */
    @ApiModelProperty("业务ID，如案件ID/记录ID等（冗余）")
    private String buzzId;
    
    @ApiModelProperty("备注")
    private String remark;
    
    public static class PayItem {
        
        /**
         * 项目编号（调用收费项目查询接口后根据业务选择传入）
         */
        @ApiModelProperty("项目编号")
        @NotNull(message="项目编号不能为空")
        private String itemNo;
        
        /**
         * 项目名称（此项无需填写，由系统根据项目编号自动填入）
         */
        @ApiModelProperty("项目名称（此项无需填写，由系统根据项目编号自动填入）")
        private String itemName;
        
        
        /**
         * 单价（元）
         */
        @ApiModelProperty("单价（元）")
        @NotNull(message="单价不能为空")
        private BigDecimal price;
        
        /**
         * 数量
         */
        @ApiModelProperty("数量")
        @NotNull(message="数量不能为空")
        private int quantity;
        
        
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
        public String getItemNo() {
            return itemNo;
        }
        public void setItemNo(String itemNo) {
            this.itemNo = itemNo;
        }
        public String getItemName() {
            return itemName;
        }
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    }

    public BigDecimal getReceivableAmt() {
        if (this.receivableAmt != null && this.receivableAmt.compareTo(new BigDecimal(0)) != 0) {
            return this.receivableAmt;
        }
        if (this.items == null) {
            return this.receivableAmt;
        }
        BigDecimal total = new BigDecimal(0);
        for (PayItem item : items) {
            total = total.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        this.receivableAmt = total;
        return receivableAmt;
    }

    public void setReceivableAmt(BigDecimal receivableAmt) {
        this.receivableAmt = receivableAmt;
    }

    public List<PayItem> getItems() {
        return items;
    }

    public void setItems(List<PayItem> items) {
        this.items = items;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuzzId() {
        return buzzId;
    }

    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId;
    }
    
    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	
}
