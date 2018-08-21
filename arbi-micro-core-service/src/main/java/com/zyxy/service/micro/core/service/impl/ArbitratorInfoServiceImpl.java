package com.zyxy.service.micro.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArbitratorChangeProfileRecord;
import com.zyxy.common.domain.ArbitratorChangeProfileRecordExample;
import com.zyxy.common.domain.ArbitratorInfo;
import com.zyxy.common.domain.ArbitratorInfoExample;
import com.zyxy.common.dto.ArbitratorChangeProfileDTO;
import com.zyxy.common.mapper.ArbitratorChangeProfileRecordMapper;
import com.zyxy.common.mapper.ArbitratorInfoMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorBaseInfoVO;
import com.zyxy.common.vo.ArbitratorPersonalInfoVO;
import com.zyxy.service.micro.core.service.ArbitratorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author tanquan
 */
@Service
public class ArbitratorInfoServiceImpl implements ArbitratorInfoService {

    @Autowired
    private ArbitratorInfoMapper mapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private ArbitratorChangeProfileRecordMapper arbitratorChangeProfileRecordMapper;

    @Override
    public int countByExample(ArbitratorInfoExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArbitratorInfoExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArbitratorInfo record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(ArbitratorInfo record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<ArbitratorInfo> selectByExample(ArbitratorInfoExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public ArbitratorInfo selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ArbitratorInfo record,
                                        ArbitratorInfoExample example) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(ArbitratorInfo record,
                               ArbitratorInfoExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ArbitratorInfo record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ArbitratorInfo record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<ArbitratorInfo> selectPagedByExample(Integer page, Integer pageSize,
                                                         ArbitratorInfoExample example) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (pageSize == null || pageSize < 1 || pageSize > 1000) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(this.selectByExample(example));
    }

    @Override
    public BusiExecuteResult<ArbitratorPersonalInfoVO> arbitratorPersonalInfoBusiExecute(
            String arbitratorId) {
        return BusiExecuteResult.builderSuccessResult(mapper.queryArbitratorPersonalInfo(arbitratorId));
    }

    @Override
    public BusiExecuteResult<ArbitratorBaseInfoVO> arbitratorBaseInfoBusiExecute(
            String arbitratorId) {
        ArbitratorBaseInfoVO baseVO = mapper.queryArbitratorBaseInfo(arbitratorId);
        baseVO.setName(StringUtil.hiddenLastName(baseVO.getName()));
        baseVO.setPhone(StringUtil.phoneNumStarFormat(baseVO.getPhone()));
        baseVO.setTotalMoney(100.56d);
        return BusiExecuteResult.builderSuccessResult(baseVO);
    }

    @Override
    public BusiValidResult arbitratorChangeBusiValid(ArbitratorChangeProfileDTO formData) {
        ArbitratorChangeProfileRecordExample example = new ArbitratorChangeProfileRecordExample();
        example.createCriteria()
                .andCreaterIdEqualTo(formData.getUserId())
                .andStatusEqualTo("0");
        List<ArbitratorChangeProfileRecord> arbitratorChangeProfileRecords = arbitratorChangeProfileRecordMapper.selectByExample(example);
        if (arbitratorChangeProfileRecords != null && arbitratorChangeProfileRecords.size() > 0) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.CHANGE_INFO_APPING);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult arbitratorChangeBusiExecute(ArbitratorChangeProfileDTO formData) {
        ArbitratorChangeProfileRecord record = new ArbitratorChangeProfileRecord();
        record.setAddress(formData.getAddress());
        record.setCreaterId(formData.getUserId());
        record.setCreateTime(new Date());
        record.setId(sequenceService.getCommonID());
        record.setIdCard(formData.getIdCard());
        record.setJob(formData.getJob());
        record.setSpeciality(formData.getSpeciality());
        record.setStatus("0");
        arbitratorChangeProfileRecordMapper.insertSelective(record);
        return BusiExecuteResult.builderSuccessResult();
    }
}
