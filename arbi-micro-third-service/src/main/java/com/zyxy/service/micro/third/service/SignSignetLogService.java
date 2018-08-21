package com.zyxy.service.micro.third.service;

import com.zyxy.common.domain.SignSignetLog;
import com.zyxy.common.domain.SignSignetLogWithBLOBs;

public interface SignSignetLogService {
    int save(SignSignetLogWithBLOBs signSignetLogWithBLOBs);

    int updateByPrimaryKeySelective(SignSignetLogWithBLOBs signSignetLogWithBLOBs);

    int updateSignSignetStatus(String applyNo, int status);

    int updateRecordNo(String applyNo, String recordNo);

    SignSignetLog getById(String signSignetLogId);
}
