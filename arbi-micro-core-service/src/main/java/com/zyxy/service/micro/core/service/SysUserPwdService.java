package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 修改密码服务
 */
public interface SysUserPwdService {
	
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
    @Transactional
    BusiExecuteResult sysUserPwdBusiExecute(SysUserPwdDTO formData);
	
}
