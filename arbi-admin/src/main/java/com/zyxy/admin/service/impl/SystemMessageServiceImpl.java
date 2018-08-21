package com.zyxy.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.SystemMessageService;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.domain.MessageUser;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.enums.MessageStatusEnum;
import com.zyxy.common.mapper.MessageRecordMapper;
import com.zyxy.common.mapper.MessageUserMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;

@Service
public class SystemMessageServiceImpl implements SystemMessageService {
	
	@Autowired
	private MessageUserMapper messageUserMapper;
	
	@Autowired
	private MessageRecordMapper messageRecordMapper;

	/**
	 * 查询消息列表
	 */
	@Override
	public PageInfo<MessageRecordListVO> queryMessageList(MessageRecordListDTO formData) {
		if (formData.getPageNum() == null || formData.getPageNum() < 1) {
			formData.setPageNum(1);
		}
		if (formData.getPageSize() == null || formData.getPageSize() < 1
				|| formData.getPageSize() > 1000) {
			formData.setPageSize(10);
		}
		PageHelper.startPage(formData.getPageNum(), formData.getPageSize());
		
		List<MessageRecordListVO> messageList = messageUserMapper
				.queryMessageList(formData);
		
		return new PageInfo<MessageRecordListVO>(messageList);
	}

	/**
	 * 查询消息详情业务验证
	 */
	@Override
	public BusiValidResult messageInfoBusiValid(Integer id, String userId) {
		//消息是否存在
		MessageUser messageUser =messageUserMapper
				.selectMessageByMessageIdAndUserId(id, userId);

		if (messageUser == null){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}

		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 查询消息详情业务处理
	 * @return 
	 */
	@Override
	public BusiExecuteResult<MessageRecord> messageInfoExecute(Integer id, String userId) {
		MessageRecord messageRecord = messageRecordMapper.selectByPrimaryKey(id);
		
		//消息状态更新成已读状态
		int ums = messageUserMapper.updateMessageStatus(id, userId);
		if (ums < 0) {
			return BusiExecuteResult
					.builderErrorResult(ApiResultVO.Coder.DB_UPDATE_ERROR);
		}
		
		return BusiExecuteResult.builderSuccessResult(messageRecord);
	}

	/**
	 * 查询未读的消息数量
	 * @param userId
	 * @return 
	 */
	@Override
	public int queryUnreadMessages(String userId) {
		int count = messageUserMapper.queryUnreadMessages(
				userId, MessageStatusEnum.UN_READED.getCode());
		return count;
	}

}
