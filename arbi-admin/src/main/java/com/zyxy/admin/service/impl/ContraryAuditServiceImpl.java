package com.zyxy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ContraryAuditService;
import com.zyxy.common.domain.ContraryToAccount;
import com.zyxy.common.domain.ContraryToAccountExample;
import com.zyxy.common.domain.EnterpriseAuthRecord;
import com.zyxy.common.domain.EnterpriseAuthRecordExample;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.domain.ManagerInfoExample;
import com.zyxy.common.dto.ContraryAuditDTO;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.ContraryToAccountMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ContraryAuditVO;
import com.zyxy.common.vo.MethodAuditVO;

@Service
public class ContraryAuditServiceImpl implements ContraryAuditService {
	
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	
	@Autowired
	private ContraryToAccountMapper contraryToAccountMapper;

	/**
	 * 业务验证，判断当前登录人是否是立案秘书
	 * @return
	 */
	@Override
	public BusiValidResult contraryAuditBusiValid(String userId) {
		ManagerInfoExample managerInfo = new ManagerInfoExample();
		managerInfo
				.createCriteria()
				.andUserIdEqualTo(userId)
				.andDutiesEqualTo(ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode());
		List<ManagerInfo> list = managerInfoMapper.selectByExample(managerInfo);
		
		if (list == null || list.isEmpty()) {
			return BusiValidResult
					.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
		}
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 业务处理，查询对公账户审核列表
	 * @param formData 
	 * @return 
	 * @return 
	 */
	@Override
	public BusiExecuteResult<PageInfo<ContraryAuditVO>> contraryAuditBusiExecute(ContraryAuditDTO formData) {
		PageInfo<ContraryAuditVO> contraryPageInfo = this.queryContraryAuditList(formData);
		return BusiExecuteResult.builderSuccessResult(contraryPageInfo);
	}

	/**
	 * 查询对公账户审核列表
	 * @return 
	 * @return 
	 */
	private PageInfo<ContraryAuditVO> queryContraryAuditList(ContraryAuditDTO formData) {
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		
		List<ContraryAuditVO> contraryAuditList = contraryToAccountMapper.queryContraryAuditList(formData);
		return new PageInfo<ContraryAuditVO>(contraryAuditList);
	}

	/**
	 * 业务验证-审核对公账户
	 */
	@Override
	public BusiValidResult auditContraryBusiValid(ContraryAuditDTO formData) {
		// 判断当前案件在待审核状态
		List<ContraryToAccount> contraryByIdList = this
				.auditContraryById(formData);
		if (contraryByIdList == null || contraryByIdList.isEmpty()) {
			return BusiValidResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 判断当前案件在待审核状态
	 * @return
	 */
	private List<ContraryToAccount> auditContraryById(
			ContraryAuditDTO formData) {
		ContraryToAccountExample accountExample = new ContraryToAccountExample();
		accountExample.createCriteria()
					.andIdEqualTo(formData.getId())
					.andStatusEqualTo(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		return contraryToAccountMapper.selectByExample(accountExample);
	}

	/**
	 * 业务处理
	 * 审核对公账户
	 */
	@Override
	public BusiExecuteResult auditContraryBusiExecute(ContraryAuditDTO formData) {
		//通过
		if ("1".equals(formData.getOperation())) { 
			// 修改状态为审核通过
			int uca = contraryToAccountMapper.updateContraryAudit(
					formData.getId(), CaseApproveStatusEnum.SUCCESS_AUDIT.getValue());

			if (uca <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
		}
		
		//驳回
		if ("2".equals(formData.getOperation())) {
			// 修改状态为审核未通过
			int uca = contraryToAccountMapper.updateContraryAudit(
					formData.getId(), CaseApproveStatusEnum.FAIL_AUDIT.getValue());

			if (uca <= 0) {
				return BusiExecuteResult
						.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
			}
		}
		
		return BusiExecuteResult.builderSuccessResult();
	}

}
