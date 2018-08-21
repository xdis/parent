package com.zyxy.common.mapper;

import com.zyxy.common.domain.PayRLItems;
import com.zyxy.common.domain.PayRLItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRLItemsMapper {

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int countByExample(PayRLItemsExample example);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int deleteByExample(PayRLItemsExample example);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int insert(PayRLItems record);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int insertSelective(PayRLItems record);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    List<PayRLItems> selectByExample(PayRLItemsExample example);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    PayRLItems selectByPrimaryKey(String id);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PayRLItems record,
            @Param("example") PayRLItemsExample example);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int updateByExample(@Param("record") PayRLItems record,
            @Param("example") PayRLItemsExample example);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayRLItems record);

    /**
     * pay_rl_items
     * @mbggenerated
     */
    int updateByPrimaryKey(PayRLItems record);
}