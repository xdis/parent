package com.zyxy.auth.service.impl;

import com.zyxy.auth.service.SysUserService;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.mapper.SysUserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户密码相关服务
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByUserName(String userName) {
        SysUserExample userExample = new SysUserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(userExample);
        return CollectionUtils.isEmpty(sysUsers) ? null : sysUsers.get(0);
    }

    @Override
    public SysUser getByUserName(String userName, int userType) {
        SysUserExample userExample = new SysUserExample();
        userExample.createCriteria()
                .andUserNameEqualTo(userName)
                .andUserTypeEqualTo(userType);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(userExample);
        return CollectionUtils.isEmpty(sysUsers) ? null : sysUsers.get(0);
    }

    @Override
    public SysUser getById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
}
