package com.zyxy.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.AibitrationCaseInfoService;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.enums.CaseAgentTypeEnum;
import com.zyxy.common.enums.CaseManagerStatusEnum;
import com.zyxy.common.enums.CaseMatTypeEnum;
import com.zyxy.common.enums.CaseReplyTimeRecordTypeEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仲裁委案件信息serviceImpl
 */
@Service
public class AibitrationCaseInfoServiceImpl implements AibitrationCaseInfoService {
    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    @Autowired
    private CaseMatMapper caseMatMapper;

    @Autowired
    private CaseJurisDisMapper caseJurisDisMapper;

    @Autowired
    private QuizRecordMapper quizRecordMapper;

    @Autowired
    private CompromiseRecordMapper compromiseRecordMapper;

    @Autowired
    private AdjudicationAmendmentRecordMapper adjudicationAmendmentRecordMapper;

    @Autowired
    private ArgueRecordMapper argueRecordMapper;
   
    /**
     * 案件请求信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    @Override
    public BusiExecuteResult<ArbitratorCaseRequestInfoVO> caseRequestInfoBusiExecute(String caseId, String flag) {
        ArbitratorCaseRequestInfoVO requestInfo = new ArbitratorCaseRequestInfoVO();
        //基本信息
        ArbitratorCaseBaseInfoVO baseInfo = caseInfoMapper.queryArbitrationCaseInfo(caseId, flag);
        requestInfo.setBaseInfo(baseInfo);
        // 案件材料
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

    /**
     * 案件信息业务验证
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    @Override
    public BusiValidResult caseInfoBusiValid(String caseId, String userId) {
        List<CaseManager> caseManagerList = this.queryCaseNowArbitrationByCaseId(caseId);
        //该案件是否存在
        if (caseManagerList.size()<=0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        // 该案件是否属于该仲裁委人员
        List<CaseManager> personnelValidation = this.personnelValidation(
               userId, caseId);

        if (personnelValidation.size()<=0) {
            return BusiValidResult
                    .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }else{
        	String managerType = personnelValidation.get(0).getManagerType();//获取该仲裁委身份
        	if(ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode().equals(managerType)||ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode().equals(managerType)){
        		 return BusiValidResult
                         .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        	}
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 案件答辩信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    @Override
    public BusiExecuteResult<ArbitratorCaseReplyInfoVO> caseReplyInfoBusiExecute(String caseId, String flag) {
        /**
         * 答辩信息
         */
        List<ArbitratorCaseReplyInfoVO> arbitratorCaseReplyInfoVO = caseInfoMapper.queryCaseDebateInfo(caseId, flag,CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
        ArbitratorCaseReplyInfoVO replyInfo;
        if(arbitratorCaseReplyInfoVO.size()>0){
        	 replyInfo = arbitratorCaseReplyInfoVO.get(0);
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
        }else{
        	replyInfo = new ArbitratorCaseReplyInfoVO();
        }

        /**
         * 管辖权异议
         */
        CaseJurisDisVO caseJurisDisVO = this.queryCaseJurisDisByCaseId(caseId, flag);
        replyInfo.setCaseJurisDis(caseJurisDisVO);
        return BusiExecuteResult.builderSuccessResult(replyInfo);
    }
    
    
    /**
     * 案件变更请求信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    @Override
    public BusiExecuteResult<List<ChangeRequestContentVO>> changeRequestBusiExecute(String caseId, String flag) {
    	List<ChangeRequestContentVO> queryCaseChangeRecordList = caseChangeRecordMapper.queryCaseChangeRecordList(caseId, flag);
        return BusiExecuteResult.builderSuccessResult(queryCaseChangeRecordList);
    }
    
    
    /**
     * 案件变更请求答辩信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    @Override
    public BusiExecuteResult<List<ArbitratorCaseReplyInfoVO>> changeDebateRequestBusiExecute(String caseId, String flag) {
        /**
         * 答辩信息
         */
        List<ArbitratorCaseReplyInfoVO> replyInfo = caseInfoMapper.queryCaseDebateInfo(caseId, flag,CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue());     
        return BusiExecuteResult.builderSuccessResult(replyInfo);
    }
    
    /**
     * 举证信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    @Override
    public BusiExecuteResult<List<EvidenceVO>> caseProofBusiExecute(String caseId) {
    	List<EvidenceVO> queryCaseChangeRecordList = caseMatMapper.selectproofEvidenceList(caseId);
        return BusiExecuteResult.builderSuccessResult(queryCaseChangeRecordList);
    }

 

    /**
     * 案件裁决信息业务处理
     * @param caseId 案件Id
     * @return
     */
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



    /**
     * 查询指定案件补正列表
     * @param caseId 案件ID
     * @return
     */
    @Override
    public BusiExecuteResult amendmentInfoBusiExecute(String caseId) {
        BasePageDTO formData = new BasePageDTO();
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());

        /**
         * 申请方案件补正列表
         */
        Map<String, String> map = new HashMap<String, String>();
        map.put("caseId", caseId);
        map.put("requestFlag", RequestTypeEnum.REQUEST.getValue());
        map.put("litigantType", CaseAgentTypeEnum.PROP_AGENT.getCode());
        List<AdjudicationAmendmentVO> amendmentEvaluation = adjudicationAmendmentRecordMapper
                .amendmentEvaluation(map);
        /**
         * 被申请方案件补正列表
         */
        Map<String, String> beMap = new HashMap<String, String>();
        beMap.put("caseId", caseId);
        beMap.put("requestFlag", RequestTypeEnum.REQUEST.getValue());
        beMap.put("litigantType", CaseAgentTypeEnum.DEFE_AGENT.getCode());
        List<AdjudicationAmendmentVO> beamendmentEvaluation = adjudicationAmendmentRecordMapper
                .amendmentEvaluation(beMap);
        amendmentEvaluation.addAll(beamendmentEvaluation);
        return BusiExecuteResult
                .builderSuccessResult(new PageInfo<AdjudicationAmendmentVO>(
                        amendmentEvaluation));
    }

  
    /**
     * 查询辩论记录列表
     * @param caseId
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<ArgueRecord>> argueRecordListBusiExecute(String caseId) {
        PageInfo<ArgueRecord> pageInfo = this.argueRecordPageInfo(caseId);
        return BusiExecuteResult.builderSuccessResult(pageInfo);
    }





    /***********************私有service**************************/
    /**
     * 根据案件id查询出当前有效的仲裁委工作人员
     * @param caseId
     * @return
     */
    private List<CaseManager> queryCaseNowArbitrationByCaseId(String caseId){
        CaseManagerExample caseManagerExample = new CaseManagerExample();
        caseManagerExample.createCriteria().andCaseIdEqualTo(caseId).andStatusEqualTo(CaseManagerStatusEnum.OK.getCode());
        List<CaseManager> caseManagerList = caseManagerMapper.selectByExample(caseManagerExample);
        return caseManagerList;
    }
    
    /**
	 * 通过userId判断该案件是否是该仲裁委人员审核
	 * 
	 * @param userId
	 *            用户id
	 * @param caseId
	 *            案件id
	 * @return 指定案件当前有效仲裁委
	 */
	private List<CaseManager> personnelValidation(String userId, String caseId) {
		CaseManagerExample caseManagerExample = new CaseManagerExample();
		caseManagerExample.createCriteria().andCaseIdEqualTo(caseId)
				.andManagerIdEqualTo(userId)
				.andStatusEqualTo(CaseManagerStatusEnum.OK.getCode());

		caseManagerMapper.selectByExample(caseManagerExample);
		return caseManagerMapper.selectByExample(caseManagerExample);
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
     * 查询指定案件管辖权异议信息
     *
     * @param caseId 案件Id
     * @return 返回指定案件管辖权异议信息
     * @Param flag 请求标志 0-正请求，1-反请求
     */
    private CaseJurisDisVO queryCaseJurisDisByCaseId(String caseId, String flag) {
        return caseJurisDisMapper.queryCaseJurisDisByCaseId(caseId, flag);
    }


    /**
     * 查询辩论记录列表
     * @param caseId
     * @return
     */
    private PageInfo<ArgueRecord> argueRecordPageInfo(String caseId) {
        ArgueRecordExample example = new ArgueRecordExample();
        example.createCriteria().andCaseIdEqualTo(caseId);

        BasePageDTO formData = new BasePageDTO();
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return new PageInfo<ArgueRecord>(argueRecordMapper.selectByExampleWithBLOBs(example));
    }
}
