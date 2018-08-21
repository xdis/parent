package com.zyxy.service.micro.core.service.impl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.LitigantInfoExample;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.dto.LitigantEmailUpdateDTO;
import com.zyxy.common.dto.LitigantInfoUpdateDTO;
import com.zyxy.common.dto.PassWordModifyDTO;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.UserBaseInfoVO;
import com.zyxy.service.micro.core.service.PersonalCenterService;
import com.zyxy.service.micro.core.util.PwdUtil;

/**
 * 个人中心
 */
@Service
public class PersonalCenterServiceImpl implements PersonalCenterService {

	@Autowired
	private LitigantInfoMapper litigantInfoMapper;
	@Autowired
	private SysUserMapper  sysUserMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	
	@Override
	public BusiExecuteResult<UserBaseInfoVO> userBaseInfoExcute(String userId) {
		UserBaseInfoVO baseInfoVO =litigantInfoMapper.selectUserBaseInfo(userId);
		return BusiExecuteResult.builderSuccessResult(baseInfoVO);
	}

	@Override
	public BusiValidResult passwordValid(String userId,
			String password) {
		 //将获得的密码进行加密
        String md5UserPwd = PwdUtil.getPwd(password);
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserInfoIdEqualTo(userId)
                .andUserPwdEqualTo(md5UserPwd);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        if (sysUserList.size() == 1) {
            //原密码输入正确
            return BusiValidResult.builderSuccessResult();
        } else {
            //原密码输入有误
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.OLD_PASS_WORD_ERROR);
        }
	}

	@Override
	public BusiExecuteResult<String> updatePasswordExcute(
			PassWordModifyDTO formData) {
		SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserInfoIdEqualTo(formData.getUserId());
        SysUser sysUser = new SysUser();
        sysUser.setUserPwd(PwdUtil.getPwd(formData.getNewPassword()));
        int lows = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if (lows > 0) {
            //密码修改成功
            return BusiExecuteResult.builderSuccessResult();
        } else {
            //密码修改失败
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }
	}

	@Override
	public BusiExecuteResult<String> updateBaseInfoExcute(
			LitigantInfoUpdateDTO formData) {
		LitigantInfo record = new LitigantInfo();
		record.setAddress(formData.getAddress());
		record.setVocation(formData.getVocation());
		LitigantInfoExample example = new LitigantInfoExample();
		example.createCriteria().andUserIdEqualTo(formData.getUserId());
		litigantInfoMapper.updateByExampleSelective(record, example);
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> updateEmail(LitigantEmailUpdateDTO formData) {
		UserInfo record = new UserInfo();
		record.setId(formData.getUserId());
		record.setEmail(formData.getEmail());
		userInfoMapper.updateByPrimaryKeySelective(record);
		return BusiExecuteResult.builderSuccessResult();
	}
	
	
	
	
}
