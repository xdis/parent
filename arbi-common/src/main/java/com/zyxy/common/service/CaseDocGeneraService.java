package com.zyxy.common.service;

import com.zyxy.common.domain.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.vo.CaseArbitralAwardVO;
import com.zyxy.common.vo.EvidenceVO;
import com.zyxy.common.vo.UserInfoVO;
import com.zyxy.common.vo.doc.CaseDocHeadVO;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CaseDocGeneraService {

    @Autowired
    private CaseDocCommMapper caseDocCommMapper;

    /**
     * 得到文书头部信息
     *
     * @param caseId      案件Id
     * @param requestType 请求类型
     * @return
     */
    public CaseDocHeadVO getCaseDocHead(String caseId, RequestTypeEnum requestType) {
        CaseDocHeadVO caseDocHeadVO = new CaseDocHeadVO();
        caseDocHeadVO.setApplicant(caseDocCommMapper.queryLitigantInfo(caseId, requestType.getValue(), "0"));
        caseDocHeadVO.setBeApplicant(caseDocCommMapper.queryLitigantInfo(caseId, requestType.getValue(), "1"));
        caseDocHeadVO.setApplicantAgent(caseDocCommMapper.queryAgentInfo(caseId, requestType.getValue(), "0"));
        caseDocHeadVO.setBeApplicantAgent(caseDocCommMapper.queryAgentInfo(caseId, requestType.getValue(), "1"));
        return caseDocHeadVO;
    }

    /**
     * 得到文书头部信息
     *
     * @param caseId 案件Id
     * @return
     */
    public CaseDocHeadVO getCaseDocHead(String caseId) {
        return getCaseDocHead(caseId, RequestTypeEnum.REQUEST);
    }

    @Autowired
    public CaseInfoMapper caseInfoMapper;

    @Autowired
    public CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    public UserInfoMapper userInfoMapper;

    @Autowired
    public CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private CaseRejoinRecordMapper caseRejoinRecordMapper;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    @Autowired
    private CaseMatMapper caseMatMapper;

    @Autowired
    private CaseDocContentMapper caseDocContentMapper;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    public CaseArbitralAwardVO getCaseArbitralAward(String caseId) {
        CaseArbitralAwardVO award = new CaseArbitralAwardVO();

        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
        String caseNo = caseInfo.getCaseNo();
        award.setCaseNo(caseNo);
        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = getCaseDocHead(caseId);
        award.setCaseDocHead(caseDocHead);
        //签订合同还是协议,展示不一致
        String protocolMode = caseInfo.getSignAbriProtocolMode();
        award.setProtocolMode(protocolMode);
        //签订时间
        Date signTime = caseInfo.getSignTime();
        award.setSignTime(signTime);
        //案件受理时间
        Date caseAcceptanceTime = caseInfo.getCaseAcceptanceTime();
        award.setCaseAcceptanceTime(caseAcceptanceTime);
        //合同名称
        String protocolName = caseInfo.getProtocolName();
        award.setProtocolName(protocolName);
        //案由
        String caseType = caseInfo.getCaseTypeId();
        award.setCaseType(caseType);
        //仲裁员
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        UserInfoVO caseArbitratorInfo = userInfoMapper.selectUserInFoByUserId(caseArbitrator.getArbitratorId());
        //仲裁员选定类型,1- 当事人指定,0- 系统指派/主任指定
        String arbitratorType = caseArbitrator.getType();
        award.setArbitratorType(arbitratorType);
        //组庭时间
        Date arbitratorGroupTime = caseArbitrator.getSendGroupNoticeTime();
        award.setArbitratorGroupTime(arbitratorGroupTime);
        //仲裁员名称
        String arbitratorName = caseArbitratorInfo.getName();
        award.setArbitratorName(arbitratorName);
        //查询
        CaseRequestInfo paramRequestInfo = new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo = caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        //本请求仲裁请求
        String requestArbClaim = caseRequestInfo.getArbClaim();
        award.setRequestArbClaim(requestArbClaim);
        //事实与理由
        String requestFact = caseRequestInfo.getFact();
        award.setRequestFact(requestFact);
        //判断被申请人本请求有无答辩
        CaseRejoinRecordExample rejoinExample = new CaseRejoinRecordExample();
        rejoinExample.createCriteria()
                .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                .andRejoinTyepEqualTo(ReplyTypeEnum.REQUEST.getValue())
                .andCaseIdEqualTo(caseId);
        List<CaseRejoinRecordWithBLOBs> requestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(rejoinExample);
        //本请求答辩内容
        String requestReply = "";
        if (!requestJoinList.isEmpty()) {
            requestReply = requestJoinList.get(0).getRejoinText();
        }
        award.setRequestReply(requestReply);

        //判断申请人本请求有无变更
        CaseChangeRecordExample changeRecordExample = new CaseChangeRecordExample();
        rejoinExample.createCriteria()
                .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                .andStatusEqualTo(NumberUtils.toInt(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue()))
                .andCaseIdEqualTo(caseId);
        rejoinExample.setOrderByClause("create_time desc");
        List<CaseChangeRecordWithBLOBs> changeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);

        //是否有仲裁请求变更
        boolean requestChange = !changeRecordList.isEmpty();
        award.setRequestChange(requestChange);
        if (requestChange) {
            CaseChangeRecordWithBLOBs caseChangeRecord = changeRecordList.get(0);
            //变更时间
            Date requestChangeTime = caseChangeRecord.getCreateTime();
            award.setRequestChangeTime(requestChangeTime);
            //变更请求
            String requestChangeRequest = caseChangeRecord.getChangeRequest();
            award.setRequestChangeRequest(requestChangeRequest);
            //变更事实与理由
            String requestChangeFactReason = caseChangeRecord.getFactReason();
            award.setRequestChangeFactReason(requestChangeFactReason);
            //判断变更本请求有无答辩
            CaseRejoinRecordExample changeRejoinExample = new CaseRejoinRecordExample();
            rejoinExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                    .andRejoinTyepEqualTo(ReplyTypeEnum.CHANGE_REUEST.getValue())
                    .andCaseIdEqualTo(caseId);
            List<CaseRejoinRecordWithBLOBs> changeRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(changeRejoinExample);

            //本请求答辩内容
            String requestChangeReply = "";
            if (!changeRequestJoinList.isEmpty()) {
                requestChangeReply = changeRequestJoinList.get(0).getRejoinText();
            }
            award.setRequestChangeReply(requestChangeReply);
        }

        //判断是否有反请求
        CaseRequestInfoExample beRequestInfoExample = new CaseRequestInfoExample();
        beRequestInfoExample.createCriteria()
                .andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                .andCaseIdEqualTo(caseId);
        List<CaseRequestInfoWithBLOBs> beRequestInfoList = caseRequestInfoMapper.selectByExampleWithBLOBs(beRequestInfoExample);

        //是否有反请求
        boolean haveBackRequest = !beRequestInfoList.isEmpty();
        award.setHaveBackRequest(haveBackRequest);
        if (haveBackRequest) {
            //仲裁反请求
            String backRequestArbClaim = beRequestInfoList.get(0).getArbClaim();
            award.setBackRequestArbClaim(backRequestArbClaim);
            String backRequestFact = beRequestInfoList.get(0).getFact();
            award.setBackRequestFact(backRequestFact);
            //判断反请求是否有答辩
            CaseRejoinRecordExample beRejoinExample = new CaseRejoinRecordExample();
            beRejoinExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                    .andRejoinTyepEqualTo(ReplyTypeEnum.REQUEST.getValue())
                    .andCaseIdEqualTo(caseId);
            List<CaseRejoinRecordWithBLOBs> beRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(beRejoinExample);

            //本请求答辩内容
            String backRequestReply = "";
            if (!beRequestJoinList.isEmpty()) {
                backRequestReply = beRequestJoinList.get(0).getRejoinText();
            }
            award.setBackRequestReply(backRequestReply);

            //判断反请求是否有变更
            CaseChangeRecordExample beChangeRecordExample = new CaseChangeRecordExample();
            beChangeRecordExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                    .andStatusEqualTo(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue())
                    .andCaseIdEqualTo(caseId);
            rejoinExample.setOrderByClause("create_time desc");
            List<CaseChangeRecordWithBLOBs> beChangeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);

            //是否有仲裁请求变更
            boolean backRequestChange = !beChangeRecordList.isEmpty();
            award.setBackRequestChange(backRequestChange);
            if (backRequestChange) {
                CaseChangeRecordWithBLOBs caseChangeRecord = beChangeRecordList.get(0);
                //变更时间
                Date backRequestChangeTime = caseChangeRecord.getCreateTime();
                award.setBackRequestChangeTime(backRequestChangeTime);
                //变更请求
                String backRequestChangeRequest = caseChangeRecord.getChangeRequest();
                award.setBackRequestChangeRequest(backRequestChangeRequest);
                //变更事实与理由
                String backRequestChangeFactReason = caseChangeRecord.getFactReason();
                award.setBackRequestChangeFactReason(backRequestChangeFactReason);
                //判断变更本请求有无答辩
                CaseRejoinRecordExample changeRejoinExample = new CaseRejoinRecordExample();
                rejoinExample.createCriteria()
                        .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                        .andRejoinTyepEqualTo(ReplyTypeEnum.CHANGE_REUEST.getValue())
                        .andCaseIdEqualTo(caseId);
                List<CaseRejoinRecordWithBLOBs> changeRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(changeRejoinExample);

                //本请求答辩内容
                String backRequestChangeReply = "";
                if (!changeRequestJoinList.isEmpty()) {
                    backRequestChangeReply = changeRequestJoinList.get(0).getRejoinText();
                }
                award.setBackRequestChangeReply(backRequestChangeReply);
            }
        }
        //二、举证与质证
        //申请人举证
        List<EvidenceVO> proposerMatList = caseMatMapper.selectEvidencesParam(caseId, EvidenceTypeEnum.PROPOSER.getValue());
        //申请人是否举证
        boolean applicantProof = !proposerMatList.isEmpty();
        award.setApplicantProof(applicantProof);
        if (applicantProof) {
            //申请人提供证据Str
            StringBuilder applicantProofMat = new StringBuilder();
            //被申请人质证意见Str
            StringBuilder applicantProofOppugn = new StringBuilder();
            for (int i = 0; i < proposerMatList.size(); i++) {
                String pixMat = "证据" + number2Chinese((i + 1) + "") + "，";
                applicantProofMat.append(pixMat).append(proposerMatList.get(i).getEvidenceMat()).append("；");
                if (StringUtils.isNotBlank(proposerMatList.get(i).getOppugnEvidence())) {
                    applicantProofOppugn.append(pixMat).append(proposerMatList.get(i).getOppugnEvidence()).append("；");
                }
            }
            award.setApplicantProofMat(applicantProofMat.toString());
            award.setApplicantProofOppugn(applicantProofOppugn.toString());
        }
        //被申请人举证
        List<EvidenceVO> defendantMatList = caseMatMapper.selectEvidencesParam(caseId, EvidenceTypeEnum.DEFENDANT.getValue());
        //申请人是否举证
        boolean beApplicantProof = !defendantMatList.isEmpty();
        award.setBeApplicantProof(beApplicantProof);
        if (beApplicantProof) {
            //申请人提供证据Str
            StringBuilder beApplicantProofMat = new StringBuilder();
            //被申请人质证意见Str
            StringBuilder beApplicantProofOppugn = new StringBuilder();
            for (int i = 0; i < defendantMatList.size(); i++) {
                String pixMat = "证据" + number2Chinese((i + 1) + "") + "，";
                beApplicantProofMat.append(pixMat).append(defendantMatList.get(i).getEvidenceMat()).append("；");
                if (StringUtils.isNotBlank(defendantMatList.get(i).getOppugnEvidence())) {
                    beApplicantProofOppugn.append(pixMat).append(defendantMatList.get(i).getOppugnEvidence()).append("；");
                }
            }
            award.setBeApplicantProofMat(beApplicantProofMat.toString());
            award.setBeApplicantProofOppugn(beApplicantProofOppugn.toString());
        }
        CaseDocContentWithBLOBs caseDocContent = caseDocContentMapper.queryCaseDocContentByCaseIdAndDocType(caseId, CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());

        if (caseDocContent != null) {
            //三、事实认定
            String factFinding = caseDocContent.getBodyText();
            award.setFactFinding(factFinding);
            //四、仲裁庭意见
            String arbitralTribunalOpinion = caseDocContent.getOpinion();
            award.setArbitralTribunalOpinion(arbitralTribunalOpinion);
            //五、裁决
            String finalDecision = caseDocContent.getFinalDecision();
            award.setFinalDecision(finalDecision);
        }

        //落款日期
        Date badgingDate = new Date();
        award.setBadgingDate(badgingDate);
        String secretaryId = caseManagerMapper.queryArbitrationUserId(caseId, ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
        UserInfoVO secretaryInfo = userInfoMapper.selectUserInFoByUserId(secretaryId);
        String secretaryName = secretaryInfo.getName();
        award.setSecretaryName(secretaryName);
        return award;
    }

    private String number2Chinese(String string) {
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

        String result = "";

        int n = string.length();
        for (int i = 0; i < n; i++) {

            int num = string.charAt(i) - '0';

            if (i != n - 1 && num != 0) {
                result += s1[num] + s2[n - 2 - i];
            } else {
                if ("零".equals(s1[num]) && result.endsWith("零")) {
                    continue;
                }
                result += s1[num];
            }
        }
        if (result.endsWith("零")) {
            result = result.substring(0, result.length() - 1);
        }
        if (result.equals("一十")) {
            result = "十";
        }
        return result;

    }
}
