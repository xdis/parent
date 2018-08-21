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
import com.zyxy.admin.service.ContraryAuditService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ContraryAuditDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ContraryAuditVO;
import com.zyxy.common.vo.MethodAuditVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.web.BaseController;

/**
 *	对公账户审核
 */
@Controller
@RequestMapping("contrary/audit")
public class ContraryAuditController extends BaseController {
	
	@Autowired
	private ContraryAuditService contraryAuditService;
	
	@WebLog("立案秘书-跳转对公账户审核列表")
	@RequestMapping("")
    public ModelAndView list(){
        //参数初始化返回页面
        ModelAndView modelAndView = new ModelAndView("case/contraryAudit");
        return modelAndView;
    }
	
	@WebLog("立案秘书-获取对公账户审核列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageInfo<ContraryAuditVO> list(@Valid ContraryAuditDTO formData, 
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
        BusiValidResult busiValid = contraryAuditService
        		.contraryAuditBusiValid(formData.getUserId());
        
        if (busiValid.hasError()) {
        	// 返回用户无此权限
			response.setStatus(Integer.parseInt(Coder.NO_PERMISSION.getCode()));
			return null;
		}
        
        //业务处理
        BusiExecuteResult<PageInfo<ContraryAuditVO>> contraryAuditBusiExecute = contraryAuditService
        		.contraryAuditBusiExecute(formData);
        
        if (contraryAuditBusiExecute.hasError()) {
			// 返回用户账户异常
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
        
        return contraryAuditBusiExecute.getBody();
	}
	
	@WebLog("立案秘书-审核对公账户")
	@RequestMapping(value = "/audit")
	@ResponseBody
	public ApiResultVO auditContrary(@Valid ContraryAuditDTO formData, 
			BindingResult bindingResult, HttpServletRequest request, 
				HttpServletResponse response){
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
		formData.setUserId(sessionUser.getUserInfoId());
		//formData.setUserId("3");
		
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
        
        //业务验证
		BusiValidResult busiValidResult = contraryAuditService
        		.auditContraryBusiValid(formData);
        
        if (busiValidResult.hasError()) {
        	// 返回用户账户异常
			response.setStatus(Integer.parseInt(Coder.ACCOUNT_ERROR.getCode()));
			return null;
		}
        
        //业务处理
        BusiExecuteResult busiExecuteResult = contraryAuditService
				.auditContraryBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
}
