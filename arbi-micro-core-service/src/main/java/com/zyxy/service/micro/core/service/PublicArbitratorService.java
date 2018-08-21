package com.zyxy.service.micro.core.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ArbitratorListVO;

/**
 * 仲裁员案件相关服务
 */
public interface PublicArbitratorService {

    /**
     * 申请立案业务处理
     * @param form DTO
     * @return
     */
    BusiExecuteResult<PageInfo<ArbitratorListVO>> queryArbitratorsBusiExecute(BasePageDTO form);

}