package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;

public interface SystemMessageService {

	/**
	 * 查询消息列表
	 */
	PageInfo<MessageRecordListVO> queryMessageList(MessageRecordListDTO formData);

	/**
	 * 查询消息详情业务验证
	 */
	BusiValidResult messageInfoBusiValid(Integer id, String userId);

	/**
	 * 查询消息详情业务处理
	 */
	BusiExecuteResult<MessageRecord> messageInfoExecute(Integer id,
			String userId);
	
	/**
	 * 查询未读的消息数量
	 * @param userId
	 * @return 
	 */
	int queryUnreadMessages(String userId);
	
}
