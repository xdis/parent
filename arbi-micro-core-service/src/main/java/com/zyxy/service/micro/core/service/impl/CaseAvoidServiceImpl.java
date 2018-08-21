package com.zyxy.service.micro.core.service.impl;

import java.util.Date;

import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseAvoidRecordWithBLOBs;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseAvoidStatusEnum;
import com.zyxy.common.enums.CaseAvoidStyleEnum;
import com.zyxy.common.enums.CaseAvoidTypeEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseAvoidRecordMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.service.micro.core.service.CaseAvoidService;
import com.zyxy.service.micro.core.service.CommonService;

/**
 * 更改仲裁请求Service实现类
 */
@Service
public class CaseAvoidServiceImpl implements CaseAvoidService{

	@Autowired
	private CaseAvoidRecordMapper caseAvoidRecordMapper;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseDocMapper caseDocMapper;

	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private ApproveTypeService approveTypeService;
	
	@Autowired private CommonService commonService;
	/**
	 * 插入回避记录
	 * @param formData
	 * @return
	 */
	@Override
	public BusiExecuteResult<String> insertCaseAvoidBusiExecute(CaseAvoidRecordInsertDTO formData) {
		
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getCreaterId());
		if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
			formData.setAvoidStyle(CaseAvoidStyleEnum.PROPOSER_APPLIED.getValue());
		}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			formData.setAvoidStyle(CaseAvoidStyleEnum.DEFENDANT_APPLIED.getValue());
		}
		Date date =new Date();
		
		CaseAvoidRecordWithBLOBs caseAvoidRecord =new CaseAvoidRecordWithBLOBs();
		String busiId = sequenceService.getCommonID();
		caseAvoidRecord.setId(busiId);
		caseAvoidRecord.setAvoidStyle(formData.getAvoidStyle());
		caseAvoidRecord.setAvoidType(formData.getAvoidType());
		caseAvoidRecord.setAvoidReason(formData.getAvoidReason());
		caseAvoidRecord.setCaseId(formData.getCaseId());
		caseAvoidRecord.setCreaterId(formData.getCreaterId());
		caseAvoidRecord.setCreateTime(date);
		caseAvoidRecord.setStatus(CaseAvoidStatusEnum.WAIT_AUDIT.getValue());
		caseAvoidRecord.setAvoidRequst(formData.getAvoidRequest());
		
		
		
		//回避审批记录
		CaseApprove approve = new CaseApprove();
		approve.setId(sequenceService.getCommonID());
		approve.setCaseId(formData.getCaseId());
		approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		approve.setBusiId(busiId);
		approve.setCreaterId(formData.getCreaterId());
		approve.setCreateTime(date);
		
		//回避申请书
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
		
		String avoidId = null;
		if (CaseAvoidStyleEnum.SELF_APPLIED.getValue().equals(formData.getAvoidStyle())) {
			caseAvoidRecord.setAvoidId(formData.getCreaterId());
		}else{
			if (CaseAvoidTypeEnum.ARBITRATOR.getValue().equals(formData.getAvoidType())) {
				avoidId = caseAvoidRecordMapper.selectEffectiveArbitratorByCaseId(formData.getCaseId());
				
			}else if(CaseAvoidTypeEnum.SECRETARY.getValue().equals(formData.getAvoidType())){
				avoidId = caseManagerMapper.queryNowWorkPeopleIdByType(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
			}
			if (StringUtils.isBlank(avoidId)) {
				return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
			}
			caseAvoidRecord.setAvoidId(avoidId);
		}
		caseAvoidRecordMapper.insert(caseAvoidRecord);
		
		//创建审批对象
		ApproveType key=new ApproveType();
		
		if (CaseAvoidTypeEnum.ARBITRATOR.getValue().equals(formData.getAvoidType())) {
			String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(),ManagerInfoStatusEnum.NORMAL.getCode());
			
			//approve.setApproveType(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName());
			
			//设置审批类型
			key.setTypeName(ApproveTypeEnum.ARBITRATOR_AVOID_EXAMINE.getTypeName());
			
			approve.setApproveUserId(userId);
			caseDoc.setDocType(CaseDocTypeEnum.ARBITRATOR_AVOID_APPLY.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.ARBITRATOR_AVOID_APPLY.getDocName());
		}else if (CaseAvoidTypeEnum.SECRETARY.getValue().equals(formData.getAvoidType())){
			String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),ManagerInfoStatusEnum.NORMAL.getCode());
			
			//approve.setApproveType(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName());
			
			//设置审批类型
			key.setTypeName(ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName());
			
			approve.setApproveUserId(userId);
			caseDoc.setDocType(CaseDocTypeEnum.SECRETARY_AVOID_APPLY_BOOK.getCode());
			caseDoc.setDocName(CaseDocTypeEnum.SECRETARY_AVOID_APPLY_BOOK.getDocName());
		}
		
		//设置审批类型进入缓存
		approveTypeService.selectCacheByPrimaryKey(key);
		

		//设置审批类型
		approve.setApproveType(key.getTypeName());
		
		caseApproveMapper.insertSelective(approve);
		caseDocMapper.insertSelective(caseDoc);
		return BusiExecuteResult.builderSuccessResult();
	}

}
