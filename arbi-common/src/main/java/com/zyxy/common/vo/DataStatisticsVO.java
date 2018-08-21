package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;

import com.zyxy.common.domain.DataStatistics;

/**
 * 数据统计对象
 */
@ApiModel("数据统计对象")
public class DataStatisticsVO {
	/**
     * 职业
     */
    private String duties;
    
    /**
     * 当月
     */
    private String sameMonth;

    /**
     * 总统计数据
     */
    private DataStatistics totalDataStatistics;
    
    /**
     * 总统计立案数据
     */
    private DataStatistics totalRegistered;
    
    /**
     * 总统计裁决数据
     */
    private DataStatistics totalNumber;

    /**
     * 当天统计数据
     */
    private DataStatistics todayDataStatistics;
    
    /**
     * 当天撤案统计数据
     */
    private DataStatistics todayCancel;
    
    /**
     * 当天调解统计数据
     */
    private DataStatistics todayConciliation;

    /**
     * 当月统计数据
     */
    private DataStatistics monthDataStatistics;
    
    /**
     * 当月立案统计数据
     */
    private DataStatistics monthRegistered;

    /**
     * 当月裁决统计数据
     */
    private DataStatistics monthNumber;
    
    /**
     * 当月反请求审批统计数据
     */
    private DataStatistics monthCounterclaim;
    
    /**
     * 当月仲裁请求变更统计数据
     */
    private DataStatistics monthChange;
    
    /**
     * 当月秘书回避请求统计数据
     */
    private DataStatistics monthAvoid;

    public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getSameMonth() {
		return sameMonth;
	}

	public void setSameMonth(String sameMonth) {
		this.sameMonth = sameMonth;
	}

	public DataStatistics getTotalDataStatistics() {
        return totalDataStatistics;
    }

    public void setTotalDataStatistics(DataStatistics totalDataStatistics) {
        this.totalDataStatistics = totalDataStatistics;
    }

    public DataStatistics getTotalRegistered() {
		return totalRegistered;
	}

	public void setTotalRegistered(DataStatistics totalRegistered) {
		this.totalRegistered = totalRegistered;
	}

	public DataStatistics getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(DataStatistics totalNumber) {
		this.totalNumber = totalNumber;
	}

	public DataStatistics getTodayDataStatistics() {
        return todayDataStatistics;
    }

    public void setTodayDataStatistics(DataStatistics todayDataStatistics) {
        this.todayDataStatistics = todayDataStatistics;
    }

    public DataStatistics getMonthDataStatistics() {
        return monthDataStatistics;
    }

    public void setMonthDataStatistics(DataStatistics monthDataStatistics) {
        this.monthDataStatistics = monthDataStatistics;
    }

	public DataStatistics getMonthRegistered() {
		return monthRegistered;
	}

	public void setMonthRegistered(DataStatistics monthRegistered) {
		this.monthRegistered = monthRegistered;
	}

	public DataStatistics getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(DataStatistics monthNumber) {
		this.monthNumber = monthNumber;
	}

	public DataStatistics getTodayCancel() {
		return todayCancel;
	}

	public void setTodayCancel(DataStatistics todayCancel) {
		this.todayCancel = todayCancel;
	}

	public DataStatistics getTodayConciliation() {
		return todayConciliation;
	}

	public void setTodayConciliation(DataStatistics todayConciliation) {
		this.todayConciliation = todayConciliation;
	}

	public DataStatistics getMonthCounterclaim() {
		return monthCounterclaim;
	}

	public void setMonthCounterclaim(DataStatistics monthCounterclaim) {
		this.monthCounterclaim = monthCounterclaim;
	}

	public DataStatistics getMonthChange() {
		return monthChange;
	}

	public void setMonthChange(DataStatistics monthChange) {
		this.monthChange = monthChange;
	}

	public DataStatistics getMonthAvoid() {
		return monthAvoid;
	}

	public void setMonthAvoid(DataStatistics monthAvoid) {
		this.monthAvoid = monthAvoid;
	}
}
