package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseArbitralAwardsDraft;
import com.zyxy.common.domain.CaseArbitralAwardsDraftExample;
import com.zyxy.common.domain.CaseArbitralAwardsDraftWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseArbitralAwardsDraftMapper {
    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int countByExample(CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int deleteByExample(CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int insert(CaseArbitralAwardsDraftWithBLOBs record);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int insertSelective(CaseArbitralAwardsDraftWithBLOBs record);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    List<CaseArbitralAwardsDraftWithBLOBs> selectByExampleWithBLOBs(CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    List<CaseArbitralAwardsDraft> selectByExample(CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseArbitralAwardsDraftWithBLOBs record, @Param("example") CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseArbitralAwardsDraftWithBLOBs record, @Param("example") CaseArbitralAwardsDraftExample example);

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseArbitralAwardsDraft record, @Param("example") CaseArbitralAwardsDraftExample example);
}