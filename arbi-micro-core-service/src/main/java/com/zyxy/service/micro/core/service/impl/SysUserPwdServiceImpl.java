package com.zyxy.service.micro.core.service.impl;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.service.micro.core.service.SysUserPwdService;
import com.zyxy.service.micro.core.util.PwdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户密码相关服务
 */
@Service
public class SysUserPwdServiceImpl implements SysUserPwdService {

    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 修改密码业务验证
     *
     * @param formData 用户DTO
     * @return 返回是否通过业务验证
     */
    @Override
    public BusiValidResult sysUserPwdBusiValid(SysUserPwdDTO formData) {
        //将获得的密码进行加密
        String md5UserPwd = PwdUtil.getPwd(formData.getUserPwd());
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample
                .createCriteria()
                .andUserInfoIdEqualTo(formData.getUserId())
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

    /**
     * 修改密码业务处理
     *
     * @param formData 用户DTO
     * @return 返回是否成功处理业务
     */
    @Override
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
