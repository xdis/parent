package com.zyxy.service.micro.core.service.impl;

import java.util.Date;

import com.zyxy.common.domain.MessageUserExample;
import com.zyxy.common.enums.DeletedFlag;
import com.zyxy.common.enums.MessageReceiveTypeEnum;
import com.zyxy.common.enums.MessageStatusEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.MessageCenterVO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.domain.MessageUser;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.mapper.MessageRecordMapper;
import com.zyxy.common.mapper.MessageUserMapper;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;
import com.zyxy.service.micro.core.service.MessageService;

/**
 * 消息处理实现类
 *
 */
@Service
public class MessageServiceImpl implements MessageService {


	@Autowired
	private MessageRecordMapper messageRecordMapper;
	
	@Autowired
	private MessageUserMapper messageUserMapper; 
	
	@Autowired
	private SequenceService sequenceService;

	/**
	 * 查询消息列表
	 * @param dto
	 * @return
	 */
	@Override
	public MessageCenterVO queryMessageList(MessageRecordListDTO dto) {
		MessageUserExample example = new MessageUserExample();
		example.createCriteria()
				.andStatusEqualTo(MessageStatusEnum.UN_READED.getCode())
				.andDelFlagEqualTo(DeletedFlag.NO.getValue())
				.andUserIdEqualTo(dto.getUserId());
		int count = messageUserMapper.countByExample(example);
		if (dto.getPageNum() == null || dto.getPageNum() < 1) {
			dto.setPageNum(1);
        }
        if (dto.getPageSize() == null || dto.getPageSize() < 1 || dto.getPageSize() > 1000) {
            dto.setPageSize(10);
        }
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		MessageCenterVO result = new MessageCenterVO();
		result.setUnReadNum(count);
		result.setList(new PageInfo<MessageRecordListVO>(messageRecordMapper.selectMessageRecordList(dto)));
		return result;
	}

	/**
	 * 消息详情验证
	 * @param id
	 * @param userId
	 * @return
	 */
	@Override
	public BusiValidResult messageInfoBusiValid(Integer id, String userId) {

		//消息是否存在
		MessageUser messageUser =messageUserMapper.selectMessageByMessageIdAndUserId(id,userId);

		if (messageUser == null){
			return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
		}

		return BusiValidResult.builderSuccessResult();
	}

	/**
	 * 查询消息详情
	 * @param id
	 * @param userId
	 * @return
	 */
	@Override
	public BusiExecuteResult<MessageInfoVO> messageInfoExecute(int id,String userId) {
		MessageInfoVO messageInfoVO = messageRecordMapper.selectMessageRecordById(id);
		messageUserMapper.updateMessageStatus(id, userId);
		return BusiExecuteResult.builderSuccessResult(messageInfoVO);
	}

	/**
	 * 更改信息状态
	 * @param id
	 * @param userId
	 * @return
	 */
	@Override
	public int updateMessageStatus(int id,String userId) {
		return messageUserMapper.updateMessageStatus(id, userId);
	}

	/**
	 * 一键删除
	 * @param userId
	 * @return
	 */
	@Override
	public int deleteAllMessages(String userId) {
		return messageUserMapper.deleteAllmessageByUserId(userId);
	}

	/**
	 * 根据消息ID用户ID删除单条消息
	 * @param messageId
	 * @param userId
	 * @return
	 */
	@Override
	public int deleteMessage(Integer messageId,String userId){

		return messageUserMapper.deleteMessageByMessageIdAndUserId(messageId,userId);
	}

	/**
	 * 发送消息
	 * @param formData
	 * @return
	 */
	@Override
	public BusiExecuteResult<String> addMessage(MessageInsertDTO formData){
		
		MessageRecord messageRecord = new MessageRecord();
		messageRecord.setTitle(formData.getTitle());
		messageRecord.setMessageBody(formData.getMessageBody());
		messageRecord.setReleaseType(formData.getReleaseType());
		messageRecord.setCreaterId(formData.getCreaterId());
		messageRecord.setCreateTime(new Date());
		
		int rows = messageRecordMapper.insertMessageRecord(messageRecord);
		int count = 0;
		if (rows>0) {
			MessageUser messageUser = new MessageUser();
			messageUser.setMessageId(messageRecord.getId());
			messageUser.setCreaterId(formData.getCreaterId());
			messageUser.setCreateTime(new Date());
			messageUser.setStatus(MessageStatusEnum.UN_READED.getCode());
			messageUser.setDelFlag(DeletedFlag.NO.getValue());
			if (MessageReceiveTypeEnum.PROPOSER.getValue().equals(formData.getReleaseType())) {
				count = messageUserMapper.insertMessagerUsersProp(messageUser);
			}else if (MessageReceiveTypeEnum.DEFENDANT.getValue().equals(formData.getReleaseType())) {
				count = messageUserMapper.insertMessagerUsersDenf(messageUser);
			}else if (MessageReceiveTypeEnum.AGENT.getValue().equals(formData.getReleaseType())) {
				count = messageUserMapper.insertMessagerUsersAgent(messageUser);
			}else if (MessageReceiveTypeEnum.ARBTRATOR.getValue().equals(formData.getReleaseType())) {
				count = messageUserMapper.insertMessagerUsersArbi(messageUser);
			} else if(MessageReceiveTypeEnum.ALL.getValue().equals(formData.getReleaseType())) {
				count = messageUserMapper.insertMessagerUsers(messageUser);
			}
		}
		return count>0?BusiExecuteResult.builderSuccessResult():BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
	}
}
