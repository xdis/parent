package com.zyxy.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.UserManagerService;
import com.zyxy.common.dto.ArbitrationUserInfoDTO;
import com.zyxy.common.dto.UserManagerArbiUserInfoDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委后台用户管理controller
 */
@Controller
@RequestMapping("/userManager")
public class UserManagerController extends BaseController{

	@Autowired
	private UserManagerService userManagerService;
	
	@WebLog("仲裁委-跳转仲裁委用户管理页面")
	@RequestMapping(value = "")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("userManager/userList");
		return mav;
	}


	@WebLog("仲裁委-加载仲裁委用户管理列表")
	@RequestMapping(value = "/arbiUserManager")
	@ResponseBody
	public PageInfo<ArbitrationUserInfoVO> arbiUserManagerList(@Valid ArbitrationUserInfoDTO formData, BindingResult bindingResult, HttpServletResponse response){
		SecurityUserVO sessionUser = super.getSessionUser();

		// 参数初始化
		formData.setUserId(sessionUser.getUserInfoId());

		if(bindingResult.hasErrors()){
			// 返回非法参数
			response.setStatus(Integer.parseInt(ApiResultVO.Coder.VALID_ERROR.getCode()));
			return null;
		}

		//todo 业务验证 待定


		//业务处理
        BusiExecuteResult<PageInfo<ArbitrationUserInfoVO>> busiExecuteResult = userManagerService.arbiUserManagerBusiExecuteResult(formData);

        if (busiExecuteResult.hasError()) {
            // 返回用户账户异常
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }

        return  busiExecuteResult.getBody();
	}

	@WebLog("仲裁委-仲裁委后台用户重置密码")
	@RequestMapping("/resetPwd/{userId}")
    @ResponseBody
	public ApiResultVO<String> resetPwd(@PathVariable("userId") String userId){

        //参数验证
        if(StringUtil.isEmpty(userId)){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = userManagerService.resetPwdBusiValidResult(userId);

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = userManagerService.resetPwdBusiExecuteResult(userId);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
        }

        return super.ok();
    }

    @WebLog("仲裁委-仲裁委后台用户启用账号")
    @RequestMapping("/enableStatus/{userId}")
    @ResponseBody
    public ApiResultVO<String> enableStatus(@PathVariable("userId") String userId){

        //参数验证
        if(StringUtil.isEmpty(userId)){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = userManagerService.enableStatusBusiValidResult(userId);

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = userManagerService.enableStatusBusiExecuteResult(userId);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
        }

        return super.ok();
    }


    @WebLog("仲裁委-仲裁委后台用户注销账号")
    @RequestMapping("/disableStatus/{userId}")
    @ResponseBody
    public ApiResultVO<String> disableStatus(@PathVariable("userId") String userId){

        //参数验证
        if(StringUtil.isEmpty(userId)){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = userManagerService.disableStatusBusiValidResult(userId);

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = userManagerService.disableStatusBusiExecuteResult(userId);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
        }

        return super.ok();
    }


    @WebLog("仲裁委-跳转添加仲裁委页面")
    @RequestMapping(value = "/addArbi")
    public ModelAndView addArbi(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("userManager/addArbiUser");
        return mav;
    }

    @WebLog("仲裁委-添加仲裁委账号")
    @RequestMapping("/addArbiAccount")
    @ResponseBody
    public ApiResultVO<String> addArbiAccount(@Valid UserManagerArbiUserInfoDTO formData,BindingResult bindingResult){
        //参数初始化
        String userInfoId = getSessionUser().getUserInfoId();
        formData.setCreaterId(userInfoId);

        //参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }

        //业务验证
        BusiValidResult busiValidResult = userManagerService.addArbiBusiValidResult(formData);

        if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
        }

        //业务处理
        BusiExecuteResult busiExecuteResult = userManagerService.addArbiBusiExecuteResult(formData);

        if(busiExecuteResult.hasError()){
            return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
        }

        return super.ok();
    }

}
