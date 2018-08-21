package com.zyxy.common.service;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.zyxy.common.custom.MyMultipartFile;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.dto.flow.CaseCancelDTO;
import com.zyxy.common.dto.flow.CaseOverDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.PDFUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.LitigantArbitratorInfoVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CaseFlowService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;

    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private WorkDayService workDayService;

    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseArbitratorOperMapper caseArbitratorOperMapper;

    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;

    @Autowired
    private CaseArbitratorService caseArbitratorService;

    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;

    @Autowired
    private CaseProposerMapper caseProposerMapper;

    @Autowired
    private CaseDefendantMapper caseDefendantMapper;

    @Autowired
    private ArbitratorInfoMapper arbitratorInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CaseNoSeqMapper caseNoSeqMapper;

    @Autowired
    private CaseDocMapper caseDocMapper;

    @Autowired
    private DocSendRecordMapper docSendRecordMapper;

    @Autowired
    private MicroFileService microFileService;

    @Autowired
    private MicroMessageService microMessageService;

    /**
     * 将案件流程推进到审理期
     *
     * @param caseId   案件Id
     * @param remark   推进原因
     *                 目前只有两种
     *                 1、正请求答辩期结束
     *                 2、正请求答辩期中,中途终止和解流程
     * @param isMorrow 是否次日开始计算
     * @return
     */
    public boolean replyToProcess(String caseId, ReplyToProcessRemarkEnum remark, boolean isMorrow) {
        sendGroupNotice(caseId);
        //修改主流程状态到审理期
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_PROCESSING.getCode());
        CaseInfoExample example = new CaseInfoExample();
        example.createCriteria().andIdEqualTo(caseId);
        caseInfoMapper.updateByExampleSelective(caseInfo, example);

        //修改前节点流动记录
        CaseNodeOper oldCaseNodeOper = new CaseNodeOper();
        Date nowTime = new Date();
        oldCaseNodeOper.setRealEndTime(nowTime);
        oldCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample updateOldCaseNodeOperRecord = new CaseNodeOperExample();
        updateOldCaseNodeOperRecord.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_REPLY.getCode());
        caseNodeOperMapper.updateByExampleSelective(oldCaseNodeOper, updateOldCaseNodeOperRecord);

        //添加节点流动记录
        CaseNodeOper newCaseNodeOper = new CaseNodeOper();
        newCaseNodeOper.setCaseId(caseId);
        newCaseNodeOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
        newCaseNodeOper.setCreateTime(nowTime);
        newCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
        newCaseNodeOper.setId(sequenceService.getCommonID());
        newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_PROCESSING.getCode());
        newCaseNodeOper.setOperRecord(remark.getRemark());

        //计划结束时间
        CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
        requestInfoExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectByExample(requestInfoExample);
        CaseRequestInfo requestInfo = caseRequestInfos.get(0);
        CaseTimeSet caseTimeSet;
        if (requestInfo.getCaseAmount().compareTo(DisputeAmountEnum.AMOUNT_SPLIT.getValue()) <= 0) {
            caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_LOWER.getValue());
        } else {
            caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_PROCESSING_UPPER.getValue());
        }
        newCaseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet(), isMorrow));
        newCaseNodeOper.setStartTime(nowTime);
        caseNodeOperMapper.insertSelective(newCaseNodeOper);
        return true;
    }

    /**
     * 案件结案
     *
     * @param formData
     * @return
     */
    public boolean caseOver(CaseOverDTO formData) {
        CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria()
                .andIdEqualTo(formData.getCaseId());
        CaseInfo caseInfo = caseInfoMapper.selectByExample(caseInfoExample).get(0);

        CaseRequestInfoExample requestInfoExample = new CaseRequestInfoExample();
        requestInfoExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        CaseRequestInfo requestInfo = caseRequestInfoMapper.selectByExample(requestInfoExample).get(0);

        //修改主流程状态
        String result = formData.getResult();
        CaseInfo updateCaseInfo = new CaseInfo();
        if ("0".equals(result) || "2".equals(result) || "3".equals(result)) {
            //0- 双方撤案 2- 案件转线下 3- 下达调解书
            updateCaseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_OVER.getCode());
        } else if ("1".equals(result)) {
            //1- 下达裁决书
            updateCaseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_OFFSET.getCode());
        }
        CaseInfoExample example = new CaseInfoExample();
        example.createCriteria().andIdEqualTo(formData.getCaseId());
        caseInfoMapper.updateByExampleSelective(updateCaseInfo, example);

        //修改前节点流动记录
        CaseNodeOper oldCaseNodeOper = new CaseNodeOper();
        Date nowTime = new Date();
        oldCaseNodeOper.setRealEndTime(nowTime);
        oldCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        CaseNodeOperExample updateOldCaseNodeOperRecord = new CaseNodeOperExample();
        updateOldCaseNodeOperRecord.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andNodeIdEqualTo(caseInfo.getCurrentMainNode());
        caseNodeOperMapper.updateByExampleSelective(oldCaseNodeOper, updateOldCaseNodeOperRecord);

        //如果为下达裁决书类型，先插入下达裁决书记录
        if ("1".equals(result)) {
            //插入操作记录
            CaseNodeOper caseNodeOper = new CaseNodeOper();
            caseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
            caseNodeOper.setStartTime(new Date());
            //计划结束时间
            caseNodeOper.setPlanEndTime(new Date());
            caseNodeOper.setRealEndTime(new Date());
            caseNodeOper.setOperRecord("下达裁决书");
            caseNodeOper.setNodeId(CaseMainNodeEnum.CASE_ARBI.getCode());
            caseNodeOper.setId(sequenceService.getCommonID());
            caseNodeOper.setCreateTime(new Date());
            caseNodeOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
            caseNodeOper.setCaseId(formData.getCaseId());
            caseNodeOperMapper.insertSelective(caseNodeOper);
        }

        String operRecordStr;
        if ("0".equals(result)) {
            //0- 双方撤案
            operRecordStr = "双方撤案，案件结案";
        } else if ("1".equals(result)) {
            //1- 下达裁决书
            operRecordStr = "已下达仲裁决定书，案件结案";
        } else if ("2".equals(result)) {
            //2- 案件转线下
            operRecordStr = "案件转线下，案件结案";
        } else if ("3".equals(result)) {
            //3- 下达调解书
            operRecordStr = "已下达调解书，案件结案";
        } else {
            operRecordStr = "";
        }
        //插入操作记录
        CaseNodeOper caseNodeOper = new CaseNodeOper();
        caseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        caseNodeOper.setStartTime(new Date());
        //计划结束时间
        caseNodeOper.setPlanEndTime(new Date());
        caseNodeOper.setRealEndTime(new Date());
        caseNodeOper.setOperRecord(operRecordStr);
        caseNodeOper.setNodeId(CaseMainNodeEnum.CASE_OVER.getCode());
        caseNodeOper.setId(sequenceService.getCommonID());
        caseNodeOper.setCreateTime(new Date());
        caseNodeOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
        caseNodeOper.setCaseId(formData.getCaseId());
        caseNodeOperMapper.insertSelective(caseNodeOper);

        //如果为下达裁决书类型，先插入下达裁决书记录
        if ("1".equals(result)) {
            //插入操作记录
            CaseNodeOper offsetNodeOper = new CaseNodeOper();
            offsetNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
            offsetNodeOper.setStartTime(new Date());
            //计划结束时间
            CaseTimeSet caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_OFFSET.getValue());
            caseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet()));
            offsetNodeOper.setOperRecord("补正期");
            offsetNodeOper.setNodeId(CaseMainNodeEnum.CASE_OFFSET.getCode());
            offsetNodeOper.setId(sequenceService.getCommonID());
            offsetNodeOper.setCreateTime(new Date());
            offsetNodeOper.setCreaterId(SysUserEnum.SYSTEM.getValue());
            offsetNodeOper.setCaseId(formData.getCaseId());
            caseNodeOperMapper.insertSelective(offsetNodeOper);
        }
        return true;
    }


    /**
     * 下发组庭通知书
     *
     * @param caseId 案件Id
     * @return
     */
    public boolean sendGroupNotice(String caseId) {
        //todo:下发组庭通知书
        Font titlefont = PDFUtil.createSTFont(20, Font.BOLD);
        Font contentFont = PDFUtil.createFSFont(14, Font.NORMAL);
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
        UserInfo caseProposer = userInfoMapper.queryProposerUserInfoByCaseId(caseId);
        UserInfo caseDefendant = userInfoMapper.queryDefendantUserInfoByCaseId(caseId);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId).getArbitratorId());
        //申请人组庭通知书
        PDFUtil proposerPDFUtil = new PDFUtil();
        proposerPDFUtil.createDocument();
        proposerPDFUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会", titlefont);
        proposerPDFUtil.writeParagraphToDocAligment("仲 裁 庭 组 成 通 知 书", titlefont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs(caseInfo.getCaseNo(), contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeBr();
                //仲裁员，申请人，被申请人
        proposerPDFUtil.writeStringStrs(caseProposer.getName() + "：", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("申请人与被申请人关于" + caseInfo.getCaseTypeId() + "一案,由本会仲裁员" + userInfo.getName() + "组成仲裁庭," + userInfo.getName() + "为独任仲裁员。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("特此通知。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs("珠海仲裁委员会", contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeDateToDoc(contentFont);

        //被申请方组庭通知书
        PDFUtil defendantPDFUtil = new PDFUtil();
        defendantPDFUtil.createDocument();
        proposerPDFUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会", titlefont);
        proposerPDFUtil.writeParagraphToDocAligment("仲 裁 庭 组 成 通 知 书", titlefont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs(caseInfo.getCaseNo(), contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeBr();
                //仲裁员，申请人，被申请人
        proposerPDFUtil.writeStringStrs(caseDefendant.getName() + "：", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("申请人与被申请人关于" + caseInfo.getCaseTypeId() + "一案,由本会仲裁员" + userInfo.getName() + "组成仲裁庭," + userInfo.getName() + "为独任仲裁员。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("特此通知。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs("珠海仲裁委员会", contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeDateToDoc(contentFont);

        //仲裁员组庭通知书
        PDFUtil arbitratorPDFUtil = new PDFUtil();
        arbitratorPDFUtil.createDocument();
        proposerPDFUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会", titlefont);
        proposerPDFUtil.writeParagraphToDocAligment("仲 裁 庭 组 成 通 知 书", titlefont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs(caseInfo.getCaseNo(), contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeBr();
                //仲裁员，申请人，被申请人
        proposerPDFUtil.writeStringStrs(userInfo.getName() + "：", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("申请人与被申请人关于" + caseInfo.getCaseTypeId() + "一案,由本会仲裁员" + userInfo.getName() + "组成仲裁庭," + userInfo.getName() + "为独任仲裁员。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeParagraphToDoc("特此通知。", contentFont);
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeBr();
        proposerPDFUtil.writeStringStrs("珠海仲裁委员会", contentFont, Element.ALIGN_RIGHT);
        proposerPDFUtil.writeDateToDoc(contentFont);

        MultipartFile proposerUpload = new MyMultipartFile("uploadFile", sequenceService.getCommonID(), proposerPDFUtil.getOut().toByteArray());
        MultipartFile defendantUpload = new MyMultipartFile("uploadFile", sequenceService.getCommonID(), defendantPDFUtil.getOut().toByteArray());
        MultipartFile arbitratorUpload = new MyMultipartFile("uploadFile", sequenceService.getCommonID(), arbitratorPDFUtil.getOut().toByteArray());

        ApiResultVO<String> proposerFile = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), proposerUpload);
        ApiResultVO<String> defendantFile = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), defendantUpload);
        ApiResultVO<String> arbitratorFile = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), arbitratorUpload);

        MailInfoDTO mailInfoDTO = new MailInfoDTO();
        String[] attachmentIds = new String[]{proposerFile.getBody()};
        mailInfoDTO.setAttachmentIDs(attachmentIds);
        mailInfoDTO.setBuzzId(caseId);
        mailInfoDTO.setContent("");
        mailInfoDTO.setSubject("组庭通知");
        String[] toEmail = new String[]{caseProposer.getEmail()};
        mailInfoDTO.setTo(toEmail);
        mailInfoDTO.setUserId(SysUserEnum.SYSTEM.getValue());
        microMessageService.sendMail(mailInfoDTO);

        mailInfoDTO = new MailInfoDTO();
        attachmentIds = new String[]{defendantFile.getBody()};
        mailInfoDTO.setAttachmentIDs(attachmentIds);
        mailInfoDTO.setBuzzId(caseId);
        mailInfoDTO.setContent("");
        mailInfoDTO.setSubject("组庭通知");
        toEmail = new String[]{caseDefendant.getEmail()};
        mailInfoDTO.setTo(toEmail);
        mailInfoDTO.setUserId(SysUserEnum.SYSTEM.getValue());
        microMessageService.sendMail(mailInfoDTO);

        mailInfoDTO = new MailInfoDTO();
        attachmentIds = new String[]{arbitratorFile.getBody()};
        mailInfoDTO.setAttachmentIDs(attachmentIds);
        mailInfoDTO.setBuzzId(caseId);
        mailInfoDTO.setContent("");
        mailInfoDTO.setSubject("组庭通知");
        toEmail = new String[]{userInfo.getEmail()};
        mailInfoDTO.setTo(toEmail);
        mailInfoDTO.setUserId(SysUserEnum.SYSTEM.getValue());
        microMessageService.sendMail(mailInfoDTO);

        //插入文书表
        CaseDoc caseDoc = new CaseDoc();
        caseDoc.setDocName(CaseDocTypeEnum.TRIBUNAL_NOTICE.getDocName());
        caseDoc.setDocType(CaseDocTypeEnum.TRIBUNAL_NOTICE.getCode());
        caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
        caseDoc.setCaseId(caseId);
        CaseNoSeq caseNoSeq = caseNoSeqMapper.queryCaseNoByCsaeId(caseId);
        caseDoc.setDocYearNumber(caseNoSeq.getYear());
        caseDoc.setDocSerialNumber(caseNoSeq.getNo().toString());
        caseDoc.setCreaterId(SysUserEnum.SYSTEM.getValue());
        caseDoc.setCreateTime(new Date());

        String proposerDocId = sequenceService.getCommonID();
        String defendantDocId = sequenceService.getCommonID();
        String arbitratorDocId = sequenceService.getCommonID();
        //申请人
        caseDoc.setId(proposerDocId);
        caseDocMapper.insertSelective(caseDoc);
        //被申请人
        caseDoc.setId(defendantDocId);
        caseDocMapper.insertSelective(caseDoc);
        //仲裁员
        caseDoc.setId(arbitratorDocId);
        caseDocMapper.insertSelective(caseDoc);

        DocSendRecord docSendRecord = new DocSendRecord();
        docSendRecord.setCaseId(caseId);
        docSendRecord.setCreaterId(SysUserEnum.SYSTEM.getValue());
        docSendRecord.setCreateTime(new Date());
        docSendRecord.setSendType("2");
        docSendRecord.setStatus(0);

        docSendRecord.setId(sequenceService.getCommonID());
        docSendRecord.setReceiverType("0");
        docSendRecord.setReceiverId(caseProposer.getId());
        docSendRecord.setDocId(proposerDocId);
        docSendRecordMapper.insertSelective(docSendRecord);

        docSendRecord.setId(sequenceService.getCommonID());
        docSendRecord.setReceiverType("1");
        docSendRecord.setReceiverId(caseDefendant.getId());
        docSendRecord.setDocId(defendantDocId);
        docSendRecordMapper.insertSelective(docSendRecord);

        docSendRecord.setId(sequenceService.getCommonID());
        docSendRecord.setReceiverType("4");
        docSendRecord.setReceiverId(userInfo.getId());
        docSendRecord.setDocId(arbitratorDocId);
        docSendRecordMapper.insertSelective(docSendRecord);

        //修改下发状态
        CaseArbitrator caseArbitrator = new CaseArbitrator();
        caseArbitrator.setSendGroupNotice(CaseArbitratorSendGroupNoticeEnum.YES.getCode());
        caseArbitrator.setSendGroupNoticeTime(new Date());
        CaseArbitratorExample example = new CaseArbitratorExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
        caseArbitratorMapper.updateByExampleSelective(caseArbitrator, example);
        return true;
    }

    /**
     * 和解结束方法
     *
     * @param caseId 案件Id
     * @return
     */
    public boolean compromiseOver(String caseId) {
        //修改和解状态，修改和解结束时间
        CompromiseApply compromiseApply = new CompromiseApply();
        compromiseApply.setCaseId(caseId);
        compromiseApply = compromiseApplyMapper.selectCompromiseByCaseId(compromiseApply);
        CompromiseApply newCompromiseApply = new CompromiseApply();
        newCompromiseApply.setId(compromiseApply.getId());
        newCompromiseApply.setStatus(ComproiseApplyStatusEnum.FINISH.getValue());
        newCompromiseApply.setRealEndTime(new Date());
        compromiseApplyMapper.updateByPrimaryKeySelective(newCompromiseApply);
        Date compromiseStartTime = compromiseApply.getStartTime();
        //是否在答辩期
        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
        boolean isReplyExpect = caseInfo.getCurrentMainNode().equals(CaseMainNodeEnum.CASE_REPLY.getCode());
        if (isReplyExpect) {
            boolean isSendGroupNotice = isSendGroupNotice(caseId);
            if (isSendGroupNotice) {
                //进入审理期
                replyToProcess(caseId, ReplyToProcessRemarkEnum.CASE_COMPROMISE_TERMINATION, true);
            } else {
                CaseReplyTimeRecordExample caseReplyTimeRecordExample = new CaseReplyTimeRecordExample();
                caseReplyTimeRecordExample.createCriteria()
                        .andCaseIdEqualTo(caseId);
                List<CaseReplyTimeRecord> caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(caseReplyTimeRecordExample);
                Date requestReplyEndTime;
                for (CaseReplyTimeRecord caseReplyTimeRecord : caseReplyTimeRecords) {
                    requestReplyEndTime = caseReplyTimeRecord.getEndTime();
                    //答辩期是否结束
                    if (!(requestReplyEndTime.compareTo(new Date()) < 0)) {
//                  将答辩期加上指定时间
//                  计算方式：
//                  答辩计划结束时间 - 和解开始时间
//                  （次日算起）
                        long divide = getDivide(compromiseStartTime, requestReplyEndTime);
                        caseReplyTimeRecord.setEndTime(workDayService.after(requestReplyEndTime, divide, false));
                        caseReplyTimeRecordMapper.updateByPrimaryKeySelective(caseReplyTimeRecord);
                    }
                }
            }
        } else {
            Date processingEndTime = processingTime(caseId);
//            将审理期加上指定时间
//            计算方式：
//            审理计划结束时间 - 和解开始时间
//            （次日算起）86400000 =  1000 / 60 / 60 / 24
            Long divide = getDivide(compromiseStartTime, processingEndTime);
            processingEndTime = workDayService.after(processingEndTime, divide);
            CaseNodeOperExample caseNodeOperExample = new CaseNodeOperExample();
            caseNodeOperExample.createCriteria()
                    .andCaseIdEqualTo(caseId)
                    .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PROCESSING.getCode());
            CaseNodeOper caseNodeOper = new CaseNodeOper();
            caseNodeOper.setPlanEndTime(processingEndTime);
            caseNodeOperMapper.updateByExampleSelective(caseNodeOper, caseNodeOperExample);
        }
        return true;
    }

    /**
     * 得到时间差天数
     *
     * @param compromiseStartTime
     * @param requestReplyTime
     * @return
     */
    private long getDivide(Date compromiseStartTime, Date requestReplyTime) {
        return new BigDecimal(requestReplyTime.getTime() - compromiseStartTime.getTime()).divide(new BigDecimal(86400000), RoundingMode.UP).longValue();
    }

    /**
     * 审理期结束时间
     *
     * @param caseId 案件Id
     * @return 答辩期结束时间
     */
    private Date processingTime(String caseId) {
        CaseNodeOperExample caseNodeOperExample = new CaseNodeOperExample();
        caseNodeOperExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PROCESSING.getCode());
        CaseNodeOper caseNodeOper = caseNodeOperMapper.selectByExample(caseNodeOperExample).get(0);
        return caseNodeOper.getPlanEndTime();
    }

    /**
     * 是否已组庭
     *
     * @param caseId 案件Id
     * @return 是否已组庭
     */
    public boolean isSendGroupNotice(String caseId) {
        CaseArbitratorExample example = new CaseArbitratorExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andSendGroupNoticeEqualTo(CaseArbitratorSendGroupNoticeEnum.YES.getCode());
        List<CaseArbitrator> caseArbitrators = caseArbitratorMapper.selectByExample(example);
        //是否进行组庭
        return caseArbitrators != null && caseArbitrators.size() > 0;
    }

    /**
     * 放弃答辩期
     *
     * @param caseId 案件Id
     * @return 是否成功
     */
    public boolean giveReply(String caseId, String requestType) {
        //修改答辩期时间
        CaseReplyTimeRecordExample replyTimeRecordExample = new CaseReplyTimeRecordExample();
        replyTimeRecordExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(requestType);
        CaseReplyTimeRecord caseReplyTimeRecord = new CaseReplyTimeRecord();
        caseReplyTimeRecord.setEndTime(new Date());
        caseReplyTimeRecordMapper.updateByExampleSelective(caseReplyTimeRecord, replyTimeRecordExample);
        if (requestType.equals(RequestTypeEnum.REQUEST.getValue())) {
            CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
            String arbitratorId = caseArbitrator.getArbitratorId();
            //是否存在有效仲裁员
            if (StringUtils.isNotBlank(arbitratorId)) {
                //进入审理期
                replyToProcess(caseId, ReplyToProcessRemarkEnum.CASE_REPLY_OVER, true);
            } else {
                CaseArbitratorExample waitExample = new CaseArbitratorExample();
                waitExample.createCriteria()
                        .andCaseIdEqualTo(caseId)
                        .andStatusEqualTo(CaseArbitratorStatusEnum.WAIT_ACCEPT.getCode());
                List<CaseArbitrator> caseArbitrators = caseArbitratorMapper.selectByExample(waitExample);
                //是否已经存在待受理的仲裁员
                boolean haveArbi = caseArbitrators.size() > 0;
                if (!haveArbi) {
                    List<String> inTypes = new ArrayList<>();
                    //todo:枚举类
                    inTypes.add("0");
                    inTypes.add("1");
                    CaseArbitratorOperExample example = new CaseArbitratorOperExample();
                    example.createCriteria()
                            .andCaseIdEqualTo(caseId)
                            .andTypeIn(inTypes);
                    List<CaseArbitratorOper> caseArbitratorOpers = caseArbitratorOperMapper.selectByExample(example);
                    if (caseArbitratorOpers != null && caseArbitratorOpers.size() > 1) {
                        //分配仲裁员
                        //双方选择是否一致
                        boolean flag = true;
                        String oldArbitratorId = caseArbitratorOpers.get(0).getArbitratorId();
                        for (CaseArbitratorOper arbitratorOper : caseArbitratorOpers) {
                            if (!oldArbitratorId.equals(arbitratorOper.getArbitratorId())) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            //不一致
                            caseArbitratorService.allotArbitrator(caseId);
                        } else {
                            //一致
                            caseArbitratorService.insertCaseArbitrator(caseId, oldArbitratorId, CaseArbitratorTypeEnum.PARTY_SELECTED);
                        }
                    } else {
                        caseArbitratorService.allotArbitrator(caseId);
                    }
                }
            }
        }
        return false;
    }

    /**
     * 撤案
     *
     * @param formData 案件Id
     * @return 是否成功
     */
    public boolean cancelCase(CaseCancelDTO formData) {
        String caseId = formData.getCaseId();
        String requestType = formData.getRequestType();
        //修改答辩期时间
        CaseReplyTimeRecordExample replyTimeRecordExample = new CaseReplyTimeRecordExample();
        replyTimeRecordExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(requestType);
        CaseReplyTimeRecord caseReplyTimeRecord = new CaseReplyTimeRecord();
        caseReplyTimeRecord.setEndTime(new Date());
        caseReplyTimeRecordMapper.updateByExampleSelective(caseReplyTimeRecord, replyTimeRecordExample);

        //修改该请求为已撤案
        CaseRequestInfoWithBLOBs caseRequestInfoWithBLOBs = new CaseRequestInfoWithBLOBs();
        caseRequestInfoWithBLOBs.setStatus(CaseRequestInfoStatusEnum.CANCEL.getValue());
        CaseRequestInfoExample caseRequestInfoExample = new CaseRequestInfoExample();
        caseRequestInfoExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(requestType);
        caseRequestInfoMapper.updateByExampleSelective(caseRequestInfoWithBLOBs, caseRequestInfoExample);

        //是否还有正常的请求
        caseRequestInfoExample = new CaseRequestInfoExample();
        caseRequestInfoExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andStatusEqualTo(CaseRequestInfoStatusEnum.NORMAL.getValue());
        List<CaseRequestInfo> caseRequestInfos = caseRequestInfoMapper.selectByExample(caseRequestInfoExample);
        if (caseRequestInfos == null || caseRequestInfos.isEmpty()) {
            CaseOverDTO caseOverDTO = new CaseOverDTO();
//            0- 双方撤案，1- 下达裁决书，2- 案件转线下，3- 下达调解书
            caseOverDTO.setResult("0");
            caseOverDTO.setCaseId(caseId);
            return caseOver(caseOverDTO);
        }
        return true;
    }
}
