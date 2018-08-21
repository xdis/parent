package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.MethodAuditVO;

public interface UserMethodAuditService {

	/**
	 * 业务验证，判断当前登录人是否是立案秘书
	 * @return
	 */
	BusiValidResult userAuditBusiValid(String userId);
	
	/**
	 * 业务处理，查询法人列表
	 * @param formData 
	 * @return 
	 */
	BusiExecuteResult<PageInfo<MethodAuditVO>> methodAuditBusiExecute(UserAuditDTO formData);

	/**
	  * 审核法人身份验证
	  * @param userId 当前登录用户id
	  * @return 验证结果
	  */
	BusiValidResult auditMethodBusiValid(UserAuditDTO formData);

	/**
	 * 审核法人身份
	 * @param formData 用户身份审核DTO
	 * @return 
	 */
	BusiExecuteResult auditMethodBusiExecute(UserAuditDTO formData);

}
