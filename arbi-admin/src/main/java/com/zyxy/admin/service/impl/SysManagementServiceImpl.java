package com.zyxy.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.SysManagementService;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.dto.SysMessageRecordDTO;
import com.zyxy.common.mapper.MessageRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 系统管理serviceImpl
 */
@Service
public class SysManagementServiceImpl implements SysManagementService {

    @Autowired
    private MessageRecordMapper messageRecordMapper;


    /**
     * 查询系统消息列表业务处理
     * @param formData
     * @return
     */
    @Override
    public BusiExecuteResult<PageInfo<MessageRecord>> queryMessageRecordListBusiExecute(SysMessageRecordDTO formData) {
        PageInfo<MessageRecord> pageInfo = this.queryMessageRecordList(formData);
        return BusiExecuteResult.builderSuccessResult(pageInfo);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public BusiExecuteResult<MessageRecord> queryMessageRecordDetailBusiExecuteResult(Integer id) {
        MessageRecord messageRecord = messageRecordMapper.selectByPrimaryKey(id);
        return BusiExecuteResult.builderSuccessResult(messageRecord);
    }


    /**
     * 查询系统消息列表
     * @param formData
     * @return
     */
    private PageInfo<MessageRecord> queryMessageRecordList(SysMessageRecordDTO formData) {

        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1
                || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
        return new PageInfo<MessageRecord>(messageRecordMapper.selectMessageList(formData));
    }
}
