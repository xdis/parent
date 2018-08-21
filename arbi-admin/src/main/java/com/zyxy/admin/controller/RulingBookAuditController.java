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

import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.admin.service.RulingBookAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.RulingBookAuditDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.AuditRulingBookVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 裁决书审核
 *
 */
@Controller
@RequestMapping("/ruling/audit")
public class RulingBookAuditController extends BaseController{
	
	@Autowired
	private CaseProcessingService caseProcessingService;
	
	@Autowired
	private RulingBookAuditService rulingBookAuditService;

	/**
	 * 裁决书审核
	 * 
	 * @param caseId
	 *            案件Id
	 * @param request
	 * @return 裁决书预览信息
	 */
	@WebLog("仲裁委-裁决书审核")
	@RequestMapping("/{approveId}/rulingBookAudit")
	public ModelAndView rulingBookAudit(@PathVariable("approveId") String approveId,
			HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();
		
		// 返回页面
		ModelAndView modelAndView = new ModelAndView("case/auditRulingAudit");

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
		AuditRulingBookVO rulingBookAuditBusiExecute = rulingBookAuditService
				.rulingBookAuditBusiExecute(approveId,sessionUser.getUserInfoId());
		if (rulingBookAuditBusiExecute == null) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView
					.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}
		modelAndView.addObject("auditRulingBookVO", rulingBookAuditBusiExecute);

		return modelAndView;
	}
	
	
	
	@WebLog("仲裁委—审核裁决书")
	@RequestMapping("/auditRulingBook")
	@ResponseBody
	public ApiResultVO auditRulingBook(
			@Valid RulingBookAuditDTO formData, BindingResult bindingResult,
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
				ApproveTypeEnum.ARBITRAL_AWARD_APPROVAL.getTypeName());

		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),
					busiValidResult.getMsg());
		}

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = rulingBookAuditService
				.auditRulingBookBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
	
	
	


}
