package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseTurnsOfflineRecord;
import com.zyxy.common.domain.CaseTurnsOfflineRecordExample;
import com.zyxy.common.vo.ApproveRecordVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseTurnsOfflineRecordMapper {
    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int countByExample(CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int insert(CaseTurnsOfflineRecord record);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseTurnsOfflineRecord record);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    List<CaseTurnsOfflineRecord> selectByExampleWithBLOBs(CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    List<CaseTurnsOfflineRecord> selectByExample(CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    CaseTurnsOfflineRecord selectByPrimaryKey(String id);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseTurnsOfflineRecord record, @Param("example") CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseTurnsOfflineRecord record, @Param("example") CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseTurnsOfflineRecord record, @Param("example") CaseTurnsOfflineRecordExample example);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseTurnsOfflineRecord record);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(CaseTurnsOfflineRecord record);

    /**
     * case_turns_offline_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseTurnsOfflineRecord record);

    /**
     * 根据案件id查询案件转线下记录信息
     * @param caseId
     */
    CaseTurnsOfflineRecord queryTurnsOffline(@Param("caseId") String caseId);

    /**
     *	根据案件id查询审批记录列表
     * @param caseId
     */
	List<ApproveRecordVO> queryApproveSuggestByApproveId(@Param("approveId") String approveId);
}