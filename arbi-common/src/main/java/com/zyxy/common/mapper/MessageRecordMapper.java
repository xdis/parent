package com.zyxy.common.mapper;

import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.domain.MessageRecordExample;
import java.util.List;

import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.dto.SysMessageRecordDTO;
import com.zyxy.common.vo.MessageInfoVO;
import com.zyxy.common.vo.MessageRecordListVO;
import org.apache.ibatis.annotations.Param;

public interface MessageRecordMapper {
    /**
     * message_record
     *
     * @mbggenerated
     */
    int countByExample(MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int deleteByExample(MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int insert(MessageRecord record);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int insertSelective(MessageRecord record);

    /**
     * message_record
     *
     * @mbggenerated
     */
    List<MessageRecord> selectByExampleWithBLOBs(MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    List<MessageRecord> selectByExample(MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    MessageRecord selectByPrimaryKey(Integer id);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MessageRecord record);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(MessageRecord record);

    /**
     * message_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MessageRecord record);

    /**
     * 查询消息列表
     * @param dto
     * @return
     */
    List<MessageRecordListVO> selectMessageRecordList(MessageRecordListDTO dto);

    /**
     * 根据消息ID查询消息
     * @param id
     * @return
     */
    MessageInfoVO selectMessageRecordById(int id);

    /**
     * 插入消息
     * @param messageRecord
     * @return
     */
    int insertMessageRecord(MessageRecord messageRecord);

    /**
     * 查询消息列表
     * @param formData
     * @return
     */
    List<MessageRecord> selectMessageList(SysMessageRecordDTO formData);
}