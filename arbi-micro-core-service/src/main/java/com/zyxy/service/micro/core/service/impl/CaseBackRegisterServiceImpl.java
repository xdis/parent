package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.CaseApprove;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.CaseRequestInfo;
import com.zyxy.common.domain.CaseRequestInfoExample;
import com.zyxy.common.domain.CaseRequestInfoWithBLOBs;
import com.zyxy.common.dto.BackRegisterCaseDTO;
import com.zyxy.common.dto.CaseEvidenceDTO;
import com.zyxy.common.enums.AgentFlagEnum;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.CaseApproveStatusEnum;
import com.zyxy.common.enums.CaseDocStatusEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.EvidenceTypeEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.ManagerInfoStatusEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.CaseAgentMapper;
import com.zyxy.common.mapper.CaseApproveMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseManagerMapper;
import com.zyxy.common.mapper.CaseMatMapper;
import com.zyxy.common.mapper.CaseRequestInfoMapper;
import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.DocHeadVO;
import com.zyxy.service.micro.core.service.CaseBackRegisterService;
import com.zyxy.service.micro.core.service.CommonService;

/**
 * 反请求Service实现
 *
 */
@Service
public class CaseBackRegisterServiceImpl implements CaseBackRegisterService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CaseRequestInfoMapper caseRequestInfoMapper;

	@Autowired
	private CaseMatMapper caseMatMapper;
	
	@Autowired 
	private CaseInfoMapper caseInfoMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseApproveMapper caseApproveMapper;
	
	@Autowired
	private CaseDocMapper caseDocMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CaseManagerMapper caseManagerMapper;
	
	@Autowired
	private ApproveTypeService approveTypeService;
	

	@Override
	public BusiValidResult caseBackRegisterBusiValid(
			BackRegisterCaseDTO formData) {
		//案件是否存在
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
		if (caseInfo==null) {
			return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
		}
		//当前案件是否已经有反请求
		CaseRequestInfoExample caseRequestInfoExample = new CaseRequestInfoExample();
		caseRequestInfoExample.
			createCriteria().
				andCaseIdEqualTo(formData.getCaseId()).
					andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue());
		List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectByExample(caseRequestInfoExample);
		if (caseRequestInfos.size()>0) {
			return BusiValidResult.builderErrorResult(Coder.CASE_ALREADY_HAS_BACK_REQUEST);
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> caseBackRegisterBusiExecute(
			BackRegisterCaseDTO formData) {
		LitigantTypeEnum enums =commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getCreaterId());
		if (LitigantTypeEnum.DEFENDANT_AGENT.getValue().equals(enums.getValue())) {
			formData.setAngentFlag(AgentFlagEnum.AGENT.getValue());
		}else if (LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			formData.setAngentFlag(AgentFlagEnum.SELF.getValue());
		}
		Date date = new Date();
		 //插入请求表
        CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
        String requestId = sequenceService.getCommonID();
        caseRequestInfo.setId(requestId);
        caseRequestInfo.setCaseId(formData.getCaseId());
        caseRequestInfo.setAcceptanceNo(formData.getAcceptanceNo());
        caseRequestInfo.setRequestType(RequestTypeEnum.BACK_REQUEST.getValue());
        caseRequestInfo.setAgentFlag(formData.getAngentFlag());
        caseRequestInfo.setArbClaim(formData.getArbClaim());
        caseRequestInfo.setFact(formData.getFact());
//      caseRequestInfo.setReason(formData.getReason());
        caseRequestInfo.setCreaterId(formData.getCreaterId());
        caseRequestInfo.setCreateTime(date);
//        caseRequestInfo.setStatus(status);
        caseRequestInfoMapper.insertSelective(caseRequestInfo);
        //插入案件材料
     /*   for (CaseAttachmentDTO attachment : formData.getCaseAttachments()) {
            if (attachment.getAttachName().lastIndexOf(".") != -1) {
                attachment.setDocType(attachment.getAttachName().substring(attachment.getAttachName().lastIndexOf(".")+1));
            }
        }*/
        //插入证据
        if (null!=formData.getCaseEvidences()) {
        	for (CaseEvidenceDTO evidence : formData.getCaseEvidences()) {
        		evidence.setId(sequenceService.getCommonID());
        	}
        	caseMatMapper.insertEvidence(formData.getCaseEvidences(),RequestTypeEnum.BACK_REQUEST.getValue(), formData.getCaseId(), caseRequestInfo.getId(),EvidenceTypeEnum.DEFENDANT.getValue());
		}
//      caseMatMapper.insertAttachment(formData.getCaseAttachments(),RequestTypeEnum.BACK_REQUEST.getValue(), formData.getCaseId(), caseRequestInfo.getId());
		
		//查询当前审批人
		String userId = caseManagerMapper.queryArbitrationUserId(formData.getCaseId(), ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(),ManagerInfoStatusEnum.NORMAL.getCode());
		
		//查询审批类型
		ApproveType key=new ApproveType();
		key.setTypeName(ApproveTypeEnum.COUNTERCLAIM_APPROVAL.getTypeName());
		approveTypeService.selectCacheByPrimaryKey(key);
		

		//反请求审批记录
		CaseApprove approve = new CaseApprove();
		approve.setId(sequenceService.getCommonID());
		approve.setCaseId(formData.getCaseId());
		approve.setRequestId(requestId);
		approve.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
		approve.setBusiId(requestId);
		approve.setApproveType(key.getTypeName());
		approve.setCreaterId(formData.getCreaterId());
		approve.setCreateTime(date);
		approve.setApproveUserId(userId);
		caseApproveMapper.insertSelective(approve);
		
		//反请求申请书
		CaseDoc caseDoc = new CaseDoc();
		caseDoc.setId(sequenceService.getCommonID());
		caseDoc.setDocType(CaseDocTypeEnum.DE_REQUEST_APPLICATION_ARBITRATION_BOOK.getCode());
		caseDoc.setDocName(CaseDocTypeEnum.DE_REQUEST_APPLICATION_ARBITRATION_BOOK.getDocName());
		//签章状态待定
		caseDoc.setCaseId(formData.getCaseId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定
		caseDoc.setCreaterId(formData.getCreaterId());
		caseDoc.setCreateTime(date);
		caseDocMapper.insertSelective(caseDoc);
		
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult docHeadValid(String caseId, String userId) {
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		//验证
		return BusiValidResult.builderSuccessResult();
	}
	
	
	@Override
	public BusiExecuteResult<DocHeadVO> docHeadExecute(String caseId, String userId) {
		DocHeadVO docVO = caseInfoMapper.selectDocHead(caseId);
		return BusiExecuteResult.builderSuccessResult(docVO);
	}

}
