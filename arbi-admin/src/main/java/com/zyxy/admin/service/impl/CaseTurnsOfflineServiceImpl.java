package com.zyxy.admin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CaseTurnsOfflineService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseTurnsOfflineRecord;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseTurnsOfflineDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveDescribeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseManagerStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.OpinionStateEnum;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseApproveSuggestMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.CaseTurnsOfflineRecordMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseTurnsOfflineRecordVO;

/**
 *	案件转线下 
 */
@Service
public class CaseTurnsOfflineServiceImpl implements CaseTurnsOfflineService {
	
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	private CaseTurnsOfflineRecordMapper caseTurnsOfflineRecordMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private WhetherDistributionService whetherDistributionService;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;

	/**
	 * 	业务验证
	 * @return 
	 */
	@Override
	public BusiValidResult applyBusiValid(CaseTurnsOfflineDTO formData) {
		//判断案件是否存在
		int caseExist = caseInfoMapper.caseExist(formData.getCaseId());
		String duties = managerInfoMapper.queryDutiesByUserId(formData.getUserId());
		if (caseExist <= 0) {
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}else if ("0".equals(duties) || "1".equals(duties)) {
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 插入记录业务处理
	 * @return 
	 * @return 
	 */
	@Override
	public BusiExecuteResult insert(CaseTurnsOfflineDTO formData) {
		//当前登录人职务
		String duties = managerInfoMapper.queryDutiesByUserId(formData.getUserId());
		
		Date date = new Date();
		String commonID = sequenceService.getCommonID();
		
		CaseTurnsOfflineRecord caseTurnsOfflineRecord = new CaseTurnsOfflineRecord();
		caseTurnsOfflineRecord.setId(commonID);
		caseTurnsOfflineRecord.setCaseId(formData.getCaseId());
		caseTurnsOfflineRecord.setCreaterId(formData.getUserId());
		caseTurnsOfflineRecord.setCreateTime(date);
		caseTurnsOfflineRecord.setCause(formData.getCause());
		caseTurnsOfflineRecord.setBusiId(sequenceService.getCommonID());
		caseTurnsOfflineRecord.setStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		caseTurnsOfflineRecord.setCreaterIdDuties(duties);
		int condition = caseTurnsOfflineRecordMapper.insertSelective(caseTurnsOfflineRecord);
		if (condition <= 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		
		CaseApprove caseApprove = new CaseApprove();
		caseApprove.setId(commonID);
		caseApprove.setCaseId(formData.getCaseId());
		caseApprove.setApproveType(ApproveTypeEnum.TURNS_OFFLINE_APPROVE.getTypeName());
		caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		caseApprove.setCreateTime(date);
		caseApprove.setBusiId(sequenceService.getCommonID());
		caseApprove.setCreaterId(formData.getUserId());
		
		//当前登录人为仲裁秘书
		if (ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(duties)) {
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
			
			//查询仲裁部长的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(
					formData.getCaseId(),
					ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),
					CaseManagerStatusEnum.OK.getCode());
			
			caseApprove.setApproveUserId(managerId);
		}
		
		//当前登录人为仲裁部长
		if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)) {
			//判断当前案件是否有副主任
			boolean queryCaseManagerInfo = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(), 
						ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
			//没有副主任
			if (!queryCaseManagerInfo) {
				//分配副主任
				int insertManagerType = this.insertManagerType(formData.getCaseId(), 
						ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				if (insertManagerType < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			//查询副主任的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(
					formData.getCaseId(),
					ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode(),
					CaseManagerStatusEnum.OK.getCode());
			
			caseApprove.setApproveUserId(managerId);
		}
		
		//当前登录人为副主任,主任
		if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties) 
				|| ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)) {
			//判断当前案件是否有主任
			boolean queryCaseManagerInfo = whetherDistributionService
					.queryCaseManagerInfo(formData.getCaseId(), 
						ManagerInfoTypeEnum.DIRECTOR.getCode());
			//没有主任
			if (!queryCaseManagerInfo) {
				//分配主任
				int insertManagerType = this.insertManagerType(formData.getCaseId(), 
						ManagerInfoTypeEnum.DIRECTOR.getCode());
				if (insertManagerType < 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
			
			//查询主任的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(
					formData.getCaseId(),
					ManagerInfoTypeEnum.DIRECTOR.getCode(),
					CaseManagerStatusEnum.OK.getCode());
			
			caseApprove.setApproveUserId(managerId);
		}
		
		int is = caseApproveMapper.insertSelective(caseApprove);
		if (is <= 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		
		return BusiExecuteResult.builderSuccessResult();
	}

	/**
	 * 案件转线下审核业务验证
	 * @return 
	 */
	@Override
	public BusiValidResult caseBusiValid(String approveId) {
		//判断案件是否存在
		CaseTurnsOfflineRecord caseTurnsOfflineRecord = caseTurnsOfflineRecordMapper
				.selectByPrimaryKey(approveId);
		if (caseTurnsOfflineRecord == null) {
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 案件转线下审核业务处理
	 * @return 
	 */
	@Override
	public CaseTurnsOfflineRecordVO caseBusiValidAudit(String approveId, String userId) {
		CaseTurnsOfflineRecordVO caseTurnsOfflineRecordVO = new CaseTurnsOfflineRecordVO();
		
		//案件转线下记录信息
		CaseTurnsOfflineRecord caseTurnsOfflineRecord = caseTurnsOfflineRecordMapper
				.selectByPrimaryKey(approveId);
		caseTurnsOfflineRecordVO.setCaseTurnsOfflineRecord(caseTurnsOfflineRecord);
		
		//案件转线下创建人姓名
		caseTurnsOfflineRecordVO.setCreaterName(
				userInfoMapper
					.selectByPrimaryKey(caseTurnsOfflineRecord.getCreaterId()).getName());;
		
		//当前仲裁委登录人为主任、副主任
		String duties = managerInfoMapper.queryDutiesByUserId(userId);
		caseTurnsOfflineRecordVO.setDuties(duties);
		if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)
				|| ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode()
						.equals(duties)) {
			
			//查询案件审批意见列表
			caseTurnsOfflineRecordVO.setApproveRecorList(
					caseTurnsOfflineRecordMapper
						.queryApproveSuggestByApproveId(caseTurnsOfflineRecord.getId()));
		}
		
		return caseTurnsOfflineRecordVO;
	}

	/**
	 * 审核案件转线下业务验证
	 * @return 
	 */
	@Override
	public BusiValidResult auditBusiValid(CaseApproveSuggestDTO formData, String userId) {
		//判断当前登录人是否是当前审批人
		CaseApprove caseApprove = caseApproveMapper
				.selectByPrimaryKey(formData.getApproveId());
		if (caseApprove != null) {
			if (!userId.equals(caseApprove.getApproveUserId())) {
				return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NO_PERMISSION);
			}
		}else {
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 审核案件转线下业务处理
	 */
	@Override
	public BusiExecuteResult auditBusiExecute(CaseApproveSuggestDTO formData) {
		//插入审批意见表
		CaseApproveSuggest caseApproveSuggest = new CaseApproveSuggest();
		
		//当前登录人职务
		String duties = managerInfoMapper.queryDutiesByUserId(formData.getCreaterId());
		
		//当前登录人为仲裁部长
		if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(duties)) {
			//操作类型为驳回
			if (OpinionStateEnum.REJECTED.getValue()
					.equals(formData.getOpinionStatus())) {
				//修改审批状态为未通过
				CaseApprove caseApprove = new CaseApprove();
				caseApprove.setId(formData.getApproveId());
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int cam = caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
				if (cam <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				CaseTurnsOfflineRecord offlineRecord = new CaseTurnsOfflineRecord();
				offlineRecord.setId(formData.getApproveId());
				offlineRecord.setStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int ctor = caseTurnsOfflineRecordMapper.updateByPrimaryKeySelective(offlineRecord);
				if (ctor <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 审批意见表标注
				caseApproveSuggest
						.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_NO_PASS
								.getDescribe());
			}
			
			
			//操作类型为通过
			if (OpinionStateEnum.GET_THROUGH.getValue()
					.equals(formData.getOpinionStatus())) {
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
		
		//当前登录人为副主任
		if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(duties)) {
			//操作类型为驳回
			if (OpinionStateEnum.REJECTED.getValue()
					.equals(formData.getOpinionStatus())) {
				//修改审批状态为未通过
				CaseApprove caseApprove = new CaseApprove();
				caseApprove.setId(formData.getApproveId());
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int cam = caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
				if (cam <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				CaseTurnsOfflineRecord offlineRecord = new CaseTurnsOfflineRecord();
				offlineRecord.setId(formData.getApproveId());
				offlineRecord.setStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int ctor = caseTurnsOfflineRecordMapper.updateByPrimaryKeySelective(offlineRecord);
				if (ctor <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 审批意见表标注
				caseApproveSuggest
						.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_NO_PASS
								.getDescribe());
			}
			
			//操作类型为通过
			if (OpinionStateEnum.GET_THROUGH.getValue()
					.equals(formData.getOpinionStatus())) {
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
		
		//当前登录人为主任
		if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(duties)) {
			//操作类型为驳回
			if (OpinionStateEnum.REJECTED.getValue().equals(formData.getOpinionStatus())) {
				//修改审批状态为未通过
				CaseApprove caseApprove = new CaseApprove();
				caseApprove.setId(formData.getApproveId());
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int cam = caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
				if (cam <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				CaseTurnsOfflineRecord offlineRecord = new CaseTurnsOfflineRecord();
				offlineRecord.setId(formData.getApproveId());
				offlineRecord.setStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				int ctor = caseTurnsOfflineRecordMapper.updateByPrimaryKeySelective(offlineRecord);
				if (ctor <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				//更新审批意见表的意见状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED
						.getValue());
				
				// 审批意见表标注
				caseApproveSuggest
						.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_NO_PASS
								.getDescribe());
			}
			
			//操作类型为通过
			if (OpinionStateEnum.GET_THROUGH.getValue()
					.equals(formData.getOpinionStatus())) {
				//修改审批状态
				CaseApprove caseApprove = new CaseApprove();
				caseApprove.setId(formData.getApproveId());
				caseApprove.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
				int cam = caseApproveMapper.updateByPrimaryKeySelective(caseApprove);
				if (cam <= 0) {
					return BusiExecuteResult
							.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				CaseTurnsOfflineRecord offlineRecord = new CaseTurnsOfflineRecord();
				offlineRecord.setId(formData.getApproveId());
				offlineRecord.setStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
				int ctor = caseTurnsOfflineRecordMapper.updateByPrimaryKeySelective(offlineRecord);
				if (ctor <= 0) {
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
		
		caseApproveSuggest.setId(sequenceService.getCommonID());
		caseApproveSuggest.setApproveId(formData.getApproveId());
		caseApproveSuggest.setApproveSuggest(formData.getApproveSuggest());
		caseApproveSuggest.setCaseId(formData.getCaseId());
		caseApproveSuggest.setCreaterId(formData.getCreaterId());
		caseApproveSuggest.setCreateTime(new Date());
		caseApproveSuggest.setSuggestUserDuties(duties);
		// 插入审批意见表
		int cjdLow = caseApproveSuggestMapper.insertSelective(caseApproveSuggest);
		if (cjdLow < 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
		}
		
		return BusiExecuteResult.builderSuccessResult();
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
	 * 分配仲裁委工作人员
	 * @return 
	 */
	public int insertManagerType(String caseId, String type) {
		return caseManagerMapper.allotManagerPeopleByCaseAndType(caseId, type);
	}
}
