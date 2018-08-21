package com.zyxy.common.mapper;

import com.zyxy.common.domain.LitigantAgent;
import com.zyxy.common.domain.LitigantAgentExample;
import com.zyxy.common.vo.LitigantAgentRelationVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LitigantAgentMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int countByExample(LitigantAgentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int deleteByExample(LitigantAgentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int insert(LitigantAgent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int insertSelective(LitigantAgent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	List<LitigantAgent> selectByExample(LitigantAgentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	LitigantAgent selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") LitigantAgent record,
			@Param("example") LitigantAgentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") LitigantAgent record,
			@Param("example") LitigantAgentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(LitigantAgent record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table litigant_agent
	 * @mbggenerated
	 */
	int updateByPrimaryKey(LitigantAgent record);

	/**
     * 查询当事人代理列表
     * @param userId
     * @return
     */
    List<LitigantAgentRelationVO> selectLitigantAgentRelations(String userId);
}