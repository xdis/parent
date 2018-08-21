package com.zyxy.common.service;

import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasePeopleService {

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据类型和案件Id查询人员信息
     *
     * @param caseId              案件Id
     * @param managerInfoTypeEnum 仲裁委人员类型枚举
     * @return 人员信息
     */
    public UserInfo getArbitrationPeopleUserInfo(String caseId, ManagerInfoTypeEnum managerInfoTypeEnum) {
        String s = caseManagerMapper.queryNowWorkPeopleIdByType(caseId, managerInfoTypeEnum.getCode());
        return userInfoMapper.selectByPrimaryKey(s);
    }

    /**
     * 根据案件Id查询仲裁员信息
     *
     * @param caseId 案件Id
     * @return 仲裁员信息
     */
    public UserInfo queryArbitratorUserInfo(String caseId) {
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        return userInfoMapper.selectByPrimaryKey(caseArbitrator.getArbitratorId());
    }
}
