package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorExample;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocExample;
import com.zyxy.common.domain.CaseProtocolRecord;
import com.zyxy.common.domain.CaseProtocolRecordExample;
import com.zyxy.common.domain.CaseProtocolRecordWithBLOBs;
import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.domain.CompromiseApplyExample;
import com.zyxy.common.dto.ProtocolRecordInsertDTO;
import com.zyxy.common.dto.ProtocolResponseDTO;
import com.zyxy.common.enums.CaseArbitratorStatusEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.ComproiseApplyOpinionEnum;
import com.zyxy.common.enums.ComproiseApplyStatusEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.ProtocolOpinionEnum;
import com.zyxy.common.enums.ProtocolPageStatusEnum;
import com.zyxy.common.enums.ProtocolPageTitleEnum;
import com.zyxy.common.enums.ProtocolStatusEnum;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseProtocolRecordMapper;
import com.zyxy.common.mapper.CompromiseApplyMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ProtocolDocInfoVO;
import com.zyxy.common.vo.ProtocolInfoVO;
import com.zyxy.service.micro.core.service.CaseProtocolService;
import com.zyxy.service.micro.core.service.CommonService;

@Service
public class CaseProtocolServiceImpl implements CaseProtocolService{
	
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CompromiseApplyMapper compromiseApplyMapper;
	@Autowired
	private CaseProtocolRecordMapper caseProtocolMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CaseDocMapper caseDocMapper;
	@Autowired
	private CommonService commonService;
	@Autowired 
	private CaseArbitratorMapper caseArbitratorMapper;
	@Autowired
	private CaseFlowService caseFlowService;
	
	@Override
	public BusiValidResult protocolApplyValid(ProtocolRecordInsertDTO formData) {

		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums ==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		CompromiseApplyExample example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
		List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
		if (compromiseApplies.size()==0) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}else{
			CompromiseApply compromiseApply =compromiseApplies.get(0);
			if (!ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(compromiseApply.getPropOpinion())
					|| !ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(compromiseApply.getDefeOpinion())
					|| ! ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(compromiseApply.getManagerOpinion())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}
		//判断当前是否组庭
		//是否组庭
		if (caseFlowService.isSendGroupNotice(formData.getCaseId())) {
			return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_NOT_EXIST);
		}
		
		return BusiValidResult.builderSuccessResult(); 
	}

	@Override
	public BusiExecuteResult<String> protocolApplyExecute(
			ProtocolRecordInsertDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		Date date = new Date();
		CaseProtocolRecordWithBLOBs caseProtocol = new CaseProtocolRecordWithBLOBs();
		caseProtocol.setId(sequenceService.getCommonID());
		caseProtocol.setCaseId(formData.getCaseId());
		caseProtocol.setProtocolContent(formData.getProtocolContent());
		caseProtocol.setCreaterType(enums.getValue());
		if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
			caseProtocol.setPropOpinion(ProtocolOpinionEnum.OPINION_AGREE.getValue());
		}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			caseProtocol.setDefeOpinion(ProtocolOpinionEnum.OPINION_AGREE.getValue());
		}
		caseProtocol.setCreaterId(formData.getUserId());
		caseProtocol.setCreateTime(date);
		caseProtocol.setStatus(ProtocolStatusEnum.WAIT.getValue());
		caseProtocolMapper.insertSelective(caseProtocol);

		CaseDoc caseDoc = new CaseDoc();
		caseDoc.setId(sequenceService.getCommonID());
		//签章状态待定################
		caseDoc.setCaseId(formData.getCaseId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定############
		caseDoc.setCreaterId(formData.getUserId());
		caseDoc.setCreateTime(date);
		caseDoc.setDocType(CaseDocTypeEnum.COMPROMISE_PROTOCOL_APPLY_BOOK.getCode());
		caseDoc.setDocName(CaseDocTypeEnum.COMPROMISE_PROTOCOL_APPLY_BOOK.getDocName());
		caseDocMapper.insertSelective(caseDoc);
		
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult protocolResponseValid(ProtocolResponseDTO formData) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		CaseProtocolRecordExample example = new CaseProtocolRecordExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
		List<CaseProtocolRecordWithBLOBs> protocols = caseProtocolMapper.selectByExampleWithBLOBs(example);
		if (protocols.size()==0) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> protoclResponseExecute(
			ProtocolResponseDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		formData.setResponseType(enums.getValue());
		CaseProtocolRecordExample example = new CaseProtocolRecordExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
		CaseProtocolRecordWithBLOBs record = new CaseProtocolRecordWithBLOBs();
		if (ProtocolOpinionEnum.OPINION_AGREE.getValue().equals(formData.getStatus())) {
			record.setStatus(ProtocolStatusEnum.AGREE.getValue());
		}else if(ProtocolOpinionEnum.OPINION_REFUSE.getValue().equals(formData.getStatus())){
			record.setStatus(ProtocolStatusEnum.REFUSE.getValue());
		}
		if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(formData.getResponseType())) {
			record.setPropOpinion(formData.getStatus());
		}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(formData.getResponseType())) {
			record.setDefeOpinion(formData.getStatus());
		}
		record.setOtherOperatingTime(new Date());
		caseProtocolMapper.updateByExampleSelective(record, example);
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult protocolStatusInfoValid(String caseId, String userId) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
		if (enums ==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<ProtocolInfoVO> protocolStatusInfoExecute(
			String caseId, String userId) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(caseId, userId);
		CaseProtocolRecordExample example = new CaseProtocolRecordExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CaseProtocolRecordWithBLOBs> list = caseProtocolMapper.selectByExampleWithBLOBs(example);
		ProtocolInfoVO infoVO = new ProtocolInfoVO();
		if (list.size()>0) {
			//当前身份是申请方
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				//和解协议我方发起
				if (enums.getValue().equals(list.get(0).getCreaterType())) {
					//对方无回应
					if (StringUtils.isBlank(list.get(0).getDefeOpinion())) {
						infoVO.setTitleName(ProtocolPageTitleEnum.OUR_APPLY_PROTOVOL.getTitleName());
						infoVO.setTime(list.get(0).getCreateTime());
						infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_OPPOSITE_RESPONSE.getStatusName());
						return BusiExecuteResult.builderSuccessResult(infoVO);
					}else{
						//对方同意
						if (ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(list.get(0).getDefeOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_AGREE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_PROTOCL.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						//对方拒绝
						}else if(ComproiseApplyOpinionEnum.OPINION_REFUSE.getCode().equals(list.get(0).getDefeOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_REFUSE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.COMPROMISE_OVER.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}
					}
				//和解协议对方发起
				}else{
					if (StringUtils.isBlank(list.get(0).getPropOpinion())) {
						infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_APPLY_PROTOCOL.getTitleName());
						infoVO.setTime(list.get(0).getCreateTime());
						infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_OUR_RESPONSE.getStatusName());
						return BusiExecuteResult.builderSuccessResult(infoVO);
					}else{
						if (ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(list.get(0).getPropOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OUR_AGREE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_PROTOCL.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}else if(ComproiseApplyOpinionEnum.OPINION_REFUSE.getCode().equals(list.get(0).getPropOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OUR_REFUSE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.COMPROMISE_OVER.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}
					}
				}
			//当前身份是被申请人
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				//我方发起和解
				if (enums.getValue().equals(list.get(0).getCreaterType())) {
					//对方无回应
					if (StringUtils.isBlank(list.get(0).getPropOpinion())) {
						infoVO.setTitleName(ProtocolPageTitleEnum.OUR_APPLY_PROTOVOL.getTitleName());
						infoVO.setTime(list.get(0).getCreateTime());
						infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_OPPOSITE_RESPONSE.getStatusName());
						return BusiExecuteResult.builderSuccessResult(infoVO);
					}else{
						//对方同意
						if (ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(list.get(0).getPropOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_AGREE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_PROTOCL.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						//对方拒绝
						}else if(ComproiseApplyOpinionEnum.OPINION_REFUSE.getCode().equals(list.get(0).getPropOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_REFUSE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.COMPROMISE_OVER.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}
					}
				//对方发起和解协议
				}else{
					if (StringUtils.isBlank(list.get(0).getDefeOpinion())) {
						infoVO.setTitleName(ProtocolPageTitleEnum.OPPOSITE_APPLY_PROTOCOL.getTitleName());
						infoVO.setTime(list.get(0).getCreateTime());
						infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_OUR_RESPONSE.getStatusName());
						return BusiExecuteResult.builderSuccessResult(infoVO);
					}else{
						if (ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(list.get(0).getDefeOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OUR_AGREE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.WAIT_PROTOCL.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}else if(ComproiseApplyOpinionEnum.OPINION_REFUSE.getCode().equals(list.get(0).getDefeOpinion())) {
							infoVO.setTitleName(ProtocolPageTitleEnum.OUR_REFUSE_PROTOVOL.getTitleName());
							infoVO.setTime(list.get(0).getOtherOperatingTime());
							infoVO.setStatusName(ProtocolPageStatusEnum.COMPROMISE_OVER.getStatusName());
							return BusiExecuteResult.builderSuccessResult(infoVO);
						}
					}
				}
			}
		//出具调解书
		}else {
			CompromiseApplyExample applyExample = new CompromiseApplyExample();
			applyExample.createCriteria().andCaseIdEqualTo(caseId).andStatusEqualTo(ComproiseApplyStatusEnum.FINISH.getValue());
			List<CompromiseApply> applies = compromiseApplyMapper.selectByExample(applyExample);
			CaseDocExample docExample = new CaseDocExample();
			docExample.createCriteria().andCaseIdEqualTo(caseId).andDocTypeEqualTo(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
			List<CaseDoc> caseDocs = caseDocMapper.selectByExample(docExample);
			if (applies.size()>0&&caseDocs.size()==0) {
				infoVO.setTitleName(ProtocolPageStatusEnum.WAIT_DECISION.getStatusName());
				return BusiExecuteResult.builderSuccessResult(infoVO);
			}else if(applies.size()>0&&caseDocs.size()>0){
				infoVO.setTitleName(ProtocolPageStatusEnum.COMPROMISE_FINISH.getStatusName());
				return BusiExecuteResult.builderSuccessResult(infoVO);
			}
		}
		return null;
	}

	@Override
	public BusiValidResult protocolDocInfoValid(String caseId, String userId) {
		BusiValidResult busiValidResult = commonService.commonCaseAndUserValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return BusiValidResult.builderErrorResult(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		CaseProtocolRecordExample example = new CaseProtocolRecordExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CaseProtocolRecord> list = caseProtocolMapper.selectByExample(example);
		if (list.size()==0) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<ProtocolDocInfoVO> protocolDocInfoExecute(
			String caseId, String userId) {
		
		return null;
	}
	
}
