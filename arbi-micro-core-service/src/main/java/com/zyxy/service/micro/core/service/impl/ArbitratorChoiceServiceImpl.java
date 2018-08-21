package com.zyxy.service.micro.core.service.impl;

import com.zyxy.common.domain.*;
import com.zyxy.common.dto.CaseArbitratorOprInsertDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseArbitratorService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ArbitratorAvoidRecordVO;
import com.zyxy.common.vo.LitigantCaseInfoValidVO;
import com.zyxy.service.micro.core.service.ArbitratorChoiceService;
import com.zyxy.service.micro.core.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 当事人选择仲裁员实现类
 */
@Service
public class ArbitratorChoiceServiceImpl implements ArbitratorChoiceService {

    private static final Logger logger = LoggerFactory.getLogger(ArbitratorChoiceServiceImpl.class);

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private ArbitratorInfoMapper arbitratorInfoMapper;

    @Autowired
    private CaseArbitratorOperMapper caseArbitratorOperMapper;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseAvoidRecordMapper caseAvoidRecordMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private CaseArbitratorService caseArbitratorService;

    @Override
    public BusiValidResult arbitratorChoiceBusiValid(
            CaseArbitratorOprInsertDTO formData) {

        //案件存是否存在
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());

        if (caseInfo == null) {
            return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
        }
        //仲裁员是否存在
        if (SysRecommendFlagEnum.SELF_CHOICE.getValue().equals(formData.getIsSysRecom())) {
            ArbitratorInfoExample arbitratorInfo = new ArbitratorInfoExample();
            arbitratorInfo.
                    createCriteria().
                    andUserIdEqualTo(formData.getArbitratorId());
            List<ArbitratorInfo> arbitratorInfos = arbitratorInfoMapper.selectByExample(arbitratorInfo);
            if (arbitratorInfos.size() == 0) {
                return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_NOT_EXIST);
            }
        }
        LitigantTypeEnum litigantTypeEnum = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        if (litigantTypeEnum == null) {
            return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
        }
        //是否已选仲裁员
        CaseArbitratorOperExample caseArbitratorOperExample = new CaseArbitratorOperExample();
        String type = "";
        switch (litigantTypeEnum) {
            case PROPESER:
                type = "0";
                break;
            case PROPESER_AGENT:
                type = "0";
                break;
            case DEFENDANT_AGENT:
                type = "1";
                break;
            case DEFENDANT:
                type = "1";
                break;
            default:
                break;
        }
        caseArbitratorOperExample.
                createCriteria().
                andCaseIdEqualTo(formData.getCaseId()).
                andTypeEqualTo(type);
        List<CaseArbitratorOper> arbitratorOpers = caseArbitratorOperMapper.selectByExample(caseArbitratorOperExample);
        if (arbitratorOpers.size() > 0) {
            return BusiValidResult.builderErrorResult(Coder.CASE_ALREADY_HAS_ARBITRATOR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<String> arbitratorChoiceBusiExecute(
            CaseArbitratorOprInsertDTO formData) {
        CaseArbitratorOper caseArbitratorOper = new CaseArbitratorOper();
        caseArbitratorOper.setCaseId(formData.getCaseId());
        LitigantTypeEnum litigantTypeEnum = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        String type = "";
        switch (litigantTypeEnum) {
            case PROPESER:
                type = "0";
                break;
            case PROPESER_AGENT:
                type = "0";
                break;
            case DEFENDANT_AGENT:
                type = "1";
                break;
            case DEFENDANT:
                type = "1";
                break;
            default:
                break;
        }
        caseArbitratorOper.setType(type);
        caseArbitratorOper.setCreaterId(formData.getUserId());
        caseArbitratorOper.setCreateTime(new Date());
        int rows = 0;
        //系统推荐
        if (SysRecommendFlagEnum.SYS_RECOMMEND.getValue().equals(formData.getIsSysRecom())) {
            rows = caseArbitratorMapper.insertCaseArbiOper(caseArbitratorOper);
        }
        //自己选择
        else if (SysRecommendFlagEnum.SELF_CHOICE.getValue().equals(formData.getIsSysRecom())) {
            caseArbitratorOper.setArbitratorId(formData.getArbitratorId());
            rows = caseArbitratorOperMapper.insert(caseArbitratorOper);
        }

        //对方是否已选择
        List<String> inTypes = new ArrayList<>();
        //todo:枚举类
        inTypes.add("0");
        inTypes.add("1");
        CaseArbitratorOperExample example = new CaseArbitratorOperExample();
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andTypeIn(inTypes);
        List<CaseArbitratorOper> caseArbitratorOpers = caseArbitratorOperMapper.selectByExample(example);
        if (caseArbitratorOpers != null && caseArbitratorOpers.size() > 1) {
            //分配仲裁员
            //双方选择是否一致
            boolean flag = true;
            String oldArbitratorId = caseArbitratorOpers.get(0).getArbitratorId();
            for (CaseArbitratorOper arbitratorOper : caseArbitratorOpers) {
                if (!oldArbitratorId.equals(arbitratorOper.getArbitratorId())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                //不一致
                caseArbitratorService.allotArbitrator(formData.getCaseId());
            } else {
                //一致
                caseArbitratorService.insertCaseArbitrator(formData.getCaseId(), oldArbitratorId, CaseArbitratorTypeEnum.PARTY_SELECTED);
            }
        }

        if (rows < 1) {
            BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult arbitratorAvoidListValid(String caseId, String userId) {
    	BusiValidResult busiValidResult = commonService.commonCaseAndUserValid(caseId, userId);
        if (busiValidResult.hasError()) {
			return BusiValidResult.builderErrorResult(busiValidResult.getCode(), busiValidResult.getMsg());
		}
    	return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<List<ArbitratorAvoidRecordVO>> arbitratorAvoidListExecute(
            String caseId) {
        List<ArbitratorAvoidRecordVO> list = caseAvoidRecordMapper.selectArbitratorAvoidList(caseId);
      
        return BusiExecuteResult.builderSuccessResult(list);
    }

}
