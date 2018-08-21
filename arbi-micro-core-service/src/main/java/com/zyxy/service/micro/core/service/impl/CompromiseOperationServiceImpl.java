package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import com.zyxy.common.dto.flow.CaseCompromiseOverDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorExample;
import com.zyxy.common.domain.CaseMediateProcessRecord;
import com.zyxy.common.domain.CaseProtocolRecord;
import com.zyxy.common.domain.CaseProtocolRecordExample;
import com.zyxy.common.domain.CaseProtocolRecordWithBLOBs;
import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.domain.CompromiseApplyExample;
import com.zyxy.common.dto.CompromiseOperationDTO;
import com.zyxy.common.enums.CaseArbitratorStatusEnum;
import com.zyxy.common.enums.CaseMediateProcessStatusEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.CompromiseReponseStatusEnum;
import com.zyxy.common.enums.CompromiseStatusEnum;
import com.zyxy.common.enums.ProtocolStatusEnum;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseMediateProcessRecordMapper;
import com.zyxy.common.mapper.CaseProtocolRecordMapper;
import com.zyxy.common.mapper.CompromiseApplyMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CompromiseApplyInfoVO;
import com.zyxy.common.vo.CompromiseInfoVO;
import com.zyxy.common.vo.CompromiseMenuVO;
import com.zyxy.common.vo.ProtocolInfoVO;
import com.zyxy.service.micro.core.service.CaseProtocolService;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.CompromiseApplyService;
import com.zyxy.service.micro.core.service.CompromiseMenuService;
import com.zyxy.service.micro.core.service.CompromiseOperationService;

@Service
public class CompromiseOperationServiceImpl implements
		CompromiseOperationService {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CompromiseApplyMapper compromiseApplyMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CaseProtocolRecordMapper caseProtocolRecordMapper;
	@Autowired
	private MicroFlowService microFlowService;
	@Autowired
	private CompromiseMenuService compromiseMenuService;
	@Autowired
	private CompromiseApplyService compromiseApplyService;
	@Autowired
	private CaseProtocolService caseProtocolService;
	@Autowired 
	private CaseArbitratorMapper caseArbitratorMapper;
	@Autowired
	private CaseMediateProcessRecordMapper caseMediateProcessRecordMapper;
	@Autowired
	private CaseFlowService caseFlowService;

	@Override
	public BusiValidResult compromiseOperationValid(
			CompromiseOperationDTO formData) {
		//userId和caseId关系验证
		BusiValidResult commonValid = commonService.commonCaseAndUserValid(formData.getCaseId(), formData.getUserId());
		if (commonValid.hasError()) {
			return BusiValidResult.builderErrorResult(commonValid.getCode(), commonValid.getMsg());
		}
		
		switch (formData.getMenuId()) {
		//和解申请
		case "20":
			//判断当前案件是否和解申请记录
			CompromiseApplyExample example = new CompromiseApplyExample();
			example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
			if (compromiseApplies.size()>0) {
				return BusiValidResult.builderErrorResult(Coder.CASE_ALREADY_HAS_COMPROMISE);
			}
			break;
		case "21":
			//判断当前案件是否和解申请记录
			CompromiseApplyExample example2 = new CompromiseApplyExample();
			example2.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CompromiseApply> compromiseApplies2 = compromiseApplyMapper.selectByExample(example2);
			if (compromiseApplies2.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		case "22":
			//判断当前案件是否和解申请记录
			CompromiseApplyExample example3 = new CompromiseApplyExample();
			example3.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CompromiseApply> compromiseApplies3 = compromiseApplyMapper.selectByExample(example3);
			if (compromiseApplies3.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		case "24":
			CaseProtocolRecordExample example4 = new CaseProtocolRecordExample();
			example4.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CaseProtocolRecord> caseProtocolRecords =caseProtocolRecordMapper.selectByExample(example4);
			if (caseProtocolRecords.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		case "25":
			CaseProtocolRecordExample example5 = new CaseProtocolRecordExample();
			example5.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CaseProtocolRecord> caseProtocolRecords2 =caseProtocolRecordMapper.selectByExample(example5);
			if (caseProtocolRecords2.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		case "26":
			//判断当前案件是否和解申请记录
			CompromiseApplyExample example6 = new CompromiseApplyExample();
			example6.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CompromiseApply> compromiseApplies4 = compromiseApplyMapper.selectByExample(example6);
			if (compromiseApplies4.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			//是否组庭
			if (caseFlowService.isSendGroupNotice(formData.getCaseId())) {
				return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_NOT_EXIST);
			}
			break;
		default:
			break;
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<?> compromiseOperationExcute(
			CompromiseOperationDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		String menuId = formData.getMenuId();
        CaseCompromiseOverDTO caseCompromiseOverDTO = new CaseCompromiseOverDTO();
        caseCompromiseOverDTO.setCaseId(formData.getCaseId());
        caseCompromiseOverDTO.setUserId(formData.getUserId());
        switch (menuId) {
		//和解申请
		case "20":
			CompromiseApply compromiseApply = new CompromiseApply();
			compromiseApply.setId(sequenceService.getCommonID());
			compromiseApply.setCreaterId(formData.getUserId());
			compromiseApply.setCaseId(formData.getCaseId());
			compromiseApply.setCreateTime(new Date());
			compromiseApply.setApplyType(enums.getValue());
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				compromiseApply.setPropOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				compromiseApply.setDefeOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}
			compromiseApply.setStatus(CompromiseStatusEnum.WAIT_AUDIT.getValue());
			compromiseApplyMapper.insertSelective(compromiseApply);
			return BusiExecuteResult.builderSuccessResult();
		//同意和解
		case "21":
			CompromiseApply compromiseApply2 = new CompromiseApply();
			compromiseApply2.setId(getCompromiseApplyId(formData.getCaseId()));
			compromiseApply2.setStatus(CompromiseStatusEnum.WAIT_AUDIT.getValue());
			compromiseApply2.setOtherOperatingTime(new Date());
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				compromiseApply2.setPropOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				compromiseApply2.setDefeOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}
			compromiseApplyMapper.updateByPrimaryKeySelective(compromiseApply2);
			return BusiExecuteResult.builderSuccessResult();
		//拒绝和解
		case "22":
			//判断当前和解的状态
			CompromiseApplyExample  example = new CompromiseApplyExample();
			example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
			List<CompromiseApply> applies = compromiseApplyMapper.selectByExample(example);
			if (CompromiseStatusEnum.ONGOINF.getValue().equals(applies.get(0).getStatus())) {
				//直接进入审理期
                microFlowService.compromiseOver(formData.getCaseId(), caseCompromiseOverDTO);
            }
			CompromiseApply compromiseApply3 = new CompromiseApply();
			compromiseApply3.setId(getCompromiseApplyId(formData.getCaseId()));
			compromiseApply3.setStatus(CompromiseStatusEnum.REFUSE.getValue());
			compromiseApply3.setOtherOperatingTime(new Date());
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				compromiseApply3.setPropOpinion(CompromiseReponseStatusEnum.REFUSE.getValue());
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				compromiseApply3.setDefeOpinion(CompromiseReponseStatusEnum.REFUSE.getValue());
			}
			compromiseApplyMapper.updateByPrimaryKeySelective(compromiseApply3);
			return BusiExecuteResult.builderSuccessResult();
		//同意调解协议申请书
		case "24":
			CaseProtocolRecordWithBLOBs record = new CaseProtocolRecordWithBLOBs();
			record.setId(getCaseProtocolId(formData.getCaseId()));
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				record.setPropOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				record.setDefeOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
			}
			record.setOtherOperatingTime(new Date());
			record.setStatus(ProtocolStatusEnum.AGREE.getValue());
			caseProtocolRecordMapper.updateByPrimaryKeySelective(record);
			
			CaseMediateProcessRecord caseMediateProcessRecord = new CaseMediateProcessRecord();
			caseMediateProcessRecord.setId(sequenceService.getCommonID());
			caseMediateProcessRecord.setCaseId(formData.getCaseId());
			caseMediateProcessRecord.setStatus(CaseMediateProcessStatusEnum.WAIT_PROTOCOL_DOC.getValue());
			caseMediateProcessRecordMapper.insertSelective(caseMediateProcessRecord);
			
			return BusiExecuteResult.builderSuccessResult();
		//拒绝调解协议申请书
		case "25":
			CaseProtocolRecordWithBLOBs record2 = new CaseProtocolRecordWithBLOBs();
			record2.setId(getCaseProtocolId(formData.getCaseId()));
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				record2.setPropOpinion(CompromiseReponseStatusEnum.REFUSE.getValue());
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				record2.setDefeOpinion(CompromiseReponseStatusEnum.REFUSE.getValue());
			}
			record2.setOtherOperatingTime(new Date());
			record2.setStatus(ProtocolStatusEnum.REFUSE.getValue());
			caseProtocolRecordMapper.updateByPrimaryKeySelective(record2);
			//直接进入审理期
            microFlowService.compromiseOver(formData.getCaseId(), caseCompromiseOverDTO);
            return BusiExecuteResult.builderSuccessResult();
		//出具调解书
		case "26":
			//直接进入审理期
            microFlowService.compromiseOver(formData.getCaseId(), caseCompromiseOverDTO);
            return BusiExecuteResult.builderSuccessResult();
		default:
			break;
		}
		
		return null;
	}
	
	private String getCompromiseApplyId(String CaseId){
		CompromiseApplyExample  example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(CaseId);
		List<CompromiseApply> applies = compromiseApplyMapper.selectByExample(example);
		if (applies.size()>0) {
			return applies.get(0).getId();
		}
		return null;
	}
	
	private String getCaseProtocolId(String caseId){
		CaseProtocolRecordExample example = new CaseProtocolRecordExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CaseProtocolRecord> caseProtocolRecords =caseProtocolRecordMapper.selectByExample(example);
		if (caseProtocolRecords.size()>0) {
			return caseProtocolRecords.get(0).getId();
		}
		return null;
	}

	@Override
	public BusiExecuteResult<CompromiseInfoVO> compromiseInfo(String caseId,
			String userId) {
		CompromiseInfoVO infoVO = new CompromiseInfoVO();
		BusiExecuteResult<List<CompromiseApplyInfoVO>> compromiseApplyInfos = compromiseApplyService.compromiseApplyInfoExecute(caseId, userId);
		BusiExecuteResult<CompromiseMenuVO> compromiseMenuVO = compromiseMenuService.compromiseMenuBusiExecute(caseId, userId);
		BusiExecuteResult<ProtocolInfoVO> protocolInfoVO = caseProtocolService.protocolStatusInfoExecute(caseId,userId);
		if (null != compromiseApplyInfos) {
			infoVO.setApplyInfoVOs(compromiseApplyInfos.getBody());
		}
		infoVO.setCompromiseMenuVO(compromiseMenuVO.getBody());
		if (null != protocolInfoVO) {
			infoVO.setProtocolInfoVO(protocolInfoVO.getBody());
			
		}
		 return BusiExecuteResult.builderSuccessResult(infoVO);
	}

}
