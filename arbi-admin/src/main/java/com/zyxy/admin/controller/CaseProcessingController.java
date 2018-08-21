package com.zyxy.admin.controller;

import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.ChangeCounterclaimDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.AhangeCounterclaimtVO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.InitiateAuditVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 案件处理信息
 *
 */
@Api(description = "案件处理")
@Controller
@RequestMapping("/case/processing")
public class CaseProcessingController extends BaseController {

	@Autowired
	private CaseProcessingService caseProcessingService;

	/**
	 * 反请求审核申请书页面
	 * @param approveId 审批Id
	 * @param request
	 * @return 反请求审核申请书页面信息
	 */
	@WebLog("仲裁委-反请求审核")
	@RequestMapping("/{approveId}/antiRequestAudit")
	public ModelAndView antiRequestAudit(@PathVariable("approveId") String approveId,
			HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//返回页面
		ModelAndView modelAndView = new ModelAndView("case/antiRequestAudit");

		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(approveId)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",
					ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务验证
		 */
		BusiValidResult busiValidResult = caseProcessingService
				.auditTheCaseBusiValid(approveId, sessionUser.getUserInfoId());

		if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView
					.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务处理
		 */
		InitiateAuditVO beCounterclaimAuditVO = caseProcessingService
				.beCounterclaimAuditBusiExecute(approveId,
						sessionUser.getUserInfoId());

		modelAndView.addObject("initiateAuditBusiExecute",
				beCounterclaimAuditVO);
		return modelAndView;
	}

	/**
	 * 审核反请求
	 * @param formData  案件审核DTO
	 * @param bindingResult
	 * @param request
	 * @return 审核结果
	 */
	@WebLog("仲裁委—审核反请求")
	@RequestMapping("/auditBeCounterclaim")
	@ResponseBody
	public ApiResultVO auditBeCounterclaim(
			@Valid AuditPutOnRecordDTO formData, BindingResult bindingResult,
			HttpServletRequest request) {

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
		BusiValidResult busiValidResult = caseProcessingService.auditBusiValid(
				formData.getApproveId(), formData.getCaseId(),
				formData.getUserId());

		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),
					busiValidResult.getMsg());
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = caseProcessingService
				.auditBeCounterclaimBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}

	/**
	 * 变更仲裁反请求
	 * @param approveId 审批id
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委-变更仲裁反请求")
	@RequestMapping("/{approveId}/changeCounterclaim")
	public ModelAndView changeCounterclaim(
			@PathVariable("approveId") String approveId, HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();

		//返回页面
		ModelAndView modelAndView = new ModelAndView("case/changCounterclaim");

		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(approveId)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务验证
		 */
		BusiValidResult busiValidResult = caseProcessingService
				.auditTheCaseBusiValid(approveId, sessionUser.getUserInfoId());

		if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务处理
		 */
		AhangeCounterclaimtVO beCounterclaimAuditVO = caseProcessingService
				.changeCounterclaimtBusiExecute(approveId,sessionUser.getUserInfoId());
		modelAndView.addObject("beCounterclaimAuditVO", beCounterclaimAuditVO);
		return modelAndView;
	}

	/**
	 * 审核变更反请求
	 * 
	 * @param formData
	 *            变更仲裁反请求DTO
	 * @param bindingResult
	 * @param request
	 * @return 审核结果
	 */
	@WebLog("仲裁委—审核变更反请求")
	@RequestMapping("/auditChangeCounterclaim")
	@ResponseBody
	public ApiResultVO auditChangeCounterclaim(
			@Valid ChangeCounterclaimDTO formData, BindingResult bindingResult,
			HttpServletRequest request) {

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
		BusiValidResult busiValidResult = caseProcessingService.auditBusiValid(
				formData.getCaseId(), formData.getUserId(),
				ApproveTypeEnum.ALTERATION_COUNTERCLAIM_APPROVAL.getTypeName());

		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),
					busiValidResult.getMsg());
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = caseProcessingService
				.auditChangeCounterclaimBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}

}
