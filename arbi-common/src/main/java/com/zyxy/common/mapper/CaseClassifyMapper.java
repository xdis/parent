package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseClassify;
import com.zyxy.common.domain.CaseClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseClassifyMapper {
    /**
     * case_classify
     *
     * @mbggenerated
     */
    int countByExample(CaseClassifyExample example);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int deleteByExample(CaseClassifyExample example);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int insert(CaseClassify record);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int insertSelective(CaseClassify record);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    List<CaseClassify> selectByExample(CaseClassifyExample example);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    CaseClassify selectByPrimaryKey(Integer id);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseClassify record, @Param("example") CaseClassifyExample example);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseClassify record, @Param("example") CaseClassifyExample example);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseClassify record);

    /**
     * case_classify
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseClassify record);
}