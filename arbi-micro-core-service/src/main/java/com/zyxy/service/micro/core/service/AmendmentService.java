package com.zyxy.service.micro.core.service;


import com.zyxy.common.dto.AdjudiAmendRecordAuditDTO;
import com.zyxy.common.dto.AdjudiAmendRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
public interface AmendmentService {

    /**
     * 案件补正信息业务验证
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult amendmentInfoBusiValid(String caseId, String userId);
    
	/**
	 * 查询指定案件补正列表
	 * @param caseId 案件ID
	 * @return 指定案件补正列表
	 */
	BusiExecuteResult amendmentInfoBusiExecute(String caseId);
	
	/**
	 * 补正申请业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult adjudicationAmendmentInsertValid(AdjudiAmendRecordInsertDTO formData);

	/**
	 * 补正申请业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> adjudicationAmendmentInsertExecute(AdjudiAmendRecordInsertDTO formData);
	
	/**
	 * 仲裁员修正审核业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult adjudicationAmendmentAuditValid(AdjudiAmendRecordAuditDTO formData);
	
	/**
	 * 仲裁员修正审核业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> adjudicationAmendmentAuditExecute(AdjudiAmendRecordAuditDTO formData);
}
