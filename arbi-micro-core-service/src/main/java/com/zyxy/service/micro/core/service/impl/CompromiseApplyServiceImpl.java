package com.zyxy.service.micro.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zyxy.common.dto.flow.CaseCompromiseOverDTO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.domain.CompromiseApplyExample;
import com.zyxy.common.dto.CompromiseApplyInsertDTO;
import com.zyxy.common.dto.CompromiseResponseDTO;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.ComproiseApplyAuditTypeEnum;
import com.zyxy.common.enums.CompromiseMessageEnum;
import com.zyxy.common.enums.CompromiseReponseStatusEnum;
import com.zyxy.common.enums.CompromiseResponseStyleEnum;
import com.zyxy.common.enums.CompromiseResponseTypeEnum;
import com.zyxy.common.enums.CompromiseStatusEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CompromiseApplyMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseFlowService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CompromiseApplyInfoVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.CompromiseApplyService;
/**
 * 和解申请Service实现类
 */
@Service
public class CompromiseApplyServiceImpl implements CompromiseApplyService {
	
	@Autowired
	private CompromiseApplyMapper compromiseApplyMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private MicroFlowService microFlowService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CaseArbitratorMapper caseArbitratorMapper;
	@Autowired
	private CaseFlowService caseFlowService;
	
	
	@Override
	public BusiValidResult compromiseApplyValid(
			CompromiseApplyInsertDTO formData) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		//判断当前案件是否和解申请记录
		CompromiseApplyExample example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
		List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
		if (compromiseApplies.size()>0) {
			return BusiValidResult.builderErrorResult(Coder.CASE_ALREADY_HAS_COMPROMISE);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> compromiseApplyExecute(
			CompromiseApplyInsertDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		formData.setApplyType(enums.getValue());
		CompromiseApply compromiseApply = new CompromiseApply();
		compromiseApply.setId(sequenceService.getCommonID());
		compromiseApply.setCreaterId(formData.getUserId());
		compromiseApply.setCaseId(formData.getCaseId());
		compromiseApply.setCreateTime(new Date());
		compromiseApply.setApplyType(formData.getApplyType());
		if (CompromiseResponseTypeEnum.PROPOSER.getValue().equals(formData.getApplyType())) {
			compromiseApply.setPropOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
		}else if(CompromiseResponseTypeEnum.DEFENDANT.getValue().equals(formData.getApplyType())){
			compromiseApply.setDefeOpinion(CompromiseReponseStatusEnum.AGREE.getValue());
		}
		//是否组庭
		if (caseFlowService.isSendGroupNotice(formData.getCaseId())) {
			compromiseApply.setAuditType(ComproiseApplyAuditTypeEnum.ARBITRATOR.getCode());
		}else{
			compromiseApply.setAuditType(ComproiseApplyAuditTypeEnum.ARBITRATION_SECRETARIES.getCode());
		}
		compromiseApply.setStatus(CompromiseStatusEnum.WAIT_ECHO.getValue());
		int rows = compromiseApplyMapper.insertSelective(compromiseApply);
		return rows>0?BusiExecuteResult.builderSuccessResult()
				:BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}

	@Override
	public BusiValidResult compromiseResponseValid(CompromiseResponseDTO formData) {
		if (CompromiseResponseTypeEnum.ARBITRATOR.getValue().equals(formData.getResponseType())) {
			CompromiseApply compromiseApply = compromiseApplyMapper.selectByPrimaryKey(formData.getId());
			if (!CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApply.getPropOpinion()) || 
					!CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApply.getDefeOpinion())) {
				return BusiValidResult.builderErrorResult(Coder.LITIGANT_OPINION_NOT_THE_SAME);
			}
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> compromiseResponseExecute(
			CompromiseResponseDTO formData) {
		CompromiseApply compromiseApply = new CompromiseApply();
		compromiseApply.setId(formData.getId());
		if (CompromiseResponseTypeEnum.PROPOSER.getValue().equals(formData.getResponseType())) {
			//根据回应状态判断和解状态
			if (CompromiseReponseStatusEnum.AGREE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.WAIT_AUDIT.getValue());
			}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.REFUSE.getValue());
			}
			compromiseApply.setOtherOperatingTime(new Date());
			compromiseApply.setPropOpinion(formData.getStatus());
		}else if(CompromiseResponseTypeEnum.ARBITRATOR.getValue().equals(formData.getResponseType())){
			//根据回应状态判断和解状态
			if (CompromiseReponseStatusEnum.AGREE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.ONGOINF.getValue());
			}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.REFUSE.getValue());
			}
			compromiseApply.setStartTime(formData.getStartTime());
			compromiseApply.setManagerOpinion(formData.getStatus());
			compromiseApply.setManagerOperatingTime(new Date());
		}else if (CompromiseResponseTypeEnum.DEFENDANT.getValue().equals(formData.getResponseType())) {
			//根据回应状态判断和解状态
			if (CompromiseReponseStatusEnum.AGREE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.WAIT_AUDIT.getValue());
			}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(formData.getStatus())) {
				compromiseApply.setStatus(CompromiseStatusEnum.REFUSE.getValue());
			}
			compromiseApply.setOtherOperatingTime(new Date());
			compromiseApply.setDefeOpinion(formData.getStatus());
		}
		if (CompromiseResponseStyleEnum.HALFWAY.getValue().equals(formData.getResponseStyle())) {
            CaseCompromiseOverDTO caseCompromiseOverDTO = new CaseCompromiseOverDTO();
            caseCompromiseOverDTO.setCaseId(formData.getCaseId());
            caseCompromiseOverDTO.setUserId(formData.getUserId());
            microFlowService.compromiseOver(formData.getCaseId(), caseCompromiseOverDTO);
        }
		int rows = compromiseApplyMapper.updateByPrimaryKeySelective(compromiseApply);
		return rows>0?BusiExecuteResult.builderSuccessResult()
				:BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
	}
	
	@Override
	public BusiValidResult compromiseApplyInfoValid(String caseId, String userId) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<List<CompromiseApplyInfoVO>> compromiseApplyInfoExecute(String caseId,String userId) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(caseId, userId);
		CompromiseApplyExample example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
		if (compromiseApplies.size()==0) {
			return BusiExecuteResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		List<CompromiseApplyInfoVO> list= new ArrayList<CompromiseApplyInfoVO>(); 
		//当前用户是和解申请方。
		if (enums.getValue().equals(compromiseApplies.get(0).getApplyType())) {
			//当前用户是案件申请人
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				//申请人opinion 不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getPropOpinion())) {
					CompromiseApplyInfoVO infoVO1 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_REFUSE.getValue());
					}
					list.add(infoVO1);
				}
				//对方opinion 不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getDefeOpinion())) {
					CompromiseApplyInfoVO infoVO2 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPPOSITE_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPOSITE_SIDE_REFUSE.getValue());
					}
					list.add(infoVO2);
				}
				//第三方opinion不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getManagerOpinion())) {
					CompromiseApplyInfoVO infoVO3 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_REFUSE.getValue());
					}
					list.add(infoVO3);
				}
			//当前用户是被申请方
			}else if(CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())){
				//当前用户是案件本申请方--发起和解请求
				if (!StringUtils.isBlank(compromiseApplies.get(0).getDefeOpinion())) {
					CompromiseApplyInfoVO infoVO1 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_REFUSE.getValue());
					}
					list.add(infoVO1);
				}
				//对方意见
				if (!StringUtils.isBlank(compromiseApplies.get(0).getPropOpinion())) {
					CompromiseApplyInfoVO infoVO2 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPPOSITE_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPOSITE_SIDE_REFUSE.getValue());
					}
					list.add(infoVO2);
				}
				//第三方意见
				if (!StringUtils.isBlank(compromiseApplies.get(0).getManagerOpinion())) {
					CompromiseApplyInfoVO infoVO3 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_REFUSE.getValue());
					}
					list.add(infoVO3);
				}
			}
		//当前用户不是和解申请方	
		}else{
			//当前是案件申请人(和解申请人是被申请方)
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
				//案件被申请人是和解申请人
				if (!StringUtils.isBlank(compromiseApplies.get(0).getDefeOpinion())) {
					CompromiseApplyInfoVO infoVO1 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPPOSITE_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPOSITE_SIDE_REFUSE.getValue());
					}
					list.add(infoVO1);
				}
				
				if (!StringUtils.isBlank(compromiseApplies.get(0).getPropOpinion())) {
					CompromiseApplyInfoVO infoVO2 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_REFUSE.getValue());
					}
					list.add(infoVO2);
				}
				if (!StringUtils.isBlank(compromiseApplies.get(0).getManagerOpinion())) {
					CompromiseApplyInfoVO infoVO3 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_REFUSE.getValue());
					}
					list.add(infoVO3);
				}
			//当前用户是被申请人（和解申请人是申请方）
			}else if(CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())){
				//和解申请人是申请人申请人opinion 不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getPropOpinion())) {
					CompromiseApplyInfoVO infoVO1 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPPOSITE_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO1 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OPPOSITE_SIDE_REFUSE.getValue());
					}
					list.add(infoVO1);
				}
				//对方opinion 不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getDefeOpinion())) {
					CompromiseApplyInfoVO infoVO2 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getDefeOpinion())) {
						infoVO2 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.OUR_SIDE_REFUSE.getValue());
					}
					list.add(infoVO2);
				}
				//第三方opinion不为空
				if (!StringUtils.isBlank(compromiseApplies.get(0).getManagerOpinion())) {
					CompromiseApplyInfoVO infoVO3 = null;
					if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_AGREE.getValue());
					}else if (CompromiseReponseStatusEnum.REFUSE.getValue().equals(compromiseApplies.get(0).getPropOpinion())) {
						infoVO3 = new CompromiseApplyInfoVO(compromiseApplies.get(0).getCreateTime(),CompromiseMessageEnum.ARBITRATOR_REFUSE.getValue());
					}
					list.add(infoVO3);
				}
			}
		}
		return BusiExecuteResult.builderSuccessResult(list);
	}

}
