package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.zyxy.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.CaseChangeRecordService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseChangeRecordDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseChangeRecordVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 变更仲裁请求控制层
 *
 */
@Controller
@RequestMapping("/case/changeRecord")
public class CaseChangeRecordController extends BaseController{
	
	@Autowired
	private CaseChangeRecordService caseChangeRecordService;
	
	@WebLog("仲裁委-变更仲裁请求")
	@RequestMapping("/{approveId}")
	public ModelAndView get(@PathVariable("approveId") String approveId,HttpServletRequest request){
		SecurityUserVO sessionUser = super.getSessionUser();
		//参数初始化
        ModelAndView modelAndView = new ModelAndView("case/caseChangeRecord");

        //参数验证
        if(StringUtil.isEmpty(approveId)){
        	modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        
        //业务验证
        BusiValidResult busiValidResult = caseChangeRecordService.queryCaseChangeRecordBusiValid(sessionUser.getUserInfoId(),approveId);
        
        if(busiValidResult.hasError()){
        	modelAndView.addObject("code", busiValidResult.getCode());
            modelAndView.addObject("message", busiValidResult.getMsg());
            return modelAndView;
        }
        
        //业务处理
        BusiExecuteResult<CaseChangeRecordVO> busiExecuteResult = caseChangeRecordService.queryCaseChangeRecordBusiExecuteResult(sessionUser.getUserInfoId(),approveId);
       
        if(busiExecuteResult.hasError()){
        	modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }
        
        
        modelAndView.addObject("caseChangeRecordVO",busiExecuteResult.getBody());
        return modelAndView;
	}
	
	/**
	 * 仲裁委-变更仲裁请求审核
	 * @param formData
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委-审核变更仲裁申请")
	@RequestMapping("/audit/{caseChangeRecordId}")
	@ResponseBody
	public ApiResultVO audit(@PathVariable("caseChangeRecordId")String caseChangeRecordId,@Valid CaseApproveSuggestDTO formData,BindingResult bindingResult,HttpServletRequest request){
		SecurityUserVO sessionUser = super.getSessionUser();
		//参数初始化
        formData.setCreaterId(sessionUser.getUserInfoId());
        
        //参数验证
        if(bindingResult.hasErrors()){
        	return super.validError();
        }
        
        //业务验证
        BusiValidResult busiValidResult = caseChangeRecordService.auditCaseChangeRecordBusiValid(formData.getCaseId(), formData.getCreaterId(), formData.getApproveId(),caseChangeRecordId);
        
        if(busiValidResult.hasError()){
        	return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        
        //业务处理
        BusiExecuteResult<CaseChangeRecordVO> busiExecuteResult = caseChangeRecordService.auditCaseChangeRecordBusiExecute(formData,caseChangeRecordId);
       
        if(busiExecuteResult.hasError()){
        	return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        
		return super.ok();
	}
}
