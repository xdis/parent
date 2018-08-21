package com.zyxy.admin.service;

import java.util.List;

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.service.BusiExecuteResult;

public interface ArgueRecordService {

	/**
	 * 查询辩论记录列表
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<List<ArgueRecord>> argueRecordList(String caseId);

}
