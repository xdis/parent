package com.zyxy.common.mapper;

import com.zyxy.common.domain.WithdrawRecord;
import com.zyxy.common.domain.WithdrawRecordExample;
import com.zyxy.common.domain.WithdrawRecordWithBLOBs;
import com.zyxy.common.vo.ArbitrationCaseWithdrawApplyVO;
import com.zyxy.common.vo.WithdrawApplyDocVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WithdrawRecordMapper {
    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int countByExample(WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int deleteByExample(WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int insert(WithdrawRecordWithBLOBs record);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int insertSelective(WithdrawRecordWithBLOBs record);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    List<WithdrawRecordWithBLOBs> selectByExampleWithBLOBs(WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    List<WithdrawRecord> selectByExample(WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    WithdrawRecordWithBLOBs selectByPrimaryKey(String id);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WithdrawRecordWithBLOBs record, @Param("example") WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") WithdrawRecordWithBLOBs record, @Param("example") WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WithdrawRecordWithBLOBs record);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(WithdrawRecordWithBLOBs record);

    /**
     * withdraw_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WithdrawRecord record);
    
    /**
     * 查询撤案-申请书内容
     * @param caseId 案件id`
     * @return
     */
    ArbitrationCaseWithdrawApplyVO queryCaseWithdrawApplyContent(@Param("caseId")String caseId,@Param("requestFlag")String requestFlag);
  
    /**
     * 查询撤案-申请书内容
     * @param caseId
     * @param requestType
     * @return
     */
    WithdrawApplyDocVO selectWithdrawApplyDoc(@Param("caseId")String caseId,@Param("requestFlag")String requestType);
}