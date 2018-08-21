package com.zyxy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.PersonalCenterService;
import com.zyxy.admin.util.PwdUtil;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 立案审核页面
 */
@Service
public class PersonalCenterServiceImpl implements PersonalCenterService{
	
    @Autowired
    private SysUserMapper sysUserMapper;
    

    
  

    /**
     * 修改密码业务验证
     * @param formData 用户DTO
     * @return 返回是否通过业务验证
     */
    @Override
    public BusiValidResult sysUserPwdBusiValid(SysUserPwdDTO formData) {
    	SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserInfoIdEqualTo(formData.getUserId());
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);
        
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        //验证原密码是否有误
        boolean results=bCryptPasswordEncoder.matches(formData.getUserPwd(),sysUserList.get(0).getUserPwd());
    	
        if(!results){
        	 //原密码输入有误
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.OLD_PASS_WORD_ERROR);
        }
       
        //原密码输入正确
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 修改密码业务处理
     *
     * @param formData 用户DTO
     * @return 返回是否成功处理业务
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public BusiExecuteResult sysUserPwdBusiExecute(SysUserPwdDTO formData) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserInfoIdEqualTo(formData.getUserId());
        SysUser sysUser = new SysUser();
        sysUser.setUserPwd(PwdUtil.getPwd(formData.getNewUserPwd()));
        int lows = sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
        if (lows > 0) {
            //密码修改成功
            return BusiExecuteResult.builderSuccessResult();
        } else {
            //密码修改失败
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }


    }
	

}
