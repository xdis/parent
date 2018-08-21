package com.zyxy.common.vo;

import java.util.Date;

/**
 *  案件仲裁员组庭通知书对象
 */
public class CaseArbitratorTribunalVO {

    /**
     * 仲裁员名字
     */
    private String arbitratorName;

    /**
     * 组庭通知书时间
     */
    private Date tribunalNoticeCreateTime;

    public String getArbitratorName() {
        return arbitratorName;
    }

    public void setArbitratorName(String arbitratorName) {
        this.arbitratorName = arbitratorName;
    }

    public Date getTribunalNoticeCreateTime() {
        return tribunalNoticeCreateTime;
    }

    public void setTribunalNoticeCreateTime(Date tribunalNoticeCreateTime) {
        this.tribunalNoticeCreateTime = tribunalNoticeCreateTime;
    }
}
