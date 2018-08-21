package com.zyxy.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.RulingBookAuditService;
import com.zyxy.admin.service.WhetherDistributionService;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseApproveExample;
import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorExample;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.domain.ManagerInfoExample;
import com.zyxy.common.dto.RulingBookAuditDTO;
import com.zyxy.common.dto.flow.CaseAuditDTO;
import com.zyxy.common.dto.flow.CaseOverDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseAgentTypeEnum;
import com.zyxy.common.enums.CaseApproveDescribeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseArbitratorStatusEnum;
import com.zyxy.common.enums.CaseDocContentSaveDraftEnum;
import com.zyxy.common.enums.CaseManagerStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.OpinionStateEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.CaseAgentMapper;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseApproveSuggestMapper;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApproveRecordVO;
import com.zyxy.common.vo.AuditRulingBookVO;
import com.zyxy.common.vo.CaseAgentVO;
import com.zyxy.common.vo.CaseDocVO;
/**
 * 裁决书审批ServiceImpl
 *
 */
@Service
public class RulingBookAuditServiceImpl implements RulingBookAuditService {

	@Autowired
	private CaseDocMapper caseDocMapper;

	@Autowired
	private CaseApproveMapper caseApproveMapper;

	@Autowired
	private CaseAgentMapper caseAgentMapper;

	@Autowired
	private CaseInfoMapper caseInfoMapper;

	@Autowired
	private WhetherDistributionService whetherDistributionService;

	@Autowired
	private CaseManagerMapper caseManagerMapper;

	@Autowired
	private SequenceService sequenceService;

	@Autowired
	private CaseApproveSuggestMapper caseApproveSuggestMapper;

	@Autowired
	private ManagerInfoMapper managerInfoMapper;

	@Autowired
	private CaseArbitratorMapper caseArbitratorMapper;
	
	@Autowired
	private LitigantInfoMapper litigantInfoMapper;
	
	@Autowired
	private MicroFlowService microFlowService;

	/**
	 * 裁决书审核业务处理
	 * @param approveId
	 * @param caseId
	 * @return 裁决书信息
	 */
	@Override
	public AuditRulingBookVO rulingBookAuditBusiExecute(String approveId,
			String userId) {
		return queryRulingBook(approveId,userId);
	}

	/**
	 * 审核裁决书业务处理
	 * 
	 * @param formData
	 * @return 审核结果
	 */
	@Override
	public BusiExecuteResult auditRulingBookBusiExecute(
			RulingBookAuditDTO formData) {

		return this.auditRulingBook(formData);
	}

	/******************** 私有service ************************/

	/**
	 * 查询裁决书信息
	 * 
	 * @param caseId
	 *            案件id
	 * @return 裁决书信息
	 */
	private AuditRulingBookVO queryRulingBook(String approveId,String userId) {
		
		/**
		 * 裁决书审核信息对象，设置并返回
		 */
		AuditRulingBookVO auditRulingBookVO = new AuditRulingBookVO();
		
		// 查询出当前审批对象
		CaseApproveExample caseApprove = new CaseApproveExample();
		caseApprove.createCriteria().andCaseIdEqualTo(approveId);
		List<CaseApprove> queryCaseApprove = caseApproveMapper.selectByExample(caseApprove);
		// 判断当前审批对象是否存在
		if (queryCaseApprove.size() > 0) {
			// 查询出裁决书
			CaseDocVO caseDocVO = caseDocMapper.queryCaseDocbusiId( queryCaseApprove.get(0).getBusiId(),CaseDocContentSaveDraftEnum.NO_SAVE_AS_DRAFT.getCode());
			// 判断裁决书是否为空
			if (caseDocVO != null) {
				// 查询出该案件的代理人信息
				List<CaseAgentVO> caseAgentVOList = caseAgentMapper.selectAgentName(queryCaseApprove.get(0).getCaseId());

				if (caseAgentVOList != null) {
					for (int i = 0; i < caseAgentVOList.size(); i++) {
						// 判断是申请人的代理人还是被申请人的代理人
						if (CaseAgentTypeEnum.PROP_AGENT.getCode().equals(caseAgentVOList.get(i).getLitigantType())) {
							caseDocVO.setPropAgentName(caseAgentVOList.get(i).getName());
							caseDocVO.setPropAgentDuties(caseAgentVOList.get(i).getVocation());
						} else {
							caseDocVO.setDepeAgentName(caseAgentVOList.get(i).getName());
							caseDocVO.setPropAgentDuties(caseAgentVOList.get(i).getVocation());
						}
					}
				}

			// 根据审批Id查询审批记录
			List<ApproveRecordVO> approveRecordVO = caseApproveMapper.queryApproveRecordApproveId(approveId);
			
			// 获取当前审批表的审批人身份
			String approveDuties = caseApproveMapper.queryApproveUserDuties(approveId);
			
			// 获取当前登录的审批人身份，添加到立案审核对象
			String userDuties = managerInfoMapper.queryDutiesByUserId(userId);
			
			// 获取当前案件id及审批id审批表审批人身份和当前用户身份,添加到立案审核对象
			auditRulingBookVO.setApproveId(approveId);
			auditRulingBookVO.setCaseId(queryCaseApprove.get(0).getCaseId());
			auditRulingBookVO.setApproveDuties(approveDuties);
			auditRulingBookVO.setDuties(userDuties);
			
			// 将裁决书基本信息，添加到裁决书审核对象
			auditRulingBookVO.setCaseDocVO(caseDocVO);
			// 将审批记录添加到裁决书审核对象
			auditRulingBookVO.setApproveRecordList(approveRecordVO);
			}
		}
		return auditRulingBookVO;

	}

	/**
	 * 审核裁决书
	 * 
	 * @param formData
	 *            立案审核DTO
	 * @return
	 */
	private BusiExecuteResult auditRulingBook(RulingBookAuditDTO formData) {
		/**
		 * 操作类型 通过或者反馈修改意见，只有主任或者副主任才能驳回
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
		 * 操作人为部长,主任和副主任
		 */
		if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(currentDuties)||ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)|| ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
			
			// 操作类型为驳回
			if ((OpinionStateEnum.REJECTED.getValue()).equals(opinion)) {
				// 驳回，裁决书将回到仲裁庭，将由仲裁员审核，审批人修改为仲裁员
				// 查询当前案件仲裁员Id
				CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
				caseArbitratorExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
				List<CaseArbitrator> CaseArbitrator = caseArbitratorMapper.selectByExample(caseArbitratorExample);
				String arbitratorId = CaseArbitrator.get(0).getArbitratorId();
				
				// 将仲裁员更新到审批表审批人
				int uai = caseApproveMapper.updateApproverId(formData.getApproveId(), arbitratorId);
				
				// 审批表状态，修改为审核未通过
				caseApprove.setApproveStatus(CaseApproveStatusEnum.FAIL_AUDIT.getValue());
				
				// 按照审批Id查找，指定修改的审批表对象
				caseApprove.setId(formData.getApproveId());
				
				// 审批状态更新到审批表
				int updateStatus = caseApproveMapper.updateStatus(caseApprove);
				if (uai <= 0 || updateStatus <= 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
				}
				
				// 意见表状态为驳回
				caseApproveSuggest.setOpinionStatus(OpinionStateEnum.REJECTED.getValue());
				
				// 添加意见表审批标注
				if (ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe());
					
				}else if (ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_SUGGESTION.getDescribe());
					
				}else if (ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(currentDuties)) {
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_SUGGESTION.getDescribe());
				}
			// 操作类型为通过
			}else if ((OpinionStateEnum.GET_THROUGH.getValue()).equals(opinion)) {
				//操作人为主任
				if(ManagerInfoTypeEnum.DIRECTOR.getCode().equals(currentDuties)){ 
					
					// 审批表状态，修改为通过
					caseApprove.setApproveStatus(CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
					
					// 按照审批Id查找，指定修改的审批表对象
					caseApprove.setId(formData.getApproveId());
					
					// 数据更新到审批表
					int updateStatus = caseApproveMapper.updateStatus(caseApprove);
					
					// 结案流程控制
					CaseOverDTO caseOverDTO =new  CaseOverDTO();
					caseOverDTO.setCaseId(formData.getCaseId());
					//todo枚举类暂未建
					caseOverDTO.setResult("1");
					caseOverDTO.setUserId(formData.getUserId());
					ApiResultVO<String> caseOver = microFlowService.caseOver(formData.getCaseId(), caseOverDTO);
					if (!(ApiResultVO.Coder.SUCCESS.getCode()).equals(caseOver.getHead().getRetCode())) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.CALL_SERV_ERROR);
					}
					
					if (updateStatus < 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}
					
					// 意见表状态为通过
					caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
					
					//添加意见表审批标注
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
					
				//操作人为仲裁部长
				}else if(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode().equals(currentDuties)){
					
					// 意见表状态为通过
					caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
					
					//添加意见表审批标注
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_MINISTER_PASS.getDescribe());
					
					// 判断当前案件是否有副主任
					boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
					
					// 没有副主任，需要分配副主任
					if (!queryCaseManagerInfo) {
						
						// 分配副主任
						int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
						
						if (ampbt <=0) {
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
					
				//当操作人为副主任时	
				}else if(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode().equals(currentDuties)){
					
					// 意见表状态为通过
					caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
					
					//添加意见表审批标注
					caseApproveSuggest.setMark(CaseApproveDescribeEnum.DEPUTY_DIRECTOR_FINAL_JUDGMENT_PASS.getDescribe());
					
					// 判断当前案件是否有主任
					boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
					
					// 没有主任，需要分配主任
					if (!queryCaseManagerInfo) {
						// 分配主任
						int am = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode());
						if (am < 0) {
							return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
						}

					}

					// 副主任操作完成，将主任更新到审批表中
					// 查询主任的userId
					String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.DIRECTOR.getCode(),CaseManagerStatusEnum.OK.getCode());
					
					// 将查询出的主任添加到审批表
					int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
					if (updateApproverId < 0) {
						return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
					}
					
				}
			}
		// 操作人为秘书
		} else if(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode().equals(currentDuties)){

			// 意见表状态为通过
			caseApproveSuggest.setOpinionStatus(OpinionStateEnum.GET_THROUGH.getValue());
			
			//添加意见表审批标注
			caseApproveSuggest.setMark(CaseApproveDescribeEnum.ARBITRATION_SECRETARY_FIRST_TRIAL.getDescribe());
			
			// 判断当前案件是否有仲裁部长
			boolean queryCaseManagerInfo = whetherDistributionService.queryCaseManagerInfo(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
			
			if (!queryCaseManagerInfo) {// 没有部长
				
				// 分配仲裁部长
				int ampbt = caseManagerMapper.allotManagerPeopleByCaseAndType(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				if (ampbt < 0) {
					return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_INSERT_ERROR);
				}
			}
	
			// 秘书操作完成，将仲裁部长更新到审批表中
			// 查询仲裁部长的userId
			String managerId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(),ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode(),CaseManagerStatusEnum.OK.getCode());
			// 将查询出的仲裁部长添加到审批表
			int updateApproverId = caseApproveMapper.updateApproverId(formData.getApproveId(), managerId);
			if (updateApproverId < 0) {
				return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
		}

		// 生成审批意见id
		String approveSuggestId =sequenceService.getCommonID();
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

}
