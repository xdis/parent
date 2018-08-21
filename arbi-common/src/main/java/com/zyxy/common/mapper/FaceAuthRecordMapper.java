package com.zyxy.common.mapper;

import com.zyxy.common.domain.FaceAuthRecord;
import com.zyxy.common.domain.FaceAuthRecordExample;
import com.zyxy.common.domain.FaceAuthRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaceAuthRecordMapper {
    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int countByExample(FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int deleteByExample(FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int insert(FaceAuthRecordWithBLOBs record);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int insertSelective(FaceAuthRecordWithBLOBs record);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    List<FaceAuthRecordWithBLOBs> selectByExampleWithBLOBs(FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    List<FaceAuthRecord> selectByExample(FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    FaceAuthRecordWithBLOBs selectByPrimaryKey(String id);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FaceAuthRecordWithBLOBs record, @Param("example") FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") FaceAuthRecordWithBLOBs record, @Param("example") FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FaceAuthRecord record, @Param("example") FaceAuthRecordExample example);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FaceAuthRecordWithBLOBs record);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(FaceAuthRecordWithBLOBs record);

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FaceAuthRecord record);
}