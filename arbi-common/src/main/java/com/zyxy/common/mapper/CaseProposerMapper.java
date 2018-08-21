package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseProposer;
import com.zyxy.common.domain.CaseProposerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseProposerMapper {
    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int countByExample(CaseProposerExample example);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int deleteByExample(CaseProposerExample example);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int insert(CaseProposer record);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int insertSelective(CaseProposer record);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    List<CaseProposer> selectByExample(CaseProposerExample example);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    CaseProposer selectByPrimaryKey(String id);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseProposer record, @Param("example") CaseProposerExample example);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseProposer record, @Param("example") CaseProposerExample example);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseProposer record);

    /**
     * case_proposer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseProposer record);
    
    /**
     * 根据案件id查询
     * @param caseId
     */
	CaseProposer selectCaseProposerByCaseId(String caseId);


}