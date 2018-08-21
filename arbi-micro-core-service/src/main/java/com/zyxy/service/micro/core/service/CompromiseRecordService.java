package com.zyxy.service.micro.core.service;

import java.util.List;

import com.zyxy.common.dto.CompromiseRecordInsertDTO;
import com.zyxy.common.dto.CompromiseRecordListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CompromiseRecordVO;

/**
 * 和解记录Service
 */
public interface CompromiseRecordService {
	
	/**
	 * 案件和解记录沟通
	 * @param formData
	 * @return
	 */
	List<CompromiseRecordVO> list(CompromiseRecordListDTO formData);
	
	/**
	 * 发送和解消息业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult compromiseSendValid(CompromiseRecordInsertDTO formData);
	
	/**
	 * 发送和解消息业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<List<CompromiseRecordVO>> compromiseSendExecute(CompromiseRecordInsertDTO formData);
	
	
}
