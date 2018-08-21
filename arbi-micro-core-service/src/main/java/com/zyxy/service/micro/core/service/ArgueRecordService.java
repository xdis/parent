package com.zyxy.service.micro.core.service;

import java.util.List;

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.ArgueRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 辩论Service
 */
public interface ArgueRecordService {
	
	/**
	 * 辩论记录增加业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult argueInsertValid(ArgueRecordInsertDTO formData);
	
	/**
	 * 辩论记录增加业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<List<ArgueRecord>> argueInsertExecute(ArgueRecordInsertDTO formData);
	
	/**
	 * 查询辩论记录列表
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<List<ArgueRecord>> argueRecordList(String caseId);
}
