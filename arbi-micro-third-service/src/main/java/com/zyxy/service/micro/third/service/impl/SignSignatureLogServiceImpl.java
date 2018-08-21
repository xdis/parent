package com.zyxy.service.micro.third.service.impl;

import com.zyxy.common.domain.SignSignatureLog;
import com.zyxy.common.mapper.SignSignatureLogMapper;
import com.zyxy.service.micro.third.service.SignSignatureLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanquan
 */
@Service
public class SignSignatureLogServiceImpl implements SignSignatureLogService {

    @Autowired
    private SignSignatureLogMapper mapper;

    @Override
    public int save(SignSignatureLog signSignatureLog) {
        return mapper.insert(signSignatureLog);
    }

    @Override
    public int updateByPrimaryKeySelective(SignSignatureLog signSignatureLog) {
        return mapper.updateByPrimaryKeySelective(signSignatureLog);
    }

    @Override
    public SignSignatureLog getById(String signSignatureLogId) {
        return mapper.selectByPrimaryKey(signSignatureLogId);
    }
}
