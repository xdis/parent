package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseArbitratorApprove;
import com.zyxy.common.domain.CaseArbitratorApproveExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseArbitratorApproveMapper {
    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int countByExample(CaseArbitratorApproveExample example);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int deleteByExample(CaseArbitratorApproveExample example);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int insert(CaseArbitratorApprove record);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int insertSelective(CaseArbitratorApprove record);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    List<CaseArbitratorApprove> selectByExample(CaseArbitratorApproveExample example);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    CaseArbitratorApprove selectByPrimaryKey(String id);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseArbitratorApprove record, @Param("example") CaseArbitratorApproveExample example);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseArbitratorApprove record, @Param("example") CaseArbitratorApproveExample example);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseArbitratorApprove record);

    /**
     * case_arbitrator_approve
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseArbitratorApprove record);
}