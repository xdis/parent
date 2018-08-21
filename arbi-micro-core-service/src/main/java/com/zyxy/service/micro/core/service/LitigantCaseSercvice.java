package com.zyxy.service.micro.core.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.DelayedReplyDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorInfoVO;
import com.zyxy.common.vo.CaseCommInfoVO;
import com.zyxy.common.vo.CountDownVO;
import com.zyxy.common.vo.LitigantCaseListVO;
import com.zyxy.common.vo.PayAndCaseInfoVO;
import com.zyxy.common.vo.PayAndChangeInfoVO;
import com.zyxy.common.vo.PayOrderVO;
import com.zyxy.common.vo.ReplyDocVO;
import com.zyxy.common.vo.RequestVO;
import com.zyxy.common.vo.WithdrawMessageVO;

public interface LitigantCaseSercvice {
	
	/**
	 * 当事人案件列表
	 * @param formData
	 * @return
	 */
	PageInfo<LitigantCaseListVO>  selectLitigantCaseList(LitigantCaseListDTO formData);
	
	/**
	 * 根据案件ID查询的仲裁员
	 * @param CaseId
	 * @return
	 */
	ArbitratorInfoVO selectArbitratorInfoByCaseId(String CaseId);
	
	/**
	 * 当事人案件验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult litigantCaseInfoBusiValid(String caseId,String userId);
	
	/**
	 * 当事人案件信息
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<PayAndCaseInfoVO> litigantCaseInfoBusiExecute(String caseId ,String userId);
	
	/**
	 * 当事人案件信息
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<PayAndCaseInfoVO> litigantBackRequestInfoBusiExecute(String caseId ,String userId);

	/**
	 * 案件缴费缴费单信息业务验证
	 * @param caseId 案件Id
	 * @param userId 用户Id
	 * @return
	 */
	BusiValidResult casePayInfoBusiValid(String caseId, String userId);

	/**
	 * 案件缴费缴费单信息业务处理
	 * @param caseId 案件Id
	 * @param userId 用户Id
	 * @return
	 */
	BusiExecuteResult<PayOrderVO> casePayInfoBusiExecute(String caseId, String userId);
 
	/**
	 * 案件公共信息业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult caseCommInfoBusiValid(String caseId,String userId);

    /**
     * 案件公共信息业务处理
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiExecuteResult<CaseCommInfoVO> caseCommInfoBusiExecute(String caseId, String userId);
    
    /**
     * 案件请求列表（本请求，变更请求）业务验证
     * @param caseId
     * @param userId
     * @return
     */
    BusiValidResult requestInfoValid(String caseId,String userId);
    
    /**
     * 案件请求列表（本请求，变更请求）业务处理
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<RequestVO> requestInfoExecute(String caseId,String userId);
    
    /**
     * 变更本请求书业务验证
     * @param caseId
     * @param changeId
     * @param userId
     * @return
     */
    BusiValidResult changeDocValid(String caseId,String changeId, String userId);
    
    /**
     * 变更本请求书业务 处理
     * @param caseId
     * @param changeId
     * @param userId
     * @return
     */
    BusiExecuteResult<PayAndChangeInfoVO> changeDocExecute(String caseId,String changeId, String userId);
    

    /**
     * 案件请求列表（本请求，变更请求）业务验证
     * @param caseId
     * @param userId
     * @return
     */
    BusiValidResult backRequestInfoValid(String caseId,String userId);
    
    /**
     * 案件请求列表（本请求，变更请求）业务处理
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<RequestVO> backRequestInfoExecute(String caseId,String userId);
    
    /**
     * 变更反请求书业务验证
     * @param caseId
     * @param changeId
     * @param userId
     * @return
     */
    BusiValidResult backChangeDocValid(String caseId,String changeId, String userId);
    
    /**
     * 变更反请求书业务处理
     * @param caseId
     * @param changeId
     * @param userId
     * @return
     */
    BusiExecuteResult<PayAndChangeInfoVO> backChangeDocExecute(String caseId,String changeId, String userId);

	/**
	 * 延期答辩业务验证
	 *
	 * @param formData 业务对象
	 * @return
	 */
	BusiValidResult delayedReplyValid(DelayedReplyDTO formData);

	/**
	 * 延期答辩业务验证
	 *
	 * @param formData 业务对象
	 * @return
	 */
	BusiExecuteResult delayedReplyExecute(DelayedReplyDTO formData);
	
	/**
	 * 答辩书业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult replyDocValid(String caseId,String userId);
	
	/**
	 * 答辩书业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<ReplyDocVO> replyDocExecute(String caseId,String type);
	
	/**
	 * 反请求答辩书业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<ReplyDocVO> backReplyDocExecute(String caseId,String type);
	
	/**
	 * 倒计时业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult countDownValid(String caseId,String userId);
	
	/**
	 * 倒计时业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<List<CountDownVO>> countDownExecute(String caseId,String userId);
	
	/**
	 * 撤案信息
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<WithdrawMessageVO> withdrawMessageExecute(String caseId);
}
