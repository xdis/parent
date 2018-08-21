package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.CaseCommProgressInfoVO;
import com.zyxy.service.micro.api.dto.ReqCaseCommonDTO;
import com.zyxy.service.micro.api.dto.ResCaseStatusDTO;

/**
 * 案件 状态查询
 * @author tanquan
 */
@Service
public class CaseStatusService extends BaseService<ReqCaseCommonDTO, ResCaseStatusDTO>{
    
    @Autowired
    private CaseInfoMapper caseInfoMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;
    @Autowired
    private CacheService cacheService;
    
    @Override
    protected  BuzzResultVO<ResCaseStatusDTO> doBuzz(ReqCaseCommonDTO dto, String currentIp) {
        // 验证当前案件是否属于该机构
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(dto.getCaseId());
        if (caseInfo == null) {
            return super.error("案件不存在");
        }
        if (!dto.getOrgNo().equals(caseInfo.getSourceOrgId())) {
            return super.error("操作非法");
        }
        ResCaseStatusDTO resDTO = new ResCaseStatusDTO();
        resDTO.setCurrentMainNode(String.valueOf(caseInfo.getCurrentMainNode()));
        CaseCommProgressInfoVO caseProgress = caseInfoMapper.queryCaseCommProgressInfo(dto.getCaseId());
        resDTO.setCurrentProgress(caseProgress.getCurrentProgress());
        return super.success(resDTO);
    }
    
}

