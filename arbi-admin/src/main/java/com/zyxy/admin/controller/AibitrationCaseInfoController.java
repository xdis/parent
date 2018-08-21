package com.zyxy.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.AibitrationCaseInfoService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AdjudicationAmendmentVO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorCaseReplyInfoVO;
import com.zyxy.common.vo.ArbitratorCaseRequestInfoVO;
import com.zyxy.common.vo.CaseArbitrationInfoVO;
import com.zyxy.common.vo.ChangeRequestContentVO;
import com.zyxy.common.vo.EvidenceVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委案件信息控制层
 */
@Controller
@RequestMapping("/arbitration/case")
public class AibitrationCaseInfoController extends BaseController {

    @Autowired
    private AibitrationCaseInfoService aibitrationCaseInfoService;

    /**
     * 案件请求基本信息
     * @param caseId
     * @return
     */
    @WebLog(value = "仲裁委-案件请求信息")
    @RequestMapping(value = "/{caseId}/requestInfo")
    public ModelAndView caseRequestInfo(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("detailsPage/requestInfo");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<ArbitratorCaseRequestInfoVO> busiExecuteResult = aibitrationCaseInfoService.caseRequestInfoBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseDeRequestInfo",busiExecuteResult.getBody());
        return modelAndView;
    }


    /**
     * 仲裁委-案件请求答辩信息
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-案件请求答辩信息")
    @RequestMapping(value = "/{caseId}/requestReplyInfo")
    public ModelAndView caseReplyInfo(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/thisRequestReply");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<ArbitratorCaseReplyInfoVO> busiExecuteResult = aibitrationCaseInfoService.caseReplyInfoBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());
       
        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseReplyInfo",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    
    /**
     * 仲裁委-变更仲裁请求信息
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-变更仲裁请求")
    @RequestMapping(value = "/{caseId}/changeRequest")
    public ModelAndView changeRequest(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/changeRequest");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<List<ChangeRequestContentVO>> busiExecuteResult = aibitrationCaseInfoService.changeRequestBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("changeRequest",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    
    /**
     * 仲裁委-变更仲裁请求答辩信息
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-变更仲裁请求答辩信息")
    @RequestMapping(value = "/{caseId}/changeDebateRequest")
    public ModelAndView changeDebateRequest(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/changeRequestReply");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<List<ArbitratorCaseReplyInfoVO>> busiExecuteResult = aibitrationCaseInfoService.changeDebateRequestBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseReplyInfo",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    
    /**
     * 仲裁委-举证
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-举证")
    @RequestMapping(value = "/{caseId}/caseProof")
    public ModelAndView caseProof(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/caseProof");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<List<EvidenceVO>> busiExecuteResult = aibitrationCaseInfoService.caseProofBusiExecute(caseId);

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("evidenceList",busiExecuteResult.getBody());
        return modelAndView;
    }

    /**
     * 案件反请求基本信息
     * @param caseId
     * @return
     */
    @WebLog(value = "仲裁委-案件反请求信息")
    @RequestMapping(value = "/{caseId}/deRequestInfo")
    public ModelAndView caseDeRequestInfo(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("detailsPage/requestInfo");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<ArbitratorCaseRequestInfoVO> busiExecuteResult = aibitrationCaseInfoService.caseRequestInfoBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseDeRequestInfo",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    
    /**
     * 仲裁委-变更仲裁反请求信息
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-变更仲裁反请求")
    @RequestMapping(value = "/{caseId}/changeReverseRequest")
    public ModelAndView changeReverseRequest(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/changeRequest");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<List<ChangeRequestContentVO>> busiExecuteResult = aibitrationCaseInfoService.changeRequestBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("changeRequest",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    /**
     * 仲裁委-案件反请求答辩信息
     * @param caseId
     * @return
     */
    @WebLog(value = "仲裁委-案件反请求答辩信息")
    @RequestMapping(value = "/{caseId}/deRequestReplyInfo")
    public ModelAndView caseDeReplyInfo(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("detailsPage/thisRequestReply");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<ArbitratorCaseReplyInfoVO> busiExecuteResult = aibitrationCaseInfoService.caseReplyInfoBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseDeReplyInfo",busiExecuteResult.getBody());
        return modelAndView;
    }
    
    
    /**
     * 仲裁委-变更仲裁反请求答辩信息
     * @param caseId 案件Id
     * @return
     */
    @WebLog(value = "仲裁委-变更仲裁反请求答辩信息")
    @RequestMapping(value = "/{caseId}/changeReverseDebateRequest")
    public ModelAndView changeReverseDebateRequest(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化
        ModelAndView modelAndView = new ModelAndView("detailsPage/changeRequestReply");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<List<ArbitratorCaseReplyInfoVO>> busiExecuteResult = aibitrationCaseInfoService.changeDebateRequestBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseReplyInfo",busiExecuteResult.getBody());
        return modelAndView;
    }


    /**
     * 仲裁委-案件裁判信息
     * @param caseId
     * @return
     */
    @WebLog(value = "仲裁委-案件裁判信息")
    @RequestMapping(value = "/{caseId}/arbitrationInfo")
    public ModelAndView caseArbitrationInfo(@PathVariable("caseId") String caseId) {
        SecurityUserVO sessionUser = super.getSessionUser();
        //参数初始化 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("case/caseChangeRecord");

        //参数验证
        if (StringUtils.isBlank(caseId)) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        //业务处理
        BusiExecuteResult<CaseArbitrationInfoVO> busiExecuteResult = aibitrationCaseInfoService.caseArbitrationInfoBusiExecute(caseId);

        if(busiExecuteResult.hasError()){
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("caseArbitrationInfo",busiExecuteResult.getBody());
        return modelAndView;
    }


    /**
     * 仲裁委-跳转案件补正列表
     * @return
     */
    @WebLog("仲裁委-跳转案件补正列表")
    @RequestMapping("/amendmentInfo")
    public ModelAndView amendmentInfoList(){
        //参数初始化返回页面 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("case/caseHanding");
        return modelAndView;
    }


    /**
     * 仲裁委-案件补正信息
     *
     * @param caseId
     * @return
     */
    @WebLog("仲裁委-案件补正信息")
    @RequestMapping("/{caseId}/amendmentInfo")
    @ResponseBody
    public PageInfo<AdjudicationAmendmentVO> amendmentInfo(@PathVariable("caseId") String caseId,HttpServletResponse response) {
        SecurityUserVO sessionUser = super.getSessionUser();


        //参数验证
        if (StringUtils.isBlank(caseId)) {
            //返回非法参数
            response.setStatus(Integer.parseInt(ApiResultVO.Coder.VALID_ERROR.getCode()));
            return null;
        }

        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());

        if (busiValidResult.hasError()) {
            //返回用户账户异常
            response.setStatus(Integer.parseInt(busiValidResult.getCode()));
            return null;
        }

        //业务处理
        BusiExecuteResult amendmentInfoBusiExecute = aibitrationCaseInfoService.amendmentInfoBusiExecute(caseId);

        if(amendmentInfoBusiExecute.hasError()){
            //返回用户系统异常
            response.setStatus(Integer.parseInt(amendmentInfoBusiExecute.getCode()));
            return null;
        }

        BusiExecuteResult<PageInfo<AdjudicationAmendmentVO>> busiExecuteResult = amendmentInfoBusiExecute;


        return busiExecuteResult.getBody();
    }


    /**
     * 仲裁委-跳转辩论记录列表
     * @return
     */
    @WebLog("仲裁委-跳转辩论记录列表")
    @RequestMapping("/argueRecord")
    public ModelAndView argueRecordList(){
        //参数初始化返回页面 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("case/caseHanding");
        return modelAndView;
    }


    /**
     * 仲裁委-辩论记录列表
     * @param caseId
     * @param response
     * @return
     */
    @WebLog("仲裁委-辩论记录列表")
    @RequestMapping("/{caseId}/argueRecord")
    public PageInfo<ArgueRecord> list(@PathVariable("caseId") String caseId,HttpServletResponse response){
        SecurityUserVO sessionUser = super.getSessionUser();


        //参数验证
        if (StringUtils.isBlank(caseId)) {
            //返回非法参数
            response.setStatus(Integer.parseInt(ApiResultVO.Coder.VALID_ERROR.getCode()));
            return null;
        }

        //业务验证
        BusiValidResult busiValidResult = aibitrationCaseInfoService.caseInfoBusiValid(caseId, sessionUser.getUserInfoId());

        if (busiValidResult.hasError()) {
            //返回用户账户异常
            response.setStatus(Integer.parseInt(busiValidResult.getCode()));
            return null;
        }

        //业务处理
        BusiExecuteResult<PageInfo<ArgueRecord>> busiExecuteResult = aibitrationCaseInfoService.argueRecordListBusiExecute(caseId);

        if(busiExecuteResult.hasError()){
            //返回用户系统异常
            response.setStatus(Integer.parseInt(busiExecuteResult.getCode()));
            return null;
        }



        return busiExecuteResult.getBody();
    }
}
