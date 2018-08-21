package com.zyxy.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zyxy.common.vo.ApiResultVO;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyxy.admin.service.SysResourceService;
import com.zyxy.admin.service.SystemMessageService;
import com.zyxy.admin.util.RequestUtil;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.SysResource;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.vo.UserInfoVO;
import com.zyxy.common.web.BaseController;


@Controller
public class IndexController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private SysResourceService sysResourceService;
	
	@Autowired
	private SystemMessageService systemMessageService;
	
	@WebLog("仲裁委-首页")
	@RequestMapping(value = "/index", method = {RequestMethod.GET})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		SecurityUserVO sessionUser = super.getSessionUser();
		
		String accessToken = request.getParameter("access_token");
		/*
		 * 参数验证
		 */
		if(StringUtils.isBlank(accessToken)){
			return new ModelAndView("redirect:/login");
		}
		List<SysResource> userResource = sysResourceService.selectUserResource(sessionUser.getUserInfoId());
		
		//登录人显示
		UserInfoVO userInfoVO = sysResourceService.selectUserInFo(sessionUser.getUserInfoId());
		if(userInfoVO==null){
            userInfoVO = sysResourceService.selectPhoneByUserId(sessionUser.getUserInfoId());
		}

        /*StringBuffer buffer = new StringBuffer(userInfoVO.getPhone());
        userInfoVO.setPhone(buffer.replace(5, 9, "****").toString());*/
		
		//查询未读的消息数量
		int count = systemMessageService.queryUnreadMessages(sessionUser.getUserInfoId());

		//转成json字符串
		JSONArray resArray = new JSONArray();
		resArray.addAll(userResource);

		mav.addObject("resJson", resArray.toJSONString());
		mav.addObject("resourceList", userResource);
		mav.addObject("accessToken", accessToken);
		mav.addObject("userInfoVO", userInfoVO);
		mav.addObject("count", count);
		return mav;
	}
	@WebLog("仲裁委-登录")
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request) {
		String reqIp = RequestUtil.getIp(request);
		logger.info("请求登录页面，IP:{}", reqIp);
		return "login";
	}
	@WebLog("仲裁委-首页")
	@PreAuthorize("hasAnyAuthority('home')")
	@RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(HttpServletRequest request) {
		return "home";
	}

    @WebLog("仲裁委-登出")
    @ResponseBody
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResultVO<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        ApiResultVO<String> ret = new ApiResultVO<String>();
        String reqIp = RequestUtil.getIp(request);
        logger.info("请求登出接口，IP:{}", reqIp);
        return ret.setCoder(ApiResultVO.Coder.SUCCESS);
    }


}
