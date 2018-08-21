package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.EnumerateEvidenceDTO;
import com.zyxy.common.dto.OppugnEvidenceDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.EvidenceListVO;

/**
 * 举证Service
 */
public interface EnumerateEvidenceService {
	
	/**
	 * 质证业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult oppugnEvidenceValid(OppugnEvidenceDTO formData);
	
	/**
	 * 质证业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> oppugnEvidenceExecute(OppugnEvidenceDTO formData);
	
	/**
	 * 举证业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult enumerateEvidenceValid(EnumerateEvidenceDTO formData);
	
	/**
	 * 举证业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> enumerateEvidenceExecute(EnumerateEvidenceDTO formData);
	
	/**
	 * 证据列表业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult evidenceListValid(String caseId,String userId);
	
	/**
	 * 证据列表业务处理
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<EvidenceListVO> evidenceListExecute(String caseId);
	
}
