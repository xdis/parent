package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.ConciliationBookService;
import com.zyxy.admin.service.PublicCoreService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseApproveDTO;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ConciliationBookVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委调解书申请审核
 */
@Controller
@RequestMapping("/case/conciliation")
public class ConciliationBookController extends BaseController {
	
	@Autowired
	private ConciliationBookService conciliationBookService;
	
	@Autowired
	private PublicCoreService publicCoreService;
	
	/**
	 * 根据案件审批编号查询案件id，根据案件id查询调解书所需数据
	 * id 审批编号
	 * @return 
	 */
	@WebLog("仲裁委-调解书审核")
	@RequestMapping("")
	public ModelAndView get(@Valid CaseApproveDTO formData, BindingResult bingBindingResult, HttpServletRequest request) {
		
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
		ModelAndView modelAndView= new ModelAndView("case/conciliationBook");
//		formData.setApproveId("1");
		formData.setApproveType(ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
		formData.setUserId(sessionUser.getUserInfoId());
		
		// 参数验证
        if (bingBindingResult.hasErrors()) {
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }
        
        //业务验证
        BusiValidResult busiValidResult = conciliationBookService.queryBusiValid(formData);
        if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}
        
        //业务处理
		ConciliationBookVO conciliationBookVO = conciliationBookService.selectByCaseId(formData);
		modelAndView.addObject("conciliationBook", conciliationBookVO);
		
		return modelAndView;
	}
	
	/**
	 * 审核调解书-插入审批意见
	 * @return 
	 */
	@WebLog("仲裁委-审核调解书")
	@RequestMapping("/audit")
	public ApiResultVO add(@Valid CaseApproveSuggestDTO formData, BindingResult bindingResult, HttpServletRequest request) {
		
		SecurityUserVO sessionUser = super.getSessionUser();
		formData.setCreaterId(sessionUser.getUserInfoId());
            
		//参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }
        
        //业务验证
        BusiValidResult auditBusiValid = conciliationBookService.auditBusiValid(
        		formData.getApproveId(),sessionUser.getUserInfoId(),
        		ApproveTypeEnum.CONCILIATION_BOOK_APPROVAL.getTypeName());
		
        if (auditBusiValid.hasError()) {
            return super.busiValidError(auditBusiValid.getCode(),auditBusiValid.getMsg());
        }
        
        //业务处理
		BusiExecuteResult busiExecuteResult = conciliationBookService.add(formData, 
				sessionUser.getUserInfoId());
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}
		
		return super.busiExecuteSuccess();
	}
}
