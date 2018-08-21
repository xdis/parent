package com.zyxy.common.mapper;

import com.zyxy.common.domain.EnterpriseAuthRecord;
import com.zyxy.common.domain.EnterpriseAuthRecordExample;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.vo.MethodAuditVO;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EnterpriseAuthRecordMapper {
    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int countByExample(EnterpriseAuthRecordExample example);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int deleteByExample(EnterpriseAuthRecordExample example);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int insert(EnterpriseAuthRecord record);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int insertSelective(EnterpriseAuthRecord record);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    List<EnterpriseAuthRecord> selectByExample(EnterpriseAuthRecordExample example);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") EnterpriseAuthRecord record, @Param("example") EnterpriseAuthRecordExample example);

    /**
     * enterprise_auth_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") EnterpriseAuthRecord record, @Param("example") EnterpriseAuthRecordExample example);

    /**
     * 查询要审核的法人列表
     * @param formData
     */
    List<MethodAuditVO> queryArbiCaseList(UserAuditDTO formData);

    /**
     * 审核法人
     * @param id	审核法人id
     * @param status	状态
     * @return
     */
	int updateMethodAudit(@Param("id") String id, @Param("status") String status);

	/**
	 * 查询法人信息
	 * @param id
	 * @param status
	 * @return
	 */
	EnterpriseAuthRecord selectEnterpriseAuthRecordByStatus(@Param("id") String id, @Param("status") String status);

}