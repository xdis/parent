package com.zyxy.service.micro.core.service;

import com.zyxy.common.enums.AgentFlagEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AdjudicationAmendApplyDocVO;
import com.zyxy.common.vo.ArbitrationApplyDocVO;
import com.zyxy.common.vo.ChangeRequestApplyDocVO;
import com.zyxy.common.vo.CompromiseProtocolDocVO;
import com.zyxy.common.vo.JurisdictionObjectionApplyDocVO;
import com.zyxy.common.vo.JurisdictionObjectionFeedbackDocVO;
import com.zyxy.common.vo.ReplyDocVO;
import com.zyxy.common.vo.SecretaryAvoidApplyDocVO;
import com.zyxy.common.vo.WithdrawApplyDocVO;


public interface CommonService {
	
	/**
	 * 根据案件id和用户ID查询当前用户身份
	 * @param caseId
	 * @param userId
	 * @return
	 */
	public LitigantTypeEnum queryCaseRoleByUserId(String caseId, String userId);
	
	/**
	 * 根据案件id和用户ID查询当前请求方式
	 * @param caseId
	 * @param userId
	 * @return
	 */
	public RequestTypeEnum queryRequestTypeByUserId(String caseId, String userId);
	
	/**
	 * 根据案件id和用户ID查询代理标志
	 * @param caseId
	 * @param userId
	 * @return
	 */
	public AgentFlagEnum queryAgentFlagByUserId(String caseId,String userId);
	
	/**
	 * 根据案件id和用户ID查询案件人员类型(申请方或被申请方)
	 * @param caseId
	 * @param userId
	 * @return
	 */
	public CasePersonnelTypeEnum queryCasePersonnerlTypeByUserId(String caseId,String userId);
	
	/**
	 * 案件和用户关系验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult commonCaseAndUserValid(String caseId,String userId);
	
	/**
	 * 是否在答辩期
	 * @param caseId
	 * @param type
	 * @param enums
	 * @return
	 */
	boolean isReplyTime(String caseId,String type,RequestTypeEnum enums);
	
	/**
	 * 是否存在答辩记录
	 * @param caseId
	 * @param type
	 * @param enums
	 * @return
	 */
	boolean hasReplyRecord(String caseId,String type,RequestTypeEnum enums);
	
	/**
	 * 是否有答辩期
	 * @param caseId
	 * @param type
	 * @param enums
	 * @return
	 */
	boolean hasReplyTime(String caseId,String type,RequestTypeEnum enums);
	
	/**
	 * 是否有反请求
	 * @param caseId
	 * @return
	 */
	boolean hasBackRequest(String caseId);
	
	/**
	 * 请求是否撤回
	 * @param caseId
	 * @param enums
	 * @return
	 */
	boolean requestIsWithdraw(String caseId,RequestTypeEnum enums);
	
	/**
	 * 仲裁申请书(反请求申请书)
	 * @param caseId
	 * @param enums
	 * @return
	 */
	ArbitrationApplyDocVO arbitrationApplyDoc(String caseId,RequestTypeEnum enums);
	
	/**
	 * 答辩书
	 * @param caseId
	 * @param enums
	 * @param type
	 * @return
	 */
	ReplyDocVO replyDoc(String caseId,RequestTypeEnum enums,String type);
	
	/**
	 * 撤案申请书
	 * @param caseId
	 * @param enums
	 * @return
	 */
	WithdrawApplyDocVO WithdrawApplyDocVO(String caseId,RequestTypeEnum enums);
	
	/**
	 * 变更仲裁请求申请书
	 * @param changeId
	 * @return
	 */
	ChangeRequestApplyDocVO changeRequestApplyDoc(String changeId);
	
	/**
	 * 管辖权异议申请书
	 * @param caseId
	 * @param enums
	 * @return
	 */
	JurisdictionObjectionApplyDocVO jurisdictionObjectionApplyDocVO(String caseId,RequestTypeEnum enums);
	
	/**
	 * 管辖权异议回应书
	 * @param caseId
	 * @param enums
	 * @return
	 */
	JurisdictionObjectionFeedbackDocVO jurisdictionObjectionFeedbackDoc(String caseId,RequestTypeEnum enums);
	
	/**
	 * 裁决补正申请书
	 * @param caseId
	 * @param enums
	 * @return
	 */
	AdjudicationAmendApplyDocVO adjudicationAmendApplyDoc(String caseId,RequestTypeEnum enums);
	
	/**
	 * 秘书回避申请书
	 * @param avoidId
	 * @return
	 */
	SecretaryAvoidApplyDocVO aecretaryAvoidApplyDoc(String avoidId);
	
	/**
	 * 仲裁员会回避书
	 * @param avoidId
	 * @return
	 */
	ArbitrationApplyDocVO arbitrationApplyDoc(String avoidId);
	
	/**
	 * 和解协议书
	 * @param caseId
	 * @return
	 */
	CompromiseProtocolDocVO compromiseProtocolDoc(String caseId);
	
	/**
	 * 根据身份证号查身份证
	 * @param cardId
	 * @return
	 */
	String selectUserIdByCardId(String cardId);
	
}
