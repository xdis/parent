package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseDefendant;
import com.zyxy.common.domain.CaseDefendantExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseDefendantMapper {
    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int countByExample(CaseDefendantExample example);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int deleteByExample(CaseDefendantExample example);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int insert(CaseDefendant record);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int insertSelective(CaseDefendant record);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    List<CaseDefendant> selectByExample(CaseDefendantExample example);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseDefendant record, @Param("example") CaseDefendantExample example);

    /**
     * case_defendant
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseDefendant record, @Param("example") CaseDefendantExample example);

    /**
     * 根据案件id查询
     */
	CaseDefendant selectCaseDefendantByCaseId(String caseId);
}