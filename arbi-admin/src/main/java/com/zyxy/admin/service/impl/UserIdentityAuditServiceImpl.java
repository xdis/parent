package com.zyxy.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserIdentityAuditService;
import com.zyxy.common.domain.LabourRealNameAuthRecord;
import com.zyxy.common.domain.LabourRealNameAuthRecordExample;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.domain.ManagerInfoExample;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.LabourRealNameAuthRecordMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.RealUserAuditVO;
/**
 * 当事人身份审核
 *
 */
@Service
public class UserIdentityAuditServiceImpl implements UserIdentityAuditService {
	@Autowired
	private ManagerInfoMapper managerInfoMapper;

	@Autowired
	private LabourRealNameAuthRecordMapper labourRealNameAuthRecordMapper;

	@Autowired
	private MicroFileService microFileService;

	/**
	 * 判断当前是审批人是否为立案秘书
	 * 
	 * @param userId
	 *            当前登录的仲裁委Id
	 * @return
	 */
	@Override
	public BusiValidResult userAuditBusiValid(String userId) {
		List<ManagerInfo> list = this.userAuditByUserId(userId);
		if (list == null || list.isEmpty()) {
			return BusiValidResult
					.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
		}
		return BusiValidResult.builderSuccessResult();

	}

	/**
	 * 判断当前审批人为立案秘书，审批在待审核状态
	 * 
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	@Override
	public BusiValidResult auditUserBusiValid(UserAuditDTO formData) {
		// 判断当前审批人是立案秘书
		List<ManagerInfo> list = this.userAuditByUserId(formData.getUserId());
		if (list == null || list.isEmpty()) {
			return BusiValidResult
					.builderErrorResult(Coder.USERID_NO_PRIVILEGE);
		}
		// 判断当前案件在待审核状态
		List<LabourRealNameAuthRecord> userAuditByIdList = this
				.userAuditById(formData);
		if (userAuditByIdList == null || userAuditByIdList.isEmpty()) {
			return BusiValidResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		return BusiValidResult.builderSuccessResult();

	}

	/**
	 * 用户身份审核记录信息业务处理
	 * 
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult<PageInfo<RealUserAuditVO>> userAuditBusiExecute(
			UserAuditDTO formData) {

		PageInfo<RealUserAuditVO> caseListVOPageInfo = this
				.queryArbiCaseList(formData);
		return BusiExecuteResult.builderSuccessResult(caseListVOPageInfo);
	}

	/**
	 * 审核用户身份业务处理
	 * 
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	@Override
	public BusiExecuteResult auditUserBusiExecute(UserAuditDTO formData) {
		// 将审批结果更新到用户身份审批表
		int uua = labourRealNameAuthRecordMapper.updateUserAudit(
				formData.getId(), formData.getOperation(),
				formData.getUserId(), new Date());

		if (uua <= 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}

		return BusiExecuteResult.builderSuccessResult();
	}

	// ###############私有方法################################
	/**
	 * 判断当前登录的仲裁委为立案秘书
	 * @param userId 当前登录仲裁委Id
	 * @return
	 */
	private List<ManagerInfo> userAuditByUserId(String userId) {

		ManagerInfoExample managerInfo = new ManagerInfoExample();
		managerInfo
				.createCriteria()
				.andUserIdEqualTo(userId)
				.andDutiesEqualTo(
						ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode());
		return managerInfoMapper.selectByExample(managerInfo);
	}
	
	/**
	 * 判断当前案件在待审核状态
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	private List<LabourRealNameAuthRecord> userAuditById(UserAuditDTO formData) {
		LabourRealNameAuthRecordExample lrnare = new LabourRealNameAuthRecordExample();
		lrnare.createCriteria().andIdEqualTo(formData.getId())
				.andStatusEqualTo(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		return labourRealNameAuthRecordMapper.selectByExample(lrnare);
	}

	/**
	 * 查询案件列表
	 * 
	 * @param formData 用户身份审核DTO
	 * @return
	 */
	private PageInfo<RealUserAuditVO> queryArbiCaseList(UserAuditDTO formData) {
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		List<RealUserAuditVO> queryRealUserAuditList = labourRealNameAuthRecordMapper
				.queryRealUserAuditList(formData);
		//获取图片地址添加到对象集合中
		for (RealUserAuditVO realUserAuditVO : queryRealUserAuditList) {
			if(realUserAuditVO.getIdCard()!=null&&realUserAuditVO.getCardImageCon()!=null&&realUserAuditVO.getCardImageFront()!=null)
			realUserAuditVO.setIdCard(microFileService.getFileInfoById(realUserAuditVO.getIdCard()).getBody().getSysPath());
			realUserAuditVO.setCardImageCon(microFileService.getFileInfoById(realUserAuditVO.getCardImageCon()).getBody().getSysPath());
			realUserAuditVO.setCardImageFront(microFileService.getFileInfoById(realUserAuditVO.getCardImageFront()).getBody().getSysPath());
			
		}
		return new PageInfo<RealUserAuditVO>(queryRealUserAuditList);
	}

}
