package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorExample;
import com.zyxy.common.domain.CaseArbitratorOper;
import com.zyxy.common.vo.CaseArbitratorTribunalVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseArbitratorMapper {
    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int countByExample(CaseArbitratorExample example);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int deleteByExample(CaseArbitratorExample example);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int insert(CaseArbitrator record);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int insertSelective(CaseArbitrator record);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    List<CaseArbitrator> selectByExample(CaseArbitratorExample example);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    CaseArbitrator selectByPrimaryKey(Integer id);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseArbitrator record, @Param("example") CaseArbitratorExample example);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseArbitrator record, @Param("example") CaseArbitratorExample example);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseArbitrator record);

    /**
     * case_arbitrator
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseArbitrator record);

    int allotArbitrator(String caseId);

    /**
     * 插入仲裁员选择记录
     *
     * @param caseArbitratorOper
     * @return
     */
    int insertCaseArbiOper(CaseArbitratorOper caseArbitratorOper);

    /**
     * 查询仲裁员Id
     *
     * @param caseId
     * @return
     */
    String queryAllotArbitrator(String caseId);

    /**
     * 查询仲裁员Id
     *
     * @param caseId
     * @return
     */
    CaseArbitrator queryCaseNowArbitratorByCaseId(String caseId);

    /**
     * 根据案件id查询出仲裁员名字以及组庭通知书发放时间
     * @param caseId
     * @return
     */
    CaseArbitratorTribunalVO selectArbitratorNameAndCreateTime(@Param("caseId")String caseId);
    
    /**
     * 查询仲裁员接受案件的类型(主任分配/双方共同选定)
     * @param arbitratorId 仲裁员id
     * @param caseId 案件id
     * @return 结案类型
     */
    String queryArbitratorAcceptType(@Param("arbitratorId")String arbitratorId,@Param("caseId")String caseId);

    /**
     * 查询选择过的仲裁员Id
     *
     * @param caseId 案件Id
     * @return 仲裁员Id列表
     */
    List<String> queryBothAgreement(String caseId);
}
