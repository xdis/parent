package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ArbitrationCaseListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitrationCaseArbitrationApplyVO;
import com.zyxy.common.vo.ArbitrationCaseListVO;

/**
 * 
 * 仲裁委service
 *
 */
public interface ArbitrationCaseService {


	/**
	 * 业务验证
	 * @param userId
	 * @return
	 */
	BusiValidResult queryArbitrationCaseBusiValid(String userId);


	/**
	 * 业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<PageInfo<ArbitrationCaseListVO>> queryArbitrationCaseBusiExecute(ArbitrationCaseListDTO formData);
	
	/**
	 * 仲裁委-查询案件详情-仲裁请求业务执行
	 * @param caseId 案件id
	 * @return
	 */
	BusiExecuteResult<ArbitrationCaseArbitrationApplyVO> queryCaseArbitrationRequestInfoBusiExecute(String caseId,String userId,String requestFlag);
	
}
