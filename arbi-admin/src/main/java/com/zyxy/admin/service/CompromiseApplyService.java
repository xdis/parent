package com.zyxy.admin.service;


import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ComproiseApplyVO;

/**
 * 和解申请service
 */
public interface CompromiseApplyService {

    /**
     * 和解申请业务验证,判断是组庭前的和解申请还是组庭后的和解申请，并且判断当事人双方是否都同意和解
     * @param caseId
     * @return
     */
    BusiValidResult queryComproiseApplyBusiValid(String caseId);

    /**
     * 和解申请业务处理,查询出和解申请
     * @param caseId
     * @param userId
     * @return
     */
    ComproiseApplyVO queryComproiseApplyBusiExcute(String caseId,String userId);


    /**
     * 和解申请业务验证
     * @param applyId
     * @return
     */
    BusiValidResult compromiseApplyBusiValidResult(String applyId);

    /**
     * 同意和解申请业务处理
     * @param applyId
     * @param startTime
     * @return
     */
    BusiExecuteResult agreeCompromiseApplyBusiExcute(String applyId, String startTime,String caseId);


    /**
     * 拒绝和解申请业务处理
     * @param applyId
     * @return
     */
    BusiExecuteResult refuseCompromiseApplyBusiExcute(String applyId);
    
}
