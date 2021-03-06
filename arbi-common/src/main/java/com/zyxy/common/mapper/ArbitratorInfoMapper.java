package com.zyxy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyxy.common.domain.ArbitratorInfo;
import com.zyxy.common.domain.ArbitratorInfoExample;
import com.zyxy.common.dto.ArbitratorEnquiriesDTO;
import com.zyxy.common.dto.ArbitratorInfoUpdateDTO;
import com.zyxy.common.vo.ArbitratorBaseInfoVO;
import com.zyxy.common.vo.ArbitratorInfoAduitVO;
import com.zyxy.common.vo.ArbitratorInformationVO;
import com.zyxy.common.vo.ArbitratorListVO;
import com.zyxy.common.vo.ArbitratorPersonalInfoVO;
import com.zyxy.common.vo.LitigantArbitratorInfoVO;

public interface ArbitratorInfoMapper {

    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int countByExample(ArbitratorInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int deleteByExample(ArbitratorInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int insert(ArbitratorInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int insertSelective(ArbitratorInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	List<ArbitratorInfo> selectByExample(ArbitratorInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	ArbitratorInfo selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ArbitratorInfo record,
			@Param("example") ArbitratorInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ArbitratorInfo record,
			@Param("example") ArbitratorInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(ArbitratorInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table arbitrator_info
	 * @mbggenerated
	 */
	int updateByPrimaryKey(ArbitratorInfo record);

	/**
     * 查询仲裁员个人信息
     * @param arbitratorId 仲裁员id
     * @return 仲裁员个人信息
     */
    ArbitratorPersonalInfoVO queryArbitratorPersonalInfo(String arbitratorId);
    
    /**
     * 查询仲裁员基本信息
     * @param arbitratorId 仲裁员id
     * @return 仲裁员基本信息
     */
    ArbitratorBaseInfoVO queryArbitratorBaseInfo(String arbitratorId);
    
    /**
     * 当事人端当前仲裁员
     * @param caseId
     * @return
     */
    LitigantArbitratorInfoVO selectArbitratorInfoByCaseId(String caseId);

    List<ArbitratorListVO> queryArbitrationList();
    
    /**
     * 查询仲裁委端，仲裁员信息列表
     * @param formData
     * @return
     */
    List<ArbitratorInformationVO> queryArbitratorInLists(ArbitratorEnquiriesDTO formData);
    
    /**
     * 将仲裁员加入黑名单
     * @param id 仲裁员Id
     * @return
     */
    int updateArbitratorDisable(@Param("id") String id);
    
    
    /**
     * 查询仲裁员审核信息
     * @param id 仲裁员Id
     * @return
     */
    ArbitratorInfoAduitVO queryArbitratorAudit(@Param("id") String id);
    
    /**
     * 将仲裁员最新信息更新到仲裁员表
     * @param formData
     * @return
     */
    int updateArbitratorInfo(ArbitratorInfoUpdateDTO formData);
    
    /**
     * 更新删除状态或黑名单状态
     * @param formData
     * @return
     */
    int updateStatus(ArbitratorInfoUpdateDTO formData);

}