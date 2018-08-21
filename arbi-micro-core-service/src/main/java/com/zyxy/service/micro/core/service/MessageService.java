package com.zyxy.service.micro.core.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.MessageCenterVO;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;

/**
 * 消息处理接口
 *
 */
public interface MessageService{
	
	/**
	 * 查询消息列表
	 * @param dto
	 * @return
	 */
	MessageCenterVO queryMessageList(MessageRecordListDTO dto);
	
	/**
	 * 查询消息详情
	 * @param id
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<MessageInfoVO> messageInfoExecute(int id, String userId);

	/**
	 * 消息详情验证
	 * @param id
	 * @param userId
	 * @return
	 */
	BusiValidResult messageInfoBusiValid(Integer id, String userId);
	
	/**
	 * 更改信息状态
	 * @param id
	 * @param userId
	 * @return
	 */
	int updateMessageStatus(int id, String userId);
	
	/**
	 * 一键删除
	 * @param userId
	 * @return
	 */
	int deleteAllMessages(String userId);

	/**
	 * 根据消息ID用户ID删除单条消息
	 * @param messageId
	 * @param userId
	 * @return
	 */
	int deleteMessage(Integer messageId,String userId);
	
	/**
	 * 发送消息
	 * @param messageInsertDTO
	 * @return
	 */
	BusiExecuteResult<String> addMessage(MessageInsertDTO messageInsertDTO);
	
}
