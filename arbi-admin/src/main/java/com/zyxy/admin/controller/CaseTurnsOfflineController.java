package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.CaseTurnsOfflineService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseTurnsOfflineDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseTurnsOfflineRecordVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 *	案件转线下
 */
@Controller
@RequestMapping("/case/turns/offline")
public class CaseTurnsOfflineController extends BaseController {
	
	@Autowired
	private CaseTurnsOfflineService caseTurnsOfflineService;
	
	/**
	 * 跳转案件转线下原因页面
	 * @return 
	 */
	@WebLog("跳转案件转线下原因页面")
	@RequestMapping("/jump/{caseId}")
	public ModelAndView CaseTurnsOffline(@PathVariable("caseId") String caseId) {
		ModelAndView modelAndView = new ModelAndView("case/caseTurnsOffline");
		
		modelAndView.addObject("caseId", caseId);
        return modelAndView;
	}
	
	/**
	 * 案件转线下申请
	 * @return 
	 * @return 
	 */
	@WebLog("仲裁委-案件转线下申请")
	@RequestMapping("/applyfor")
	@ResponseBody
	public ApiResultVO caseApplyFor(@Valid CaseTurnsOfflineDTO formData, 
			BindingResult bingBindingResult, HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
		formData.setUserId(sessionUser.getUserInfoId());
		
		//参数验证
		if (bingBindingResult.hasErrors()) {
			 return super.validError();
		}
		
		//业务验证
		BusiValidResult busiValidResult = caseTurnsOfflineService.applyBusiValid(formData);
		if(busiValidResult.hasError()){
    		return super.busiValidError(busiValidResult.getCode(), 
    				busiValidResult.getMsg());
    	}
		
		//业务处理
		BusiExecuteResult busiExecuteResult = caseTurnsOfflineService.insert(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess();
	}
	
	/**
	 * 案件转线下审核
	 * @return 
	 */
	@WebLog("仲裁委-案件转线下审核")
	@RequestMapping("/{approveId}")
	public ModelAndView caseTurnsOfflineAudit(@PathVariable("approveId") String approveId){
		SecurityUserVO sessionUser = super.getSessionUser();
		
		ModelAndView modelAndView = new ModelAndView("case/caseTurnsOfflineBook");
		
		//参数验证
		if(StringUtils.isBlank(approveId)){
    		modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
    	}
		
		//业务验证
		BusiValidResult busiValidResult = caseTurnsOfflineService
				.caseBusiValid(approveId);
		
		if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
		}
		
		//业务处理
		CaseTurnsOfflineRecordVO caseTurnsOfflineRecordVO = caseTurnsOfflineService
				.caseBusiValidAudit(approveId, sessionUser.getUserInfoId());
		modelAndView.addObject("caseTurnsOfflineRecordVO", caseTurnsOfflineRecordVO);
		
		return modelAndView;
	}
	
	/**
	 * 审核案件转线下
	 * @return 
	 */
	@WebLog("审核案件转线下")
	@RequestMapping("/audit")
	@ResponseBody
	public ApiResultVO auditCaseTurnsOffline(@Valid CaseApproveSuggestDTO formData, 
			BindingResult bindingResult, HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
		formData.setCreaterId(sessionUser.getUserInfoId());
		
		//参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }
        
        //业务验证
        BusiValidResult busiValidResult = caseTurnsOfflineService
        		.auditBusiValid(formData, sessionUser.getUserInfoId());
        
        if (busiValidResult.hasError()) {
        	return super.busiValidError(busiValidResult.getCode(),
        			busiValidResult.getMsg());
		}
        
        //业务处理
        BusiExecuteResult busiExecuteResult = caseTurnsOfflineService
        		.auditBusiExecute(formData);
        
        if (busiExecuteResult.hasError()) {
        	return super.busiExecuteError(busiExecuteResult.getCode(),
        			busiExecuteResult.getMsg());
		}
        
		return super.busiExecuteSuccess();
	}
}
