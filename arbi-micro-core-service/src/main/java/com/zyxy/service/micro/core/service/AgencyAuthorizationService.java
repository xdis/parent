package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.AgencyAuthorDTO;
import com.zyxy.common.dto.ChangeAuthorDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AuthorDocVO;
import com.zyxy.common.vo.CaseLitigantValidDTO;
import com.zyxy.common.vo.MessageVO;


/**
 * 代理授权
 */
public interface AgencyAuthorizationService {
	
	/**
	 * 验证是否四要素认证
	 * @param cardId
	 * @return
	 */
	BusiValidResult agentElementVerifyValid(String cardId);
	
	/**
	 * 验证当事人和案件
	 * @param formData
	 * @return
	 */
	BusiValidResult caseLitigantValid(CaseLitigantValidDTO formData);
	
	/**
	 * 预览授权书业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult previewAuthorDocValid(AgencyAuthorDTO formData);
	
	/**
	 * 预览授权书业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<AuthorDocVO> previewAuthoeDocExecute(AgencyAuthorDTO formData);
	
	/**
	 * 代理授权业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<?> agencyAuthorExecute(AgencyAuthorDTO formData);
	
	/**
	 * 权限更改业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult changePrivilegeValid(ChangeAuthorDTO formData);
	
	/**
	 * 权限更改业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<?> changePrivilegeExecute(ChangeAuthorDTO formData);
	
	/**
	 * 案件转线下业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult cancelAgentValid(String caseId,String userId);
	
	/**
	 * 案件转线下业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<?> cancelAgentExecute(String caseId,String userId);
	
	/**
	 * 短信验证
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<MessageVO> authorMsgExecute(AgencyAuthorDTO formData);
	
}
