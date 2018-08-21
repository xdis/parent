package com.zyxy.common.dto;

/**
 * 系统消息DTO
 */
public class SysMessageRecordDTO extends BasePageDTO{
    /**
     * 标题
     */
    private String title;

    /**
     * 发布对象
     * 0-全部
     * 1-申请人
     * 2-被申请人
     * 3-代理人
     * 4-仲裁员
     */
    private String releaseType;

    /**
     * 发布时间开始时间
     */
    private String createStartTime;

    /**
     * 发布时间结束时间
     */
    private String createEndTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public String getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        this.createStartTime = createStartTime;
    }

    public String getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(String createEndTime) {
        this.createEndTime = createEndTime;
    }
}
