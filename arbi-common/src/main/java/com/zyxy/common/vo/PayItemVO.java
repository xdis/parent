package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 缴费收费项目
 * @author tanquan
 *
 */
@ApiModel(value ="缴费收费项目")
public class PayItemVO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private String itemNo;
    
    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    private String itemName;

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
