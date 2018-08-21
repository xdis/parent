package com.zyxy.service.micro.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseAgent;
import com.zyxy.common.domain.CaseAgentExample;
import com.zyxy.common.domain.CaseProtocolRecord;
import com.zyxy.common.domain.CaseProtocolRecordExample;
import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.domain.CompromiseApplyExample;
import com.zyxy.common.enums.AgentTypeEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.ComproiseApplyStatusEnum;
import com.zyxy.common.enums.CompromisePageStatusEnum;
import com.zyxy.common.enums.CompromiseReponseStatusEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.MenuEnum;
import com.zyxy.common.enums.ProtocolStatusEnum;
import com.zyxy.common.mapper.CaseAgentMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseProtocolRecordMapper;
import com.zyxy.common.mapper.CompromiseApplyMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CompromiseMenuVO;
import com.zyxy.common.vo.MenuVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.CompromiseMenuService;

/**
 * 和解按钮
 */
@Service
public class CompromiseMenuServiceImpl implements CompromiseMenuService {

	@Autowired
	private CommonService commonService;
	@Autowired
	private CompromiseApplyMapper compromiseApplyMapper;
	@Autowired
	private CaseDocMapper caseDocMapper;
	@Autowired
	private CaseProtocolRecordMapper caseProtocolRecordMapper;
	@Autowired
	private CaseAgentMapper caseAgentMapper;
	
	
	@Override
	public BusiValidResult compromiseMenuBusiValid(String caseId, String userId) {
		LitigantTypeEnum enums =commonService.queryCaseRoleByUserId(caseId, userId);
		if (enums==null) {
			BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<CompromiseMenuVO> compromiseMenuBusiExecute(String caseId,
			String userId) {
		CasePersonnelTypeEnum enums =commonService.queryCasePersonnerlTypeByUserId(caseId, userId);
	
		CompromiseMenuVO compromiseMenuVO = new CompromiseMenuVO();
		
		List<MenuVO> menuVOS=new ArrayList<MenuVO>();
		//查询当前用户是否一般代理：
		CaseAgentExample agentExample = new CaseAgentExample();
		agentExample.createCriteria().andCaseIdEqualTo(caseId).andLitigantTypeEqualTo(enums.getValue());
		List<CaseAgent> agents = caseAgentMapper.selectByExample(agentExample);
		if (agents.size()>0&&AgentTypeEnum.GENERAL_AGENT.getValue().equals(agents.get(0).getAgentType())) {
			compromiseMenuVO.setStatus(CompromisePageStatusEnum.GENERAL_AGENT_OPERATION.getValue());
			return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
		}
		
		//发起和解之前
		CompromiseApplyExample example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CompromiseApply> compromiseApplies = compromiseApplyMapper.selectByExample(example);
		if (compromiseApplies.size()==0) {
			MenuVO menuVO1 = new MenuVO(MenuEnum.COMPROMISE_APPLY.getCode(), MenuEnum.COMPROMISE_APPLY.getRemark());
			menuVOS.add(menuVO1);
			compromiseMenuVO.setMenuVOs(menuVOS);
			compromiseMenuVO.setStatus(CompromisePageStatusEnum.NO_COMPROMISE.getValue());
			return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
		}
		//发起和解，等待一方通过
		if ((null == compromiseApplies.get(0).getPropOpinion()&&null != compromiseApplies.get(0).getDefeOpinion())||
				(null != compromiseApplies.get(0).getPropOpinion()&&null == compromiseApplies.get(0).getDefeOpinion())) {
			//判断当前用户是否和解发起方	
			if (enums.getValue().equals(compromiseApplies.get(0).getApplyType())) {
				compromiseMenuVO.setStatus(CompromisePageStatusEnum.WAIT_OPPSITE_RESPONSE.getValue());
				return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
			}else{
				MenuVO menuVO2 = new MenuVO(MenuEnum.COMPROMISE_AGREE.getCode(), MenuEnum.COMPROMISE_AGREE.getRemark());
				MenuVO menuVO3 = new MenuVO(MenuEnum.COMPROMISE_REFUSE.getCode(), MenuEnum.COMPROMISE_REFUSE.getRemark());
				menuVOS.add(menuVO2);
				menuVOS.add(menuVO3);
				compromiseMenuVO.setMenuVOs(menuVOS);
				compromiseMenuVO.setStatus(CompromisePageStatusEnum.WAIT_OUR_RESPONSE.getValue());
				return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
			}
		}
		//发起和解，等待第三方通过
		if (CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())&&
				CompromiseReponseStatusEnum.AGREE.getValue().equals(compromiseApplies.get(0).getPropOpinion())&&
				StringUtils.isBlank(compromiseApplies.get(0).getManagerOpinion())) {
			compromiseMenuVO.setStatus(CompromisePageStatusEnum.WAIT_ARBITRATOR_RESPONSE.getValue());
			return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
		}
		//和解中
		if (ComproiseApplyStatusEnum.DOING.getValue().equals(compromiseApplies.get(0).getStatus())) {
			//未发起调节书申请和裁决申请
			CaseProtocolRecordExample protocolExample = new CaseProtocolRecordExample();
			protocolExample.createCriteria().andCaseIdEqualTo(caseId);
			List<CaseProtocolRecord> caseProtocols = caseProtocolRecordMapper.selectByExample(protocolExample);
			if (caseProtocols.size()==0) {
				MenuVO menuVO4 = new MenuVO(MenuEnum.COMPROMISE_REFUSE.getCode(), MenuEnum.COMPROMISE_REFUSE.getRemark());
				MenuVO menuVO5 = new MenuVO(MenuEnum.COMPROMISE_PROTOCOL_APPLY.getCode(), MenuEnum.COMPROMISE_PROTOCOL_APPLY.getRemark());
				MenuVO menuVO6 = new MenuVO(MenuEnum.COMPROMISE_DECISION_APPLY.getCode(), MenuEnum.COMPROMISE_DECISION_APPLY.getRemark());
				menuVOS.add(menuVO4);
				menuVOS.add(menuVO5);
				menuVOS.add(menuVO6);
				compromiseMenuVO.setMenuVOs(menuVOS);
				compromiseMenuVO.setStatus(CompromisePageStatusEnum.COMPROMISING.getValue());
				return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
			}
			//一方发起和解申请书等待另一方同意
			if (ProtocolStatusEnum.WAIT.getValue().equals(caseProtocols.get(0).getStatus())) {
				//当前用户是发起方
				if (enums.getValue().equals(caseProtocols.get(0).getCreaterType())) {
					compromiseMenuVO.setStatus(CompromisePageStatusEnum.WAIT_OPPSITE_PROTOCOL_RESPONSE.getValue());
					return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
				}else{
					//当前用户非发起方
					MenuVO menuVO7 = new MenuVO(MenuEnum.COMPROMISE_REFUSE.getCode(), MenuEnum.COMPROMISE_REFUSE.getRemark());
//					MenuVO menuVO8 = new MenuVO(MenuEnum.COMPROMISE_PROTOCOL_REFUSE.getCode(), MenuEnum.COMPROMISE_PROTOCOL_REFUSE.getRemark());
					MenuVO menuVO9 = new MenuVO(MenuEnum.COMPROMISE_PROTOCOL_AGREE.getCode(), MenuEnum.COMPROMISE_PROTOCOL_AGREE.getRemark());
					menuVOS.add(menuVO7);
//					menuVOS.add(menuVO8);
					menuVOS.add(menuVO9);
					compromiseMenuVO.setMenuVOs(menuVOS);
					compromiseMenuVO.setStatus(CompromisePageStatusEnum.WAIT_OUR_PROTOCOL_RESPONSE.getValue());
					return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
				}
			}else if (ProtocolStatusEnum.REFUSE.getValue().equals(caseProtocols.get(0).getStatus())) {
				compromiseMenuVO.setStatus(CompromisePageStatusEnum.REFUSE_COMPROMISE.getValue());
				return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
			}else if (ProtocolStatusEnum.AGREE.getValue().equals(caseProtocols.get(0).getStatus())) {
				compromiseMenuVO.setStatus(CompromisePageStatusEnum.FINISH_COMPROMISE.getValue());
				return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
			}
			//申请出具调解书
		}
		//拒绝和解
		if (ComproiseApplyStatusEnum.REFUSED.getValue().equals(compromiseApplies.get(0).getStatus())) {
			compromiseMenuVO.setStatus(CompromisePageStatusEnum.REFUSE_COMPROMISE.getValue());
			return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
		}
		
		//和解完成
		if (ComproiseApplyStatusEnum.FINISH.getValue().equals(compromiseApplies.get(0).getStatus())) {
			compromiseMenuVO.setStatus(CompromisePageStatusEnum.FINISH_COMPROMISE.getValue());
			return BusiExecuteResult.builderSuccessResult(compromiseMenuVO);
		}
		
		return null;
	}

}
