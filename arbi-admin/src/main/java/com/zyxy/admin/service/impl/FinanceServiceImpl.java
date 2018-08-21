package com.zyxy.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.FinanceService;
import com.zyxy.common.dto.FincaceDTO;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.FinanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 财务模块serviceImpl
 */
@Service
public class FinanceServiceImpl implements FinanceService{

    @Autowired
    private CaseInfoMapper caseInfoMapper;


    /**
     * 查询财务模块列表业务处理
     * @param formData
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<FinanceVO>> queryFinanceBusiExecute(FincaceDTO formData) {
        return BusiExecuteResult.builderSuccessResult(this.queryFinance(formData));
    }


    /****************私有service*****************/

    /**
     * 查询财务模块列表
     * @param formData
     * @return
     */
    private PageInfo<FinanceVO> queryFinance(FincaceDTO formData){
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return new PageInfo<FinanceVO>(caseInfoMapper.queryFinance(formData));
    }
}
