package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;

/**
 * 回避service
 */
public interface CaseAvoidRecordService {

    /**
     * 新增回避业务处理
     * @param formData
     * @return
     */
    Boolean insertCaseAvoidRecordBusiExecute(CaseAvoidRecordInsertDTO formData);
}
