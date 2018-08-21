package com.zyxy.service.micro.core.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseAgent;
import com.zyxy.common.domain.CaseChangeRecordWithBLOBs;
import com.zyxy.common.domain.CaseDefendant;
import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.CaseProposer;
import com.zyxy.common.domain.CaseRejoinRecordExample;
import com.zyxy.common.domain.CaseRejoinRecordWithBLOBs;
import com.zyxy.common.domain.CaseReplyTimeRecord;
import com.zyxy.common.domain.CaseReplyTimeRecordExample;
import com.zyxy.common.domain.CaseRequestInfo;
import com.zyxy.common.domain.CaseRequestInfoExample;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.LitigantInfoExample;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.enums.AgentFlagEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.CaseRequestInfoStatusEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.mapper.CaseAgentMapper;
import com.zyxy.common.mapper.CaseAvoidRecordMapper;
import com.zyxy.common.mapper.CaseChangeRecordMapper;
import com.zyxy.common.mapper.CaseDefendantMapper;
import com.zyxy.common.mapper.CaseDocCommMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseJurisDisMapper;
import com.zyxy.common.mapper.CaseProposerMapper;
import com.zyxy.common.mapper.CaseRejoinRecordMapper;
import com.zyxy.common.mapper.CaseReplyTimeRecordMapper;
import com.zyxy.common.mapper.CaseRequestInfoMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.mapper.WithdrawRecordMapper;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.AdjudicationAmendApplyDocVO;
import com.zyxy.common.vo.ArbitrationApplyDocVO;
import com.zyxy.common.vo.ChangeRequestApplyDocVO;
import com.zyxy.common.vo.CompromiseProtocolDocVO;
import com.zyxy.common.vo.JurisdictionObjectionApplyDocVO;
import com.zyxy.common.vo.JurisdictionObjectionFeedbackDocVO;
import com.zyxy.common.vo.LitigantCaseInfoValidVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.SecretaryAvoidApplyDocVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;
import com.zyxy.common.vo.ReplyDocVO;
import com.zyxy.common.vo.WithdrawApplyDocVO;
import com.zyxy.service.micro.core.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private CaseProposerMapper caseProposerMapper;
	@Autowired
	private CaseDefendantMapper caseDefendantMapper;
	@Autowired
	private CaseAgentMapper caseAgentMapper;
	@Autowired 
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;
	@Autowired
	private CaseRejoinRecordMapper caseRejoinRecordMapper;
	@Autowired
	private CaseRequestInfoMapper caseRequestInfoMapper;
	@Autowired
	private LitigantInfoMapper litigantInfoMapper;
	@Autowired
	private CaseDocCommMapper caseDocCommMapper;
	@Autowired
	private WithdrawRecordMapper withdrawRecordMapper;
	@Autowired
	private CaseChangeRecordMapper caseChangeRecordMapper;
	@Autowired
	private CaseJurisDisMapper caseJurisDisMapper;
	@Autowired
	private CaseAvoidRecordMapper caseAvoidRecordMapper;
	
	@Override
    public LitigantTypeEnum queryCaseRoleByUserId(String caseId, String userId) {

        //查询对应用户的身份证号
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(userId);
        String cardId=userInfo.getCardId();

        //判断是否是当事人
        CaseProposer caseProposer=caseProposerMapper.selectCaseProposerByCaseId(caseId);
        if(caseProposer!=null&&caseProposer.getCardId().equals(cardId)){
            return LitigantTypeEnum.PROPESER;
        }
        //判断是否是被申请人
        CaseDefendant caseDefendant=caseDefendantMapper.selectCaseDefendantByCaseId(caseId);
        if(caseDefendant!=null&&caseDefendant.getCardId().equals(cardId)){
            return LitigantTypeEnum.DEFENDANT;
        }

        //判断是否是代理人(两种类型)
        CaseAgent caseagent=new CaseAgent();
        caseagent.setCaseId(caseId);
        caseagent=caseAgentMapper.selectAgentByCaseId(caseagent);
        if(caseagent!=null && caseagent.getAgentId().equals(userId)){

            if(caseagent.getLitigantType().equals(LitigantTypeEnum.PROPESER.getValue())){
                return LitigantTypeEnum.PROPESER_AGENT;
            }

            if(caseagent.getLitigantType().equals(LitigantTypeEnum.DEFENDANT.getValue())){
                return LitigantTypeEnum.DEFENDANT_AGENT;
            }
        }

        return null;

    }

	@Override
	public RequestTypeEnum queryRequestTypeByUserId(String caseId, String userId) {//查询当前用户的身份
		LitigantTypeEnum enums = queryCaseRoleByUserId(caseId, userId);
		if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())
				||LitigantTypeEnum.PROPESER_AGENT.getValue().equals(enums.getValue())) {
			return RequestTypeEnum.REQUEST;
		}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())
				||LitigantTypeEnum.DEFENDANT_AGENT.getValue().equals(enums.getValue())){
			return RequestTypeEnum.BACK_REQUEST;
		}
		return null;
	}

	@Override
	public AgentFlagEnum queryAgentFlagByUserId(String caseId, String userId) {
		LitigantTypeEnum enums = queryCaseRoleByUserId(caseId, userId);
		if (LitigantTypeEnum.DEFENDANT_AGENT.getValue().equals(enums.getValue())||
				LitigantTypeEnum.PROPESER_AGENT.getValue().equals(enums.getValue())) {
			return AgentFlagEnum.AGENT;
		}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())||
				LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())){
			return AgentFlagEnum.SELF;
		}
		return null;
	}

	@Override
	public CasePersonnelTypeEnum queryCasePersonnerlTypeByUserId(String caseId,
			String userId) {
		LitigantTypeEnum enums = queryCaseRoleByUserId(caseId, userId);
		if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())
				||LitigantTypeEnum.PROPESER_AGENT.getValue().equals(enums.getValue())) {
			return CasePersonnelTypeEnum.PROPOSER;
		}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())
				||LitigantTypeEnum.DEFENDANT_AGENT.getValue().equals(enums.getValue())){
			return CasePersonnelTypeEnum.DEFENDANT;
		}
		return null;
	}

	@Override
	public BusiValidResult commonCaseAndUserValid(String caseId, String userId) {
		LitigantTypeEnum enums = queryCaseRoleByUserId(caseId, userId);
		if (enums ==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
		LitigantCaseInfoValidVO validVO = caseInfoMapper.selectLitigantUserIdByCaseId(caseId);
		switch (enums) {
		//当前用户是申请人
		case PROPESER:
			if (!userId.equals(validVO.getProposerId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		//当前用户是被申请人	
		case DEFENDANT:
			if (!userId.equals(validVO.getDefendantId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		//当前用户是申请人代理人
		case PROPESER_AGENT:
			if (!userId.equals(validVO.getProposerAgentId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		//当前用户是被申请人代理人	
		case DEFENDANT_AGENT:
			if (!userId.equals(validVO.getDefendantAgentId())) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
			break;
		default:
			break;
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public boolean isReplyTime(String caseId, String type, RequestTypeEnum enums) {
		 CaseReplyTimeRecordExample replyExample = new CaseReplyTimeRecordExample();
         replyExample.createCriteria().
         andCaseIdEqualTo(caseId).
         andRequestTypeEqualTo(enums.getValue()).
         andTypeEqualTo(type);
         List<CaseReplyTimeRecord> caseChangeReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(replyExample);
         if  (caseChangeReplyTimeRecords.size()>0&&caseChangeReplyTimeRecords.get(0).getEndTime().compareTo(new Date()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasReplyRecord(String caseId, String type,
			RequestTypeEnum enums) {
		 CaseRejoinRecordExample example = new CaseRejoinRecordExample();
         example.createCriteria().
         	andCaseIdEqualTo(caseId).
         	andCounterclaimFlagEqualTo(enums.getValue()).
         	andRejoinTyepEqualTo(type);
         List<CaseRejoinRecordWithBLOBs> caseRejoinRecords = caseRejoinRecordMapper.selectByExampleWithBLOBs(example);
         if (caseRejoinRecords.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasReplyTime(String caseId, String type,
			RequestTypeEnum enums) {
		 CaseReplyTimeRecordExample replyExample = new CaseReplyTimeRecordExample();
         replyExample.createCriteria().
         andCaseIdEqualTo(caseId).
         andRequestTypeEqualTo(enums.getValue()).
         andTypeEqualTo(type);
         List<CaseReplyTimeRecord> caseChangeReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(replyExample);
         if  (caseChangeReplyTimeRecords.size() > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hasBackRequest(String caseId) {
		CaseRequestInfoExample example = new CaseRequestInfoExample();
		example.createCriteria().andCaseIdEqualTo(caseId).andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue());
		List<CaseRequestInfo> caseRequestInfos=caseRequestInfoMapper.selectByExample(example);
		if (caseRequestInfos.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean requestIsWithdraw(String caseId, RequestTypeEnum enums) {
		CaseRequestInfoExample example = new CaseRequestInfoExample();
		example.createCriteria().andCaseIdEqualTo(caseId).andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
		List<CaseRequestInfo> caseRequestInfos=caseRequestInfoMapper.selectByExample(example);
		if (caseRequestInfos.size()>0) {
			if (CaseRequestInfoStatusEnum.CANCEL.getValue().equals(caseRequestInfos.get(0).getStatus())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArbitrationApplyDocVO arbitrationApplyDoc(String caseId,
			RequestTypeEnum enums) {
		ArbitrationApplyDocVO applyDocVO = caseRequestInfoMapper.selectArbitrationInfo(caseId, enums.getValue());
		CaseDocLitigantVO applicant = caseDocCommMapper.queryLitigantInfo(caseId, RequestTypeEnum.REQUEST.getValue(), "0");
		CaseDocLitigantVO beApplicant = caseDocCommMapper.queryLitigantInfo(caseId, RequestTypeEnum.REQUEST.getValue(), "1");
		if (RequestTypeEnum.REQUEST.getValue().equals(enums.getValue())) {
			applyDocVO.setProposer(applicant);
			applyDocVO.setDefendant(beApplicant);
		}else{
			applyDocVO.setProposer(beApplicant);
			applyDocVO.setDefendant(applicant);
		}
		return applyDocVO;
	}

	@Override
	public ReplyDocVO replyDoc(String caseId, RequestTypeEnum enums, String type) {
		ReplyDocVO info = new ReplyDocVO();
		CaseRejoinRecordExample example = new CaseRejoinRecordExample();
		example.createCriteria().
			andCaseIdEqualTo(caseId).
				andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue()).
					andRejoinTyepEqualTo(type);
		List<CaseRejoinRecordWithBLOBs> caseRejoinRecords = caseRejoinRecordMapper.selectByExampleWithBLOBs(example);
		CaseDocLitigantVO propose= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "0");
		CaseDocLitigantVO defendant= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "1");
		if (RequestTypeEnum.REQUEST.getValue().equals(enums.getValue())) {
			info.setRepliedVO(propose);
			info.setBeRepliedVO(defendant);
			info.setInscribeName(propose.getName());
		}else{
			info.setRepliedVO(defendant);
			info.setBeRepliedVO(propose);
			info.setInscribeName(defendant.getName());
		}
		info.setInscribeTime(DateUtil.formatDate(caseRejoinRecords.get(0).getCreateTime(), "yyyy年MM月dd日"));
		info.setId(caseRejoinRecords.get(0).getId());
		info.setRejoinText(caseRejoinRecords.get(0).getRejoinText());
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
		info.setCaseType(caseInfo.getCaseTypeId());
		return info;
	}
	
	@Override
	public WithdrawApplyDocVO WithdrawApplyDocVO(String caseId,
			RequestTypeEnum enums) {
		WithdrawApplyDocVO applyDocVO = withdrawRecordMapper.selectWithdrawApplyDoc(caseId, enums.getValue());
		return applyDocVO;
	}

	@Override
	public ChangeRequestApplyDocVO changeRequestApplyDoc(String changeId) {
		CaseChangeRecordWithBLOBs info = caseChangeRecordMapper.selectByPrimaryKey(changeId);
		CaseDocLitigantVO propose= caseDocCommMapper.queryLitigantInfo(info.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "0");
		CaseDocLitigantVO defendant= caseDocCommMapper.queryLitigantInfo(info.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "1");
		ChangeRequestApplyDocVO applyDocVO = new ChangeRequestApplyDocVO();
		if (RequestTypeEnum.REQUEST.getValue().equals(info.getCounterclaimFlag())) {
			applyDocVO.setProposer(propose);
			applyDocVO.setDefendant(defendant);
		}else{
			applyDocVO.setProposer(defendant);
			applyDocVO.setDefendant(propose);
		}
		applyDocVO.setFactReason(info.getFactReason());
		applyDocVO.setRequestItem(info.getChangeRequest());
		applyDocVO.setApplyTime(info.getCreateTime());
		return applyDocVO;
	}

	@Override
	public JurisdictionObjectionApplyDocVO jurisdictionObjectionApplyDocVO(
			String caseId, RequestTypeEnum enums) {
		JurisdictionObjectionApplyDocVO applyDocVO =caseJurisDisMapper.selectJurisdictionObjectionApplyDoc(caseId, enums.getValue());
		return applyDocVO;
	}
	
	

	@Override
	public JurisdictionObjectionFeedbackDocVO jurisdictionObjectionFeedbackDoc(
			String caseId, RequestTypeEnum enums) {
		JurisdictionObjectionFeedbackDocVO docVO = caseJurisDisMapper.selectJurisdictionObjectionFeedbackDoc(caseId, enums.getValue());
		if (StringUtils.isBlank(docVO.getFeedBack())) {
			return null;
		}
		return docVO;
	}

	@Override
	public AdjudicationAmendApplyDocVO adjudicationAmendApplyDoc(String caseId,
			RequestTypeEnum enums) {
		return null;
	}

	@Override
	public SecretaryAvoidApplyDocVO aecretaryAvoidApplyDoc(String avoidId) {
		SecretaryAvoidApplyDocVO applyDocVO = caseAvoidRecordMapper.selectSecretaryAvoidApplyDoc(avoidId);
		return applyDocVO;
	}

	@Override
	public ArbitrationApplyDocVO arbitrationApplyDoc(String avoidId) {
		ArbitrationApplyDocVO applyDocVO =caseAvoidRecordMapper.selectArbitrationApplyDocVO(avoidId);
		return applyDocVO;
	}

	@Override
	public CompromiseProtocolDocVO compromiseProtocolDoc(String caseId) {
		return null;
	}

	@Override
	public String selectUserIdByCardId(String cardId) {
		LitigantInfoExample example = new LitigantInfoExample();
		example.createCriteria().andCardIdEqualTo(cardId);
		List<LitigantInfo> infos = litigantInfoMapper.selectByExample(example);
		if (infos.size()>0) {
			return infos.get(0).getUserId();
		}
		return null;
	}
	
	
	
	
}
