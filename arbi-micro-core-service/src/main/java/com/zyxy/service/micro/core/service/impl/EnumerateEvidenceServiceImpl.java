package com.zyxy.service.micro.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.constants.SysConstant;
import com.zyxy.common.domain.CaseMatWithBLOBs;
import com.zyxy.common.dto.CaseEvidenceDTO;
import com.zyxy.common.dto.EnumerateEvidenceDTO;
import com.zyxy.common.dto.OppugnEvidenceDTO;
import com.zyxy.common.enums.CaseMatTypeEnum;
import com.zyxy.common.enums.EvidenceTypeEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseMatMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.EvidenceListVO;
import com.zyxy.common.vo.EvidenceVO;
import com.zyxy.common.vo.LitigantCaseInfoValidVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.EnumerateEvidenceService;
/**
 * 举证质证Service实现类
 */
@Service
public class EnumerateEvidenceServiceImpl implements EnumerateEvidenceService {

	@Autowired
	private CaseMatMapper caseMatMapper;
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CommonService commonService;
	
	
	@Override
	public BusiValidResult oppugnEvidenceValid(OppugnEvidenceDTO formData) {
		//验证证据属于案件
		CaseMatWithBLOBs caseMat = caseMatMapper.selectByPrimaryKey(formData.getId());
		if (!formData.getCaseId().equals(caseMat.getCaseId())) {
			return BusiValidResult.builderErrorResult(Coder.EVIDENCE_NOT_MATCH_CASE);
		}
		/*LitigantCaseInfoValidVO validData = caseInfoMapper.
				selectLitigantUserIdByCaseId(formData.getCaseId());
		//验证操作人
		if (EvidenceTypeEnum.PROPOSER.getValue().equals(formData.getEvidenceType())) {
			if (!formData.getUserId().equals(validData.getDefendantId())&&
					!formData.getUserId().equals(validData.getDefendantAgentId())) {
				return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
			}
		} else if(EvidenceTypeEnum.DEFENDANT.getValue().equals(formData.getEvidenceType())) {
			if (!formData.getUserId().equals(validData.getProposerId())&&
					!formData.getUserId().equals(validData.getProposerAgnentId())) {
				return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
			}
		}*/
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> oppugnEvidenceExecute(
			OppugnEvidenceDTO formData) {
		CaseMatWithBLOBs caseMat = new CaseMatWithBLOBs();
		caseMat.setId(formData.getId());
		caseMat.setOppugnEvidence(formData.getOppugnEvidence());
		int rows = caseMatMapper.updateByPrimaryKeySelective(caseMat);
		return rows>0?BusiExecuteResult.builderSuccessResult():
			BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
	}

	@Override
	public BusiValidResult enumerateEvidenceValid(EnumerateEvidenceDTO formData) {
		//验证操作人
		/*LitigantCaseInfoValidVO validData = caseInfoMapper.
				selectLitigantUserIdByCaseId(formData.getCaseId());
		if  (EvidenceTypeEnum.PROPOSER.getValue().equals(formData.getEvidenceType())) {
			if (!formData.getUserId().equals(validData.getProposerId())&&
					formData.getUserId().equals(validData.getProposerAgnentId())) {
				return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
			}
		} else if (EvidenceTypeEnum.DEFENDANT.getValue().equals(formData.getEvidenceType())) {
			if (!formData.getUserId().equals(validData.getDefendantId())&&
					!formData.getUserId().equals(validData.getDefendantAgentId())) {
				return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
			}
		}*/
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> enumerateEvidenceExecute(
			EnumerateEvidenceDTO formData) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue()) ||
				LitigantTypeEnum.PROPESER_AGENT.getValue().equals(enums.getValue())) {
			formData.setEvidenceType(EvidenceTypeEnum.PROPOSER.getValue());
		}else if (LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue()) ||
				LitigantTypeEnum.DEFENDANT_AGENT.getValue().equals(enums.getValue())) {
			formData.setEvidenceType(EvidenceTypeEnum.DEFENDANT.getValue());
		}
		
		for (CaseEvidenceDTO evidence : formData.getCaseEvidences()) {
			evidence.setId(sequenceService.getCommonID());
		}
		int rows = 0;
		if (EvidenceTypeEnum.PROPOSER.getValue().equals(formData.getEvidenceType())) {
			rows = caseMatMapper.insertRejionEvidence(formData.getCaseEvidences(), "", formData.getCaseId(), "", CaseMatTypeEnum.REPLY_EVIDENCE.getCode(), LitigantTypeEnum.PROPESER.getValue());
		}else if(EvidenceTypeEnum.DEFENDANT.getValue().equals(formData.getEvidenceType())) {
			rows = caseMatMapper.insertRejionEvidence(formData.getCaseEvidences(), "", formData.getCaseId(), "", CaseMatTypeEnum.REPLY_EVIDENCE.getCode(), LitigantTypeEnum.DEFENDANT.getValue());
		}
		return rows>0?BusiExecuteResult.builderSuccessResult():
			BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}

	@Override
	public BusiValidResult evidenceListValid(String caseId, String userId) {
		//验证操作人
		LitigantCaseInfoValidVO validData = caseInfoMapper.
				selectLitigantUserIdByCaseId(caseId);
		if (!userId.equals(validData.getProposerId())&&!userId.equals(validData.getProposerAgentId())&&
				!userId.equals(validData.getDefendantId())&&!userId.equals(validData.getDefendantAgentId())) {
			return BusiValidResult.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<EvidenceListVO> evidenceListExecute(String caseId) {
		List<EvidenceVO> proposerEvidences = caseMatMapper.selectEvidencesParam(caseId, 
				EvidenceTypeEnum.PROPOSER.getValue());
		for (EvidenceVO evidenceVO : proposerEvidences) {
			evidenceVO.setFileId(SysConstant.FILE_PREFIX+evidenceVO.getFileId());
		}
		List<EvidenceVO> defendantEvidences = caseMatMapper.selectEvidencesParam(caseId,
				EvidenceTypeEnum.DEFENDANT.getValue());
		for (EvidenceVO evidenceVO : defendantEvidences) {
			evidenceVO.setFileId(SysConstant.FILE_PREFIX+evidenceVO.getFileId());
		}
		EvidenceListVO evidenceList = new EvidenceListVO();
		if (proposerEvidences.size()>0) {
			evidenceList.setProposerEvidences(proposerEvidences);
		}
		if (defendantEvidences.size()>0) {
			evidenceList.setDefendantEvidences(defendantEvidences);
		}
		return BusiExecuteResult.builderSuccessResult(evidenceList);
	}
	
	

}
