package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.DelegateService;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.AuthDelegateDTO;
import com.zyxy.common.enums.CommonStatus;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DelegateServiceImpl implements DelegateService {
	@Autowired
	private AuthorizationDelegateMapper authorizationDelegateMapper;
	@Autowired
	private SequenceService sequenceService;

	
	@Override
	public BusiExecuteResult<List<AuthorizationDelegate>> queryDelegateByUserId(String userId) {
		AuthorizationDelegateExample authorizationDelegateExample = new AuthorizationDelegateExample();
		authorizationDelegateExample.createCriteria()
				.andUserIdEqualTo(userId);
		List<AuthorizationDelegate> delegateList = authorizationDelegateMapper.selectByExample(authorizationDelegateExample);

		return BusiExecuteResult.builderSuccessResult(delegateList);
	}


	/**
	 * 添加授权
	 * @param dto
	 * @return
	 */
	@Override
	public BusiExecuteResult addAuthDelegate(AuthDelegateDTO dto){
		String[] approveTypeIdArr = dto.getApproveTypeIds().split(",");
		Map<String,Object> params = new HashMap<String,Object>();
		ArrayList<Map<String, Object>> authTypeList = new ArrayList<>();;
		for (String atId:approveTypeIdArr) {
			Map<String,Object> authType = new HashMap<String,Object>();
			authType.put("id",sequenceService.getCommonID());
			authType.put("atId",atId);
			authTypeList.add(authType);
		}
		params.put("authTypeList",authTypeList);
		params.put("userId",dto.getUserId());
		params.put("delegateUserId",dto.getDelegateUserId());
		params.put("startDate",dto.getStartDate());
		params.put("endDate",dto.getEndDate());
		params.put("status", CommonStatus.STATUS_TRUE.getValue());
		authorizationDelegateMapper.addAuthorizationDelegate(params);
		return BusiExecuteResult.builderSuccessResult();
	}
}
