package com.zyxy.admin.service;

import org.springframework.transaction.annotation.Transactional;

import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 个人中心
 *
 */
public interface PersonalCenterService {
	
	 /**
     * 修改密码业务验证
     * @param formData
     * @return
     */
	BusiValidResult sysUserPwdBusiValid(SysUserPwdDTO formData);
    
    
    /**
     * 修改密码业务处理
     * @param formData
     * @return
     */
    BusiExecuteResult sysUserPwdBusiExecute(SysUserPwdDTO formData);

}
