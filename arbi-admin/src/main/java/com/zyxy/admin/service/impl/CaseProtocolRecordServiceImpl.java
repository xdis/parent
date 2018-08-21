package com.zyxy.admin.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CaseProtocolRecordService;
import com.zyxy.common.domain.CaseInfoExample;
import com.zyxy.common.domain.CaseProtocolRecord;
import com.zyxy.common.domain.CaseProtocolRecordExample;
import com.zyxy.common.domain.CaseProtocolRecordWithBLOBs;
import com.zyxy.common.enums.ComproiseApplyOpinionEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseProtocolRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

/**
 * 调解协议申请Impl
 *
 */
@Service
public class CaseProtocolRecordServiceImpl implements CaseProtocolRecordService {

	 @Autowired
	 private CaseInfoMapper caseInfoMapper;
	 
	 @Autowired
	 private CaseProtocolRecordMapper caseProtocolRecordMapper;
	 
	/**
	 * 查询调解协议申请业务验证
	 * @param caseId
	 * @return
	 */
	@Override
	public BusiValidResult queryCaseProtocolRecordBusiValid(String caseId) {
		// TODO Auto-generated method stub
		CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria().andIdEqualTo(caseId);
        //根据案件id查询该案件存不存在
        int i = caseInfoMapper.countByExample(caseInfoExample);
        if(i<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        //判断双方当事人是否都同意
        CaseProtocolRecordWithBLOBs caseProtocolRecordWithBlobs = this.queryCaseProtocolRecord(caseId);
        if(caseProtocolRecordWithBlobs!=null){
        	String propOpinion=caseProtocolRecordWithBlobs.getPropOpinion();
        	String defeOpinion=caseProtocolRecordWithBlobs.getDefeOpinion();
        	if(!(ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(propOpinion)&&ComproiseApplyOpinionEnum.OPINION_AGREE.getCode().equals(defeOpinion))){
        		return BusiValidResult.builderErrorResult(ApiResultVO.Coder.LITIGANT_OPINION_NOT_THE_SAME);
        	}
        }
        return BusiValidResult.builderSuccessResult();
	}

	/**
	 *  查询调解协议申请业务处理
	 */
	@Override
	public BusiExecuteResult<CaseProtocolRecordWithBLOBs> queryCaseProtocolRecordBusiExecute(
			String caseId) {
		// TODO Auto-generated method stub
		CaseProtocolRecordWithBLOBs caseProtocolRecordWithBlobs = this.queryCaseProtocolRecord(caseId);
		if(caseProtocolRecordWithBlobs!=null){
			return BusiExecuteResult.builderSuccessResult(caseProtocolRecordWithBlobs);
		}
		return BusiExecuteResult.builderErrorResult(Coder.DB_NOTFOUND_ERROR);
	}

	
	/****************私有service********************/
	/**
	 * 查询调解协议申请
	 * @param caseId
	 * @return
	 */
	private CaseProtocolRecordWithBLOBs queryCaseProtocolRecord(String caseId){
		CaseProtocolRecordExample caseProtocolRecordExample=new CaseProtocolRecordExample();
		caseProtocolRecordExample.createCriteria().andCaseIdEqualTo(caseId);
        List<CaseProtocolRecordWithBLOBs> selectByExampleWithBLOBList = caseProtocolRecordMapper.selectByExampleWithBLOBs(caseProtocolRecordExample);
        if(selectByExampleWithBLOBList.size()>0){
        	return selectByExampleWithBLOBList.get(0);
        }
		return null;
	}
}
