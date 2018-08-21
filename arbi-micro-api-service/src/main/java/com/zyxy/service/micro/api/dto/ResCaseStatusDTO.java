package com.zyxy.service.micro.api.dto;

/**
 * 案件状态查询结果
 * @author sonta
 *
 */
public class ResCaseStatusDTO {
    /**
     * 当前主流程状态
     */
    private String currentMainNode;
    
    /**
     * 当前进度,1-立案,2-答辩,3-审理,4-裁决,5-结案,6-补正
     */
    private String currentProgress;

    public String getCurrentMainNode() {
        return currentMainNode;
    }

    public void setCurrentMainNode(String currentMainNode) {
        this.currentMainNode = currentMainNode;
    }

    public String getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(String currentProgress) {
        this.currentProgress = currentProgress;
    }

    
}
