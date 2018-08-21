package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqUserAuthStatusDTO;
import com.zyxy.service.micro.api.dto.ResUserAuthStatusDTO;

/**
 * 用户认证状态查询
 * @author tanquan
 */
@Service
public class UserAuthStatusService extends BaseService<ReqUserAuthStatusDTO, ResUserAuthStatusDTO>{
    
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CacheService cacheService;
    
    @Override
    protected  BuzzResultVO<ResUserAuthStatusDTO> doBuzz(ReqUserAuthStatusDTO dto, String currentIp) {
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getUserID());
        if (dbUser == null) {
            return super.error("userID不存在");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该userID");
        }
        ResUserAuthStatusDTO resDTO = new ResUserAuthStatusDTO();
        resDTO.setAuthFlag("1".equals(dbUser.getRealAuth()) ?  "1" : "0");
        return super.success(resDTO);
    }
    
}

