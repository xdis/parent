package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserMethodAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MethodAuditVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.web.BaseController;

/**
 * 法定代表人身份审核
 */
@Controller
@RequestMapping("method/audit")
public class UserMethodAuditController extends BaseController{
	
	@Autowired
	UserMethodAuditService userMethodAuditService;
	
	@WebLog("立案秘书-跳转法人身份审批列表")
	@RequestMapping("")
    public ModelAndView list(){
        //参数初始化返回页面
        ModelAndView modelAndView = new ModelAndView("case/userMethodAudit");
        return modelAndView;
    }
	
	@WebLog("立案秘书-获取法人身份审核列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageInfo<MethodAuditVO> list(@Valid UserAuditDTO formData, 
			BindingResult bindingResult, HttpServletRequest request, 
				HttpServletResponse response){
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
		formData.setUserId(sessionUser.getUserInfoId());
		//formData.setUserId("3"); 
		
		//参数验证
        if (bindingResult.hasErrors()) {
        	//返回非法参数
        	response.setStatus(Integer.parseInt(Coder.VALID_ERROR.getCode()));
            return null;
        }
        
        //业务验证
        BusiValidResult busiValid = userMethodAuditService
        		.userAuditBusiValid(formData.getUserId());
        
        if (busiValid.hasError()) {
        	// 返回用户账户异常
			response.setStatus(Integer.parseInt(Coder.ACCOUNT_ERROR.getCode()));
			return null;
		}
        
        //业务处理
        BusiExecuteResult<PageInfo<MethodAuditVO>> methodAuditBusiExecute = userMethodAuditService
        		.methodAuditBusiExecute(formData);
        
        if (methodAuditBusiExecute.hasError()) {
			// 返回用户账户异常
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
        
        return methodAuditBusiExecute.getBody();
	}
	
	@WebLog("立案秘书—审核法人身份")
	@RequestMapping("/audit")
	@ResponseBody
	public ApiResultVO auditBeCounterclaim(@Valid UserAuditDTO formData,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		SecurityUserVO sessionUser = super.getSessionUser();
		formData.setUserId(sessionUser.getUserInfoId());

		/*
		 * 参数验证
		 */
		if (bindingResult.hasErrors()) {
			return super.validError();
		}

		/*
		 * 业务验证
		 */
		BusiValidResult busiValidResult = userMethodAuditService
				.auditMethodBusiValid(formData);

		if (busiValidResult.hasError()) {
			// 返回用户账户异常
			response.setStatus(Integer.parseInt(Coder.CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR.getCode()));
			return null;
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = userMethodAuditService
				.auditMethodBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
}
