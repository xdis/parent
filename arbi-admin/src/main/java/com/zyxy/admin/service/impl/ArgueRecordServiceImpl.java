package com.zyxy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.ArgueRecordService;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.domain.ArgueRecordExample;
import com.zyxy.common.mapper.ArgueRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

/**
 * 辩论
 */
@Service
public class ArgueRecordServiceImpl implements ArgueRecordService {
	
	@Autowired
	private ArgueRecordMapper argueRecordMapper;

	/**
	 * 查询辩论记录列表
	 * @param caseId
	 * @return
	 */
	@Override
	public BusiExecuteResult<List<ArgueRecord>> argueRecordList(String caseId) {
		ArgueRecordExample example = new ArgueRecordExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<ArgueRecord> argueRecords = argueRecordMapper.selectByExampleWithBLOBs(example);
		if (argueRecords.size()==0) {
			BusiExecuteResult
				.builderErrorResult(ApiResultVO.Coder.DB_NOTFOUND_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult(argueRecords);
	}
	
}
