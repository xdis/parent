package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.enums.CaseMainNodeEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.util.BeanUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.PayOrderVO;
import com.zyxy.service.micro.api.dto.ReqCaseCommonDTO;
import com.zyxy.service.micro.api.dto.ResCasePayInfoDTO;
import com.zyxy.service.micro.api.service.micro.LitigantCaseService;

/**
 * 案件 缴费信息查询
 * @author tanquan
 */
@Service
public class CasePayInfoService extends BaseService<ReqCaseCommonDTO, ResCasePayInfoDTO>{
    
    @Autowired
    private CaseInfoMapper caseInfoMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;
    @Autowired
    private LitigantCaseService microLitigantCaseService;
    @Autowired
    private CacheService cacheService;
    
    @Override
    protected  BuzzResultVO<ResCasePayInfoDTO> doBuzz(ReqCaseCommonDTO dto, String currentIp) {
        // 验证当前案件是否属于该机构
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(dto.getCaseId());
        if (caseInfo == null) {
            return super.error("案件不存在");
        }
        if (!dto.getOrgNo().equals(caseInfo.getSourceOrgId())) {
            return super.error("操作非法");
        }
        // 判断当前案件是否处于待缴费或者已缴费
        ResCasePayInfoDTO resDTO = new ResCasePayInfoDTO();
        ApiResultVO<PayOrderVO> apiRet = microLitigantCaseService.payInfo(dto.getCaseId(), caseInfo.getCreaterId());
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        BeanUtil.copyProperties(apiRet.getBody(), resDTO);
        return super.success(resDTO);
    }
    
}

