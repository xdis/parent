package com.zyxy.common.mapper;

import com.zyxy.common.domain.AgentAuthorityRef;
import com.zyxy.common.domain.AgentAuthorityRefExample;
import java.util.List;

import com.zyxy.common.vo.MenuVO;
import org.apache.ibatis.annotations.Param;

public interface AgentAuthorityRefMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int countByExample(AgentAuthorityRefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int deleteByExample(AgentAuthorityRefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int insert(AgentAuthorityRef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int insertSelective(AgentAuthorityRef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    List<AgentAuthorityRef> selectByExample(AgentAuthorityRefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    AgentAuthorityRef selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgentAuthorityRef record, @Param("example") AgentAuthorityRefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgentAuthorityRef record, @Param("example") AgentAuthorityRefExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgentAuthorityRef record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_authority_ref
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgentAuthorityRef record);

    List<MenuVO> selectAuthoByAgent(AgentAuthorityRef agentAuthorityRef);
}