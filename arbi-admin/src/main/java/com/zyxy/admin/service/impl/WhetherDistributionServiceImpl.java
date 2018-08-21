package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.domain.CaseManager;
import com.zyxy.common.domain.CaseManagerExample;
import com.zyxy.common.enums.CaseManagerStatusEnum;
import com.zyxy.common.mapper.CaseManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 判断是否分配了仲裁委工作人员的serviceImpl
 */
@Service
public class WhetherDistributionServiceImpl implements WhetherDistributionService {

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    /**
     * 根据案件id，职务，以及有效状态来判断该案件是否分配了仲裁委的工作人员
     * @param caseId
     * @param duties
     * @return
     */
    @Override
    public boolean queryCaseManagerInfo(String caseId, String duties) {
        CaseManagerExample caseManagerExample = new CaseManagerExample();
        caseManagerExample.createCriteria().
                andCaseIdEqualTo(caseId).
                andManagerTypeEqualTo(duties).
                andStatusEqualTo(CaseManagerStatusEnum.OK.getCode());

        List<CaseManager> caseManagerList = caseManagerMapper.selectByExample(caseManagerExample);

        if(caseManagerList.size()<=0){
            return false;
        }
        return true;
    }
}
