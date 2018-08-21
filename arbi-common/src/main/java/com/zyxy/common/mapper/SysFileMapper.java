package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysFile;
import com.zyxy.common.domain.SysFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileMapper {

    /**
     * sys_file
     * @mbggenerated
     */
    int countByExample(SysFileExample example);

    /**
     * sys_file
     * @mbggenerated
     */
    int deleteByExample(SysFileExample example);

    /**
     * sys_file
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_file
     * @mbggenerated
     */
    int insert(SysFile record);

    /**
     * sys_file
     * @mbggenerated
     */
    int insertSelective(SysFile record);

    /**
     * sys_file
     * @mbggenerated
     */
    List<SysFile> selectByExample(SysFileExample example);

    /**
     * sys_file
     * @mbggenerated
     */
    SysFile selectByPrimaryKey(String id);

    /**
     * sys_file
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysFile record,
            @Param("example") SysFileExample example);

    /**
     * sys_file
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysFile record,
            @Param("example") SysFileExample example);

    /**
     * sys_file
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysFile record);

    /**
     * sys_file
     * @mbggenerated
     */
    int updateByPrimaryKey(SysFile record);
}