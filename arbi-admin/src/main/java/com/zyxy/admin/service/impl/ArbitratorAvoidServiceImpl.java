package com.zyxy.admin.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;

import com.zyxy.common.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.ArbitratorAvoidService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.dto.CaseManagerDTO;
import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseArbitratorService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO.Coder;

/**
 * 仲裁员回避审核ServiceImpl
 *
 */
@Service
public class ArbitratorAvoidServiceImpl implements ArbitratorAvoidService{
	@Autowired
	private CaseAvoidRecordMapper caseAvoidRecordMapper;
	
	@Autowired
	private CaseDocMapper caseDocMapper;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	
	@Autowired
	private CaseApproveMapper caseApperoveMapper;
	
	@Autowired
	private WhetherDistributionService whetherDistributionService;
	
	@Autowired
	private CaseManagerMapper  caseManagerMapper;
	
	@Autowired
    private CaseDocContentMapper caseDocContentMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseArbitratorService caseArbitratorService;
	
	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;

	@Autowired
	private CaseArbitratorMapper caseArbitratorMapper;

	@Autowired
    private UserInfoMapper userInfoMapper;

	@Autowired
    private CaseManagerService caseManagerService;
	
	/**
	 * 审核立案申请业务验证 判断案件是否存在，是否在不在审核通过状态，是否轮到当前仲裁委人员审核
	 * 
	 * @param caseId
	 * @param userId
	 * @return
	 */
	@Override
	public BusiValidResult auditBusiValid(String caseId, String userId,
			String approveId) {
		// 查询审批表的当前责任人
		String approveUserId = caseApproveMapper.selectApproverUserInfoId(approveId);

		//查询出当前用户的职务
		String duties = caseInfoMapper.queryDutiesById(userId);

		if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){

			//查询出该案件是否是属于该仲裁委
			CaseManagerDTO caseManagerDTO=new CaseManagerDTO();
			caseManagerDTO.setId(userId);
			caseManagerDTO.setCaseId(caseId);
			caseManagerDTO.setStatus(CaseManagerStatusEnum.OK.getCode());
			List<CaseManager> caseManagerList = caseManagerMapper.queryCaseNowManager(caseManagerDTO);
			if(caseManagerList.size()<=0){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}

		}else{
			if(!userId.equals(approveUserId)){
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}

		}
		return BusiValidResult.builderSuccessResult();
	}
	
	
	/**
	 * 仲裁员回避申请业务处理
	 * @param approveId 审批Id
	 * @param userId 当前用户Id
	 * @return 仲裁员回避审核信息对象
	 */
	@Override
	public AvoidListVO arbitratorAvoidBusiExecute(String approveId,String userId) {
		return this.avoidAudit(approveId,userId);

	}
	
	/**审核仲裁员回避
	 * @param formData 仲裁员回避DTO
	 * @return 审核结果
	 */
	@Override
	public BusiExecuteResult auditArbitratorBusiExecute(SaveCaseDocDTO formData) {

		return this.auditArbitrator(formData);
	}
	
	
	/**
	 * 秘书回避申请业务处理
	 * @param approveId 案件Id
	 * @param userId 当前用户Id
	 * @return 秘书回避审核信息对象
	 */
	@Override
	public AvoidListVO secretariesAvoidBusiExecute(String approveId,String userId) {
		return this.avoidAudit(approveId,userId);
	}
	
	
	/**审核秘书回避
	 * @param formData 仲裁员回避DTO
	 * @return 审核结果
	 */
	@Override
	public BusiExecuteResult auditSecretariesBusiExecute(SaveCaseDocDTO formData) {

		return this.auditSecretaries(formData);
	}

	
	//###########################私有方法###############################
	
	/**
	 * 返回回避审核信息对象
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return 回避审核信息对象
	 */
	private AvoidListVO avoidAudit(String approveId,String userId) {
		
		// 获取当前审批表审批id和审批人和业务Id身份
		ApproveRecordVO queryApprove = caseApproveMapper.queryApproveDuties(approveId);
		
		/**
		 * 创建回避返回对象
		 */
		AvoidListVO avoidListVO = new AvoidListVO();

		if(queryApprove!= null){
		    //查询出仲裁员是指派还是双方选定
            CaseArbitratorExample example = new CaseArbitratorExample();
            example.createCriteria().andCaseIdEqualTo(queryApprove.getCaseId()).andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
            List<CaseArbitrator> caseArbitratorList = caseArbitratorMapper.selectByExample(example);

            if(caseArbitratorList.size()>0){
                avoidListVO.setCaseArbiType(caseArbitratorList.get(0).getType());
            }

            //查询出仲裁秘书分配时间
            CaseManagerExample caseManagerExample = new CaseManagerExample();
            caseManagerExample.createCriteria().andCaseIdEqualTo(queryApprove.getCaseId()).andStatusEqualTo(CaseManagerStatusEnum.OK.getCode()).andManagerTypeEqualTo(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
            List<CaseManager> caseManagerList = caseManagerMapper.selectByExample(caseManagerExample);

            if(caseManagerList.size()>0){
                avoidListVO.setCaseManagerTime(caseManagerList.get(0).getCreateTime());
            }

            //获取业务Id,审批人身份
			String busiId = queryApprove.getBusiId();
			String duties = queryApprove.getDuties();
			
			// 回避申请书对象
			AvoidVO avoidVO = caseAvoidRecordMapper.queryAvoid(busiId);
			
			// 根据业务员Id查询出回避决定书案件文书对象
			DocumentContentVO documentContentVO = caseDocMapper.queryCaseDocByBusiId(busiId,CaseDocTypeEnum.ARBITRATOR_AVOID_DECISION.getCode());
			
			// 根据审批Id查询审批记录
			List<ApproveRecordVO> approveRecordList = caseApproveMapper.queryApproveRecordApproveId(approveId);

			// 获取当前案件id及审批id和审批表审批人身份，添加到仲裁员回避审核对象
			avoidListVO.setCaseId(queryApprove.getCaseId());
			avoidListVO.setApproveId(approveId);
			avoidListVO.setApproveDuties(duties);
			
            //得出该仲裁员的组庭时间
            Date triBunalTime = caseDocMapper.selectTimeByUserId(avoidVO.getAvoidId());

            avoidVO.setTriBunalTime(triBunalTime);

            CaseApprove caseApprove = caseApproveMapper.selectByPrimaryKey(approveId);

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
                avoidListVO.setPrimiss(CaseOperationPrimissEnum.HAVE_PRIMISS.getCode());
			}else{
                avoidListVO.setPrimiss(CaseOperationPrimissEnum.NOT_PRIMISS.getCode());
			}

			avoidListVO.setAuthorizationDelegateVO(authorizationDelegateVO);
           
			// 获取当前登录的审批人身份，添加到立案审核对象
			String userDuties = managerInfoMapper.queryDutiesByUserId(userId);
			avoidListVO.setDuties(userDuties);
			avoidListVO.setAvoidVO(avoidVO);
			avoidListVO.setApproveRecordList(approveRecordList);
			avoidListVO.setContentVO(documentContentVO);
		}


		return avoidListVO;

	}
	
	

	/**
	 * 审核仲裁员回避申请
	 * 
	 * @param formData
	 *            仲裁员回避审核DTO
	 * @return 审核结果
	 */
	private BusiExecuteResult auditArbitrator(SaveCaseDocDTO formData) {

		// 判断当前用户身份
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());
		
		//插入意见
		boolean isInsert = this.saveCaseApproveSuggest(formData);
		
		if(!isInsert){
    		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
    	}
		
		//当前操作人是仲裁秘书
		if (ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(duties)) {
			
			//判断是否有仲裁员回避决定书
	    	if(StringUtil.isEmpty(formData.getDocId())&&StringUtil.isEmpty(formData.getDocContentId())){
	    		
	    		//没有决定书，就新增决定书
	    		boolean flag = this.saveADraftOnDocAndDocContent(formData,CaseDocTypeEnum.ARBITRATOR_AVOID_DECISION.getDocName(),CaseDocTypeEnum.ARBITRATOR_AVOID_DECISION.getCode());
	        	if(!flag){
	        		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	        	}
	    		
	    	}else{
	    		//有文书，判断文书的出具类型是否和再次提交的文书类型是否一致
	    		CaseDocContentWithBLOBs caseDocContent = caseDocContentMapper.selectByPrimaryKey(formData.getDocContentId());
	    		
	    		//判断文书出具类型是否一致
	    		if(caseDocContent.getIssueType()==Integer.parseInt(formData.getIssueType())){
	    			
	    			//一致则修改文书
	    			boolean flag = this.updateADraftOnDocAndDocContent(formData);
	    			
	        		if(!flag){
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
	    			boolean flag = this.saveADraftOnDocAndDocContent(formData,CaseDocTypeEnum.ARBITRATOR_AVOID_DECISION.getDocName(),CaseDocTypeEnum.ARBITRATOR_AVOID_DECISION.getCode());
	            	if(!flag){
	            		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	            	}
	    		}
	    	}
	    	
    		// 判断当前案件是否有仲裁部长
			boolean isMinister = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
    		
    		if(!isMinister){
    			
				// 分配仲裁部长
				int isMinisterLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				if (isMinisterLow <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			//查询仲裁部长的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(), CaseManagerStatusEnum.OK.getCode());
			
			//将查询出的仲裁部长添加到审批表
			int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
			if (updateApproverId <= 0) {
				return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
		//当前操作人是仲裁部长或者副主任
		}else if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){
			
			//操作是驳回
			if ((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())) {
				CaseApprove caseApproveOb = new CaseApprove();
				caseApproveOb.setId(formData.getApproveId());
				
				// 审批表状态，修改为未通过
				caseApproveOb.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				
				//查询出当前审批秘书userId
				String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
				
				//将仲裁秘书更新到审批表
				caseApperoveMapper.updateApproverId(formData.getApproveId(), userId);
				
				// 审批状态更新到审批表
				int updateStatus = caseApproveMapper.updateApproveSecretariesStatus(caseApproveOb);
				
				if(updateStatus<=0){
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
			}
			
			// 操作类型为通过
			if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(formData.getOpinionStatus())) {

				if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)){
					
					// 判断当前案件是否有副主任
					boolean isDeputyDirector = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());

					if (!isDeputyDirector) {// 没有副主任，需要分配副主任
						// 分配副主任
						int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
						if (isDistributionLow <= 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
						}

					}
						
					//查询副主任的userId
					String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
					
					//将查询出的副主任添加到审批表
					int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
					if (updateApproverId <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}
					
				}else if(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){
					
					// 判断当前案件是否有主任
					boolean isDirector = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
					if(!isDirector){
						
						// 分配主任
						int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
						
						if (isDistributionLow <= 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
						}
					}
					
					
					//查询主任的userId
					String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
					
					//将查询出的主任添加到审批表
					int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
					if (updateApproverId <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}
					
				}
					
			}
				
		}else if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)){//当前操作人是主任
				
				CaseApprove caseApproveOb = new CaseApprove();
				caseApproveOb.setId(formData.getApproveId());
				
				//操作是驳回
				if ((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())) {
					
					// 审批表状态，修改为未通过
					caseApproveOb.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					
					//查询出当前审批秘书userId
					String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
					
					//将仲裁秘书更新到审批表
					caseApperoveMapper.updateApproverId(formData.getApproveId(), userId);
					
					
				}
				
				// 操作类型为通过
				if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(formData.getOpinionStatus())) {
					// 审批表状态，修改为通过
					caseApproveOb.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
					
					// 判断通过的模板类型
					if(formData.getIssueType().equals(String.valueOf(CaseDocContentIssueTypeEnum.AGREE_MODULE.getCode()))){  //同意模板
						//分配新的仲裁员 
						String allotArbitrator = caseArbitratorService.allotArbitrator(formData.getCaseId());
						if(allotArbitrator==null){
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
						}
					}
					
					// 判断不通过的模板类型
					if(formData.getIssueType().equals(String.valueOf(CaseDocContentIssueTypeEnum.DISAGREE_MODULE.getCode()))){  //不 同意模板
						
					//将回避表状态修改为未通过
						int status = caseAvoidRecordMapper.updateArbitratorStatus(formData.getCaseJurisDisId(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
						if(status <= 0){
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);	
						}
					}
				}
				
				// 审批状态更新到审批表
				int updateStatus = caseApproveMapper.updateApproveSecretariesStatus(caseApproveOb);
				if (updateStatus <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//tudo 生成通知书
			}
		
		return BusiExecuteResult.builderSuccessResult();
	}
	
	
	
	/**
	 * 审核秘书回避申请
	 * 
	 * @param formData
	 *            仲裁员回避审核DTO
	 * @return 审核结果
	 */
	private BusiExecuteResult auditSecretaries(SaveCaseDocDTO formData) {

		// 判断当前用户身份
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());
		
		//插入意见
		boolean isInsert = this.saveCaseApproveSuggest(formData);
		
		if(!isInsert){
    		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
    	}
		
		//当前操作人是仲裁部长
		if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)) {
			
			//判断是否有秘书回避决定书
	    	if(StringUtil.isEmpty(formData.getDocId())&&StringUtil.isEmpty(formData.getDocContentId())){
	    		
	    		//没有决定书，就新增决定书
	    		boolean flag = this.saveADraftOnDocAndDocContent(formData,CaseDocTypeEnum.SECRETARIES_AVOID_DECISION_BOOK.getDocName(),CaseDocTypeEnum.SECRETARIES_AVOID_DECISION_BOOK.getCode());
	        	if(!flag){
	        		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	        	}
	    		
	    	}else{
	    		//有文书，判断文书的出具类型是否和再次提交的文书类型是否一致
	    		CaseDocContentWithBLOBs caseDocContent = caseDocContentMapper.selectByPrimaryKey(formData.getDocContentId());
	    		
	    		//判断文书出具类型是否一致
	    		if(caseDocContent.getIssueType()==Integer.parseInt(formData.getIssueType())){
	    			
	    			//一致则修改文书
	    			boolean flag = this.updateADraftOnDocAndDocContent(formData);
	        		if(!flag){
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
					boolean flag = this.saveADraftOnDocAndDocContent(formData,
							CaseDocTypeEnum.SECRETARIES_AVOID_DECISION_BOOK.getDocName(),
							CaseDocTypeEnum.SECRETARIES_AVOID_DECISION_BOOK.getCode());
	            	if(!flag){
	            		return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	            	}
	    		}
	    	}

				// 判断当前案件是否有副主任
				boolean isDeputyDirector = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());

				if (!isDeputyDirector) {// 没有副主任，需要分配副主任
					// 分配副主任
					int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					
					if (isDistributionLow <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}

				}
				
				// 判断当前案件是否有主任
				boolean isDirector = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
				
				if(!isDirector){
					// 分配主任
					int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
					
					if (isDistributionLow <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
					}
				}
				
				//查询副主任的userId
				String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
				
				//将查询出的副主任添加到审批表
				int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
				if (updateApproverId <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
			
		}else if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)||ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){//当前操作人是主任或者副主任
				
				CaseApprove caseApproveOb = new CaseApprove();
				caseApproveOb.setId(formData.getApproveId()); //通过审批Id修改审批表
				
				//操作是驳回
				if ((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())) {
					
					// 审批表状态，修改为未通过
					caseApproveOb.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
					
					//查询出当前审批部长userId
					String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(), CaseManagerStatusEnum.OK.getCode());
					
					//将仲裁部长更新到审批表
					caseApperoveMapper.updateApproverId(formData.getApproveId(), userId);
					
					// 审批状态更新到审批表
					int updateStatus = caseApproveMapper.updateApproveSecretariesStatus(caseApproveOb);
					if (updateStatus <= 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}
					
					
				}
				
				// 操作类型为通过
				if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(formData.getOpinionStatus())) {
					
					//操作人为主任
					if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)){
						
						// 审批表状态，修改为通过
						caseApproveOb.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
						
						// 判断通过的模板类型
						if(formData.getIssueType().equals(String.valueOf(CaseDocContentIssueTypeEnum.AGREE_MODULE.getCode()))){  //同意模板枚举类，还未上传 tudo 同意模板
							
							//将原来的案件仲裁委关系的原秘书状态修改为回避
							int update = caseManagerMapper.updateSecretariesStatus(formData.getCaseId(), formData.getCaseJurisDisId(),CaseManagerStatusEnum.AVOID.getCode());
							if(update<=0){
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
							}
							//分配新的秘书到案件仲裁委关系中
							//案件仲裁委关系Id
							//String id=sequenceService.getCommonID(); 暂时Id数据库是自增
							//分配新的仲裁仲裁秘书
							String managerId = caseManagerMapper.queryAllotSecretaries(formData.getCaseId());
							CaseManager caseManager =new CaseManager();
							caseManager.setCaseId(formData.getCaseId());
							caseManager.setCreateTime(new Date());
							//caseManager.setId(id);
							caseManager.setManagerType(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
							caseManager.setStatus(CaseManagerStatusEnum.OK.getCode());
							//caseManager.setCreateId(formData.getUserId());
							caseManager.setManagerId(managerId);
							int insert= caseManagerMapper.insertSelective(caseManager);
							if(insert<=0){
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
							}
							
							
							//将同一个案件所有的秘书回避待审核状态，回避表状态修改为通过
							int status = caseAvoidRecordMapper.updateArbitratorStatus(formData.getCaseId(), CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
							
							// 秘书回避通过，将审批表里，同一个案件的，秘书回避的审批待审核的，都修改为通过
							int updateStatus = caseApproveMapper.updateCaseIdStatus(formData.getCaseId(), ApproveTypeEnum.APPLY_SIDESTEP_APPROVAL.getTypeName(), CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
							if (updateStatus <= 0) {
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
							}
							if (status <= 0) {
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
							}
							
						}else if(formData.getIssueType().equals(String.valueOf(CaseDocContentIssueTypeEnum.DISAGREE_MODULE.getCode()))){  //不同意模板枚举类
							//将回避表状态修改为未通过
							int status = caseAvoidRecordMapper.updateArbitratorStatus(formData.getCaseJurisDisId(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());
							
							// 审批状态更新到审批表
							int updateStatus = caseApproveMapper.updateApproveSecretariesStatus(caseApproveOb);
							if (updateStatus <= 0) {
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
							}
							if (status <= 0) {
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
							}
						}
					
					//操作人为副主任
					}else if(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){
						
						// 判断当前案件是否有主任
						boolean isDirector = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
						if(!isDirector){
							
							// 分配主任
							int isDistributionLow = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
							
							if (isDistributionLow <= 0) {
								return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
							}
						}
						
						
						//查询主任的userId
						String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode(), CaseManagerStatusEnum.OK.getCode());
						
						//将查询出的主任添加到审批表
						int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
						if (updateApproverId <= 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
						}						
						
					}
					

				}
				
				//tudo 生成通知书
				
			}

		return BusiExecuteResult.builderSuccessResult();
	}
	
	
	
	
    /**
     * 添加仲裁员回避决定书
     * @param formData
     * @return
     */
    private boolean saveADraftOnDocAndDocContent(SaveCaseDocDTO formData,String docName,String docType){
    		
		//文书id
    	String caseDocId=sequenceService.getCommonID();
    	
    	Calendar cal = Calendar.getInstance();
    	int year = cal.get(Calendar.YEAR);
    	
    	//文书年编号
    	String docYearNumber=String.valueOf(year);
    	//todo 文书序列号
    	String docSerialNumber=sequenceService.getCommonID();
    	
    	//新增文书
    	CaseDoc caseDoc = new CaseDoc();
    	caseDoc.setId(caseDocId);
    	caseDoc.setDocName(docName);
    	caseDoc.setDocType(docType);
    	caseDoc.setCaseId(formData.getCaseId());
    	caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
    	caseDoc.setDocYearNumber(docYearNumber);
    	caseDoc.setDocSerialNumber(docSerialNumber);
    	
    	//查出请求id和业务id
    	CaseApprove caseApprove = caseApproveMapper.queryBusiIdRequestId(formData.getApproveId());
    	caseDoc.setRequestId(caseApprove.getRequestId());
    	caseDoc.setBusiId(caseApprove.getBusiId());
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
		int docContentLow= caseDocContentMapper.insertSelective(caseDocContentWithBLOBs);
		if(docLow>0&&docContentLow>0){
			return true;
		}
		return false;
    }
    
    
    /**
     * 修改仲裁员回避决定书
     * @param formData
     * @return
     */
    private boolean updateADraftOnDocAndDocContent(SaveCaseDocDTO formData){
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
		//获取当前用户身份
		String duties = caseInfoMapper.queryDutiesById(formData.getUserId());
		
		//添加意见标注
		if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)){
			caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_PASS.getDescribe());
		
		}else if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(duties)){
			caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_REVIEW.getDescribe());
		
		}else if(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)){
			caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
		
		}else if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)){
			if((OpinionStateEnum.REJECTED.getValue()).equals(formData.getOpinionStatus())){
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_NO_PASS.getDescribe());
			}else{
				caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
			}
			
		}
		
		
		caseApproveSuggest.setOpinionStatus(formData.getOpinionStatus());
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setCreaterId(formData.getUserId());
		caseApproveSuggest.setId(approveSuggestId);
		caseApproveSuggest.setCreateTime(new Date());
		
		int low = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if(low>0){
			return true;
		}
		return false;
	}

	
}
