package com.zyxy.common.mapper;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.ApproveTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApproveTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int countByExample(ApproveTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int deleteByExample(ApproveTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int insert(ApproveType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int insertSelective(ApproveType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    List<ApproveType> selectByExample(ApproveTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ApproveType record, @Param("example") ApproveTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table approve_type
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ApproveType record, @Param("example") ApproveTypeExample example);

    ApproveType selectByPrimaryKey(ApproveType approveType);


}