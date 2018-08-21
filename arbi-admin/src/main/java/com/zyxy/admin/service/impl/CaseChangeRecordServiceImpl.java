package com.zyxy.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CaseChangeRecordService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseChangeRecordDTO;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.vo.ApiResultVO.Coder;

/**
 * 变更仲裁请求serviceImpl
 *
 */
@Service
public class CaseChangeRecordServiceImpl implements CaseChangeRecordService {

	@Autowired
	private CaseInfoMapper caseInfoMapper;

	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper;

	@Autowired
	private DocSendRecordMapper docSendRecordMapper;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private CaseRequestInfoMapper caseRequestInfoMapper;
	
	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;
	
	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private WhetherDistributionService whetherDistributionService;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private MicroThirdService microThirdService;


	@Autowired
    private UserInfoMapper userInfoMapper;

	@Autowired
    private WorkDayService workDayService;

	@Autowired
    private CaseTimeSetMapper caseTimeSetMapper;


	@Autowired
    private MicroMessageService microMessageService;

	@Autowired
    private CaseDocMapper caseDocMapper;

	@Autowired
    private CaseDocContentMapper caseDocContentMapper;

	@Autowired
	private CaseManagerService caseManagerService;
	
	/**
	 * 查询变更仲裁请求业务验证
	 */
	@Override
	public BusiValidResult queryCaseChangeRecordBusiValid(String userId,String approveId) {
        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);
        if(caseApprove==null){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.APPROVE_TYPE_ERROR);
        }

		CaseInfoExample caseInfoExample = new CaseInfoExample();
		caseInfoExample.createCriteria().andIdEqualTo(caseApprove.getCaseId());
		// 根据案件id查询该案件存不存在
		int i = caseInfoMapper.countByExample(caseInfoExample);
		if (i <= 0) {
			return BusiValidResult
					.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}


		//查询出当前用户的职务
		String duties = caseInfoMapper.queryDutiesById(userId);

		if(!(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties))){
			if(!userId.equals(caseApprove.getApproveUserId())){
				return BusiValidResult
						.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}

		}

		//查询出授权情况
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(caseApprove.getCaseId(), userId, caseApprove.getApproveType());

		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
			boolean flag = caseManagerService.queryCaseManagerInfo(caseApprove.getCaseId(), userId);
			if(!flag){
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION_TO_DEAL_THIS_CASE);
			}
		}

		//判断是授权方
		if(AuthorizationTypeEnum.AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
			return BusiValidResult.builderErrorResult(Coder.YOU_HAVE_DELEGATER_AUTHORIT);
		}

        return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 查询变更仲裁请求业务处理
	 */
	@Override
	public BusiExecuteResult<CaseChangeRecordVO> queryCaseChangeRecordBusiExecuteResult(
			String userId,String approveId) {
		CaseChangeRecordVO caseChangeRecordVO = this
				.queryCaseChangeRecord(userId,approveId);
		if(caseChangeRecordVO!=null){


            CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

            caseChangeRecordVO.setIsTribunal(caseApprove.getTribunalMark());


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
				caseChangeRecordVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
			}else{
				caseChangeRecordVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
			}

            //查询出当前用户的职务
			String duties = caseInfoMapper.queryDutiesById(userId);
			
			//查询出审批记录
			List<ApproveRecordVO> approveRecordVOList = caseApproveMapper
					.queryApproveRecordCaseId(caseApprove.getCaseId(),
							ApproveTypeEnum.ALTERATION_ARBITRATION_REQUEST
									.getTypeName(),
							CaseApproveStatusEnum.WAIT_AUDIT.getValue(),
							RequestTypeEnum.REQUEST.getValue());


			caseChangeRecordVO.setAuthorizationDelegateVO(authorizationDelegateVO);
			caseChangeRecordVO.setDuties(duties);
			caseChangeRecordVO.setApproveRecordVOList(approveRecordVOList);
			caseChangeRecordVO.setApproveDuties(caseInfoMapper.queryDutiesById(caseApprove.getApproveUserId()));
		}
		
		return BusiExecuteResult.builderSuccessResult(caseChangeRecordVO);
	}
	
	
	/**
	 * 变更仲裁请求审核业务验证
	 */
	@Override
	public BusiValidResult auditCaseChangeRecordBusiValid(String caseId,
			String userId,String approveId,String caseChangeRecordId) {
		CaseInfoExample caseInfoExample = new CaseInfoExample();
		caseInfoExample.createCriteria().andIdEqualTo(caseId);
		// 根据案件id查询该案件存不存在
		int i = caseInfoMapper.countByExample(caseInfoExample);
		if (i <= 0) {
			return BusiValidResult
					.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}

		//查询出该条审批
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


		//查询出仲裁请求变更记录
		CaseChangeRecordWithBLOBs caseChangeRecord = caseChangeRecordMapper.selectByPrimaryKey(caseChangeRecordId);
		//查看该变更记录是否存在
		if(caseChangeRecord==null){
			return BusiValidResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		//判断该变更记录的状态
		if(!CaseChangeStatusEnum.WAIT_AUDIT.getValue().equals(caseChangeRecord.getStatus())){
			return BusiValidResult.builderErrorResult(Coder.APPROVE_NOT_IN_CHECK_NODE_ERROR);
		}
		
		return BusiValidResult.builderSuccessResult();
	}
	
	
	/**
	 * 变更仲裁请求审核业务处理
	 */
	@Override
	public BusiExecuteResult auditCaseChangeRecordBusiExecute(CaseApproveSuggestDTO formData,String caseChangeRecordId) {
		//获取当前用户职务
		String duties = caseInfoMapper.queryDutiesById(formData.getCreaterId());
		
		

		//当前操作人是仲裁秘书
		if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(duties)){
			
			CaseChangeRecordWithBLOBs recordWithBlobs = new CaseChangeRecordWithBLOBs();
			recordWithBlobs.setId(caseChangeRecordId);
			recordWithBlobs.setMarkAmount(formData.getAmounts());
			recordWithBlobs.setCaseAdmissibleAmount(formData.getCaseAdmissibleAmount());
			recordWithBlobs.setCaseHandlingAmount(formData.getCaseHandlingAmount());
			
			//查询该案件之前是否变更过请求
			CaseChangeRecordExample example = new CaseChangeRecordExample();
			example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andCounterclaimFlagEqualTo(formData.getCounterclaimFlag());
			example.setOrderByClause("CREATE_TIME DESC");
			List<CaseChangeRecord> caseChangeRecordList = caseChangeRecordMapper.selectByExample(example);
			
			if(caseChangeRecordList.size()>0){
				
				//得到最近一次变更的标的金额、受理费、处理费以及仲裁费
				CaseChangeRecord caseChangeRecord = caseChangeRecordList.get(0);
				BigDecimal caseAdmissibleAmount = caseChangeRecord.getCaseAdmissibleAmount();
				BigDecimal caseHandlingAmount = caseChangeRecord.getCaseHandlingAmount();
				BigDecimal totalAmount = caseAdmissibleAmount.add(caseHandlingAmount);
				
				//得到当前变更的受理费、处理费以及仲裁费
				BigDecimal caseAcceptAmount = formData.getCaseAdmissibleAmount();
				BigDecimal caseHandingAmount = formData.getCaseHandlingAmount();
				BigDecimal totalAmounts = caseAcceptAmount.add(caseHandingAmount);
				
				//算出差值
				BigDecimal differenceAmount = totalAmounts.subtract(totalAmount);
					
				//比较大小 -1 是小于 1是大于
				if(differenceAmount.compareTo(new BigDecimal(0))==-1){
					
					//设置应补缴费用
					recordWithBlobs.setPaymentShouldBe(differenceAmount);
					
				}else if(differenceAmount.compareTo(new BigDecimal(0))==1){
					
					//设置应退费
					recordWithBlobs.setShouldBeRefund(differenceAmount);
					
				}else{
					
					//当差值为0时，不做任何处理
				}
				
			}else{
				//之前没有变更记录时，不做任何处理
			}
			
			//将标的金额、受理费、处理费等修改进入变更记录里
			int low = caseChangeRecordMapper.updateByPrimaryKeySelective(recordWithBlobs);
			
			if(low<=0){
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
			// 判断当前案件是否有仲裁部长
			boolean isMinister = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(),
							ManagerInfoTypeEnum.ARBITRATION_MINISTER
									.getCode());
			
			if(!isMinister){
				// 分配仲裁部长
				int isMinisterLow = caseManagerMapper
						.allotManagerPeopleByCaseAndType(formData
								.getCaseId(),
								ManagerInfoTypeEnum.ARBITRATION_MINISTER
										.getCode());
				if (isMinisterLow <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			//查询仲裁部长的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),
					ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(), CaseManagerStatusEnum.OK.getCode());
			//将查询出的仲裁部长添加到审批表
			int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
			if (updateApproverId <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
		}else if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)){//当前操作人是仲裁部长
			
			// 判断当前案件是否有副主任
			boolean isDeputyDirector = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(),
							ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());

			if (!isDeputyDirector) {// 没有副主任，需要分配副主任
				// 分配副主任
				int isDistributionLow = caseManagerMapper
						.allotManagerPeopleByCaseAndType(formData
								.getCaseId(),
								ManagerInfoTypeEnum.DEPUTY_DIRECTOR
										.getCode());
				
				if (isDistributionLow <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}

			}
			
			
			// 判断当前案件是否有主任
			boolean isDirector = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(),
							ManagerInfoTypeEnum.DIRECTOR.getCode());
			
			if(!isDirector){
				// 分配主任
				int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(
						formData.getCaseId(),
						ManagerInfoTypeEnum.DIRECTOR.getCode());
				
				if (isDistributionLow <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			
			//查询副主任的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),
					ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
			//将查询出的副主任添加到审批表
			int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
			if (updateApproverId <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
		}else if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){//当前操作人是主任或者副主任
			
			CaseApprove caseApprove = new CaseApprove();
			
			caseApprove.setId(formData.getApproveId());
			CaseChangeRecord record = new CaseChangeRecord();
			record.setId(caseChangeRecordId);

			//短信模板
			String telId="";

			//todo 插入文书
			CaseDoc caseDoc = new CaseDoc();
			String docId=sequenceService.getCommonID();
			caseDoc.setId(docId);
			caseDoc.setCaseId(formData.getCaseId());
            caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
            caseDoc.setCreaterId(formData.getCreaterId());
            caseDoc.setCreateTime(new Date());
            caseDoc.setBusiId(caseChangeRecordId);

            //todo 插入文书内容
            CaseDocContentWithBLOBs caseDocContentWithBLOBs=new CaseDocContentWithBLOBs();
            String docContentId = sequenceService.getCommonID();
            caseDocContentWithBLOBs.setId(docContentId);
            caseDocContentWithBLOBs.setCaseId(formData.getCaseId());
            caseDocContentWithBLOBs.setDocId(docId);
            caseDocContentWithBLOBs.setCreateTime(caseDoc.getCreateTime());

			//操作是驳回
			if ((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())) {
				caseDoc.setDocName(CaseDocTypeEnum.NOT_ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE.getDocName());
				caseDoc.setDocType(CaseDocTypeEnum.NOT_ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE.getCode());
				record.setStatus(CaseChangeStatusEnum.FAIL_AUDIT.getValue());
				// 审批表状态，修改为未通过
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());

                telId="1007";
				
			}
			
			// 操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(formData.getOpinionStatus())) {

                caseDoc.setDocName(CaseDocTypeEnum.ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE.getDocName());
                caseDoc.setDocType(CaseDocTypeEnum.ACCEPT_CHANGE_OF_ARBITRATION_REQUEST_NOTICE.getCode());
                telId="1006";

                //生成缴费单
                CaseChangeRecordWithBLOBs caseChangeRecordWithBLOB = caseChangeRecordMapper.selectByPrimaryKey(caseChangeRecordId);
                if(caseChangeRecordWithBLOB.getPaymentShouldBe()!=null){

                    String userId = caseChangeRecordWithBLOB.getUserId();
                    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);


                    PayInfoDTO info = new PayInfoDTO();
                    info.setBuzzId(caseChangeRecordId);
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
                    caseChangeRecordWithBLOBs.setId(caseChangeRecordId);
                    caseChangeRecordWithBLOBs.setPayEndTime(payEndTime);
                    caseChangeRecordWithBLOBs.setStatus(CaseChangeStatusEnum.WAIT_PAY.getValue());
                    caseChangeRecordWithBLOBs.setPayId(payNoteApiResultVo.getBody());
                    int i = caseChangeRecordMapper.updateByPrimaryKeySelective(caseChangeRecordWithBLOBs);
                    if(i<=0){
                        return BusiExecuteResult.builderSuccessResult(Coder.DB_UPDATE_ERROR);
                    }

                }

				// 审批表状态，修改为通过
				caseApprove.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
			}

			caseDocMapper.insertSelective(caseDoc);
			caseDocContentMapper.insertSelective(caseDocContentWithBLOBs);
			//发送短信
            DocSendRecord docSendRecord = new DocSendRecord();
            docSendRecord.setDocId(docId);
            docSendRecord.setCaseId(formData.getCaseId());

            docSendRecord.setSendType(DocSendRecordTypeEnum.SHORT_MESSAGE.getCode());
            docSendRecord.setStatus(Integer.parseInt(DocSendRecordStatusEnum.NORMAL.getCode()));
            docSendRecord.setCreaterId(formData.getCreaterId());
            docSendRecord.setCreateTime(new Date());

            LitigantInfoVO litigantInfoVO = caseInfoMapper.selectLitigantInfoByCaseId(formData.getCaseId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phone",litigantInfoVO.getPropPhone());
            jsonObject.put("caseNo",litigantInfoVO.getCaseNo());

            docSendRecord.setReceiverId(litigantInfoVO.getPropUserId());
            docSendRecord.setReceiverType(DocSendReceiverType.APPLICANT.getCode());
            docSendRecordMapper.insert(docSendRecord);

            microMessageService.sendSms(litigantInfoVO.getPropPhone(),telId,jsonObject.toJSONString(),litigantInfoVO.getPropUserId(),caseChangeRecordId);
            jsonObject.put("phone",litigantInfoVO.getDefePhone());

            docSendRecord.setReceiverId(litigantInfoVO.getDefeUserId());
            docSendRecord.setReceiverType(DocSendReceiverType.RESPONDENT.getCode());
            docSendRecordMapper.insert(docSendRecord);

            microMessageService.sendSms(litigantInfoVO.getDefePhone(),telId,jsonObject.toJSONString(),litigantInfoVO.getDefeUserId(),caseChangeRecordId);

            if(litigantInfoVO.getPropAgentName()!=null){
                jsonObject.put("phone",litigantInfoVO.getPropAgentPhone());

                docSendRecord.setReceiverId(litigantInfoVO.getPropAgentUserId());
                docSendRecord.setReceiverType(DocSendReceiverType.APPLICANT_AGNET.getCode());
                docSendRecordMapper.insert(docSendRecord);

                microMessageService.sendSms(litigantInfoVO.getPropAgentPhone(),telId,jsonObject.toJSONString(),litigantInfoVO.getPropAgentUserId(),caseChangeRecordId);
            }

            if(litigantInfoVO.getDefeAgentName()!=null){
                jsonObject.put("phone",litigantInfoVO.getDefePhone());

                docSendRecord.setReceiverId(litigantInfoVO.getDefeAgentUserId());
                docSendRecord.setReceiverType(DocSendReceiverType.RESPONDENT_AGENT.getCode());
                docSendRecordMapper.insert(docSendRecord);

                microMessageService.sendSms(litigantInfoVO.getDefePhone(),telId,jsonObject.toJSONString(),litigantInfoVO.getDefeAgentUserId(),caseChangeRecordId);
            }
			
			//修改变更仲裁记录表的状态
			int low = caseChangeRecordMapper.updateByPrimaryKey(record);
			
			// 数据更新到审批表
			int updateStatus = caseApproveMapper.updateApproveStatus(caseApprove);
			if (updateStatus <= 0 && low <=0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
		}
        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());

        formData.setDuties(duties);
		//查询出授权情况
		AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(formData.getCaseId(), formData.getCreaterId(), caseApprove.getApproveType());

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

		//插入意见
		boolean flag = this.saveCaseChangeRecordApproveSuggest(formData);

		if(!flag){
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}


		
		return BusiExecuteResult.builderSuccessResult();
	}


	/****************** 私有service **********************/
	/**
	 * 查询变更仲裁请求申请对象
	 * 
	 * @param userId
	 * @param approveId
	 * @return
	 */
	private CaseChangeRecordVO queryCaseChangeRecord(
			String userId,String approveId) {
		return caseChangeRecordMapper.queryCaseChangeRecordByDTO(userId,approveId);
	}

	/**
	 * 插入审批意见
	 * @param formData
	 * @return
	 */
	private boolean saveCaseChangeRecordApproveSuggest(CaseApproveSuggestDTO formData){
		
		// 生成审批意见id
		String approveSuggestId = sequenceService.getCommonID();
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();
		
		//获取当前责任人的id
		String duties = caseInfoMapper.queryDutiesById(formData.getCreaterId());
		
		//判断当前操作人是主任还是副主任
		if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){
			caseApproveSuggest.setOpinionStatus(formData.getOpinionStatus());
		}
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setCreaterId(formData.getCreaterId());
		caseApproveSuggest.setId(approveSuggestId);
		caseApproveSuggest.setCreateTime(new Date());
		int low = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if(low>0){
			return true;
		}
		return false;
	}
}
