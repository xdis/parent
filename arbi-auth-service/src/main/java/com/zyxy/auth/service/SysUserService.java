package com.zyxy.auth.service;

import com.zyxy.common.domain.SysUser;

/**
 * 登录
 */
public interface SysUserService {

    SysUser getByUserName(String userName);

    SysUser getByUserName(String userName, int userType);

    SysUser getById(String userId);
}
