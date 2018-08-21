package com.zyxy.service.micro.third.service;

import com.zyxy.common.domain.SignCreateOrganizationLog;

public interface SignCreateOrganizationLogService {
    int save(SignCreateOrganizationLog organizationLog);

    int updateStatus(String id, int status);

    int updateStatus(String id, int status, String errorInfo);

    SignCreateOrganizationLog getById(String id);
}
