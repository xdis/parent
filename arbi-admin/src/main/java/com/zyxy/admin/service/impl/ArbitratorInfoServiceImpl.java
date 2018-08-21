package com.zyxy.admin.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.ArbitratorInfoService;
import com.zyxy.admin.util.PwdUtil;
import com.zyxy.common.domain.ArbitratorInfo;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.domain.UserInfoExample;
import com.zyxy.common.dto.ArbitratorInfoDTO;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.SysUserTypeEnum;
import com.zyxy.common.mapper.ArbitratorInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO;


/**
 * 仲裁委后台-仲裁员管理
 */
@Service
public class ArbitratorInfoServiceImpl implements ArbitratorInfoService {
	
	@Autowired
    private UserInfoMapper userInfoMapper;
	
	@Autowired
    private SequenceService sequenceService;
	
	@Autowired
    private SysUserMapper sysUserMapper;

	@Autowired
	private ArbitratorInfoMapper arbitratorInfoMapper;
	
	@Override
	public BusiValidResult userRegisterBusiValid(ArbitratorInfoDTO formData) {
		//是否已经存在该用户
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andPhoneEqualTo(formData.getPhone());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (userInfos != null && userInfos.size() > 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ALREADY_EXIST);
        }
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public boolean userRegisterBusiExecute(ArbitratorInfoDTO formData) {
		String userId = sequenceService.getCommonID();
        String sysUserId = sequenceService.getCommonID();
        String arbitratorInfoId = sequenceService.getCommonID();
        String password = formData.getPhone().substring(5);
        
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setPhone(formData.getPhone());
        userInfo.setName(formData.getName());
        userInfo.setCreaterId(formData.getCreaterId());
        userInfo.setCreateTime(new Date());
        int i = userInfoMapper.insertSelective(userInfo);
        
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserId);
        sysUser.setUserInfoId(userId);
        sysUser.setUserType(SysUserTypeEnum.ARBITRATOR.getValue());
        sysUser.setUserName(formData.getPhone());
        sysUser.setUserPwd(PwdUtil.getPwd(password));
        sysUser.setStatus(0);
        try {
        	String ip = InetAddress.getLocalHost().toString();
        	ip = ip.substring(ip.indexOf("/")+1);
			sysUser.setRegisterIp(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        sysUser.setHeadphoto(formData.getHeadphoto());
        sysUser.setLoginType(0);
        sysUser.setRealAuth(0);
        sysUser.setBelocked(0);
        sysUser.setCreateId(formData.getCreaterId());
        sysUser.setCreateTime(new Date());
        sysUser.setDeletedFlag(0);
        int j = sysUserMapper.insertSelective(sysUser);
        
        ArbitratorInfo arbitratorInfo = new ArbitratorInfo();
        arbitratorInfo.setId(arbitratorInfoId);
        arbitratorInfo.setUserId(userId);
        arbitratorInfo.setBirthday(formData.getBirthday());
        arbitratorInfo.setVocation(formData.getVocation());
        arbitratorInfo.setSpecialty(formData.getSpecialty());
        arbitratorInfo.setAddress(formData.getAddress());
        arbitratorInfo.setCreaterId(formData.getCreaterId());
        Date date = new Date();
        arbitratorInfo.setCreateDate(new SimpleDateFormat("yyyyMMdd").format(date));
        arbitratorInfo.setCreateTime(new SimpleDateFormat("HHmmss").format(date));
        arbitratorInfo.setHeadPhoto(formData.getHeadphoto());
        int k = arbitratorInfoMapper.insertSelective(arbitratorInfo);
        
        if (i>0 && j>0 && k>0) {
        	return true;
		}
        return false;
	}
	
}
