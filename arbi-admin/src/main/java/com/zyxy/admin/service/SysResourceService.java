package com.zyxy.admin.service;

import java.util.List;

import com.zyxy.common.domain.SysResource;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.vo.UserInfoVO;

public interface SysResourceService {
	/**
     * 根据userid查询用户拥有的资源
     * @param userId
     * @return
     */
	List<SysResource> selectUserResource(String userId);

	/**
	 * 根据userid查询当前登录人信息
	 * @param userId
	 * @return 
	 */
	UserInfoVO selectUserInFo(String userId);

	/**
	 * 根据userId查询出手机号
	 * @param userId
	 * @return
	 */
	UserInfoVO selectPhoneByUserId(String userId);
}
