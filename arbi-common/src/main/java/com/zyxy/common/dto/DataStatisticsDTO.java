package com.zyxy.common.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据统计对象
 */
@ApiModel("数据统计对象")
public class DataStatisticsDTO extends BaseDTO{

    /**
     * 用户id，user_info表id
     */
    @ApiModelProperty("用户id，user_info表id")
    private String userId;

    /**
     * 当天
     */
    @ApiModelProperty("当天")
    private String toDay;

    /**
     * 当月
     */
    @ApiModelProperty("当月")
    private String sameMonth;
    
    /*******审批类型******/
    /**
     * 立案
     */
    private String registered;
    
    /**
     * 裁决
     */
    private String number;
    
    /**
     * 本请求撤案
     */
    private String isCancel;
    
    /**
     * 反请求撤案
     */
    private String antiCancel;
    
    /**
     * 调解
     */
    private String conciliation;
    
    /**
     * 反请求审批
     */
    private String counterclaim;
    
    /**
     * 仲裁请求变更
     */
    private String change;
    
    /**
     * 秘书回避请求
     */
    private String avoid;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    public String getSameMonth() {
        return sameMonth;
    }

    public void setSameMonth(String sameMonth) {
        this.sameMonth = sameMonth;
    }

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public String getAntiCancel() {
		return antiCancel;
	}

	public void setAntiCancel(String antiCancel) {
		this.antiCancel = antiCancel;
	}

	public String getConciliation() {
		return conciliation;
	}

	public void setConciliation(String conciliation) {
		this.conciliation = conciliation;
	}

	public String getCounterclaim() {
		return counterclaim;
	}

	public void setCounterclaim(String counterclaim) {
		this.counterclaim = counterclaim;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getAvoid() {
		return avoid;
	}

	public void setAvoid(String avoid) {
		this.avoid = avoid;
	}
}
