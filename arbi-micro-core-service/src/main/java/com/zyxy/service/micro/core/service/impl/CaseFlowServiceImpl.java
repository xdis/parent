package com.zyxy.service.micro.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.dto.flow.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.service.micro.core.service.CaseFlowService;
import com.zyxy.service.micro.core.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CaseFlowServiceImpl implements CaseFlowService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;

    @Autowired
    private MicroThirdService microThirdService;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;

    @Autowired
    private WorkDayService workDayService;

    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;

    @Autowired
    private com.zyxy.common.service.CaseFlowService caseFlowService;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public BusiValidResult caseAuditBusiValid(CaseAuditDTO formData) {
        //该案件是否存在
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
        if (caseInfo == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
        }
        //是否在立案审核状态
        if (!CaseMainNodeEnum.CASE_CHECK.getCode().equals(caseInfo.getCurrentMainNode())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_CHECK_NODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseAuditBusiExecute(CaseAuditDTO formData) {
        CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
        requestInfoExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectByExample(requestInfoExample);
        CaseRequestInfo requestInfo = caseRequestInfos.get(0);
        //修改主流程状态,流动到代缴费状态
        CaseInfo caseInfo = new CaseInfo();
        if ("0".equals(formData.getResult())) {
            caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_PAY.getCode());
        } else {
            caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_CHECK_NOT_PASS.getCode());
        }
        CaseInfoExample example = new CaseInfoExample();
        example.createCriteria().andIdEqualTo(formData.getCaseId());
        caseInfoMapper.updateByExampleSelective(caseInfo, example);
        //修改前节点流动记录
        CaseNodeOper oldCaseNodeOper = new CaseNodeOper();
        oldCaseNodeOper.setRealEndTime(new Date());
        oldCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample updateOldCaseNodeOperRecord = new CaseNodeOperExample();
        updateOldCaseNodeOperRecord.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_CHECK.getCode());
        caseNodeOperMapper.updateByExampleSelective(oldCaseNodeOper, updateOldCaseNodeOperRecord);

        //添加节点流动记录
        CaseNodeOper newCaseNodeOper = new CaseNodeOper();
        newCaseNodeOper.setCaseId(formData.getCaseId());
        newCaseNodeOper.setCreaterId(formData.getUserId());
        newCaseNodeOper.setCreateTime(new Date());
        newCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
        newCaseNodeOper.setId(sequenceService.getCommonID());
        newCaseNodeOper.setRequestId(requestInfo.getId());
        if ("0".equals(formData.getResult())) {
            /*
             * todo:生成缴费信息
             */
            List<PayInfoDTO.PayItem> payItems = new ArrayList<>();
            PayInfoDTO.PayItem payItem = new PayInfoDTO.PayItem();
            payItem.setItemNo("103045501108");
            payItem.setPrice(new BigDecimal("0.01"));
            payItem.setQuantity(1);
            payItems.add(payItem);
            PayInfoDTO payInfoDTO = new PayInfoDTO(payItems);
            payInfoDTO.setBuzzId(requestInfo.getId());
            //缴费人错误
            UserInfo userInfo = userInfoMapper.queryProposerUserInfoByCaseId(formData.getCaseId());
            payInfoDTO.setPayerName(userInfo.getName());
            payInfoDTO.setRemark("立案申请缴费");
            payInfoDTO.setUserId(userInfo.getId());
            log.info("================================================payInfo:" + JSONObject.toJSONString(payInfoDTO));
            ApiResultVO<String> stringApiResultVO = microThirdService.genPayNote(payInfoDTO);
            if (!stringApiResultVO.getHead().getRetCode().equals(ApiResultVO.Coder.SUCCESS.getCode())) {
                log.error("调用生成缴费信息接口失败,接口返回信息:{}", JSONObject.toJSONString(stringApiResultVO));
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CALL_SERV_ERROR);
            }

            String payId = stringApiResultVO.getBody();
            //改变请求支付Id
            CaseRequestInfoWithBLOBs changePayId = new CaseRequestInfoWithBLOBs();
            changePayId.setPayId(payId);
            changePayId.setId(requestInfo.getId());
            CaseTimeSet caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PAY.getValue());
            Date payEndTime = workDayService.after(caseTimeSet.getTimeSet(), false);
            changePayId.setPayEndTime(payEndTime);
            caseRequestInfoMapper.updateByPrimaryKeySelective(changePayId);
            newCaseNodeOper.setBussId(payId);
            newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_PAY.getCode());
            newCaseNodeOper.setOperRecord("审核通过，进入代缴费");
            //计划结束时间
            newCaseNodeOper.setPlanEndTime(payEndTime);
            newCaseNodeOper.setStartTime(new Date());
        } else {
            newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_CHECK_NOT_PASS.getCode());
            newCaseNodeOper.setOperRecord("审核不通过");
            newCaseNodeOper.setPlanEndTime(new Date());
            newCaseNodeOper.setRealEndTime(new Date());
            newCaseNodeOper.setStartTime(new Date());
        }
        caseNodeOperMapper.insertSelective(newCaseNodeOper);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult casePayBusiValid(CasePayDTO formData) {
        //该案件是否存在
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
        if (caseInfo == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
        }
        //是否在代缴费状态
        if (!CaseMainNodeEnum.CASE_PAY.getCode().equals(caseInfo.getCurrentMainNode())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_PAY_NODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult casePayBusiExecute(CasePayDTO formData) {
        CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
        requestInfoExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectByExample(requestInfoExample);
        CaseRequestInfo requestInfo = caseRequestInfos.get(0);
        //修改主流程状态
        CaseInfo caseInfo = new CaseInfo();
        if ("0".equals(formData.getResult())) {
            caseInfo.setCaseNo(sequenceService.getCaseNo(caseInfo.getId()));
            caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_REPLY.getCode());
        } else {
            caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_FAIL.getCode());
        }
        CaseInfoExample example = new CaseInfoExample();
        example.createCriteria().andIdEqualTo(formData.getCaseId());
        caseInfoMapper.updateByExampleSelective(caseInfo, example);
        //修改前节点流动记录
        CaseNodeOper oldCaseNodeOper = new CaseNodeOper();
        Date nowTime = new Date();
        oldCaseNodeOper.setRealEndTime(nowTime);
        oldCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample updateOldCaseNodeOperRecord = new CaseNodeOperExample();
        updateOldCaseNodeOperRecord.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PAY.getCode());
        caseNodeOperMapper.updateByExampleSelective(oldCaseNodeOper, updateOldCaseNodeOperRecord);

        //添加节点流动记录
        CaseNodeOper newCaseNodeOper = new CaseNodeOper();
        newCaseNodeOper.setCaseId(formData.getCaseId());
        newCaseNodeOper.setCreaterId(formData.getUserId());
        newCaseNodeOper.setCreateTime(nowTime);
        newCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
        newCaseNodeOper.setId(sequenceService.getCommonID());
        newCaseNodeOper.setRequestId(requestInfo.getId());
        if ("0".equals(formData.getResult())) {
            newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_REPLY.getCode());
            newCaseNodeOper.setOperRecord("缴费成功，进入答辩期");
            //计划结束时间
            CaseTimeSet caseTimeSet;
            if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_LOWER.getValue());
            } else {
                caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_UPPER.getValue());
            }
            newCaseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet()));
            newCaseNodeOper.setStartTime(nowTime);
            //加入答辩时间表
            CaseReplyTimeRecord caseReplyTimeRecord = new CaseReplyTimeRecord();
            caseReplyTimeRecord.setBusiId(requestInfo.getId());
            caseReplyTimeRecord.setDelayFlag(CaseReplyTimeRecordDelayFLagEnum.NO.getValue());
            caseReplyTimeRecord.setEndTime(workDayService.after(caseTimeSet.getTimeSet()));
            caseReplyTimeRecord.setId(sequenceService.getCommonID());
            caseReplyTimeRecord.setRequestType(RequestTypeEnum.REQUEST.getValue());
            caseReplyTimeRecord.setStartTime(nowTime);
            caseReplyTimeRecord.setType(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
            caseReplyTimeRecord.setCaseId(formData.getCaseId());
            caseReplyTimeRecordMapper.insertSelective(caseReplyTimeRecord);
            //分配仲裁秘书
            caseManagerMapper.allotManagerPeopleByCaseAndType(caseInfo.getId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        } else {
            //请求接口
            microThirdService.cancleOrder(requestInfo.getPayId());
            newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_FAIL.getCode());
            newCaseNodeOper.setOperRecord("缴费超时，立案失败");
            newCaseNodeOper.setPlanEndTime(nowTime);
            newCaseNodeOper.setRealEndTime(nowTime);
            newCaseNodeOper.setStartTime(nowTime);
        }
        caseNodeOperMapper.insertSelective(newCaseNodeOper);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseCompromiseExitBusiValid(String caseId) {
        //该案件是否存在
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
        if (caseInfo == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
        }
        //是否在答辩状态
        if (CaseMainNodeEnum.CASE_REPLY.getCode().equals(caseInfo.getCurrentMainNode())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_REPLY_NODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseCompromiseExitBusiExecute(String caseId) {
        //加时间


        //进入审理流程
        CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
        requestInfoExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        CaseRequestInfo requestInfo = caseRequestInfoMapper.selectByExample(requestInfoExample).get(0);
        //跳主节点
        //修改主流程状态
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_PROCESSING.getCode());
        CaseInfoExample example = new CaseInfoExample();
        example.createCriteria().andIdEqualTo(caseId);
        caseInfoMapper.updateByExampleSelective(caseInfo, example);
        //修改前节点流动记录
        CaseNodeOper oldCaseNodeOper = new CaseNodeOper();
        Date nowTime = new Date();
        oldCaseNodeOper.setRealEndTime(nowTime);
        oldCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample updateOldCaseNodeOperRecord = new CaseNodeOperExample();
        updateOldCaseNodeOperRecord.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_REPLY.getCode());
        caseNodeOperMapper.updateByExampleSelective(oldCaseNodeOper, updateOldCaseNodeOperRecord);
        //插入操作记录
        CaseNodeOper caseNodeOper = new CaseNodeOper();
        caseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
        caseNodeOper.setStartTime(new Date());
        //计划结束时间
        CaseTimeSet caseTimeSet;
        if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
            caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_LOWER.getValue());
        } else {
            caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_UPPER.getValue());
        }
        caseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet()));
        caseNodeOper.setOperRecord("中途放弃和解，进入审理期");
        caseNodeOper.setNodeId(CaseMainNodeEnum.CASE_PROCESSING.getCode());
        caseNodeOper.setId(sequenceService.getCommonID());
        caseNodeOper.setCreateTime(new Date());
        caseNodeOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
        caseNodeOper.setCaseId(caseId);
        caseNodeOperMapper.insertSelective(caseNodeOper);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseOverBusiValid(CaseOverDTO formData) {
        //该案件是否存在
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
        if (caseInfo == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
        }
        String result = formData.getResult();

        if ("0".equals(result)) {
            //0- 双方撤案
            if (CaseMainNodeEnum.CASE_OVER.getCode().equals(caseInfo.getCurrentMainNode())
                    || CaseMainNodeEnum.CASE_OFFSET.getCode().equals(caseInfo.getCurrentMainNode())) {
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
            }
        } else if ("1".equals(result)) {
            //1- 下达裁决书
            if (CaseMainNodeEnum.CASE_PROCESSING.getCode().equals(caseInfo.getCurrentMainNode())) {
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
            }
        } else if ("2".equals(result)) {
            //2- 案件转线下

        } else if ("3".equals(result)) {
            //3- 下达调解书

        } else {
            //请求类型错误
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseOverBusiExecute(CaseOverDTO formData) {
        boolean flag = caseFlowService.caseOver(formData);
        if (flag) {
            return BusiExecuteResult.builderSuccessResult();
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }

    @Override
    public BusiValidResult compromiseOverBusiValid(CaseCompromiseOverDTO formData) {
        //是否在和解中
        CompromiseApply compromiseApply = new CompromiseApply();
        compromiseApply.setCaseId(formData.getCaseId());
        compromiseApply = compromiseApplyMapper.selectCompromiseByCaseId(compromiseApply);
        if (compromiseApply == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        if (!ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApply.getStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult compromiseOverBusiExecute(CaseCompromiseOverDTO formData) {
        boolean flag = caseFlowService.compromiseOver(formData.getCaseId());
        if (flag) {
            return BusiExecuteResult.builderSuccessResult();
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }

    @Override
    public BusiValidResult giveReplyBusiValid(CaseGiveReplyDTO formData) {
        LitigantTypeEnum litigantTypeEnum = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        if (litigantTypeEnum == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.USERID_NO_PRIVILEGE);
        }
        //是否已选仲裁员
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
        //查询出答辩期
        CaseReplyTimeRecordExample example = new CaseReplyTimeRecordExample();
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(type)
                .andTypeEqualTo(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
        List<CaseReplyTimeRecord> caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(example);
        if (caseReplyTimeRecords == null || caseReplyTimeRecords.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        if (caseReplyTimeRecords.get(0).getEndTime().compareTo(new Date()) < 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult giveReplyBusiExecute(CaseGiveReplyDTO formData) {
        LitigantTypeEnum litigantTypeEnum = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        //是否已选仲裁员
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
        boolean flag = caseFlowService.giveReply(formData.getCaseId(), type);
        if (flag) {
            return BusiExecuteResult.builderSuccessResult();
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }

    @Override
    public BusiValidResult cancelCaseBusiValid(CaseCancelDTO formData) {
        //是否在正常状态
        CaseRequestInfo caseRequestInfo = new CaseRequestInfo();
        caseRequestInfo.setCaseId(formData.getCaseId());
        caseRequestInfo.setRequestType(formData.getRequestType());
        caseRequestInfo = caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);
        String status = caseRequestInfo.getStatus();
        if (!CaseRequestInfoStatusEnum.NORMAL.getValue().equals(status)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult cancelCaseBusiExecute(CaseCancelDTO formData) {
        boolean flag = caseFlowService.cancelCase(formData);
        if (flag) {
            return BusiExecuteResult.builderSuccessResult();
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }
}
