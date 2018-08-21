package com.zyxy.admin.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.CaseListService;
import com.zyxy.common.domain.CaseManagerExample;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseListVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 案件serviceImpl
 */
@Service
public class CaseListServiceImpl implements CaseListService{

    @Autowired
    CaseInfoMapper caseInfoMapper;

    @Autowired
    ManagerInfoMapper managerInfoMapper;
    
    @Autowired
    CaseManagerMapper caseManagerMapper;

    /**
     * 业务处理
     * @param formData
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<CaseListVO>> queryArbiCaseListBusiExcute(CaseListDTO formData) {
    	PageInfo<CaseListVO> caseListVOPageInfo = this.queryArbiCaseList(formData);
        return BusiExecuteResult.builderSuccessResult(caseListVOPageInfo);
    }

    /**
     * 业务验证
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult queryArbiCaseListBusiValid(String userId) {
        //根据user_info表中的数据查询出仲裁委的信息
        ManagerInfo managerInfo = managerInfoMapper.queryDutiesAndStatusByPrimaryKey(userId);
		/*
		 * 0-正常返回成功
		 * 非0返回失败，并带上失败信息
		 */
        if(managerInfo!=null){
        	if(ManagerInfoStatusEnum.NORMAL.getCode().equals(managerInfo.getStatus())){
                return BusiValidResult.builderSuccessResult();
            }
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ACCOUNT_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
        
    }

    /******************私有service********************/
    /**
     * 查询案件列表
     * @param formData
     * @return
     */
    public PageInfo<CaseListVO> queryArbiCaseList(CaseListDTO formData) {
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return new PageInfo<CaseListVO>(caseInfoMapper.queryArbiCaseList(formData));
    }
}
