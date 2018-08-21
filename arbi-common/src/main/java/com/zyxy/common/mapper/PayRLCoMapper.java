package com.zyxy.common.mapper;

import com.zyxy.common.domain.PayRLCo;
import com.zyxy.common.domain.PayRLCoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRLCoMapper {

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int countByExample(PayRLCoExample example);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int deleteByExample(PayRLCoExample example);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int insert(PayRLCo record);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int insertSelective(PayRLCo record);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    List<PayRLCo> selectByExample(PayRLCoExample example);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    PayRLCo selectByPrimaryKey(String id);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PayRLCo record,
            @Param("example") PayRLCoExample example);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int updateByExample(@Param("record") PayRLCo record,
            @Param("example") PayRLCoExample example);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayRLCo record);

    /**
     * pay_rl_co
     * @mbggenerated
     */
    int updateByPrimaryKey(PayRLCo record);
}