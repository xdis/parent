package com.zyxy.common.mapper;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.PayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderMapper {

    /**
     * pay_order
     * @mbggenerated
     */
    int countByExample(PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    int deleteByExample(PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * pay_order
     * @mbggenerated
     */
    int insert(PayOrder record);

    /**
     * pay_order
     * @mbggenerated
     */
    int insertSelective(PayOrder record);

    /**
     * pay_order
     * @mbggenerated
     */
    List<PayOrder> selectByExampleWithBLOBs(PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    List<PayOrder> selectByExample(PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    PayOrder selectByPrimaryKey(String id);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PayOrder record,
            @Param("example") PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") PayOrder record,
            @Param("example") PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByExample(@Param("record") PayOrder record,
            @Param("example") PayOrderExample example);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayOrder record);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(PayOrder record);

    /**
     * pay_order
     * @mbggenerated
     */
    int updateByPrimaryKey(PayOrder record);
}