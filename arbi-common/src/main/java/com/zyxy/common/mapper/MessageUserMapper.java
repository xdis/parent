package com.zyxy.common.mapper;

import com.zyxy.common.domain.MessageUser;
import com.zyxy.common.domain.MessageUserExample;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.vo.MessageRecordListVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageUserMapper {
    /**
     * message_user
     *
     * @mbggenerated
     */
    int countByExample(MessageUserExample example);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int deleteByExample(MessageUserExample example);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int insert(MessageUser record);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int insertSelective(MessageUser record);

    /**
     * message_user
     *
     * @mbggenerated
     */
    List<MessageUser> selectByExample(MessageUserExample example);

    /**
     * message_user
     *
     * @mbggenerated
     */
    MessageUser selectByPrimaryKey(Integer id);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MessageUser record, @Param("example") MessageUserExample example);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MessageUser record, @Param("example") MessageUserExample example);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MessageUser record);

    /**
     * message_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MessageUser record);

    /**
     * 根据用户id和消息id修改消息状态
     * @param id
     * @param userId
     * @return
     */
    int updateMessageStatus(@Param("id") int id,@Param("userId")String userId);

    /**
     * 根据用户一键删除消息
     * @param userId
     * @return
     */
    int deleteAllmessageByUserId(String userId);

    /**
     * 根据消息ID和用户ID删除信息
     * @param messageId
     * @param userId
     * @return
     */
    int deleteMessageByMessageIdAndUserId(@Param("messageId") Integer messageId,@Param("userId") String userId);

    /**
     * 插入message_user(全部用户)
     * @param messageUser
     * @return
     */
    int insertMessagerUsers(MessageUser messageUser);
    
    /**
     * 插入message_ser(仲裁员)
     * @param messageUser
     * @return
     */
    int insertMessagerUsersArbi(MessageUser messageUser);
    
    /**
     * 插入message_ser(申请人)
     * @param messageUser
     * @return
     */
    int insertMessagerUsersProp(MessageUser messageUser);
    
    /**
     * 插入message_ser(被申请人)
     * @param messageUser
     * @return
     */
    int insertMessagerUsersDenf(MessageUser messageUser);
    
    /**
     * 插入message_ser(代理)
     * @param messageUser
     * @return
     */
    int insertMessagerUsersAgent(MessageUser messageUser);

    /**
     * 根据消息ID和用户ID查询消息
     * @param messageId
     * @param userId
     * @return
     */
    MessageUser selectMessageByMessageIdAndUserId(@Param("messageId") int messageId,@Param("userId") String userId);

    /**
     * 根据用户id查询消息
     * @param formData
     */
    List<MessageRecordListVO> queryMessageList(MessageRecordListDTO formData);

    /**
     * 查询未读消息的数量
     * @param userId
     * @param status 消息状态
     */
	int queryUnreadMessages(@Param("userId") String userId, @Param("status") String status);

}