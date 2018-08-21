package com.zyxy.admin.service;

import com.zyxy.common.domain.AuthorizationDelegate;
import com.zyxy.common.dto.AuthDelegateDTO;
import com.zyxy.common.service.BusiExecuteResult;

import java.util.List;

public interface DelegateService {
    BusiExecuteResult<List<AuthorizationDelegate>> queryDelegateByUserId(String userId);

    BusiExecuteResult addAuthDelegate(AuthDelegateDTO dto);

}
