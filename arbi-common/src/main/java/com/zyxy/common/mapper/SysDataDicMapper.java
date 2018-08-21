package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysDataDic;
import com.zyxy.common.domain.SysDataDicExample;
import com.zyxy.common.domain.SysDataDicKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDataDicMapper {

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int countByExample(SysDataDicExample example);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int deleteByExample(SysDataDicExample example);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int deleteByPrimaryKey(SysDataDicKey key);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int insert(SysDataDic record);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int insertSelective(SysDataDic record);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    List<SysDataDic> selectByExample(SysDataDicExample example);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    SysDataDic selectByPrimaryKey(SysDataDicKey key);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysDataDic record,
            @Param("example") SysDataDicExample example);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysDataDic record,
            @Param("example") SysDataDicExample example);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysDataDic record);

    /**
     * sys_data_dic
     * @mbggenerated
     */
    int updateByPrimaryKey(SysDataDic record);
}