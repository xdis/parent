package com.zyxy.service.micro.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.*;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.*;
import com.zyxy.service.micro.core.service.ArbitratorCaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 仲裁员案件相关服务
 */
@Service
public class ArbitratorCaseServiceImpl implements ArbitratorCaseService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseMatMapper caseMatMapper;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    @Autowired
    private CaseJurisDisMapper caseJurisDisMapper;

    @Autowired
    private QuizRecordMapper quizRecordMapper;

    @Autowired
    private CompromiseRecordMapper compromiseRecordMapper;

    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;

    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;

    @Autowired
    private CaseFlowService caseFlowService;

    @Autowired
    private WorkDayService workDayService;

    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;

    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private ArgueRecordMapper argueRecordMapper;

    @Autowired
    private CaseNoSeqMapper caseNoSeqMapper;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseApproveMapper caseApproveMapper;

    @Autowired
    private CaseApproveSuggestMapper caseApproveSuggestMapper;

    @Autowired
    private CaseDocMapper caseDocMapper;

    @Autowired
    private CaseDocContentMapper caseDocContentMapper;

    @Autowired
    private CaseArbitralAwardsDraftMapper caseArbitralAwardsDraftMapper;

    @Autowired
    private CaseMediateProcessRecordMapper caseMediateProcessRecordMapper;

    @Autowired
    private WithdrawRecordMapper withdrawRecordMapper;

    //#######################################公共Service####################################################
    @Override
    public BusiExecuteResult<PageInfo<ArbitratorCaseListVO>> queryCaseListBusiExecute(ArbitratorCaseListDTO formData, String arbitratorId) {
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1 || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return BusiExecuteResult.builderSuccessResult(new PageInfo<ArbitratorCaseListVO>(caseInfoMapper.queryCaseList(formData, arbitratorId)));
    }

    /**
     * 受理案件业务验证
     *
     * @param formData 受理案件DTO
     * @return 返回是否通过业务验证
     */
    @Override
    public BusiValidResult acceptCaseBusiValid(ArbitratorCaseAcceptDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }

        //该案件是否在待受理状态
        if (!CaseArbitratorStatusEnum.WAIT_ACCEPT.getCode().equals(caseArbitrator.getStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 业务处理
     *
     * @param formData 受理案件DTO
     * @return 返回是否成功处理业务
     */
    @Override
    public BusiExecuteResult acceptCaseBusiExecute(ArbitratorCaseAcceptDTO formData) {
        CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
        caseArbitratorExample
                .createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andArbitratorIdEqualTo(formData.getUserId())
                .andStatusEqualTo(CaseArbitratorStatusEnum.WAIT_ACCEPT.getCode());
        CaseArbitrator caseArbitrator = new CaseArbitrator();
        if ("0".equals(formData.getStatus())) {
            //修改接受状态为有效
            caseArbitrator.setStatus(CaseArbitratorStatusEnum.OK.getCode());
            int lows = caseArbitratorMapper.updateByExampleSelective(caseArbitrator, caseArbitratorExample);
            CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
            CaseReplyTimeRecordExample requestReplyTime = new CaseReplyTimeRecordExample();
            requestReplyTime.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
            List<CaseReplyTimeRecord> caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(requestReplyTime);
            //本请求答辩期是否结束
            boolean caseReplyTimeOver = !caseReplyTimeRecords.isEmpty() && caseReplyTimeRecords.get(0).getEndTime().compareTo(new Date()) < 0;
            if (!(lows > 0)) {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR);
            }
            if (CaseMainNodeEnum.CASE_REPLY.getCode().equals(caseInfo.getCurrentMainNode()) && caseReplyTimeOver) {
                //todo:和解期
                caseFlowService.replyToProcess(formData.getCaseId(), ReplyToProcessRemarkEnum.CASE_REPLY_OVER, true);
            } else if (CaseMainNodeEnum.CASE_PROCESSING.getCode().equals(caseInfo.getCurrentMainNode())) {
                //重新计算审限期
                CaseNodeOper caseNodeOper = new CaseNodeOper();
                //计划结束时间
                CaseTimeSet caseTimeSet;
                CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
                requestInfoExample.createCriteria()
                        .andCaseIdEqualTo(formData.getCaseId())
                        .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
                CaseRequestInfo requestInfo = caseRequestInfoMapper.selectByExample(requestInfoExample).get(0);
                if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_LOWER.getValue());
                } else {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_UPPER.getValue());
                }
                caseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet()));

                CaseNodeOperExample nodeOperExample = new CaseNodeOperExample();
                nodeOperExample.createCriteria()
                        .andCaseIdEqualTo(formData.getCaseId())
                        .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PROCESSING.getCode());
                caseNodeOperMapper.updateByExampleSelective(caseNodeOper, nodeOperExample);
                caseFlowService.sendGroupNotice(formData.getCaseId());
            }
        } else {
            //修改接受状态为不受理
            caseArbitrator.setStatus(CaseArbitratorStatusEnum.NOT_ACCEPT.getCode());
            int lows = caseArbitratorMapper.updateByExampleSelective(caseArbitrator, caseArbitratorExample);
            if (lows > 0) {
                //重新分配仲裁员
                caseArbitratorMapper.allotArbitrator(formData.getCaseId());
            } else {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR);
            }
        }
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseBaseInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<ArbitratorCaseBaseInfoVO> caseBaseInfoBusiExecute(String caseId, String userId, String requestFlag) {
        return BusiExecuteResult.builderSuccessResult(caseInfoMapper.queryCaseBaseInfo(caseId, requestFlag));
    }

    @Override
    public BusiValidResult caseCommInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseCommInfoVO> caseCommInfoBusiExecute(String caseId, String userId) {
        CaseCommInfoVO caseCommInfo = new CaseCommInfoVO();
        caseCommInfo.setInfo(caseInfoMapper.queryCaseCommInfo(caseId));
        caseCommInfo.setProgress(caseInfoMapper.queryCaseCommProgressInfo(caseId));
        CaseCommCountdownVO countdown = new CaseCommCountdownVO();
        Date now = new Date();
        CompromiseApplyExample example = new CompromiseApplyExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId);
        List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
        if (!compromiseApplies.isEmpty()) {
            CompromiseApply compromiseApply = compromiseApplies.get(0);
            String status = compromiseApply.getStatus();
            if (ComproiseApplyStatusEnum.DOING.getValue().equals(status)) {
                Date planEndTime = compromiseApply.getPlanEndTime();
                countdown.setCompromise((planEndTime.getTime() - now.getTime()) / 1000);
            }
        }

        Date date = caseNodeOperMapper.selectPlanEndTimeDateByCaseId(caseId, CaseMainNodeEnum.CASE_PROCESSING.getCode());
        if (date != null) {
            countdown.setCompromise((date.getTime() - now.getTime()) / 1000);
        }
        caseCommInfo.setCountdown(countdown);
        return BusiExecuteResult.builderSuccessResult(caseCommInfo);
    }

    @Override
    public BusiValidResult caseRequestInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<ArbitratorCaseRequestInfoVO> caseRequestInfoBusiExecute(String caseId, String flag) {
        ArbitratorCaseRequestInfoVO requestInfo = new ArbitratorCaseRequestInfoVO();
        //基本信息
        ArbitratorCaseBaseInfoVO baseInfo = caseInfoMapper.queryCaseBaseInfo(caseId, flag);
        requestInfo.setBaseInfo(baseInfo);
        /**
         * 案件材料
         */
        List<CaseMat> caseMats = this.queryCaseMatByCaseId(caseId, flag);
        //附件列表
        List<CaseAttachmentVO> attachments = new ArrayList<>();
        //委托代理人材料
        List<CaseAttorneyMaterialVO> attorneyMaterials = new ArrayList<>();
        //请求证据列表
        List<CaseEvidenceVO> evidences = new ArrayList<>();
        for (CaseMat caseMat : caseMats) {
            if (caseMat.getMatType().equals(CaseMatTypeEnum.ATTACHMENT.getCode())) {
                attachments.add(CaseAttachmentVO.convertFormCaseMat(caseMat));
            } else if (caseMat.getMatType().equals(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode())) {
                attorneyMaterials.add(CaseAttorneyMaterialVO.convertFormCaseMat(caseMat));
            } else if (caseMat.getMatType().equals(CaseMatTypeEnum.REQUEST_EVIDENCE.getCode())) {
                evidences.add(CaseEvidenceVO.convertFormCaseMat(caseMat));
            }
        }
        requestInfo.setCaseAttorneyMaterial(attorneyMaterials);
        requestInfo.setAttachments(attachments);
        requestInfo.setCaseEvidences(evidences);
        //变更仲裁请求信息
        List<CaseChangeRecordWithBLOBs> caseChangeRecords = this.queryArbiChangeRecordByCaseId(caseId, flag);
        List<CaseArbitrationChangeRecordVO> changeRecords = new ArrayList<>();
        for (CaseChangeRecordWithBLOBs caseChangeRecord : caseChangeRecords) {
            changeRecords.add(CaseArbitrationChangeRecordVO.convertFormCaseChangeRecord(caseChangeRecord));
        }
        requestInfo.setArbitrationChangeRecords(changeRecords);
        return BusiExecuteResult.builderSuccessResult(requestInfo);
    }

    @Override
    public BusiValidResult caseReplyInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<ArbitratorCaseReplyInfoVO> caseReplyInfoBusiExecute(String caseId, String flag) {
        /**
         * 答辩信息
         */
        ArbitratorCaseReplyInfoVO replyInfo = caseInfoMapper.queryCaseReplyInfo(caseId, flag);
        if (replyInfo != null) {
            /**
             * 答辩材料
             */
            List<CaseMat> caseMats = this.queryCaseMatByCaseId(caseId, flag);
            //答辩证据列表
            List<CaseEvidenceVO> evidences = new ArrayList<>();
            for (CaseMat caseMat : caseMats) {
                if (caseMat.getMatType().equals(CaseMatTypeEnum.REPLY_EVIDENCE.getCode())) {
                    evidences.add(CaseEvidenceVO.convertFormCaseMat(caseMat));
                }
            }
            replyInfo.setCaseEvidences(evidences);
        }
        if (replyInfo == null) {
            replyInfo = new ArbitratorCaseReplyInfoVO();
        }
        /**
         * 管辖权异议
         */
        CaseJurisDisVO caseJurisDisVO = this.queryCaseJurisDisByCaseId(caseId, flag);
        replyInfo.setCaseJurisDis(caseJurisDisVO);
        return BusiExecuteResult.builderSuccessResult(replyInfo);
    }

    //#######################################私有Service####################################################

    /**
     * 查询指定案件当前有效仲裁员信息
     *
     * @param caseId 案件Id
     * @return 返回仲裁员信息
     */
    private CaseArbitrator queryCaseNowArbitratorByCaseId(String caseId) {
        CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
        /**
         * 只允许在待受理和有效状态, 同个案件只能存在一个待受理或有效状态
         */
        List<String> statusList = new ArrayList<>();
        statusList.add(CaseArbitratorStatusEnum.WAIT_ACCEPT.getCode());
        statusList.add(CaseArbitratorStatusEnum.OK.getCode());
        caseArbitratorExample
                .createCriteria()
                .andCaseIdEqualTo(caseId)
                .andStatusIn(statusList);
        List<CaseArbitrator> caseArbitratorList = caseArbitratorMapper.selectByExample(caseArbitratorExample);
        if (caseArbitratorList.size() == 1) {
            return caseArbitratorList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 查询指定案件所有材料信息
     *
     * @param caseId 案件Id
     * @return 返回指定案件所有材料信息
     */
    private List<CaseMat> queryCaseMatByCaseId(String caseId, String flag) {
        CaseMatExample caseMatExample = new CaseMatExample();
        caseMatExample
                .createCriteria()
                .andCaseIdEqualTo(caseId)
                .andCounterclaimFlagEqualTo(flag);
        List<CaseMat> caseMats = caseMatMapper.selectByExample(caseMatExample);
        return caseMats;
    }

    /**
     * 查询指定案件所有仲裁变更信息
     *
     * @param caseId 案件Id
     * @return 返回指定案件所有仲裁变更信息
     * @Param flag 请求标志 0-正请求，1-反请求
     */
    private List<CaseChangeRecordWithBLOBs> queryArbiChangeRecordByCaseId(String caseId, String flag) {
        //todo:换表
        CaseChangeRecordExample example = new CaseChangeRecordExample();
        example
                .createCriteria()
                .andCaseIdEqualTo(caseId)
                .andCounterclaimFlagEqualTo(flag);
        return caseChangeRecordMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 查询指定案件管辖权异议信息
     *
     * @param caseId 案件Id
     * @return 返回指定案件管辖权异议信息
     * @Param flag 请求标志 0-正请求，1-反请求
     */
    private CaseJurisDisVO queryCaseJurisDisByCaseId(String caseId, String flag) {
        return caseJurisDisMapper.queryCaseJurisDisByCaseId(caseId, flag);
    }

    @Override
    public BusiValidResult caseFlowInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseFlowVO> caseFlowInfoBusiExecute(String caseId) {
        return BusiExecuteResult.builderSuccessResult(caseInfoMapper.queryCaseFlowByCaseId(caseId));
    }

    @Override
    public BusiValidResult caseCompromiseInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseCompromiseVO> caseCompromiseInfoBusiExecute(String caseId) {
        CaseCompromiseVO caseCompromiseVO = new CaseCompromiseVO();
        caseCompromiseVO.setRecord(compromiseRecordMapper.queryArgueRecordVOByCaseId(caseId));
        //状态,0- 无和解申请,1- 和解申请秘书审核中,2- 和解申请仲裁员审核中,3- 等待开始和解,4- 和解完成
        CompromiseApplyExample example = new CompromiseApplyExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId);
        List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
        //无和解申请处理,2为对方拒绝和解,5为等待对方回应
        if (compromiseApplies.isEmpty() || "2".equals(compromiseApplies.get(0).getStatus()) || "5".equals(compromiseApplies.get(0).getStatus())) {
            caseCompromiseVO.setStatus("0");
            return BusiExecuteResult.builderSuccessResult(caseCompromiseVO);
        }
        CompromiseApply compromiseApply = compromiseApplies.get(0);
        //如果为审核中状态
        if (compromiseApply.getStatus().equals(CompromiseStatusEnum.WAIT_AUDIT.getValue())) {
            if ("0".equals(compromiseApply.getAuditType())) {
                caseCompromiseVO.setStatus("1");
            } else {
                caseCompromiseVO.setStatus("2");
            }
            return BusiExecuteResult.builderSuccessResult(caseCompromiseVO);
        }
        //如果为等待开始审核状态
        if (compromiseApply.getStatus().equals(CompromiseStatusEnum.WAIT_START.getValue())) {
            caseCompromiseVO.setStatus("3");
            return BusiExecuteResult.builderSuccessResult(caseCompromiseVO);
        }
        //如果为等待开始审核状态
        if (compromiseApply.getStatus().equals(CompromiseStatusEnum.COMPLETE.getValue())) {
            caseCompromiseVO.setStatus("4");
            return BusiExecuteResult.builderSuccessResult(caseCompromiseVO);
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }


    @Override
    public BusiValidResult caseCompromiseAuditBusiValid(ArbitratorCaseCompromiseAuditDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        if ("0".equals(formData.getResult()) && StringUtils.isBlank(formData.getStartDate())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        if ("0".equals(formData.getResult())) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate = null;
            try {
                startDate = sdf.parse(formData.getStartDate());
            } catch (ParseException e) {
                e.printStackTrace();
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
            }

            if (startDate.before(new Date())) {
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
            }

            //时间是否符合要求
            CaseRequestInfo caseRequestInfo = new CaseRequestInfo();
            caseRequestInfo.setCaseId(formData.getCaseId());
            caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
            CaseRequestInfo requestInfo = caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);

            //需截止审限前多少天
            Integer fewDayAgo;
            //算出时间
            if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                fewDayAgo = Integer.parseInt(CompletionTimeBeforeEnum.THE_DAY_BEFORE.getCode());
            } else {
                fewDayAgo = Integer.parseInt(CompletionTimeBeforeEnum.TWO_DAYS_BEFORE.getCode());
            }
            //得到
            Date date = caseNodeOperMapper.selectPlanEndTimeDateByCaseId(formData.getCaseId(), CaseMainNodeEnum.CASE_PROCESSING.getCode());
            date = DateUtil.dateTimeSubByDay(date, fewDayAgo);
            if (!startDate.before(date)) {
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
            }
        }

        CompromiseApplyExample example = new CompromiseApplyExample();
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andStatusEqualTo(CompromiseStatusEnum.WAIT_AUDIT.getValue())
                .andAuditTypeEqualTo("1");
        List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
        if (compromiseApplies.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseCompromiseAuditBusiExecute(ArbitratorCaseCompromiseAuditDTO formData) {
        if ("0".equals(formData.getResult())) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //和解开始时间
            Date startDate = null;
            try {
                startDate = sdf.parse(formData.getStartDate());
            } catch (ParseException e) {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CONVERT_ERROR);
            }

            CompromiseApply compromiseApply = new CompromiseApply();
            compromiseApply.setStartTime(startDate);
            compromiseApply.setManagerOpinion(formData.getOpinion());
            compromiseApply.setManagerOperatingTime(new Date());
            compromiseApply.setStatus(CompromiseStatusEnum.WAIT_START.getValue());
            CaseTimeSet caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.COMPROMISE_TRIBUNAL.getValue());
            Date endDate = DateUtil.dateTimeAddByDays(startDate, caseTimeSet.getTimeSet());
            compromiseApply.setPlanEndTime(endDate);
            CompromiseApplyExample example = new CompromiseApplyExample();
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId());
            compromiseApplyMapper.updateByExampleSelective(compromiseApply, example);
        } else {
            CompromiseApply compromiseApply = new CompromiseApply();
            compromiseApply.setManagerOpinion(formData.getOpinion());
            compromiseApply.setManagerOperatingTime(new Date());
            compromiseApply.setStatus(CompromiseStatusEnum.REFUSE.getValue());
            CompromiseApplyExample example = new CompromiseApplyExample();
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId());
            compromiseApplyMapper.updateByExampleSelective(compromiseApply, example);
        }
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseCompromiseReplyBusiValid(ArbitratorCaseCompromiseReplyDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseCompromiseReplyBusiExecute(ArbitratorCaseCompromiseReplyDTO formData) {
        CompromiseRecord compromiseRecord = new CompromiseRecord();
        compromiseRecord.setCaseId(formData.getCaseId());
        compromiseRecord.setContent(formData.getContent());
        compromiseRecord.setContentType(CompromiseRecordTypeEnum.COMPROMISE.getValue());
        compromiseRecord.setCreaterId(formData.getUserId());
        compromiseRecord.setCreateTime(new Date());
        compromiseRecord.setId(sequenceService.getCommonID());
        compromiseRecord.setSenderType(CompromiseSentTypeEnum.ARBITRATOR.getValue());
        compromiseRecordMapper.insertSelective(compromiseRecord);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseArbitrationInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseArbitrationInfoVO> caseArbitrationInfoBusiExecute(String caseId) {
        CaseArbitrationInfoVO arbitrationInfo = new CaseArbitrationInfoVO();
        CaseWithdrawDecisionVO requestWithdrawDecisionDoc = caseInfoMapper.queryWithdrawDecisionDocByCaseIdAndRequestFlag(caseId, RequestTypeEnum.REQUEST.getValue());
        CaseWithdrawDecisionVO beRequestWithdrawDecisionDoc = caseInfoMapper.queryWithdrawDecisionDocByCaseIdAndRequestFlag(caseId, RequestTypeEnum.BACK_REQUEST.getValue());
        List<CaseWithdrawDecisionVO> caseWithdrawDecisions = new ArrayList<>();
        if (requestWithdrawDecisionDoc != null) {
            caseWithdrawDecisions.add(requestWithdrawDecisionDoc);
        }
        if (beRequestWithdrawDecisionDoc != null) {
            caseWithdrawDecisions.add(beRequestWithdrawDecisionDoc);
        }
        arbitrationInfo.setCaseWithdrawDecisions(caseWithdrawDecisions);
        arbitrationInfo.setCaseQuizRecords(quizRecordMapper.queryByCaseId(caseId));
        arbitrationInfo.setCaseCompromiseRecords(compromiseRecordMapper.queryCaseCompromiseRecordByCaseId(caseId));
        return BusiExecuteResult.builderSuccessResult(arbitrationInfo);
    }

    @Override
    public BusiValidResult caseArgueReplyBusiValid(ArbitratorCaseArgueReplyDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseArgueReplyBusiExecute(ArbitratorCaseArgueReplyDTO formData) {
        ArgueRecord record = new ArgueRecord();
        record.setId(sequenceService.getCommonID());
        record.setCaseId(formData.getCaseId());
        record.setSendType("2");
        record.setCreaterId(formData.getUserId());
        record.setContent(formData.getContent());
        record.setCreateTime(new Date());
        argueRecordMapper.insertSelective(record);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseArgueBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<List<ArgueRecordVO>> caseArgueBusiExecute(String caseId, String userId) {
        return BusiExecuteResult.builderSuccessResult(argueRecordMapper.queryArgueRecordVOByCaseId(caseId));
    }

    @Override
    public BusiValidResult caseArbitralAwardsBusiValid(ArbitratorCaseArbitralAwardsDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andApproveTypeEqualTo(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        if (!caseApproves.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseArbitralAwardsBusiExecute(ArbitratorCaseArbitralAwardsDTO formData) {
        //插入审批
        CaseApprove caseApprove = new CaseApprove();
        //秘书Id
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        caseApprove.setApproveUserId(approveUserId);
        String caseApproveId = sequenceService.getCommonID();
        caseApprove.setId(caseApproveId);
        caseApprove.setCreateTime(new Date());
        caseApprove.setCreaterId(formData.getUserId());
        caseApprove.setCaseId(formData.getCaseId());
        caseApprove.setApproveType(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApproveMapper.insertSelective(caseApprove);

        //插入文书表
        CaseDoc caseDoc = new CaseDoc();
        caseDoc.setDocName(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getDocName());
        caseDoc.setDocType(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
        String caseDocId = sequenceService.getCommonID();
        caseDoc.setId(caseDocId);
        caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
        caseDoc.setCaseId(formData.getCaseId());

        CaseNoSeq caseNoSeq = caseNoSeqMapper.queryCaseNoByCsaeId(formData.getCaseId());
        caseDoc.setDocYearNumber(caseNoSeq.getYear());
        caseDoc.setDocSerialNumber(caseNoSeq.getNo().toString());
        caseDoc.setCreaterId(formData.getUserId());
        caseDoc.setCreateTime(new Date());
        caseDoc.setBusiId(caseApproveId);
        caseDocMapper.insertSelective(caseDoc);

        CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
        caseDocContent.setBodyText(formData.getContent());
        caseDocContent.setFinalDecision(formData.getArbitratorContent());
        caseDocContent.setOpinion(formData.getArbitrationSuggest());
        caseDocContent.setArbitratorId(formData.getUserId());
        caseDocContent.setCaseId(formData.getCaseId());
        caseDocContent.setCreateTime(new Date());
        caseDocContent.setDocId(caseDocId);
        String caseDocContentId = sequenceService.getCommonID();
        caseDocContent.setId(caseDocContentId);
        caseDocContent.setIssueId(formData.getUserId());
        caseDocContent.setIssusTime(new Date());
        caseDocContent.setSecretaryId(approveUserId);
        caseDocContentMapper.insertSelective(caseDocContent);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseArbitralAwardsChangeBusiValid(ArbitratorCaseArbitralAwardsDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andApproveTypeEqualTo(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //审核不通过,重新修改
        if (!CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseArbitralAwardsChangeBusiExecute(ArbitratorCaseArbitralAwardsDTO formData) {
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        //修改审批状态
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andApproveTypeEqualTo(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        CaseApprove caseApprove = new CaseApprove();
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApprove.setApproveUserId(approveUserId);
        caseApproveMapper.updateByExampleSelective(caseApprove, caseApproveExample);
        //修改文书内容
        CaseDocExample example = new CaseDocExample();
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andDocTypeEqualTo(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
        CaseDoc caseDoc = caseDocMapper.selectByExample(example).get(0);
        CaseDocContentExample caseDocContentExample = new CaseDocContentExample();
        caseDocContentExample.createCriteria()
                .andDocIdEqualTo(caseDoc.getId());
        CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
        caseDocContent.setBodyText(formData.getContent());
        caseDocContent.setFinalDecision(formData.getArbitratorContent());
        caseDocContent.setOpinion(formData.getArbitrationSuggest());
        caseDocContentMapper.updateByExampleSelective(caseDocContent, caseDocContentExample);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseArbitralAwardsDraftBusiValid(ArbitratorCaseArbitralAwardsDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseArbitralAwardsDraftBusiExecute(ArbitratorCaseArbitralAwardsDTO formData) {
        CaseArbitralAwardsDraftWithBLOBs caseArbitralAwardsDraft = new CaseArbitralAwardsDraftWithBLOBs();
        caseArbitralAwardsDraft.setCaseId(formData.getCaseId());
        caseArbitralAwardsDraft.setCreaterId(formData.getUserId());
        caseArbitralAwardsDraft.setCreateTime(new Date());
        caseArbitralAwardsDraft.setContent(formData.getContent());
        caseArbitralAwardsDraft.setArbitrationSuggest(formData.getArbitrationSuggest());
        caseArbitralAwardsDraft.setArbitratorContent(formData.getArbitratorContent());

        CaseArbitralAwardsDraftExample example = new CaseArbitralAwardsDraftExample();
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId());
        List<CaseArbitralAwardsDraft> caseArbitralAwardsDrafts = caseArbitralAwardsDraftMapper.selectByExample(example);
        if (caseArbitralAwardsDrafts.isEmpty()) {
            caseArbitralAwardsDraft.setId(sequenceService.getCommonID());
            caseArbitralAwardsDraftMapper.insertSelective(caseArbitralAwardsDraft);
        } else {
            caseArbitralAwardsDraftMapper.updateByExampleWithBLOBs(caseArbitralAwardsDraft, example);
        }
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseArbitralAwardsStatusBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Autowired
    private CaseDocGeneraService caseDocGeneraService;

    @Override
    public BusiExecuteResult<ArbitratorCaseArbitralAwardStatusVO> caseArbitralAwardsStatusBusiExecute(String caseId, String userId) {
        ArbitratorCaseArbitralAwardStatusVO arbitralAwardStatusVO = new ArbitratorCaseArbitralAwardStatusVO();
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andApproveTypeEqualTo(ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        arbitralAwardStatusVO.setCaseArbitralAward(caseDocGeneraService.getCaseArbitralAward(caseId));
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            arbitralAwardStatusVO.setStatus("0");
            //草稿内容
            CaseArbitralAwardsDraftExample example = new CaseArbitralAwardsDraftExample();
            example.createCriteria()
                    .andCaseIdEqualTo(caseId);
            List<CaseArbitralAwardsDraftWithBLOBs> caseArbitralAwardsDrafts = caseArbitralAwardsDraftMapper.selectByExampleWithBLOBs(example);
            if (!caseArbitralAwardsDrafts.isEmpty()) {
                arbitralAwardStatusVO.setArbitralAwards(caseArbitralAwardsDrafts.get(0));
            }
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //裁决书审核中
        if (CaseApproveStatusEnum.WAIT_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("1");
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        //审核不通过,重新修改
        if (CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("2");
            //仲裁委意见
            CaseApproveSuggest secretarySuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
            CaseApproveSuggest ministerSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
            CaseApproveSuggest deputyDirectorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
            CaseApproveSuggest directorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DIRECTOR.getCode());
            arbitralAwardStatusVO.setSecretarySuggest(secretarySuggest);
            arbitralAwardStatusVO.setDeputyDirectorSuggest(deputyDirectorSuggest);
            arbitralAwardStatusVO.setDirectorSuggest(directorSuggest);
            arbitralAwardStatusVO.setMinisterSuggest(ministerSuggest);

            CaseArbitralAwardsDraftWithBLOBs caseArbitralAwardsDraft = new CaseArbitralAwardsDraftWithBLOBs();
            CaseDocContentWithBLOBs caseDocContentWithBLOBs = caseDocContentMapper.queryCaseDocContentByCaseIdAndDocType(caseId, CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
            caseArbitralAwardsDraft.setContent(caseDocContentWithBLOBs.getBodyText());
            caseArbitralAwardsDraft.setArbitratorContent(caseDocContentWithBLOBs.getFinalDecision());
            caseArbitralAwardsDraft.setArbitrationSuggest(caseDocContentWithBLOBs.getOpinion());
            arbitralAwardStatusVO.setArbitralAwards(caseArbitralAwardsDraft);
            //回显之前填写
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        //审核通过
        if (CaseApproveStatusEnum.SUCCESS_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("3");
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
    }

    @Override
    public BusiValidResult caseMediateAwardsBusiValid(String caseId, String userId) {
        CaseMediateProcessRecordExample example = new CaseMediateProcessRecordExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId);
        List<CaseMediateProcessRecord> caseMediateProcessRecords = caseMediateProcessRecordMapper.selectByExample(example);
        if (caseMediateProcessRecords.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        CaseMediateProcessRecord caseMediateProcessRecord = caseMediateProcessRecords.get(0);
        if (!"0".equals(caseMediateProcessRecord.getStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseMediateAwardsBusiExecute(String caseId, String userId) {
        //插入审批
        CaseApprove caseApprove = new CaseApprove();
        //秘书Id
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(caseId, ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        caseApprove.setApproveUserId(approveUserId);
        String caseApproveId = sequenceService.getCommonID();
        caseApprove.setId(caseApproveId);
        caseApprove.setCreateTime(new Date());
        caseApprove.setCreaterId(userId);
        caseApprove.setCaseId(caseId);
        caseApprove.setApproveType(ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApproveMapper.insertSelective(caseApprove);
        return BusiExecuteResult.builderSuccessResult();
    }


    @Override
    public BusiValidResult caseMediateAwardsStatusBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<ArbitratorCaseMediateAwardStatusVO> caseMediateAwardsStatusBusiExecute(String caseId, String userId) {
        ArbitratorCaseMediateAwardStatusVO arbitralAwardStatusVO = new ArbitratorCaseMediateAwardStatusVO();
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andApproveTypeEqualTo(ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            arbitralAwardStatusVO.setStatus("0");
            //草稿内容
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //裁决书审核中
        if (CaseApproveStatusEnum.WAIT_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("1");
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        //审核不通过,重新修改
        if (CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("2");
            //仲裁委意见
            CaseApproveSuggest secretarySuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
            CaseApproveSuggest ministerSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
            CaseApproveSuggest deputyDirectorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
            CaseApproveSuggest directorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DIRECTOR.getCode());
            arbitralAwardStatusVO.setSecretarySuggest(secretarySuggest);
            arbitralAwardStatusVO.setDeputyDirectorSuggest(deputyDirectorSuggest);
            arbitralAwardStatusVO.setDirectorSuggest(directorSuggest);
            arbitralAwardStatusVO.setMinisterSuggest(ministerSuggest);
            //回显之前填写
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        //审核通过
        if (CaseApproveStatusEnum.SUCCESS_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            arbitralAwardStatusVO.setStatus("3");
            return BusiExecuteResult.builderSuccessResult(arbitralAwardStatusVO);
        }

        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
    }


    @Override
    public BusiValidResult caseMediateAwardsChangeBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(caseId);
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andApproveTypeEqualTo(ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //审核不通过,重新修改
        if (!CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseMediateAwardsChangeBusiExecute(String caseId, String userId) {
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(caseId, ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        //修改审批状态
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        caseApproveExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andApproveTypeEqualTo(ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
        CaseApprove caseApprove = new CaseApprove();
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApprove.setApproveUserId(approveUserId);
        caseApproveMapper.updateByExampleSelective(caseApprove, caseApproveExample);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseJurisAwardsBusiValid(ArbitratorCaseJurisAwardsDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());

        CaseRequestInfoWithBLOBs caseRequestInfoWithBLOBs = new CaseRequestInfoWithBLOBs();
        caseRequestInfoWithBLOBs = caseRequestInfoMapper.selectRequestInfoByParam(caseRequestInfoWithBLOBs);

        if (caseRequestInfoWithBLOBs == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
        } else {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
        }
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        if (!caseApproves.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseJurisAwardsBusiExecute(ArbitratorCaseJurisAwardsDTO formData) {
        //插入审批
        CaseApprove caseApprove = new CaseApprove();

        CaseRequestInfoWithBLOBs caseRequestInfoWithBLOBs = new CaseRequestInfoWithBLOBs();
        caseRequestInfoWithBLOBs = caseRequestInfoMapper.selectRequestInfoByParam(caseRequestInfoWithBLOBs);

        //秘书Id
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        caseApprove.setApproveUserId(approveUserId);
        String caseApproveId = sequenceService.getCommonID();
        caseApprove.setId(caseApproveId);
        caseApprove.setRequestId(caseRequestInfoWithBLOBs.getId());
        caseApprove.setCreateTime(new Date());
        caseApprove.setCreaterId(formData.getUserId());
        caseApprove.setCaseId(formData.getCaseId());
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseApprove.setApproveType(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
        } else {
            caseApprove.setApproveType(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
        }
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApprove.setTribunalMark(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode());
        caseApproveMapper.insertSelective(caseApprove);

        //插入文书表
        CaseDoc caseDoc = new CaseDoc();
        caseDoc.setRequestId(caseRequestInfoWithBLOBs.getId());
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseDoc.setDocName(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getDocName());
        } else {
            caseDoc.setDocName(CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK.getDocName());
        }
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseDoc.setDocType(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getDocName());
        } else {
            caseDoc.setDocType(CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK.getDocName());
        }
        String caseDocId = sequenceService.getCommonID();
        caseDoc.setId(caseDocId);
        caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
        caseDoc.setCaseId(formData.getCaseId());

        CaseNoSeq caseNoSeq = caseNoSeqMapper.queryCaseNoByCsaeId(formData.getCaseId());
        caseDoc.setDocYearNumber(caseNoSeq.getYear());
        caseDoc.setDocSerialNumber(caseNoSeq.getNo().toString());
        caseDoc.setCreaterId(formData.getUserId());
        caseDoc.setCreateTime(new Date());
        caseDoc.setBusiId(caseApproveId);
        caseDocMapper.insertSelective(caseDoc);

        CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
        caseDocContent.setOpinion(formData.getContent());
        caseDocContent.setArbitratorId(formData.getUserId());
        caseDocContent.setCaseId(formData.getCaseId());
        caseDocContent.setCreateTime(new Date());
        caseDocContent.setRequestId(caseRequestInfoWithBLOBs.getId());
        caseDocContent.setDocId(caseDocId);
        String caseDocContentId = sequenceService.getCommonID();
        caseDocContent.setId(caseDocContentId);
        caseDocContent.setIssueId(formData.getUserId());
        caseDocContent.setIssusTime(new Date());
        caseDocContent.setSecretaryId(approveUserId);
        caseDocContentMapper.insertSelective(caseDocContent);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseJurisAwardsChangeBusiValid(ArbitratorCaseJurisAwardsDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
        } else {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
        }
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //审核不通过,重新修改
        if (!CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult caseJurisAwardsChangeBusiExecute(ArbitratorCaseJurisAwardsDTO formData) {
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        //修改审批状态
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
        } else {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
        }

        CaseRequestInfoWithBLOBs caseRequestInfoWithBLOBs = new CaseRequestInfoWithBLOBs();
        caseRequestInfoWithBLOBs = caseRequestInfoMapper.selectRequestInfoByParam(caseRequestInfoWithBLOBs);

        CaseApprove caseApprove = new CaseApprove();
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApprove.setApproveUserId(approveUserId);
        caseApprove.setRequestId(caseRequestInfoWithBLOBs.getId());
        caseApproveMapper.updateByExampleSelective(caseApprove, caseApproveExample);
        //修改文书内容
        CaseDocExample example = new CaseDocExample();
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andDocTypeEqualTo(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getDocName());
        } else {
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andDocTypeEqualTo(CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK.getDocName());
        }
        CaseDoc caseDoc = caseDocMapper.selectByExample(example).get(0);
        CaseDocContentExample caseDocContentExample = new CaseDocContentExample();
        caseDocContentExample.createCriteria()
                .andDocIdEqualTo(caseDoc.getId());
        CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
        caseDocContent.setOpinion(formData.getContent());
        caseDocContent.setRequestId(caseRequestInfoWithBLOBs.getId());
        caseDocContentMapper.updateByExampleSelective(caseDocContent, caseDocContentExample);
        return BusiExecuteResult.builderSuccessResult();
    }

    @Override
    public BusiValidResult caseJurisAwardsStatusBusiValid(ArbitratorCaseJurisAwardsStatusDTO formData) {
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<ArbitratorCaseJurisAwardStatusVO> caseJurisAwardsStatusBusiExecute(ArbitratorCaseJurisAwardsStatusDTO formData) {
        ArbitratorCaseJurisAwardStatusVO jurisAwardStatusVO = new ArbitratorCaseJurisAwardStatusVO();
        CaseApproveExample caseApproveExample = new CaseApproveExample();
        if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
        } else {
            caseApproveExample.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andApproveTypeEqualTo(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
        }
        List<CaseApprove> caseApproves = caseApproveMapper.selectByExample(caseApproveExample);
        //todo 是否需要出具管辖权异议决定书
        //未出具裁决书
        if (caseApproves.isEmpty()) {
            jurisAwardStatusVO.setStatus("0");
            return BusiExecuteResult.builderSuccessResult(jurisAwardStatusVO);
        }
        CaseApprove caseApprove = caseApproves.get(0);
        //裁决书审核中
        if (CaseApproveStatusEnum.WAIT_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            jurisAwardStatusVO.setStatus("1");
            return BusiExecuteResult.builderSuccessResult(jurisAwardStatusVO);
        }

        //审核不通过,重新修改
        if (CaseApproveStatusEnum.FAIL_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            jurisAwardStatusVO.setStatus("2");
            //仲裁委意见
            CaseApproveSuggest secretarySuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
            CaseApproveSuggest ministerSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
            CaseApproveSuggest deputyDirectorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
            CaseApproveSuggest directorSuggest = caseApproveSuggestMapper.selectApproveSuggestByApproveIdAndManagerType(caseApprove.getId(), ManagerInfoTypeEnum.DIRECTOR.getCode());
            jurisAwardStatusVO.setSecretarySuggest(secretarySuggest);
            jurisAwardStatusVO.setDeputyDirectorSuggest(deputyDirectorSuggest);
            jurisAwardStatusVO.setDirectorSuggest(directorSuggest);
            jurisAwardStatusVO.setMinisterSuggest(ministerSuggest);
            return BusiExecuteResult.builderSuccessResult(jurisAwardStatusVO);
        }

        //审核通过
        if (CaseApproveStatusEnum.SUCCESS_AUDIT.getValue().equals(caseApprove.getApproveStatus())) {
            jurisAwardStatusVO.setStatus("3");
            return BusiExecuteResult.builderSuccessResult(jurisAwardStatusVO);
        }

        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
    }

    @Override
    public BusiValidResult caseWithdrawAwardsBusiValid(ArbitratorCaseWithdrawAwardsDTO formData) {
        if ("1".equals(formData.getOpinion()) && StringUtils.isBlank(formData.getOpinionContent())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.OPINION_NOT_NULL);
        }
        CaseArbitrator caseArbitrator = this.queryCaseNowArbitratorByCaseId(formData.getCaseId());
        //该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        //该案件是否属于该仲裁员
        if (!formData.getUserId().equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Autowired
    private CaseCancelProcessRecordMapper caseCancelProcessRecordMapper;

    @Override
    public BusiExecuteResult caseWithdrawAwardsBusiExecute(ArbitratorCaseWithdrawAwardsDTO formData) {
        //同意
        if ("0".equals(formData.getOpinion())) {
            CaseApprove caseApprove = new CaseApprove();
            caseApprove.setId(sequenceService.getCommonID());
            Date nowTime = new Date();
            caseApprove.setCreateTime(nowTime);
            caseApprove.setCreaterId(formData.getUserId());
            caseApprove.setCaseId(formData.getCaseId());
            WithdrawRecordExample example = new WithdrawRecordExample();

            CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
            caseRequestInfo.setCaseId(formData.getCaseId());
            caseRequestInfo.setRequestType(formData.getRequestType());
            caseRequestInfo = caseRequestInfoMapper.selectRequestInfoByParam(caseRequestInfo);
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andRequestIdEqualTo(caseRequestInfo.getId());
            example.setOrderByClause("CREATE_TIME DESC");
            List<WithdrawRecord> withdrawRecords = withdrawRecordMapper.selectByExample(example);
            caseApprove.setBusiId(withdrawRecords.get(0).getId());
            if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
                caseApprove.setApproveType(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName());
            } else {
                caseApprove.setApproveType(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName());
            }
            caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
            String secretaryId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
            caseApprove.setApproveUserId(secretaryId);
            caseApprove.setTribunalMark(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode());
            caseApprove.setRequestId(caseRequestInfo.getId());
            caseApproveMapper.insertSelective(caseApprove);

            CaseDoc caseDoc = new CaseDoc();
            caseDoc.setCreaterId(formData.getUserId());
            if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestType())) {
                caseDoc.setDocName(CaseDocTypeEnum.CANCEL_DECIDE_BOOK.getDocName());
                caseDoc.setDocType(CaseDocTypeEnum.CANCEL_DECIDE_BOOK.getCode());
            } else {
                caseDoc.setDocName(CaseDocTypeEnum.DE_REQUEST_CANCEL_DECIDE_BOOK.getDocName());
                caseDoc.setDocType(CaseDocTypeEnum.DE_REQUEST_CANCEL_DECIDE_BOOK.getCode());
            }
            String caseDocId = sequenceService.getCommonID();
            caseDoc.setId(caseDocId);
            caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
            caseDoc.setCaseId(formData.getCaseId());

            CaseNoSeq caseNoSeq = caseNoSeqMapper.queryCaseNoByCsaeId(formData.getCaseId());
            caseDoc.setDocYearNumber(caseNoSeq.getYear());
            caseDoc.setDocSerialNumber(caseNoSeq.getNo().toString());

            caseDoc.setCreateTime(nowTime);
            caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
            caseDoc.setBusiId(withdrawRecords.get(0).getId());
            caseDoc.setRequestId(caseRequestInfo.getId());
            caseDocMapper.insertSelective(caseDoc);

            CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
            caseDocContent.setArbitratorId(formData.getUserId());
            caseDocContent.setCaseId(formData.getCaseId());
            caseDocContent.setCreateTime(nowTime);
            caseDocContent.setDocId(caseDocId);
            caseDocContent.setId(sequenceService.getCommonID());
            caseDocContent.setIssueId(formData.getUserId());
            caseDocContent.setIssueType(CaseDocContentIssueTypeEnum.AGREE_MODULE.getCode());
            caseDocContent.setIssusTime(nowTime);
            caseDocContent.setRequestId(caseRequestInfo.getId());
            caseDocContent.setSaveADraft(CaseDocContentSaveDraftEnum.NO_SAVE_AS_DRAFT.getCode());
            caseDocContent.setSecretaryId(secretaryId);
            caseDocContentMapper.insertSelective(caseDocContent);
        } else {
            //不同意
            CaseCancelProcessRecord caseCancelProcessRecord = new CaseCancelProcessRecord();
            caseCancelProcessRecord.setOpinion(formData.getOpinionContent());
            //修改为不通过
            caseCancelProcessRecord.setStatus("2");
            CaseCancelProcessRecordExample example = new CaseCancelProcessRecordExample();
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andStatusEqualTo("0")
                    .andRetuestTypeEqualTo(formData.getRequestType());
            //更新失败原因及状态
            caseCancelProcessRecordMapper.updateByExampleWithBLOBs(caseCancelProcessRecord, example);
        }
        return BusiExecuteResult.builderSuccessResult();
    }
}
