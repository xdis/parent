package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.SysResourceService;
import com.zyxy.common.domain.SysResource;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.mapper.*;
import com.zyxy.common.vo.UserInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户资源serviceImpl
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    SysResourceMapper sysResourceMapper;
    
    @Autowired
    UserInfoMapper userInfoMapper;

	@Override
	public List<SysResource> selectUserResource(String userId) {
		return sysResourceMapper.selectUserResource(userId);
	}

	@Override
	public UserInfoVO selectUserInFo(String userId) {
		return userInfoMapper.selectUserInFoByUserId(userId);
	}

	/**
	 * 根据userId查询出手机号
	 * @param userId
	 * @return
	 */
	@Override
	public UserInfoVO selectPhoneByUserId(String userId) {
		return userInfoMapper.selectPhoneByUserId(userId);
	}


}
