package com.zyxy.admin.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.enums.*;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.InitiateAuditService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseMat;
import com.zyxy.common.domain.CaseTimeSet;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.domain.ManagerInfoExample;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.flow.CaseAuditDTO;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseApproveSuggestMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.CaseMatMapper;
import com.zyxy.common.mapper.CaseRequestInfoMapper;
import com.zyxy.common.mapper.CaseTimeSetMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroFlowService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 立案审核相关服务
 */
@Service
public class InitiateAuditServiceImpl implements InitiateAuditService {
	@Autowired
	private CaseInfoMapper caseInfoMapper;

	@Autowired
	private CaseMatMapper caseMatMapper;

	@Autowired
	private CaseManagerMapper caseManagerMapper;

	@Autowired
	private CaseApproveMapper caseApproveMapper;

	@Autowired
	private CaseRequestInfoMapper caseRequestInfoMapper;

	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;

	@Autowired
	private WhetherDistributionService whetherDistributionService;

	@Autowired
	private MicroFlowService microFlowService;

	@Autowired
	private ManagerInfoMapper managerInfoMapper;

	@Autowired
	private WorkDayService workDayService;
	
	@Autowired
	private CaseTimeSetMapper caseTimeSetMapper;

	@Autowired
	private CaseManagerService caseManagerService;

	/**
	 * 立案审核业务处理
	 * @param approveId  审批id
	 * @param userId  用户id
	 * @return
	 */
	@Override
	public InitiateAuditVO initiateAuditBusiExecute(String approveId, String userId) {
		return this.queryinitiateAuditByCaseId(approveId,RequestTypeEnum.REQUEST.getValue(),userId);
	}

	/**
	 * 审核立案申请业务处理
	 * 
	 * @param formData 立案审核DTO
	 * @return
	 */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public BusiExecuteResult auditTheCaseBusiExecute(AuditPutOnRecordDTO formData) {
		/**
		 * 操作类型 通过或者驳回，只有主任或者副主任才能驳回
		 */
		String opinion = formData.getOpinionStatus();
		
		// 判断当前用户身份
		String currentDuties = caseInfoMapper.queryDutiesById(formData.getUserId());
		
		/**
		 * 更改审批表审批状态和审批人
		 */
		CaseApprove caseApprove = new CaseApprove();

		/**
		 * 插入审批意见表
		 */
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();

		/**
		 * 操作人为主任和副主任
		 */
		if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)|| ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
			// 操作类型为驳回
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)) {
				
				// 审批表状态，修改为未通过
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				
				// 按照审批ID查找，指定修改的审批表对象
				caseApprove.setId(formData.getApproveId());
				
				// 意见表状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED.getValue());
				
				// 添加意见表审批标注
				if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe());
				}else if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe());
				}else if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe());
				}
				
				// 数据更新到审批表
				int ups = caseApproveMapper.updateStatus(caseApprove);
				if (ups <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				// 立案审核流程控制
				CaseAuditDTO caseAuditDTO = new CaseAuditDTO();
				caseAuditDTO.setCaseId(formData.getCaseId());
				caseAuditDTO.setResult(formData.getOpinionStatus());
				caseAuditDTO.setUserId(formData.getUserId());
				ApiResultVO<String> audit = microFlowService.audit(formData.getCaseId(), caseAuditDTO);
//				if (!(ApiResultVO.Coder.SUCCESS.getCode()).equals(audit.getHead().getRetCode())) {
//					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CALL_SERV_ERROR);
//				}
				
			// 操作类型为通过	
			}else if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)) {
				
				// 审核通过，计算缴费时间并将缴费截止时间更新到请求表
				//计划结束时间
                CaseTimeSet caseTimeSet;
                caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PAY.getValue());
                
                //缴费截止时间
                Date payEndTime = workDayService.after(new Date(), caseTimeSet.getTimeSet(), true);
                
                //将缴费截止时间更新到数据库
				int uqdatePayEndTime = caseRequestInfoMapper.uqdatePayEndTime(formData.getApproveId(), payEndTime);
				
				// 审批表状态，修改为代缴费
				caseApprove.setApproveStatus(CaseApproveStatusEnum.BILL_PAYMENT.getValue());
				
				// 按照审批ID查找，指定修改的审批表对象
				caseApprove.setId(formData.getApproveId());
				
				// 意见表状态为通过
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
				
				// 添加意见表审批标注
				if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
				}else if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
				}
				
				// 数据更新到审批表
				int updateStatus = caseApproveMapper.updateStatus(caseApprove);
				if (updateStatus <= 0 || uqdatePayEndTime <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				// 立案审核流程控制
				CaseAuditDTO caseAuditDTO = new CaseAuditDTO();
				caseAuditDTO.setCaseId(formData.getCaseId());
				caseAuditDTO.setResult(formData.getOpinionStatus());
				caseAuditDTO.setUserId(formData.getUserId());
				
				ApiResultVO<String> audit = microFlowService.audit(formData.getCaseId(), caseAuditDTO);
//				if (!(ApiResultVO.Coder.SUCCESS.getCode()).equals(audit.getHead().getRetCode())) {
//					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CALL_SERV_ERROR);
//				}
			}
		} else {// 当操作为立案秘书和立案部长,立案秘书和立案部长只能通过，不能驳回
			
			// 意见表状态为通过
			caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
			
			// 操作人为秘书
			if (ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode().equals(currentDuties)) {
				
				// 审批意见表标注
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.INITIATE_SECRETARY_FIRST_TRIAL.getDescribe());
				
				// 将仲裁费用更新到请求表中
				BigDecimal arbitrationFee = formData.getArbitrationFee(); // 仲裁费
				BigDecimal handling = formData.getHandling(); // 处理费
				
				// 算出差值
				BigDecimal theFeeFor = arbitrationFee.subtract(handling); // 受理费
				BigDecimal amounts = formData.getAmounts(); // 涉案金额
				BigDecimal behaviorCharges = formData.getBehaviorCharges(); // 行为费
				
				// 生成支付ID
				String payId = sequenceService.getCommonID();
				if (arbitrationFee.compareTo(new BigDecimal(0)) == -1|| handling.compareTo(new BigDecimal(0)) == -1|| theFeeFor.compareTo(new BigDecimal(0)) == -1|| amounts.compareTo(new BigDecimal(0)) == -1|| behaviorCharges.compareTo(new BigDecimal(0)) == -1|| formData.getCaseTypeId() == null) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
				}
				int uqdateArbitrationFee = caseRequestInfoMapper.uqdateArbitrationFee(formData.getApproveId(), amounts,handling, theFeeFor, payId,behaviorCharges);
				
				// 将案由更新到案件基本信息表
				int updateCaseTypeId = caseInfoMapper.updateCaseTypeId(formData.getCaseId(), formData.getCaseTypeId());
				if (uqdateArbitrationFee <= 0 || updateCaseTypeId <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}

				// 判断当前案件是否有立案部长
				boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode());
				if (!queryCaseManagerInfo) {// 没有部长
					
					// 分配立案部长
					int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode());
					if (ampbt <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}
				
				// 秘书操作完成，将立案部长更新到审批表中
				// 查询立案部长的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode(),CaseManagerStatusEnum.OK.getCode());
				
				// 将查询出的立案部长添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
				if (updateApproverId <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}
			
			// 操作人为部长
			if (ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode().equals(currentDuties)) {
				
				// 审批意见表标注
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.INITIATE_MINISTER_REVIEW.getDescribe());
				
				// 判断当前案件是否有副主任
				boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				
				if (!queryCaseManagerInfo) {// 没有副主任，需要分配副主任
					
					// 分配副主任
					int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					
					// 分配主任
					int am = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
					if (ampbt <= 0 || am <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}

				}

				// 立案部长操作完成，将副主任更新到审批表中
				// 查询副主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(),CaseManagerStatusEnum.OK.getCode());
				
				// 将查询出的副主任添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
				if (updateApproverId <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}
		}
		
		// 生成审批意见id
		String approveSuggestId = sequenceService.getCommonID();
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setId(approveSuggestId);
		caseApproveSuggest.setCreaterId(formData.getUserId());
		caseApproveSuggest.setCreateTime(new Date());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		
		// 插入审批意见表
		int casLow = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if (casLow <= 0) {
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}

	/******************** 私有service ************************/

	/**
	 * 查询并返回立案审核页面
	 * @param approveId 审批id
	 * @param requestType 本请求
	 * @param userId 用户id
	 * @return
	 */
	private InitiateAuditVO queryinitiateAuditByCaseId(String approveId,String requestType,String userId) {

        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

		// 根据案件Id和请求类型查询出案件基本信息
		ArbitratorCaseBaseInfoVO caseInfo = caseInfoMapper.queryArbitrationCaseInfo(caseApprove.getCaseId(), requestType);

		// 根据审批Id查询出证据清单记录
		List<EvidenceVO> evidenceList = caseMatMapper.selectEvidenceList(approveId);

		// 根据案件id,请求类型查询出涉案金额等金额
		CaseRequestInfoVO caseRequestInfoVO = caseRequestInfoMapper.queryAmountByCaseId(caseApprove.getCaseId(), requestType);
		
		// 根据审批Id查询审批记录
		List<ApproveRecordVO> InitiateAuditVO = caseApproveMapper.queryApproveRecordApproveId(approveId);
		
		// 获取当前审批表的审批人身份
		String approveDuties = caseApproveMapper.queryApproveUserDuties(approveId);
		
		// 获取当前登录的审批人身份，添加到立案审核对象
		String userDuties = managerInfoMapper.queryDutiesByUserId(userId);
			

		/**
		 * 立案审核对象，设置并返回
		 */
		InitiateAuditVO initiateAuditVO = new InitiateAuditVO();

        //查询出授权信息
        AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), userId, caseApprove.getApproveType());

        boolean primiss=false;

        //判断是否授权
        if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
            //判断是否有案件操作权限
            if(userId.equals(caseApprove.getApproveUserId())){
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
            initiateAuditVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
        }else{
            initiateAuditVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
        }

		// 获取当前案件id及审批id审批表审批人身份和当前用户身份,添加到立案审核对象
		initiateAuditVO.setApproveId(approveId);
		initiateAuditVO.setCaseId(caseApprove.getCaseId());
		initiateAuditVO.setApproveDuties(approveDuties);
		initiateAuditVO.setDuties(userDuties);
        initiateAuditVO.setAuthorizationDelegateVO(authorizationDelegateVO);

		// 案件详情左侧仲裁信息
		CaseArbitrationPersonnelInfoVO arbiInfo = new CaseArbitrationPersonnelInfoVO();
		List<CaseManagerVO> caseManger = caseInfoMapper
				.queryCaseArbiInfo(caseApprove.getCaseId());
		String name = null;
		String duties = null;
		for (int i = 0; i < caseManger.size(); i++) {
			duties = caseManger.get(i).getDuties();
			name = caseManger.get(i).getName();
			ManagerInfoTypeEnum managerDuties = ManagerInfoTypeEnum
					.getCode(duties);
			switch (managerDuties) {
			case INITIATE_THE_SECRETARY:
				arbiInfo.setCaseSecretaryName(name);
				break;
			case INITIATE_THE_MINISTER:
				arbiInfo.setCaseMinisterName(name);
				break;
			case ARBITRATION_SECRETARY:
				arbiInfo.setArbiSecretaryName(name);
				break;
			case ARBITRATION_MINISTER:
				arbiInfo.setArbiMinisterName(name);
				break;
			case DIRECTOR:
				arbiInfo.setDirectorName(name);
				break;
			case DEPUTY_DIRECTOR:
				arbiInfo.setDeputyDirectorName(name);
			default:
				break;
			}
		}


		//查询出案件的审批信息
		List<CaseApproveVO> caseApproveVoList = caseApproveMapper.selectApproveByCaseId(caseApprove.getCaseId(),userId);

		initiateAuditVO.setCaseApproveVoList(caseApproveVoList);

		initiateAuditVO.setArbiInfo(arbiInfo);

		initiateAuditVO.setArbitratorCaseBaseInfo(caseInfo);

		initiateAuditVO.setEvidenceList(evidenceList);

		initiateAuditVO.setCaseRequestInfoVO(caseRequestInfoVO);

		initiateAuditVO.setApproveRecordList(InitiateAuditVO);

		CaseCommProgressInfoVO caseProgressInfo = caseInfoMapper
				.queryCaseCommProgressInfo(caseApprove.getCaseId());
		initiateAuditVO.setCaseProgressInfo(caseProgressInfo);

		return initiateAuditVO;
	}
}
