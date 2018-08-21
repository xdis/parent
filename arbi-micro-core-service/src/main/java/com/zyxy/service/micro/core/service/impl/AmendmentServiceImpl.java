package com.zyxy.service.micro.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.AdjudiAmendRecordAuditDTO;
import com.zyxy.common.dto.AdjudiAmendRecordInsertDTO;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.AdjudicationAmendmentVO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.service.micro.core.service.AmendmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 仲裁补正相关服务
 */
@Service
public class AmendmentServiceImpl implements
        AmendmentService {

    @Autowired
    private AdjudicationAmendmentRecordMapper adjudicationAmendmentRecordMapper;

    @Autowired
    CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CaseDocMapper caseDocMapper;
    ;

    @Override
    public BusiValidResult amendmentInfoBusiValid(String caseId, String userId) {
        CaseArbitrator caseArbitrator = this
                .queryCaseNowArbitratorByCaseId(caseId);
        // 该案件是否存在
        if (caseArbitrator == null) {
            return BusiValidResult
                    .builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }

        // 该案件是否属于该仲裁员
        if (!userId.equals(caseArbitrator.getArbitratorId())) {
            return BusiValidResult
                    .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 查询指定案件补正列表
     *
     * @param caseId 案件ID
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<AdjudicationAmendmentVO>> amendmentInfoBusiExecute(
            String caseId) {
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
        caseArbitratorExample.createCriteria().andCaseIdEqualTo(caseId)
                .andStatusIn(statusList);
        List<CaseArbitrator> caseArbitratorList = caseArbitratorMapper
                .selectByExample(caseArbitratorExample);
        if (caseArbitratorList.size() == 1) {
            return caseArbitratorList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public BusiValidResult adjudicationAmendmentInsertValid(
            AdjudiAmendRecordInsertDTO formData) {
        //案件是否结案
        CaseDocExample example = new CaseDocExample();
        example.
                createCriteria().
                andCaseIdEqualTo(formData.getCaseId()).
                andDocTypeEqualTo(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
        List<CaseDoc> caseDocs = caseDocMapper.selectByExample(example);
        if (caseDocs.size() == 0) {
            return BusiValidResult.builderErrorResult(Coder.CASE_NOTADJUDICATION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<String> adjudicationAmendmentInsertExecute(
            AdjudiAmendRecordInsertDTO formData) {
        AdjudicationAmendmentRecordWithBLOBs record = new AdjudicationAmendmentRecordWithBLOBs();
        record.setId(sequenceService.getCommonID());
        record.setCaseId(formData.getCaseId());
        record.setApplication(formData.getApplication());
        record.setFactReason(formData.getFactReason());
        record.setCreateTime(new Date());
        record.setContentId(formData.getUserId());
        record.setCreaterId(formData.getUserId());
        record.setStauts(AmendStatusEnum.WAIT.getValue());
        int rows = adjudicationAmendmentRecordMapper.insert(record);
        return rows > 0 ? BusiExecuteResult.builderSuccessResult() :
                BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);

    }

    @Override
    public BusiValidResult adjudicationAmendmentAuditValid(
            AdjudiAmendRecordAuditDTO formData) {
        //当前仲裁员是否有效仲裁员
        CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
        caseArbitratorExample.
                createCriteria().
                andCaseIdEqualTo(formData.getCaseId()).
                andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
        List<CaseArbitrator> caseArbitrators = caseArbitratorMapper.selectByExample(caseArbitratorExample);
        if (!formData.getUserId().equals(caseArbitrators.get(0).getArbitratorId())) {
            return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_NOT_MATCH_ARBITRATOR_FOR_CASE);
        }
        if ("1".equals(formData.getStatus()) && StringUtils.isBlank(formData.getContent())) {
            return BusiValidResult.builderErrorResult(Coder.ADJUST_CONTENT_NOT_NULL);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseApproveMapper caseApproveMapper;

    @Autowired
    private CaseNoSeqMapper caseNoSeqMapper;

    @Autowired
    private CaseDocContentMapper caseDocContentMapper;

    @Override
    public BusiExecuteResult<String> adjudicationAmendmentAuditExecute(
            AdjudiAmendRecordAuditDTO formData) {
        AdjudicationAmendmentRecordWithBLOBs record = new AdjudicationAmendmentRecordWithBLOBs();
        record.setId(formData.getId());
        record.setStauts(formData.getStatus());
        record.setContent(formData.getContent());
        int rows = adjudicationAmendmentRecordMapper.updateByPrimaryKeySelective(record);
        //文书表
        CaseDoc caseDoc = new CaseDoc();
        caseDoc.setBusiId(formData.getId());
        CaseNoSeq caseNoSeq = caseNoSeqMapper.queryCaseNoByCsaeId(formData.getCaseId());
        caseDoc.setDocYearNumber(caseNoSeq.getYear());
        caseDoc.setDocSerialNumber(caseNoSeq.getNo().toString());
        caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
        caseDoc.setCreateTime(new Date());
        caseDoc.setCaseId(formData.getCaseId());
        caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
        caseDoc.setId(sequenceService.getCommonID());
        caseDoc.setDocType(CaseDocTypeEnum.ADJUDICATION_AMENDMENT_APPLY_BOOK.getCode());
        caseDoc.setDocName(CaseDocTypeEnum.ADJUDICATION_AMENDMENT_APPLY_BOOK.getDocName());
        caseDoc.setCreaterId(formData.getUserId());
        caseDocMapper.insertSelective(caseDoc);
        //文书内容表
        CaseDocContentWithBLOBs caseDocContent = new CaseDocContentWithBLOBs();
//		caseDocContent.setRequestId();
        caseDocContent.setId(sequenceService.getCommonID());
        String secretaryId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        caseDocContent.setSecretaryId(secretaryId);
        caseDocContent.setSaveADraft(CaseDocContentSaveDraftEnum.NO_SAVE_AS_DRAFT.getCode());
        caseDocContent.setIssusTime(new Date());
        caseDocContent.setIssueType(CaseDocContentIssueTypeEnum.AGREE_MODULE.getCode());
        caseDocContent.setIssueId(formData.getUserId());
        caseDocContent.setDocId(caseDoc.getId());
        caseDocContent.setCreateTime(new Date());
        caseDocContent.setCaseId(formData.getCaseId());
        caseDocContent.setArbitratorId(formData.getUserId());
//		caseDocContent.setOpinion();
        caseDocContent.setFinalDecision(formData.getContent());
//		caseDocContent.setBodyText();
        caseDocContentMapper.insertSelective(caseDocContent);
        //插入补正审批
        CaseApprove caseApprove = new CaseApprove();
        caseApprove.setTribunalMark(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode());
        caseApprove.setApproveUserId(secretaryId);
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        caseApprove.setApproveType(ApproveTypeEnum.CORRECTION_BOOK_APPROVAL.getTypeName());
        caseApprove.setBusiId(formData.getId());
        caseApprove.setCaseId(formData.getCaseId());
        caseApprove.setCreaterId(formData.getUserId());
        caseApprove.setCreateTime(new Date());
        caseApprove.setId(sequenceService.getCommonID());
        caseApproveMapper.insertSelective(caseApprove);
        return rows > 0 ? BusiExecuteResult.builderSuccessResult() :
                BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
    }

}
