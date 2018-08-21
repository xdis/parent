package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.AuthorizationDelegate;
import com.zyxy.common.domain.AuthorizationDelegateExample;
import com.zyxy.common.domain.CaseManager;
import com.zyxy.common.domain.CaseManagerExample;
import com.zyxy.common.dto.CaseManagerDTO;
import com.zyxy.common.enums.AuthorizationDelegateStatusEnum;
import com.zyxy.common.enums.AuthorizationTypeEnum;
import com.zyxy.common.enums.AuthorizationWithCaseRelationEnum;
import com.zyxy.common.enums.CaseManagerStatusEnum;
import com.zyxy.common.mapper.AuthorizationDelegateMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorCaseBaseInfoVO;
import com.zyxy.common.vo.AuthorizationDelegateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仲裁委案件关系serviceImpl
 */
@Service
public class CaseManagerServiceImpl implements CaseManagerService {

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    CaseInfoMapper caseInfoMapper;

    @Autowired
    private AuthorizationDelegateMapper authorizationDelegateMapper;

    /**
     * 业务验证
     * @param caseId
     * @param userId
     * @return
     */
    @Override
    public BusiValidResult caseRequestInfoBusiValid(String caseId, String userId) {
        CaseManager caseManager = this.queryCaseNowManagerByCaseId(caseId, userId);
        if(caseManager==null){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 业务处理，查询案件详情信息
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @param requestFlag
     * @return
     */
    @Override
    public BusiExecuteResult<ArbitratorCaseBaseInfoVO> caseBaseInfoBusiExecute(String caseId, String userId, String requestFlag) {
        return BusiExecuteResult.builderSuccessResult(caseInfoMapper.queryCaseBaseInfo(caseId, requestFlag));
    }

    /**
     * 查询授权情况
     * @param caseId
     * @param userId
     * @param approveType
     * @return
     */
    @Override
    public AuthorizationDelegateVO queryAuthorizationDelegateDuties(String caseId, String userId, String approveType) {
        AuthorizationDelegateVO authorizationDelegateVO = new AuthorizationDelegateVO();

        //是否被授权
        boolean beAuthorization=false;
        //查询出是否被授权
        AuthorizationDelegateExample authorizationDelegateExample = new AuthorizationDelegateExample();
        authorizationDelegateExample.createCriteria().andAgentUserIdEqualTo(userId).andStatusEqualTo(AuthorizationDelegateStatusEnum.EFFECTIVE.getCode()).andAuthTypeEqualTo(approveType);
        List<AuthorizationDelegate> authorizationDelegateList = authorizationDelegateMapper.selectByExample(authorizationDelegateExample);
        if(authorizationDelegateList.size()>0){
            beAuthorization = true;
        }

        //被授权情况
        if(beAuthorization){
            //查询出授权方是否是该案件的负责人
            boolean b = this.queryCaseManagerInfo(caseId, authorizationDelegateList.get(0).getUserId());
            if(b){
                authorizationDelegateVO.setAuthorizationType(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode());
                authorizationDelegateVO.setAuthorizationDuties(caseInfoMapper.queryDutiesById(authorizationDelegateList.get(0).getUserId()));
                authorizationDelegateVO.setAuthorizationUserId(authorizationDelegateList.get(0).getUserId());
            }

            //查询出被授权方是否是该案件的负责人
            boolean flag = this.queryCaseManagerInfo(caseId, authorizationDelegateList.get(0).getAgentUserId());
            if(flag){
                authorizationDelegateVO.setBeAuthorizationWithCaseRelation(AuthorizationWithCaseRelationEnum.HAVE_RELATION.getCode());
            }else{
                authorizationDelegateVO.setBeAuthorizationWithCaseRelation(AuthorizationWithCaseRelationEnum.NOT_RELATION.getCode());
            }

            return authorizationDelegateVO;
        }


        //是否授权
        boolean authorization=false;
        //查询出是否授权
        authorizationDelegateExample = new AuthorizationDelegateExample();
        authorizationDelegateExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(AuthorizationDelegateStatusEnum.EFFECTIVE.getCode()).andAuthTypeEqualTo(approveType);
        List<AuthorizationDelegate> authorizationDelegates= authorizationDelegateMapper.selectByExample(authorizationDelegateExample);
        if(authorizationDelegates.size()>0){
            authorization=true;
        }

        //授权情况
        if(authorization){
            //查询出授权方是否是该案件的负责人
            boolean b = this.queryCaseManagerInfo(caseId, userId);
            if(b){
                authorizationDelegateVO.setAuthorizationType(AuthorizationTypeEnum.AUTHORIZATION_PARTY.getCode());
                authorizationDelegateVO.setAuthorizationDuties(caseInfoMapper.queryDutiesById(userId));
                authorizationDelegateVO.setAuthorizationUserId(userId);
            }
        }

        return authorizationDelegateVO;
    }


    /**
     * 根据案件id和用户id查询出该案件是否属于该仲裁委工作人员
     * @param caseId
     * @param userId
     * @return
     */
    public boolean queryCaseManagerInfo(String caseId,String userId){
        CaseManagerExample example = new CaseManagerExample();
        example.createCriteria().andManagerIdEqualTo(userId).andCaseIdEqualTo(caseId);
        List<CaseManager> caseManagerList = caseManagerMapper.selectByExample(example);
        if(caseManagerList.size()<=0){
            return false;
        }
        return true;
    }

    /*************私有service********
     * 根据仲裁委id和案件查询是否有这个案件，并且查询出该仲裁委是否已经回避
     */
    private CaseManager queryCaseNowManagerByCaseId(String caseId,String userId){
        CaseManagerDTO caseManagerDTO=new CaseManagerDTO();
        caseManagerDTO.setId(userId);
        caseManagerDTO.setCaseId(caseId);
        caseManagerDTO.setStatus(CaseManagerStatusEnum.OK.getCode());
        List<CaseManager> caseManagerList = caseManagerMapper.queryCaseNowManager(caseManagerDTO);
        if(caseManagerList.size()<=0){
            return null;
        }
        return caseManagerList.get(0);
    }



}
