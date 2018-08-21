package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.LivenessTokenVO;
import com.zyxy.service.micro.api.dto.ReqLivenessTokenDTO;
import com.zyxy.service.micro.api.dto.ResLivenessTokenDTO;
import com.zyxy.service.micro.api.service.micro.SysUserService;

/**
 * 用户单点登录（SSO）token获取
 * @author tanquan
 */
@Service
public class UserLivenessTokenService extends BaseService<ReqLivenessTokenDTO, ResLivenessTokenDTO>{
    
    @Autowired
    private SysUserService microSysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CacheService cacheService;
    
    @Override
    protected  BuzzResultVO<ResLivenessTokenDTO> doBuzz(ReqLivenessTokenDTO dto, String currentIp) {
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getUserID());
        if (dbUser == null) {
            return super.error("userID不存在");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该userID");
        }
        ApiResultVO<LivenessTokenVO> apiRet = microSysUserService.livenessToken(dbUser.getUserInfoId(), dto.getReturnURL());
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        ResLivenessTokenDTO resDTO = new ResLivenessTokenDTO();
        resDTO.setToken(apiRet.getBody().getToken());
        resDTO.setUrl(apiRet.getBody().getUrl() + "?token=" + resDTO.getToken());
        return super.success(resDTO);
    }
    
}

