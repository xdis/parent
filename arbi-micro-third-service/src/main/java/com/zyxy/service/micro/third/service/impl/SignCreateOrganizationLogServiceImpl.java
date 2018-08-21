package com.zyxy.service.micro.third.service.impl;

import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.mapper.SignCreateOrganizationLogMapper;
import com.zyxy.service.micro.third.service.SignCreateOrganizationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignCreateOrganizationLogServiceImpl implements SignCreateOrganizationLogService {

    @Autowired
    private SignCreateOrganizationLogMapper mapper;

    @Override
    public int save(SignCreateOrganizationLog organizationLog) {
        return mapper.insert(organizationLog);
    }

    @Override
    public int updateStatus(String id, int status) {
        return updateStatus(id, status, null);
    }

    @Override
    public int updateStatus(String id, int status, String errorInfo) {
        SignCreateOrganizationLog updateStatus = new SignCreateOrganizationLog();
        updateStatus.setStatus(status);
        updateStatus.setErrorInfo(errorInfo);
        updateStatus.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(updateStatus);
    }

    @Override
    public SignCreateOrganizationLog getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
