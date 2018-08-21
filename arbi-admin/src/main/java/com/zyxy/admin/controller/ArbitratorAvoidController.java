package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.ArbitratorAvoidService;
import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.admin.service.RulingBookAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.AvoidListVO;
import com.zyxy.common.vo.AuditRulingBookVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;
/**
 * 回避审核Controller
 */
@Controller
@RequestMapping("avoid/audit")
public class ArbitratorAvoidController extends BaseController {

	@Autowired
	private CaseProcessingService caseProcessingService;
	
	@Autowired
	private ArbitratorAvoidService arbitratorAvoidService;

	/**
	 * 仲裁员回避审核
	 * @param approveId 审批Id
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委-仲裁员回避审核")
	@RequestMapping("/{approveId}/arbitrator")
	public ModelAndView arbitratorAvoidAudit(@PathVariable("approveId") String approveId,
			HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();

		// 返回页面
		ModelAndView modelAndView = new ModelAndView("case/arbitratorAvoidAudit");

		// 参数验证
		if (StringUtil.isEmpty(approveId)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",
					ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务验证
		 */
		BusiValidResult busiValidResult = caseProcessingService.auditTheCaseBusiValid(approveId, sessionUser.getUserInfoId());

		if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		// 业务处理
		AvoidListVO arbitratorAvoidBusiExecute = arbitratorAvoidService.arbitratorAvoidBusiExecute(approveId, sessionUser.getUserInfoId());
		if (arbitratorAvoidBusiExecute == null) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		modelAndView.addObject("arbitratorAvoid", arbitratorAvoidBusiExecute);

		return modelAndView;
	}
	
	
	@WebLog("仲裁委-审核仲裁员回避")
	@RequestMapping("/auditArbitratorAvoid")
	@ResponseBody
	public ApiResultVO auditArbitratorAvoid(@Valid SaveCaseDocDTO formData, BindingResult bindingResult,HttpServletRequest request) {

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
		BusiValidResult busiValidResult = arbitratorAvoidService.auditBusiValid(formData.getCaseId(), formData.getUserId(),formData.getApproveId());

		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),busiValidResult.getMsg());
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = arbitratorAvoidService.auditArbitratorBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
	
	
	
	
	/**
	 * 秘书回避审核
	 * @param approveId 审批Id
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委-仲裁秘书回避审核")
	@RequestMapping("/{approveId}/secretaries")
	public ModelAndView secretariesAvoidAudit(@PathVariable("approveId") String approveId,HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();

		// 返回页面
		ModelAndView modelAndView = new ModelAndView("case/secretariesAvoidAudit");

		// 参数验证
		if (StringUtil.isEmpty(approveId)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		// 业务验证
		BusiValidResult busiValidResult = caseProcessingService.auditTheCaseBusiValid(approveId, sessionUser.getUserInfoId());

		if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		// 业务处理
		AvoidListVO secretariesAvoidBusiExecute = arbitratorAvoidService
				.secretariesAvoidBusiExecute(approveId, sessionUser.getUserInfoId());
		if (secretariesAvoidBusiExecute == null) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView
					.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

		modelAndView.addObject("secretariesAvoid", secretariesAvoidBusiExecute);

		return modelAndView;
	}
	
	
	
	@WebLog("仲裁委-审核秘书回避")
	@RequestMapping("/auditSecretariesAvoid")
	@ResponseBody
	public ApiResultVO auditSecretariesAvoid(
			@Valid SaveCaseDocDTO formData, BindingResult bindingResult,
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
		BusiValidResult busiValidResult = arbitratorAvoidService.auditBusiValid(formData.getCaseId(), formData.getUserId(),formData.getApproveId());

		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),busiValidResult.getMsg());
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = arbitratorAvoidService.auditSecretariesBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}

}
