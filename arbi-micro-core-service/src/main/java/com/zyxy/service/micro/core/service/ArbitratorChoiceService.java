package com.zyxy.service.micro.core.service;

import java.util.List;

import com.zyxy.common.dto.CaseArbitratorOprInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorAvoidRecordVO;

public interface ArbitratorChoiceService {

	/**
	 * 仲裁员选择记录验证
	 * @param formData
	 * @return
	 */
	BusiValidResult arbitratorChoiceBusiValid(CaseArbitratorOprInsertDTO formData);
	
	/**
	 * 仲裁与选择业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> arbitratorChoiceBusiExecute(CaseArbitratorOprInsertDTO formData);
	
	/**
	 * 仲裁员回避列表业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult arbitratorAvoidListValid(String caseId,String userId);
	
	/**
	 * 仲裁员回避列表业务处理
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<List<ArbitratorAvoidRecordVO>> arbitratorAvoidListExecute(String caseId);
}
