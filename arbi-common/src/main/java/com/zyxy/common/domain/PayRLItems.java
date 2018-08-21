package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   3.4.3 收费项目信息
 *
 * pay_rl_items
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="PayRLItems")
public class PayRLItems implements Serializable {

    /**
     * ID pay_rl_items.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 数据同步类型：1－新增，2－修改，3－删除 pay_rl_items.SYNC_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据同步类型：1－新增，2－修改，3－删除")
    private String syncType;
    /**
     * 项目编码 pay_rl_items.ITEM_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "项目编码")
    private String itemNo;
    /**
     * 项目名称 pay_rl_items.ITEM_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "项目名称")
    private String itemName;
    /**
     * 管理方式：1–财政专户管理,2 –预算资金管理 pay_rl_items.MANANGER_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "管理方式：1–财政专户管理,2 –预算资金管理")
    private String manangerType;
    /**
     * 收费标准上限（元） pay_rl_items.CHARGE_MAX
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费标准上限（元）")
    private Long chargeMax;
    /**
     * 收费标准下限（元） pay_rl_items.CHARGE_MIN
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费标准下限（元）")
    private Long chargeMin;
    /**
     * 计量单位 pay_rl_items.CHARGE_UNIT
     * @mbggenerated
     */
    @ApiModelProperty(value = "计量单位")
    private String chargeUnit;
    /**
     * 收费项目类别码 pay_rl_items.ITEM_TYPE_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项目类别码")
    private String itemTypeNo;
    /**
     * 收费项目类别名称 pay_rl_items.ITEM_TYPE_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项目类别名称")
    private String itemTypeName;
    /**
     * 收费项目缴入账号 pay_rl_items.CHARGE_IN_ACCOUT
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项目缴入账号")
    private String chargeInAccout;
    /**
     * 收费项目归属账号所属银行代码 pay_rl_items.CHARGE_IN_BANK_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费项目归属账号所属银行代码")
    private String chargeInBankCode;
    /**
     * 批准级次 pay_rl_items.APPROVE_LEVEL
     * @mbggenerated
     */
    @ApiModelProperty(value = "批准级次")
    private Integer approveLevel;
    /**
     * 批准文号 pay_rl_items.APPROVE_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "批准文号")
    private String approveNo;
    /**
     * 是否减免收费 pay_rl_items.IS_FREE
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否减免收费")
    private Integer isFree;
    /**
     * 预算科目外码 pay_rl_items.BUDGET_SUBJECT_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "预算科目外码")
    private String budgetSubjectCode;
    /**
     * 预算科目名称 pay_rl_items.BUDGET_SUBJECT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "预算科目名称")
    private String budgetSubjectName;
    /**
     * 收费对象 pay_rl_items.CHARGE_TARGET
     * @mbggenerated
     */
    @ApiModelProperty(value = "收费对象")
    private Integer chargeTarget;
    /**
     * 缴费期限 pay_rl_items.CHARGE_TERM
     * @mbggenerated
     */
    @ApiModelProperty(value = "缴费期限")
    private Integer chargeTerm;
    /**
     * 滞纳金率 pay_rl_items.LATE_FEE_RATE
     * @mbggenerated
     */
    @ApiModelProperty(value = "滞纳金率")
    private Long lateFeeRate;
    /**
     * 状态 pay_rl_items.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 同步时间 pay_rl_items.SYNC_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "同步时间")
    private Date syncTime;
    /**
     * 用途：0-案件处理费，1-案件受理费 pay_rl_items.USAGES
     * @mbggenerated
     */
    @ApiModelProperty(value = "用途：0-案件处理费，1-案件受理费")
    private Integer usages;
    /**
     * pay_rl_items
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
     * 数据同步类型：1－新增，2－修改，3－删除
     * @return  数据同步类型：1－新增，2－修改，3－删除
     * @mbggenerated
     */
    public String getSyncType() {
        return syncType;
    }

    /**
     * 数据同步类型：1－新增，2－修改，3－删除
     * @param syncType  数据同步类型：1－新增，2－修改，3－删除
     * @mbggenerated
     */
    public void setSyncType(String syncType) {
        this.syncType = syncType == null ? null : syncType.trim();
    }

    /**
     * 项目编码
     * @return  项目编码
     * @mbggenerated
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * 项目编码
     * @param itemNo  项目编码
     * @mbggenerated
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    /**
     * 项目名称
     * @return  项目名称
     * @mbggenerated
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 项目名称
     * @param itemName  项目名称
     * @mbggenerated
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 管理方式：1–财政专户管理,2 –预算资金管理
     * @return  管理方式：1–财政专户管理,2 –预算资金管理
     * @mbggenerated
     */
    public String getManangerType() {
        return manangerType;
    }

    /**
     * 管理方式：1–财政专户管理,2 –预算资金管理
     * @param manangerType  管理方式：1–财政专户管理,2 –预算资金管理
     * @mbggenerated
     */
    public void setManangerType(String manangerType) {
        this.manangerType = manangerType == null ? null : manangerType.trim();
    }

    /**
     * 收费标准上限（元）
     * @return  收费标准上限（元）
     * @mbggenerated
     */
    public Long getChargeMax() {
        return chargeMax;
    }

    /**
     * 收费标准上限（元）
     * @param chargeMax  收费标准上限（元）
     * @mbggenerated
     */
    public void setChargeMax(Long chargeMax) {
        this.chargeMax = chargeMax;
    }

    /**
     * 收费标准下限（元）
     * @return  收费标准下限（元）
     * @mbggenerated
     */
    public Long getChargeMin() {
        return chargeMin;
    }

    /**
     * 收费标准下限（元）
     * @param chargeMin  收费标准下限（元）
     * @mbggenerated
     */
    public void setChargeMin(Long chargeMin) {
        this.chargeMin = chargeMin;
    }

    /**
     * 计量单位
     * @return  计量单位
     * @mbggenerated
     */
    public String getChargeUnit() {
        return chargeUnit;
    }

    /**
     * 计量单位
     * @param chargeUnit  计量单位
     * @mbggenerated
     */
    public void setChargeUnit(String chargeUnit) {
        this.chargeUnit = chargeUnit == null ? null : chargeUnit.trim();
    }

    /**
     * 收费项目类别码
     * @return  收费项目类别码
     * @mbggenerated
     */
    public String getItemTypeNo() {
        return itemTypeNo;
    }

    /**
     * 收费项目类别码
     * @param itemTypeNo  收费项目类别码
     * @mbggenerated
     */
    public void setItemTypeNo(String itemTypeNo) {
        this.itemTypeNo = itemTypeNo == null ? null : itemTypeNo.trim();
    }

    /**
     * 收费项目类别名称
     * @return  收费项目类别名称
     * @mbggenerated
     */
    public String getItemTypeName() {
        return itemTypeName;
    }

    /**
     * 收费项目类别名称
     * @param itemTypeName  收费项目类别名称
     * @mbggenerated
     */
    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName == null ? null : itemTypeName.trim();
    }

    /**
     * 收费项目缴入账号
     * @return  收费项目缴入账号
     * @mbggenerated
     */
    public String getChargeInAccout() {
        return chargeInAccout;
    }

    /**
     * 收费项目缴入账号
     * @param chargeInAccout  收费项目缴入账号
     * @mbggenerated
     */
    public void setChargeInAccout(String chargeInAccout) {
        this.chargeInAccout = chargeInAccout == null ? null : chargeInAccout
                .trim();
    }

    /**
     * 收费项目归属账号所属银行代码
     * @return  收费项目归属账号所属银行代码
     * @mbggenerated
     */
    public String getChargeInBankCode() {
        return chargeInBankCode;
    }

    /**
     * 收费项目归属账号所属银行代码
     * @param chargeInBankCode  收费项目归属账号所属银行代码
     * @mbggenerated
     */
    public void setChargeInBankCode(String chargeInBankCode) {
        this.chargeInBankCode = chargeInBankCode == null ? null
                : chargeInBankCode.trim();
    }

    /**
     * 批准级次
     * @return  批准级次
     * @mbggenerated
     */
    public Integer getApproveLevel() {
        return approveLevel;
    }

    /**
     * 批准级次
     * @param approveLevel  批准级次
     * @mbggenerated
     */
    public void setApproveLevel(Integer approveLevel) {
        this.approveLevel = approveLevel;
    }

    /**
     * 批准文号
     * @return  批准文号
     * @mbggenerated
     */
    public String getApproveNo() {
        return approveNo;
    }

    /**
     * 批准文号
     * @param approveNo  批准文号
     * @mbggenerated
     */
    public void setApproveNo(String approveNo) {
        this.approveNo = approveNo == null ? null : approveNo.trim();
    }

    /**
     * 是否减免收费
     * @return  是否减免收费
     * @mbggenerated
     */
    public Integer getIsFree() {
        return isFree;
    }

    /**
     * 是否减免收费
     * @param isFree  是否减免收费
     * @mbggenerated
     */
    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    /**
     * 预算科目外码
     * @return  预算科目外码
     * @mbggenerated
     */
    public String getBudgetSubjectCode() {
        return budgetSubjectCode;
    }

    /**
     * 预算科目外码
     * @param budgetSubjectCode  预算科目外码
     * @mbggenerated
     */
    public void setBudgetSubjectCode(String budgetSubjectCode) {
        this.budgetSubjectCode = budgetSubjectCode == null ? null
                : budgetSubjectCode.trim();
    }

    /**
     * 预算科目名称
     * @return  预算科目名称
     * @mbggenerated
     */
    public String getBudgetSubjectName() {
        return budgetSubjectName;
    }

    /**
     * 预算科目名称
     * @param budgetSubjectName  预算科目名称
     * @mbggenerated
     */
    public void setBudgetSubjectName(String budgetSubjectName) {
        this.budgetSubjectName = budgetSubjectName == null ? null
                : budgetSubjectName.trim();
    }

    /**
     * 收费对象
     * @return  收费对象
     * @mbggenerated
     */
    public Integer getChargeTarget() {
        return chargeTarget;
    }

    /**
     * 收费对象
     * @param chargeTarget  收费对象
     * @mbggenerated
     */
    public void setChargeTarget(Integer chargeTarget) {
        this.chargeTarget = chargeTarget;
    }

    /**
     * 缴费期限
     * @return  缴费期限
     * @mbggenerated
     */
    public Integer getChargeTerm() {
        return chargeTerm;
    }

    /**
     * 缴费期限
     * @param chargeTerm  缴费期限
     * @mbggenerated
     */
    public void setChargeTerm(Integer chargeTerm) {
        this.chargeTerm = chargeTerm;
    }

    /**
     * 滞纳金率
     * @return  滞纳金率
     * @mbggenerated
     */
    public Long getLateFeeRate() {
        return lateFeeRate;
    }

    /**
     * 滞纳金率
     * @param lateFeeRate  滞纳金率
     * @mbggenerated
     */
    public void setLateFeeRate(Long lateFeeRate) {
        this.lateFeeRate = lateFeeRate;
    }

    /**
     * 状态
     * @return  状态
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status  状态
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 同步时间
     * @return  同步时间
     * @mbggenerated
     */
    public Date getSyncTime() {
        return syncTime;
    }

    /**
     * 同步时间
     * @param syncTime  同步时间
     * @mbggenerated
     */
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    /**
     * 用途：0-案件处理费，1-案件受理费
     * @return  用途：0-案件处理费，1-案件受理费
     * @mbggenerated
     */
    public Integer getUsages() {
        return usages;
    }

    /**
     * 用途：0-案件处理费，1-案件受理费
     * @param usages  用途：0-案件处理费，1-案件受理费
     * @mbggenerated
     */
    public void setUsages(Integer usages) {
        this.usages = usages;
    }
}