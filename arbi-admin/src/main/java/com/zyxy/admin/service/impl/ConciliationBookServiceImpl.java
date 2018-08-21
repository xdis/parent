package com.zyxy.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.AuthorizationDelegateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.ConciliationBookService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.dto.CaseApproveDTO;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ComproiseApplyVO;
import com.zyxy.common.vo.ConciliationBookVO;

@Service
public class ConciliationBookServiceImpl implements ConciliationBookService {
	
	@Autowired
	private CaseAgentMapper caseAgentMapper;
	
	@Autowired
	private CaseDocMapper caseDocMapper;
	
	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private WhetherDistributionService whetherDistributionService;
	
	@Autowired
	private CompromiseApplyMapper compromiseApplyMapper;
	
	@Autowired
	private CaseProtocolRecordMapper caseProtocolRecordMapper;
	
	@Autowired
	private CaseArbitratorMapper caseArbitratorMapper;
	
	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private CaseInfoMapper caseInfoMapper;

	@Autowired
	private CaseManagerService caseManagerService;

	@Autowired
	private CaseAvoidRecordMapper caseAvoidRecordMapper;
	
	/**
	 * 调解书审核-业务验证 
	 * 判断案件是否存在，是否在待审核状态，是否属于该仲裁委人员
	 * @return
	 */
	@Override
	public BusiValidResult queryBusiValid(CaseApproveDTO formData) {
		//根据审批id查询案件id
		CaseApprove caseApprove = caseApproveMapper
				.selectByPrimaryKey(formData.getApproveId());
		formData.setCaseId(caseApprove.getCaseId());

		//判断案件是否存在
		if (caseApprove == null) {
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}

		//判断该条审批是否在待审核状态
		if(CaseApproveStatusEnum.WAIT_AUDIT.getValue().equals(caseApprove.getApproveStatus())){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.APPROVE_NOT_IN_CHECK_NODE_ERROR);
		}

		//获取当前用户职务
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());

		String approveDuties = caseInfoMapper.queryDutiesById(caseApprove.getApproveUserId());

		//查询出授权情况
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), formData.getUserId(), caseApprove.getApproveType());

		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
			boolean flag = caseManagerService.queryCaseManagerInfo(caseApprove.getCaseId(), formData.getUserId());
			if(!flag){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
			}

			if(!formData.getUserId().equals(caseApprove.getApproveUserId())){
				return BusiValidResult
						.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}
		}

		//判断是授权方
		if(AuthorizationTypeEnum.AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.YOU_HAVE_DELEGATER_AUTHORIT);
		}

		//被授权方
		if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			boolean b = caseManagerService.queryCaseManagerInfo(caseApprove.getCaseId(), authorizationDelegateVO.getAuthorizationUserId());
			if(!b){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
			}

			//有关系
			if(AuthorizationWithCaseRelationEnum.HAVE_RELATION.getCode().equals(authorizationDelegateVO.getBeAuthorizationWithCaseRelation())){

				if(!approveDuties.equals(duties)){
					if(!approveDuties.equals(authorizationDelegateVO.getAuthorizationDuties())){
						return BusiValidResult
								.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
					}
				}

			}else{
				if(!approveDuties.equals(authorizationDelegateVO.getAuthorizationDuties())){
					return BusiValidResult
							.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
				}
			}
		}
		return BusiValidResult.builderSuccessResult();
	}
	
	/**
	 * 调解书审核-业务处理
	 * 根据案件id查询调解书信息
	 * @return 
	 */
	@Override
	public ConciliationBookVO selectByCaseId(CaseApproveDTO formData) {
		ConciliationBookVO conciliationBookVO = new ConciliationBookVO();
		
		//根据审批id查询案件id
		CaseApprove caseApprove = caseApproveMapper
				.selectByPrimaryKey(formData.getApproveId());
		formData.setCaseId(caseApprove.getCaseId());
		
		//查询案件申请人、被申请人的代理人姓名，职位
		CaseAgent caseAgent = new CaseAgent();
		caseAgent.setCaseId(formData.getCaseId());
		caseAgent.setLitigantType(CaseAgentTypeEnum.PROP_AGENT.getCode());
		conciliationBookVO.setCaseAgentVO(
				caseAgentMapper.selectCaseAgentByCaseId(caseAgent));
		caseAgent.setLitigantType(CaseAgentTypeEnum.DEFE_AGENT.getCode());
		conciliationBookVO.setCaseAgentsVO(
				caseAgentMapper.selectCaseAgentByCaseId(caseAgent));
		
		//根据案件id和文书类型，查询文书内容
		CaseDocDTO caseDocDTO = new CaseDocDTO();
		caseDocDTO.setCaseId(formData.getCaseId());
		caseDocDTO.setDocType(CaseDocTypeEnum.COMPROMISE_PROTOCOL_APPLY_BOOK.getCode());
		conciliationBookVO.setCaseDocumentsVO(
				caseDocMapper.selectCaseDoc(caseDocDTO));
		
		//获取合同协议相关数据
		caseDocDTO.setDocType(CaseDocTypeEnum.APPLICATION_ARBITRATION_BOOK.getCode());
		conciliationBookVO.setCaseInfo(
				caseDocMapper.queryCaseInfo(caseDocDTO));
		
		// 获取当前审批表的审批人职务
		String approveDuties = caseApproveMapper
				.selectApproveDuties(
						formData.getApproveId(),
						formData.getApproveType(), 
						CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		conciliationBookVO.setApproveDuties(approveDuties);
		
		conciliationBookVO.setApproveId(formData.getApproveId());
		conciliationBookVO.setCaseId(formData.getCaseId());
		
		//根据案件ID、申请类型查询调解协议
		ComproiseApplyVO comproiseApply = compromiseApplyMapper.queryComproiseApply(formData.getCaseId());
		CaseProtocolRecord caseProtocolRecord = new CaseProtocolRecord();
		caseProtocolRecord.setCaseId(formData.getCaseId());
		if (comproiseApply != null) {
			caseProtocolRecord.setApplyType(comproiseApply.getApplyType());
		}
		conciliationBookVO.setCaseProtocolRecordVO(
				caseProtocolRecordMapper.selectCaseProtocolRecord(caseProtocolRecord));
		
		//当前仲裁委登录人为主任、副主任
		ManagerInfo managerInfo = this.selectManagerInfo(formData.getUserId());
		conciliationBookVO.setManagerInfo(managerInfo);
		if(managerInfo != null){
			if (managerInfo.getDuties() != null) {
				if (managerInfo.getDuties().equals(ManagerInfoTypeEnum.DIRECTOR.getCode())
						|| managerInfo.getDuties().equals(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode())) {
					//查询案件审批意见列表
					conciliationBookVO.setApproveRecordList(
							caseApproveMapper.queryApproveRecordCaseId(
									formData.getCaseId(), 
									formData.getApproveType(),
									CaseApproveStatusEnum.WAIT_AUDIT.getValue(),
									RequestTypeEnum.REQUEST.getValue()));
				}
			}
		}


		//查询出授权信息
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), formData.getUserId(), caseApprove.getApproveType());

		boolean primiss=false;

		//判断是否授权
		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
			//判断是否有案件操作权限
			if(formData.getUserId().equals(caseApprove.getApproveUserId())){
				primiss=true;

			}
		}

		//判断是否是被授权
		if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			if(caseApprove.getApproveUserId().equals(authorizationDelegateVO.getAuthorizationUserId())){
				primiss=true;
			}
		}

		//判断是否有案件处理权限
		if(primiss){
			conciliationBookVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
		}else{
			conciliationBookVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
		}

		conciliationBookVO.setAuthorizationDelegateVO(authorizationDelegateVO);

		// 获取当前登录的审批人身份，添加到立案审核对象
		String userDuties = managerInfoMapper.queryDutiesByUserId(formData.getUserId());


		//当前用户是秘书，判断是否回避过
		if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.equals(userDuties)){
			List<String> statusList=new ArrayList<String>();
			statusList.add(CaseAvoidStatusEnum.WAIT_AUDIT.getValue());
			statusList.add(CaseAvoidStatusEnum.SUCCESS_AUDIT.getValue());
			//判断秘书是否申请过回避
			CaseAvoidRecordExample caseAvoidRecordExample = new CaseAvoidRecordExample();
			caseAvoidRecordExample.createCriteria().andCaseIdEqualTo(caseApprove.getCaseId()).andAvoidIdEqualTo(formData.getUserId()).andStatusIn(statusList);
			List<CaseAvoidRecord> caseAvoidRecordList = caseAvoidRecordMapper.selectByExample(caseAvoidRecordExample);
			if(caseAvoidRecordList.size()>0){
				conciliationBookVO.setIsApplyAvoid(IsApplyAvoidEnum.IS_APPLY_AVOID.getCode());
			}else{
				conciliationBookVO.setIsApplyAvoid(IsApplyAvoidEnum.NOT_IS_APPLY_AVOID.getCode());
			}
		}

		return conciliationBookVO;
	}
	
	/**
	 * 审核调解书-业务验证
	 * 判断当前审批人是否轮到该仲裁委人员
	 * @return 
	 */
	@Override
	public BusiValidResult auditBusiValid(String approveId, String userId, String approveType) {

		//根据审批id查询案件id
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

		//判断该审批是否在待审核状态
		if(!CaseApproveStatusEnum.WAIT_AUDIT.getValue().equals(caseApprove.getApproveStatus())){
			return BusiValidResult
					.builderErrorResult(ApiResultVO.Coder.APPROVE_NOT_IN_CHECK_NODE_ERROR);
		}

		//获取当前用户职务
		String duties = caseInfoMapper.queryDutiesById(userId);

		String approveDuties = caseInfoMapper.queryDutiesById(caseApprove.getApproveUserId());

		//查询出授权情况
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), userId, caseApprove.getApproveType());

		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
			boolean flag = caseManagerService.queryCaseManagerInfo(caseApprove.getCaseId(), userId);
			if(!flag){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
			}

			if(!userId.equals(caseApprove.getApproveUserId())){
				return BusiValidResult
						.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}
		}

		//判断是授权方
		if(AuthorizationTypeEnum.AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.YOU_HAVE_DELEGATER_AUTHORIT);
		}

		//被授权方
		if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			boolean b = caseManagerService.queryCaseManagerInfo(caseApprove.getCaseId(), authorizationDelegateVO.getAuthorizationUserId());
			if(!b){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
			}

			//有关系
			if(AuthorizationWithCaseRelationEnum.HAVE_RELATION.getCode().equals(authorizationDelegateVO.getBeAuthorizationWithCaseRelation())){

				if(!approveDuties.equals(duties)){
					if(!approveDuties.equals(authorizationDelegateVO.getAuthorizationDuties())){
						return BusiValidResult
								.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
					}
				}

			}else{
				if(!approveDuties.equals(authorizationDelegateVO.getAuthorizationDuties())){
					return BusiValidResult
							.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
				}
			}
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 审核调解书-业务处理
	 * 插入审批意见、判断是否分配了仲裁委人员
	 * @return 
	 */
	@Override
	public BusiExecuteResult add(CaseApproveSuggestDTO formData, String userId) {
		//插入审批意见表
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();
		
		//操作类型 通过或者反馈修改意见
		String opinion = formData.getOpinionStatus();
		
		//获取当前登录的仲裁委人员信息
		ManagerInfo managerInfo = this.selectManagerInfo(userId);
		
		//操作人为秘书
		if (ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(
				managerInfo.getDuties())){
			//更新审批意见表的意见状态为通过
			caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH
					.getValue());
			
			// 审批意见表标注
			caseApproveSuggest
					.setMark(CaseApproveDescribeEnum.ARBITRATION_SECRETARY_FIRST_TRIAL
							.getDescribe());
			
			//判断当前案件是否有仲裁部长
			boolean queryCaseManagerInfo = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(), 
						ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
			//没有部长
			if (!queryCaseManagerInfo) {
				//分配仲裁部长
				int insertManagerType = this.insertManagerType(formData.getCaseId(), 
						ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				if (insertManagerType < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			//秘书操作完成，将仲裁部长更新到审批表中
			//查询仲裁部长的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(
					formData.getCaseId(),
					ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),
					CaseManagerStatusEnum.OK.getCode());
			//更新审批人为仲裁部长
			int updateApproverId = caseApproveMapper.updateApproverId(
					formData.getApproveId(), managerId);
			if (updateApproverId < 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
		}
		
		//操作人为部长
		if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(
				managerInfo.getDuties())) {
			//操作类型为反馈修改建议
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)){
				//调解书将回到仲裁庭，将由仲裁员审核，审批人修改为仲裁员
				//查询当前案件仲裁员
				CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
				caseArbitratorExample
						.createCriteria()
						.andCaseIdEqualTo(formData.getCaseId())
						.andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
				List<CaseArbitrator> caseArbitrator = caseArbitratorMapper
						.selectByExample(caseArbitratorExample);
				String arbitratorId = caseArbitrator.get(0).getArbitratorId();
				
				//更新审批人为仲裁员
				int uai = caseApproveMapper.updateApproverId(
						formData.getApproveId(), arbitratorId);
				if (uai < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//修改审批状态为未通过
				int type = this.updateByApproveType(formData.getApproveId());
				if (type < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 审批意见表标注
				caseApproveSuggest
						.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_SUGGESTION
								.getDescribe());
			}
			
			//操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)){
				
				//更新审批意见表的意见状态为通过
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH
						.getValue());
				
				// 审批意见表标注
				caseApproveSuggest
						.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_PASS
								.getDescribe());
				
				//判断当前案件是否有副主任
				boolean queryCaseManagerInfo = whetherDistributionService
						.queryCaseManagerInfo(formData.getCaseId(), 
							ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				//没有副主任
				if (!queryCaseManagerInfo) {
					//分配副主任
					int imt = this.insertManagerType(formData.getCaseId(), 
							ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					
					if (imt <= 0) {
						return BusiExecuteResult
								.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}
				
				//部长操作完成，将副主任更新到审批表中
				//查询副主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(
						formData.getCaseId(),
						ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(),
						CaseManagerStatusEnum.OK.getCode());
				//更新审批人为副主任
				int updateApproverId = caseApproveMapper.updateApproverId(
						formData.getApproveId(), managerId);
				if (updateApproverId <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}
		}
		
		//操作人为副主任
		if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode()
				.equals(managerInfo.getDuties())){
			//操作类型为反馈修改建议
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)){
				//调解书将回到仲裁庭，将由仲裁员审核，审批人修改为仲裁员
				//查询当前案件仲裁员
				CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
				caseArbitratorExample
						.createCriteria()
						.andCaseIdEqualTo(formData.getCaseId())
						.andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
				List<CaseArbitrator> caseArbitrator = caseArbitratorMapper
						.selectByExample(caseArbitratorExample);
				String arbitratorId = caseArbitrator.get(0).getArbitratorId();
				
				//更新审批人为仲裁员
				int uai = caseApproveMapper.updateApproverId(
						formData.getApproveId(), arbitratorId);
				if (uai < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//修改审批状态为未通过
				int type = this.updateByApproveType(formData.getApproveId());
				if (type < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 添加意见表审批标注
				caseApproveSuggest
					.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_SUGGESTION
						.getDescribe());
			}
			
			//操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)){
				//更新审批意见表的意见状态为通过
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH
						.getValue());
				
				// 添加意见表审批标注
				caseApproveSuggest
					.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS
						.getDescribe());
				
				// 判断当前案件是否有主任
				boolean queryCaseManagerInfo = whetherDistributionService
						.queryCaseManagerInfo(formData.getCaseId(),
							ManagerInfoTypeEnum.DIRECTOR.getCode());
				//没有主任
				if (!queryCaseManagerInfo) {
					//分配主任
					int imt = this.insertManagerType(formData.getCaseId(), 
							ManagerInfoTypeEnum.DIRECTOR.getCode());
					
					if (imt <= 0) {
						return BusiExecuteResult
								.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}
				
				//副主任操作完成，将主任更新到审批表中
				//查询主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(
						formData.getCaseId(),
						ManagerInfoTypeEnum.DIRECTOR.getCode(),
						CaseManagerStatusEnum.OK.getCode());
				//更新审批人为主任
				int updateApproverId = caseApproveMapper.updateApproverId(
						formData.getApproveId(), managerId);
				if (updateApproverId <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}
		}
		
		//操作人为主任
		if (ManagerInfoTypeEnum.DIRECTOR.getCode()
				.equals(managerInfo.getDuties())){
			//操作类型为反馈修改建议
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)){
				//调解书将回到仲裁庭，将由仲裁员审核，审批人修改为仲裁员
				//查询当前案件仲裁员
				CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
				caseArbitratorExample
						.createCriteria()
						.andCaseIdEqualTo(formData.getCaseId())
						.andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
				List<CaseArbitrator> caseArbitrator = caseArbitratorMapper
						.selectByExample(caseArbitratorExample);
				String arbitratorId = caseArbitrator.get(0).getArbitratorId();
				
				//更新审批人为仲裁员
				int uai = caseApproveMapper.updateApproverId(
						formData.getApproveId(), arbitratorId);
				if (uai < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//修改审批状态为未通过
				int type = this.updateByApproveType(formData.getApproveId());
				if (type < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 添加意见表审批标注
				caseApproveSuggest
					.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_SUGGESTION
						.getDescribe());
			}
			
			//操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)){
				//修改审批状态
				int type = this.updateApproveType(formData.getApproveId());
				if (type < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为通过
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH
						.getValue());
				
				// 添加意见表审批标注
				caseApproveSuggest
					.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS
						.getDescribe());
			}
		}

		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());

		formData.setDuties(managerInfo.getDuties());

		//查询出授权情况
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(formData.getCaseId(), formData.getCreaterId(), caseApprove.getApproveType());

		//判断是否授权
		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
			caseApproveSuggest.setIsAuthorized(ApproveIsAuthorizedEnum.NOT_AUTHORIZED.getCode());
		}

		//判断是否是被授权方
		if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			caseApproveSuggest.setIsAuthorized(ApproveIsAuthorizedEnum.AUTHORIZED.getCode());
			//是被授权方，判断当前是用自己的职务操作案件还是用被授予的权限操作按键
			if(caseApprove.getApproveUserId().equals(authorizationDelegateVO.getAuthorizationUserId())){
				caseApproveSuggest.setSuggestUserDuties(authorizationDelegateVO.getAuthorizationDuties());
			}
		}
		
		caseApproveSuggest.setId(sequenceService.getCommonID());
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setCreaterId(formData.getCreaterId());
		caseApproveSuggest.setCreateTime(new Date());

		// 插入审批意见表
		int cjdLow = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if (cjdLow < 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		
		return BusiExecuteResult.builderSuccessResult();
	}

	/** 
	 * 分配仲裁委工作人员
	 * @return 
	 */
	public int insertManagerType(String caseId, String type) {
		return caseManagerMapper.allotManagerPeopleByCaseAndType(caseId, type);
	}

	/**
	 * 获取当前登录的仲裁委人员信息
	 * @return 
	 */
	public ManagerInfo selectManagerInfo(String userId) {
		ManagerInfo managerInfo = managerInfoMapper.queryDutiesAndStatusByPrimaryKey(userId);
		return managerInfo;
	}

	/**
	 * 修改审批状态为通过
	 * @return 
	 */
	public int updateApproveType(String approveId) {
		CaseApprove caseApprove = new CaseApprove();
		caseApprove.setId(approveId);
		caseApprove.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
		return caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
	}
	
	/**
	 * 修改审批状态为未通过
	 * @return 
	 */
	public int updateByApproveType(String approveId) {
		CaseApprove caseApprove = new CaseApprove();
		caseApprove.setId(approveId);
		caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
		return caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
	}

}
