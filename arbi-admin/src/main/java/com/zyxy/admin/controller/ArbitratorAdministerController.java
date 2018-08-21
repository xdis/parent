package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ArbitratorAdministerService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitratorEnquiriesDTO;
import com.zyxy.common.dto.ArbitratorInfoUpdateDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ArbitratorInfoAduitVO;
import com.zyxy.common.vo.ArbitratorInformationVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 *仲裁员管理Controller
 */
@Controller
@RequestMapping("/arbitrator/administer")
public class ArbitratorAdministerController extends BaseController{
	
	@Autowired
	private ArbitratorAdministerService arbitratorAdministerService;
	
	@WebLog("仲裁委-跳转仲裁员列表")
	@RequestMapping("")
    public ModelAndView list(){
        //参数初始化返回页面
        ModelAndView modelAndView = new ModelAndView("case/arbitratorTable");
        return modelAndView;
    }
	
	@WebLog("仲裁委-获取仲裁员列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageInfo<ArbitratorInformationVO> list(
			@Valid ArbitratorEnquiriesDTO formData,
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
		 * 业务验证 待定
		 */

		/*
		 * 业务处理
		 */
		BusiExecuteResult<PageInfo<ArbitratorInformationVO>> busiExecuteResult = arbitratorAdministerService
				.arbitratorTableBusiExecute(formData);
		if (busiExecuteResult.hasError() || busiExecuteResult == null) {
			// 返回用户账户异常
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}

		return busiExecuteResult.getBody();
	}
	
	
	@WebLog("仲裁委-查看仲裁员详情")
	@RequestMapping(value = "/{id}/info")
	public ModelAndView arbitratorInfo(@PathVariable("id") String id, HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();

		// 参数初始化
		ModelAndView modelAndView = new ModelAndView("case/arbitratorInfo");

		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(id)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",
					ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务验证 待定
		 */

		/*
		 * 业务处理
		 */

		ArbitratorInformationVO arbitratorInfo = arbitratorAdministerService
				.arbitratorInfoBusiExecute(id);

		if (arbitratorInfo == null) {
			modelAndView.addObject("code",
					ResultVO.Result.DB_NOTFOUND_ERROR_MESSAGE);
			modelAndView.addObject("message",
					ResultVO.Result.DB_NOTFOUND_ERROR_MESSAGE);
			return modelAndView;
		}

		modelAndView.addObject("arbitratorInfo", arbitratorInfo);
		return modelAndView;
	}
	
	
	
	@WebLog("仲裁委-禁用仲裁员")
	@RequestMapping("/disable")
	@ResponseBody
	public ApiResultVO disable(@Valid String id,HttpServletRequest request,
			HttpServletResponse response) {

		SecurityUserVO sessionUser = super.getSessionUser();
		
		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(id)) {
			return super.validError();
		}

		/*
		 * 业务验证
		 */
	
		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = arbitratorAdministerService
				.arbitratorDisableBusiExecute(id);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
	
	
	@WebLog("仲裁委-信息审核")
	@RequestMapping(value = "/{id}/infoAudit")
	public ModelAndView arbitratorInfoAudit(@PathVariable("id") String id, HttpServletRequest request) {
		SecurityUserVO sessionUser = super.getSessionUser();

		// 参数初始化
		ModelAndView modelAndView = new ModelAndView("case/arbitratorInfoAudit");

		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(id)) {
			modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			modelAndView.addObject("message",
					ResultVO.Result.VALID_ERROR_MESSAGE);
			return modelAndView;
		}

		/*
		 * 业务验证 待定
		 */

		/*
		 * 业务处理
		 */

		ArbitratorInfoAduitVO arbitratorInfoAduitBusiExecute = arbitratorAdministerService
				.arbitratorInfoAduitBusiExecute(id);
		modelAndView.addObject("arbitratorInfo", arbitratorInfoAduitBusiExecute);
		return modelAndView;
	}
	
	
	@WebLog("仲裁委-仲裁员信息更新或驳回")
	@RequestMapping("/updateArbitratorInfo")
	@ResponseBody
	public ApiResultVO updateArbitratorInfo(@Valid ArbitratorInfoUpdateDTO formData,BindingResult bindingResult, HttpServletRequest request,
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
	
		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = arbitratorAdministerService
				.updateArbitratorInfoBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
	
	
	@WebLog("仲裁委-将仲裁员删除或移出黑名单")
	@RequestMapping("/deleteOrReinstateNormal")
	@ResponseBody
	public ApiResultVO deleteOrReinstateNormal(@Valid ArbitratorInfoUpdateDTO formData,BindingResult bindingResult, HttpServletRequest request,
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
	
		/*
		 * 业务处理
		 */
		BusiExecuteResult busiExecuteResult = arbitratorAdministerService
				.deleteOrReinstateNormalBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),
					busiExecuteResult.getMsg());
		}

		return super.busiExecuteSuccess();
	}
	
	
	
}
