package com.zyxy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ArbitrationCaseService;
import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.CaseManager;
import com.zyxy.common.domain.ManagerInfo;
import com.zyxy.common.dto.ArbitrationCaseListDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseMatTypeEnum;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.ArbitrationCaseHandleMapper;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseDocContentMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApproveRecordVO;
import com.zyxy.common.vo.ArbitrationCaseArbitrationApplyVO;
import com.zyxy.common.vo.ArbitrationCaseListVO;
import com.zyxy.common.vo.ArbitratorCaseBaseInfoVO;
import com.zyxy.common.vo.CaseAmountVO;
import com.zyxy.common.vo.CaseApproveVO;
import com.zyxy.common.vo.CaseArbitrationPersonnelInfoVO;
import com.zyxy.common.vo.CaseCommProgressInfoVO;
import com.zyxy.common.vo.CaseManagerVO;
import com.zyxy.common.vo.CaseProgressListVO;
import com.zyxy.common.vo.EvidenceVO;
import com.zyxy.common.vo.ProgressContentVO;


/**
 * 仲裁委serviceImpl
 *
 */
@Service
public class ArbitrationCaseImpl implements ArbitrationCaseService {

	@Autowired
	CaseInfoMapper caseInfoMapper;

	@Autowired
	ManagerInfoMapper managerInfoMapper;

	@Autowired
	ArbitrationCaseHandleMapper caseHandleMapper;
	
	@Autowired
	CaseDocMapper caseDocMapper;
	
	@Autowired
	CaseDocContentMapper caseDocContentMapper;
	
	@Autowired
	ApproveTypeService approveTypeService;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	/**
	 * 仲裁委案件列表查询
	 */
	private BusiExecuteResult<PageInfo<ArbitrationCaseListVO>> queryArbitrationCaseList(
			ArbitrationCaseListDTO formData) {
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		return BusiExecuteResult.builderSuccessResult(new PageInfo<ArbitrationCaseListVO>(caseInfoMapper.queryArbitrationCaseList(formData)));
	}

	/**
	 * 业务验证，验证仲裁委工作人员的状态
	 * @param userId
	 * @return
	 */
	@Override
	public BusiValidResult queryArbitrationCaseBusiValid(String userId) {
		//根据user_info表中的数据查询出仲裁委的信息
		ManagerInfo managerInfo = managerInfoMapper.queryDutiesAndStatusByPrimaryKey(userId);
		
		if(managerInfo!=null){
			/*
			 * 0-正常返回成功
			 * 非0返回失败，并带上失败信息
			 */
			if(ManagerInfoStatusEnum.NORMAL.getCode().equals(managerInfo.getStatus())){
				return BusiValidResult.builderSuccessResult();
			}
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.ACCOUNT_ERROR);
		}
		return BusiValidResult.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		
	}

	/**
	 * 业务处理
	 * @param formData
	 * @return
	 */
	@Override
	public BusiExecuteResult<PageInfo<ArbitrationCaseListVO>> queryArbitrationCaseBusiExecute(ArbitrationCaseListDTO formData) {
		return this.queryArbitrationCaseList(formData);
	}
	
	@Override
	public BusiExecuteResult<ArbitrationCaseArbitrationApplyVO> queryCaseArbitrationRequestInfoBusiExecute(String caseId,String userId,String requestFlag) {
		String currentApproveType = RequestTypeEnum.REQUEST.getValue().equals(requestFlag)
				? ApproveTypeEnum.INITIATE_APPROVAL.getTypeName() : ApproveTypeEnum.COUNTERCLAIM_APPROVAL.getTypeName();
		
		ArbitrationCaseArbitrationApplyVO caseArbitrationApply=new ArbitrationCaseArbitrationApplyVO();
		
		//案件进展
		List<CaseProgressListVO> caseProgress=caseInfoMapper.queryCaseProgress(caseId,requestFlag);
		//将审批类型改为对应的文字显示
		String approveType=null;
		for (int i = 0; i < caseProgress.size(); i++) {
			if(caseProgress.get(i).getProgressCont().size()==0){
				ProgressContentVO cont=new ProgressContentVO();
				cont.setMark(CaseApproveStatusEnum.WAIT_AUDIT.getRemark());
				caseProgress.get(i).getProgressCont().add(cont);
			}
			approveType=caseProgress.get(i).getApproveType();
			String remark=null;
			for (ApproveTypeEnum approveStatus : ApproveTypeEnum.values()) {
				String value=approveStatus.getTypeName();
				if(StringUtil.isNotEmpty(approveType) && value.equals(approveType)){
					remark=approveStatus.getTypeValue();
					break;
				}
			}
			caseProgress.get(i).setApproveType(remark);
		}
		caseArbitrationApply.setProgressList(caseProgress);
		
		
		//案件基本信息
		ArbitratorCaseBaseInfoVO caseBaseInfo=caseInfoMapper.queryArbitrationCaseInfo(caseId, requestFlag);
		caseArbitrationApply.setCaseBaseInfo(caseBaseInfo);
		
		//案件证据
		List<EvidenceVO> evidences=caseInfoMapper.queryEvdences(caseId,requestFlag,CaseMatTypeEnum.REQUEST_EVIDENCE.getCode());
		caseArbitrationApply.setEvidences(evidences);
	
		//案件审批记录
		List<ApproveRecordVO> approveRecords=caseInfoMapper.queryApproveRecords(caseId,currentApproveType);
		
		//查询出案件的审批信息
		List<CaseApproveVO> caseApproveVoList = caseApproveMapper.selectApproveByCaseId(caseId,userId);
		
		caseArbitrationApply.setDuties(managerInfoMapper.queryDutiesByUserId(userId));

		caseArbitrationApply.setCaseApproveVoList(caseApproveVoList);
		
		//讲职位数字表示转换成对应的文字显示
		String duties=null;
		for(int i=0;i<approveRecords.size();i++){
			String mark=null;
			duties=approveRecords.get(i).getDuties();
			for(ManagerInfoTypeEnum managerDuties:ManagerInfoTypeEnum.values()){
				if(StringUtil.isNotEmpty(duties) && managerDuties.getCode().equals(duties)){
					mark=managerDuties.getMark();
					break;
				}
			}
			approveRecords.get(i).setDuties(mark);
		}
		caseArbitrationApply.setApproveRecords(approveRecords);
		
		//案件金额相关 
		CaseAmountVO caseAmount=caseInfoMapper.queryCaseAmount(caseId,requestFlag);
		caseArbitrationApply.setCaseAmount(caseAmount);
		
		//案件详情左侧仲裁信息
		CaseArbitrationPersonnelInfoVO arbiInfo=new CaseArbitrationPersonnelInfoVO();
		CaseInfo caseInfo=caseInfoMapper.selectByPrimaryKey(caseId);
		List<CaseManagerVO> caseManger=caseInfoMapper.queryCaseArbiInfo(caseId);
		String name=null;
		for (int i = 0; i < caseManger.size(); i++) {
			duties=caseManger.get(i).getDuties();
			name=caseManger.get(i).getName();
			ManagerInfoTypeEnum managerDuties =ManagerInfoTypeEnum.getCode(duties);
			switch(managerDuties){
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
		
		arbiInfo.setCaseNo(caseInfo.getCaseNo());
		arbiInfo.setRegisterTime(caseInfo.getRegisterTime());
		
		caseArbitrationApply.setArbiInfo(arbiInfo);
		
		CaseCommProgressInfoVO caseProgressInfo=caseInfoMapper.queryCaseCommProgressInfo(caseId);
		caseArbitrationApply.setCaseProgressInfo(caseProgressInfo);
		
		
		return BusiExecuteResult.builderSuccessResult(caseArbitrationApply);
	}

}
