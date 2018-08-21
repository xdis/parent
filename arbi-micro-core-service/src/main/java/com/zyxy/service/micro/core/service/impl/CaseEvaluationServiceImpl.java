package com.zyxy.service.micro.core.service.impl;

import com.zyxy.common.vo.CaseEvaluationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.CaseEvaluationDTO;
import com.zyxy.common.mapper.CaseEvaluationMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.CaseEvaluationListVO;
import com.zyxy.service.micro.core.service.CaseEvaluationService;

/**
 * 仲裁员案件评论查看服务
 */
@Service
public class CaseEvaluationServiceImpl implements CaseEvaluationService{
	@Autowired
	private CaseEvaluationMapper mapper;
	
	//#######################################公共Service####################################################
	@Override
	public BusiExecuteResult<CaseEvaluationVO> queryCaseEvaluationBusiExecute(CaseEvaluationDTO formData) {
		if(formData.getPageNum()==null || formData.getPageNum()<1){
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1 || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
		CaseEvaluationVO caseEvaluationVO = new CaseEvaluationVO();
		caseEvaluationVO.setOverallRating("满意");
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		caseEvaluationVO.setList(new PageInfo<CaseEvaluationListVO>(mapper.queryCaseEvaluation(formData)));
		return BusiExecuteResult.builderSuccessResult(caseEvaluationVO);
	}

}
