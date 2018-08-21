package com.zyxy.admin.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.AdjudicationAmendmentRecordWithBLOBs;
import com.zyxy.common.dto.AdjudicationAmendmentDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.AmendmentContentVO;
/**
 * 仲裁委-裁决补正接口
 */
public interface AdjudicationAmendmentService {
	/**
	 * 查询裁决补正书业务执行
	 * @param approveId 审批id
	 * @param userId 用户id
	 * @return 业务执行结果
	 */
	BusiExecuteResult<AmendmentContentVO> queryAdjudicationAmendment(String approveId,String userId);
	
	/**
	 * 更新裁决补正书业务执行
	 * @param formData 裁决补正书处理对象
	 * @return 
	 */
	BusiExecuteResult updateAdjudicationAmendment(AdjudicationAmendmentDTO formData);

	/**
	 * 查询补正信息记录
	 * @param formData 
	 * @return
	 */
	AmendmentContentVO queryAdjudicationAmendmentByCaseId(AdjudicationAmendmentDTO formData);

	/**
	 * 仲裁委-查询出具裁决补正书
	 * @param formData 
	 * @return
	 */
	BusiExecuteResult<AmendmentContentVO> selectAdjudicationAmendment(AdjudicationAmendmentDTO formData);

}
