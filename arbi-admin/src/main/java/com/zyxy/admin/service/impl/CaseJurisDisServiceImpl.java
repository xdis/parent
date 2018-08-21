package com.zyxy.admin.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.*;

import com.zyxy.common.dto.flow.CaseCancelDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.CaseDocGeneraService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.*;
import com.zyxy.common.vo.doc.CaseDocHeadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CaseJurisDisService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.dto.CaseJurisDisDTO;
import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO.Coder;

import static com.zyxy.common.enums.ApproveTypeEnum.COUNTERCLAIM_JURISDICTION_APPROVAL;

/**
 * 管辖权异议serviceImpl
 */
@Service
public class CaseJurisDisServiceImpl implements CaseJurisDisService {


    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    CaseJurisDisMapper caseJurisDisMapper;

    @Autowired
    CaseApproveMapper caseApproveMapper;

    @Autowired
    CaseApproveSuggestMapper caseApproveSuggestMapper;
    
    @Autowired
    SequenceService sequenceService;

    @Autowired
    private CaseDocMapper caseDocMapper;

    @Autowired
    private CaseDocContentMapper caseDocContentMapper;

    @Autowired
	private WhetherDistributionService whetherDistributionService;
    
    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CaseDocGeneraService caseDocGeneraService;

    @Autowired
	private CaseAvoidRecordMapper caseAvoidRecordMapper;

    @Autowired
    private MicroMessageService microMessageService;

    @Autowired
    private MicroFlowService microFlowService;

    @Autowired
    private DocSendRecordMapper docSendRecordMapper;

    @Autowired
    private CaseManagerService caseManagerService;

    /**
     * 查询并返回仲裁委管辖权异议对象业务处理
     * @param jurisApproveId
     * @param userId
     * @return
     */
    @Override
    public BusiExecuteResult<ArbitrationCaseJurisDisVO> queryCaseJurisDisByCaseIdBusiExecute(String jurisApproveId,String userId) {
    	//查询出当前用户的职务
		String duties = caseInfoMapper.queryDutiesById(userId);
        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(jurisApproveId);
        ApproveTypeEnum typeName = ApproveTypeEnum.getTypeName(caseApprove.getApproveType());


        String requestType=null;
        String docTypeName=null;
        String approveType=null;
        RequestTypeEnum requestTypeEnum=null;
        //判断当前审批是本请求的管辖权异议还是反请求的管辖权异议
        switch(typeName){
            case JURISDICTION_OBJECTION_APPROVAL:
                requestType=RequestTypeEnum.REQUEST.getValue();
                requestTypeEnum=RequestTypeEnum.REQUEST;
                approveType=ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName();
                docTypeName=CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getCode();
                break;
            case COUNTERCLAIM_JURISDICTION_APPROVAL:
                requestType=RequestTypeEnum.BACK_REQUEST.getValue();
                requestTypeEnum=RequestTypeEnum.BACK_REQUEST;
                approveType= COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName();
                docTypeName=CaseDocTypeEnum.BACK_REQUSTE_JUDIS_DIS_DECISION_BOOK.getCode();
                break;
        }


        //判断该案件是否有有效的仲裁秘书
        CaseManagerExample caseManagerExample = new CaseManagerExample();
        caseManagerExample.createCriteria().andCaseIdEqualTo(caseApprove.getCaseId()).andManagerTypeEqualTo(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode()).andStatusEqualTo(CaseManagerStatusEnum.OK.getCode());
        List<CaseManager> caseManagerList = caseManagerMapper.selectByExample(caseManagerExample);

        if(caseManagerList.size()<=0){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CASE_NOT_OK_SERETARY);
        }


		//根据案件id和请求类型查询出管辖权异议基本对象
        ArbiCaseJurisDisVO arbiCaseJurisDisVO = caseJurisDisMapper.selectCaseJurisDisByCaseIdAndRequestType(caseApprove.getCaseId(), requestType);

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
            arbiCaseJurisDisVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
        }else{
        	arbiCaseJurisDisVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
		}

		//当前用户是秘书，判断是否回避过
		if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.equals(duties)){
        	List<String> statusList=new ArrayList<String>();
        	statusList.add(CaseAvoidStatusEnum.WAIT_AUDIT.getValue());
        	statusList.add(CaseAvoidStatusEnum.SUCCESS_AUDIT.getValue());
			//判断秘书是否申请过回避
			CaseAvoidRecordExample caseAvoidRecordExample = new CaseAvoidRecordExample();
			caseAvoidRecordExample.createCriteria().andCaseIdEqualTo(caseApprove.getCaseId()).andAvoidIdEqualTo(userId).andStatusIn(statusList);
			List<CaseAvoidRecord> caseAvoidRecordList = caseAvoidRecordMapper.selectByExample(caseAvoidRecordExample);
			if(caseAvoidRecordList.size()>0){
				arbiCaseJurisDisVO.setIsApplyAvoid(IsApplyAvoidEnum.IS_APPLY_AVOID.getCode());
			}else{
				arbiCaseJurisDisVO.setIsApplyAvoid(IsApplyAvoidEnum.NOT_IS_APPLY_AVOID.getCode());
			}
		}

        //查询出当前审批人的职务
        String approveDuties = caseInfoMapper.queryDutiesById(caseApprove.getApproveUserId());

		//设置职务
        arbiCaseJurisDisVO.setDuties(duties);

        //当前审批人的职务
        arbiCaseJurisDisVO.setApproveDuties(approveDuties);

		//设置请求类型
		arbiCaseJurisDisVO.setRequestType(requestType);
		//设置当前审批状态
        arbiCaseJurisDisVO.setCaseApproveStatus(caseApprove.getApproveStatus());

        //设置当前审批是组庭前还是组庭后提出的
        arbiCaseJurisDisVO.setTribunalMark(caseApprove.getTribunalMark());

        //设置请求id
        arbiCaseJurisDisVO.setRequestId(caseApprove.getRequestId());

        //得出秘书姓名
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(caseManagerList.get(0).getManagerId());
        arbiCaseJurisDisVO.setSecretaryName(userInfo.getName());

        //判断当前审批是组庭前还是组庭后提出的，假如是组庭前，则查出仲裁员的名字以及组庭通知书发放的时间
        if(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(caseApprove.getTribunalMark())){
            CaseArbitratorTribunalVO caseArbitratorTribunalVO = caseArbitratorMapper.selectArbitratorNameAndCreateTime(caseApprove.getCaseId());
            if(caseArbitratorTribunalVO==null){
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
            }

            arbiCaseJurisDisVO.setArbitratorName(caseArbitratorTribunalVO.getArbitratorName());
            arbiCaseJurisDisVO.setTribunalNoticeCreateTime(caseArbitratorTribunalVO.getTribunalNoticeCreateTime());
        }

        //判断是否有变更仲裁请求
        CaseChangeRecordExample caseChangeRecordExample = new CaseChangeRecordExample();
        caseChangeRecordExample.createCriteria().andCaseIdEqualTo(caseApprove.getCaseId()).andCounterclaimFlagEqualTo(requestType);
        caseChangeRecordExample.setOrderByClause("CREATE_TIME DESC");
        List<CaseChangeRecordWithBLOBs> caseChangeRecordWithBLOBList = caseChangeRecordMapper.selectByExampleWithBLOBs(caseChangeRecordExample);
        if(caseChangeRecordWithBLOBList.size()>0){
            arbiCaseJurisDisVO.setCaseChangeRequest(caseChangeRecordWithBLOBList.get(0).getChangeRequest());
            arbiCaseJurisDisVO.setCaseChangeTime(caseChangeRecordWithBLOBList.get(0).getCreateTime());
        }

        //查询出文书头部
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseApprove.getCaseId(), requestTypeEnum);


        //查询出审批记录
        List<ApproveRecordVO> approveRecordVOList = caseApproveMapper.queryApproveRecordCaseId(caseApprove.getCaseId(),approveType,CaseApproveStatusEnum.WAIT_AUDIT.getValue(),requestType);

        // 根据案件id查询出涉案金额等金额
        CaseRequestInfoVO caseRequestInfoVO = caseRequestInfoMapper.queryAmountByCaseId(caseApprove.getCaseId(), requestType);

        DocumentContentVO documentContentVO = caseDocMapper.selectCaseJurisDisByCaseIdAndDocType(caseApprove.getCaseId(), docTypeName);

        //创建管辖权对象，设置并返回
        ArbitrationCaseJurisDisVO arbitrationCaseJurisDisVO = new ArbitrationCaseJurisDisVO();
        arbitrationCaseJurisDisVO.setCaseDocHead(caseDocHead);
        arbitrationCaseJurisDisVO.setApproveRecordVOList(approveRecordVOList);
        arbitrationCaseJurisDisVO.setCaseRequestInfoVO(caseRequestInfoVO);

        arbitrationCaseJurisDisVO.setArbiCaseJurisDisVO(arbiCaseJurisDisVO);

        arbitrationCaseJurisDisVO.setDocumentContentVO(documentContentVO);

        arbitrationCaseJurisDisVO.setAuthorizationDelegateVO(authorizationDelegateVO);

		return BusiExecuteResult.builderSuccessResult(arbitrationCaseJurisDisVO);
    }

	/**
	 * 查询并返回仲裁委管辖权异议业务验证
	 * @param jurisApproveId
	 * @param userId
	 * @return
	 */
	@Override
    public BusiValidResult queryCaseJurisDisByCaseIdBusiValid(String jurisApproveId,String userId) {

	    //查询出该审批是否存在
        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(jurisApproveId);
        if(caseApprove==null){
            return BusiValidResult.builderErrorResult(Coder.NOT_FOUND);
        }

        //查询出改管辖权异议记录是否存在
        CaseJurisDisWithBLOBs caseJurisDisWithBLOBs = caseJurisDisMapper.selectByPrimaryKey(caseApprove.getBusiId());
        if(caseJurisDisWithBLOBs==null){
            return BusiValidResult.builderErrorResult(Coder.NOT_FOUND);
        }


        CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria().andIdEqualTo(caseApprove.getCaseId());
        //根据案件id查询该案件存不存在
        int i = caseInfoMapper.countByExample(caseInfoExample);
        if(i<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }


        String duties=caseInfoMapper.queryDutiesById(userId);
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
     * 保存仲裁协议效力决定书业务验证
     */
    @Override
	public BusiValidResult saveDocAndDocContentBusiValidResult(
			SaveCaseDocDTO formData) {
    	CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria().andIdEqualTo(formData.getCaseId());
        //根据案件id查询该案件存不存在
        int i = caseInfoMapper.countByExample(caseInfoExample);
        if(i<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }


        RequestTypeEnum requestTypeEnum = RequestTypeEnum.getValue(formData.getRequestType());
        //判断当前审批是本请求的管辖权异议还是反请求的管辖权异议
        String approveType=null;
        switch(requestTypeEnum){
            case REQUEST:
                approveType=ApproveTypeEnum.JURISDICTION_OBJECTION_APPROVAL.getTypeName();
                break;
            case BACK_REQUEST:
                approveType= COUNTERCLAIM_JURISDICTION_APPROVAL.getTypeName();
                break;
        }

        CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());
        String duties=caseInfoMapper.queryDutiesById(formData.getUserId());
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
     * 保存仲裁协议效力决定书业务处理
     */
	@Override
	public BusiExecuteResult saveDocAndDocContentBusiExecuteResult(
			SaveCaseDocDTO formData) {

	    //查询出当前审批
        CaseApprove approve = caseApproveMapper.selectByPrimaryKey(formData.getApproveId());


        //获取当前用户职务
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());

		//当前操作人是仲裁秘书
		if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(duties)){
				//判断是否有文书
			if(StringUtil.isEmpty(formData.getDocId())&&StringUtil.isEmpty(formData.getDocContentId())){

				//没有文书，就新增文书
                boolean b = this.saveDocAndDocContent(formData);
                if(!b){
					return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
				}

			}else{
				//有文书，判断文书的出具类型是否和再次提交的文书类型是否一致
				CaseDocContentWithBLOBs caseDocContent = caseDocContentMapper.selectByPrimaryKey(formData.getDocContentId());

				//判断文书出具类型是否一致
				if(caseDocContent.getIssueType()==Integer.parseInt(formData.getIssueType())){
                    boolean b = this.updateDocAndDocContent(formData);
                    if(!b){
						return BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
					}

				}else{
					//文书出具类型不一致，将该文书修改为废弃状态
					CaseDoc record = new CaseDoc();
					record.setId(formData.getDocId());
					record.setStatus(CaseDocStatusEnum.DISUSE.getCode());
					int lows = caseDocMapper.updateByPrimaryKeySelective(record);
					if(lows<=0){
						return BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
					}

					//重新插入文书对象
                    boolean f = this.saveDocAndDocContent(formData);
					if(!f){
						return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
					}
				}
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

            //当前操作人是仲裁部长
		}else if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)){



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

            //查询副主任的userId
            String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),
                    ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
            //将查询出的副主任添加到审批表
            int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
            if (updateApproverId <= 0) {
                return BusiExecuteResult
                        .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
            }


            //当前操作人是副主任
		}else if(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){


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


            //查询主任的userId
            String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),
                    ManagerInfoTypeEnum.DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
            //将查询出的主任添加到审批表
            int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
            if (updateApproverId <= 0) {
                return BusiExecuteResult
                        .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
            }
            //当前操作人是主任
		}else if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)){

            CaseApprove caseApprove = new CaseApprove();

            caseApprove.setId(formData.getApproveId());
            CaseJurisDis record = new CaseJurisDis();
            record.setId(formData.getCaseJurisDisId());

            //操作是驳回
            if ((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())) {


                //未组庭
                if(TribunalMarkEnum.NOT_TRIBUNAL.getCode().equals(approve.getTribunalMark())){

                    //查询仲裁秘书的userId
                    String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),
                            ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
                    //将查询出的秘书部长添加到审批表
                    int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
                    if (updateApproverId <= 0) {
                        return BusiExecuteResult
                                .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
                    }

                }

                //组庭成功
                if(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(approve.getTribunalMark())){
                    CaseArbitratorExample example = new CaseArbitratorExample();
                    example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
                    List<CaseArbitrator> caseArbitratorList = caseArbitratorMapper.selectByExample(example);
                    if(caseArbitratorList.size()<=0){
                        return BusiExecuteResult
                                .builderErrorResult(ApiResultVO.Coder.ARBITRATOR_NOT_EXIST);
                    }

                    //将查询出的仲裁员添加到审批表
                    int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), caseArbitratorList.get(0).getArbitratorId());

                    if (updateApproverId <= 0) {
                        return BusiExecuteResult
                                .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
                    }
                }

                record.setStatus(CaseChangeStatusEnum.FAIL_AUDIT.getValue());
                // 审批表状态，修改为未通过
                caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());


            }

            // 操作类型为通过
            if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(formData.getOpinionStatus())) {

                // 审批表状态，修改为通过
                caseApprove.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());

                //出具类型是同意模板
                if (CaseDocIssueTypeEnum.AGREE.getCode().equals(formData.getIssueType())) {
                    CaseCancelDTO caseCancelDTO = new CaseCancelDTO();
                    caseCancelDTO.setCaseId(formData.getCaseId());
                    caseCancelDTO.setRequestType(formData.getRequestType());
                    caseCancelDTO.setUserId(formData.getUserId());
                    microFlowService.cancelCase(formData.getCaseId(),caseCancelDTO);
                    record.setStatus(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue());
                }

                //出具类型是不同意模板
                if (CaseDocIssueTypeEnum.NOT_AGREE.getCode().equals(formData.getIssueType())) {
                    record.setStatus(CaseChangeStatusEnum.FAIL_AUDIT.getValue());
                }

            }
            //修改变更仲裁记录表的状态
            int low = caseJurisDisMapper.updateByPrimaryKey(record);

            // 数据更新到审批表
            int updateStatus = caseApproveMapper.updateApproveStatus(caseApprove);
            if (updateStatus <= 0 && low <=0) {
                return BusiExecuteResult
                        .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
            }

            DocSendRecord docSendRecord = new DocSendRecord();
            docSendRecord.setDocId(formData.getDocId());
            docSendRecord.setCaseId(formData.getCaseId());

            docSendRecord.setSendType(DocSendRecordTypeEnum.SHORT_MESSAGE.getCode());
            docSendRecord.setStatus(Integer.parseInt(DocSendRecordStatusEnum.NORMAL.getCode()));
            docSendRecord.setCreaterId(formData.getUserId());
            docSendRecord.setCreateTime(new Date());



            LitigantInfoVO litigantInfoVO = caseInfoMapper.selectLitigantInfoByCaseId(formData.getCaseId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("phone",litigantInfoVO.getPropPhone());
            jsonObject.put("caseNo",formData.getCaseNo());

            docSendRecord.setReceiverId(litigantInfoVO.getPropUserId());
            docSendRecord.setReceiverType(DocSendReceiverType.APPLICANT.getCode());
            docSendRecordMapper.insert(docSendRecord);

            microMessageService.sendSms(litigantInfoVO.getPropPhone(),"1005",jsonObject.toJSONString(),litigantInfoVO.getPropUserId(),formData.getCaseJurisDisId());
            jsonObject.put("phone",litigantInfoVO.getDefePhone());

            docSendRecord.setReceiverId(litigantInfoVO.getDefeUserId());
            docSendRecord.setReceiverType(DocSendReceiverType.RESPONDENT.getCode());
            docSendRecordMapper.insert(docSendRecord);

            microMessageService.sendSms(litigantInfoVO.getDefePhone(),"1005",jsonObject.toJSONString(),litigantInfoVO.getDefeUserId(),formData.getCaseJurisDisId());

            if(litigantInfoVO.getPropAgentName()!=null){
                jsonObject.put("phone",litigantInfoVO.getPropAgentPhone());

                docSendRecord.setReceiverId(litigantInfoVO.getPropAgentUserId());
                docSendRecord.setReceiverType(DocSendReceiverType.APPLICANT_AGNET.getCode());
                docSendRecordMapper.insert(docSendRecord);

                microMessageService.sendSms(litigantInfoVO.getPropAgentPhone(),"1005",jsonObject.toJSONString(),litigantInfoVO.getPropAgentUserId(),formData.getCaseJurisDisId());
            }

            if(litigantInfoVO.getDefeAgentName()!=null){
                jsonObject.put("phone",litigantInfoVO.getDefePhone());

                docSendRecord.setReceiverId(litigantInfoVO.getDefeAgentUserId());
                docSendRecord.setReceiverType(DocSendReceiverType.RESPONDENT_AGENT.getCode());
                docSendRecordMapper.insert(docSendRecord);

                microMessageService.sendSms(litigantInfoVO.getDefePhone(),"1005",jsonObject.toJSONString(),litigantInfoVO.getDefeAgentUserId(),formData.getCaseJurisDisId());
            }



            //组庭成功
            if(TribunalMarkEnum.ALREADY_TRIBUNAL.getCode().equals(approve.getTribunalMark())){
                CaseArbitratorExample example = new CaseArbitratorExample();
                example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
                List<CaseArbitrator> caseArbitratorList = caseArbitratorMapper.selectByExample(example);

                if(caseArbitratorList.size()<=0){
                    return BusiExecuteResult
                            .builderErrorResult(ApiResultVO.Coder.ARBITRATOR_NOT_EXIST);
                }

                docSendRecord.setReceiverId(caseArbitratorList.get(0).getArbitratorId());
                docSendRecord.setReceiverType(DocSendReceiverType.ARBITRATOR.getCode());
                docSendRecordMapper.insert(docSendRecord);
            }
        }

        formData.setDuties(duties);
        //查询出授权情况
        AuthorizationDelegateVO authorizationDelegateVO = caseManagerService.queryAuthorizationDelegateDuties(formData.getCaseId(), formData.getUserId(), approve.getApproveType());

		//判断是否授权
		if(StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationType())&&StringUtil.isEmpty(authorizationDelegateVO.getAuthorizationDuties())){
          formData.setIsAuthorized(ApproveIsAuthorizedEnum.NOT_AUTHORIZED.getCode());
        }

        //判断是否是被授权方
        if(AuthorizationTypeEnum.BE_AUTHORIZATION_PARTY.getCode().equals(authorizationDelegateVO.getAuthorizationType())){
            formData.setIsAuthorized(ApproveIsAuthorizedEnum.AUTHORIZED.getCode());
            //是被授权方，判断当前是用自己的职务操作案件还是用被授予的权限操作按键
            if(approve.getApproveUserId().equals(authorizationDelegateVO.getAuthorizationUserId())){
                formData.setDuties(authorizationDelegateVO.getAuthorizationDuties());
            }
        }



        //插入意见
        boolean flag = this.saveCaseApproveSuggest(formData);

        if(!flag){
            return BusiExecuteResult
                    .builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
        }
		return BusiExecuteResult.builderSuccessResult();
	}

	
    /********************私有service************************/

    /**
     * 保存仲裁协议效力决定书
     * @param formData
     * @return
     */
    private boolean saveDocAndDocContent(SaveCaseDocDTO formData){
    	//文书id
    	String caseDocId=sequenceService.getCommonID();

        String year = DateUtil.getDate("yyyy");

        //文书年编号
    	String docYearNumber=String.valueOf(year);
    	//todo 文书序列号
    	String docSerialNumber=sequenceService.getCommonID();
    	
    	//新增文书
    	CaseDoc caseDoc = new CaseDoc();
    	caseDoc.setId(caseDocId);
    	caseDoc.setDocName(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getDocName());
    	caseDoc.setDocType(CaseDocTypeEnum.REQUSTE_JUDIS_DIS_DECISION_BOOK.getCode());
    	caseDoc.setCaseId(formData.getCaseId());
    	caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
    	caseDoc.setDocYearNumber(docYearNumber);
    	caseDoc.setDocSerialNumber(docSerialNumber);
    	caseDoc.setRequestId(formData.getRequestId());
    	int docLow = caseDocMapper.insertSelective(caseDoc);
    	
    	//新增文书内容
		CaseDocContentWithBLOBs caseDocContentWithBLOBs = new CaseDocContentWithBLOBs();
		caseDocContentWithBLOBs.setId(sequenceService.getCommonID());
		caseDocContentWithBLOBs.setCaseId(formData.getCaseId());
		caseDocContentWithBLOBs.setRequestId(formData.getRequestId());
		caseDocContentWithBLOBs.setBodyText(formData.getBodyText());
		caseDocContentWithBLOBs.setOpinion(formData.getOpinion());
		caseDocContentWithBLOBs.setIssueType(Integer.parseInt(formData.getIssueType()));
		caseDocContentWithBLOBs.setIssueId(formData.getUserId());
		caseDocContentWithBLOBs.setCreateTime(new Date());
		caseDocContentWithBLOBs.setDocId(caseDocId);
		caseDocContentWithBLOBs.setSecretaryId(formData.getUserId());
		caseDocContentWithBLOBs.setSaveADraft(CaseDocContentSaveDraftEnum.NO_SAVE_AS_DRAFT.getCode());
		int docContentLow= caseDocContentMapper.insertSelective(caseDocContentWithBLOBs);
		if(docLow>0&&docContentLow>0){
			return true;
		}
		return false;
    }
    
    /**
     * 仲裁协议效力决定书
     * @param formData
     * @return
     */
    private boolean updateDocAndDocContent(SaveCaseDocDTO formData){
    	//修改文书内容
		CaseDocContentWithBLOBs caseDocContentWithBLOBs = new CaseDocContentWithBLOBs();
		caseDocContentWithBLOBs.setBodyText(formData.getBodyText());
		caseDocContentWithBLOBs.setOpinion(formData.getOpinion());
		caseDocContentWithBLOBs.setIssueType(Integer.parseInt(formData.getIssueType()));
		caseDocContentWithBLOBs.setId(formData.getDocContentId());
		int docContentLow= caseDocContentMapper.updateByPrimaryKeySelective(caseDocContentWithBLOBs);
		if(docContentLow>0){
			return true;
		}
    	return false;
    }
    
    
    /**
	 * 插入审批意见
	 * @param formData
	 * @return
	 */
	private boolean saveCaseApproveSuggest(SaveCaseDocDTO formData){
		
		// 生成审批意见id
		String approveSuggestId = sequenceService.getCommonID();
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();
		
		//获取当前责任人的id
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());
		
		//判断当前操作人是主任
		if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)){
			caseApproveSuggest.setOpinionStatus(formData.getOpinionStatus());
		}
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setCreaterId(formData.getUserId());
		caseApproveSuggest.setId(approveSuggestId);
		caseApproveSuggest.setCreateTime(new Date());
		caseApproveSuggest.setIsAuthorized(formData.getIsAuthorized());
		int low = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if(low>0){
			return true;
		}
		return false;
	}
}
