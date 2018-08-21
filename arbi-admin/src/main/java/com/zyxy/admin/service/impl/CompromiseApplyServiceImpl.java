package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.CompromiseApplyService;
import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ComproiseApplyVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 和解申请serviceImpl
 */
@Service
public class CompromiseApplyServiceImpl implements CompromiseApplyService {

    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;

    @Autowired
    private DocSendRecordMapper docSendRecordMapper;
    
    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;
    
    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;
    
    @Autowired
    private CaseInfoMapper caseInfoMapper;
    
    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;
    
    @Autowired
    private WorkDayService workDayService;

    @Autowired
    private CaseApproveMapper caseApproveMapper;

    /**
     * 和解申请业务验证,判断是组庭前的和解申请还是组庭后的和解申请，并且判断当事人双方是否都同意和解
     * @param caseId
     * @return
     */
    @Override
    public BusiValidResult queryComproiseApplyBusiValid(String caseId) {
        CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria().andIdEqualTo(caseId);
        // 根据案件id查询该案件存不存在
        int i = caseInfoMapper.countByExample(caseInfoExample);
        if (i <= 0) {
            return BusiValidResult
                    .builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 和解申请业务处理,查询出和解申请
     * @param caseId
     * @return
     */
    @Override
    public ComproiseApplyVO queryComproiseApplyBusiExcute(String caseId) {


        //查询出和解申请详细信息
        ComproiseApplyVO comproiseApplyVO = this.queryComproiseApply(caseId);

        return comproiseApplyVO;
    }

    /**
     * 和解申请业务验证
     * @param applyId
     * @return
     */
    @Override
    public BusiValidResult compromiseApplyBusiValidResult(String applyId) {
        CompromiseApply compromiseApply = compromiseApplyMapper.selectByPrimaryKey(applyId);
        if(!CompromiseStatusEnum.WAIT_AUDIT.getValue().equals(compromiseApply.getStatus())){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.COMPROMIST_INFO_REVIEWED);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     *
     * 同意和解申请业务处理
     * @param applyId
     * @param startTime
     * @return
     */
    @Override
    public BusiExecuteResult agreeCompromiseApplyBusiExcute(String applyId, String startTime,String caseId) {
        DateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
       
        //和解开始时间
        Date startDate=null;
        try {
        	startDate=sdf.parse(startTime);
        } catch (ParseException e) {
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CONVERT_ERROR);
        }
        

         CaseRequestInfo caseRequestInfo = new CaseRequestInfo();
         caseRequestInfo.setCaseId(caseId);
         caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
         CaseRequestInfo requestInfo = caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);

         //计划结束时间
         CaseTimeSet caseTimeSet;

         //审限前几天
         Integer fewDayAgo;

         //算出时间
         if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
             fewDayAgo=Integer.parseInt(CompletionTimeBeforeEnum.THE_DAY_BEFORE.getCode());
             caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_LOWER.getValue());
         } else {
             fewDayAgo=Integer.parseInt(CompletionTimeBeforeEnum.TWO_DAYS_BEFORE.getCode());
             caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_UPPER.getValue());
         }

         //得到答辩期的计划结束时间
         Date planEndTime = caseNodeOperMapper.selectPlanEndTimeByCaseId(caseId, CaseMainNodeEnum.CASE_REPLY.getCode().toString());

         //审限期计划结束时间
         Date processingPlanEndTime = workDayService.after(planEndTime, caseTimeSet.getTimeSet(),false);



        //求出和解开始时间可选择的最后时间期限
        Date date = DateUtil.dateTimeSubByDay(processingPlanEndTime, fewDayAgo);

         //判断和解开始时间是否超过
         if(!startDate.before(date)){
             return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.START_DATE_SELECTION_EXIST_ERROR);
         }

        //和解计划结束时间
        caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.COMPROMISE_TRIBUNAL.getValue());
        Date planEndDate = DateUtil.dateTimeAddByDays(startDate,caseTimeSet.getTimeSet());

        int lows = this.updateComproiseApplyByApplyId(applyId, startDate,planEndDate, ComproiseApplyOpinionEnum.OPINION_AGREE.getCode(),CompromiseStatusEnum.WAIT_START.getValue());

        if(lows<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }

    /**
     * 拒绝和解申请业务处理
     * @param applyId
     * @return
     */
    @Override
    public BusiExecuteResult refuseCompromiseApplyBusiExcute(String applyId) {
        int lows = this.updateComproiseApplyByApplyId(applyId, null,null, ComproiseApplyOpinionEnum.OPINION_REFUSE.getCode(), CompromiseStatusEnum.REFUSE.getValue());
        if(lows<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }

        return BusiExecuteResult.builderSuccessResult();
    }

    /******************私有service*******************/

    /**
     * 查询和解申请
     * @param caseId
     * @return
     */
    private ComproiseApplyVO queryComproiseApply(String caseId){
        return compromiseApplyMapper.queryComproiseApply(caseId);
    }

    /**
     * 根据申请id修改和解申请状态
     * @param applyId
     * @param startTime
     * @return
     */
    private int updateComproiseApplyByApplyId(String applyId,Date startTime,Date planEndTime,String managerOpinion,String status){
        CompromiseApply compromiseApply=new CompromiseApply();
        compromiseApply.setId(applyId);
        compromiseApply.setStartTime(startTime);
        compromiseApply.setManagerOpinion(managerOpinion);
        compromiseApply.setManagerOperatingTime(new Date());
        compromiseApply.setPlanEndTime(planEndTime);
        compromiseApply.setStatus(status);
        return compromiseApplyMapper.updateByPrimaryKeySelective(compromiseApply);
    }

}
