package com.zyxy.admin.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.admin.service.WithdrawCaseService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitrationCaseDecisionHandleDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationWithdrawCaseDecisionVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

@Controller
@RequestMapping(value="/case")
public class WithdrawCaseController extends BaseController{
	@Autowired
	WithdrawCaseService withdrawCaseService;
	
	@Autowired
	CaseProcessingService caseProcessingService;
	
	@WebLog("仲裁委-撤销仲裁申请审批页面信息")
    @RequestMapping(value = "/withdrawArbitration")
    public ModelAndView withdrawArbitrationApply(
            @RequestParam("approveId") String approveId) {
    	ModelAndView mav=new ModelAndView("case/unCaseCheck");
        SecurityUserVO sessionUser = super.getSessionUser();
		/*
         * 参数验证
		 */
        if (StringUtils.isBlank(approveId)) {
        	mav.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            mav.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return mav;
        }

		/*
         * 业务验证
		 */
        BusiValidResult busiValid=caseProcessingService.approveBusiValid(approveId, sessionUser.getUserInfoId());
        if(busiValid.hasError()){
        	mav.addObject("code", busiValid.getCode());
            mav.addObject("message", busiValid.getMsg());
            return mav;
        }
        
		/*
         * 业务处理
         */
        BusiExecuteResult<ArbitrationWithdrawCaseDecisionVO> executeResult = withdrawCaseService
                .arbitrationWithdrawCaseContentBusiExecute(approveId , sessionUser.getUserInfoId());

        mav.addObject("withdrawCaseVO", executeResult.getBody());
        return mav;
    }

    @WebLog("仲裁委-撤销仲裁本请求的审批")
    @RequestMapping(value = "withdrawArbitrationRequest/reviewContent")
    @ResponseBody
    public ApiResultVO updateArbitrationRequestWithdrawCaseApply(@Valid ArbitrationCaseDecisionHandleDTO formData, BindingResult bindingResult) {
        SecurityUserVO sessionUser = super.getSessionUser();
        formData.setUserId(sessionUser.getUserInfoId());
        
        /*
         * 参数验证
		 */
        if (StringUtils.isBlank(formData.getApproveId()) || bindingResult.hasErrors()) {
        	return super.busiExecuteError(ResultVO.Result.VALID_ERROR_CODE.getResult(), ResultVO.Result.VALID_ERROR_MESSAGE.getResult());
        }
    	
		/*
		 * 业务验证
		 */
        BusiValidResult busiValid = caseProcessingService.approveBusiValid(formData.getApproveId(), sessionUser.getUserInfoId());
        if (busiValid.hasError()) {
        	return super.busiExecuteError(busiValid.getCode(), busiValid.getMsg());
        }
		
		/*
         * 业务处理
         */
        BusiExecuteResult busiExecute = withdrawCaseService.arbitrationWithdrawCaseApproveBusiExecute(formData);
        
        return super.busiExecuteError(busiExecute.getCode(), busiExecute.getMsg());
    }
    
    @WebLog("仲裁委-撤销仲裁反请求的审批")
    @RequestMapping(value = "withdrawArbitrationCounterclaim/reviewContent")
    @ResponseBody
    public ApiResultVO<String> updateArbitrationCounterclaimWithdrawCaseApply(@Valid ArbitrationCaseDecisionHandleDTO formData, BindingResult bindingResult) {
        SecurityUserVO sessionUser = super.getSessionUser();
        formData.setUserId(sessionUser.getUserInfoId());
        
        /*
         * 参数验证
		 */
        if (StringUtils.isBlank(formData.getApproveId()) || bindingResult.hasErrors()) {
            return super.busiExecuteError(ResultVO.Result.VALID_ERROR_CODE.getResult(),
            		ResultVO.Result.VALID_ERROR_MESSAGE.getResult());
        }
    	
		/*
		 * 业务验证
		 */
        BusiValidResult busiValid = caseProcessingService.approveBusiValid(formData.getApproveId(), sessionUser.getUserInfoId());
        if (busiValid.hasError()) {
            return super.busiExecuteError(busiValid.getCode(), busiValid.getMsg());
        }
		
		/*
         * 业务处理
         */
        BusiExecuteResult busiExecute = withdrawCaseService.arbitrationWithdrawCaseApproveBusiExecute(formData);
        
        return super.busiExecuteError(busiExecute.getCode(),busiExecute.getMsg());
    }
    
}
