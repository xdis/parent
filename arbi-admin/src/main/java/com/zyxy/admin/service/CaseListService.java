package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CaseListVO;

/**
 * 案件service
 */
public interface CaseListService {



    /**
     * 业务验证
     * @param userId
     * @return
     */
    BusiValidResult queryArbiCaseListBusiValid(String userId);

    /**
     * 业务处理
     * @param formData
     * @return
     */
    BusiExecuteResult<PageInfo<CaseListVO>> queryArbiCaseListBusiExcute(CaseListDTO formData);

}
