package com.zyxy.service.micro.third.service;

import com.zyxy.common.domain.SignSignatureLog;

public interface SignSignatureLogService {
    int save(SignSignatureLog signSignatureLog);

    int updateByPrimaryKeySelective(SignSignatureLog signSignatureLog);

    SignSignatureLog getById(String signSignatureLogId);
}
