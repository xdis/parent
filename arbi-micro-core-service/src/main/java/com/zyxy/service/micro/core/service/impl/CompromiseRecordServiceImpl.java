package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.domain.CompromiseRecordExample;
import com.zyxy.common.dto.CompromiseRecordInsertDTO;
import com.zyxy.common.dto.CompromiseRecordListDTO;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.CompromiseSentTypeEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CompromiseRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CompromiseRecordVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.CompromiseRecordService;
/**
 * 和解调节沟通记录Service
 */
@Service
public class CompromiseRecordServiceImpl implements CompromiseRecordService {
	
	@Autowired 
	private CompromiseRecordMapper compromiseRecordMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CommonService commonService;
	
	@Override
	public List<CompromiseRecordVO> list(
			CompromiseRecordListDTO formData) {
		List<CompromiseRecordVO> list = compromiseRecordMapper.selectCompromiseRecordList(formData.getCaseId());
		return list;
	}

	@Override
	public BusiValidResult compromiseSendValid(
			CompromiseRecordInsertDTO formData) {
		//LitigantCaseInfoValidVO info = caseInfoMapper.selectLitigantUserIdByCaseId(formData.getCaseId());
		/*//发送人身份认证
		if (CompromiseSentTypeEnum.PROPOSER.equals(formData.getSendType())) {
			if (!formData.getUserId().equals(info.getProposerId())&&
					!formData.getUserId().equals(info.getProposerAgnentId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		} else if (CompromiseSentTypeEnum.DEFENDANT.equals(formData.getSendType())) {
			if (!formData.getUserId().equals(info.getDefendantId())&&
					!formData.getUserId().equals(info.getDefendantAgentId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		} else if (CompromiseSentTypeEnum.ARBI_SECRETARY.equals(formData.getSendType())) {
			if (!formData.getUserId().equals(info.getArbiSecretaryId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}else if (CompromiseSentTypeEnum.ARBITRATOR.equals(formData.getSendType())) {
			if (!formData.getUserId().equals(info.getArbitratorId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}*/
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<List<CompromiseRecordVO>> compromiseSendExecute(
			CompromiseRecordInsertDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
			formData.setSendType(CompromiseSentTypeEnum.PROPOSER.getValue());
		}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())){
			formData.setSendType(CompromiseSentTypeEnum.DEFENDANT.getValue());
		}
		CompromiseRecord compromiseRecord = new CompromiseRecord();
		compromiseRecord.setCaseId(formData.getCaseId());
		compromiseRecord.setContent(formData.getContent());
		compromiseRecord.setSenderType(formData.getSendType());
		compromiseRecord.setCreateTime(new Date());
		compromiseRecord.setId(sequenceService.getCommonID());
		compromiseRecord.setContentType(formData.getContentType());
		compromiseRecord.setCreaterId(formData.getUserId());
		int rows = compromiseRecordMapper.insert(compromiseRecord);
		
		List<CompromiseRecordVO> list = compromiseRecordMapper.selectCompromiseRecordList(formData.getCaseId());
		return rows>0?BusiExecuteResult.builderSuccessResult(list):BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}

}
