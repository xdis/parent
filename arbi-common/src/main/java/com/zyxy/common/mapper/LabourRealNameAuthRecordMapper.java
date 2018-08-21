package com.zyxy.common.mapper;

import com.zyxy.common.domain.LabourRealNameAuthRecord;
import com.zyxy.common.domain.LabourRealNameAuthRecordExample;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.vo.CaseListVO;
import com.zyxy.common.vo.RealUserAuditVO;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LabourRealNameAuthRecordMapper {
    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int countByExample(LabourRealNameAuthRecordExample example);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int deleteByExample(LabourRealNameAuthRecordExample example);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int insert(LabourRealNameAuthRecord record);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int insertSelective(LabourRealNameAuthRecord record);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    List<LabourRealNameAuthRecord> selectByExample(LabourRealNameAuthRecordExample example);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    LabourRealNameAuthRecord selectByPrimaryKey(String id);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LabourRealNameAuthRecord record, @Param("example") LabourRealNameAuthRecordExample example);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LabourRealNameAuthRecord record, @Param("example") LabourRealNameAuthRecordExample example);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LabourRealNameAuthRecord record);

    /**
     * labour_real_name_auth_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LabourRealNameAuthRecord record);
    
    
    /**
     *  PC端查询用户身份审核列表
     * @param formData
     * @return 用户身份审核列表
     */
    List<RealUserAuditVO> queryRealUserAuditList(UserAuditDTO formData);
    
    
    /**
     * 将审核的结果更新到用户身份审核记录表
     * @param id 用户身份审核Id
     * @param status 审核状态
     * @param currentOwner 当前责任人
     * @param auditTime 审批时间
     * @return
     */
    int updateUserAudit(@Param("id") String id,@Param("status") String status,@Param("currentOwner") String currentOwner,@Param("auditTime") Date auditTime);
}