package com.zyxy.service.micro.third.service.impl;

import com.zyxy.common.domain.SignSignetLog;
import com.zyxy.common.domain.SignSignetLogExample;
import com.zyxy.common.domain.SignSignetLogWithBLOBs;
import com.zyxy.common.mapper.SignSignetLogMapper;
import com.zyxy.service.micro.third.service.SignSignetLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author tanquan
 */
@Service
public class SignSignetLogServiceImpl implements SignSignetLogService {

    @Autowired
    private SignSignetLogMapper mapper;

    @Override
    public int save(SignSignetLogWithBLOBs signSignetLogWithBLOBs) {
        return mapper.insert(signSignetLogWithBLOBs);
    }

    @Override
    public int updateByPrimaryKeySelective(SignSignetLogWithBLOBs signSignetLogWithBLOBs) {
        return mapper.updateByPrimaryKeySelective(signSignetLogWithBLOBs);
    }

    @Override
    public int updateSignSignetStatus(String applyNo, int status) {
        SignSignetLogWithBLOBs updateSignetLog = new SignSignetLogWithBLOBs();
        updateSignetLog.setStatus(status);
        updateSignetLog.setUpdateTime(new Date());

        SignSignetLogExample example = new SignSignetLogExample();
        example.createCriteria().andApplyNoEqualTo(applyNo);
        return mapper.updateByExampleSelective(updateSignetLog, example);
    }

    @Override
    public int updateRecordNo(String applyNo, String recordNo) {
        SignSignetLogWithBLOBs updateSignetLog = new SignSignetLogWithBLOBs();
        updateSignetLog.setRecordNo(recordNo);
        updateSignetLog.setUpdateTime(new Date());

        SignSignetLogExample example = new SignSignetLogExample();
        example.createCriteria().andApplyNoEqualTo(applyNo);
        return mapper.updateByExampleSelective(updateSignetLog, example);
    }

    @Override
    public SignSignetLog getById(String signSignetLogId) {
        SignSignetLogExample example = new SignSignetLogExample();
        example.createCriteria().andIdEqualTo(signSignetLogId);
        List<SignSignetLog> signetLogList = mapper.selectByExample(example);
        return signetLogList.size() > 0 ? signetLogList.get(0) : null;
    }
}
