package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.dto.BaseDTO;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.service.micro.api.dto.ReqCompanyAccAuthDTO;
import com.zyxy.service.micro.api.dto.ResCompanyAccAuthDTO;
import com.zyxy.service.micro.api.service.micro.SysUserService;

/**
 * 企业认证-对公账户转账信息获取
 * @author tanquan
 */
@Service
public class CompanyAccAuthService extends BaseService<ReqCompanyAccAuthDTO, ResCompanyAccAuthDTO>{

    @Autowired
    private SysUserService microSysUserService;
    @Autowired
    private MicroFileService microFileService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Override
    protected  BuzzResultVO<ResCompanyAccAuthDTO> doBuzz(ReqCompanyAccAuthDTO dto, String currentIp) {
        SysUser dbUser = sysUserMapper.selectByPrimaryKey(dto.getUserID());
        if (dbUser == null) {
            return super.error("userID不存在");
        }
        if (dbUser.getResourceOrgId() == null || !dbUser.getResourceOrgId().equals(dto.getOrgNo())) {
            return super.error("当前orgNo不存在该userID");
        }
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setUserId(dto.getUserID());
        ApiResultVO<EnterpriseAuthStatusVO> apiRet = microSysUserService.enterpriseAuthStatus(baseDTO);
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        EnterpriseAuthStatusVO retBody = apiRet.getBody();
        ResCompanyAccAuthDTO resDTO = new ResCompanyAccAuthDTO();
        resDTO.setAmount(retBody.getAmount());
        resDTO.setPlatAccountBank("中国工商银行珠海市分行");
        resDTO.setPlatAccountName("珠海仲裁委员会过渡户");
        resDTO.setPlatAccountNo("130003488909902328801");
        resDTO.setStatus(retBody.getStatus());
        resDTO.setRemark("珠海仲裁委员会互联网仲裁平台企业认证");
        return super.success(resDTO);
    }
}
