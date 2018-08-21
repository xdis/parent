package com.zyxy.service.micro.api.service.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqSSOTokenDTO;
import com.zyxy.service.micro.api.dto.ResSSOTokenDTO;

/**
 * 用户单点登录（SSO）token获取
 * @author tanquan
 */
@Service
public class UserSSOTokenService extends BaseService<ReqSSOTokenDTO, ResSSOTokenDTO>{
    
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CacheService cacheService;
    
    @Override
    protected  BuzzResultVO<ResSSOTokenDTO> doBuzz(ReqSSOTokenDTO dto, String currentIp) {
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getUserID());
        if (dbUser == null) {
            return super.error("userID不存在");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该userID");
        }
        // 生成token，并放入缓存
        String token = UUID.randomUUID().toString().replace("-", "");
        cacheService.addCache(CacheTypeEnum.API_SSO_TOKEN, dto.getUserID(), token);
        ResSSOTokenDTO resDTO = new ResSSOTokenDTO();
        resDTO.setToken(token);
        resDTO.setExpire(CacheTypeEnum.API_SSO_TOKEN.getExpire());
        return super.success(resDTO);
    }
    
}

