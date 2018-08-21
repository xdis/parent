package com.zyxy.service.micro.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.*;
import com.zyxy.common.dto.DelayedReplyDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.enums.*;
import com.zyxy.common.mapper.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.vo.*;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.LitigantCaseSercvice;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.zyxy.common.dto.PayAndCaseInfoVO;

@Service
public class LitigantCaseServiceImpl implements LitigantCaseSercvice {

    @Autowired
    private CaseInfoMapper caseInfoMapper;
    @Autowired
    private CaseRequestInfoMapper caseRequestInfoMapper;
	@Autowired
    private ArbitratorInfoMapper arbitratorInfoMapper;
    @Autowired
    private CaseMatMapper caseMatMapper;
    @Autowired
    private CaseArbitratorOperMapper caseArbitratorOperMapper;
    @Autowired
    private MicroThirdService microThirdService;
    @Autowired
    private CaseNodeOperMapper caseNodeOperMapper;
    @Autowired
    private CommonService commonService;
    @Autowired
    private CaseChangeRecordMapper caseChangeMapper;
    @Autowired
    private CaseReplyTimeRecordMapper caseReplyTimeRecordMapper;
    @Autowired
    private CaseReplyDeferRecordMapper caseReplyDeferRecordMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private CaseRejoinRecordMapper caseRejoinRecordMapper;
    @Autowired
    private CompromiseApplyMapper compromiseApplyMapper;
    @Autowired
    private CaseDocCommMapper caseDocCommMapper;

    private static final Logger logger = LoggerFactory.getLogger(LitigantCaseServiceImpl.class);

    @Override
    public PageInfo<LitigantCaseListVO> selectLitigantCaseList(
            LitigantCaseListDTO formData) {
        if (formData.getPageNum() == null || formData.getPageNum() < 1) {
            formData.setPageNum(1);
        }
        if (formData.getPageSize() == null || formData.getPageSize() < 1 || formData.getPageSize() > 1000) {
            formData.setPageSize(10);
        }
        PageHelper.startPage(formData.getPageNum(), formData.getPageSize());

        PageInfo<LitigantCaseListVO> pageInfo = null;

        if (LitigantTypeEnum.PROPESER.getValue().equals(formData.getCurrentRole())) {
            pageInfo = new PageInfo<LitigantCaseListVO>(caseInfoMapper.selectProposerCaseList(formData));
        } else if (LitigantTypeEnum.DEFENDANT.getValue().equals(formData.getCurrentRole())) {
            pageInfo = new PageInfo<LitigantCaseListVO>(caseInfoMapper.selectDefendantCaseList(formData));
        } else if (LitigantTypeEnum.AGENT.getValue().equals(formData.getCurrentRole())) {
            pageInfo = new PageInfo<LitigantCaseListVO>(caseInfoMapper.selectAgentCaseList(formData));
        }

        return pageInfo;
    }

    @Override
    public ArbitratorInfoVO selectArbitratorInfoByCaseId(String caseId) {
    	ArbitratorInfoVO arbitratorInfoVO = new ArbitratorInfoVO();
        List<LitigantArbitratorInfoVO> result = caseArbitratorOperMapper.selectArbitratorForLitigantByCaseId(caseId);
        for (LitigantArbitratorInfoVO arbitratorPersonalInfoVO : result) {
			if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(arbitratorPersonalInfoVO.getType())) {
				arbitratorInfoVO.setPropArbitrator(arbitratorPersonalInfoVO);
			}else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(arbitratorPersonalInfoVO.getType())) {
				arbitratorInfoVO.setDefeArbitrator(arbitratorPersonalInfoVO);
			}
		}
        LitigantArbitratorInfoVO info = arbitratorInfoMapper.selectArbitratorInfoByCaseId(caseId);
        arbitratorInfoVO.setSysArbitrator(info);
        return arbitratorInfoVO;
    }

    @Override
    public BusiValidResult litigantCaseInfoBusiValid(String caseId, String userId) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderSuccessResult();
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<PayAndCaseInfoVO> litigantCaseInfoBusiExecute(
            String caseId, String userId) {
        LitigantCaseBaseInfoVO caseInfo = caseInfoMapper.
                selectLitigantCaseInfoByCaseId(caseId);
        caseInfo.setCaseApplyTime(DateUtil.formatDate(caseInfo.getApplyTime(), "yyyy年MM月dd日"));
        /**
         * 案件材料
         */
        List<CaseMat> caseMats = this.queryCaseMatByCaseId(caseId, RequestTypeEnum.REQUEST.getValue());
        //附件列表
        List<CaseAttachmentVO> attachments = new ArrayList<>();
        //委托代理人材料
        List<CaseAttorneyMaterialVO> attorneyMaterials = new ArrayList<>();
        //请求证据列表
        List<CaseEvidenceVO> evidences = new ArrayList<>();
        if (caseMats.size() > 0) {
            for (CaseMat caseMat : caseMats) {
                if (CaseMatTypeEnum.ATTACHMENT.getCode().equals(caseMat.getMatType())) {
                    attachments.add(CaseAttachmentVO.convertFormCaseMat(caseMat));
                } else if (CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode().equals(caseMat.getMatType())) {
                    attorneyMaterials.add(CaseAttorneyMaterialVO.convertFormCaseMat(caseMat));
                } else if (CaseMatTypeEnum.REQUEST_EVIDENCE.getCode().equals(caseMat.getMatType())) {
                    evidences.add(CaseEvidenceVO.convertFormCaseMat(caseMat));
                }
            }
        }
        caseInfo.setAttachments(attachments);
        caseInfo.setCaseEvidences(evidences);

//        PayOrderVO payInfo = casePayInfoBusi(caseId, userId, RequestTypeEnum.BACK_REQUEST.getValue());
        PayAndCaseInfoVO info = new PayAndCaseInfoVO();
        info.setBaseInfo(caseInfo);
//        info.setPayInfo(payInfo);

        return BusiExecuteResult.builderSuccessResult(info);
    }

    @Override
    public BusiExecuteResult<PayAndCaseInfoVO> litigantBackRequestInfoBusiExecute(
            String caseId, String userId) {
        LitigantCaseBaseInfoVO caseInfo = caseInfoMapper.
                selectLitigantBackRequestInfoByCaseId(caseId);
        caseInfo.setCaseApplyTime(DateUtil.formatDate(caseInfo.getApplyTime(), "yyyy年MM月dd日"));
        /**
         * 案件材料
         */
        List<CaseMat> caseMats = this.queryCaseMatByCaseId(caseId, RequestTypeEnum.BACK_REQUEST.getValue());
        //附件列表
        List<CaseAttachmentVO> attachments = new ArrayList<>();
        //委托代理人材料
        List<CaseAttorneyMaterialVO> attorneyMaterials = new ArrayList<>();
        //请求证据列表
        List<CaseEvidenceVO> evidences = new ArrayList<>();
        if (caseMats.size() > 0) {
            for (CaseMat caseMat : caseMats) {
                if (CaseMatTypeEnum.ATTACHMENT.getCode().equals(caseMat.getMatType())) {
                    attachments.add(CaseAttachmentVO.convertFormCaseMat(caseMat));
                } else if (CaseMatTypeEnum.ATTORNEY_MATERIAL.getCode().equals(caseMat.getMatType())) {
                    attorneyMaterials.add(CaseAttorneyMaterialVO.convertFormCaseMat(caseMat));
                } else if (CaseMatTypeEnum.REQUEST_EVIDENCE.getCode().equals(caseMat.getMatType())) {
                    evidences.add(CaseEvidenceVO.convertFormCaseMat(caseMat));
                }
            }
        }
        caseInfo.setAttachments(attachments);
        caseInfo.setCaseEvidences(evidences);

//        PayOrderVO payInfo = casePayInfoBusi(caseId, userId, RequestTypeEnum.BACK_REQUEST.getValue());
        PayAndCaseInfoVO info = new PayAndCaseInfoVO();
        info.setBaseInfo(caseInfo);
//        info.setPayInfo(payInfo);
        return BusiExecuteResult.builderSuccessResult(info);
    }


    /**
     * 查询指定案件所有材料信息
     *
     * @param caseId 案件Id
     * @return 返回指定案件所有材料信息
     */
    private List<CaseMat> queryCaseMatByCaseId(String caseId, String flag) {
        CaseMatExample caseMatExample = new CaseMatExample();
        caseMatExample
                .createCriteria()
                .andCaseIdEqualTo(caseId)
                .andCounterclaimFlagEqualTo(flag);
        List<CaseMat> caseMats = caseMatMapper.selectByExample(caseMatExample);
        return caseMats;
    }

    @Override
    public BusiValidResult casePayInfoBusiValid(String caseId, String userId) {
        //根据caseId 查询申请人id 查询出申请人user_id,被申请人user_id,申请人代理user_id,被申请人user_id
        if (StringUtils.isBlank(userId)) {
            return BusiValidResult.builderErrorResult(Coder.VALID_ERROR);
        }
        if (!relationValid(caseId, userId)) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<PayOrderVO> casePayInfoBusiExecute(String caseId, String userId) {
        CaseRequestInfoExample example = new CaseRequestInfoExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue());
        CaseRequestInfo caseRequestInfo = caseRequestInfoMapper.selectByExample(example).get(0);
        CaseInfo caseInfoWithBLOBs = caseInfoMapper.selectByPrimaryKey(caseId);
        PayOrderVO payOrderVO = new PayOrderVO();
        //是否还未生成
        if (StringUtils.isBlank(caseRequestInfo.getPayId())) {
            payOrderVO.setStatus(0);
            return BusiExecuteResult.builderSuccessResult(payOrderVO);
        }
        ApiResultVO<PayOrder> payOrderApiResultVO = microThirdService.queryOrder(caseRequestInfo.getPayId());
        logger.info("=====================================queryOrder:" + JSONObject.toJSONString(payOrderApiResultVO));
        PayOrder body = payOrderApiResultVO.getBody();
        //VO
        payOrderVO.setCheckDigitAll(body.getCheckDigitAll());
        payOrderVO.setCheckDigitNo(body.getCheckDigitNo());
        payOrderVO.setCreateTime(body.getCreateTime());
        payOrderVO.setPayerName(body.getPayerName());
        payOrderVO.setPnNo(body.getPnNo());
        payOrderVO.setReceivableAmt(body.getReceivableAmt());
        payOrderVO.setRtNo(body.getRtNo());
        payOrderVO.setUnitNo(body.getUnitNo());
        payOrderVO.setQrCode(microThirdService.getPayNoteQrCode(caseRequestInfo.getPayId()).getBody());
        CaseNodeOperExample payExample = new CaseNodeOperExample();
        payExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PAY.getCode());
        CaseNodeOper caseNodeOper = caseNodeOperMapper.selectByExample(payExample).get(0);
        payOrderVO.setDealTime(caseNodeOper.getPlanEndTime());
        Integer currentMainNode = caseInfoWithBLOBs.getCurrentMainNode();
        //0-未生成,1- 已缴费,2- 未缴费,3- 过期
        if (CaseMainNodeEnum.CASE_PAY.getCode().equals(currentMainNode)) {
            payOrderVO.setStatus(2);
        } else if (caseNodeOper.getPlanEndTime().compareTo(new Date()) < 0) {
            payOrderVO.setStatus(3);
        } else {
            payOrderVO.setStatus(1);
        }
        /*
         * [{"itemNo":"收费项目编码","itemName":"收费项目名称","price":"单价","quantity":"数量"},..]
		 */
        List<PayOrderVO.Item> items = new ArrayList<>();
        List<Map<String, Object>> itemList = JSONObject.parseObject(body.getItems(), List.class);
        PayOrderVO.Item item;
        for (Map<String, Object> itemMap : itemList) {
            item = new PayOrderVO.Item();
            item.setName((String) itemMap.get("itemName"));
            item.setNo((String) itemMap.get("itemNo"));
            item.setPrice((BigDecimal) itemMap.get("price"));
            item.setQuantity(Integer.parseInt(itemMap.get("quantity").toString()));
            items.add(item);
        }
        payOrderVO.setItems(items);
        return BusiExecuteResult.builderSuccessResult(payOrderVO);
    }

    /**
     * 关系验证
     *
     * @param caseId 案件信息
     * @param userId 当前用户Id
     * @return 当前用户是否与本案件有关
     */
    private boolean relationValid(String caseId, String userId) {
        LitigantCaseInfoValidVO validData = caseInfoMapper.selectLitigantUserIdByCaseId(caseId);
        if (userId.equals(validData.getProposerId())
                || userId.equals(validData.getDefendantId())
                || userId.equals(validData.getDefendantAgentId())
                || userId.equals(validData.getProposerAgentId())) {
            return true;
        }
        return false;
    }

    @Override
    public BusiValidResult caseCommInfoBusiValid(String caseId, String userId) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<CaseCommInfoVO> caseCommInfoBusiExecute(
            String caseId, String userId) {
        CaseCommInfoVO caseCommInfo = new CaseCommInfoVO();
        caseCommInfo.setInfo(caseInfoMapper.queryCaseCommInfo(caseId));
        //todo:进度信息待定
        caseCommInfo.setProgress(caseInfoMapper.queryCaseCommProgressInfo(caseId));
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        caseCommInfo.setLitigantType(enums.getValue());
        return BusiExecuteResult.builderSuccessResult(caseCommInfo);
    }

    @Override
    public BusiValidResult requestInfoValid(String caseId, String userId) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<RequestVO> requestInfoExecute(
            String caseId, String userId) {
        RequestVO requestVO = new RequestVO();
        CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(caseId, userId);
        //查询变更请求
        List<RequestListVO> list = null;
        //查询本请求
        RequestListVO requsetListVo = null;
       
        //请求按钮
        ReplyButtonVO reply = new ReplyButtonVO();
        //变更请求按钮
        ReplyButtonVO changeReply = new ReplyButtonVO();
        
        if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
            list = caseChangeMapper.selectChangeRequestList(caseId, null);
            requsetListVo = caseInfoMapper.selectCaseRequest(caseId, null);
          //请求答辩按钮
            //判断是否答辩
            if (commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(),  RequestTypeEnum.REQUEST)) {
                reply.setAmendBtn(false);
            	reply.setCheckBtn(true);
            	reply.setReplyBtn(false);
            } else {
            	reply.setAmendBtn(false);
            	reply.setCheckBtn(false);
            	reply.setReplyBtn(false);
            }
          //变更请求答辩按钮
          //判断是否答辩
            if (commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(),  RequestTypeEnum.REQUEST)) {
            	changeReply.setAmendBtn(false);
            	changeReply.setCheckBtn(true);
            	changeReply.setReplyBtn(false);
            } else {
            	changeReply.setAmendBtn(false);
            	changeReply.setCheckBtn(false);
            	changeReply.setReplyBtn(false);
            }
        } else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
            list = caseChangeMapper.selectChangeRequestList(caseId, enums.getValue());
            requsetListVo = caseInfoMapper.selectCaseRequest(caseId, enums.getValue());
            
            //请求答辩按钮判断
            //判断是否在请求答辩期
            if (commonService.hasReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
				//在答辩期
            	if (commonService.isReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
            		//判断是否有答辩记录
            		if(commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
            			reply.setAmendBtn(true);
                    	reply.setCheckBtn(true);
                    	reply.setReplyBtn(false);
					}else{
						reply.setAmendBtn(false);
		            	reply.setCheckBtn(false);
		            	reply.setReplyBtn(true);
					}
				}else{
					reply.setAmendBtn(false);
	            	reply.setCheckBtn(true);
	            	reply.setReplyBtn(false);
				}
			}else{
				reply.setAmendBtn(false);
            	reply.setCheckBtn(false);
            	reply.setReplyBtn(false);
			}
            
            //变更请求按钮答辩判断
            //判断是否在变更请求答辩期
            if (commonService.hasReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
				//在答辩期
            	if (commonService.isReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
            		//判断是否有变更答辩记录
            		if(commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.REQUEST)) {
            			changeReply.setAmendBtn(true);
                    	changeReply.setCheckBtn(true);
                    	changeReply.setReplyBtn(false);
					}else{
						changeReply.setAmendBtn(false);
		            	changeReply.setCheckBtn(false);
		            	changeReply.setReplyBtn(true);
					}
				}else{
					changeReply.setAmendBtn(false);
	            	changeReply.setCheckBtn(true);
	            	changeReply.setReplyBtn(false);
					
				}
			}else{
				changeReply.setAmendBtn(false);
            	changeReply.setCheckBtn(false);
            	changeReply.setReplyBtn(false);
			}
        }
        if (requsetListVo != null) {
            list.add(requsetListVo);
        }
        requestVO.setRequestVO(list);
        requestVO.setReplyButton(reply);
        requestVO.setChangeReplyButton(changeReply);
        return BusiExecuteResult.builderSuccessResult(requestVO);
    }

    @Override
    public BusiValidResult changeDocValid(String caseId, String changeId,
                                          String userId) {

        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<PayAndChangeInfoVO> changeDocExecute(String caseId,
                                                                  String changeId, String userId) {
        CaseChangeInfoVO changeInfo = caseChangeMapper.selectCaseChangeDoc(caseId, changeId);
        changeInfo.setCaseApplyTime(DateUtil.formatDate(changeInfo.getApplyTime(), "yyyy年MM月dd日"));
//        PayOrderVO payInfo = caseChangePayInfoBusi(changeId, userId);
        PayAndChangeInfoVO info = new PayAndChangeInfoVO();
        info.setBaseInfo(changeInfo);
//        info.setPayInfo(payInfo);
        return BusiExecuteResult.builderSuccessResult(info);
    }

    @Override
    public BusiValidResult backRequestInfoValid(String caseId, String userId) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<RequestVO> backRequestInfoExecute(
            String caseId, String userId) {

        RequestVO requestVO = new RequestVO();

        CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(caseId, userId);
        //查询变更反请求
        List<RequestListVO> list = null;
        //查询反请求
        RequestListVO requsetListVo = null;
        
        //请求按钮
        ReplyButtonVO reply = new ReplyButtonVO();
        //变更请求按钮
        ReplyButtonVO changeReply = new ReplyButtonVO();

        if (CasePersonnelTypeEnum.PROPOSER.getValue().equals(enums.getValue())) {
            list = caseChangeMapper.selectChangeBackRequestList(caseId, enums.getValue());
            requsetListVo = caseInfoMapper.selectCaseBackRequest(caseId, enums.getValue());
            //请求答辩按钮判断
            //判断是否在请求答辩期
            if (commonService.hasReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
				//在答辩期
            	if (commonService.isReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
            		//判断是否有答辩记录
            		if(commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
            			reply.setAmendBtn(true);
            			reply.setCheckBtn(true);
            			reply.setReplyBtn(false);
					}else{
						reply.setAmendBtn(false);
            			reply.setCheckBtn(false);
            			reply.setReplyBtn(true);
					}
				}else{
					reply.setAmendBtn(false);
        			reply.setCheckBtn(true);
        			reply.setReplyBtn(false);
				}
			}else{
				
				reply.setAmendBtn(false);
    			reply.setCheckBtn(false);
    			reply.setReplyBtn(false);
			}
            
            //变更请求按钮答辩判断
            //判断是否在变更请求答辩期
            if (commonService.hasReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
				//在答辩期
            	if (commonService.isReplyTime(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
            		//判断是否有变更答辩记录
            		if(commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(), RequestTypeEnum.BACK_REQUEST)) {
        				changeReply.setAmendBtn(true);
        				changeReply.setCheckBtn(true);
        				changeReply.setReplyBtn(false);
					}else{
						changeReply.setAmendBtn(false);
						changeReply.setCheckBtn(false);
						changeReply.setReplyBtn(true);
					}
				}else{
					changeReply.setAmendBtn(false);
					changeReply.setCheckBtn(true);
					changeReply.setReplyBtn(false);
				}
			}else{
				changeReply.setAmendBtn(false);
				changeReply.setCheckBtn(false);
				changeReply.setReplyBtn(false);
			}
            
        } else if (CasePersonnelTypeEnum.DEFENDANT.getValue().equals(enums.getValue())) {
            list = caseChangeMapper.selectChangeBackRequestList(caseId, null);
            requsetListVo = caseInfoMapper.selectCaseBackRequest(caseId, null);
            //请求答辩按钮
            //判断是否答辩
            if (commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue(),  RequestTypeEnum.BACK_REQUEST)) {
            	reply.setAmendBtn(false);
            	reply.setCheckBtn(true);
            	reply.setReplyBtn(false);
            } else {
            	reply.setAmendBtn(false);
            	reply.setCheckBtn(false);
            	reply.setReplyBtn(false);
            }
          //变更请求答辩按钮
          //判断是否答辩
            if (commonService.hasReplyRecord(caseId, CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue(),  RequestTypeEnum.BACK_REQUEST)) {
            	changeReply.setAmendBtn(false);
				changeReply.setCheckBtn(true);
				changeReply.setReplyBtn(false);
            } else {
            	changeReply.setAmendBtn(false);
				changeReply.setCheckBtn(false);
				changeReply.setReplyBtn(false);
            }
        }
        if (requsetListVo != null) {
            list.add(requsetListVo);
        }
        requestVO.setRequestVO(list);
        requestVO.setChangeReplyButton(changeReply);
        requestVO.setReplyButton(reply);
        return BusiExecuteResult.builderSuccessResult(requestVO);
    }


    @Override
    public BusiValidResult backChangeDocValid(String caseId, String changeId,
                                              String userId) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(caseId, userId);
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult<PayAndChangeInfoVO> backChangeDocExecute(
            String caseId, String changeId, String userId) {
        CaseChangeInfoVO changeInfo = caseChangeMapper.selectCaseBackChangeDoc(caseId, changeId);
        changeInfo.setCaseApplyTime(DateUtil.formatDate(changeInfo.getApplyTime(), "yyyy年MM月dd日"));
//        PayOrderVO payInfo = caseChangePayInfoBusi(changeId, userId);
        PayAndChangeInfoVO info = new PayAndChangeInfoVO();
        info.setBaseInfo(changeInfo);
//        info.setPayInfo(payInfo);
        return BusiExecuteResult.builderSuccessResult(info);
    }


    @Override
    public BusiValidResult delayedReplyValid(DelayedReplyDTO formData) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        if (enums == null) {
            return BusiValidResult.builderErrorResult(Coder.NO_PERMISSION);
        }
        //答辩时间记录对象
        List<CaseReplyTimeRecord> caseReplyTimeRecords;
        CaseReplyTimeRecordExample example = new CaseReplyTimeRecordExample();
        //根据身份验证
        String roleValue = enums.getValue();
        if (LitigantTypeEnum.PROPESER.getValue().equals(roleValue) || LitigantTypeEnum.PROPESER_AGENT.getValue().equals(roleValue)) {
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andRequestTypeEqualTo(RequestTypeEnum.BACK_REQUEST.getValue())
                    .andTypeEqualTo(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
            caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(example);
        } else {
            example.createCriteria()
                    .andCaseIdEqualTo(formData.getCaseId())
                    .andRequestTypeEqualTo(RequestTypeEnum.REQUEST.getValue())
                    .andTypeEqualTo(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
            caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(example);
        }
        //存不存在该答辩
        if (caseReplyTimeRecords == null || caseReplyTimeRecords.isEmpty()) {
            return BusiValidResult.builderErrorResult(Coder.NOT_FOUND);
        }
        //该答辩是否在进行中
        if (caseReplyTimeRecords.get(0).getEndTime().compareTo(new Date()) <= 0) {
            return BusiValidResult.builderErrorResult(Coder.REQUEST_NOT_IN_REPLY_ERROR);
        }
        //该答辩是否已经申请了延期答辩
        if (caseReplyTimeRecords.get(0).getDelayFlag().equals(CaseReplyTimeRecordDelayFLagEnum.YES.getValue())) {
            return BusiValidResult.builderErrorResult(Coder.REQUEST_DEALY_EXIST_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult delayedReplyExecute(DelayedReplyDTO formData) {
        LitigantTypeEnum enums = commonService.queryCaseRoleByUserId(formData.getCaseId(), formData.getUserId());
        //答辩时间记录对象
        List<CaseReplyTimeRecord> caseReplyTimeRecords;
        CaseReplyTimeRecordExample example = new CaseReplyTimeRecordExample();
        //根据身份验证
        String roleValue = enums.getValue();
        //是否为申请人
        boolean isProposer = LitigantTypeEnum.PROPESER.getValue().equals(roleValue) || LitigantTypeEnum.PROPESER_AGENT.getValue().equals(roleValue);
        example.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(isProposer ? RequestTypeEnum.BACK_REQUEST.getValue() : RequestTypeEnum.REQUEST.getValue())
                .andTypeEqualTo(CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue());
        caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(example);
        CaseReplyTimeRecord caseReplyTimeRecord = caseReplyTimeRecords.get(0);
        String caseReplyTimeRecordId = caseReplyTimeRecord.getId();
        Date endTime = caseReplyTimeRecord.getEndTime();
        
        CaseRejoinRecordExample caseRejoinRecordExample = new CaseRejoinRecordExample();
        
        
        //加入延期记录表
        CaseReplyDeferRecord caseReplyDeferRecord = new CaseReplyDeferRecord();
        caseReplyDeferRecord.setId(sequenceService.getCommonID());
        caseReplyDeferRecord.setCreaterId(formData.getUserId());
        caseReplyDeferRecord.setCreateTime(new Date());
        caseReplyDeferRecord.setReplyReason(formData.getDelayReason());
        caseReplyDeferRecord.setReplyTimeId(caseReplyTimeRecordId);
        caseReplyDeferRecordMapper.insert(caseReplyDeferRecord);

        //修改请求信息表
        CaseRequestInfoWithBLOBs caseRequestInfo = new CaseRequestInfoWithBLOBs();
        //设置为延期答辩
        caseRequestInfo.setDelayedReply("1");
        CaseRequestInfoExample caseRequestInfoExample = new CaseRequestInfoExample();
        caseRequestInfoExample.createCriteria()
                .andCaseIdEqualTo(formData.getCaseId())
                .andRequestTypeEqualTo(isProposer ? RequestTypeEnum.REQUEST.getValue() : RequestTypeEnum.BACK_REQUEST.getValue());
        caseRequestInfoMapper.updateByExampleSelective(caseRequestInfo, caseRequestInfoExample);

        //延长时间
        caseReplyTimeRecord = new CaseReplyTimeRecord();
        caseReplyTimeRecord.setId(caseReplyTimeRecordId);
        caseReplyTimeRecord.setEndTime(DateUtil.dateTimeAddByDays(endTime, 1));
        caseReplyTimeRecord.setDelayFlag(CaseReplyTimeRecordDelayFLagEnum.YES.getValue());
        caseReplyTimeRecordMapper.updateByPrimaryKeySelective(caseReplyTimeRecord);
        return BusiExecuteResult.builderSuccessResult();
    }

    private PayOrderVO casePayInfoBusi(String caseId, String userId, String requestType) {
        CaseRequestInfoExample example = new CaseRequestInfoExample();
        example.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andRequestTypeEqualTo(requestType);
        CaseRequestInfo caseRequestInfo = caseRequestInfoMapper.selectByExample(example).get(0);
        CaseInfo caseInfoWithBLOBs = caseInfoMapper.selectByPrimaryKey(caseId);
        PayOrderVO payOrderVO = new PayOrderVO();
        //是否还未生成
        if (StringUtils.isBlank(caseRequestInfo.getPayId())) {
            payOrderVO.setStatus(0);
            return payOrderVO;
        }
        PayOrder body = microThirdService.queryOrder(caseRequestInfo.getPayId()).getBody();
        //VO
        payOrderVO.setCheckDigitAll(body.getCheckDigitAll());
        payOrderVO.setCheckDigitNo(body.getCheckDigitNo());
        payOrderVO.setCreateTime(body.getCreateTime());
        payOrderVO.setPayerName(body.getPayerName());
        payOrderVO.setPnNo(body.getPnNo());
        payOrderVO.setReceivableAmt(body.getReceivableAmt());
        payOrderVO.setRtNo(body.getRtNo());
        payOrderVO.setUnitNo(body.getUnitNo());
        payOrderVO.setQrCode(microThirdService.getPayNoteQrCode(caseRequestInfo.getPayId()).getBody());
        CaseNodeOperExample payExample = new CaseNodeOperExample();
        payExample.createCriteria()
                .andCaseIdEqualTo(caseId)
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PAY.getCode());
        CaseNodeOper caseNodeOper = caseNodeOperMapper.selectByExample(payExample).get(0);
        payOrderVO.setDealTime(caseNodeOper.getPlanEndTime());
        Integer currentMainNode = caseInfoWithBLOBs.getCurrentMainNode();
        //0-未生成,1- 已缴费,2- 未缴费,3- 过期
        if (CaseMainNodeEnum.CASE_PAY.getCode().equals(currentMainNode)) {
            payOrderVO.setStatus(2);
        } else if (caseNodeOper.getPlanEndTime().compareTo(new Date()) < 0) {
            payOrderVO.setStatus(3);
        } else {
            payOrderVO.setStatus(1);
        }
        /*
         * [{"itemNo":"收费项目编码","itemName":"收费项目名称","price":"单价","quantity":"数量"},..]
		 */
        List<PayOrderVO.Item> items = new ArrayList<>();
        List<Map<String, String>> itemList = JSONObject.parseObject(body.getItems(), List.class);
        PayOrderVO.Item item;
        for (Map<String, String> itemMap : itemList) {
            item = new PayOrderVO.Item();
            item.setName(itemMap.get("itemName"));
            item.setNo(itemMap.get("itemNo"));
            item.setPrice(new BigDecimal(itemMap.get("price")));
            item.setQuantity(Integer.parseInt(itemMap.get("quantity")));
        }
        payOrderVO.setItems(items);
        return payOrderVO;
    }

    private PayOrderVO caseChangePayInfoBusi(String changeId, String userId) {
        CaseChangeRecordWithBLOBs changeRecord = caseChangeMapper.selectByPrimaryKey(changeId);
        CaseInfo caseInfoWithBLOBs = caseInfoMapper.selectByPrimaryKey(changeRecord.getCaseId());
        PayOrderVO payOrderVO = new PayOrderVO();
        //是否还未生成
        if (StringUtils.isBlank(changeRecord.getPayId())) {
            payOrderVO.setStatus(0);
            return payOrderVO;
        }
        PayOrder body = microThirdService.queryOrder(changeRecord.getPayId()).getBody();
        //VO
        payOrderVO.setCheckDigitAll(body.getCheckDigitAll());
        payOrderVO.setCheckDigitNo(body.getCheckDigitNo());
        payOrderVO.setCreateTime(body.getCreateTime());
        payOrderVO.setPayerName(body.getPayerName());
        payOrderVO.setPnNo(body.getPnNo());
        payOrderVO.setReceivableAmt(body.getReceivableAmt());
        payOrderVO.setRtNo(body.getRtNo());
        payOrderVO.setUnitNo(body.getUnitNo());
        payOrderVO.setQrCode(microThirdService.getPayNoteQrCode(changeRecord.getPayId()).getBody());
        CaseNodeOperExample payExample = new CaseNodeOperExample();
        payExample.createCriteria()
                .andCaseIdEqualTo(changeRecord.getCaseId())
                .andNodeIdEqualTo(CaseMainNodeEnum.CASE_PAY.getCode());
        CaseNodeOper caseNodeOper = caseNodeOperMapper.selectByExample(payExample).get(0);
        payOrderVO.setDealTime(caseNodeOper.getPlanEndTime());
        Integer currentMainNode = caseInfoWithBLOBs.getCurrentMainNode();
        //0-未生成,1- 已缴费,2- 未缴费,3- 过期
        if (CaseMainNodeEnum.CASE_PAY.getCode().equals(currentMainNode)) {
            payOrderVO.setStatus(2);
        } else if (caseNodeOper.getPlanEndTime().compareTo(new Date()) < 0) {
            payOrderVO.setStatus(3);
        } else {
            payOrderVO.setStatus(1);
        }
        /*
         * [{"itemNo":"收费项目编码","itemName":"收费项目名称","price":"单价","quantity":"数量"},..]
		 */
        List<PayOrderVO.Item> items = new ArrayList<>();
        List<Map<String, String>> itemList = JSONObject.parseObject(body.getItems(), List.class);
        PayOrderVO.Item item;
        for (Map<String, String> itemMap : itemList) {
            item = new PayOrderVO.Item();
            item.setName(itemMap.get("itemName"));
            item.setNo(itemMap.get("itemNo"));
            item.setPrice(new BigDecimal(itemMap.get("price")));
            item.setQuantity(Integer.parseInt(itemMap.get("quantity")));
        }
        payOrderVO.setItems(items);
        return payOrderVO;
    }

	@Override
	public BusiValidResult replyDocValid(String caseId, String userId) {
		//caseId与userId验证
		BusiValidResult commonValid = commonService.commonCaseAndUserValid(caseId, userId);
		if (commonValid.hasError()) {
			return BusiValidResult.builderErrorResult(commonValid.getCode(), commonValid.getMsg());
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<ReplyDocVO> replyDocExecute(String caseId,String type) {
		ReplyDocVO info = new ReplyDocVO();
		CaseRejoinRecordExample example = new CaseRejoinRecordExample();
		example.createCriteria().
			andCaseIdEqualTo(caseId).
				andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue()).
					andRejoinTyepEqualTo(type);
		List<CaseRejoinRecordWithBLOBs> caseRejoinRecords = caseRejoinRecordMapper.selectByExampleWithBLOBs(example);
		if (caseRejoinRecords.size()>0) {
			CaseDocLitigantVO propose= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "1");
			info.setBeRepliedVO(defendant);
			info.setRepliedVO(propose);
			info.setInscribeTime(DateUtil.formatDate(caseRejoinRecords.get(0).getCreateTime(), "yyyy年MM月dd日"));
			info.setInscribeName(propose.getName());
			info.setId(caseRejoinRecords.get(0).getId());
			info.setRejoinText(caseRejoinRecords.get(0).getRejoinText());
			CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
			info.setCaseType(caseInfo.getCaseTypeId());
		}
		return BusiExecuteResult.builderSuccessResult(info);
	}
	
	@Override
	public BusiExecuteResult<ReplyDocVO> backReplyDocExecute(String caseId,String type){
		ReplyDocVO info = new ReplyDocVO();
		CaseRejoinRecordExample example = new CaseRejoinRecordExample();
		example.createCriteria().
			andCaseIdEqualTo(caseId).
			andCounterclaimFlagEqualTo(RequestTypeEnum.REQUEST.getValue()).
			andRejoinTyepEqualTo(type);
		List<CaseRejoinRecordWithBLOBs> caseRejoinRecords = caseRejoinRecordMapper.selectByExampleWithBLOBs(example);
		if (caseRejoinRecords.size()>0) {
			CaseDocLitigantVO propose= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "0");
			CaseDocLitigantVO defendant= caseDocCommMapper.queryLitigantInfo(caseId,RequestTypeEnum.REQUEST.getValue(), "1");
			info.setBeRepliedVO(propose);
			info.setRepliedVO(defendant);
			info.setInscribeTime(DateUtil.formatDate(caseRejoinRecords.get(0).getCreateTime(), "yyyy年MM月dd日"));
			info.setInscribeName(defendant.getName());
			info.setId(caseRejoinRecords.get(0).getId());
			info.setRejoinText(caseRejoinRecords.get(0).getRejoinText());
			CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
			info.setCaseType(caseInfo.getCaseTypeId());
		}
		return BusiExecuteResult.builderSuccessResult(info);
	}
	
	@Override
	public BusiValidResult countDownValid(String caseId, String userId) {
		
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<List<CountDownVO>> countDownExecute(String caseId,
			String userId) {
		List<CountDownVO> countDownVOs = new ArrayList<CountDownVO>();
		CompromiseApplyExample example = new CompromiseApplyExample();
		example.createCriteria().andCaseIdEqualTo(caseId).andStatusEqualTo(CompromiseStatusEnum.ONGOINF.getValue());
		List<CompromiseApply> list = compromiseApplyMapper.selectByExample(example);
		//和解中---和解倒计时
		if (list.size()>0) {
			CountDownVO countDownVO = new CountDownVO();
			countDownVO.setName("和解倒计时");
			countDownVO.setTime(list.get(0).getPlanEndTime().getTime()-new Date().getTime());
			countDownVOs.add(countDownVO);
			return BusiExecuteResult.builderSuccessResult(countDownVOs);
		}
		//判断案件时期
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
		//案件
		if (CaseMainNodeEnum.CASE_REPLY.getCode().equals(caseInfo.getCurrentMainNode())) {
			CaseReplyTimeRecordExample example2 = new CaseReplyTimeRecordExample();
			example2.createCriteria().andCaseIdEqualTo(caseId);
			List<CaseReplyTimeRecord> caseReplyTimeRecords = caseReplyTimeRecordMapper.selectByExample(example2);
			for (CaseReplyTimeRecord caseReplyTimeRecord : caseReplyTimeRecords) {
				if (caseReplyTimeRecord.getEndTime().compareTo(new Date())>0) {
					//本请求
					if (RequestTypeEnum.REQUEST.getValue().equals(caseReplyTimeRecord.getRequestType())) {
						//是否变更请求
						if (CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue().equals(caseReplyTimeRecord.getType())) {
							CountDownVO countDownVO = new CountDownVO();
							countDownVO.setName("本请求答辩期");
							countDownVO.setTime(caseReplyTimeRecord.getEndTime().getTime()-new Date().getTime());
							countDownVOs.add(countDownVO);
						}else if (CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue().equals(caseReplyTimeRecord.getType())) {
							CountDownVO countDownVO = new CountDownVO();
							countDownVO.setName("变更请求答辩期");
							countDownVO.setTime(caseReplyTimeRecord.getEndTime().getTime()-new Date().getTime());
							countDownVOs.add(countDownVO);
						}
					//反请求
					}else if(RequestTypeEnum.BACK_REQUEST.getValue().equals(caseReplyTimeRecord.getRequestType())){
						if (CaseReplyTimeRecordTypeEnum.CASE_REPLY.getValue().equals(caseReplyTimeRecord.getType())) {
							CountDownVO countDownVO = new CountDownVO();
							countDownVO.setName("本请求答辩期");
							countDownVO.setTime(caseReplyTimeRecord.getEndTime().getTime()-new Date().getTime());
							countDownVOs.add(countDownVO);
						}else if (CaseReplyTimeRecordTypeEnum.CASE_CHANGE_REPLY.getValue().equals(caseReplyTimeRecord.getType())) {
							CountDownVO countDownVO = new CountDownVO();
							countDownVO.setName("变更反请求答辩期");
							countDownVO.setTime(caseReplyTimeRecord.getEndTime().getTime()-new Date().getTime());
							countDownVOs.add(countDownVO);
						}
					}
					
				}
			}
			return BusiExecuteResult.builderSuccessResult(countDownVOs);
		}
		//审理期
		if (CaseMainNodeEnum.CASE_PROCESSING.getCode().equals(caseInfo.getCurrentMainNode())) {
			CaseNodeOperExample example3 = new CaseNodeOperExample();
			example3.createCriteria().andCaseIdEqualTo(caseId).andNextNodeIdEqualTo(CaseMainNodeEnum.CASE_PROCESSING.getCode());
			List<CaseNodeOper> caseNodeOpers = caseNodeOperMapper.selectByExample(example3);
			CountDownVO countDownVO = new CountDownVO();
			countDownVO.setName("审理期");
			countDownVO.setTime(caseNodeOpers.get(0).getPlanEndTime().getTime()-new Date().getTime());
			countDownVOs.add(countDownVO);
			return BusiExecuteResult.builderSuccessResult(countDownVOs);
		}
		
		return null;
	}

	@Override
	public BusiExecuteResult<WithdrawMessageVO> withdrawMessageExecute(
			String caseId) {
		WithdrawMessageVO messageVO = new WithdrawMessageVO();
		//被请求撤案 没有反请求
		if (commonService.requestIsWithdraw(caseId, RequestTypeEnum.REQUEST)&&
				(!commonService.hasBackRequest(caseId))) {
			messageVO.setMessage(WithdrawMessageEnum.PROPOSER_WITHDRAW.getMsg());
			return BusiExecuteResult.builderSuccessResult(messageVO);
		}
		//申请人已撤回仲裁申请，反请求继续
		if (commonService.requestIsWithdraw(caseId, RequestTypeEnum.REQUEST)&&
				!commonService.requestIsWithdraw(caseId, RequestTypeEnum.BACK_REQUEST)) {
			messageVO.setMessage(WithdrawMessageEnum.PROPOSER_WITHDRAW_AND_DEFENDANT_GO_ON.getMsg());
			return BusiExecuteResult.builderSuccessResult(messageVO);
		}
		
		//申请人已撤回仲裁申请，反请求继续
		if (commonService.requestIsWithdraw(caseId, RequestTypeEnum.REQUEST)&&
				!commonService.requestIsWithdraw(caseId, RequestTypeEnum.BACK_REQUEST)) {
			messageVO.setMessage(WithdrawMessageEnum.PROPOSER_GO_ON_AND_DEFENDANT_WITHDRAW.getMsg());
			return BusiExecuteResult.builderSuccessResult(messageVO);
		}
		
		//申请人已撤回仲裁请求，被申请人已撤回反请求申请
		if (commonService.requestIsWithdraw(caseId, RequestTypeEnum.REQUEST)&&
				commonService.requestIsWithdraw(caseId, RequestTypeEnum.BACK_REQUEST)) {
			messageVO.setMessage(WithdrawMessageEnum.BOTH_WITHDRAW.getMsg());
			return BusiExecuteResult.builderSuccessResult(messageVO);
		}
		return BusiExecuteResult.builderSuccessResult();
	}
	
	
}
