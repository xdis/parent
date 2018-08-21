package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseNoSeq;
import com.zyxy.common.domain.CaseNoSeqExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseNoSeqMapper {
    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int countByExample(CaseNoSeqExample example);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int deleteByExample(CaseNoSeqExample example);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int insert(CaseNoSeq record);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int insertSelective(CaseNoSeq record);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    List<CaseNoSeq> selectByExample(CaseNoSeqExample example);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    CaseNoSeq selectByPrimaryKey(String id);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseNoSeq record, @Param("example") CaseNoSeqExample example);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseNoSeq record, @Param("example") CaseNoSeqExample example);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseNoSeq record);

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseNoSeq record);

    /**
     * 生成一个序号
     *
     * @param seq 主键Id
     * @return
     */
    int generaCaseNo(@Param("seq") String seq);

    /**
     * 根据caseId查询
     *
     * @param caseId
     * @return
     */
    CaseNoSeq queryCaseNoByCsaeId(String caseId);
}