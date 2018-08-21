package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ArbitrationCaseListDTO;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CaseListVO;
import com.zyxy.common.vo.RealUserAuditVO;

/**
 * 当事人身份审核Service
 *
 */
public interface UserIdentityAuditService {
	
	
	 /**
	  * 仲裁委工作人员身份验证
	  * @param userId 当前登录用户id
	  * @return 验证结果
	  */
	 BusiValidResult userAuditBusiValid(String userId);
	 
	 /**
	  * 审核用户身份验证
	  * @param userId 当前登录用户id
	  * @return 验证结果
	  */
	 BusiValidResult auditUserBusiValid(UserAuditDTO formData);
	 
	/**
	 * 需要审核的用户列表
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	 BusiExecuteResult<PageInfo<RealUserAuditVO>> userAuditBusiExecute(UserAuditDTO formData);

	/**
	 * 审核用户身份
	 * @param formData 用户身份审核DTO
	 * @return 
	 */
	BusiExecuteResult auditUserBusiExecute(
			UserAuditDTO formData);
	

}
