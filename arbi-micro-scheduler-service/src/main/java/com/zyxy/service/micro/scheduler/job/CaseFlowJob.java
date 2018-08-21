package com.zyxy.service.micro.scheduler.job;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.flow.CasePayDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.CaseArbitratorService;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.vo.ApiResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class CaseFlowJob {

    private static final Logger logger = LoggerFactory.getLogger(CaseFlowJob.class);

    @Autowired
    private CaseFlowMapper caseFlowMapper;

    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;

    @Autowired
    private MicroFlowService microFlowService;

    @Autowired
    private CaseFlowService caseFlowService;

    @Autowired
    private MicroMessageService microMessageService;

    @Autowired
    private MicroThirdService microThirdService;

    @Autowired
    private CaseArbitratorService caseArbitratorService;

    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;

    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;

    @Autowired
    private WorkDayService workDayService;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    /**
     * 将答辩期时间结束的任务加入审理期
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void replyExpireToProcessing() {
        List<String> caseIds = caseFlowMapper.queryReplyExpireCase();
        for (String caseId : caseIds) {
            caseFlowService.replyToProcess(caseId, ReplyToProcessRemarkEnum.CASE_REPLY_OVER, false);
        }
    }

    /**
     * 将支付超时的任务加入审理期
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void payExpireToOver() {
        List<String> caseIds = caseFlowMapper.queryPayExpireCase();
        CasePayDTO casePayDTO = new CasePayDTO();
        casePayDTO.setUserId(SysUserEnum.SYSTEM.getValue());
        //审核结果，0- 通过，1- 不通过
        casePayDTO.setResult("1");
        for (String caseId : caseIds) {
            casePayDTO.setCaseId(caseId);
            microFlowService.pay(caseId, casePayDTO);
        }
    }

    /**
     * 将补正时间到期的任务修改状态
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void offsetExpireToOver() {
        List<String> caseIds = caseFlowMapper.queryOffsetExpireCase();
        CaseNodeOper caseNodeOper = new CaseNodeOper();
        caseNodeOper.setRealEndTime(new Date());
        caseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample example;
        for (String caseId : caseIds) {
            example = new CaseNodeOperExample();
            example.createCriteria()
                    .andCaseIdEqualTo(caseId)
                    .andNodeIdEqualTo(CaseMainNodeEnum.CASE_OFFSET.getCode());
            caseNodeOperMapper.updateByExampleSelective(caseNodeOper, example);
        }
    }

    /**
     * 答辩期结束后两日内组庭提醒
     */
    @Scheduled(cron = "0 0 8/2 * * ? ")
    public void replyExpireToOver() {
        //todo:模版待修改
        List<Map<String, String>> caseIds = caseFlowMapper.queryReplyExpireNoticeCase();
//        Map content
//        {
//            "caseId":"caseId",
//            "phone":"phone"
//        }
        String tplId = "1004";
        String tplParam;
        String userId = SysUserEnum.SYSTEM.getValue();
        for (Map<String, String> map : caseIds) {
            tplParam = "{\"caseId\":\"" + map.get("caseId") + "\"}";
            microMessageService.sendSms(map.get("phone"), tplId, tplParam, userId, null);
        }
    }

    /**
     * 答辩期结束后为分配仲裁员的，系统分配
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void replyExpireNotSelectArbitratorSystemSelect() {
        List<String> caseIds = caseFlowMapper.queryReplyExpireNotSelectArbitratorCase();
        for (String caseId : caseIds) {
            //系统分配仲裁员
            caseArbitratorService.allotArbitrator(caseId);
        }
    }

    /**
     * 本请求付款状态定时器
     * 每分钟
     */
    @Scheduled(cron = "0 * * * * ?")
    public void requestPayStatusMonitor() {
        List<Map<String, String>> cases = caseFlowMapper.queryPayingCase();
//        {
//            "caseId" : "caseId",
//            "payId" : "payId"
//        }
        String payId;
        String caseId;
        CasePayDTO casePayDTO = new CasePayDTO();
        casePayDTO.setUserId(SysUserEnum.SYSTEM.getValue());
        //设置为成功
        casePayDTO.setResult("0");
        for (Map<String, String> nowCase : cases) {
            payId = nowCase.get("payId");
            caseId = nowCase.get("caseId");
            casePayDTO.setCaseId(caseId);
            //查询付款状态
            ApiResultVO<PayOrder> payOrderApiResultVO = microThirdService.queryOrder(payId);
            logger.info("缴费状态" + JSONObject.toJSONString(payOrderApiResultVO));
            PayOrder body = payOrderApiResultVO.getBody();
            Integer status = body.getStatus();
            //支付成功
            if (status.equals(4)) {
                //支付成功走流程
                microFlowService.pay(caseId, casePayDTO);
            }
        }
    }

    /**
     * 反请求付款状态定时器
     * 每分钟
     */
    @Scheduled(cron = "0 * * * * ?")
    public void beRequestPayStatusMonitor() {
        List<Map<String, String>> cases = caseFlowMapper.queryBeRequestPayingCase();
//        {
//            "caseId" : "caseId",
//            "payId" : "payId",
//            "requestId" : "requestId"
//        }
        String payId;
        String caseId;
        String requestId;
        //设置为成功
        CaseRequestInfoWithBLOBs payStatusUpdate = new CaseRequestInfoWithBLOBs();
        payStatusUpdate.setPayStatus(PayStatusEnum.PAY.getValue());
        for (Map<String, String> nowCase : cases) {
            payId = nowCase.get("payId");
            caseId = nowCase.get("caseId");
            requestId = nowCase.get("requestId");
            //查询付款状态
            ApiResultVO<PayOrder> payOrderApiResultVO = microThirdService.queryOrder(payId);
            PayOrder body = payOrderApiResultVO.getBody();
            Integer status = body.getStatus();
            //支付成功
            if (status.equals(4)) {
                //支付成功修改为已支付
                payStatusUpdate.setId(requestId);
                caseRequestInfoMapper.updateByPrimaryKeySelective(payStatusUpdate);

                //加入答辩时间表
                CaseReplyTimeRecord caseReplyTimeRecord = new CaseReplyTimeRecord();
                caseReplyTimeRecord.setBusiId(requestId);
                caseReplyTimeRecord.setDelayFlag(CaseReplyTimeRecordDelayFLagEnum.NO.getValue());

                CaseTimeSet caseTimeSet;
                CaseRequestInfo requestInfo = new CaseRequestInfo();
                requestInfo.setCaseId(caseId);
                requestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
                requestInfo = caseRequestInfoMapper.selectRequestByParam(requestInfo);
                if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_LOWER.getValue());
                } else {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_UPPER.getValue());
                }
                caseReplyTimeRecord.setEndTime(workDayService.after(caseTimeSet.getTimeSet()));
                caseReplyTimeRecord.setId(sequenceService.getCommonID());
                caseReplyTimeRecord.setRequestType(RequestTypeEnum.BACK_REQUEST.getValue());
                caseReplyTimeRecord.setStartTime(new Date());
                caseReplyTimeRecord.setType(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
                caseReplyTimeRecord.setCaseId(caseId);
                caseReplyTimeRecordMapper.insertSelective(caseReplyTimeRecord);
            }
        }
    }

    /**
     * 将支付超时的发请求结束
     */
    @Scheduled(cron = "0 * * * * ?")
    public void bePayExpireToOver() {
        List<Map<String, String>> requests = caseFlowMapper.queryBeRequestExpireCase();
//        {
//            "caseId" : "caseId",
//            "payId" : "payId",
//            "requestId" : "requestId"
//        }
        String payId;
        String requestId;
        for (Map<String, String> request : requests) {
            payId = request.get("payId");
            requestId = request.get("requestId");
            microThirdService.cancleOrder(payId);
            CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
            caseRequestInfo.setId(requestId);
            caseRequestInfo.setStatus(CaseRequestInfoStatusEnum.PAY_ERROR.getValue());
            caseRequestInfoMapper.updateByPrimaryKeySelective(caseRequestInfo);
        }
    }

    /**
     * 和解开始
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void compromiseStart() {
        caseFlowMapper.compromiseStart();
    }

    /**
     * 和解结束
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void compromiseEnd() {
        List<String> compromiseOverCaseIds = caseFlowMapper.queryCompromiseOverCase();
        for (String compromiseOverCaseId : compromiseOverCaseIds) {
            caseFlowService.compromiseOver(compromiseOverCaseId);
        }
    }


    /**
     * 反请求付款状态定时器
     * 每分钟
     */
    @Scheduled(cron = "0 * * * * ?")
    public void changeRequestPayStatusMonitor() {
        List<Map<String, String>> cases = caseFlowMapper.queryChangeRequestPayingCase();
//        {
//            "caseId" : "caseId",
//            "payId" : "payId",
//            "requestType" : "requestType",
//            "id" : "id"
//        }
        String payId;
        String caseId;
        String requestType;
        String id;
        //设置为成功
        CaseChangeRecordWithBLOBs payStatusUpdate = new CaseChangeRecordWithBLOBs();
        payStatusUpdate.setStatus(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue());
        for (Map<String, String> nowCase : cases) {
            payId = nowCase.get("payId");
            caseId = nowCase.get("caseId");
            requestType = nowCase.get("requestType");
            id = nowCase.get("id");
            //查询付款状态
            ApiResultVO<PayOrder> payOrderApiResultVO = microThirdService.queryOrder(payId);
            PayOrder body = payOrderApiResultVO.getBody();
            Integer status = body.getStatus();
            //支付成功
            if (status.equals(4)) {
                //支付成功修改为已支付
                payStatusUpdate.setId(id);
                caseChangeRecordMapper.updateByPrimaryKeySelective(payStatusUpdate);

                //加入答辩时间表
                CaseReplyTimeRecord caseReplyTimeRecord = new CaseReplyTimeRecord();
                caseReplyTimeRecord.setBusiId(id);
                caseReplyTimeRecord.setDelayFlag(CaseReplyTimeRecordDelayFLagEnum.NO.getValue());

                CaseTimeSet caseTimeSet;
                CaseRequestInfo requestInfo = new CaseRequestInfo();
                requestInfo.setCaseId(caseId);
                requestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
                requestInfo = caseRequestInfoMapper.selectRequestByParam(requestInfo);
                if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_LOWER.getValue());
                } else {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_REPLY_UPPER.getValue());
                }
                caseReplyTimeRecord.setEndTime(workDayService.after(caseTimeSet.getTimeSet()));
                caseReplyTimeRecord.setId(sequenceService.getCommonID());
                caseReplyTimeRecord.setRequestType(requestType);
                caseReplyTimeRecord.setStartTime(new Date());
                caseReplyTimeRecord.setType(CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue());
                caseReplyTimeRecord.setCaseId(caseId);
                caseReplyTimeRecordMapper.insertSelective(caseReplyTimeRecord);
            }
        }
    }

    /**
     * 将支付超时的发请求结束
     */
    @Scheduled(cron = "0 * * * * ?")
    public void changePayExpireToOver() {
        List<Map<String, String>> requests = caseFlowMapper.queryChangeRequestExpireCase();
//        {
//            "caseId" : "caseId",
//            "payId" : "payId",
//            "requestType" : "requestType",
//            "id" : "id"
//        }
        String payId;
        String caseId;
        String requestType;
        String id;
        //设置为成功
        CaseChangeRecordWithBLOBs payStatusUpdate = new CaseChangeRecordWithBLOBs();
        payStatusUpdate.setStatus(CaseChangeStatusEnum.PAY_ERROR.getValue());
        for (Map<String, String> request : requests) {
            payId = request.get("payId");
            caseId = request.get("caseId");
            requestType = request.get("requestType");
            id = request.get("id");
            microThirdService.cancleOrder(payId);
            payStatusUpdate.setId(id);
            caseChangeRecordMapper.updateByPrimaryKeySelective(payStatusUpdate);
        }
    }
}
