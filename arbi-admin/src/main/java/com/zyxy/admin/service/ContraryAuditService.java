package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ContraryAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ContraryAuditVO;

public interface ContraryAuditService {

	/**
	 * 业务验证，判断当前登录人是否是立案秘书
	 * @return
	 */
	BusiValidResult contraryAuditBusiValid(String userId);

	/**
	 * 业务处理，查询对公账户审核列表
	 * @param formData 
	 * @return 
	 */
	BusiExecuteResult<PageInfo<ContraryAuditVO>> contraryAuditBusiExecute(ContraryAuditDTO formData);

	/**业务验证
	 * 审核对公账户
	 * @param formData 
	 * @param userId
	 * @return
	 */
	BusiValidResult auditContraryBusiValid(ContraryAuditDTO formData);

	/**
	 * 业务处理
	 * 审核对公账户
	 * @param formData
	 * @return
	 */
	BusiExecuteResult auditContraryBusiExecute(ContraryAuditDTO formData);

}
