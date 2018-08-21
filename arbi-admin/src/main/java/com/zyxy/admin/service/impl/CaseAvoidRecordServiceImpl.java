package com.zyxy.admin.service.impl;

import com.zyxy.admin.service.CaseAvoidRecordService;
import com.zyxy.common.domain.CaseAvoidRecordWithBLOBs;
import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.enums.CaseAvoidStatusEnum;
import com.zyxy.common.enums.CaseAvoidStyleEnum;
import com.zyxy.common.enums.CaseAvoidTypeEnum;
import com.zyxy.common.mapper.CaseAvoidRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 回避serviceImpl
 */
@Service
public class CaseAvoidRecordServiceImpl implements CaseAvoidRecordService {

    @Autowired
    private CaseAvoidRecordMapper caseAvoidRecordMapper;

    /**
     * 插入回避记录业务处理
     * @param formData
     * @return
     */
    @Override
    public Boolean insertCaseAvoidRecordBusiExecute(CaseAvoidRecordInsertDTO formData) {
        CaseAvoidRecordWithBLOBs caseAvoidRecordWithBLOBs=new CaseAvoidRecordWithBLOBs();
        caseAvoidRecordWithBLOBs.setCaseId(formData.getCaseId());
        caseAvoidRecordWithBLOBs.setCreaterId(formData.getCreaterId());
        caseAvoidRecordWithBLOBs.setAvoidId(formData.getCreaterId());
        caseAvoidRecordWithBLOBs.setAvoidStyle(CaseAvoidStyleEnum.SELF_APPLIED.getValue());
        caseAvoidRecordWithBLOBs.setAvoidType(CaseAvoidTypeEnum.SECRETARY.getValue());
        caseAvoidRecordWithBLOBs.setAvoidReason(formData.getAvoidReason());
        caseAvoidRecordWithBLOBs.setStatus(CaseAvoidStatusEnum.WAIT_AUDIT.getValue());
        caseAvoidRecordWithBLOBs.setCreateTime(new Date());
        return this.insertCaseAvoidRecord(caseAvoidRecordWithBLOBs);
    }


    /*********私有service*********/

    /**
     * 插入回避记录
     * @param formData
     * @return
     */
    public boolean insertCaseAvoidRecord(CaseAvoidRecordWithBLOBs formData){
        //插入回避记录
        int low = caseAvoidRecordMapper.insert(formData);
        if(low<=0){
            return false;
        }
        return true;
    }
}
