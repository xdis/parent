package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.FincaceDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.FinanceVO;

/**
 * 财务模块service
 */
public interface FinanceService {

    /**
     * 查询财务模块列表业务处理
     * @return
     */
    BusiExecuteResult<PageInfo<FinanceVO>> queryFinanceBusiExecute(FincaceDTO formData);
}
