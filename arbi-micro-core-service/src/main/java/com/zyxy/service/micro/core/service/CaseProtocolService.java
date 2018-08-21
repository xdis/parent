package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.ProtocolRecordInsertDTO;
import com.zyxy.common.dto.ProtocolResponseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ProtocolDocInfoVO;
import com.zyxy.common.vo.ProtocolInfoVO;

/**
 * 	调节协议申请Service
 */
public interface CaseProtocolService {

	/**
	 * 调节协议申请业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult protocolApplyValid(ProtocolRecordInsertDTO formData);
	
	/**
	 * 调节协议申请业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> protocolApplyExecute(ProtocolRecordInsertDTO formData);
	
	/**
	 * 调解协议申请书回应业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult protocolResponseValid(ProtocolResponseDTO formData);
	
	/**
	 * 调解协议申请书回应业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> protoclResponseExecute(ProtocolResponseDTO formData);
	
	/**
	 * 和解状态
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult protocolStatusInfoValid(String caseId,String userId);
	
	/**
	 * 和解状态
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<ProtocolInfoVO> protocolStatusInfoExecute(String caseId,String userId);
	
	/**
	 * 调解协议申请书验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult protocolDocInfoValid(String caseId,String userId);

	/**
	 * 调解协议申请书业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<ProtocolDocInfoVO>  protocolDocInfoExecute(String caseId,String userId);
}
