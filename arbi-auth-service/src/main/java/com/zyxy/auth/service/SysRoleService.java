package com.zyxy.auth.service;

import com.zyxy.common.domain.SysRole;

import java.util.List;

/**
 * 角色
 */
public interface SysRoleService {
    /**
     *
     */
    List<SysRole> listRoleByUserId(String userId);
}
