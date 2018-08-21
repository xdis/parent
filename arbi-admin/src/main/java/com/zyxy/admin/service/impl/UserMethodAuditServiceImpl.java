package com.zyxy.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserMethodAuditService;
import com.zyxy.common.domain.EnterpriseAuthRecord;
import com.zyxy.common.domain.EnterpriseAuthRecordExample;
import com.zyxy.common.domain.LabourRealNameAuthRecord;
import com.zyxy.common.domain.LabourRealNameAuthRecordExample;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.domain.ManagerInfoExample;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.EnterpriseAuthRecordMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MethodAuditVO;
import com.zyxy.common.vo.RealUserAuditVO;

@Service
public class UserMethodAuditServiceImpl implements UserMethodAuditService {
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	private EnterpriseAuthRecordMapper enterpriseAuthRecordMapper;
	
	@Autowired
	private MicroFileService microFileService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private LitigantInfoMapper litigantInfoMapper;
	
	/**业务验证
	 * 判断当前登录人是否为立案秘书
	 */
	@Override
	public BusiValidResult userAuditBusiValid(String userId) {
		ManagerInfoExample managerInfo = new ManagerInfoExample();
		managerInfo
				.createCriteria()
				.andUserIdEqualTo(userId)
				.andDutiesEqualTo(
						ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode());
		List<ManagerInfo> list = managerInfoMapper.selectByExample(managerInfo);
		
		if (list == null || list.isEmpty()) {
			return BusiValidResult
					.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
		}
		return BusiValidResult.builderSuccessResult();
	}
	
	/**
	 * 法人身份审核记录信息业务处理
	 * 
	 * @param formData 用户身份审核DTO
	 * @return 
	 * @return
	 */
	@Override
	public BusiExecuteResult<PageInfo<MethodAuditVO>> methodAuditBusiExecute(
			UserAuditDTO formData) {

		PageInfo<MethodAuditVO> pageInfo = this.queryArbiCaseList(formData);
		return BusiExecuteResult.builderSuccessResult(pageInfo);
	}

	/**
	 * 查询要审核的法人列表
	 * @return 
	 */
	public PageInfo<MethodAuditVO> queryArbiCaseList(UserAuditDTO formData) {
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		List<MethodAuditVO> queryArbiCaseList = enterpriseAuthRecordMapper
				.queryArbiCaseList(formData);
		for (MethodAuditVO methodAuditVO : queryArbiCaseList) {
//			methodAuditVO.setIdCard(microFileService.getFileInfoById(methodAuditVO.getIdCard()).getBody().getSysPath());
			methodAuditVO.setCardImageCon(microFileService.getFileInfoById(methodAuditVO.getCardImageCon()).getBody().getSysPath());
			methodAuditVO.setCardImageFront(microFileService.getFileInfoById(methodAuditVO.getCardImageFront()).getBody().getSysPath());
		}
		return new PageInfo<MethodAuditVO>(queryArbiCaseList);
	}

	/**
	 * 审核法人业务验证
	 */
	@Override
	public BusiValidResult auditMethodBusiValid(UserAuditDTO formData) {
		// 判断当前案件在待审核状态
		List<EnterpriseAuthRecord> userAuditByIdList = this
				.methodAuditById(formData);
		if (userAuditByIdList == null || userAuditByIdList.isEmpty()) {
			return BusiValidResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		return BusiValidResult.builderSuccessResult();
	}
	
	/**
	 * 判断当前案件在待审核状态
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	private List<EnterpriseAuthRecord> methodAuditById(UserAuditDTO formData) {
		EnterpriseAuthRecordExample enterprise = new EnterpriseAuthRecordExample();
		enterprise.createCriteria()
					.andIdEqualTo(formData.getId())
					.andStatusEqualTo(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		return enterpriseAuthRecordMapper.selectByExample(enterprise);
	}

	/**
	 * 审核法人身份
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult auditMethodBusiExecute(UserAuditDTO formData) {
		//通过
		if ("1".equals(formData.getOperation())) { 
			// 修改状态
			int uua = enterpriseAuthRecordMapper.updateMethodAudit(
					formData.getId(), CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());

			if (uua <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
			
			//将通过的法人信息添加到当事人表中
			EnterpriseAuthRecord enterpriseAuthRecord = enterpriseAuthRecordMapper
				.selectEnterpriseAuthRecordByStatus(
						formData.getId(), 
						CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());
			LitigantInfo litigantInfo = new LitigantInfo();
			litigantInfo.setId(sequenceService.getCommonID());
			litigantInfo.setUserId(enterpriseAuthRecord.getCreaterId());
			litigantInfo.setCertName(enterpriseAuthRecord.getCertName());
			litigantInfo.setCertDuties(enterpriseAuthRecord.getCertDuties());
			litigantInfo.setUnifiedSocialCode(enterpriseAuthRecord.getUnifiedSocialCode());
			litigantInfo.setAddress(enterpriseAuthRecord.getAddress());
			litigantInfo.setCardImageFront(enterpriseAuthRecord.getCardImageFront());
			litigantInfo.setCardImageCon(enterpriseAuthRecord.getCardImageCon());
			litigantInfo.setBusiImgId(enterpriseAuthRecord.getThreeInOne());
			litigantInfo.setPlatformAuth(enterpriseAuthRecord.getPlatformAuth());
			litigantInfo.setEnterpriseType(enterpriseAuthRecord.getType());
			litigantInfo.setCreaterId(formData.getUserId());
			litigantInfo.setCreateTime(new Date());
			litigantInfoMapper.insertSelective(litigantInfo);
		}
		
		//驳回
		if ("2".equals(formData.getOperation())) {
			// 将审批结果更新到用户身份审批表
			int uua = enterpriseAuthRecordMapper.updateMethodAudit(
					formData.getId(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());

			if (uua <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
		}
		
		return BusiExecuteResult.builderSuccessResult();
	}
}
