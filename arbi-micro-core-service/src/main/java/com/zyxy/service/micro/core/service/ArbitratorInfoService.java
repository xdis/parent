package com.zyxy.service.micro.core.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArbitratorInfo;
import com.zyxy.common.domain.ArbitratorInfoExample;
import com.zyxy.common.dto.ArbitratorChangeProfileDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorBaseInfoVO;
import com.zyxy.common.vo.ArbitratorPersonalInfoVO;

import java.util.List;


/**
 * 仲裁员服务信息模块
 *
 * @author tanquan
 */
public interface ArbitratorInfoService {

    public int countByExample(ArbitratorInfoExample example);

    public int deleteByExample(ArbitratorInfoExample example);

    public int deleteByPrimaryKey(String id);

    public int insert(ArbitratorInfo record);

    public int insertSelective(ArbitratorInfo record);

    public List<ArbitratorInfo> selectByExample(ArbitratorInfoExample example);

    public ArbitratorInfo selectByPrimaryKey(String id);

    public int updateByExampleSelective(ArbitratorInfo record, ArbitratorInfoExample example);

    public int updateByExample(ArbitratorInfo record, ArbitratorInfoExample example);

    public int updateByPrimaryKeySelective(ArbitratorInfo record);

    public int updateByPrimaryKey(ArbitratorInfo record);

    /**
     * 分页查询仲裁员信息
     *
     * @param page     当前页
     * @param pageSize 页面大小
     * @param example  查询条件
     * @return
     */
    PageInfo<ArbitratorInfo> selectPagedByExample(Integer page, Integer pageSize, ArbitratorInfoExample example);

    /**
     * 查询仲裁员个人信息业务处理
     *
     * @param arbitratorId 仲裁员id
     * @return
     */
    BusiExecuteResult<ArbitratorPersonalInfoVO> arbitratorPersonalInfoBusiExecute(String arbitratorId);

    /**
     * 查询仲裁员基本信息业务处理
     *
     * @param arbitratorId
     * @return
     */
    BusiExecuteResult<ArbitratorBaseInfoVO> arbitratorBaseInfoBusiExecute(String arbitratorId);

    /**
     * 仲裁员申请修改信息业务验证
     *
     * @param formData
     * @return
     */
    BusiValidResult arbitratorChangeBusiValid(ArbitratorChangeProfileDTO formData);

    /**
     * 仲裁员申请修改信息业务处理
     *
     * @param formData
     * @return
     */
    BusiExecuteResult arbitratorChangeBusiExecute(ArbitratorChangeProfileDTO formData);

}
