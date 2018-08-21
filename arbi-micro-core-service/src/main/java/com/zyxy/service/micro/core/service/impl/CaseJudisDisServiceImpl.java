package com.zyxy.service.micro.core.service.impl;

import java.util.Date;

import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseJurisDisExample;
import com.zyxy.common.domain.CaseJurisDisProcessRecord;
import com.zyxy.common.domain.CaseJurisDisWithBLOBs;
import com.zyxy.common.dto.CaseJurisDisInsertDTO;
import com.zyxy.common.dto.JurisDisFeedBackDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.CaseJurisDisProcessStatusEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.enums.TribunalMarkEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseChangeRecordMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseJurisDisMapper;
import com.zyxy.common.mapper.CaseJurisDisProcessRecordMapper;
import com.zyxy.service.micro.core.service.CaseJurisDisService;
import com.zyxy.service.micro.core.service.CommonService;

/**
 * 申请管辖权异议service
 */
@Service
public class CaseJudisDisServiceImpl implements CaseJurisDisService {

	@Autowired
	private CaseJurisDisMapper caseJurisDisMapper;
	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper; 
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CaseDocMapper caseDocMapper;
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	@Autowired
	private ApproveTypeService approveTypeService;
	@Autowired
	private CaseFlowService caseFlowService;
	@Autowired
	private CaseJurisDisProcessRecordMapper caseJurisDisProcessRecordMapper;
	
	@Override
	public BusiExecuteResult<String> insertCaseJurisDis(CaseJurisDisInsertDTO formData) {
		//查询当前请求类型
		RequestTypeEnum enums =commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getCreaterId());
		if (enums==null) {
			return BusiExecuteResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		formData.setCounterclaimFlag(enums.getValue());
		
		Date date = new Date();
		CaseJurisDisWithBLOBs caseJurisDis = new CaseJurisDisWithBLOBs();
		String busiId =sequenceService.getCommonID();
		caseJurisDis.setId(busiId);
		caseJurisDis.setCaseId(formData.getCaseId());
		caseJurisDis.setReason(formData.getReason());
		caseJurisDis.setCreaterId(formData.getCreaterId());
		caseJurisDis.setJurisId(formData.getCreaterId());
		caseJurisDis.setCounterclaimFlag(formData.getCounterclaimFlag());
		caseJurisDis.setCreateTime(date);
		caseJurisDis.setRequestItem(formData.getRequestItem());
		String requestId = caseChangeRecordMapper.seleceRequsetIdByCaseIdAndRequestFlag(formData.getCaseId(), formData.getCounterclaimFlag());
		if (requestId==null) {
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		caseJurisDis.setRequestId(requestId);
		caseJurisDisMapper.insert(caseJurisDis);
		
		//管辖区异议审批记录
		CaseApprove approve = new CaseApprove();
		
		//管辖区异议申请书
		CaseDoc caseDoc = new CaseDoc();
		
		//创建审批类型对象
		ApproveType key = new ApproveType();
		
		if (RequestTypeEnum.REQUEST.getValue().equals(formData.getCounterclaimFlag())) {
			//approve.setApproveType(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
			key.setTypeName(ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName());
			
			caseDoc.setDocType(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_APPLY_BOOK.getDocName());
		}else if (RequestTypeEnum.BACK_REQUEST.getValue().equals(formData.getCounterclaimFlag())) {
			//approve.setApproveType(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
			key.setTypeName(ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName());
			
			caseDoc.setDocType(CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_APPLY_BOOK.getDocName());
		}
				
		//查询审批类型
		approveTypeService.selectCacheByPrimaryKey(key);

		approve.setApproveType(key.getTypeName());
		approve.setId(sequenceService.getCommonID());
		approve.setCaseId(formData.getCaseId());
		approve.setRequestId(busiId);
		approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		approve.setBusiId(requestId);
		approve.setCreaterId(formData.getCreaterId());
		approve.setCreateTime(date);

		//是否组庭
		if (caseFlowService.isSendGroupNotice(formData.getCaseId())) {
			approve.setTribunalMark(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode());
		
			CaseJurisDisProcessRecord disProcessRecord = new CaseJurisDisProcessRecord();
			disProcessRecord.setId(sequenceService.getCommonID());
			disProcessRecord.setCaseId(formData.getCaseId());
			disProcessRecord.setRequestType(enums.getValue());
			disProcessRecord.setStatus(CaseJurisDisProcessStatusEnum.WAIT_DECISION.getValue());
			caseJurisDisProcessRecordMapper.insertSelective(disProcessRecord);
		}else{
			approve.setTribunalMark(TribunalMarkEnum.NOT_TRIBUNAL.getCode());
			caseApproveMapper.insertSelective(approve);
		}
		
		
		
		caseDoc.setId(sequenceService.getCommonID());
		//签章状态待定################
		caseDoc.setCaseId(formData.getCaseId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定############
		caseDoc.setCreaterId(formData.getCreaterId());
		caseDoc.setCreateTime(date);
		caseDocMapper.insertSelective(caseDoc);
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult jurisDisFeedBackValid(JurisDisFeedBackDTO formData) {
		RequestTypeEnum enums = commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		CaseJurisDisExample example =new CaseJurisDisExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andCounterclaimFlagEqualTo(enums.getValue());
		if (caseJurisDisMapper.selectByExample(example).size()==0) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> jurisDisFeedBackExecute(JurisDisFeedBackDTO formData) {
		CaseJurisDisWithBLOBs record = new CaseJurisDisWithBLOBs();
		record.setFeedBack(formData.getFeedBack());
		record.setFeedBackId(formData.getUserId());
		record.setFeedBackTime(new Date());
		RequestTypeEnum enums = commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getUserId());
		CaseJurisDisExample example =new CaseJurisDisExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andCounterclaimFlagEqualTo(enums.getValue());
		caseJurisDisMapper.updateByExampleSelective(record, example);
		return BusiExecuteResult.builderSuccessResult();
	}

}
