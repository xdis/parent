package com.zyxy.auth.service.impl;

import com.zyxy.auth.service.SysResourceService;
import com.zyxy.auth.service.SysRoleService;
import com.zyxy.common.domain.SysRole;
import com.zyxy.common.domain.SysRoleExample;
import com.zyxy.common.mapper.SysResourceMapper;
import com.zyxy.common.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户密码相关服务
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> listRoleByUserId(String userId) {
        return sysRoleMapper.listRoleByUserId(userId);
    }
}
