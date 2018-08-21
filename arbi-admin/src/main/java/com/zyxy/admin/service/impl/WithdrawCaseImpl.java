package com.zyxy.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.admin.service.WithdrawCaseService;
import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocContentWithBLOBs;
import com.zyxy.common.domain.CaseRequestInfo;
import com.zyxy.common.domain.CaseRequestInfoWithBLOBs;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.domain.WithdrawRecordWithBLOBs;
import com.zyxy.common.dto.ArbitrationCaseDecisionHandleDTO;
import com.zyxy.common.dto.flow.CaseCancelDTO;
import com.zyxy.common.enums.ApproveIsAuthorizedEnum;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveDescribeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseDocContentIssueTypeEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.OpinionStateEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.enums.TribunalMarkEnum;
import com.zyxy.common.enums.WithdrawCaseTypeEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseApproveSuggestMapper;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseDocContentMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.CaseNoSeqMapper;
import com.zyxy.common.mapper.CaseRequestInfoMapper;
import com.zyxy.common.mapper.DocSendRecordMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.mapper.WithdrawRecordMapper;
import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationWithdrawCaseDecisionVO;
import com.zyxy.common.vo.CaseApproveSuggestVO;
import com.zyxy.common.vo.CaseBaseInfoVO;
import com.zyxy.common.vo.CaseDocContentVO;

@Service
public class WithdrawCaseImpl implements WithdrawCaseService{
	@Autowired
	CaseInfoMapper caseInfoMapper;
	
	@Autowired
	DocSendRecordMapper docSendRecordMapper;
	
	@Autowired
	SequenceService sequenceService;
	
	@Autowired
	CaseApproveSuggestMapper caseApproveSuggestMapper;
	
	@Autowired
	CaseDocContentMapper caseDocContentMapper;
	
	@Autowired
	CaseDocMapper caseDocMapper;
	
	@Autowired
	WhetherDistributionService whetherDistributionService;
	
	@Autowired
	CaseManagerMapper caseManagerMapper;
	
	@Autowired
	ApproveTypeService approveTypeService;
	
	@Autowired
	MicroFlowService microFlowService;
	
	@Autowired
	CaseApproveMapper caseApproveMapper;
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	WithdrawRecordMapper withdrawRecordMapper;
	
	@Autowired
	CaseArbitratorMapper caseArbitratorMapper;
	
	@Autowired
	CaseNoSeqMapper caseNoSeqMapper;
	
	@Autowired
	CaseRequestInfoMapper caseRequestInfoMapper;
	@Override
	public BusiExecuteResult<ArbitrationWithdrawCaseDecisionVO> arbitrationWithdrawCaseContentBusiExecute(
			String approveId, String userId) {
		//案件审批
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);
		
		//撤案审批页面展示对象
		ArbitrationWithdrawCaseDecisionVO withdrawCaseDecision = new ArbitrationWithdrawCaseDecisionVO();
		
		//当事人信息
		CaseBaseInfoVO caseBaseInfo = caseInfoMapper.queryCaseBaseInfoByRequestId(caseApprove.getRequestId());
		
		//案件文书
		CaseDoc caseDoc = caseDocMapper.queryCaseDocByApproveId(approveId);
		
		//案件文书内容
		CaseDocContentVO caseDocContent = null;
		String arbiSecretaryName = null;
		String arbitratorName = null;
		//仲裁员结案类型
		String arbitratorAcceptType = null;
		if(caseDoc == null ){
			arbiSecretaryName = userInfoMapper.selectByPrimaryKey(userId).getName();
		}else{
			caseDocContent = caseDocContentMapper.queryDocContentByDocId(caseDoc.getId());
			if(caseDocContent != null && caseDocContent.getSecretaryId() != null){
				arbiSecretaryName = userInfoMapper.selectByPrimaryKey(caseDocContent.getSecretaryId()).getName();
			}
			if(caseDocContent != null && caseDocContent.getArbitratorId() != null
					&& TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(caseApprove.getTribunalMark())){
				arbitratorName = userInfoMapper.selectByPrimaryKey(caseDocContent.getArbitratorId()).getName();
			}
			
			arbitratorAcceptType = caseArbitratorMapper.queryArbitratorAcceptType(caseDocContent.getArbitratorId(),caseDocContent.getCaseId());
		}
		caseDocContent.setArbiSecretaryName(arbiSecretaryName);
		caseDocContent.setArbitratorName(arbitratorName);
		
		//撤案申请书
		WithdrawRecordWithBLOBs withdrawRecord = withdrawRecordMapper.selectByPrimaryKey(caseApprove.getBusiId());
		
		//审批记录
		List<CaseApproveSuggestVO> caseApproveSuggests = caseApproveSuggestMapper.queryApproveSuggestsByApproveId(approveId);
		for (CaseApproveSuggestVO caseApproveSuggestVO : caseApproveSuggests) {
			caseApproveSuggestVO.setApproverName(userInfoMapper.selectByPrimaryKey(caseApproveSuggestVO.getCreaterId()).getName());
		}
		
		//当前身份
		String currentDuties = managerInfoMapper.queryDutiesByUserId(userId);
		
		//案件受理时间
		String caseAcceptTime =docSendRecordMapper.selectAcceptTimeByRequestId(caseApprove.getRequestId());
		
		//相反类型的审批id
		String opppsiteWithdrawCaseTypeApproveId = caseApproveMapper.queryOppositeApproveId(caseApprove.getCaseId(), caseApprove.getApproveType());
		
		//请求类型
		CaseRequestInfoWithBLOBs caseRequestInfo = caseRequestInfoMapper.selectByPrimaryKey(caseApprove.getRequestId());
		if(caseRequestInfo == null){
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}
		String requestType =caseRequestInfo.getRequestType();
		
		//撤案类型  
		String withdrawCaseType = null;
		String busiId = caseDocContentMapper
				.queryApprovePassAndIssueTypeIsPassApproval(
						caseApprove.getCaseId(), 
						ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName().equals(caseApprove.getApproveType())
						? ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName()
								: ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName());
		
		Date oppositeWithdrawRecordCreateTime = null;
		if(busiId != null ){
			withdrawCaseType = WithdrawCaseTypeEnum.BOTH_WITHDRAW_CASE.getCode();
			WithdrawRecordWithBLOBs oldWithdrawRecord = withdrawRecordMapper.selectByPrimaryKey(busiId);
			if(oldWithdrawRecord == null || oldWithdrawRecord.getCreateTime()==null){
				return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
			}else{
				oppositeWithdrawRecordCreateTime = oldWithdrawRecord.getCreateTime();
			}
		}else{
			withdrawCaseType = WithdrawCaseTypeEnum.LITIGANT_WITHDRAW_CASE.getCode();
		}
		
		//组庭通知书
		CaseDocContentVO trinualNotice =null;
		CaseDoc cd = caseDocMapper.queryValidDocByRequestIdAndDocType(caseApprove.getRequestId(), CaseDocTypeEnum.TRIBUNAL_NOTICE.getCode());
		if(cd != null){
			trinualNotice = caseDocContentMapper.queryDocContentByDocId(cd.getId());
			if(trinualNotice != null && trinualNotice.getArbitratorId() != null){
				UserInfo ui = userInfoMapper.selectByPrimaryKey(trinualNotice.getArbitratorId());
				if(ui != null){
					trinualNotice.setArbitratorName(ui.getName());
				}
			}
		}
		
		List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectCaseRequestInfoByCaseId(caseApprove.getCaseId());
		if(caseRequestInfos.size() == 2){
			for (CaseRequestInfo temp : caseRequestInfos) {
				if( RequestTypeEnum.REQUEST.getValue().equals(temp.getRequestType()) ){
					withdrawCaseDecision.setRequestArbiFee(temp.getCaseHandlingAmount().add(temp.getCaseAdmissibleAmount()).intValue());
					withdrawCaseDecision.setRequestRefund(temp.getShouldBeRefund().intValue());
				}else{
					withdrawCaseDecision.setCouterclaimArbiFee(temp.getCaseHandlingAmount().add(temp.getCaseAdmissibleAmount()).intValue());
					withdrawCaseDecision.setCouterclaimRefund(temp.getShouldBeRefund().intValue());
				}
			}
		}
		
		withdrawCaseDecision.setCaseBaseInfo(caseBaseInfo);
		withdrawCaseDecision.setCaseDoc(caseDoc);
		withdrawCaseDecision.setCaseDocContent(caseDocContent);
		withdrawCaseDecision.setWithdrawRecord(withdrawRecord);
		withdrawCaseDecision.setCaseApproveSuggests(caseApproveSuggests);
		withdrawCaseDecision.setCaseAcceptTime(caseAcceptTime);
		withdrawCaseDecision.setCurrentDuties(currentDuties);
		withdrawCaseDecision.setArbitratorAcceptType(arbitratorAcceptType);
		withdrawCaseDecision.setWithdrawCaseType(withdrawCaseType);
		withdrawCaseDecision.setCaseApprove(caseApprove);
		withdrawCaseDecision.setRequestType(requestType);
		withdrawCaseDecision.setOpppsiteWithdrawCaseTypeApproveId(opppsiteWithdrawCaseTypeApproveId);
		withdrawCaseDecision.setOppositeWithdrawRecordCreateTime(oppositeWithdrawRecordCreateTime);
		withdrawCaseDecision.setTrinualNotice(trinualNotice);
		
		return BusiExecuteResult.builderSuccessResult(withdrawCaseDecision);
	}

	@Override
	public BusiExecuteResult arbitrationWithdrawCaseApproveBusiExecute(
			ArbitrationCaseDecisionHandleDTO formData) {
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());
		if(caseApprove == null){
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}
		
		
		/*  常用参数初始化   */
		String caseId=caseApprove.getCaseId();
		Date date = new Date();
		String id = sequenceService.getCommonID();
		String mark = null;
		String isAuthorized = null;
		String requestFlag = null;
		
		CaseRequestInfo caseRequestInfo = caseRequestInfoMapper.selectByPrimaryKey(caseApprove.getRequestId());
		if(caseRequestInfo == null){
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}else{
			requestFlag = caseRequestInfo.getRequestType();
		}
		
		String docName = null;
		String docType = null;
		String tribunalMark = caseApprove.getTribunalMark();
		
		//文书名、文书类型
		if(RequestTypeEnum.REQUEST.getValue().equals(requestFlag)){
			docName = CaseDocTypeEnum.CANCEL_APPLY_BOOK.getCode();
			docType = CaseDocTypeEnum.CANCEL_APPLY_BOOK.getDocName();
		}else{
			docName = CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getCode();
			docType = CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getDocName();
		}
		
		//是否授权
		if(formData.getUserId().equals(caseApprove.getApproveUserId())){
			isAuthorized = ApproveIsAuthorizedEnum.NOT_AUTHORIZED.getCode();
		}else{
			isAuthorized = ApproveIsAuthorizedEnum.AUTHORIZED.getCode();
		}
		
		//撤案标志
		boolean withdrawCaseFlag=false;
		
		String approveDuties = managerInfoMapper.queryDutiesByUserId(caseApprove.getApproveUserId());
		if(approveDuties == null){
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}else{
			ManagerInfoTypeEnum managerDuties = ManagerInfoTypeEnum.getCode(approveDuties);
			CaseApproveSuggest caseApproveSuggest = null;
			switch(managerDuties){
				case ARBITRATION_SECRETARY :
					if( TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(tribunalMark) ){
						caseApproveSuggest=new CaseApproveSuggest();
						caseApproveSuggest.setCaseId(caseId);
						caseApproveSuggest.setApproveId(formData.getApproveId());
						caseApproveSuggest.setCreateTime(date);
						caseApproveSuggest.setCreaterId(formData.getUserId());
						caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
						caseApproveSuggest.setIsAuthorized(isAuthorized);
						caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_SECRETARY_FIRST_TRIAL.getDescribe());
						caseApproveSuggest.setId(id);
						caseApproveSuggest.setSuggestUserDuties(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
						
						caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
						
					}else{
						CaseDoc caseDoc = caseDocMapper.queryCaseDocByApproveId(formData.getApproveId());
						CaseDocContentWithBLOBs cdcWithBLOBs =null;
						
						if( caseDoc != null ){
							cdcWithBLOBs=caseDocContentMapper.queryDocContentByDocId(caseDoc.getId());
							
							if(cdcWithBLOBs.getIssueType() != null ){ 
								if(formData.getIssueType().equals(cdcWithBLOBs.getIssueType())){
									cdcWithBLOBs = new CaseDocContentWithBLOBs();
									cdcWithBLOBs.setBodyText(formData.getBodyText());
									cdcWithBLOBs.setFinalDecision(formData.getFinalDecision());
									cdcWithBLOBs.setOpinion(formData.getOpinion());
									cdcWithBLOBs.setDocId(caseDoc.getId());
									
									//修改文书内容
									caseDocContentMapper.updateCaseDocContentByDocId(cdcWithBLOBs);
									
								}else{
									cdcWithBLOBs = new CaseDocContentWithBLOBs();
									caseDoc.setStatus(CaseDocStatusEnum.DISUSE.getCode());
									//修改原文书状态为废弃
									caseDocMapper.updateByPrimaryKey(caseDoc);
									
									//添加文书表内容
									/* 文书表内容     */
							 		caseDoc.setId(id);
									caseDoc.setDocName(docName);
									caseDoc.setDocType(docType);
//									caseDoc.setSignStatus(signStatus);
//									caseDoc.setFileId(fileId);
									caseDoc.setCaseId(caseApprove.getCaseId());
									caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
									caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
									caseDoc.setDocYearNumber(DateUtil.formatDate(new Date(), "yyyy"));
//									caseDoc.setDocSerialNumber(docSerialNumber);
//									caseDoc.setSignSignetLogId(signSignetLogId);
									caseDoc.setCreaterId(formData.getUserId());
									caseDoc.setCreateTime(new Date());
									caseDoc.setRequestId(caseApprove.getRequestId());
									caseDoc.setBusiId(caseApprove.getBusiId());
									
									
									/*  文书内容表内容   */
									cdcWithBLOBs = new CaseDocContentWithBLOBs();
									cdcWithBLOBs.setId(sequenceService.getCommonID());
									cdcWithBLOBs.setCaseId(caseApprove.getCaseId());
									cdcWithBLOBs.setRequestId(caseApprove.getRequestId());
									cdcWithBLOBs.setBodyText(formData.getBodyText());
									cdcWithBLOBs.setOpinion(formData.getOpinion());
									cdcWithBLOBs.setFinalDecision(formData.getFinalDecision());
									cdcWithBLOBs.setIssueType(formData.getIssueType());
//									cdcWithBLOBs.setIssueId(issueId);
//									cdcWithBLOBs.setIssusTime(issusTime);
									cdcWithBLOBs.setCreateTime(new Date());
									cdcWithBLOBs.setDocId(id);
//									cdcWithBLOBs.setArbitratorId(arbitratorId);???有仲裁员吗
									cdcWithBLOBs.setSecretaryId(caseApprove.getApproveUserId());
									
									//插入记录
									caseDocMapper.insertSelective(caseDoc);
									caseDocContentMapper.insertSelective(cdcWithBLOBs);
								}
								
							}else{
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
							}
							
						}else{
							/* 文书表内容     */
							caseDoc = new CaseDoc();
					 		caseDoc.setId(id);
							caseDoc.setDocName(docName);
							caseDoc.setDocType(docType);
//							caseDoc.setSignStatus(signStatus);
//							caseDoc.setFileId(fileId);
							caseDoc.setCaseId(caseApprove.getCaseId());
							caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
							caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
							caseDoc.setDocYearNumber(DateUtil.formatDate(new Date(), "yyyy"));
//							caseDoc.setDocSerialNumber(docSerialNumber);
//							caseDoc.setSignSignetLogId(signSignetLogId);
							caseDoc.setCreaterId(formData.getUserId());
							caseDoc.setCreateTime(new Date());
							caseDoc.setRequestId(caseApprove.getRequestId());
							caseDoc.setBusiId(caseApprove.getBusiId());
							
							/*  文书内容表内容   */
							cdcWithBLOBs = new CaseDocContentWithBLOBs();
							cdcWithBLOBs.setId(sequenceService.getCommonID());
							cdcWithBLOBs.setCaseId(caseApprove.getCaseId());
							cdcWithBLOBs.setRequestId(caseApprove.getRequestId());
							cdcWithBLOBs.setBodyText(formData.getBodyText());
							cdcWithBLOBs.setOpinion(formData.getOpinion());
							cdcWithBLOBs.setFinalDecision(formData.getFinalDecision());
							cdcWithBLOBs.setIssueType(formData.getIssueType());
//							cdcWithBLOBs.setIssueId(issueId);
//							cdcWithBLOBs.setIssusTime(issusTime);
							cdcWithBLOBs.setCreateTime(new Date());
							cdcWithBLOBs.setDocId(id);
//							cdcWithBLOBs.setArbitratorId(arbitratorId);
							cdcWithBLOBs.setSecretaryId(caseApprove.getApproveUserId());
							
							//插入记录
							caseDocMapper.insertSelective(caseDoc);
							caseDocContentMapper.insertSelective(cdcWithBLOBs);
						}
						
						//创建审批类型对象
						ApproveType key = new ApproveType();
						key.setTypeName(caseApprove.getApproveType());
						approveTypeService.selectCacheByPrimaryKey(key);

					}
					// 判断当前案件是否有仲裁部长	
					boolean arbitrationMinisterExist = whetherDistributionService
							.queryCaseManagerInfo(caseApprove.getCaseId(),
									ManagerInfoTypeEnum.ARBITRATION_MINISTER
									.getCode());
					if (!arbitrationMinisterExist) {// 没有部长
						// 分配仲裁部长
						int ampbt = caseManagerMapper
								.allotManagerPeopleByCaseAndType(
										caseApprove.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
						if (ampbt < 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);//更新失败
						}
					}
				
					caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
					break;
					
				case ARBITRATION_MINISTER:
					caseApproveSuggest=new CaseApproveSuggest();
					caseApproveSuggest.setCaseId(caseId);
					caseApproveSuggest.setApproveId(formData.getApproveId());
					caseApproveSuggest.setCreateTime(date);
					caseApproveSuggest.setCreaterId(formData.getUserId());
					caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
					caseApproveSuggest.setId(id);
					
					//部长驳回
					if(OpinionStateEnum.REJECTED.getValue().equals(formData.getOpinionStatus())){
						//是否组庭
						if( TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(tribunalMark) ){
							caseApproveMapper.updateApproveUserAsArbitrator(caseId, caseApprove.getApproveType());
							mark = CaseApproveDescribeEnum.ARBITRATION_MINISTER_SUGGESTION.getDescribe();
						}else{
							mark = CaseApproveDescribeEnum.ARBITRATION_MINISTER_NO_PASS.getDescribe();
							caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
						}
						
						caseApproveMapper.changeApproveStatus(caseId, caseApprove.getApproveType(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					}else{
						mark = CaseApproveDescribeEnum.ARBITRATION_MINISTER_PASS.getDescribe();
						caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					}
					caseApproveSuggest.setMark(mark);
					caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
					
					// 判断当前案件是否有副主任
					boolean deputyDirectorExist = whetherDistributionService
							.queryCaseManagerInfo(caseApprove.getCaseId(),
									ManagerInfoTypeEnum.DEPUTY_DIRECTOR
									.getCode());
					if (!deputyDirectorExist) {// 没有部长
						// 分配仲裁部长
						int ampbt = caseManagerMapper
								.allotManagerPeopleByCaseAndType(
										caseApprove.getCaseId(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
						if (ampbt < 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);//更新失败
						}
					}
					break;
					
				case DEPUTY_DIRECTOR:
					caseApproveSuggest=new CaseApproveSuggest();
					caseApproveSuggest.setCaseId(caseId);
					caseApproveSuggest.setApproveId(formData.getApproveId());
					caseApproveSuggest.setCreateTime(date);
					caseApproveSuggest.setCreaterId(formData.getUserId());
					caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
					caseApproveSuggest.setId(id);
					
					//部长驳回
					if(OpinionStateEnum.REJECTED.getValue().equals(formData.getOpinionStatus())){
						//是否组庭
						if( TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(tribunalMark) ){
							caseApproveMapper.updateApproveUserAsArbitrator(caseId, caseApprove.getApproveType());
							mark = CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe();
						}else{
							mark = CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe();
							caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
						}
						
						caseApproveMapper.changeApproveStatus(caseId, caseApprove.getApproveType(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					}else{
						mark = CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe();
						caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					}
					caseApproveSuggest.setMark(mark);
					caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
					
					// 判断当前案件是否有副主任
					boolean directorExist = whetherDistributionService
							.queryCaseManagerInfo(caseApprove.getCaseId(),
									ManagerInfoTypeEnum.DIRECTOR
									.getCode());
					if (!directorExist) {// 没有部长
						// 分配仲裁部长
						int ampbt = caseManagerMapper
								.allotManagerPeopleByCaseAndType(
										caseApprove.getCaseId(), ManagerInfoTypeEnum.DIRECTOR.getCode());
						if (ampbt < 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);//更新失败
						}
					}
					break;
					
				case DIRECTOR:
					caseApproveSuggest=new CaseApproveSuggest();
					caseApproveSuggest.setCaseId(caseId);
					caseApproveSuggest.setApproveId(formData.getApproveId());
					caseApproveSuggest.setCreateTime(date);
					caseApproveSuggest.setCreaterId(formData.getUserId());
					caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
					caseApproveSuggest.setId(id);
					caseApproveSuggest.setOpinionStatus(formData.getOpinionStatus());
					
					//驳回
					if(OpinionStateEnum.REJECTED.getValue().equals(formData.getOpinionStatus())){
						if( TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(tribunalMark) ){
							caseApproveMapper.updateApproveUserAsArbitrator(caseId, caseApprove.getApproveType());
							mark = CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe();
						}else{
							caseApproveMapper.updateApproveUserAsManager(caseId, caseApprove.getApproveType(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
							mark = CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe();
						}
						caseApproveMapper.changeApproveStatus(caseId, caseApprove.getApproveType(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					}else{//通过
						mark = CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe();
						
						//同意撤案
						if(CaseDocContentIssueTypeEnum.AGREE_MODULE.getCode().equals(formData.getIssueType())){
							withdrawCaseFlag = true;
						}
					}
					
					caseApproveSuggest.setMark(mark);
					caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
					
					caseApproveMapper.changeApproveStatus(caseId, caseApprove.getApproveType(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					
					//取消任务
					if(withdrawCaseFlag){
						CaseCancelDTO caseCanceDTO = new CaseCancelDTO();
						caseCanceDTO.setCaseId(caseId);
						caseCanceDTO.setRequestType(requestFlag);
						caseCanceDTO.setUserId(formData.getUserId());
						ApiResultVO<String> apiResultVO=microFlowService.cancelCase(caseId, caseCanceDTO);
						if(! ApiResultVO.Coder.SUCCESS.getCode().equals(apiResultVO.getHead().getRetCode()) ){
							return BusiExecuteResult.builderErrorResult(apiResultVO.getHead().getRetCode(),apiResultVO.getHead().getMsg());
						}
					}
					break;
					
					default:
						BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
						break;
			}
		}
		return BusiExecuteResult.builderSuccessResult(ApiResultVO.Coder.SUCCESS);
	}

}
