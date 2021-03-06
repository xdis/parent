package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseAgent;
import com.zyxy.common.domain.CaseAgentExample;

import java.util.List;

import com.zyxy.common.vo.AgentAuthorDataVO;
import com.zyxy.common.vo.CaseAgentVO;
import com.zyxy.common.vo.doc.CaseDocAgentVO;

import org.apache.ibatis.annotations.Param;

public interface CaseAgentMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int countByExample(CaseAgentExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int deleteByExample(CaseAgentExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int insert(CaseAgent record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int insertSelective(CaseAgent record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	List<CaseAgent> selectByExample(CaseAgentExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	CaseAgent selectByPrimaryKey(Integer id);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") CaseAgent record,
			@Param("example") CaseAgentExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") CaseAgent record,
			@Param("example") CaseAgentExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(CaseAgent record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_agent
	 * @mbggenerated
	 */
	int updateByPrimaryKey(CaseAgent record);


	/*****手动添加的方法****/

    List<CaseAgentVO> queryAgentByCaseId(String CaseId);


    CaseAgent selectAgentByCaseId(CaseAgent caseAgent);

    /**
     * 根据案件id查询
     * @param caseAgent 
     */
    CaseAgentVO selectCaseAgentByCaseId(CaseAgent caseAgent);
    
    //根据案件ID查出申请人代理人名称职务和被申请人代理人名称职务
    List<CaseAgentVO> selectAgentName(@Param("caseId") String caseId);
    
    /**
     * 根据userId 查询用户信息
     * @param userId
     * @return
     */
    CaseDocAgentVO selectAgentInfo(@Param("userId") String userId);
    
    AgentAuthorDataVO selectAgentAuthorData(@Param("caseId") String caseId,@Param("requestType") String requestType);
}