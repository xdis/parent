package com.zyxy.common.service;

import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorApprove;
import com.zyxy.common.domain.CaseArbitratorOper;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseArbitratorApproveMapper;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseArbitratorOperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CaseArbitratorService {

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseArbitratorOperMapper caseArbitratorOperMapper;

    @Autowired
    private CaseArbitratorApproveMapper caseArbitratorApproveMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CaseApproveMapper caseApproveMapper;

    /**
     * 系统分配仲裁员
     *
     * @param caseId 案件Id
     * @return 分配到的仲裁员Id
     */
    public String allotArbitrator(String caseId) {
        //插入选择记录表
        String arbitratorId = caseArbitratorMapper.queryAllotArbitrator(caseId);
        CaseArbitratorOper caseArbitratorOper = new CaseArbitratorOper();
        caseArbitratorOper.setArbitratorId(arbitratorId);
        caseArbitratorOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
        caseArbitratorOper.setCaseId(caseId);
        caseArbitratorOper.setCreateTime(new Date());
        caseArbitratorOper.setType("3");
        caseArbitratorOperMapper.insertSelective(caseArbitratorOper);
        insertCaseArbitrator(caseId, arbitratorId, CaseArbitratorTypeEnum.SYSTEM_ASSIGN);
        return arbitratorId;
    }

    public void insertCaseArbitrator(String caseId, String arbitratorId, CaseArbitratorTypeEnum type) {
//        //插入审核记录表
//        CaseArbitratorApprove caseArbitratorApprove = new CaseArbitratorApprove();
//        caseArbitratorApprove.setArbitratorId(arbitratorId);
//        caseArbitratorApprove.setCaseId(caseId);
//        caseArbitratorApprove.setCreaterId(SysUserEnum.SYSTEM.getValue());
//        caseArbitratorApprove.setCreateTime(new Date());
//        String busiId = sequenceService.getCommonID();
//        caseArbitratorApprove.setId(busiId);
//        //0- 待审核
//        caseArbitratorApprove.setStatus("0");
//        caseArbitratorApprove.setType(type.getCode());
//        caseArbitratorApproveMapper.insertSelective(caseArbitratorApprove);
//
//        //插入审核表
//        CaseApprove approve = new CaseApprove();
//        approve.setApproveType(ApproveTypeEnum.ARBITRATOR_APPROVE.getTypeName());
//        approve.setId(sequenceService.getCommonID());
//        approve.setCaseId(caseId);
//        approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
//        approve.setBusiId(busiId);
//        approve.setCreaterId(SysUserEnum.SYSTEM.getValue());
//        approve.setCreateTime(new Date());
//        caseApproveMapper.insertSelective(approve);

        //插入案件仲裁员表
        CaseArbitrator caseArbitrator = new CaseArbitrator();
        caseArbitrator.setArbitratorId(arbitratorId);
        caseArbitrator.setCaseId(caseId);
        caseArbitrator.setCreateId(SysUserEnum.SYSTEM.getValue());
        caseArbitrator.setCreateTime(new Date());
        caseArbitrator.setStatus(CaseArbitratorStatusEnum.WAIT_ACCEPT.getCode());
        caseArbitrator.setType(type.getCode());
        caseArbitratorMapper.insertSelective(caseArbitrator);
    }
}
