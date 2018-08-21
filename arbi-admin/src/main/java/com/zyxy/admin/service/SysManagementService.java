package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.dto.SysMessageRecordDTO;
import com.zyxy.common.service.BusiExecuteResult;

/**
 * 系统管理service
 */
public interface SysManagementService {

    /**
     * 查询系统消息列表
     * @param formData
     * @return
     */
    BusiExecuteResult<PageInfo<MessageRecord>> queryMessageRecordListBusiExecute(SysMessageRecordDTO formData);

    /**
     * 查询系统消息详情业务处理
     * @param id
     * @return
     */
    BusiExecuteResult<MessageRecord> queryMessageRecordDetailBusiExecuteResult(Integer id);
}
