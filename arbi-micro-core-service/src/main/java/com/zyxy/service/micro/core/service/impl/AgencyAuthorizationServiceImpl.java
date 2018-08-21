package com.zyxy.service.micro.core.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.zyxy.common.constants.Constant;
import com.zyxy.common.custom.MyMultipartFile;
import com.zyxy.common.domain.CaseAgent;
import com.zyxy.common.domain.CaseAgentExample;
import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.CaseInfoExample;
import com.zyxy.common.domain.CaseMatWithBLOBs;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.LitigantInfoExample;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import com.zyxy.common.dto.AgencyAuthorDTO;
import com.zyxy.common.dto.ChangeAuthorDTO;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.enums.CaseMatTypeEnum;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.ElementVerifyStatusEnum;
import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.enums.SysUserRealAuthorEnum;
import com.zyxy.common.mapper.CaseAgentMapper;
import com.zyxy.common.mapper.CaseDocCommMapper;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CaseMatMapper;
import com.zyxy.common.mapper.LitigantInfoMapper;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.CaseDocGeneraService;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.SignetService;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.PDFUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.AuthorDocVO;
import com.zyxy.common.vo.CaseLitigantValidDTO;
import com.zyxy.common.vo.CaseLitigantValidVO;
import com.zyxy.common.vo.LitigantCaseInfoValidVO;
import com.zyxy.common.vo.MessageVO;
import com.zyxy.common.vo.doc.CaseDocAgentVO;
import com.zyxy.common.vo.doc.CaseDocHeadVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;
import com.zyxy.service.micro.core.service.AgencyAuthorizationService;
import com.zyxy.service.micro.core.service.CommonService;

@Service
public class AgencyAuthorizationServiceImpl implements
		AgencyAuthorizationService {

	@Autowired
	private LitigantInfoMapper litigantInfoMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private CaseAgentMapper caseAgentMapper;
	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private CaseDocGeneraService caseDocGeneraService;
	@Autowired
	private MicroFileService microFileService;
	@Autowired
	private SignetService signetService;
	@Autowired
	private CaseDocCommMapper caseDocCommMapper;
	@Autowired
	private MicroMessageService microMessageService;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private CaseMatMapper caseMatMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public BusiValidResult agentElementVerifyValid(String cardId) {
		//验证当前代理人是否平台认证用户
		LitigantInfoExample example = new LitigantInfoExample();
		example.createCriteria().andCardIdEqualTo(cardId);
		List<LitigantInfo> infos = litigantInfoMapper.selectByExample(example);
		if (infos.size()==0) {
			return BusiValidResult.builderErrorResult(Coder.NOT_FOUND_AGENT_USER);
		}
		if (StringUtils.isBlank(infos.get(0).getElementVerifyStatus())||
				ElementVerifyStatusEnum.NOT_PASEE.getValue().equals(infos.get(0).getElementVerifyStatus())) {
			return BusiValidResult.builderErrorResult(Coder.NOT_FOUND_AGENT_USER);
		}
		SysUserExample userExample = new SysUserExample();
		List<SysUser> sysUsers=sysUserMapper.selectByExample(userExample);
		if (sysUsers.size()==0||
			SysUserRealAuthorEnum.NO.getValue().equals(sysUsers.get(0).getRealAuth())) {
			return BusiValidResult.builderErrorResult(Coder.NOT_FOUND_AGENT_USER);
		}
		return BusiValidResult.builderSuccessResult();
	}
	
	@Override
	public BusiValidResult caseLitigantValid(CaseLitigantValidDTO formData) {
		CaseLitigantValidVO caseLitigantValidVO = caseInfoMapper.selectCaseLitigantValidInfo(formData.getCaseNo());
		if ("0".equals(formData.getAgentRole())) {
			if (!formData.getCardId().equals(caseLitigantValidVO.getPropCardId())) {
				return BusiValidResult.builderErrorResult(Coder.LITIGANT_INFO_NOT_MACTH_CASE);
			}
			if (!formData.getName().equals(caseLitigantValidVO.getPropName())) {
				return BusiValidResult.builderErrorResult(Coder.LITIGANT_INFO_NOT_MACTH_CASE);
			}
		}else if("1".equals(formData.getAgentRole())) {
			if (!formData.getCardId().equals(caseLitigantValidVO.getPropCardId())) {
				return BusiValidResult.builderErrorResult(Coder.LITIGANT_INFO_NOT_MACTH_CASE);
			}
			if (!formData.getName().equals(caseLitigantValidVO.getPropName())) {
				return BusiValidResult.builderErrorResult(Coder.LITIGANT_INFO_NOT_MACTH_CASE);
			}
		}else{
			BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
		}
		return BusiValidResult.builderSuccessResult();
	}



	@Override
	public BusiValidResult previewAuthorDocValid(AgencyAuthorDTO formData) {
		switch (formData.getBusinessCode()) {
		//申请人委托代理人
		case "0":
			if (StringUtils.isBlank(formData.getCaseId())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
			LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
			//判断当前是否有代理
			CaseAgentExample agentExample = new CaseAgentExample();
			if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())) {
				agentExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.PROPOSER.getValue());
				if (caseAgentMapper.selectByExample(agentExample).size()>0) {
					return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
				}
			}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
				agentExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (caseAgentMapper.selectByExample(agentExample).size()>0) {
					return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
				}
			}
			break;
		case "1":
			if (StringUtils.isBlank(formData.getCaseId())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
			LitigantTypeEnum enums2 = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
			//判断当前是否有代理
			CaseAgentExample agentExample2 = new CaseAgentExample();
			if (LitigantTypeEnum.PROPESER.getValue().equals(enums2.getValue())) {
				agentExample2.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.PROPOSER.getValue());
				if (caseAgentMapper.selectByExample(agentExample2).size()>0) {
					return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
				}
			}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums2.getValue())) {
				agentExample2.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (caseAgentMapper.selectByExample(agentExample2).size()>0) {
					return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
				}
			}
			break;
		case "2":
			if (StringUtils.isBlank(formData.getCaseNo())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
			//判断立案号是否存在
			CaseInfoExample example = new CaseInfoExample();
			example.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			List<CaseInfo> caseInfos = caseInfoMapper.selectByExample(example);
			if (caseInfos.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
			}
			break;
		case "3":
			if (StringUtils.isBlank(formData.getCaseNo())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
			//判断立案号是否存在
			CaseInfoExample example2 = new CaseInfoExample();
			example2.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			List<CaseInfo> caseInfos2 = caseInfoMapper.selectByExample(example2);
			if (caseInfos2.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
			}
			break;
		default:
			break;
		}
		if ("0".equals(formData.getAgentStyle())) {
			if (StringUtils.isBlank(formData.getLawFirm())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
			if (StringUtils.isBlank(formData.getLawyerCertificate())) {
				return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
			}
		}
		
		return BusiValidResult.builderSuccessResult();
	}


	@Override
	public BusiExecuteResult<AuthorDocVO> previewAuthoeDocExecute(
			AgencyAuthorDTO formData) {
		AuthorDocVO authorDocVO = new AuthorDocVO();
		
		switch (formData.getBusinessCode()) {
		//当前用户申请人
		case "0":
			CaseDocLitigantVO propose= caseDocCommMapper.queryLitigantInfo(formData.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant= caseDocCommMapper.queryLitigantInfo(formData.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "1");
			authorDocVO.setClientele(propose);
			authorDocVO.setOppositeName(defendant.getName());
			CaseDocAgentVO agentVO = caseAgentMapper.selectAgentInfo(commonService.selectUserIdByCardId(formData.getAccpetCardId()));
			authorDocVO.setCaseDocAgent(agentVO);
			break;
		//当前用户被申请人
		case "1":
			CaseDocLitigantVO propose2= caseDocCommMapper.queryLitigantInfo(formData.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant2= caseDocCommMapper.queryLitigantInfo(formData.getCaseId(),RequestTypeEnum.REQUEST.getValue(), "1");		
			authorDocVO.setClientele(defendant2);
			authorDocVO.setOppositeName(propose2.getName());
			CaseDocAgentVO agentVO2 = caseAgentMapper.selectAgentInfo(commonService.selectUserIdByCardId(formData.getAccpetCardId()));
			authorDocVO.setCaseDocAgent(agentVO2);
			break;
		//当前用户申请人代理人	
		case "2":
			CaseDocAgentVO agentVO3 = caseAgentMapper.selectAgentInfo(formData.getUserId());
			authorDocVO.setCaseDocAgent(agentVO3);
			CaseInfoExample example = new CaseInfoExample();
			example.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			List<CaseInfo> caseInfos = caseInfoMapper.selectByExample(example);
			CaseDocLitigantVO propose3= caseDocCommMapper.queryLitigantInfo(caseInfos.get(0).getId(),RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant3= caseDocCommMapper.queryLitigantInfo(caseInfos.get(0).getId(),RequestTypeEnum.REQUEST.getValue(), "1");		
			authorDocVO.setClientele(propose3);
			authorDocVO.setOppositeName(defendant3.getName());
			break;
		//当前用户被申请人代理人
		case "3":
			CaseDocAgentVO agentVO4 = caseAgentMapper.selectAgentInfo(formData.getUserId());
			authorDocVO.setCaseDocAgent(agentVO4);
			CaseInfoExample example2 = new CaseInfoExample();
			example2.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			List<CaseInfo> caseInfos2 = caseInfoMapper.selectByExample(example2);
			CaseDocLitigantVO propose4= caseDocCommMapper.queryLitigantInfo(caseInfos2.get(0).getId(),RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant4= caseDocCommMapper.queryLitigantInfo(caseInfos2.get(0).getId(),RequestTypeEnum.REQUEST.getValue(), "1");		
			authorDocVO.setClientele(defendant4);
			authorDocVO.setOppositeName(propose4.getName());
			break;
		default:
			break;
		}
		
		authorDocVO.setAgentType(formData.getAgentType());
		authorDocVO.setCaseType(formData.getCaseTypeId());
		authorDocVO.setInscribeTime(DateUtil.formatDate(new Date(), "yyyy年MM月dd日"));
		
		return BusiExecuteResult.builderSuccessResult(authorDocVO);
	}

	@Override
	public BusiExecuteResult<?> agencyAuthorExecute(AgencyAuthorDTO formData) {
		//委托人用户ID
		String userId=null;
		//当事人类型
		LitigantTypeEnum enums = null;
		//代理人用户ID
		String agentUserId = null;
		//案件ID
		String caseId = null;
		
		CaseAgent record = new CaseAgent();
		
		switch (formData.getBusinessCode()) {
		//申请人邀请代理人
		case "0":
			caseId = formData.getCaseId();
			record.setCaseId(caseId);
			record.setLitigantType(CasePersonnelTypeEnum.PROPOSER.getValue());
			//查询代理人userId
			LitigantInfoExample litigantInfoExample = new LitigantInfoExample();
			litigantInfoExample.createCriteria().andCardIdEqualTo(formData.getAccpetCardId());
			List<LitigantInfo> list = litigantInfoMapper.selectByExample(litigantInfoExample);
			enums = LitigantTypeEnum.PROPESER;
			userId=formData.getUserId();
			agentUserId=list.get(0).getUserId();
			record.setAgentId(agentUserId);
			break;
		case "1":
			
			caseId = formData.getCaseId();
			record.setCaseId(caseId);
			record.setLitigantType(CasePersonnelTypeEnum.DEFENDANT.getValue());
			//查询代理人userId
			LitigantInfoExample litigantInfoExample2 = new LitigantInfoExample();
			litigantInfoExample2.createCriteria().andCardIdEqualTo(formData.getAccpetCardId());
			List<LitigantInfo> list2 = litigantInfoMapper.selectByExample(litigantInfoExample2);
			enums = LitigantTypeEnum.DEFENDANT;
			userId=formData.getUserId();
			agentUserId=list2.get(0).getUserId();
			record.setAgentId(agentUserId);
			break;
		case "2":
			
			CaseInfoExample example = new CaseInfoExample();
			example.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			caseId = caseInfoMapper.selectByExample(example).get(0).getId();
			record.setCaseId(caseId);
			record.setLitigantType(CasePersonnelTypeEnum.PROPOSER.getValue());
			record.setAgentId(formData.getUserId());
			enums = LitigantTypeEnum.PROPESER;
			//查询申请人userId
			LitigantInfoExample litigantInfoExample3 = new LitigantInfoExample();
			litigantInfoExample3.createCriteria().andCardIdEqualTo(formData.getAccpetCardId());
			List<LitigantInfo> list3 = litigantInfoMapper.selectByExample(litigantInfoExample3);
			userId=list3.get(0).getUserId();
			agentUserId=formData.getUserId();
			break;
		case "3":
			CaseInfoExample example2 = new CaseInfoExample();
			example2.createCriteria().andCaseNoEqualTo(formData.getCaseNo());
			caseId = caseInfoMapper.selectByExample(example2).get(0).getId();
			record.setCaseId(caseId);
			record.setLitigantType(CasePersonnelTypeEnum.DEFENDANT.getValue());
			record.setAgentId(formData.getUserId());
			enums = LitigantTypeEnum.DEFENDANT;
			//查询申请人userId
			LitigantInfoExample litigantInfoExample4 = new LitigantInfoExample();
			litigantInfoExample4.createCriteria().andCardIdEqualTo(formData.getAccpetCardId());
			List<LitigantInfo> list4 = litigantInfoMapper.selectByExample(litigantInfoExample4);
			userId=list4.get(0).getUserId();
			agentUserId=formData.getUserId();
			break;
		default:
			break;
		}
		
		record.setAgentStyle(formData.getAgentStyle());
		record.setAgentType(formData.getAgentType());
		record.setCreateTime(new Date());
		record.setCreaterId(formData.getUserId());
		caseAgentMapper.insertSelective(record);
		
		//所函
		CaseMatWithBLOBs lawFirm = new CaseMatWithBLOBs();
        lawFirm.setId(sequenceService.getCommonID());
        lawFirm.setFileId(formData.getLawFirm());
        lawFirm.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
        lawFirm.setCreaterType(enums.getValue());
        lawFirm.setCaseId(caseId);
        caseMatMapper.insertSelective(lawFirm);
        
        //生成授权通知书
        generatorAuthorAttorneyDoc(previewAuthoeDocExecute(formData).getBody(), formData.getAgentStyle(), userId, agentUserId);
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiValidResult changePrivilegeValid(ChangeAuthorDTO formData) {
		BusiValidResult commBusiValidResult = commonService.commonCaseAndUserValid(formData.getCaseId(), formData.getUserId());
		if (commBusiValidResult.hasError()) {
			return commBusiValidResult;
		}
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
		//判断当前是否有代理
		List<CaseAgent> agents = null;
		CaseAgentExample agentExample = new CaseAgentExample();
		if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())) {
			agentExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.PROPOSER.getValue());
			agents =caseAgentMapper.selectByExample(agentExample);
			if (agents.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			agentExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(CasePersonnelTypeEnum.DEFENDANT.getValue());
			agents =caseAgentMapper.selectByExample(agentExample);
			if (agents.size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}
		//案件当前授权是否与之前授权一样；
		if (formData.getAgentType().equals(agents.get(0).getAgentType())) {
			return BusiValidResult.builderErrorResult(Coder.THE_SAME_AUTHOR);
		}
		
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<?> changePrivilegeExecute(ChangeAuthorDTO formData) {
		
		LitigantCaseInfoValidVO caseInfoValidVO =  caseInfoMapper.selectLitigantUserIdByCaseId(formData.getCaseId());
		String userId = null;
		String agentUserId = null;
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
		AuthorDocVO authorDocVO = new AuthorDocVO();
		CaseDocHeadVO caseDocHeadVO = caseDocGeneraService.getCaseDocHead(formData.getCaseId());
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
			authorDocVO.setClientele(caseDocHeadVO.getApplicant());
			authorDocVO.setOppositeName(caseDocHeadVO.getBeApplicant().getName());
			authorDocVO.setCaseDocAgent(caseDocHeadVO.getApplicantAgent());
			userId = caseInfoValidVO.getProposerId();
			agentUserId = caseInfoValidVO.getProposerAgentId();
		}else if(CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			authorDocVO.setClientele(caseDocHeadVO.getBeApplicant());
			authorDocVO.setOppositeName(caseDocHeadVO.getApplicant().getName());
			authorDocVO.setCaseDocAgent(caseDocHeadVO.getBeApplicantAgent());
			userId = caseInfoValidVO.getDefendantId();
			agentUserId = caseInfoValidVO.getDefendantAgentId();
		}
		authorDocVO.setAgentType(formData.getAgentType());
		authorDocVO.setInscribeTime(DateUtil.formatDate(new Date(), "yyyy年MM月dd日"));
		authorDocVO.setCaseType(caseInfo.getCaseTypeId());
		
		CaseAgentExample caseAgentExample = new CaseAgentExample();
		caseAgentExample.createCriteria().andCaseIdEqualTo(formData.getCaseId()).andLitigantTypeEqualTo(enums.getValue());
		
		//生成授权委托书
		String fileId = generatorAuthorAttorneyDoc(authorDocVO, caseAgentMapper.selectByExample(caseAgentExample).get(0).getAgentStyle(), userId, agentUserId);
		//更新委托书
		
		
		//更改状态 
		CaseAgent record = new CaseAgent();
		record.setAgentType(formData.getAgentType());
		caseAgentMapper.updateByExampleSelective(record, caseAgentExample);
		
		return BusiExecuteResult.builderSuccessResult();
	}


	@Override
	public BusiValidResult cancelAgentValid(String caseId, String userId) {
		BusiValidResult commBusiValidResult = commonService.commonCaseAndUserValid(caseId, userId);
		if (commBusiValidResult.hasError()) {
			return commBusiValidResult;
		}
		LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
		//判断当前是否有代理
		CaseAgentExample agentExample = new CaseAgentExample();
		if (LitigantTypeEnum.PROPESER.getValue().equals(enums.getValue())) {
			agentExample.createCriteria().andCaseIdEqualTo(caseId).andLitigantTypeEqualTo(CasePersonnelTypeEnum.PROPOSER.getValue());
			if (caseAgentMapper.selectByExample(agentExample).size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}else if(LitigantTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
			agentExample.createCriteria().andCaseIdEqualTo(caseId).andLitigantTypeEqualTo(CasePersonnelTypeEnum.DEFENDANT.getValue());
			if (caseAgentMapper.selectByExample(agentExample).size()==0) {
				return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
			}
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<?> cancelAgentExecute(String caseId, String userId) {
		
		return null;
	}

	public String generatorAuthorAttorneyDoc(AuthorDocVO authorDocVO,String agentStyle,String userId,String agentUserId){
		PDFUtil pdfUtil=new PDFUtil();
        pdfUtil.createDocument();
        Font titlefont=PDFUtil.createSTFont(20,Font.BOLD);
        Font contentFont=PDFUtil.createFSFont(14,Font.NORMAL);
        pdfUtil.writeParagraphToDocAligment("授权委托书",titlefont);
        //换行
        pdfUtil.writeBr();
        Document document = pdfUtil.getDocument();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
      //现委托受委托人在我与              关于            纠纷一案中 ，作为我方仲裁代理人。
        sb.append("现委托受委托人在我与").
        	append(authorDocVO.getOppositeName()).
        		append("关于").
        			append(authorDocVO.getCaseType()).
        				append(" 纠纷一案中 ，作为我方仲裁代理人");
		pdfUtil.writeStringStrs(sb.toString(), contentFont);
        sb2.append("受委托人").append(authorDocVO.getCaseDocAgent().getName()).append("的代理权限为：");
        if ("1".equals(agentStyle)) {
			sb2.append("一般授权");
		}else if ("2".equals(agentStyle)) {
			sb2.append("特殊授权");
		}
        String fileId = null;
        try {
			pdfUtil.writeApplicant(authorDocVO.getClientele(), "委托人");
			pdfUtil.writeAgent(authorDocVO.getCaseDocAgent(), "代理人");
			pdfUtil.writeStringStrs(sb.toString(), contentFont);
			pdfUtil.writeStringStrs(sb2.toString(), contentFont);
			pdfUtil.writeStringStrs(sb2.toString(), contentFont);
	        pdfUtil.writeParagraphToDocIndent("此致",contentFont);
            pdfUtil.writeParagraphToDoc("珠海仲裁委",contentFont);
            pdfUtil.writeBr();
            pdfUtil.writeParagraphToDocIndent("申请人：" + authorDocVO.getClientele().getName(), contentFont, 256);
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
            fileId = stringApiResultVO.getBody();

            String[] users = new String[]{userId,agentUserId};
            ApiResultVO<String> signet = signetService.signet(fileId, null, CaseDocTypeEnum.ARBITRATOR_AVOID_APPLY, users);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return fileId;
	}

	@Override
	public BusiExecuteResult<MessageVO> authorMsgExecute(AgencyAuthorDTO formData) {
		
		MessageVO messageVO = new MessageVO();
		
		String phoneNo=null;
		LitigantInfoExample example = new LitigantInfoExample();
		example.createCriteria().andCardIdEqualTo(formData.getAccpetCardId());
		List<LitigantInfo> litigantInfos = litigantInfoMapper.selectByExample(example);
		if (litigantInfos.size()==0) {
			return BusiExecuteResult.builderErrorResult(Coder.VALID_ERROR);
		}else{
			phoneNo = litigantInfos.get(0).getBankPhone();
			messageVO.setPhone(phoneNo);
			messageVO.setName(litigantInfos.get(0).getName());
		}
		
		String tplId = "1001";
//      String code = String.format("%06d", new Random().nextInt(999999));
        String code = "888888";
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\"" + code + "\"}";
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.REG_PWD_SMS_CODE + phoneNo, code);
        stringRedisTemplate.expire(Constant.REG_PWD_SMS_CODE + phoneNo, 3, TimeUnit.MINUTES);
        ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(phoneNo, tplId, tplParam, formData.getUserId(), null);
		/**
		 *  @ApiParam(value = "手机号") @RequestParam(required = true) String phoneNo
            ,@ApiParam(value = "模板编号") @RequestParam(required = true) String tplId
            ,@ApiParam(value = "模板内容(json key value 字符串)") @RequestParam(required = true)String tplParams
            ,@ApiParam(value = "用户编号") @RequestParam(required = false) String userId
            ,@ApiParam(value = "业务编号") @RequestParam(required = false) String buzzId
		 */
		
		return BusiExecuteResult.builderSuccessResult(messageVO);
	}


	
}
