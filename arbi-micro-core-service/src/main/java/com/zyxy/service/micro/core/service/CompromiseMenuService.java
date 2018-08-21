package com.zyxy.service.micro.core.service;

import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CompromiseMenuVO;

/**
 * 和解按钮权限
 */
public interface CompromiseMenuService {
	
	/**
	 * 和解按钮权限业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult compromiseMenuBusiValid(String caseId,String userId);
	
	/**
	 * 和解按钮权限业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<CompromiseMenuVO> compromiseMenuBusiExecute(String caseId,String userId);

}
