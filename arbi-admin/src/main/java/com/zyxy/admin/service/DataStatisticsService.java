package com.zyxy.admin.service;

import com.zyxy.common.domain.DataStatistics;
import com.zyxy.common.dto.DataStatisticsDTO;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DataStatisticsVO;

/**
 * 数据统计service
 */
public interface DataStatisticsService {
    /**
     * 业务验证
     * @param userId
     * @return
     */
    BusiValidResult queryDataStatisticsBusiValid(String userId);


    /**
     * 业务处理
     * @param formData
     * @return
     */
    DataStatisticsVO queryDataStatisticsBusiBusiExecute(DataStatisticsDTO formData);

    /**
     * 数据统计
     * @param formData
     * @return
     */
    DataStatistics queryDataStatistics(DataStatisticsDTO formData);

}
