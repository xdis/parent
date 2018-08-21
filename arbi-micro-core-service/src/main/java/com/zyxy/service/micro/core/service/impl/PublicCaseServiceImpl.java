package com.zyxy.service.micro.core.service.impl;

import com.zyxy.common.constants.Constant;
import com.zyxy.common.constants.RegexpConstant;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.*;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.WorkDayService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CaseApplyDraftVO;
import com.zyxy.common.vo.CaseArbitrationInfoVO;
import com.zyxy.common.vo.CaseDefaultInfoVO;
import com.zyxy.common.vo.MessageVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.PublicCaseService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 *
 */
@Service
public class PublicCaseServiceImpl implements PublicCaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LitigantInfoMapper litigantInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;

    @Autowired
    private CaseMatMapper caseMatMapper;

    @Autowired
    private CaseProposerMapper caseProposerMapper;

    @Autowired
    private CaseDefendantMapper caseDefendantMapper;

    @Autowired
    private CaseAgentMapper caseAgentMapper;

    @Autowired
    private CaseManagerMapper caseManagerMapper;

    @Autowired
    private CaseRejoinRecordMapper caseRejoinRecordMapper;

    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;

    @Autowired
    private CaseTimeSetMapper caseTimeSetMapper;

    @Autowired
    private WorkDayService workDayService;
    
    @Autowired
    private RejoinAmendRecordMapper rejoinAmendRecordMapper;

    @Autowired
    private CaseApproveMapper caseApproveMapper;
    
    @Autowired
	private CaseDocMapper caseDocMapper;
    @Autowired
    private CommonService commonService;
    @Autowired
	private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private MicroMessageService microMessageService;

    @Override
    public BusiValidResult caseApplyBusiValid(RegisterCaseDTO form) {
        String filingType = form.getFilingType();

        if (CaseFilingEnum.PERSON.getCode().equals(filingType)) {
            //当事人立案验证

            //当事人信息
            LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(form.getUserId());
            //当事人用户信息
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(form.getUserId());

            //案件类型信息
            //替换所有当事人信息为当前用户信息
            form.setApplicantAddress(litigantInfo.getAddress());
            form.setApplicantBirthday(litigantInfo.getBirthday());
            form.setApplicantCardId(userInfo.getCardId());
            form.setApplicantCertDuties(litigantInfo.getCertDuties());
            form.setApplicantCertName(litigantInfo.getCertName());
            form.setApplicantEmail(userInfo.getEmail());
            form.setApplicantEthnic(litigantInfo.getEthnic());
            form.setApplicantName(litigantInfo.getName());
            form.setApplicantPhone(userInfo.getPhone());
            //用户信息表中存的为0-男,1-女
            form.setApplicantSex(userInfo.getSex());
            form.setApplicantType(litigantInfo.getType());
            form.setApplicantUnifiedSocialCode(litigantInfo.getUnifiedSocialCode());

        } else {
            //代理人立案验证
            if ("1".equals(form.getFilingType())) {
                //个人
                if (StringUtils.isBlank(form.getApplicantSex()) || !Pattern.matches(RegexpConstant.SEX_REGEX, form.getApplicantSex())) {
                    logger.debug("申请人性别验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                if (StringUtils.isBlank(form.getApplicantEthnic())) {
                    logger.debug("申请人民族验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                if (StringUtils.isBlank(form.getApplicantPhone())) {
                    logger.debug("申请人手机验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                if (StringUtils.isBlank(form.getApplicantCardId())) {
                    logger.debug("申请人身份证验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
            } else {
                if (StringUtils.isBlank(form.getApplicantUnifiedSocialCode())) {
                    logger.debug("申请人统一社会信用代码验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                if (StringUtils.isBlank(form.getApplicantCertName())) {
                    logger.debug("申请人公司法人姓名验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                if (StringUtils.isBlank(form.getApplicantCertDuties())) {
                    logger.debug("申请人公司法人职务验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
            }

           /* if (StringUtils.isBlank(form.getPowerOfAttorney())) {
                logger.debug("代理人授权委托书验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }

            if (StringUtils.isBlank(form.getAgreementOfAgency())) {
                logger.debug("代理人委托合同验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }*/
            
            if (StringUtils.isBlank(form.getAgentStyle())) {
                logger.debug("代理人立案授权方式验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            
            if (StringUtils.isBlank(form.getAgentType())) {
                logger.debug("代理人立案代理类型验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            
            if ("2".equals(form.getAgentType())) {
            	if (StringUtils.isBlank(form.getLawyerCertificate())) {
                    logger.debug("代理人律师证同验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
                
                if (StringUtils.isBlank(form.getLawFirm())) {
                    logger.debug("代理人所函同验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
			}
            
            if ("0".equals(form.getAgentStyle())) {
            	if (StringUtils.isBlank(form.getDuties())) {
                    logger.debug("代理人律师所验证不通过");
                    return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
                }
			}
            if (StringUtils.isBlank(form.getCaseType())) {
                logger.debug("代理人立案案由验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getLawFirm())) {
                logger.debug("代理人所函验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
        }

        /**
         * 验证被申请人信息
         */
        if ("0".equals(form.getBeApplicantType())) {
            //个人
            if (StringUtils.isBlank(form.getBeApplicantSex()) || !Pattern.matches(RegexpConstant.SEX_REGEX, form.getBeApplicantSex())) {
                logger.debug("被申请人性别验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getBeApplicantEthnic())) {
                logger.debug("被申请人民族验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getBeApplicantPhone())) {
                logger.debug("被申请人手机验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getBeApplicantCardId())) {
                logger.debug("被申请人身份证验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
        } else {
            if (StringUtils.isBlank(form.getBeApplicantUnifiedSocialCode())) {
                logger.debug("被申请人统一社会信用代码验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getBeApplicantCertName())) {
                logger.debug("被申请人公司法人姓名验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
            if (StringUtils.isBlank(form.getBeApplicantCertDuties())) {
                logger.debug("被申请人公司法人职务验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
            }
        }
        if (form.getArbiProtocolSignMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())) {
			if (StringUtils.isBlank(form.getProtocolName())) {
				logger.debug("签订合同名称验证不通过");
                return BusiValidResult.builderErrorResult(ApiResultVO.Coder.VALID_ERROR);
			}
		}
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<String> caseApplyBusiExecute(RegisterCaseDTO form) {
        //插入案件信息表
        CaseInfo caseInfo = new CaseInfo();
        /*
         * 是否为草稿提交且该草稿存在
         * 草稿提交需删除
         * case_info 案件信息表
         * case_request_info 请求信息表
         * case_mat 案件材料表
         * case_proposer 申请人表
         * case_defendant 被申请人表
         * case_agent 代理表
         */
        String caseId = form.getCaseId();
        CaseInfo draftCaseInfo = null;
        //是否为草稿提交
        boolean isDraftSubmit = !StringUtils.isBlank(caseId);
        //是否存在该草稿
        boolean isDreftExist = false;
        //是否为草稿状态
        boolean isDreftStatus = false;
        //是否当前用户创建
        boolean isNowUserCreate = false;
        if (isDraftSubmit) {
            draftCaseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
            //是否存在该草稿
            isDreftExist = draftCaseInfo != null;
            if (isDreftExist) {
                //是否为草稿或审核不通过状态
                isDreftStatus = StringUtils.isBlank(draftCaseInfo.getAcceptanceNo()) || CaseMainNodeEnum.CASE_CHECK_NOT_PASS.getCode().equals(draftCaseInfo.getCurrentMainNode());
                //是否当前用户创建
                isNowUserCreate = form.getUserId().equals(draftCaseInfo.getCreaterId());
            }
        }
        logger.info("是否草稿提交:{},是否存在该草稿:{},是否为草稿状态:{},是否当前用户创建:{}", isDraftSubmit, isDreftExist, isDreftStatus, isNowUserCreate);
        if (isDraftSubmit && isDreftExist && isDreftStatus && isNowUserCreate) {
            //删除case_info
            caseInfoMapper.deleteByPrimaryKey(caseId);
            //删除case_request_info
            CaseRequestInfoExample caseRequestInfoExample = new CaseRequestInfoExample();
            caseRequestInfoExample.createCriteria().andCaseIdEqualTo(caseId);
            caseRequestInfoMapper.deleteByExample(caseRequestInfoExample);
            //删除case_mat
            CaseMatExample caseMatExample = new CaseMatExample();
            caseMatExample.createCriteria().andCaseIdEqualTo(caseId);
            caseMatMapper.deleteByExample(caseMatExample);
            //删除case_proposer
            CaseProposerExample caseProposerExample = new CaseProposerExample();
            caseProposerExample.createCriteria().andCaseIdEqualTo(caseId);
            caseProposerMapper.deleteByExample(caseProposerExample);
            //删除case_defendant
            CaseDefendantExample caseDefendantExample = new CaseDefendantExample();
            caseDefendantExample.createCriteria().andCaseIdEqualTo(caseId);
            caseDefendantMapper.deleteByExample(caseDefendantExample);
            //删除case_agent
            CaseAgentExample caseAgentExample = new CaseAgentExample();
            caseAgentExample.createCriteria().andCaseIdEqualTo(caseId);
            caseAgentMapper.deleteByExample(caseAgentExample);
            //设置CaseId
            caseInfo.setId(caseId);
        } else {
            caseInfo.setId(sequenceService.getCommonID());
        }
        caseInfo.setAcceptanceNo("SA" + sequenceService.getCommonID());
//        caseInfo.setCaseTypeId(form.getCaseType());
        caseInfo.setCreaterId(form.getUserId());
        caseInfo.setCreateTime(new Date());
        caseInfo.setCurrentMainNode(CaseMainNodeEnum.CASE_CHECK.getCode());
        caseInfo.setSourceOrgId(form.getSourceOrgId()); // 案件来源
        caseInfo.setSignAbriProtocolMode(form.getArbiProtocolSignMode());
        caseInfo.setSignTime(form.getSignTime());
        if (form.getArbiProtocolSignMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())) {
        	caseInfo.setProtocolName(form.getProtocolName());
		}
        //插入案件节点流水表
        //分配秘书
        caseManagerMapper.allotManagerPeopleByCaseAndType(caseInfo.getId(), ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode());
        String approveUserId = caseManagerMapper.queryNowWorkPeopleIdByType(caseInfo.getId(), ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode());
        caseInfo.setCurrentOwner(approveUserId);
        caseInfo.setApplyType(form.getFilingType());
        caseInfo.setSignAbriProtocolMode(form.getArbiProtocolSignMode());
        caseInfo.setSignTime(form.getSignTime());
        if (form.getArbiProtocolSignMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())) {
        	caseInfo.setProtocolName(form.getProtocolName());
		}
        caseInfoMapper.insertSelective(caseInfo);
        //插入请求表
        CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
        caseRequestInfo.setId(sequenceService.getCommonID());
        caseRequestInfo.setArbClaim(form.getArbClaim());
        caseRequestInfo.setFact(form.getFact());
        caseRequestInfo.setReason(form.getReason());
        caseRequestInfo.setAcceptanceNo(caseInfo.getAcceptanceNo());
        caseRequestInfo.setAgentFlag(form.getFilingType());
        caseRequestInfo.setCaseId(caseInfo.getId());
        caseRequestInfo.setCreaterId(form.getUserId());
        caseRequestInfo.setCreateTime(caseInfo.getCreateTime());
        caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
        caseRequestInfoMapper.insertSelective(caseRequestInfo);
        /**
         * 如果为重新修改提交,需要改变前节点状态及结束时间
         */
        CaseNodeOperExample oldNodeOperExample = new CaseNodeOperExample();
        oldNodeOperExample.createCriteria()
                .andCaseIdEqualTo(caseInfo.getId())
                .andDealStatusEqualTo(CaseNodeOperDealStatusEnum.INIT.getCode());
        CaseNodeOper caseNodeOper = new CaseNodeOper();
        caseNodeOper.setRealEndTime(new Date());
        caseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.SUCCESS.getCode());
        caseNodeOperMapper.updateByExampleSelective(caseNodeOper, oldNodeOperExample);

        CaseNodeOper newCaseNodeOper = new CaseNodeOper();
        newCaseNodeOper.setCaseId(caseInfo.getId());
        newCaseNodeOper.setCreaterId(form.getUserId());
        newCaseNodeOper.setCreateTime(new Date());
        newCaseNodeOper.setDealStatus(CaseNodeOperDealStatusEnum.INIT.getCode());
        newCaseNodeOper.setId(sequenceService.getCommonID());
        newCaseNodeOper.setNodeId(CaseMainNodeEnum.CASE_CHECK.getCode());
        newCaseNodeOper.setOperRecord("提交立案审核");
        //计划结束时间
        CaseTimeSet caseTimeSet = caseTimeSetMapper.selectByPrimaryKey(CaseTimeSetTypeEnum.CASE_CHECK.getValue());
        newCaseNodeOper.setPlanEndTime(workDayService.after(caseTimeSet.getTimeSet()));
        newCaseNodeOper.setRequestId(caseRequestInfo.getId());
        newCaseNodeOper.setStartTime(new Date());
        caseNodeOperMapper.insertSelective(newCaseNodeOper);
        //插入案件材料
        if (form.getCaseEvidences().size() > 0) {
        	 for (CaseEvidenceDTO evidence : form.getCaseEvidences()) {
        		 evidence.setId(sequenceService.getCommonID());
        		 }
        	 caseMatMapper.insertEvidence(form.getCaseEvidences(), RequestTypeEnum.REQUEST.getValue(), caseInfo.getId(), caseRequestInfo.getId(),EvidenceTypeEnum.PROPOSER.getValue());
        }
        //插入申请人表
        CaseProposer caseProposer = new CaseProposer();
        caseProposer.setId(sequenceService.getCommonID());
        caseProposer.setAddress(form.getApplicantAddress());
        caseProposer.setBirthday(form.getApplicantBirthday());
        caseProposer.setCardId(form.getApplicantCardId());
        caseProposer.setCaseId(caseInfo.getId());
        caseProposer.setCertDuties(form.getApplicantCertDuties());
        caseProposer.setCertName(form.getApplicantCertName());
        caseProposer.setCreaterId(form.getUserId());
        caseProposer.setCreateTime(caseInfo.getCreateTime());
        caseProposer.setEmail(form.getApplicantEmail());
        caseProposer.setEthnic(form.getApplicantEthnic());
        caseProposer.setPhone(form.getApplicantPhone());
        caseProposer.setPropName(form.getApplicantName());
        caseProposer.setPropType(form.getApplicantType());
        caseProposer.setSex(form.getApplicantSex());
        caseProposer.setUnifiedSocialCode(form.getApplicantUnifiedSocialCode());
        caseProposerMapper.insertSelective(caseProposer);
        //插入被申请人表
        CaseDefendant caseDefendant = new CaseDefendant();
        caseDefendant.setId(sequenceService.getCommonID());
        caseDefendant.setAddress(form.getBeApplicantAddress());
        caseDefendant.setBirthday(form.getBeApplicantBirthday());
        caseDefendant.setCardId(form.getBeApplicantCardId());
        caseDefendant.setCaseId(caseInfo.getId());
        caseDefendant.setCertDuties(form.getBeApplicantCertDuties());
        caseDefendant.setCertName(form.getBeApplicantCertName());
        caseDefendant.setCreaterId(form.getUserId());
        caseDefendant.setCreateTime(caseInfo.getCreateTime());
        caseDefendant.setEmail(form.getBeApplicantEmail());
        caseDefendant.setEthnic(form.getBeApplicantEthnic());
        caseDefendant.setPhone(form.getBeApplicantPhone());
        caseDefendant.setPropName(form.getBeApplicantName());
        caseDefendant.setPropType(form.getBeApplicantType());
        caseDefendant.setSex(form.getBeApplicantSex());
        caseDefendant.setUnifiedSocialCode(form.getBeApplicantUnifiedSocialCode());
        caseDefendantMapper.insertSelective(caseDefendant);

        
        //插入立案审核
        CaseApprove caseApprove = new CaseApprove();
        
        //创建审批对象
        caseApprove.setApproveType(ApproveTypeEnum.INITIATE_APPROVAL.getTypeName());
        caseApprove.setApproveUserId(approveUserId);
        caseApprove.setApproveStatus(CaseApproveStatusEnum.WAIT_AUDIT.getValue());
        //caseApprove.setApproveType(ApproveTypeEnum.INITIATE_APPROVAL.getTypeName());
        caseApprove.setCaseId(caseInfo.getId());
        caseApprove.setCreaterId(form.getUserId());
        caseApprove.setCreateTime(new Date());
        caseApprove.setId(sequenceService.getCommonID());
        caseApprove.setRequestId(caseRequestInfo.getId());
        caseApprove.setBusiId(caseRequestInfo.getId());
        caseApproveMapper.insertSelective(caseApprove);
        
        //是否为代理人申请立案
        if ("1".equals(form.getFilingType())) {
            CaseAgent caseAgent = new CaseAgent();
            caseAgent.setCaseId(caseInfo.getId());
            caseAgent.setAgentId(form.getUserId());
            caseAgent.setCreaterId(form.getUserId());
            caseAgent.setCreateTime(caseInfo.getCreateTime());
            caseAgent.setLitigantType(CaseAgentTypeEnum.PROP_AGENT.getCode());
            caseAgentMapper.insertSelective(caseAgent);
            //插入代理人材料
            //所函
            CaseMatWithBLOBs lawFirm = new CaseMatWithBLOBs();
            lawFirm.setId(sequenceService.getCommonID());
            lawFirm.setCaseId(caseInfo.getId());
            lawFirm.setRequestId(caseRequestInfo.getId());
            lawFirm.setFileId(form.getLawFirm());
            lawFirm.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            lawFirm.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            lawFirm.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(lawFirm);
            
            
            CaseMatWithBLOBs lawerCertificate = new CaseMatWithBLOBs();
            lawerCertificate.setId(sequenceService.getCommonID());
            lawerCertificate.setCaseId(caseInfo.getId());
            lawerCertificate.setRequestId(caseRequestInfo.getId());
            lawerCertificate.setFileId(form.getLawyerCertificate());
            lawerCertificate.setMatType(CaseMatTypeEnum.LAWER_CERTIFICATE.getCode());
            lawerCertificate.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            lawerCertificate.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(lawerCertificate);
            
            //
            
           /* //委托代理合同
            CaseMatWithBLOBs agreementOfAgency = new CaseMatWithBLOBs();
            agreementOfAgency.setId(sequenceService.getCommonID());
            agreementOfAgency.setCaseId(caseInfo.getId());
            agreementOfAgency.setRequestId(caseRequestInfo.getId());
            agreementOfAgency.setFileId(form.getAgreementOfAgency());
            agreementOfAgency.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            agreementOfAgency.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            agreementOfAgency.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(agreementOfAgency);
            //授权委托书
            CaseMatWithBLOBs powerOfAttorney = new CaseMatWithBLOBs();
            powerOfAttorney.setId(sequenceService.getCommonID());
            powerOfAttorney.setCaseId(caseInfo.getId());
            powerOfAttorney.setRequestId(caseRequestInfo.getId());
            powerOfAttorney.setFileId(form.getPowerOfAttorney());
            powerOfAttorney.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            powerOfAttorney.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            powerOfAttorney.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(powerOfAttorney);*/
        }
        
        Date date = new Date();
        //插入仲裁申请书
        CaseDoc caseDoc = new CaseDoc();
		caseDoc.setId(sequenceService.getCommonID());
		caseDoc.setDocType(CaseDocTypeEnum.APPLICATION_ARBITRATION_BOOK.getCode());
		caseDoc.setDocName(CaseDocTypeEnum.APPLICATION_ARBITRATION_BOOK.getDocName());
		//签章状态待定
		caseDoc.setCaseId(caseInfo.getId());
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定
		caseDoc.setCreaterId(form.getUserId());
		caseDoc.setCreateTime(date);
		caseDocMapper.insertSelective(caseDoc);
        
        return BusiExecuteResult.builderSuccessResult(caseInfo.getId());
    }

    @Override
    public BusiExecuteResult<CaseDefaultInfoVO> selfCaseApplyInfoBusiExecute(BaseDTO formData) {
        return BusiExecuteResult.builderSuccessResult(caseInfoMapper.queryCaseDefaultInfo(formData.getUserId()));
    }

    @Override
    public BusiValidResult caseApplyDraftBusiValid(RegisterCaseDTO form) {
        String filingType = form.getFilingType();

        if (CaseFilingEnum.PERSON.getCode().equals(filingType)) {
            //当事人信息
            LitigantInfo litigantInfo = litigantInfoMapper.selectByUserId(form.getUserId());
            //当事人用户信息
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(form.getUserId());
            //替换所有当事人信息为当前用户信息
            form.setApplicantAddress(litigantInfo.getAddress());
            form.setApplicantBirthday(litigantInfo.getBirthday());
            form.setApplicantCardId(userInfo.getCardId());
            form.setApplicantCertDuties(litigantInfo.getCertDuties());
            form.setApplicantCertName(litigantInfo.getCertName());
            form.setApplicantEmail(userInfo.getEmail());
            form.setApplicantEthnic(litigantInfo.getEthnic());
            form.setApplicantName(litigantInfo.getName());
            form.setApplicantPhone(userInfo.getPhone());
            //用户信息表中存的为0-男,1-女
            form.setApplicantSex(userInfo.getSex());
            form.setApplicantType(litigantInfo.getType());
            form.setApplicantUnifiedSocialCode(litigantInfo.getUnifiedSocialCode());
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<String> caseApplyDraftBusiExecute(RegisterCaseDTO form) {

        //插入案件信息表
        CaseInfo caseInfo = new CaseInfo();
        String caseId = form.getCaseId();
        CaseInfo draftCaseInfo = null;
        //是否为草稿提交
        boolean isDraftSubmit = !StringUtils.isBlank(caseId);
        //是否存在该草稿
        boolean isDreftExist = false;
        //是否为草稿状态
        boolean isDreftStatus = false;
        //是否当前用户创建
        boolean isNowUserCreate = false;
        if (isDraftSubmit) {
            draftCaseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
            //是否存在该草稿
            isDreftExist = draftCaseInfo != null;
            if (isDreftExist) {
                //是否为草稿状态
                isDreftStatus = StringUtils.isBlank(draftCaseInfo.getAcceptanceNo());
                //是否当前用户创建
                isNowUserCreate = form.getUserId().equals(draftCaseInfo.getCreaterId());
            }
        }
        logger.info("是否草稿提交:{},是否存在该草稿:{},是否为草稿状态:{},是否当前用户创建:{}", isDraftSubmit, isDreftExist, isDreftStatus, isNowUserCreate);
        if (isDraftSubmit && isDreftExist && isDreftStatus && isNowUserCreate) {
            //删除case_info
            caseInfoMapper.deleteByPrimaryKey(caseId);
            //删除case_request_info
            CaseRequestInfoExample caseRequestInfoExample = new CaseRequestInfoExample();
            caseRequestInfoExample.createCriteria().andCaseIdEqualTo(caseId);
            caseRequestInfoMapper.deleteByExample(caseRequestInfoExample);
            //删除case_mat
            CaseMatExample caseMatExample = new CaseMatExample();
            caseMatExample.createCriteria().andCaseIdEqualTo(caseId);
            caseMatMapper.deleteByExample(caseMatExample);
            //删除case_proposer
            CaseProposerExample caseProposerExample = new CaseProposerExample();
            caseProposerExample.createCriteria().andCaseIdEqualTo(caseId);
            caseProposerMapper.deleteByExample(caseProposerExample);
            //删除case_defendant
            CaseDefendantExample caseDefendantExample = new CaseDefendantExample();
            caseDefendantExample.createCriteria().andCaseIdEqualTo(caseId);
            caseDefendantMapper.deleteByExample(caseDefendantExample);
            //删除case_agent
            CaseAgentExample caseAgentExample = new CaseAgentExample();
            caseAgentExample.createCriteria().andCaseIdEqualTo(caseId);
            caseAgentMapper.deleteByExample(caseAgentExample);
            //设置CaseId
            caseInfo.setId(caseId);
        } else {
            caseInfo.setId(sequenceService.getCommonID());
        }
//        caseInfo.setCaseTypeId(form.getCaseType());
        caseInfo.setCreaterId(form.getUserId());
        caseInfo.setCreateTime(new Date());
        caseInfo.setApplyType(form.getFilingType());
        caseInfo.setSignAbriProtocolMode(form.getArbiProtocolSignMode());
        caseInfo.setSignTime(form.getSignTime());
        if (form.getArbiProtocolSignMode().equals(CaseSignArbiProtocolModeEnum.SIGN_AGREEMENT.getValue())) {
        	caseInfo.setProtocolName(form.getProtocolName());
		}
        caseInfoMapper.insertSelective(caseInfo);

        //插入请求表
        CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
        caseRequestInfo.setId(sequenceService.getCommonID());
        caseRequestInfo.setArbClaim(form.getArbClaim());
        caseRequestInfo.setFact(form.getFact());
        caseRequestInfo.setReason(form.getReason());
        caseRequestInfo.setAgentFlag(form.getFilingType());
        caseRequestInfo.setCaseId(caseInfo.getId());
        caseRequestInfo.setCreaterId(form.getUserId());
        caseRequestInfo.setCreateTime(caseInfo.getCreateTime());
        caseRequestInfo.setRequestType(RequestTypeEnum.REQUEST.getValue());
        caseRequestInfoMapper.insertSelective(caseRequestInfo);
        //插入案件材料
        if (form.getCaseEvidences().size() > 0) {
        	 for (CaseEvidenceDTO evidence : form.getCaseEvidences()) {
        		 evidence.setId(sequenceService.getCommonID());
    		 }
            caseMatMapper.insertEvidence(form.getCaseEvidences(), RequestTypeEnum.REQUEST.getValue(), caseInfo.getId(), caseRequestInfo.getId(),EvidenceTypeEnum.PROPOSER.getValue());
        }
        //插入申请人表
        CaseProposer caseProposer = new CaseProposer();
        caseProposer.setId(sequenceService.getCommonID());
        caseProposer.setAddress(form.getApplicantAddress());
        caseProposer.setBirthday(form.getApplicantBirthday());
        caseProposer.setCardId(form.getApplicantCardId());
        caseProposer.setCaseId(caseInfo.getId());
        caseProposer.setCertDuties(form.getApplicantCertDuties());
        caseProposer.setCertName(form.getApplicantCertName());
        caseProposer.setCreaterId(form.getUserId());
        caseProposer.setCreateTime(caseInfo.getCreateTime());
        caseProposer.setEmail(form.getApplicantEmail());
        caseProposer.setEthnic(form.getApplicantEthnic());
        caseProposer.setPhone(form.getApplicantPhone());
        caseProposer.setPropName(form.getApplicantName());
        caseProposer.setPropType(form.getApplicantType());
        caseProposer.setSex(form.getApplicantSex());
        caseProposer.setUnifiedSocialCode(form.getApplicantUnifiedSocialCode());
        caseProposerMapper.insertSelective(caseProposer);
        //插入被申请人表
        CaseDefendant caseDefendant = new CaseDefendant();
        caseDefendant.setId(sequenceService.getCommonID());
        caseDefendant.setAddress(form.getBeApplicantAddress());
        caseDefendant.setBirthday(form.getBeApplicantBirthday());
        caseDefendant.setCardId(form.getBeApplicantCardId());
        caseDefendant.setCaseId(caseInfo.getId());
        caseDefendant.setCertDuties(form.getBeApplicantCertDuties());
        caseDefendant.setCertName(form.getBeApplicantCertName());
        caseDefendant.setCreaterId(form.getUserId());
        caseDefendant.setCreateTime(caseInfo.getCreateTime());
        caseDefendant.setEmail(form.getBeApplicantEmail());
        caseDefendant.setEthnic(form.getBeApplicantEthnic());
        caseDefendant.setPhone(form.getBeApplicantPhone());
        caseDefendant.setPropName(form.getBeApplicantName());
        caseDefendant.setPropType(form.getBeApplicantType());
        caseDefendant.setSex(form.getBeApplicantSex());
        caseDefendant.setUnifiedSocialCode(form.getBeApplicantUnifiedSocialCode());
        caseDefendantMapper.insertSelective(caseDefendant);

        //是否为代理人申请立案
        if ("1".equals(form.getFilingType())) {
            CaseAgent caseAgent = new CaseAgent();
            caseAgent.setCaseId(caseInfo.getId());
            caseAgent.setAgentId(form.getUserId());
            caseAgent.setCreaterId(form.getUserId());
            caseAgent.setCreateTime(caseInfo.getCreateTime());
            caseAgent.setLitigantType(CaseAgentTypeEnum.PROP_AGENT.getCode());
            caseAgentMapper.insertSelective(caseAgent);
            //插入代理人材料
            //所函
            CaseMatWithBLOBs lawFirm = new CaseMatWithBLOBs();
            lawFirm.setId(sequenceService.getCommonID());
            lawFirm.setCaseId(caseInfo.getId());
            lawFirm.setRequestId(caseRequestInfo.getId());
            lawFirm.setFileId(form.getLawFirm());
            lawFirm.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            lawFirm.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            lawFirm.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(lawFirm);
            
            CaseMatWithBLOBs lawerCertificate = new CaseMatWithBLOBs();
            lawerCertificate.setId(sequenceService.getCommonID());
            lawerCertificate.setCaseId(caseInfo.getId());
            lawerCertificate.setRequestId(caseRequestInfo.getId());
            lawerCertificate.setFileId(form.getLawyerCertificate());
            lawerCertificate.setMatType(CaseMatTypeEnum.LAWER_CERTIFICATE.getCode());
            lawerCertificate.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            lawerCertificate.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(lawerCertificate);
           /* //委托代理合同
            CaseMatWithBLOBs agreementOfAgency = new CaseMatWithBLOBs();
            agreementOfAgency.setId(sequenceService.getCommonID());
            agreementOfAgency.setCaseId(caseInfo.getId());
            agreementOfAgency.setRequestId(caseRequestInfo.getId());
            agreementOfAgency.setFileId(form.getAgreementOfAgency());
            agreementOfAgency.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            agreementOfAgency.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            agreementOfAgency.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(agreementOfAgency);
            //授权委托书
            CaseMatWithBLOBs powerOfAttorney = new CaseMatWithBLOBs();
            powerOfAttorney.setId(sequenceService.getCommonID());
            powerOfAttorney.setCaseId(caseInfo.getId());
            powerOfAttorney.setRequestId(caseRequestInfo.getId());
            powerOfAttorney.setFileId(form.getPowerOfAttorney());
            powerOfAttorney.setMatType(CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode());
            powerOfAttorney.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
            powerOfAttorney.setCreaterType(LitigantTypeEnum.PROPESER.getValue());
            caseMatMapper.insertSelective(powerOfAttorney);*/
        }
        
        return BusiExecuteResult.builderSuccessResult(caseInfo.getId());
    }

    @Override
    public BusiValidResult getCaseApplyDraftBusiValid(GetCaseDraftDTO formData) {
        CaseInfo draftCaseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
        //是否存在该草稿
        if (draftCaseInfo == null) {
            return BusiValidResult.builderErrorResult(Coder.NOT_FOUND);
        }
        //是否为草稿状态
        if (!StringUtils.isBlank(draftCaseInfo.getAcceptanceNo())) {
            return BusiValidResult.builderErrorResult(Coder.REQ_ERROR);
        }
        //是否当前用户创建
        if (!formData.getUserId().equals(draftCaseInfo.getCreaterId())) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseApplyDraftVO> getCaseApplyDraftBusiExecute(GetCaseDraftDTO formData) {
        CaseApplyDraftVO caseApplyDraftVO = caseInfoMapper.queryCaseApplyDraft(formData.getCaseId());
        caseApplyDraftVO.setCaseEvidences(caseInfoMapper.queryCaseApplyDraftEvidence(formData.getCaseId()));
        return BusiExecuteResult.builderSuccessResult(caseApplyDraftVO);
    }

    @Override
    public BusiValidResult caseReplyBusiValid(CaseReplyDTO form) {
    	LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(form.getCaseId(), form.getUserId());
    	if (enums==null) {
			return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
		}
    	
        //todo:验证答辩权限
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseArbitrationInfoVO> caseReplyBusiExecute(CaseReplyDTO form) {
    	CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(form.getCaseId(), form.getUserId());
    	Date date = new Date();
        CaseRejoinRecordWithBLOBs caseRejoinRecord = new CaseRejoinRecordWithBLOBs();
        caseRejoinRecord.setCreaterId(form.getUserId());
        caseRejoinRecord.setCreateTime(date);
        //创建文书
        CaseDoc caseDoc = new CaseDoc();
		
        //查询案件Id及请求类型
//        CaseRequestInfoWithBLOBs caseRequestInfoWithBLOBs = caseRequestInfoMapper.selectByPrimaryKey(form.getRequestId());

        //插入案件材料
       if (null != form.getCaseAttachments()) {
    	   for (CaseAttachmentDTO attachment : form.getCaseAttachments()) {
    		   attachment.setId(sequenceService.getCommonID());
    		   if (attachment.getAttachName().lastIndexOf(".") != -1) {
    			   attachment.setDocType(attachment.getAttachName().substring(attachment.getAttachName().lastIndexOf(".") + 1));
    		   }
    	   }
       }
       if (null != form.getCaseEvidences()) {
    	   for (CaseEvidenceDTO evidence : form.getCaseEvidences()) {
    		   evidence.setId(sequenceService.getCommonID());
    	   }
       }
       //根据当事人类型判断文书的类型
        if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
        	if (CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue().equals(form.getType())) {
        		caseDoc.setDocType(CaseDocTypeEnum.CHANGE_REQUEST_REJOIN_BOOK.getCode());
        		caseDoc.setDocName(CaseDocTypeEnum.CHANGE_REQUEST_REJOIN_BOOK.getDocName());
			}else if ((CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue().equals(form.getType()))) {
				caseDoc.setDocType(CaseDocTypeEnum.REQUEST_REJOIN_BOOK.getCode());
        		caseDoc.setDocName(CaseDocTypeEnum.REQUEST_REJOIN_BOOK.getDocName());
			}
    		caseRejoinRecord.setCounterclaimFlag(RequestTypeEnum.REQUEST.getValue());
    		if (null != form.getCaseEvidences()) {
    			caseMatMapper.insertRejionEvidence(form.getCaseEvidences(), RequestTypeEnum.REQUEST.getValue(), form.getCaseId(), "", CaseMatTypeEnum.REPLY_EVIDENCE.getCode(),EvidenceTypeEnum.DEFENDANT.getValue());
			}
        }else if(CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())){
        	if (CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue().equals(form.getType())) {
        		caseDoc.setDocType(CaseDocTypeEnum.BACK_CHANGE_REQUEST_REJOIN_BOOK.getCode());
        		caseDoc.setDocName(CaseDocTypeEnum.BACK_CHANGE_REQUEST_REJOIN_BOOK.getDocName());
			}else if ((CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue().equals(form.getType()))) {
				caseDoc.setDocType(CaseDocTypeEnum.BACK_REQUEST_REJOIN_BOOK.getCode());
        		caseDoc.setDocName(CaseDocTypeEnum.BACK_REQUEST_REJOIN_BOOK.getDocName());
			}
			caseRejoinRecord.setCounterclaimFlag(RequestTypeEnum.BACK_REQUEST.getValue());
			if (null != form.getCaseEvidences()) {
    			caseMatMapper.insertRejionEvidence(form.getCaseEvidences(), RequestTypeEnum.BACK_REQUEST.getValue(), form.getCaseId(), "", CaseMatTypeEnum.REPLY_EVIDENCE.getCode(),EvidenceTypeEnum.PROPOSER.getValue());
			}
        }
        caseRejoinRecord.setId(sequenceService.getCommonID());
        caseRejoinRecord.setCaseId(form.getCaseId());
        caseRejoinRecord.setRejoinId(form.getUserId());
        caseRejoinRecord.setRequestId(form.getRequestId());
        caseRejoinRecord.setRejoinText(form.getReplyContent());
        caseRejoinRecord.setRejoinTyep(form.getType());
        caseRejoinRecord.setStatus(1);
        
        if (!StringUtils.isBlank(form.getChangeId())) {
        	caseRejoinRecord.setChangeId(form.getChangeId());
		}
        caseRejoinRecordMapper.insertSelective(caseRejoinRecord);
        //插入答辩书
        caseDoc.setCaseId(form.getCaseId());
        caseDoc.setId(sequenceService.getCommonID());
		//签章状态待定
		caseDoc.setStatus(CaseDocStatusEnum.NORMAL.getCode());
		caseDoc.setLogisticsStatus(DeletedFlag.NO.getValue());
		caseDoc.setDocYearNumber(DateUtil.formatDate(date, "yyyy"));
		//文书序列号待定
		caseDoc.setCreaterId(form.getUserId());
		caseDoc.setCreateTime(date);
		caseDocMapper.insertSelective(caseDoc);
        return BusiExecuteResult.builderSuccessResult();
    }
    
    @Override
	public BusiValidResult caseRejoinAmendValid(CaseRejoinUpdateDTO formData) {
    	//验证
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> caseRejoinAmendExecute(
			CaseRejoinUpdateDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		 //根据当事人类型判断文书的类型
		CaseRejoinRecordExample example = new CaseRejoinRecordExample();
        if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
        	example.createCriteria().
        	andCaseIdEqualTo(formData.getCaseId()).
        	andRejoinTyepEqualTo(formData.getType()).
        	andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue());
		}else if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
        	example.createCriteria().
        	andCaseIdEqualTo(formData.getCaseId()).
        	andRejoinTyepEqualTo(formData.getType()).
        	andCounterclaimFlagEqualTo(RequestTypeEnum.BACK_REQUEST.getValue());
		}
		List<CaseRejoinRecord> list = caseRejoinRecordMapper.selectByExample(example);
		
		//插入答辩修改记录
		RejoinAmendRecord rejoinAmendRecord = new RejoinAmendRecord();
		rejoinAmendRecord.setId(sequenceService.getCommonID());
		rejoinAmendRecord.setCreaterId(formData.getUserId());
		rejoinAmendRecord.setRejoinId(list.get(0).getId());
		
		int rows = rejoinAmendRecordMapper.insertRejoinAmend(rejoinAmendRecord);
		//修改答辩
		if (rows >0) {
			CaseRejoinRecordWithBLOBs record = new CaseRejoinRecordWithBLOBs();
			record.setRejoinText(formData.getReplyContent());
			//修改
			caseRejoinRecordMapper.updateByExampleSelective(record, example);
			//插入证据
			if (formData.getCaseEvidences().size()>0) {
				for (CaseEvidenceDTO caseEvidence : formData.getCaseEvidences()) {
					caseEvidence.setId(sequenceService.getCommonID());
				}
				if(CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
					caseMatMapper.insertRejionEvidence(formData.getCaseEvidences(), RequestTypeEnum.BACK_REQUEST.getValue(), formData.getCaseId(),
							list.get(0).getRequestId(),CaseMatTypeEnum.REPLY_EVIDENCE.getCode(), LitigantTypeEnum.DEFENDANT.getValue());
				}else if(CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
					caseMatMapper.insertRejionEvidence(formData.getCaseEvidences(), RequestTypeEnum.REQUEST.getValue(), formData.getCaseId(),
							list.get(0).getRequestId(),CaseMatTypeEnum.REPLY_EVIDENCE.getCode(), LitigantTypeEnum.PROPESER.getValue());
				}
			}
		}else{
			return BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<MessageVO> agentCaseApplyMsg(String userId,
			String phoneNo) {
		

		String tplId = "1001";
//      String code = String.format("%06d", new Random().nextInt(999999));
        String code = "888888";
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\"" + code + "\"}";
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.REG_PWD_SMS_CODE + phoneNo, code);
        stringRedisTemplate.expire(Constant.REG_PWD_SMS_CODE + phoneNo, 3, TimeUnit.MINUTES);
        ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(phoneNo, tplId, tplParam, userId, null);
		/**
		 *  @ApiParam(value = "手机号") @RequestParam(required = true) String phoneNo
            ,@ApiParam(value = "模板编号") @RequestParam(required = true) String tplId
            ,@ApiParam(value = "模板内容(json key value 字符串)") @RequestParam(required = true)String tplParams
            ,@ApiParam(value = "用户编号") @RequestParam(required = false) String userId
            ,@ApiParam(value = "业务编号") @RequestParam(required = false) String buzzId
		 */
		
		return BusiExecuteResult.builderSuccessResult();
	}
	
	
}
