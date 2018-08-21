package com.zyxy.service.micro.core.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.zyxy.common.custom.MyMultipartFile;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.CaseDocDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.*;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.ImageUtil;
import com.zyxy.common.util.PDFUtil;
import com.zyxy.common.vo.*;
import com.zyxy.common.vo.doc.CaseDocHeadVO;
import com.zyxy.service.micro.core.service.CaseDocService;
import com.zyxy.service.micro.core.service.CommonService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * 案件文书serviceImpl
 */
@Service
public class CaseDocServiceImpl implements CaseDocService {

    @Autowired
    private CaseDocMapper caseDocMapper;

    @Autowired
    private CaseAgentMapper caseAgentMapper;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseChangeRecordMapper caseChangeRecordMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private CaseDocGeneraService caseDocGeneraService;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private SignetService signetService;

    @Autowired
    private MicroFileService microFileService;


    @Autowired
    private CaseArbitratorMapper caseArbitratorMapper;

    @Autowired
    private CaseRejoinRecordMapper caseRejoinRecordMapper;

    @Autowired
    private CaseDocContentMapper caseDocContentMapper;
    @Autowired
    private CaseMatMapper caseMatMapper;

    @Autowired
    private CasePeopleService casePeopleService;
    @Autowired
    private CaseProtocolRecordMapper caseProtocolRecordMapper;

    @Autowired
    private PayOrderTranMapper payOrderTranMapper;

    @Autowired
    private CaseJurisDisMapper caseJurisDisMapper;

    /**
     * 查询案件文书业务处理
     * @param caseId
     * @param userId
     * @return
     */
    @Override
    public BusiExecuteResult<CaseDocVO> queryCaseDocBusiExecute(String caseId,String userId) {
        CaseDocDTO formData=new CaseDocDTO();
        formData.setDuties(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        formData.setUserId(userId);
        formData.setDocStatus(CaseDocStatusEnum.NORMAL.getCode());
        formData.setDocType(CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
        formData.setArbitratorStatus(CaseArbitratorStatusEnum.OK.getCode());
        formData.setCaseId(caseId);
        return queryCaseDocHandling(formData);
    }


    /***私有service**/
    /**
     * 查询出裁决书，
     * 并根据案件id查询出该案件的申请人的代理人以及被申请人的代理人，并合并为一个对象
     * @param formData
     * @return
     */
    private BusiExecuteResult<CaseDocVO> queryCaseDocHandling(CaseDocDTO formData) {
        //查询出裁决书
        CaseDocVO caseDocVO = caseDocMapper.queryCaseDoc(formData);
        //判断裁决书是否为空
        if(caseDocVO!=null) {
            //查询出该案件的代理人信息
            List<CaseAgentVO> caseAgentVOList = caseAgentMapper.queryAgentByCaseId(formData.getCaseId());

            for (int i = 0;i<caseAgentVOList.size();i++){
                //判断是申请人的代理人还是被申请人的代理人
                if(CaseAgentTypeEnum.PROP_AGENT.getCode().equals(caseAgentVOList.get(i).getLitigantType())){
                    caseDocVO.setPropAgentName(caseAgentVOList.get(i).getName());
                }else{
                    caseDocVO.setDepeAgentName(caseAgentVOList.get(i).getName());
                }
            }
            return BusiExecuteResult.builderSuccessResult(caseDocVO);
        }
        return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
    }


	@Override
	public BusiValidResult caseDocListBusiValid(String caseId, String userId) {
		BusiValidResult commonValid = commonService.commonCaseAndUserValid(caseId, userId);
		if (commonValid.hasError()) {
			return BusiValidResult.builderErrorResult(commonValid.getCode(), commonValid.getMsg());
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<?> caseDocListBusiExecute(String caseId,
			String userId) {
		CaseDocExample example = new CaseDocExample();
		example.createCriteria().andCaseIdEqualTo(caseId);
		List<CaseDoc> caseDocs = caseDocMapper.selectByExample(example);
		return BusiExecuteResult.builderSuccessResult(caseDocs);
	}


    @Override
    public BusiExecuteResult<String> generationapplicationArbitrationDoc(String caseId, String userId) {

        //查询
        CaseRequestInfo paramRequestInfo=new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo=new CaseRequestInfoWithBLOBs();
        caseRequestInfo=caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        if(caseRequestInfo==null){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
        }
        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("仲裁申请书",titlefont);

        //换行
        pdfUtil.writeBr();

        Document document = pdfUtil.getDocument();

       //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);
        pdfUtil.writeBr();
        //不缩进段落
        pdfUtil.writeParagraphToDoc("仲裁请求：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getArbClaim(),contentFont);
        pdfUtil.writeParagraphToDoc("事实与理由",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getFact(), contentFont);

        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocIndent("申请人：" + caseDocHead.getApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);

        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        String[] users = new String[]{userId};
        ApiResultVO<String> signet = signetService.signet(fileId, null, CaseDocTypeEnum.ARBITRATOR_AVOID_APPLY, users);

        return signet.getHead().getRetCode().equals(ApiResultVO.Coder.SUCCESS.getCode()) ? BusiExecuteResult.builderSuccessResult(signet.getBody()) : BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);


    }

    @Override
    public BusiExecuteResult<String> generationAdjudicationArbitrationDoc(String caseId, String userId) {
        //查询
        CaseRequestInfo paramRequestInfo=new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo=new CaseRequestInfoWithBLOBs();
        caseRequestInfo=caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        if(caseRequestInfo==null){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
        }

        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(22,Font.BOLD);
        Font subTitlefont=PDFUtil.createSTFont(26,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(16,Font.NORMAL);

        Document document = pdfUtil.getDocument();

        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("裁 决 书",subTitlefont);
        pdfUtil.writeParagraphToDocAligmentRight(caseInfo.getCaseNo(),contentFont);

        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);

        //判断签订合同还是协议
        if(caseInfo.getSignAbriProtocolMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())){
            //签订合同
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的《%s》中的仲裁条款和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    caseInfo.getProtocolName(),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }else{
            //签订协议
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的仲裁协议和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }

        pdfUtil.writeParagraphToDocIndent("根据《珠海仲裁委员会互联网金融仲裁规则》（以下简称《仲裁规则》）第  条的规定，本会向被申请人送达了仲裁受理通知书、仲裁申请书副本、仲裁规则、仲裁员名册等材料。",contentFont);
        //仲裁员
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        UserInfoVO caseArbitratorInfo = userInfoMapper.selectUserInFoByUserId(caseArbitrator.getArbitratorId());
        //判断是否系统(主任)指派
        if(caseArbitrator.getType().equalsIgnoreCase(CaseArbitratorTypeEnum.PARTY_SELECTED.getCode())){
            pdfUtil.writeParagraphToDocIndent(String.format("双方当事人未在规定期限内共同选定或共同委托本会主任指定独任仲裁员，根据《中华人民共和国仲裁法》（以下简称《仲裁法》）第三十二条、《仲裁规则》第  条的规定，本会主任指定%s为本案独任仲裁员，仲裁庭于%s成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。",
                    caseArbitratorInfo.getName(),
                    PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);
        }else{
            pdfUtil.writeParagraphToDocIndent(String.format("在本会《仲裁规则》规定期限内，双方共同选定仲裁员%s组成独任仲裁庭，仲裁庭于%s成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。",
                    caseArbitratorInfo.getName(),
                    PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);
        }
        pdfUtil.writeParagraphToDocIndent("本案已审理终结，现予以裁决。",contentFont);

        //仲裁请求与答辩
        pdfUtil.writeParagraphToDocAligment("一、仲裁请求与答辩",contentFont);
        pdfUtil.writeParagraphToDocIndent("申请人向本会提出如下仲裁请求：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getArbClaim(),contentFont);
        pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getFact(),contentFont);

        //判断被申请人本请求有无答辩
        CaseRejoinRecordExample rejoinExample = new CaseRejoinRecordExample();
        rejoinExample.createCriteria()
                .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                .andRejoinTyepEqualTo(ReplyTypeEnum.REQUEST.getValue())
                .andCaseIdEqualTo(caseId);
        List<CaseRejoinRecordWithBLOBs> requestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(rejoinExample);
        if(requestJoinList == null || requestJoinList.size()==0){
            //被申请人无答辩
            pdfUtil.writeParagraphToDocIndent("被申请人未对申请人的仲裁请求作出答辩。",contentFont);
        }else{
            //被申请人有答辩
            pdfUtil.writeParagraphToDocIndent("被申请人对申请人的仲裁请求作出如下答辩：",contentFont);
            pdfUtil.writeStringStrs(requestJoinList.get(0).getRejoinText(),contentFont);
        }
        //判断申请人本请求有无变更
        CaseChangeRecordExample changeRecordExample = new CaseChangeRecordExample();
        rejoinExample.createCriteria()
                .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                .andStatusEqualTo(NumberUtils.toInt(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue()))
                .andCaseIdEqualTo(caseId);
        rejoinExample.setOrderByClause("create_time desc");
        List<CaseChangeRecordWithBLOBs> changeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
        if(changeRecordList == null || changeRecordList.size()==0){
            //本请求无变更
        }else{
            //本请求有变更
            CaseChangeRecordWithBLOBs caseChangeRecord = changeRecordList.get(0);
            pdfUtil.writeParagraphToDocIndent(String.format("申请人又于%s向本会提交书面变更仲裁请求申请书，变更仲裁请求为：",
                    PDFUtil.getUpperDate(caseChangeRecord.getCreateTime())),contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getChangeRequest(),contentFont);
            pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getFactReason(),contentFont);
            //判断变更本请求有无答辩
            CaseRejoinRecordExample changeRejoinExample = new CaseRejoinRecordExample();
            rejoinExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue())
                    .andRejoinTyepEqualTo(ReplyTypeEnum.CHANGE_REUEST.getValue())
                    .andCaseIdEqualTo(caseId);
            List<CaseRejoinRecordWithBLOBs> changeRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(rejoinExample);
            if(changeRequestJoinList == null || changeRequestJoinList.size()==0){
                //变更请求被申请人无答辩
                pdfUtil.writeParagraphToDocIndent("被申请人未对申请人的变更仲裁请求作出答辩。",contentFont);
            }else{
                //变更请求被申请人有答辩
                pdfUtil.writeParagraphToDocIndent("被申请人对申请人的变更仲裁请求作出如下答辩：：",contentFont);
                pdfUtil.writeStringStrs(changeRequestJoinList.get(0).getRejoinText(),contentFont);
            }
        }
        //判断是否有反请求
        CaseRequestInfoExample beRequestInfoExample = new CaseRequestInfoExample();
        beRequestInfoExample.createCriteria()
                .andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                .andCaseIdEqualTo(caseId);
        List<CaseRequestInfoWithBLOBs> beRequestInfoList = caseRequestInfoMapper.selectByExampleWithBLOBs(beRequestInfoExample);
        if(beRequestInfoList == null || beRequestInfoList.size() == 0){
            //无反请求
        }else{
            //有反请求
            pdfUtil.writeParagraphToDocIndent("被申请人向本会提出如下仲裁反请求：",contentFont);
            pdfUtil.writeStringStrs(beRequestInfoList.get(0).getArbClaim(),contentFont);
            pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
            pdfUtil.writeStringStrs(beRequestInfoList.get(0).getFact(),contentFont);
            //判断反请求是否有答辩
            CaseRejoinRecordExample beRejoinExample = new CaseRejoinRecordExample();
            beRejoinExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                    .andRejoinTyepEqualTo(ReplyTypeEnum.REQUEST.getValue())
                    .andCaseIdEqualTo(caseId);
            List<CaseRejoinRecordWithBLOBs> beRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(beRejoinExample);
            if(beRequestJoinList == null || beRequestJoinList.size()==0){
                //申请人无答辩
                pdfUtil.writeParagraphToDocIndent("申请人未对被申请人的仲裁反请求作出答辩。",contentFont);
            }else{
                //申请人有答辩
                pdfUtil.writeParagraphToDocIndent("申请人对被申请人的仲裁反请求作出如下答辩：",contentFont);
                pdfUtil.writeStringStrs(beRequestJoinList.get(0).getRejoinText(),contentFont);
            }
            //判断反请求是否有变更
            CaseChangeRecordExample beChangeRecordExample = new CaseChangeRecordExample();
            beChangeRecordExample.createCriteria()
                    .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                    .andStatusEqualTo(CaseChangeStatusEnum.SUCCESS_AUDIT.getValue())
                    .andCaseIdEqualTo(caseId);
            rejoinExample.setOrderByClause("create_time desc");
            List<CaseChangeRecordWithBLOBs> beChangeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
            if(beChangeRecordList == null || beChangeRecordList.size()==0){
                //反请求无变更
            }else{
                //反请求有变更
                CaseChangeRecordWithBLOBs beCaseChangeRecord = beChangeRecordList.get(0);
                pdfUtil.writeParagraphToDocIndent(String.format("被申请人又于%s向本会提交书面变更仲裁反请求申请书，变更仲裁反请求为：",
                        PDFUtil.getUpperDate(beCaseChangeRecord.getCreateTime())),contentFont);
                pdfUtil.writeStringStrs(beCaseChangeRecord.getChangeRequest(),contentFont);
                pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
                pdfUtil.writeStringStrs(beCaseChangeRecord.getFactReason(),contentFont);
                //判断变更反请求是否有答辩
                CaseRejoinRecordExample beChangeRejoinExample = new CaseRejoinRecordExample();
                beChangeRejoinExample.createCriteria()
                        .andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                        .andRejoinTyepEqualTo(ReplyTypeEnum.CHANGE_REUEST.getValue())
                        .andCaseIdEqualTo(caseId);
                List<CaseRejoinRecordWithBLOBs> beChangeRequestJoinList = caseRejoinRecordMapper.selectByExampleWithBLOBs(beChangeRejoinExample);
                if(beChangeRequestJoinList == null || beChangeRequestJoinList.size()==0){
                    //申请人无答辩
                    pdfUtil.writeParagraphToDocIndent("申请人未对被申请人的变更仲裁反请求作出答辩。",contentFont);
                }else{
                    //申请人有答辩
                    pdfUtil.writeParagraphToDocIndent("申请人对被申请人的变更仲裁反请求作出如下答辩：",contentFont);
                    pdfUtil.writeStringStrs(beChangeRequestJoinList.get(0).getRejoinText(),contentFont);
                }
            }
        }
        //二、举证与质证
        pdfUtil.writeParagraphToDocAligment("二、举证与质证",contentFont);
        //申请人举证
        List<EvidenceVO> proposerMatList = caseMatMapper.selectEvidencesParam(caseId, EvidenceTypeEnum.PROPOSER.getValue());
        if(proposerMatList!=null && proposerMatList.size()>0){
            String matStr = "";
            String oppugnStr = "";
            for(int i=0;i<proposerMatList.size();i++){
                String pixMat = "证据"+number2Chinese((i+1)+"")+"，";
                matStr += (pixMat+proposerMatList.get(i).getEvidenceMat()+"；");
                if(StringUtils.isNotBlank(proposerMatList.get(i).getOppugnEvidence())){
                    oppugnStr += (pixMat+proposerMatList.get(i).getOppugnEvidence()+"；");
                }
            }
            pdfUtil.writeParagraphToDocIndent("申请人提供如下证据："+matStr,contentFont);
            if(StringUtils.isNotBlank(oppugnStr)){
                pdfUtil.writeParagraphToDocIndent("被申请人对申请人提供的证据发表如下质证意见："+oppugnStr,contentFont);
            }else{
                pdfUtil.writeParagraphToDocIndent("被申请人未对申请人提供的证据发表质证意见。",contentFont);
            }
        }
        //被申请人举证
        List<EvidenceVO> defendantMatList = caseMatMapper.selectEvidencesParam(caseId, EvidenceTypeEnum.DEFENDANT.getValue());
        if(defendantMatList!=null && defendantMatList.size()>0){
            String matStr = "";
            String oppugnStr = "";
            for(int i=0;i<defendantMatList.size();i++){
                String pixMat = "证据"+number2Chinese((i+1)+"")+"，";
                matStr += (pixMat+defendantMatList.get(i).getEvidenceMat()+"；");
                if(StringUtils.isNotBlank(defendantMatList.get(i).getOppugnEvidence())){
                    oppugnStr += (pixMat+defendantMatList.get(i).getOppugnEvidence()+"；");
                }
            }
            pdfUtil.writeParagraphToDocIndent("被申请人提供如下证据："+matStr,contentFont);
            if(StringUtils.isNotBlank(oppugnStr)){
                pdfUtil.writeParagraphToDocIndent("申请人对被申请人提供的证据发表如下质证意见："+oppugnStr,contentFont);
            }else{
                pdfUtil.writeParagraphToDocIndent("申请人未对被申请人提供的证据发表质证意见。",contentFont);
            }
        }
        pdfUtil.writeParagraphToDocIndent("仲裁庭对上述证据的采信意见如下：",contentFont);

        CaseDocContentWithBLOBs caseDocContent = caseDocContentMapper.queryCaseDocContentByCaseIdAndDocType(caseId,CaseDocTypeEnum.ARBITRAL_AWARD_BOOK.getCode());
        //三、事实认定
        pdfUtil.writeParagraphToDocAligment("三、事实认定",contentFont);
        pdfUtil.writeParagraphToDocIndent("本庭经审理查明："+caseDocContent.getBodyText(),contentFont);
        //四、仲裁庭意见
        pdfUtil.writeParagraphToDocAligment("四、仲裁庭意见",contentFont);
        pdfUtil.writeParagraphToDocIndent("根据现有证据材料及以上事实认定，仲裁庭对本案形成以下意见："+caseDocContent.getOpinion(),contentFont);
        //五、裁决
        pdfUtil.writeParagraphToDocAligment("五、裁决",contentFont);
        pdfUtil.writeParagraphToDocIndent(caseDocContent.getFinalDecision(),contentFont);
        pdfUtil.writeParagraphToDocIndent("本裁决为终局裁决，自作出之日起发生法律效力。",contentFont);

        //落款日期
        pdfUtil.writeParagraphToDocAligmentRight("仲  裁  员："+caseArbitratorInfo.getName(),contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("日期"+PDFUtil.getUpperDate(new Date()),contentFont);
        String secretaryId = caseManagerMapper.queryArbitrationUserId(caseId,ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
        UserInfoVO secretaryInfo = userInfoMapper.selectUserInFoByUserId(secretaryId);
        pdfUtil.writeParagraphToDocAligmentRight("秘     书："+secretaryInfo.getName(),contentFont);

        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        String[] users = new String[]{userId};
        ApiResultVO<String> signet = signetService.signet(fileId, null, CaseDocTypeEnum.ARBITRATOR_AVOID_APPLY, users);

        return signet.getHead().getRetCode().equals(ApiResultVO.Coder.SUCCESS.getCode()) ? BusiExecuteResult.builderSuccessResult(signet.getBody()) : BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.REQ_ERROR);
    }


    /**
     * 变更仲裁请求申请书
     * @param caseId
     * @param userId
     * @param changeId
     * @return
     */
    public BusiExecuteResult<?> generationChangeapplicationArbitrationDoc(String caseId,String userId,String changeId){
        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("变更仲裁请求申请书",titlefont);

        pdfUtil.writeBr();
        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDoc("申请事项：",contentFont);


        pdfUtil.writeParagraphToDoc("事实与理由：",contentFont);

        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);
        pdfUtil.writeParagraphToDocIndent("申请人：" + caseDocHead.getApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务



        return null;
    }


    /**
     * 反请求申请书
     * @return
     */
    public BusiExecuteResult<?> generateApplicationforCounterclaimDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("反请求申请书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"反请求申请人");
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"反请求被申请人");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDoc("反请求事项：",contentFont);


        pdfUtil.writeParagraphToDoc("事实与理由：",contentFont);

        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("申请人：" + caseDocHead.getBeApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 变更仲裁反请求申请书
     * @return
     */
    public BusiExecuteResult<?> generateChangeApplicationforCounterclaimDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("变更仲裁反请求申请书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"申请人：");
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"被申请人：");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDoc("申请事项：",contentFont);

        pdfUtil.writeStringStrs("",contentFont);


        pdfUtil.writeParagraphToDoc("事实与理由：",contentFont);

        pdfUtil.writeStringStrs("",contentFont);

        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("申请人：" + caseDocHead.getBeApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 仲裁答辩书
     * @return
     */
    public BusiExecuteResult<?> generateWrittenDefenseArbitrationDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("仲裁答辩书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"答辩人：");
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"被答辩人：");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        StringBuffer sb=new StringBuffer("答辩人与被答辩人");
        sb.append(caseDocHead.getApplicant().getName());
        sb.append("关于");
        sb.append("案由");
        sb.append("纠纷一案，依据事实和法律，发表如下答辩意见：");

        pdfUtil.writeParagraphToDoc(sb.toString(),contentFont);

        pdfUtil.writeStringStrs("",contentFont);


        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("答辩人：" + caseDocHead.getBeApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }

    /**
     * 变更仲裁请求答辩书
     * @return
     */
    public BusiExecuteResult<?> generateChangeWrittenDefenseArbitrationDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("变更仲裁请求答辩书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"答辩人：");
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"被答辩人：");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        StringBuffer sb=new StringBuffer("答辩人与被答辩人");
        sb.append(caseDocHead.getApplicant().getName());
        sb.append("关于");
        sb.append("案由");
        sb.append("纠纷一案，依据事实和法律，发表如下答辩意见：");

        pdfUtil.writeParagraphToDoc(sb.toString(),contentFont);

        pdfUtil.writeStringStrs("",contentFont);


        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("答辩人：" + caseDocHead.getBeApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 仲裁反请求答辩书
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimArbitrationDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("仲裁反请求答辩书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"答辩人：");
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"被答辩人：");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        StringBuffer sb=new StringBuffer("答辩人与被答辩人");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append("关于");
        sb.append("案由");
        sb.append("纠纷一案，依据事实和法律，发表如下答辩意见：");

        pdfUtil.writeParagraphToDoc(sb.toString(),contentFont);

        pdfUtil.writeStringStrs("",contentFont);


        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("答辩人：" + caseDocHead.getApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 变更仲裁反请求答辩书
     * @return
     */
    public BusiExecuteResult<?> generateChanageCounterclaimArbitrationDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("变更仲裁反请求答辩书",titlefont);

        pdfUtil.writeBr();
        //头部信息
        try {
            pdfUtil.writeApplicant(caseDocHead.getApplicant(),"答辩人：");
            pdfUtil.writeApplicant(caseDocHead.getBeApplicant(),"被答辩人：");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pdfUtil.writeBr();
        StringBuffer sb=new StringBuffer("答辩人与被答辩人");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append("关于");
        sb.append("案由");
        sb.append("纠纷一案，依据事实和法律，发表如下答辩意见：");

        pdfUtil.writeParagraphToDoc(sb.toString(),contentFont);

        pdfUtil.writeStringStrs("",contentFont);


        pdfUtil.writeParagraphToDocIndent("此致",contentFont);

        pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);

        pdfUtil.writeParagraphToDocIndent("答辩人：" + caseDocHead.getApplicant().getName(), contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }




    /**
     * 受理通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateNoticeActionDoc(String caseId){

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("受理仲裁申请通知书",titlefont);
        pdfUtil.writeBr();
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getApplicant().getName()+"：",contentFont);



        pdfUtil.writeParagraphToDocIndent("一、委托代理人的，请将授权委托书提交本会，授权委托书应载明委托事项和权限。",contentFont);
        pdfUtil.writeParagraphToDocIndent("二、请于收到此受理通知书之日起4日内与被申请人协商在本系统提供的仲裁员名单中共同选定或共同委托本会主任指定独任仲裁员。逾期，将由本会主任指定。",contentFont);
        pdfUtil.writeParagraphToDocIndent("三、如不按上述要求办理，不影响仲裁程序的进行，本会将依照《中华人民共和国仲裁法》和《珠海仲裁委员会互联网金融仲裁规则》进行仲裁。",contentFont);


        pdfUtil.writeParagraphToDoc("办案秘书：",contentFont);
        pdfUtil.writeParagraphToDoc("联系方式：",contentFont);





        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 受理通知书 to 被申请人
     * @return
     */
    public BusiExecuteResult<?> generateNoticeActionToDefentDoc(String caseId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);
        CaseRequestInfo caseRequestInfo=new CaseRequestInfo();
        caseRequestInfo.setCaseId(caseId);
        caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(caseRequestInfo.getId());
        caseReplyTimeRecord.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        UserInfo managerInfo=casePeopleService.getArbitrationPeopleUserInfo(caseId,ManagerInfoTypeEnum.ARBITRATION_SECRETARY);

        CaseRequestInfo caseRequestInfo1=caseRequestInfoMapper.selectRequestByParam(caseRequestInfo);

        CaseReplyTimeRecord caseReplyTimeRecord1=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);




        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("受理仲裁申请通知书",titlefont);
        pdfUtil.writeBr();
        //头部信息


        pdfUtil.writeParagraphToDoc(caseDocHead.getBeApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();
        pdfUtil.writeParagraphToDocIndent(caseDocHead.getApplicant().getName()+"已就其与你方关于"+caseType+"合同纠纷一案向本会申请仲裁。现就有关事项通知如下：",contentFont);

        BigDecimal bigDecimal=new BigDecimal(50000);


        //标的金额大于50000
        if(caseRequestInfo.getCaseAmount().compareTo(bigDecimal)==1){
            pdfUtil.writeParagraphToDocIndent("一、请于收到本通知和申请书副本之日起4日内按照《珠海仲裁委员会互联网金融仲裁规则》的规定向本会提交答辩书和其他有关证据材料。",contentFont);

        }else{
            pdfUtil.writeParagraphToDocIndent("一、请于收到本通知和申请书副本之日起2日内按照《珠海仲裁委员会互联网金融仲裁规则》的规定向本会提交答辩书和其他有关证据材料。",contentFont);

        }


        pdfUtil.writeParagraphToDocIndent("二、如有反请求，应在答辩期内单独提出并预交仲裁费。",contentFont);
        pdfUtil.writeParagraphToDocIndent("三、请于收到此受理通知书之日起4日内与申请人协商在本系统提供的仲裁员名单中共同选定或共同委托本会主任指定独任仲裁员。逾期，将由本会主任指定。",contentFont);
        pdfUtil.writeParagraphToDocIndent("四、请于"+PDFUtil.getUpperDate(caseReplyTimeRecord1.getEndTime())+"前向本会提交法定代表人证明书和授权委托书。授权委托书应载明委托事项和权限",contentFont);

        pdfUtil.writeParagraphToDocIndent("五、如不按上述要求办理，不影响仲裁程序的进行，本会将依照《中华人民共和国仲裁法》和《珠海仲裁委员会互联网金融仲裁规则》进行仲裁。",contentFont);


        pdfUtil.writeParagraphToDoc("办案秘书："+managerInfo.getName(),contentFont);
        pdfUtil.writeParagraphToDoc("联系方式："+managerInfo.getPhone(),contentFont);


        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 变更仲裁请求受理通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeActionDoc(String caseId,String changeId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseChangeRecordWithBLOBs caseChangeRecordWithBLOBs=caseChangeRecordMapper.selectByPrimaryKey(changeId);



        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("变更仲裁请求受理通知书",titlefont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("本会受理的申请人与被申请人");
        sb.append(caseType);

        sb.append("合同纠纷一案，你方于");
        sb.append(PDFUtil.getUpperDate(caseChangeRecordWithBLOBs.getCreateTime()));
        sb.append("提出变更仲裁请求申请，经审查，符合受理条件，决定受理。");
        sb.append("请于");
        sb.append(PDFUtil.getUpperDate(caseChangeRecordWithBLOBs.getPayEndTime()));
        sb.append("前，向本会交纳仲裁费用。逾期不交，视为撤回变更仲裁请求申请。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);

        pdfUtil.writeParagraphToDocIndent("特此通知",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeBr();


        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 变更仲裁请求受理通知书 to 被申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeActionToDefentDoc(String caseId,String changeId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseChangeRecordWithBLOBs caseChangeRecordWithBLOBs=caseChangeRecordMapper.selectByPrimaryKey(changeId);

        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(changeId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("变更仲裁请求受理通知书",titlefont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getBeApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("本会受理的申请人与被申请人");
        sb.append(caseType);

        sb.append("合同纠纷一案，申请人于");
        sb.append(PDFUtil.getUpperDate(caseChangeRecordWithBLOBs.getCreateTime()));
        sb.append("提出变更仲裁请求申请，");
        sb.append("本会于");
        sb.append(PDFUtil.getUpperDate(new Date()));
        sb.append("已经受理");
        sb.append("请于");
        sb.append(PDFUtil.getUpperDate(caseReplyTimeRecord.getEndTime()));
        sb.append("前，提交答辩书及证据");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);


        pdfUtil.writeParagraphToDocIndent("特此通知",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeBr();


        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }




    /**
     * 反请求受理通知书 to 申请人（对应的是本请求的被申请人）
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimNoticeActionToDefentDoc(String caseId,String requestId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseRequestInfo caseRequestInfo=caseRequestInfoMapper.selectByPrimaryKey(requestId);

        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(requestId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("反请求受理通知书",titlefont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getBeApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("本会受理的申请人与被申请人");
        sb.append(caseType);

        sb.append("合同纠纷一案，你方于");
        sb.append(PDFUtil.getUpperDate(caseRequestInfo.getCreateTime()));
        sb.append("提出反请求，经审查，符合受理条件，决定受理。");

        sb.append("请于");
        sb.append(PDFUtil.getUpperDate(caseRequestInfo.getPayEndTime()));
        sb.append("前，向本会交纳仲裁费用。逾期不交，视为撤回反请求申请。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);


        pdfUtil.writeParagraphToDocIndent("特此通知",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeBr();


        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 反请求受理通知书 to 被申请人（对应的是本请求的申请人）
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimNoticeActionDoc(String caseId,String requestId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseRequestInfo caseRequestInfo=caseRequestInfoMapper.selectByPrimaryKey(requestId);

        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(requestId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("反请求受理通知书",titlefont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("本会受理的申请人与被申请人");
        sb.append(caseType);

        sb.append("合同纠纷一案，被申请人于");
        sb.append(PDFUtil.getUpperDate(caseRequestInfo.getCreateTime()));
        sb.append("提出反请求，");
        sb.append("本会于");
        sb.append(PDFUtil.getUpperDate(PDFUtil.getUpperDate(new Date())));
        sb.append("已经受理");
        sb.append("请于");
        sb.append(PDFUtil.getUpperDate(caseReplyTimeRecord.getEndTime()));
        sb.append("前，提交答辩书及证据。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);


        pdfUtil.writeParagraphToDocIndent("特此通知",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeBr();


        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }



    /**
     * 不受理本请求通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateNoticeNonAdmissibilityDoc(String caseId,String requestId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseRequestInfo caseRequestInfo=caseRequestInfoMapper.selectByPrimaryKey(requestId);

        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(requestId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("不受理仲裁申请通知书",titlefont);
        pdfUtil.writeBr();
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("你（单位）于");

        sb.append(PDFUtil.getUpperDate(caseRequestInfo.getCreateTime()));
        sb.append("提交的关于你方与");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append(caseType);
        sb.append("合同纠纷一案的仲裁申请书已收到。经审查，不符合受理条件。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);
        pdfUtil.writeParagraphToDocIndent("根据《中华人民共和国仲裁法》第二十四条的规定，本会决定不予受理你方提出的仲裁申请，请另循法律途径解决纠纷。",contentFont);

        pdfUtil.writeBr();

        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }



    /**
     * 不受理变更仲裁请求通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeNonAdmissibilityDoc(String caseId,String changeId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseChangeRecord caseChangeRecord=caseChangeRecordMapper.selectByPrimaryKey(changeId);
        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(changeId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("不受理变更仲裁请求通知书",titlefont);
        pdfUtil.writeBr();
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("你（单位）于");

        sb.append(PDFUtil.getUpperDate(caseChangeRecord.getCreateTime()));
        sb.append("提交的关于你方与");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append(caseType);
        sb.append("合同纠纷一案的变更仲裁请求申请书已收到。经审查，不符合受理条件。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);
        pdfUtil.writeParagraphToDocIndent("根据《中华人民共和国仲裁法》第二十四条的规定，本会决定不予受理你方提出的仲裁申请，请另循法律途径解决纠纷。",contentFont);

        pdfUtil.writeBr();

        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 不受理反请求通知书 to 被申请人
     * @return
     */
    public BusiExecuteResult<?> generateDefentNoticeNonAdmissibilityDoc(String caseId,String requestId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseRequestInfo caseRequestInfo=caseRequestInfoMapper.selectByPrimaryKey(requestId);

        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(requestId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);


        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("不受理仲裁反请求通知书",titlefont);
        pdfUtil.writeBr();
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);
        //头部信息

        pdfUtil.writeParagraphToDoc(caseDocHead.getBeApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("你（单位）于");

        sb.append(PDFUtil.getUpperDate(caseRequestInfo.getCreateTime()));
        sb.append("提交的关于你方与");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append(caseType);
        sb.append("合同纠纷一案的反请求申请书已收到。经审查，不符合受理条件。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);
        pdfUtil.writeParagraphToDocIndent("根据《中华人民共和国仲裁法》第二十四条的规定，本会决定不予受理你方提出的仲裁申请，请另循法律途径解决纠纷。",contentFont);

        pdfUtil.writeBr();

        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }



    /**
     * 不受理变更反请求通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeDefentNoticeNonAdmissibilityDoc(String caseId,String changeId){

        CaseInfo caseInfo=new CaseInfo();
        caseInfo.setId(caseId);

        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);

        CaseChangeRecord caseChangeRecord=caseChangeRecordMapper.selectByPrimaryKey(changeId);
        CaseReplyTimeRecord caseReplyTimeRecord=new CaseReplyTimeRecord();
        caseReplyTimeRecord.setBusiId(changeId);
        caseReplyTimeRecord=caseReplyTimeRecordMapper.selectCaseReplyTimeInfo(caseReplyTimeRecord);




        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createFSFont(21,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("不受理变更仲裁反请求通知书",titlefont);
        pdfUtil.writeBr();
        //头部信息
        pdfUtil.writeParagraphToDocAligmentRight("珠仲网字（xxx）第xxx号",contentFont);

        pdfUtil.writeParagraphToDoc(caseDocHead.getBeApplicant().getName()+"：",contentFont);

        String caseType=caseInfoMapper.selectCaseInfoByCaseId(caseInfo).getCaseTypeId();

        StringBuffer sb=new StringBuffer();

        sb.append("你（单位）于");

        sb.append(PDFUtil.getUpperDate(caseChangeRecord.getCreateTime()));
        sb.append("提交的关于你方与");
        sb.append(caseDocHead.getBeApplicant().getName());
        sb.append(caseType);
        sb.append("合同纠纷一案的变更仲裁反请求申请书已收到。经审查，不符合受理条件。");
        pdfUtil.writeParagraphToDocIndent(sb.toString(),contentFont);
        pdfUtil.writeParagraphToDocIndent("根据《中华人民共和国仲裁法》第二十四条的规定，本会决定不予受理你方提出的仲裁申请，请另循法律途径解决纠纷。",contentFont);

        pdfUtil.writeBr();

        pdfUtil.writeParagraphToDocIndent("珠海仲裁委", contentFont, 256);
        pdfUtil.writeParagraphToDocIndent(PDFUtil.getUpperDate(new Date()),contentFont,256);
        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());
        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //调用签章服务


        return null;


    }


    /**
     * 调解书生成
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateConciliationStatementDoc(String caseId){

        CaseRequestInfo paramRequestInfo=new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo=new CaseRequestInfoWithBLOBs();
        caseRequestInfo=caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        CaseProtocolRecord caseProtocolRecord=new CaseProtocolRecord();
        caseProtocolRecord.setCaseId(caseId);
        CaseProtocolRecordVO caseProtocolRecordVO=new CaseProtocolRecordVO();
        caseProtocolRecordVO=caseProtocolRecordMapper.selectCaseProtocolRecord(caseProtocolRecord);

        long amount=payOrderTranMapper.selectSumAmountByCaseId(caseId);

        if(caseRequestInfo==null){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
        }

        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(22,Font.BOLD);
        Font subTitlefont=PDFUtil.createSTFont(26,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(16,Font.NORMAL);

        Document document = pdfUtil.getDocument();

        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("调 解 书",subTitlefont);
        pdfUtil.writeParagraphToDocAligmentRight(caseInfo.getCaseNo(),contentFont);

        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);

        //判断签订合同还是协议
        if(caseInfo.getSignAbriProtocolMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())){
            //签订合同
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的《%s》中的仲裁条款和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    caseInfo.getProtocolName(),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }else{
            //签订协议
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的仲裁协议和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }

        pdfUtil.writeParagraphToDocIndent("根据《珠海仲裁委员会互联网金融仲裁规则》（以下简称《仲裁规则》）第  条的规定，本会向被申请人送达了仲裁受理通知书、仲裁申请书副本、仲裁规则、仲裁员名册等材料。",contentFont);

        //仲裁员
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        UserInfoVO caseArbitratorInfo = userInfoMapper.selectUserInFoByUserId(caseArbitrator.getArbitratorId());
        //判断是否系统(主任)指派
        if(caseArbitrator.getType().equalsIgnoreCase(CaseArbitratorTypeEnum.PARTY_SELECTED.getCode())){
            pdfUtil.writeParagraphToDocIndent(String.format("双方当事人未在规定期限内共同选定或共同委托本会主任指定独任仲裁员，根据《中华人民共和国仲裁法》（以下简称《仲裁法》）第三十二条、《仲裁规则》第  条的规定，本会主任指定%s为本案独任仲裁员，仲裁庭于%s成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。",
                    caseArbitratorInfo.getName(),
                    PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);
        }else{
            pdfUtil.writeParagraphToDocIndent(String.format("在本会《仲裁规则》规定期限内，双方共同选定仲裁员%s组成独任仲裁庭，仲裁庭于%s成立。本会按照《仲裁规则》的规定向双方当事人送达了组庭通知书。",
                    caseArbitratorInfo.getName(),
                    PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);
        }

        //仲裁请求与答辩
        pdfUtil.writeParagraphToDocAligment("一、仲裁请求",contentFont);
        pdfUtil.writeParagraphToDocIndent("申请人向本会提出如下仲裁请求：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getArbClaim(),contentFont);
        pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getFact(),contentFont);


        //判断申请人本请求有无变更
        CaseChangeRecordExample changeRecordExample = new CaseChangeRecordExample();

        List<CaseChangeRecordWithBLOBs> changeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
        if(changeRecordList == null || changeRecordList.size()==0){
            //本请求无变更
        }else{
            //本请求有变更
            CaseChangeRecordWithBLOBs caseChangeRecord = changeRecordList.get(0);
            pdfUtil.writeParagraphToDocIndent(String.format("申请人又于%s向本会提交书面变更仲裁请求申请书，变更仲裁请求为：",
                    PDFUtil.getUpperDate(caseChangeRecord.getCreateTime())),contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getChangeRequest(),contentFont);
            pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getFactReason(),contentFont);

        }
        //判断是否有反请求
        CaseRequestInfoExample beRequestInfoExample = new CaseRequestInfoExample();
        beRequestInfoExample.createCriteria()
                .andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                .andCaseIdEqualTo(caseId);
        List<CaseRequestInfoWithBLOBs> beRequestInfoList = caseRequestInfoMapper.selectByExampleWithBLOBs(beRequestInfoExample);
        if(beRequestInfoList == null || beRequestInfoList.size() == 0){
            //无反请求
        }else{
            //有反请求
            pdfUtil.writeParagraphToDocIndent("被申请人向本会提出如下仲裁反请求：",contentFont);
            pdfUtil.writeStringStrs(beRequestInfoList.get(0).getArbClaim(),contentFont);
            pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
            pdfUtil.writeStringStrs(beRequestInfoList.get(0).getFact(),contentFont);

            //判断反请求是否有变更

            List<CaseChangeRecordWithBLOBs> beChangeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
            if(beChangeRecordList == null || beChangeRecordList.size()==0){
                //反请求无变更
            }else{
                //反请求有变更
                CaseChangeRecordWithBLOBs beCaseChangeRecord = beChangeRecordList.get(0);
                pdfUtil.writeParagraphToDocIndent(String.format("被申请人又于%s向本会提交书面变更仲裁反请求申请书，变更仲裁反请求为：",
                        PDFUtil.getUpperDate(beCaseChangeRecord.getCreateTime())),contentFont);
                pdfUtil.writeStringStrs(beCaseChangeRecord.getChangeRequest(),contentFont);
                pdfUtil.writeParagraphToDocIndent("其事实和理由是：",contentFont);
                pdfUtil.writeStringStrs(beCaseChangeRecord.getFactReason(),contentFont);
                //判断变更反请求是否有答辩

            }
        }

        pdfUtil.writeParagraphToDocIndent("仲裁过程中，申请人、被申请人自愿达成如下和解协议：",contentFont);
        pdfUtil.writeParagraphToDocIndent(caseProtocolRecordVO.getProtocolContent(),contentFont);
        pdfUtil.writeParagraphToDocIndent("根据《中华人民共和国仲裁法》第四条、第七条、第四十九条、第五十二条，仲裁庭认为，上述和解协议是申请人与被申请人的真实意思表示，没有违反法律、行政法规的强制性规定，仲裁庭予以确认。",contentFont);

        pdfUtil.writeParagraphToDocIndent(String.format("本案已预收仲裁费用%s元，本会不予退回。",amount),contentFont);
        pdfUtil.writeParagraphToDocIndent("本调解书自双方当事人签收之日起发生法律效力。",contentFont);
        pdfUtil.writeBr();
        pdfUtil.writeBr();
        pdfUtil.writeBr();

        //落款日期
        pdfUtil.writeParagraphToDocAligmentRight("仲  裁  员："+caseArbitratorInfo.getName(),contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("日期"+PDFUtil.getUpperDate(new Date()),contentFont);
        String secretaryId = caseManagerMapper.queryArbitrationUserId(caseId,ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
        UserInfoVO secretaryInfo = userInfoMapper.selectUserInFoByUserId(secretaryId);
        pdfUtil.writeParagraphToDocAligmentRight("秘     书："+secretaryInfo.getName(),contentFont);

        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //签章






        return null;
    }


    /**
     * 管辖权异议文书（本请求）
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateJurisdictionMeaningDoc(String caseId,String id){

        CaseRequestInfo paramRequestInfo=new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo=new CaseRequestInfoWithBLOBs();
        caseRequestInfo=caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        CaseProtocolRecord caseProtocolRecord=new CaseProtocolRecord();
        caseProtocolRecord.setCaseId(caseId);
        CaseProtocolRecordVO caseProtocolRecordVO=new CaseProtocolRecordVO();
        caseProtocolRecordVO=caseProtocolRecordMapper.selectCaseProtocolRecord(caseProtocolRecord);
        CaseJurisDisWithBLOBs caseJurisDisWithBLOBs=caseJurisDisMapper.selectByPrimaryKey(id);


        long amount=payOrderTranMapper.selectSumAmountByCaseId(caseId);

        if(caseRequestInfo==null){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
        }

        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(22,Font.BOLD);
        Font subTitlefont=PDFUtil.createSTFont(26,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(16,Font.NORMAL);

        Document document = pdfUtil.getDocument();

        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("决 定 书",subTitlefont);
        pdfUtil.writeParagraphToDocAligmentRight(caseInfo.getCaseNo(),contentFont);

        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);

        //判断签订合同还是协议
        if(caseInfo.getSignAbriProtocolMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())){
            //签订合同
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的《%s》中的仲裁条款和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    caseInfo.getProtocolName(),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }else{
            //签订协议
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的仲裁协议和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }


        //仲裁员
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        UserInfoVO caseArbitratorInfo = userInfoMapper.selectUserInFoByUserId(caseArbitrator.getArbitratorId());

        //判断是否系统(主任)指派
        pdfUtil.writeParagraphToDocIndent(String.format("本会按照《仲裁规则》的规定，组成由%s担任仲裁员的独任仲裁庭，并于%s向双方当事人送达了组庭通知书。",
                caseArbitratorInfo.getName(),
                PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);

        //仲裁请求与答辩
        pdfUtil.writeParagraphToDocIndent("申请人向本会提出如下仲裁请求：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getArbClaim(),contentFont);



        //判断申请人本请求有无变更
        CaseChangeRecordExample changeRecordExample = new CaseChangeRecordExample();

        List<CaseChangeRecordWithBLOBs> changeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
        if(changeRecordList == null || changeRecordList.size()==0){
            //本请求无变更
        }else{
            //本请求有变更
            CaseChangeRecordWithBLOBs caseChangeRecord = changeRecordList.get(0);
            pdfUtil.writeParagraphToDocIndent(String.format("申请人又于%s向本会提交书面变更仲裁请求申请书，变更仲裁请求为：",
                    PDFUtil.getUpperDate(caseChangeRecord.getCreateTime())),contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getChangeRequest(),contentFont);


        }


        pdfUtil.writeParagraphToDocIndent(String.format("被申请人于%s向本会提交了管辖权异议申请书，请求：%s。其理由是：%s。",PDFUtil.getUpperDate(caseJurisDisWithBLOBs.getCreateTime()),caseJurisDisWithBLOBs.getRequestItem(),caseJurisDisWithBLOBs.getReason()),contentFont);
        pdfUtil.writeParagraphToDocIndent(String.format("申请人提出如下回应意见：%s",caseJurisDisWithBLOBs.getFeedBack()),contentFont);

        pdfUtil.writeBr();


        //落款日期
        pdfUtil.writeParagraphToDocAligmentRight("珠海仲裁委员会",contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("仲  裁  员："+caseArbitratorInfo.getName(),contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("日期"+PDFUtil.getUpperDate(new Date()),contentFont);
        String secretaryId = caseManagerMapper.queryArbitrationUserId(caseId,ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
        UserInfoVO secretaryInfo = userInfoMapper.selectUserInFoByUserId(secretaryId);
        pdfUtil.writeParagraphToDocAligmentRight("秘     书："+secretaryInfo.getName(),contentFont);

        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //签章




        return null;
    }


    /**
     * 管辖权异议文书（反请求）
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateDefentJurisdictionMeaningDoc(String caseId,String id){

        CaseRequestInfo paramRequestInfo=new CaseRequestInfo();
        paramRequestInfo.setCaseId(caseId);
        paramRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());

        CaseRequestInfoWithBLOBs caseRequestInfo=new CaseRequestInfoWithBLOBs();
        caseRequestInfo=caseRequestInfoMapper.selectRequestInfoByParam(paramRequestInfo);

        CaseProtocolRecord caseProtocolRecord=new CaseProtocolRecord();
        caseProtocolRecord.setCaseId(caseId);
        CaseProtocolRecordVO caseProtocolRecordVO=new CaseProtocolRecordVO();
        caseProtocolRecordVO=caseProtocolRecordMapper.selectCaseProtocolRecord(caseProtocolRecord);
        CaseJurisDisWithBLOBs caseJurisDisWithBLOBs=caseJurisDisMapper.selectByPrimaryKey(id);


        long amount=payOrderTranMapper.selectSumAmountByCaseId(caseId);

        if(caseRequestInfo==null){
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
        }

        CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);

        PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(22,Font.BOLD);
        Font subTitlefont=PDFUtil.createSTFont(26,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(16,Font.NORMAL);

        Document document = pdfUtil.getDocument();

        pdfUtil.writeParagraphToDocAligment("珠 海 仲 裁 委 员 会",titlefont);
        pdfUtil.writeParagraphToDocAligment("决 定 书",subTitlefont);
        pdfUtil.writeParagraphToDocAligmentRight(caseInfo.getCaseNo(),contentFont);

        //写入案件人员头部信息
        CaseDocHeadVO caseDocHead = caseDocGeneraService.getCaseDocHead(caseId);
        pdfUtil.writeLitigantAndAgentInfo(caseDocHead);

        //判断签订合同还是协议
        if(caseInfo.getSignAbriProtocolMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())){
            //签订合同
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的《%s》中的仲裁条款和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    caseInfo.getProtocolName(),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }else{
            //签订协议
            pdfUtil.writeParagraphToDocIndent(String.format("珠海仲裁委员会（以下简称本会）根据申请人%s（以下简称申请人）与被申请人%s（以下简称被申请人）于%s签订的仲裁协议和申请人的仲裁申请，于%s受理了申请人关于%s合同纠纷的仲裁申请。",
                    caseDocHead.getApplicant().getName(),
                    caseDocHead.getBeApplicant().getName(),
                    PDFUtil.getUpperDate(caseInfo.getSignTime()),
                    PDFUtil.getUpperDate(caseInfo.getCaseAcceptanceTime()),
                    caseInfo.getCaseTypeId()),contentFont);
        }


        //仲裁员
        CaseArbitrator caseArbitrator = caseArbitratorMapper.queryCaseNowArbitratorByCaseId(caseId);
        UserInfoVO caseArbitratorInfo = userInfoMapper.selectUserInFoByUserId(caseArbitrator.getArbitratorId());

        //判断是否系统(主任)指派
        pdfUtil.writeParagraphToDocIndent(String.format("本会按照《仲裁规则》的规定，组成由%s担任仲裁员的独任仲裁庭，并于%s向双方当事人送达了组庭通知书。",
                caseArbitratorInfo.getName(),
                PDFUtil.getUpperDate(caseArbitrator.getAcceptTime())),contentFont);

        //仲裁请求与答辩
        pdfUtil.writeParagraphToDocIndent("申请人向本会提出如下仲裁请求：",contentFont);
        pdfUtil.writeStringStrs(caseRequestInfo.getArbClaim(),contentFont);



        //判断申请人本请求有无变更
        CaseChangeRecordExample changeRecordExample = new CaseChangeRecordExample();

        List<CaseChangeRecordWithBLOBs> changeRecordList = caseChangeRecordMapper.selectByExampleWithBLOBs(changeRecordExample);
        if(changeRecordList == null || changeRecordList.size()==0){
            //本请求无变更
        }else{
            //本请求有变更
            CaseChangeRecordWithBLOBs caseChangeRecord = changeRecordList.get(0);
            pdfUtil.writeParagraphToDocIndent(String.format("申请人又于%s向本会提交书面变更仲裁请求申请书，变更仲裁请求为：",
                    PDFUtil.getUpperDate(caseChangeRecord.getCreateTime())),contentFont);
            pdfUtil.writeStringStrs(caseChangeRecord.getChangeRequest(),contentFont);


        }


        pdfUtil.writeParagraphToDocIndent(String.format("被申请人于%s向本会提交了管辖权异议申请书，请求：%s。其理由是：%s。",PDFUtil.getUpperDate(caseJurisDisWithBLOBs.getCreateTime()),caseJurisDisWithBLOBs.getRequestItem(),caseJurisDisWithBLOBs.getReason()),contentFont);
        pdfUtil.writeParagraphToDocIndent(String.format("申请人提出如下回应意见：%s",caseJurisDisWithBLOBs.getFeedBack()),contentFont);

        pdfUtil.writeBr();


        //落款日期
        pdfUtil.writeParagraphToDocAligmentRight("珠海仲裁委员会",contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("仲  裁  员："+caseArbitratorInfo.getName(),contentFont);
        pdfUtil.writeParagraphToDocAligmentRight("日期"+PDFUtil.getUpperDate(new Date()),contentFont);
        String secretaryId = caseManagerMapper.queryArbitrationUserId(caseId,ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode(), CaseManagerStatusEnum.OK.getCode());
        UserInfoVO secretaryInfo = userInfoMapper.selectUserInFoByUserId(secretaryId);
        pdfUtil.writeParagraphToDocAligmentRight("秘     书："+secretaryInfo.getName(),contentFont);

        pdfUtil.closeDocument();
        String fileOrignName = UUID.randomUUID().toString().replace("-", "") + ".pdf";
        MultipartFile upload = new MyMultipartFile("uploadFile", fileOrignName, pdfUtil.getOut().toByteArray());

        ApiResultVO<String> stringApiResultVO = microFileService.uploadFile("999999", SysEnum.FileBuzzType.CASE_DOC.getCode(), upload);

        //关闭内存流
        pdfUtil.closeOut();

        if (!ApiResultVO.Coder.SUCCESS.getCode().equals(stringApiResultVO.getHead().getRetCode())) {
            throw new RuntimeException("调用文件服务失败");
        }
        String fileId = stringApiResultVO.getBody();

        //签章




        return null;
    }









    private String number2Chinese(String string) {
        String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

        String result = "";

        int n = string.length();
        for (int i = 0; i < n; i++) {

            int num = string.charAt(i) - '0';

            if (i != n - 1 && num != 0) {
                result += s1[num] + s2[n - 2 - i];
            } else {
                if("零".equals(s1[num]) && result.endsWith("零")){
                    continue;
                }
                result += s1[num];
            }
        }
        if(result.endsWith("零")){
            result = result.substring(0,result.length()-1);
        }
        if(result.equals("一十")){
            result = "十";
        }
        return result;

    }




}
