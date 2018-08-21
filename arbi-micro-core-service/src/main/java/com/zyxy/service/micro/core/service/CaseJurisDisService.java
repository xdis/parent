package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CaseJurisDisInsertDTO;
import com.zyxy.common.dto.JurisDisFeedBackDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 申请管辖权异议service
 */
public interface CaseJurisDisService {
	
	BusiExecuteResult<String> insertCaseJurisDis(CaseJurisDisInsertDTO formData);
	
	
	BusiValidResult jurisDisFeedBackValid(JurisDisFeedBackDTO formData);
	
	BusiExecuteResult<String> jurisDisFeedBackExecute(JurisDisFeedBackDTO formData);
	

}
