package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.LitigantEmailUpdateDTO;
import com.zyxy.common.dto.LitigantInfoUpdateDTO;
import com.zyxy.common.dto.PassWordModifyDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.UserBaseInfoVO;



/**
 * 个人中心Service
 */
public interface PersonalCenterService {
	
	/**
	 * 查询用户基本信息
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<UserBaseInfoVO> userBaseInfoExcute(String userId);
	
	/**
	 * 密码验证
	 * @param userId
	 * @param password
	 * @return
	 */
	BusiValidResult passwordValid(String userId,String password);
	
	/**
	 * 修改密码
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> updatePasswordExcute(PassWordModifyDTO formData);
	
	/**
	 * 当事人信息修改
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> updateBaseInfoExcute(LitigantInfoUpdateDTO formData);
	
	/**
	 * 邮箱修改
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> updateEmail(LitigantEmailUpdateDTO formData);
	
}
