package com.zyxy.common.mapper;

import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.domain.CompromiseApplyExample;
import java.util.List;

import com.zyxy.common.vo.CaseCompromiseApplyVO;
import com.zyxy.common.vo.ComproiseApplyVO;
import org.apache.ibatis.annotations.Param;

public interface CompromiseApplyMapper {
    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int countByExample(CompromiseApplyExample example);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int deleteByExample(CompromiseApplyExample example);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int insert(CompromiseApply record);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int insertSelective(CompromiseApply record);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    List<CompromiseApply> selectByExample(CompromiseApplyExample example);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    CompromiseApply selectByPrimaryKey(String id);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CompromiseApply record, @Param("example") CompromiseApplyExample example);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CompromiseApply record, @Param("example") CompromiseApplyExample example);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompromiseApply record);

    /**
     * compromise_apply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CompromiseApply record);

    /**
     * 根据id查询出和解申请
     * @param caseId
     * @return
     */
    ComproiseApplyVO queryComproiseApply(String caseId);

    /**
     * 根据案件ID查询和解申请信息
     * @param compromiseApply
     * @return
     */
    CompromiseApply selectCompromiseByCaseId(CompromiseApply compromiseApply);


    List<CaseCompromiseApplyVO> queryCaseComproiseApply(@Param("caseId") String caseId);
}