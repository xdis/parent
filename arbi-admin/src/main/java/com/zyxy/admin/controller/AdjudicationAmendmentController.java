package com.zyxy.admin.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.AdjudicationAmendmentService;
import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.SysUser;
import com.zyxy.common.dto.AdjudicationAmendmentDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AmendmentContentVO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.web.BaseController;

@Controller
@RequestMapping("/case")
public class AdjudicationAmendmentController extends BaseController{
	@Autowired
	CaseProcessingService caseProcessingService;
	
	@Autowired
	AdjudicationAmendmentService adjudicationAmendmentService;
	
	@WebLog("仲裁委-裁决补正书信息")
	@RequestMapping("/adjudicationAmendmentDoc")
	public ModelAndView amendmentInfo(@RequestParam("approveId")String approveId){
		ModelAndView mav = new ModelAndView("case/adjudicationAmendment");
		SysUser sessionUser = super.getSessionUser();
		
		/*
		 * 参数 验证
		 */
		if(StringUtils.isBlank(approveId)){
			mav.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            mav.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return mav;
		}
		
		/*
		 * 业务验证
		 */
		BusiValidResult busiValid = caseProcessingService.approveBusiValid(approveId, sessionUser.getUserInfoId());
		if(busiValid.hasError()){
			mav.addObject("code", busiValid.getCode());
			mav.addObject("msg", busiValid.getMsg());
			return mav;
		}
		
		/*
		 * 业务执行
		 */
		BusiExecuteResult<AmendmentContentVO> busiExecute = adjudicationAmendmentService
				.queryAdjudicationAmendment(approveId, sessionUser.getUserInfoId());
		mav.addObject("amendmentVO", busiExecute.getBody());
		return mav;
	}
	
	@WebLog("裁决补正书审批")
	@RequestMapping("/amendmentApprove")
	@ResponseBody
	public ApiResultVO approveAdjudicationAmendmentInfo(@Valid AdjudicationAmendmentDTO formData ,BindingResult bindingResult){
		SysUser sessionUser = super.getSessionUser();
		String userId= sessionUser.getUserInfoId();
		
		/*
		 * 参数初始化
		 */
		formData.setUserId(userId);
		
		/*
		 * 参数验证
		 */
		if(bindingResult.hasErrors()){
			return super.busiExecuteError(ResultVO.Result.VALID_ERROR_CODE.getResult(),
					ResultVO.Result.VALID_ERROR_MESSAGE.getResult());
		}
		
		/*
		 * 业务验证
		 */
		BusiValidResult busiValid = caseProcessingService.approveBusiValid(formData.getApproveId(), userId);
		if(busiValid.hasError()){
			return super.busiExecuteError(busiValid.getCode(), busiValid.getMsg());
		}
		
		BusiExecuteResult busiExecute = adjudicationAmendmentService.updateAdjudicationAmendment(formData);
		
		return super.busiExecuteError(busiExecute.getCode(), busiExecute.getMsg());
	}
	
	@WebLog("仲裁委-补正历史记录")
	@RequestMapping("/adjudicationAmendmentDoc/caseId")
	public ModelAndView amendment(AdjudicationAmendmentDTO formData){
		ModelAndView mav = new ModelAndView("case/adjudication");
		SysUser sessionUser = super.getSessionUser();
		
		AmendmentContentVO amendmentContentVO = adjudicationAmendmentService
				.queryAdjudicationAmendmentByCaseId(formData);
		mav.addObject("amendmentVO", amendmentContentVO);
		mav.addObject("caseId", formData.getCaseId());
		
		return mav;
	}
	
	@WebLog("仲裁委-查询出具裁决补正书")
	@RequestMapping("/adjudicationAmendmentDoc/approveId")
	public ModelAndView issued(@Valid AdjudicationAmendmentDTO formData ,BindingResult bindingResult){
		ModelAndView mav = new ModelAndView("case/adjudicationAmendment");
		SysUser sessionUser = super.getSessionUser();
		
		//参数初始化
		formData.setUserId(sessionUser.getUserInfoId());
		
		//参数 验证
		if(bindingResult.hasErrors()){
			mav.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            mav.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return mav;
		}
		
		//业务处理
		BusiExecuteResult<AmendmentContentVO> busiExecute = adjudicationAmendmentService
				.selectAdjudicationAmendment(formData);
		AmendmentContentVO amendmentContentVO = adjudicationAmendmentService
			.queryAdjudicationAmendmentByCaseId(formData);
		
		mav.addObject("amendmentVO", busiExecute.getBody());
		mav.addObject("amendmentContentVO", amendmentContentVO);
		
		return mav;
	}
}
