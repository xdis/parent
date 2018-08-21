package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseCancelProcessRecord;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocExample;
import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.WithdrawRecordWithBLOBs;
import com.zyxy.common.dto.WithdrawRecordInsertDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseCancelProcessStatusEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.enums.TribunalMarkEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseCancelProcessRecordMapper;
import com.zyxy.common.mapper.CaseChangeRecordMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.WithdrawRecordMapper;
import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.service.micro.core.service.CaseWithdrawService;
import com.zyxy.service.micro.core.service.CommonService;

@Service
public class CaseWithdrawServiceImpl implements CaseWithdrawService {
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CaseDocMapper caseDocMapper;
	@Autowired
	private WithdrawRecordMapper withdrawRecordMapper;
	@Autowired
	private SequenceService sequenceSevice;
	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper;
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	@Autowired
	private ApproveTypeService approveTypeService;
	@Autowired
	private CaseFlowService caseFlowService;
	@Autowired
	private CaseCancelProcessRecordMapper caseCancelProcessRecordMapper;

	@Override
	public BusiValidResult caseWithDrawValid(WithdrawRecordInsertDTO formData) {
		//案件是否存在。
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
		if (caseInfo==null) {
			return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
		}
		//是否出裁决书不能撤案
		CaseDocExample example = new CaseDocExample();
		example.
			createCriteria().
				andCaseIdEqualTo(formData.getCaseId()).
					andDocTypeEqualTo(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
		List<CaseDoc> caseDocs =  caseDocMapper.selectByExample(example);
		if (caseDocs.size()>0) {
			return BusiValidResult.builderErrorResult(Coder.CASE_ALREADY_ADJUDICATION);
		}
		RequestTypeEnum enums =commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> caseWithDrawExecute(
			WithdrawRecordInsertDTO formData) {
		//查询当前请求类型
		RequestTypeEnum enums =commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getUserId());
		formData.setRequestFlag(enums.getValue());
		
		String requestId = caseChangeRecordMapper.seleceRequsetIdByCaseIdAndRequestFlag(formData.getCaseId(), formData.getRequestFlag());
		Date date = new Date();
		WithdrawRecordWithBLOBs record = new WithdrawRecordWithBLOBs();
		String busiId = sequenceSevice.getCommonID();
		record.setId(busiId);
		record.setCaseId(formData.getCaseId());
		record.setApplication(formData.getApplication());
		record.setFact(formData.getReason());
		record.setRequestId(requestId);
		record.setCreateId(formData.getUserId());
		record.setCreateTime(date);
		int rows = withdrawRecordMapper.insert(record);
		//查询当前审批人
		String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(),ManagerInfoStatusEnum.NORMAL.getCode());
		//撤案审批记录
		CaseApprove approve = new CaseApprove();
		approve.setId(sequenceSevice.getCommonID());
		approve.setCaseId(formData.getCaseId());
		approve.setRequestId(requestId);
		approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		approve.setBusiId(busiId);
		approve.setCreaterId(formData.getUserId());
		approve.setCreateTime(date);
		approve.setApproveUserId(userId);
		//撤案申请书
		CaseDoc caseDoc = new CaseDoc();
		caseDoc.setId(sequenceSevice.getCommonID());
		//签章状态待定
		caseDoc.setCaseId(formData.getCaseId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定
		caseDoc.setCreaterId(formData.getUserId());
		caseDoc.setCreateTime(date);
		
		//审批类型对象
		ApproveType key = new ApproveType();
		
		//根据请求类型设置申请书和审批的请求类型
		if (RequestTypeEnum.REQUEST.getValue().equals(formData.getRequestFlag())) {
			//approve.setApproveType(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName());
			key.setTypeName(ApproveTypeEnum.THIS_REQUEST_WITHDRAW_CASE_APPROVE.getTypeName());
			caseDoc.setDocType(CaseDocTypeEnum.CANCEL_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.CANCEL_APPLY_BOOK.getDocName());
		}else if(RequestTypeEnum.BACK_REQUEST.getValue().equals(formData.getRequestFlag())) {
			//approve.setApproveType(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName());
			key.setTypeName(ApproveTypeEnum.COUNTER_CLAIM_CASE_APPROVE.getTypeName());
			caseDoc.setDocType(CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getDocName());
		}
		
		//查询出审批对象
		approveTypeService.selectCacheByPrimaryKey(key);
		approve.setApproveType(key.getTypeName());
		
		//是否组庭
		if (caseFlowService.isSendGroupNotice(formData.getCaseId())) {
			approve.setTribunalMark(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode());
			CaseCancelProcessRecord cancelProcessRecord = new CaseCancelProcessRecord();
			cancelProcessRecord.setId(sequenceSevice.getCommonID());
			cancelProcessRecord.setCaseId(formData.getCaseId());
			cancelProcessRecord.setRetuestType(enums.getValue());
			cancelProcessRecord.setStatus(CaseCancelProcessStatusEnum.WAIT_DECISION.getValue());
			caseCancelProcessRecordMapper.insertSelective(cancelProcessRecord);
			
		}else{
			approve.setTribunalMark(TribunalMarkEnum.NOT_TRIBUNAL.getCode());
			caseApproveMapper.insertSelective(approve);
		}
		caseDocMapper.insertSelective(caseDoc);
		
		return rows>0?BusiExecuteResult.builderSuccessResult():BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}

}
