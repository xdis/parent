package com.zyxy.service.micro.core.service;

import java.util.List;

import com.zyxy.common.dto.CompromiseApplyInsertDTO;
import com.zyxy.common.dto.CompromiseResponseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CompromiseApplyInfoVO;

/**
 * 和解申请Service
 */
public interface CompromiseApplyService {
	
	/**
	 * 和解申请业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult compromiseApplyValid(CompromiseApplyInsertDTO formData);
	
	/**
	 * 和解申请业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> compromiseApplyExecute(CompromiseApplyInsertDTO formData);
	
	/**
	 * 和解回应业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult compromiseResponseValid(CompromiseResponseDTO formData);
	
	/**
	 * 和解回应业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> compromiseResponseExecute(CompromiseResponseDTO formData);
	
	/**
	 * 和解记录业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult compromiseApplyInfoValid(String caseId,String userId);
	
	/**
	 * 和解记录业务处理
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<List<CompromiseApplyInfoVO>> compromiseApplyInfoExecute(String caseId,String userId);
}
