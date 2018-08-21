package com.zyxy.service.micro.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.mapper.ArbitratorInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ArbitratorListVO;
import com.zyxy.common.vo.CaseArbitrationInfoVO;
import com.zyxy.common.vo.LitigantCaseListVO;
import com.zyxy.service.micro.core.service.PublicArbitratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PublicArbitratorServiceImpl implements PublicArbitratorService {

    @Autowired
    private ArbitratorInfoMapper arbitratorInfoMapper;

    @Override
    public BusiExecuteResult<PageInfo<ArbitratorListVO>> queryArbitratorsBusiExecute(BasePageDTO formData) {
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1 || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        PageInfo<ArbitratorListVO> pageInfo = new PageInfo<>(arbitratorInfoMapper.queryArbitrationList());
        return BusiExecuteResult.builderSuccessResult(pageInfo);
    }
}
