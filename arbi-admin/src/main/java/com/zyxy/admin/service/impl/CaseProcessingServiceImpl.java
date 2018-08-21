package com.zyxy.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.CaseManagerDTO;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.ChangeCounterclaimDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;

/**
 * 案件处理信息serviceImpl
 *
 */
@Service
public class CaseProcessingServiceImpl implements CaseProcessingService {

	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CaseInfoMapper caseInfoMapper;

	@Autowired
	private CaseManagerMapper caseManagerMapper;

	@Autowired
	private CaseApproveMapper caseApproveMapper;

	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;

	@Autowired
	private CaseRequestInfoMapper caseRequestInfoMapper;

	@Autowired
	private ManagerInfoMapper managerInfoMapper;

	@Autowired
	private WhetherDistributionService whetherDistributionService;

	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private MicroThirdService microThirdService;

	@Autowired
	private CaseTimeSetMapper caseTimeSetMapper;

	@Autowired
	private WorkDayService workDayService;

	@Autowired
	private CaseManagerService caseManagerService;

	@Autowired
	private AuthorizationDelegateMapper authorizationDelegateMapper;
	// #######################################公共Service####################################################

	/**
	 * 业务验证 判断案件是否存在，是否属于该仲裁委人员
	 * 
	 * @param approveId 审批Id
	 * @param userId 当前用户Id
	 * @return
	 */
	@Override
	public BusiValidResult auditTheCaseBusiValid(String approveId, String userId) {
        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

        //判断案件是否存在
		String caseId = this.theCaseValidation(approveId);
		if (StringUtil.isEmpty(caseId)) {
			return BusiValidResult
					.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}


		//查询出授权信息
        AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), userId, caseApprove.getApproveType());


        //判断是否授权
        if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){

            // 该案件是否属于该类仲裁委人员
            List<CaseManager> personnelValidation = this.personnelValidation(
                    userId, approveId);

            if (personnelValidation.size()<=0) {
                return BusiValidResult
                        .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
            }

        }

        //判断是否是被授权
        if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
            // 该案件是否属于该类仲裁委人员
            List<CaseManager> personnelValidation = this.personnelValidation(
                    authorizationDelegateVO.getAuthorizationUserId(), approveId);

            if (personnelValidation.size()<=0) {
                return BusiValidResult
                        .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
            }
        }

		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 审核立案申请业务验证 判断案件是否存在，是否在待审核状态，是否轮到当前仲裁委人员审核
	 * @param approveId 审批Id
	 * @param caseId 案件Id
	 * @param userId 当前用户Id
	 * @return
	 */
	@Override
	public BusiValidResult auditBusiValid(String approveId,String caseId, String userId) {
		// 查询审批表的当前责任人
		String approveUserId = caseApproveMapper.selectApprover(approveId);
		//查询出当前用户的职务
		String duties = caseInfoMapper.queryDutiesById(userId);

		//查询出当前审批人的职务
        String approveDuties = caseInfoMapper.queryDutiesById(approveUserId);


        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

        //查询出授权情况
        AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseId, userId, caseApprove.getApproveType());

        if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
            boolean flag = caseManagerService.queryCaseManagerInfo(caseId, userId);
            if(!flag){
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
            }

            if(!(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties))){
                if(!userId.equals(caseApprove.getApproveUserId())){
                    return BusiValidResult
                            .builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
                }
            }
        }

        //判断是授权方
        if(AuthorizationTypeEnum.AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.YOU_HAVE_DELEGATER_AUTHORIT);
        }

        //被授权方
        if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
            boolean b = caseManagerService.queryCaseManagerInfo(caseId, authorizationDelegateVO.getAuthorizationUserId());
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
	 * 反请求审核业务处理
	 * @param approveId  审批id
	 * @param userId 用户id
	 * @return
	 */
	@Override
	public InitiateAuditVO beCounterclaimAuditBusiExecute(String approveId,
			String userId) {
		return this.beCounterclaimAuditByCaseId(approveId,RequestTypeEnum.BACK_REQUEST.getValue(),userId);
	}

	/**
	 * 审核反请求业务处理
	 * 
	 * @param formData 案件审核DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult auditBeCounterclaimBusiExecute(
			AuditPutOnRecordDTO formData) {
		return this.auditCounterrequest(formData);
	}

	/**
	 * 变更仲裁反请求审核
	 * @param approveId 审批id
	 * @param userId 用户id
	 * @return
	 */
	@Override
	public AhangeCounterclaimtVO changeCounterclaimtBusiExecute(String approveId,String userId) {
		return this.changeCounterclaimByCaseId(approveId,RequestTypeEnum.BACK_REQUEST.getValue(),userId);
	}

	/**
	 * 审核变更仲裁反请求
	 * 
	 * @param formData
	 *            变更仲裁请求DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult auditChangeCounterclaimBusiExecute(
			ChangeCounterclaimDTO formData) {
		return this.auditChangeCounterclaim(formData);
	}
	
	@Override
	public BusiValidResult approveBusiValid(String approveId, String userId) {
		//当前审批
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);
		
		// 查询审批表的当前责任人
		String approveUserId = null;
		
		//验证审批是否存在
		if(caseApprove ==null || caseApprove.getApproveUserId() == null || caseApprove.getApproveType() == null ||caseApprove.getCaseId() ==null){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}else{
			approveUserId = caseApprove.getApproveUserId();
		}
		
		//判断用户是否属于该案件
		List<CaseManager> list = this.personnelValidation(userId, caseApprove.getCaseId());
		if(list == null || list.isEmpty()){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
		}
		
		//验证审批状态是否为成功
		if( CaseApproveStatusEnum.SUCCESS_AUDIT.getValue().equals(caseApprove.getApproveStatus())){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.APPROVE_TYPE_ERROR);
		}
		
		//审批人的授权用户
		String agentUserId = authorizationDelegateMapper.queryAuthorization(caseApprove.getApproveUserId(), caseApprove.getApproveType());
		
		//是否已经授权给其他人
		if(userId.equals(caseApprove.getApproveUserId()) && agentUserId != null){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.YOU_HAVE_DELEGATER_AUTHORIT);
		}
		
		//验证是否被授权处理该审批
		if( !userId.equals(approveUserId) && !userId.equals(agentUserId)){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult seeDetailInfoBusiValid(String approveId,
			String userId) {
		CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);
		if(caseApprove == null || caseApprove.getCaseId() == null){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}
		
		List<CaseManager> caseManagers = this.personnelValidation(userId, caseApprove.getCaseId());
		if(caseManagers == null || caseManagers.isEmpty()){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION_TO_VIEW_THIS_CASE);
		}
		return BusiValidResult.builderSuccessResult();
	}
	
	// #######################################私有Service####################################################

	/**
	 * 根据审批Id查询案件是否存在
	 * @param approveId 审批Id
	 * @return
	 */
	private String theCaseValidation(String approveId) {
		String caseId = caseInfoMapper.queryCaseInfoCaseId(approveId);
		return caseId;

	}

	/**
	 * 通过userId判断该案件是否是该仲裁委人员审核
	 * 
	 * @param userId
	 *            用户id
	 * @param caseId
	 *            案件id
	 * @return 指定案件当前有效仲裁委
	 */
	private List<CaseManager> personnelValidation(String userId, String caseId) {
		CaseManagerExample caseManagerExample = new CaseManagerExample();
		caseManagerExample.createCriteria().andCaseIdEqualTo(caseId)
				.andManagerIdEqualTo(userId)
				.andStatusEqualTo(CaseManagerStatusEnum.OK.getCode());

		return caseManagerMapper.selectByExample(caseManagerExample);
	}

	/**
	 * 审核反请求
	 * 
	 * @param formData
	 *            立案审核DTO
	 * @return
	 */
	private BusiExecuteResult auditCounterrequest(AuditPutOnRecordDTO formData) {

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
				}
				// 状态更新到审批表
				int ups = caseApproveMapper.updateStatus(caseApprove);
				if (ups < 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			// 操作类型为通过
			}else if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)) {
				// 审批表状态，修改为代缴费
				caseApprove.setApproveStatus(CaseApproveStatusEnum.BILL_PAYMENT.getValue());
				 //计算出计划结束时间
                CaseTimeSet caseTimeSet;
                //算出时间
                if (formData.getAmounts().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.MENDING_PAY_LOWER.getValue());
                } else {
                    caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.MENDING_PAY_UPPER.getValue());
                }
                //缴费截止时间
                Date payEndTime = workDayService.after(new Date(), caseTimeSet.getTimeSet(), true);
                //将缴费截止时间更新到数据库
                int uqdatePayEndTime = caseRequestInfoMapper.uqdatePayEndTime(formData.getApproveId(), payEndTime);
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
				// 状态更新到审批表
				int updateStatus = caseApproveMapper.updateStatus(caseApprove);
				if (updateStatus <=0||uqdatePayEndTime<=0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}

			}

		} else {// 当操作为仲裁秘书和仲裁部长,仲裁秘书和仲裁部长只能通过，不能驳回
			// 意见表状态为通过
			caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
			// 操作人为秘书
			if (ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(currentDuties)) {
				// 审批意见表标注
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_SECRETARY_FIRST_TRIAL.getDescribe());
				//计算仲裁费用
				BigDecimal arbitrationFee = formData.getArbitrationFee(); // 仲裁费
				BigDecimal handling = formData.getHandling(); // 处理费
				BigDecimal amounts = formData.getAmounts(); //涉案金额费
				//算出差值
				BigDecimal theFeeFor = arbitrationFee.subtract(handling); //受理费
				BigDecimal behaviorCharges = formData.getBehaviorCharges(); // 行为费
				// 生成支付ID
				String payId =sequenceService.getCommonID();
				if(arbitrationFee.compareTo(new BigDecimal(0))==-1||handling.compareTo(new BigDecimal(0))==-1||theFeeFor.compareTo(new BigDecimal(0))==-1||amounts.compareTo(new BigDecimal(0))==-1|| behaviorCharges.compareTo(new BigDecimal(0)) == -1){
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);	
				}
				//将仲裁费用更新到请求表中
				int uqdateArbitrationFee = caseRequestInfoMapper.uqdateArbitrationFee(formData.getApproveId(),amounts,handling, theFeeFor, payId,behaviorCharges);
				if(uqdateArbitrationFee<=0){
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				// 判断当前案件是否有仲裁部长
				boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				if (!queryCaseManagerInfo) {// 没有部长
					// 分配仲裁部长
					int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
					if (ampbt < 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}

				// 秘书操作完成，将立案部长更新到审批表中
				// 查询仲裁部长的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),CaseManagerStatusEnum.OK.getCode());
				// 将查询出的仲裁部长添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
				if (updateApproverId < 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			// 操作人为部长
			}else if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(currentDuties)) {
				// 审批意见表标注
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_REVIEW.getDescribe());
				// 判断当前案件是否有副主任
				boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				if (!queryCaseManagerInfo) {// 没有副主任，需要分配副主任
					// 分配副主任
					int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					// 分配主任
					int am = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
					if (ampbt < 0 || am < 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}
				// 立案部长操作完成，将副主任更新到审批表中
				// 查询副主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(),CaseManagerStatusEnum.OK.getCode());
				// 将查询出的副主任添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
				if (updateApproverId < 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}
		}

        //查询出授权情况
        AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(formData.getCaseId(), formData.getUserId(), caseApprove.getApproveType());

        //判断是否授权
        if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
            formData.setIsAuthorized(ApproveIsAuthorizedEnum.NOT_AUTHORIZED.getCode());
        }

        //判断是否是被授权方
        if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
            formData.setIsAuthorized(ApproveIsAuthorizedEnum.AUTHORIZED.getCode());
            //是被授权方，判断当前是用自己的职务操作案件还是用被授予的权限操作按键
            if(caseApprove.getApproveUserId().equals(authorizationDelegateVO.getAuthorizationUserId())){
                formData.setDuties(authorizationDelegateVO.getAuthorizationDuties());
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
		if (casLow < 0) {
			return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}

	/**
	 * 查询并返回反请求审核页面
	 * @param approveId 审批id
	 * @param requestType 反请求
	 * @param userId 用户id
	 * @return
	 */
	private InitiateAuditVO beCounterclaimAuditByCaseId(String approveId,String requestType,String userId) {

        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

        // 根据案件Id和请求类型查询出案件基本信息
		String caseId = caseInfoMapper.queryCaseInfoCaseId(approveId);
		ArbitratorCaseBaseInfoVO caseInfoVO = caseInfoMapper.queryArbitrationCaseInfo(caseId, requestType);
		// 根据案件id查询出涉案金额等金额
		CaseRequestInfoVO caseRequestInfoVO = caseRequestInfoMapper.queryAmountByCaseId(caseId, requestType);
		// 根据审批Id,查询审批记录
		List<ApproveRecordVO> InitiateAuditVO = caseApproveMapper.queryApproveRecordApproveId(approveId);
		// 获取当前审批表的审批人身份
		String approveDuties = caseApproveMapper.queryApproveUserDuties(approveId);
		// 获取当前登录的审批人身份，添加到立案审核对象
		String userDuties = managerInfoMapper.queryDutiesByUserId(userId);



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

		/**
		 *  反请求审核审核对象，设置并返回
		 */
		InitiateAuditVO initiateAuditVO = new InitiateAuditVO();
		initiateAuditVO.setAuthorizationDelegateVO(authorizationDelegateVO);
		
		// 获取当前案件id及审批id审批表审批人身份和当前用户身份,添加到立案审核对象
		initiateAuditVO.setApproveId(approveId);
		initiateAuditVO.setCaseId(caseId);
		initiateAuditVO.setApproveDuties(approveDuties);
		initiateAuditVO.setDuties(userDuties);

        //判断是否有案件处理权限
        if(primiss){
            initiateAuditVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
        }else{
            initiateAuditVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
        }

		initiateAuditVO.setArbitratorCaseBaseInfo(caseInfoVO);

		initiateAuditVO.setCaseRequestInfoVO(caseRequestInfoVO);

		initiateAuditVO.setApproveRecordList(InitiateAuditVO);

		return initiateAuditVO;
	}

	/**
	 * 审核变更仲裁反请求
	 * 
	 * @param formData
	 *            变更仲裁反请求DTO
	 * @return
	 */
	private BusiExecuteResult auditChangeCounterclaim(
			ChangeCounterclaimDTO formData) {

		/**
		 * 操作类型 通过或者驳回，只有主任或者副主任才能驳回
		 */
		String opinion = formData.getOpinionStatus();

		// 判断当前用户身份
		String currentDuties = caseInfoMapper.queryDutiesById(formData
				.getUserId());

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
		if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)
				|| ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(
						currentDuties)) {
			// 操作类型为驳回
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)) {

				// 审批表状态，修改为未通过
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT
						.getValue());

				// 按照审批ID查找，指定修改的审批表对象
				caseApprove.setId(formData.getApproveId());

				// 意见表状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());

				// 将变更仲裁请求表的审批状态修改为未通过
				int uas = caseChangeRecordMapper.updateAuditState(formData.getChangeId(),
						CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				// 数据更新到审批表,修改审批表审批状态
				int ups = caseApproveMapper.updateStatus(caseApprove);
				if (ups < 0 || uas < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}

			}
			// 操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)) {
				// 审批表状态，修改为通过
				caseApprove
						.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT
								.getValue());

				// 按照审批ID查找，指定修改的审批表对象
				caseApprove.setId(formData.getApproveId());

				// 意见表状态为通过
				caseApproveSuggest
						.setOpinionStatus(OpinionStateEnum.GET_THROUGH
								.getValue());
				// 将变更仲裁请求表的审批状态修改为通过
				int uas = caseChangeRecordMapper.updateAuditState(formData.getChangeId(),						
						CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
				// 数据更新到审批表,修改审批表审批状态
				int updateStatus = caseApproveMapper.updateStatus(caseApprove);
				if (updateStatus < 0 || uas < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}


				//tudo 生成缴费单
				CaseChangeRecordWithBLOBs caseChangeRecordWithBLOB = caseChangeRecordMapper.selectByPrimaryKey(formData.getChangeId());
				if(caseChangeRecordWithBLOB.getPaymentShouldBe()!=null){

					String userId = caseChangeRecordWithBLOB.getUserId();
					UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);


					PayInfoDTO info = new PayInfoDTO();
					info.setBuzzId(formData.getChangeId());
					info.setPayerName(userInfo.getName());

					//查询收费项
					ApiResultVO<List<PayItemVO>> apiResultVO = microThirdService.getPayItems(PayItemsUsagesEnum.CASE_ADMISSIBLE_FEE.getCode());

					List<PayItemVO> payItemVOList = apiResultVO.getBody();

					List<PayInfoDTO.PayItem> payItemList= new ArrayList<PayInfoDTO.PayItem>();

					BigDecimal receivableAmt=new BigDecimal(0);

					for (PayItemVO payItemVO : payItemVOList) {
						PayInfoDTO.PayItem payItem = new PayInfoDTO.PayItem();
						payItem.setItemName(payItemVO.getItemName());
						payItem.setItemNo(payItemVO.getItemNo());
						payItem.setPrice(caseChangeRecordWithBLOB.getPaymentShouldBe());
						payItem.setQuantity(1);
						payItemList.add(payItem);
						receivableAmt.add(caseChangeRecordWithBLOB.getPaymentShouldBe());
					}

					info.setItems(payItemList);
					info.setReceivableAmt(receivableAmt);
					info.setUserId(userId);
					info.setRemark("变更仲裁补缴费用");

					//生成缴费单
					ApiResultVO<String> payNoteApiResultVo = microThirdService.genPayNote(info);

					CaseRequestInfo caseRequestInfo = new CaseRequestInfo();
					caseRequestInfo.setCaseId(caseChangeRecordWithBLOB.getCaseId());
					caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
					CaseRequestInfo requestInfo = caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);

					//计划结束时间
					CaseTimeSet caseTimeSet;

					//算出时间
					if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
						caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.MENDING_PAY_LOWER.getValue());
					} else {
						caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.MENDING_PAY_UPPER.getValue());
					}


					//缴费截止时间
					Date payEndTime = workDayService.after(new Date(), caseTimeSet.getTimeSet(), true);

					//把缴费单和缴费截止时间修改进数据库
					CaseChangeRecordWithBLOBs caseChangeRecordWithBLOBs = new CaseChangeRecordWithBLOBs();
					caseChangeRecordWithBLOBs.setId(formData.getChangeId());
					caseChangeRecordWithBLOBs.setStatus(CaseChangeStatusEnum.WAIT_PAY.getValue());
					caseChangeRecordWithBLOBs.setPayEndTime(payEndTime);
					caseChangeRecordWithBLOBs.setPayId(payNoteApiResultVo.getBody());
					int i = caseChangeRecordMapper.updateByPrimaryKeySelective(caseChangeRecordWithBLOBs);
					if(i<=0){
						return BusiExecuteResult.builderSuccessResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}

				}


			}

		} else {// 当操作为仲裁秘书和仲裁部长,仲裁秘书和仲裁部长只能通过，不能驳回

			// 意见表状态为通过
			caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH
					.getValue());

			// 操作人为秘书
			if (ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(
					currentDuties)) {

				// 将仲裁费用更新到请求表中
				BigDecimal paymentShouldBe = formData.getPaymentShouldBe(); // 应补缴
				BigDecimal markAmount = formData.getMarkAmount(); // 标的金额
				BigDecimal theFeeFor = formData.getTheFeeFor(); // 受理费
				BigDecimal handling = formData.getHandling();  // 受理费
				
				if (paymentShouldBe.compareTo(new BigDecimal(0)) == -1) {//不缴费不能小于0
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
				}
				
				// 生成支付ID
				String payId = sequenceService.getCommonID();
				int updateChangeRecord = caseChangeRecordMapper.updateChangeRecord(formData.getChangeId(),
						payId, paymentShouldBe, markAmount,theFeeFor,handling);
				if (updateChangeRecord < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				// 判断当前案件是否有仲裁部长
				boolean queryCaseManagerInfo = whetherDistributionService
						.queryCaseManagerInfo(formData.getCaseId(),
								ManagerInfoTypeEnum.ARBITRATION_MINISTER
										.getCode());
				if (!queryCaseManagerInfo) {// 没有部长
					// 分配仲裁部长
					int ampbt = caseManagerMapper
							.allotManagerPeopleByCaseAndType(formData.getCaseId(),
									ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
					if (ampbt < 0) {
						return BusiExecuteResult
								.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}

				// 秘书操作完成，将仲裁部长更新到审批表中
				// 查询仲裁部长的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(
						formData.getCaseId(),
						ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),
						CaseManagerStatusEnum.OK.getCode());
				// 将查询出的仲裁部长添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(
						formData.getApproveId(), managerId);
				if (updateApproverId < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
			}

			// 操作人为部长
			if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(
					currentDuties)) {

				// 判断当前案件是否有副主任
				boolean queryCaseManagerInfo = whetherDistributionService
						.queryCaseManagerInfo(formData.getCaseId(),
								ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());

				if (!queryCaseManagerInfo) {// 没有副主任，需要分配副主任
					// 分配副主任
					int ampbt = caseManagerMapper
							.allotManagerPeopleByCaseAndType(formData
									.getCaseId(),
									ManagerInfoTypeEnum.DEPUTY_DIRECTOR
											.getCode());
					// 分配主任
					int am = caseManagerMapper.allotManagerPeopleByCaseAndType(
							formData.getCaseId(),
							ManagerInfoTypeEnum.DIRECTOR.getCode());
					if (ampbt < 0 || am < 0) {
						return BusiExecuteResult
								.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}

				}

				// 仲裁部长操作完成，将副主任更新到审批表中
				// 查询副主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(
						formData.getCaseId(),
						ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(),
						CaseManagerStatusEnum.OK.getCode());
				// 将查询出的副主任添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(
						formData.getApproveId(), managerId);
				if (updateApproverId < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
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
		int casLow = caseApproveSuggestMapper
				.insertSelective(caseApproveSuggest);

		if (casLow < 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}

		return BusiExecuteResult.builderSuccessResult();
	}

	/**
	 * 查询并返回变更仲裁反请求
	 * @param approveId 审批Id
	 * @param requestType 请求类型
	 * @param userId 用户id
	 * @return
	 */
	private AhangeCounterclaimtVO changeCounterclaimByCaseId(String approveId,String requestType,String userId) {
		// 根据案件Id和请求类型查询出案件基本信息
		String caseId = caseInfoMapper.queryCaseInfoCaseId(approveId);
		ArbitratorCaseBaseInfoVO caseInfo = caseInfoMapper.queryArbitrationCaseInfo(caseId, requestType);
		
		// 根据审批Id，查询出变更后仲裁请求记录
		ChangeRequestContentVO changeRequestContentVO = caseChangeRecordMapper.queryChangeRecord(approveId);
		
		// 根据案件Id和请求类型查询出所有已通过的变更仲裁请求，应补缴的费用（用于页面计算本次应补缴费用）
		List<BigDecimal> PaymentShouldBeList = caseChangeRecordMapper.selectPaymentShouldBe(caseId, requestType,CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
		
		// 根据案件id查询出案件请求基本信息里的涉案金额等
		CaseRequestInfoVO caseRequestInfoVO = caseRequestInfoMapper.queryAmountByCaseId(caseId, requestType);
		
		// 根据审批Id查询审批记录
		List<ApproveRecordVO> approveRecordVO = caseApproveMapper.queryApproveRecordApproveId(approveId);
		
		// 获取当前审批表的审批人身份
		String approveDuties = caseApproveMapper.queryApproveUserDuties(approveId);
		
		// 获取当前登录的审批人身份，添加到立案审核对象
		String userDuties = managerInfoMapper.queryDutiesByUserId(userId);
	
		/**
		 ** 变更反请求审核信息对象，设置并返回
		 */
		AhangeCounterclaimtVO ahangeCounterclaimtVO = new AhangeCounterclaimtVO();

		// 获取当前案件id及审批id审批表审批人身份和当前用户身份,添加到立案审核对象
		ahangeCounterclaimtVO.setApproveId(approveId);
		ahangeCounterclaimtVO.setCaseId(caseId);
		ahangeCounterclaimtVO.setApproveDuties(approveDuties);
		ahangeCounterclaimtVO.setDuties(userDuties);
		
		ahangeCounterclaimtVO.setArbitratorCaseBaseInfo(caseInfo);
		ahangeCounterclaimtVO.setCaseRequestInfoVO(caseRequestInfoVO);
		ahangeCounterclaimtVO.setApproveRecordList(approveRecordVO);
		ahangeCounterclaimtVO.setChangeRequestContentVO(changeRequestContentVO);
		ahangeCounterclaimtVO.setPaymentShouldBeList(PaymentShouldBeList);
		return ahangeCounterclaimtVO;
	}

}
