package com.zyxy.admin.service;


/**
 * 判断是否分配了仲裁委工作人员的service
 */
public interface WhetherDistributionService {

    /**
     * 查询是否分配了仲裁委的工作人员
     * @param caseId
     * @param duties
     * @return
     */
    boolean queryCaseManagerInfo(String caseId,String duties);
}
