package com.zyxy.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.AdjudicationAmendmentService;
import com.zyxy.common.domain.AdjudicationAmendmentRecord;
import com.zyxy.common.domain.AdjudicationAmendmentRecordExample;
import com.zyxy.common.domain.AdjudicationAmendmentRecordExample.Criteria;
import com.zyxy.common.domain.AdjudicationAmendmentRecordWithBLOBs;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.dto.AdjudicationAmendmentDTO;
import com.zyxy.common.enums.AmendStatusEnum;
import com.zyxy.common.enums.ApproveIsAuthorizedEnum;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveDescribeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseDocIssueTypeEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.OpinionStateEnum;
import com.zyxy.common.mapper.AdjudicationAmendmentRecordMapper;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseApproveSuggestMapper;
import com.zyxy.common.mapper.CaseDocContentMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.AmendmentContentVO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CaseApproveSuggestVO;
import com.zyxy.common.vo.CaseBaseInfoVO;
import com.zyxy.common.vo.CaseDocContentVO;
import com.zyxy.common.vo.HistoryAmendRecordVO;

@Service
public class AdjudicationAmendmentServiceImpl implements AdjudicationAmendmentService{
	@Autowired
	CaseDocContentMapper caseDocContentMapper;
	
	@Autowired
	CaseInfoMapper caseInfoMapper;
	
	@Autowired
	SequenceService sequenceService;
	
	@Autowired
	CaseApproveMapper caseApproveMapper;
	
	@Autowired
	CaseApproveSuggestMapper caseApproveSuggestMapper;
	
	@Autowired
	AdjudicationAmendmentRecordMapper adjudicationAmendmentRecordMapper;
	
	@Autowired
	ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	CaseDocMapper caseDocMapper;
	
	@Override
	public BusiExecuteResult<AmendmentContentVO> queryAdjudicationAmendment(
			String approveId,String userId) {
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);
		AmendmentContentVO vo = new AmendmentContentVO();
		
		//历史补正记录
		List<HistoryAmendRecordVO> adjudicationAmendentHistoryRecords = adjudicationAmendmentRecordMapper.queryValidAdjudicationAmendmentHistoryRecord(caseApprove.getCaseId(),caseApprove.getBusiId());
		
		//当前补正记录
		AdjudicationAmendmentRecordWithBLOBs adjudicationAmendentRecord = adjudicationAmendmentRecordMapper.selectByPrimaryKey(caseApprove.getBusiId());
		
		//当事人基本信息
		CaseBaseInfoVO caseBaseInfo =  caseInfoMapper.queryCaseBaseInfoByRequestId(caseApprove.getRequestId());
		
		//案件审批记录
		List<CaseApproveSuggestVO> caseApproveSuggests = caseApproveSuggestMapper.queryApproveSuggestsByApproveId(approveId);
		if(caseApproveSuggests != null && !caseApproveSuggests.isEmpty()){
			//初始化审批人姓名
			for (CaseApproveSuggestVO caseApproveSuggestVO : caseApproveSuggests) {
				caseApproveSuggestVO.setApproverName(userInfoMapper.selectByPrimaryKey(caseApproveSuggestVO.getApproveId()).getName());
			}
		}
		
		CaseDocContentVO caseDocContent =null;
		String arbitratorName = null;
		String arbiSecretaryName = null;
		CaseDoc cd = caseDocMapper.queryCaseDocByApproveId(approveId);
		if(cd == null){
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}else{
			caseDocContent = caseDocContentMapper.queryDocContentByDocId(cd.getId());
			if(caseDocContent.getArbitratorId() == null || caseDocContent.getSecretaryId() == null){
				return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
			}else{
				arbitratorName = userInfoMapper.selectByPrimaryKey(caseDocContent.getArbitratorId()).getName();
				arbiSecretaryName = userInfoMapper.selectByPrimaryKey(caseDocContent.getSecretaryId()).getName();
				if(arbitratorName != null && arbiSecretaryName != null){
					caseDocContent.setArbiSecretaryName(arbiSecretaryName);
					caseDocContent.setArbitratorName(arbitratorName);
				}else{
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
				}
			}
		}
		
		vo.setAdjudicationAmendmentRecord(adjudicationAmendentRecord);
		vo.setAdjudicationAmendentHistoryRecords(adjudicationAmendentHistoryRecords);
		vo.setCaseBaseInfo(caseBaseInfo);
		vo.setCaseApproveSuggests(caseApproveSuggests);
		vo.setCurrentDuties(managerInfoMapper.queryDutiesByUserId(userId));
		vo.setCaseDocContent(caseDocContent);
		
		return BusiExecuteResult.builderSuccessResult(vo);
	}
				
	@Override
	public BusiExecuteResult<Coder> updateAdjudicationAmendment(AdjudicationAmendmentDTO formData) {
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());
		
		/*  常用参数初始化   */
		String id = sequenceService.getCommonID();
		Date date = new Date();
		String approveType = ApproveTypeEnum.CORRECTION_BOOK_APPROVAL.getTypeName();
		String caseId = caseApprove.getCaseId();
		
		
		//是否被授权
		String isAuthorized = null;
		if(caseApprove.getApproveUserId().equals(formData.getUserId())){
			isAuthorized = ApproveIsAuthorizedEnum.NOT_AUTHORIZED.getCode();
		}else{
			isAuthorized = ApproveIsAuthorizedEnum.AUTHORIZED.getCode();
		}
		
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();
		caseApproveSuggest.setId(id);
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(caseId);
		caseApproveSuggest.setCreaterId(formData.getUserId());
		caseApproveSuggest.setCreateTime(date);
		caseApproveSuggest.setIsAuthorized(isAuthorized);
			
		String mark = null;
		ManagerInfoTypeEnum managerDuties = ManagerInfoTypeEnum.getCode(caseApprove.getApproveUserId());
		switch(managerDuties){
			case ARBITRATION_SECRETARY :
				caseApproveSuggest.setSuggestUserDuties(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
				mark = CaseApproveDescribeEnum.ARBITRATION_SECRETARY_FIRST_TRIAL.getDescribe();
				caseApproveMapper.updateApproveUserAsManager(caseId, approveType, ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				break;
				
			case ARBITRATION_MINISTER :
				caseApproveSuggest.setSuggestUserDuties(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				if(formData.getOpinionStatus() !=null && OpinionStateEnum.GET_THROUGH.getValue().equals(formData.getOpinionStatus())){
					mark = CaseApproveDescribeEnum.ARBITRATION_MINISTER_PASS.getDescribe();
					caseApproveMapper.updateApproveUserAsManager(caseId, approveType, ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				}else{
					mark = CaseApproveDescribeEnum.ARBITRATION_MINISTER_SUGGESTION.getDescribe();
					caseApproveMapper.updateCaseApproveById(CaseApproveStatusEnum.FAIL_AUDIT.getValue(),formData.getApproveId());
					caseApproveMapper.updateApproveUserAsArbitrator(caseId, approveType);
				}
				break;
				
			case DEPUTY_DIRECTOR :
				caseApproveSuggest.setSuggestUserDuties(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				if(OpinionStateEnum.GET_THROUGH.getValue().equals(formData.getOpinionStatus())){
					mark = CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe();
					caseApproveMapper.updateApproveUserAsManager(caseId, approveType, ManagerInfoTypeEnum.DIRECTOR.getCode());
				}else{
					mark = CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe();
					caseApproveMapper.updateCaseApproveById(CaseApproveStatusEnum.FAIL_AUDIT.getValue(),formData.getApproveId());
					caseApproveMapper.updateApproveUserAsArbitrator(caseId, approveType);
					
				}
				break;
				
			case DIRECTOR :
				caseApproveSuggest.setSuggestUserDuties(ManagerInfoTypeEnum.DIRECTOR.getCode());
				if(OpinionStateEnum.GET_THROUGH.getValue().equals(formData.getOpinionStatus())){
					mark = CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe();
					
					String issueType = caseDocContentMapper.queryValidDocIssueTypeByBusiId(caseApprove.getBusiId());
					AdjudicationAmendmentRecord record = new AdjudicationAmendmentRecord();
					//判断最终结果是通过模板还是不通过模板
					if(CaseDocIssueTypeEnum.AGREE.getCode().equals(issueType)){
						record.setStatus(AmendStatusEnum.SUCCESS.getValue());
					}else{
						record.setStatus(AmendStatusEnum.FAIL.getValue());
					}
					record.setId(caseApprove.getBusiId());
					caseApproveMapper.updateCaseApproveById(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue(),formData.getApproveId());
					
					//更新补正记录表状态
					adjudicationAmendmentRecordMapper.updateByPrimaryKey(record);
					
					//发送文书
					//todo
				}else{
					mark = CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe();
					caseApproveMapper.updateCaseApproveById(CaseApproveStatusEnum.FAIL_AUDIT.getValue(),formData.getApproveId());
					caseApproveMapper.updateApproveUserAsArbitrator(caseId, approveType);
				}
				break;
				
			default :
				BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
				break;
		}
		caseApproveSuggest.setMark(mark);
		caseApproveSuggest.setOpinionStatus(formData.getOpinionStatus());
		//插入审批意见
		caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		
		return BusiExecuteResult.builderSuccessResult(ApiResultVO.Coder.SUCCESS);
	}

	/**
	 * 查询补正信息记录
	 * @param formData
	 * @return
	 * @return
	 */
	@Override
	public AmendmentContentVO queryAdjudicationAmendmentByCaseId(AdjudicationAmendmentDTO formData) {
		//根据案件id，审批类型查询审批id
		String approveId = caseApproveMapper
				.queryCaseApproveByApproveId(formData.getCaseId(), ApproveTypeEnum.CORRECTION_BOOK_APPROVAL.getTypeName());
		
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		
		//查询补正记录
		AmendmentContentVO amendmentContentVO = new AmendmentContentVO();
		List<AdjudicationAmendmentRecordWithBLOBs> adjudicationAmendentRecords = adjudicationAmendmentRecordMapper
			.queryAdjudicationAmendment(formData);
		PageInfo<AdjudicationAmendmentRecordWithBLOBs> pageInfo = new PageInfo<AdjudicationAmendmentRecordWithBLOBs>(adjudicationAmendentRecords);
		
		amendmentContentVO.setPageInfoAdjudication(pageInfo);
		amendmentContentVO.setApproveId(approveId);
		
		return amendmentContentVO;
	}

	/**
	 * 仲裁委-查询出具裁决补正书
	 */
	@Override
	public BusiExecuteResult<AmendmentContentVO> selectAdjudicationAmendment(
			AdjudicationAmendmentDTO formData) {
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());
		AmendmentContentVO vo = new AmendmentContentVO();
		
		AdjudicationAmendmentRecordWithBLOBs adjudicationWithBLOBs = adjudicationAmendmentRecordMapper
			.selectByPrimaryKey(formData.getAdjudicationId());
		
		//当事人基本信息
		CaseBaseInfoVO caseBaseInfo =  caseInfoMapper.queryCaseBaseInfoByRequestId(caseApprove.getRequestId());
		
		//案件审批记录
		List<CaseApproveSuggestVO> caseApproveSuggests = caseApproveSuggestMapper
				.queryApproveSuggestsByApproveId(formData.getApproveId());
		if(caseApproveSuggests != null && caseApproveSuggests.size()!=0){
			//初始化意见人姓名
			for (CaseApproveSuggestVO caseApproveSuggestVO : caseApproveSuggests) {
				caseApproveSuggestVO.setApproverName(userInfoMapper.selectByPrimaryKey(caseApproveSuggestVO.getCreaterId()).getName());
			}
		}
		
		vo.setAdjudicationWithBLOBs(adjudicationWithBLOBs);
		vo.setCaseBaseInfo(caseBaseInfo);
		vo.setCaseApproveSuggests(caseApproveSuggests);
		vo.setCurrentDuties(managerInfoMapper.queryDutiesByUserId(formData.getUserId()));
		
		return BusiExecuteResult.builderSuccessResult(vo);
	}

}
