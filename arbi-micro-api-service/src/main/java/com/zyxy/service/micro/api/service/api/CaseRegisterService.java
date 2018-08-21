package com.zyxy.service.micro.api.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.LitigantInfoExample;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.dto.RegisterCaseDTO;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.util.BeanUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqCaseRegisterDTO;
import com.zyxy.service.micro.api.dto.ResCaseRegisterDTO;
import com.zyxy.service.micro.api.service.micro.PublicCaseService;

/**
 * 用户单点登录（SSO）token获取
 * @author tanquan
 */
@Service
public class CaseRegisterService extends BaseService<ReqCaseRegisterDTO, ResCaseRegisterDTO>{
    
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private PublicCaseService microPublicCaseService;
    
    @Override
    protected  BuzzResultVO<ResCaseRegisterDTO> doBuzz(ReqCaseRegisterDTO dto, String currentIp) {
        // 验证代理人是否注册并实名认证
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getAgentUserId());
        if (dbUser == null) {
            return super.error("当前代理未注册");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该代理");
        }
        if (dbUser.getRealAuth() != 1) {
            return super.error("当前代理未通过实名认证");
        }
        // 验证申请人是否注册并实名认证
        LitigantInfoExample liEx = new LitigantInfoExample();
        liEx.createCriteria().andCardIdEqualTo(dto.getApplicantCardId());
        List<LitigantInfo> liList = litigantInfoMapper.selectByExample(liEx);
        if (liList == null || liList.isEmpty()) {
            return super.error("案件申请人未注册");
        }
        SysUserExample suEx = new SysUserExample();
        suEx.createCriteria().andUserInfoIdEqualTo(liList.get(0).getUserId());
        List<SysUser> suList = sysUserMapper.selectByExample(suEx);
        if (suList == null || suList.isEmpty()) {
            return super.error("案件申请人未注册");
        }
        if (suList.get(0).getRealAuth() != 1) {
            return super.error("案件申请人未实名认证");
        }
        // 发布案件
        RegisterCaseDTO caseApplyDTO = new RegisterCaseDTO();
        BeanUtil.copyProperties(dto, caseApplyDTO);
        caseApplyDTO.setUserId(dbUser.getUserInfoId());
        caseApplyDTO.setFilingType("1"); // 代理立案
        caseApplyDTO.setSourceOrgId(dto.getOrgNo());
        ApiResultVO<String> apiRet = microPublicCaseService.caseApply(caseApplyDTO);
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        ResCaseRegisterDTO resDTO = new ResCaseRegisterDTO();
        resDTO.setCaseId(apiRet.getBody());
        return super.success(resDTO);
    }
    
}

