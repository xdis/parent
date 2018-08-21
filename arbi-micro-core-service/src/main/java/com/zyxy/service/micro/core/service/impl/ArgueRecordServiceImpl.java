package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.domain.ArgueRecordExample;
import com.zyxy.common.domain.CaseDoc;
import com.zyxy.common.domain.CaseDocExample;
import com.zyxy.common.dto.ArgueRecordInsertDTO;
import com.zyxy.common.enums.ArgueSendTypeEnum;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.mapper.ArgueRecordMapper;
import com.zyxy.common.mapper.CaseDocMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.service.micro.core.service.ArgueRecordService;
import com.zyxy.service.micro.core.service.CommonService;

@Service
public class ArgueRecordServiceImpl implements ArgueRecordService {
	
	@Autowired
	private ArgueRecordMapper argueRecordMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CaseDocMapper caseDocMapper;
	
	@Autowired
	private CommonService commonService;
	

	@Override
	public BusiValidResult argueInsertValid(ArgueRecordInsertDTO formData) {
		/*if (ArgueSendTypeEnum.ARBITRATOR.getValue().equals(formData.getSendType())) {
			CaseDocExample example = new CaseDocExample();
			example.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andDocTypeEqualTo(CaseDocTypeEnum.TRIBUNAL_NOTICE.getCode());
			List<CaseDoc> caseDocs = caseDocMapper.selectByExample(example);
			if (caseDocs.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_CAN_NOT_ARGUE);
			}
		}*/
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<List<ArgueRecord>> argueInsertExecute(
			ArgueRecordInsertDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		ArgueRecord record = new ArgueRecord();
		record.setId(sequenceService.getCommonID());
		record.setCaseId(formData.getCaseId());
		record.setSendType(enums.getValue());
		record.setCreaterId(formData.getUserId());
		record.setContent(formData.getContent());
		record.setCreateTime(new Date());
		int rows = argueRecordMapper.insertSelective(record);
		
		ArgueRecordExample example = new ArgueRecordExample();
		example.createCriteria().andCaseIdEqualTo(formData.getCaseId());
		List<ArgueRecord> argueRecords = argueRecordMapper.selectByExampleWithBLOBs(example);
		if (argueRecords.size()==0) {
			BusiExecuteResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		return rows>0?BusiExecuteResult.builderSuccessResult(argueRecords):
			BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}

	@Override
	public BusiExecuteResult<List<ArgueRecord>> argueRecordList(String caseId) {
		ArgueRecordExample example = new ArgueRecordExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<ArgueRecord> argueRecords = argueRecordMapper.selectByExampleWithBLOBs(example);
		if (argueRecords.size()==0) {
			BusiExecuteResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult(argueRecords);
	}

}
