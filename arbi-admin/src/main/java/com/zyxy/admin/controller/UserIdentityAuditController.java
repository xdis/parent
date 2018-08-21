package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserIdentityAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitrationCaseListDTO;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseListVO;
import com.zyxy.common.vo.RealUserAuditVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.web.BaseController;

/**
 * 用户身份审核
 */
@Controller
@RequestMapping("/user/audit")
public class UserIdentityAuditController extends BaseController{
	
	@Autowired
	private UserIdentityAuditService userIdentityAuditService; 
	
	@WebLog("立案秘书-跳转用户身份审批列表")
	@RequestMapping("")
    public ModelAndView list(){
        //参数初始化返回页面
        ModelAndView modelAndView = new ModelAndView("case/userAudit");
        return modelAndView;
    }
	
	@WebLog("立案秘书-获取用户身份审核列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageInfo<RealUserAuditVO> list(@Valid UserAuditDTO formData,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		SecurityUserVO sessionUser = super.getSessionUser();

		// 参数初始化
		formData.setUserId(sessionUser.getUserInfoId());

		/*
		 * 参数验证
		 */
		if (bindingResult.hasErrors()) {
			// 返回非法参数
			response.setStatus(Integer.parseInt(Coder.VALID_ERROR.getCode()));
			return null;
		}

		/*
		 * 业务验证
		 */
		BusiValidResult busiValidResult = userIdentityAuditService
				.userAuditBusiValid(formData.getUserId());

		if (busiValidResult.hasError()) {
			// 返回用户账户异常
			response.setStatus(Integer.parseInt(Coder.ACCOUNT_ERROR.getCode()));
			return null;
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult<PageInfo<RealUserAuditVO>> busiExecuteResult = userIdentityAuditService
				.userAuditBusiExecute(formData);

		if (busiExecuteResult.hasError()) {
			// 返回用户账户异常
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}

		return busiExecuteResult.getBody();
	}
    
    
	
	@WebLog("立案秘书—审核用户身份")
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
		BusiValidResult busiValidResult = userIdentityAuditService
				.auditUserBusiValid(formData);

		if (busiValidResult.hasError()) {
			// 返回用户账户异常
			response.setStatus(Integer.parseInt(Coder.CASE_NOT_IN_WAIT_ACCEPT_STATUS_ERROR.getCode()));
			return null;
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = userIdentityAuditService
				.auditUserBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}


	

}
