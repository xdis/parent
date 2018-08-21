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
import com.zyxy.admin.service.InitiateAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.InitiateAuditVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委立案审核页面信息
 */
@RequestMapping("/initate/audit")
@Controller
public class InitiateAuditController extends BaseController {

	@Autowired
	private InitiateAuditService initiateAuditService;
	
	@Autowired
	private CaseProcessingService caseProcessingService; 

	@WebLog("仲裁委-立案审核基本信息")
	@RequestMapping(value = "/{approveId}")
	public ModelAndView initiateAuditInfo(
			@PathVariable("approveId") String approveId, HttpServletRequest request) {

		SecurityUserVO sessionUser = super.getSessionUser();
		String userNo = sessionUser.getUserInfoId();
		
		// 参数初始化
		ModelAndView modelAndView = new ModelAndView("case/filingAudit");

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
		
		InitiateAuditVO initiateAuditBusiExecute = initiateAuditService
				.initiateAuditBusiExecute(approveId, userNo);
		if(!ManagerInfoTypeEnum.INITIATE_THE_SECRETARY.getCode().equals(initiateAuditBusiExecute.getDuties())){
			// 参数初始化
			modelAndView = new ModelAndView("case/filingAuditTable");
		}

		modelAndView.addObject("initiateAuditBusiExecute",
				initiateAuditBusiExecute);
		return modelAndView;
	}

	/**
	 * 审核立案申请
	 *
	 * @param formData 立案审核DTO
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@WebLog("仲裁委—审核立案申请")
	@RequestMapping("/examine")
	@ResponseBody
	public ApiResultVO<String> examine(@Valid AuditPutOnRecordDTO formData,
			BindingResult bindingResult, HttpServletRequest request) {
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
		BusiValidResult busiValidResult = caseProcessingService.auditBusiValid(formData.getApproveId(),formData.getCaseId(),formData.getUserId());
		
		 if (busiValidResult.hasError()) {
		 return super.busiExecuteError(busiValidResult.getCode(),
			 busiValidResult.getMsg());
		 }

		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = initiateAuditService
				.auditTheCaseBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();

	}

}
