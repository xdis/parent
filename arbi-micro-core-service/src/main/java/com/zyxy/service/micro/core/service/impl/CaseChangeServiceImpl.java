package com.zyxy.service.micro.core.service.impl;

import java.util.Date;

import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseChangeRecordWithBLOBs;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.dto.CaseChangeRecordInsertDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseChangeStatusEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseChangeRecordMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.service.micro.core.service.CaseChangeService;
import com.zyxy.service.micro.core.service.CommonService;

/**
 * 更改仲裁请求Service实现类
 */
@Service
public class CaseChangeServiceImpl implements CaseChangeService {

	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseDocMapper caseDocMapper;

	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private ApproveTypeService approveTypeService;
	
	/**
	 * 插入更改仲裁申请记录
	 * @param formData
	 * @return
	 */
	@Override
	public BusiExecuteResult<String> insertCaseChangeRecordBusiExecute(CaseChangeRecordInsertDTO formData) {
		//查询当前请求类型
		RequestTypeEnum enums =commonService.queryRequestTypeByUserId(formData.getCaseId(), formData.getCreaterId());
		if (enums==null) {
			return BusiExecuteResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		formData.setCounterclaimFlag(enums.getValue());
		Date date = new Date();
		CaseChangeRecordWithBLOBs record = new CaseChangeRecordWithBLOBs();
		String busiId =sequenceService.getCommonID();
		record.setId(busiId);
		record.setCaseId(formData.getCaseId());
		record.setCounterclaimFlag(formData.getCounterclaimFlag());
		record.setCreaterId(formData.getCreaterId());
		record.setUserId(formData.getCreaterId());
		record.setStatus(CaseChangeStatusEnum.WAIT_AUDIT.getValue());
		record.setCreateTime(new Date());
		record.setChangeRequest(formData.getChangeRequest());
		record.setFactReason(formData.getFactReason());
		String requestId = caseChangeRecordMapper.seleceRequsetIdByCaseIdAndRequestFlag(formData.getCaseId(), formData.getCounterclaimFlag());
		if (requestId == null) {
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		
		record.setRequestId(requestId);
		caseChangeRecordMapper.insert(record);
		
		//查询当前审批人
		String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(),ManagerInfoStatusEnum.NORMAL.getCode());
		//变更请求审批
		CaseApprove approve = new CaseApprove();
		approve.setId(sequenceService.getCommonID());
		approve.setCaseId(formData.getCaseId());
		approve.setRequestId(requestId);
		approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		approve.setBusiId(busiId);
		approve.setCreaterId(formData.getCreaterId());
		approve.setCreateTime(date);
		approve.setApproveUserId(userId);

		//变更请求申请书
		CaseDoc caseDoc = new CaseDoc();
		caseDoc.setId(sequenceService.getCommonID());
		//签章状态待定
		caseDoc.setCaseId(formData.getCaseId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定
		caseDoc.setCreaterId(formData.getCreaterId());
		caseDoc.setCreateTime(date);
		
		//审批类型对象
		ApproveType key = new ApproveType();
		
		if (RequestTypeEnum.REQUEST.getValue().equals(formData.getCounterclaimFlag())) {
			//approve.setApproveType(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName());
			
			key.setTypeName(ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST.getTypeName());
			
			caseDoc.setDocType(CaseDocTypeEnum.CHANGE_REQUEST_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.CHANGE_REQUEST_APPLY_BOOK.getDocName());
		}else if(RequestTypeEnum.BACK_REQUEST.getValue().equals(formData.getCounterclaimFlag())) {
			//approve.setApproveType(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName());
			
			key.setTypeName(ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName());
			caseDoc.setDocType(CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.CANCEL_BECK_REQUEST_APPLY_BOOK.getDocName());
		}
		
		//查询出审批类型对象
		approveTypeService.selectCacheByPrimaryKey(key);

		approve.setApproveType(key.getTypeName());
		
		//插入数据
		caseApproveMapper.insertSelective(approve);
		caseDocMapper.insertSelective(caseDoc);
		
		return BusiExecuteResult.builderSuccessResult();
	}
}
