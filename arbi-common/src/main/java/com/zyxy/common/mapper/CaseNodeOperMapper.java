package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseNodeOper;
import com.zyxy.common.domain.CaseNodeOperExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseNodeOperMapper {
    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int countByExample(CaseNodeOperExample example);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int deleteByExample(CaseNodeOperExample example);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int insert(CaseNodeOper record);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int insertSelective(CaseNodeOper record);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    List<CaseNodeOper> selectByExample(CaseNodeOperExample example);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    CaseNodeOper selectByPrimaryKey(String id);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseNodeOper record, @Param("example") CaseNodeOperExample example);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseNodeOper record, @Param("example") CaseNodeOperExample example);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseNodeOper record);

    /**
     * case_node_oper
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseNodeOper record);

    /**
     * 根据案件id和主流程查询出计划结束时间
     * @param caseId
     * @param currentMainNode
     * @return
     */
    Date selectPlanEndTimeDateByCaseId(@Param("caseId") String caseId, @Param("currentMainNode") Integer currentMainNode);

    Date selectPlanEndTimeByCaseId(@Param("caseId") String caseId, @Param("currentMainNode")String currentMainNode);

}