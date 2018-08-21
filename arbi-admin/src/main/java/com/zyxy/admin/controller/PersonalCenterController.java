package com.zyxy.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.zyxy.admin.service.DelegateService;
import com.zyxy.admin.service.PersonalCenterService;
import com.zyxy.admin.service.SystemMessageService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.domain.AuthorizationDelegate;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.dto.AuthDelegateDTO;
import com.zyxy.common.dto.MessageRecordListDTO;
import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.mapper.ManagerInfoMapper;
import com.zyxy.common.mapper.UserInfoMapper;
import com.zyxy.common.service.ApproveTypeService;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MessageRecordListVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.vo.UserInfoVO;
import com.zyxy.common.web.BaseController;

/**
 * 个人中心
 */
@Controller
@RequestMapping("/numberCount")
public class PersonalCenterController extends BaseController{

	@Autowired
	private PersonalCenterService personalCenterService;

	@Autowired
	private SystemMessageService systemMessageService;
	@Autowired
	private DelegateService delegateService;
	@Autowired
	private ApproveTypeService approveTypeService;
	@Autowired
	private ManagerInfoMapper managerInfoMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@WebLog("仲裁委-跳转修改密码页面")
	@RequestMapping("myCenter")
	public ModelAndView see() {
		// 参数初始化返回页面
		ModelAndView modelAndView = new ModelAndView("numberCount/myCenter");
		return modelAndView;
	}



	@WebLog("仲裁委-判断原密码正确性和修改密码")
	@RequestMapping("/changeThePassword")
	@ResponseBody
	public ApiResultVO updatePassWord(@Valid SysUserPwdDTO formData,
			HttpServletRequest request, HttpServletResponse response) {
		SecurityUserVO sessionUser = super.getSessionUser();
		// 参数初始化
		formData.setUserId(sessionUser.getUserInfoId());

		/*
		 * 参数验证
		 */
		if (StringUtil.isEmpty(formData.getUserPwd())) {
			return super.validError();
		}

		/*
		 * 业务验证，密码正确性验证
		 */
		BusiValidResult busiValidResult = personalCenterService.sysUserPwdBusiValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),
					busiValidResult.getMsg());
		}

		/*
		 * 核心业务处理，修改密码
		 */
		if (formData.getNewUserPwd() != null || StringUtil.isNotEmpty(formData.getNewUserPwd())) {
			BusiExecuteResult busiExecuteResult = personalCenterService.sysUserPwdBusiExecute(formData);
			if (busiExecuteResult.hasError()) {
				return super.busiExecuteError(busiExecuteResult.getCode(),
						busiExecuteResult.getMsg());
			}
		}

		return super.busiExecuteSuccess();
	}


	/**
	 * 我的消息-查询消息列表
	 * @return
	 * @return
	 */
	@WebLog("仲裁委-消息列表")
	@RequestMapping("/myNews")
	public ModelAndView list(MessageRecordListDTO formData){
		SecurityUserVO sessionUser = super.getSessionUser();
		formData.setUserId(sessionUser.getUserInfoId());

		ModelAndView modelAndView = new ModelAndView("numberCount/messageCenter");

		PageInfo<MessageRecordListVO> messageList = systemMessageService
				.queryMessageList(formData);
		modelAndView.addObject("messageList", messageList);

		return modelAndView;
	}

	/**
	 * 我的消息-根据消息id获取消息详情
	 * @param id
	 * @param request
	 * @return
	 */
	@WebLog("获取消息详情")
    @RequestMapping("/{id}/get")
    public ModelAndView get(@PathVariable("id") Integer id,
    		HttpServletRequest request){
		String userId = super.getSessionUser().getUserInfoId();

		ModelAndView modelAndView = new ModelAndView("numberCount/myMessage");

        //参数验证
        if (id == null){
        	modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务验证
        BusiValidResult busiValidResult = systemMessageService
        		.messageInfoBusiValid(id, userId);
        if (busiValidResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}

        //业务处理
        BusiExecuteResult<MessageRecord> busiExecuteResult = systemMessageService
        		.messageInfoExecute(id, userId);
        if (busiExecuteResult.hasError()) {
        	modelAndView.addObject("code", ResultVO.Result.DB_UPDATE_ERROR_CODE);
			modelAndView.addObject("message", ResultVO.Result.DB_UPDATE_ERROR_MESSAGE);
			return modelAndView;
        }

        modelAndView.addObject("busiExecuteResult", busiExecuteResult.getBody());
        return modelAndView;
    }
	@WebLog("仲裁委-授权管理")
	@RequestMapping("/delegateManager")
	public ModelAndView delegateManager() {
		ModelAndView modelAndView = new ModelAndView("numberCount/delegate");

		String userId = super.getSessionUser().getUserInfoId();
		//判断有没有授权
		BusiExecuteResult<List<AuthorizationDelegate>> delegateResult = delegateService.queryDelegateByUserId(userId);
		List<AuthorizationDelegate> ownDelegateList = delegateResult.getBody();
		if(ownDelegateList!=null && ownDelegateList.size()>0){
			//有授权
			modelAndView.setViewName("numberCount/hasDelegate");
			for(int i=0;i<ownDelegateList.size();i++){
				ownDelegateList.get(i).setRemark(ApproveTypeEnum.getTypeName(ownDelegateList.get(i).getAuthType()).getTypeValue());
			}
			String agentUserId = ownDelegateList.get(0).getAgentUserId();
			UserInfoVO delegateUserinfo = userInfoMapper.selectUserInFoByUserId(agentUserId);
			modelAndView.addObject("ownDelegateList",ownDelegateList);
			modelAndView.addObject("delegateDuties",ManagerInfoTypeEnum.getCode(delegateUserinfo.getDuties()).getMark());
			modelAndView.addObject("delegateName",delegateUserinfo.getName());
			modelAndView.addObject("startDate", DateUtil.formatDate(ownDelegateList.get(0).getStartTime(),"yyyy-MM-dd"));
			modelAndView.addObject("endDate", DateUtil.formatDate(ownDelegateList.get(0).getEndTime(),"yyyy-MM-dd"));

		}else {
			//无授权
			List<ApproveType> approveTypeList = approveTypeService.queryAllApproveType();
			modelAndView.addObject("atList",approveTypeList);

			String currUserDuties = managerInfoMapper.queryDutiesByUserId(userId);
			ArrayList<String> queryDuties = new ArrayList<String>();
			//判断当前用户可以授权的职位
			if(currUserDuties.equals(ManagerInfoTypeEnum.DIRECTOR.getCode())){
				//主任 授权给主任/副主任
				queryDuties.add(ManagerInfoTypeEnum.DIRECTOR.getCode());
				queryDuties.add(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
			}else if(currUserDuties.equals(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode())){
				//副主任 授权给副主任/部长
				queryDuties.add(ManagerInfoTypeEnum.DEPUTY_DIRECTOR.getCode());
				queryDuties.add(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				queryDuties.add(ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode());
			}else if(currUserDuties.equals(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode())
					||currUserDuties.equals(ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode())){
				//部长 只能授权给部长
				queryDuties.add(ManagerInfoTypeEnum.ARBITRATION_MINISTER.getCode());
				queryDuties.add(ManagerInfoTypeEnum.INITIATE_THE_MINISTER.getCode());
			}else{
				queryDuties.add("");
			}

			HashMap<String, Object> params = new HashMap<>();
			params.put("selfUserId",userId);
			params.put("dutiesList",queryDuties);
			List<UserInfo> delegateList = userInfoMapper.queryUserInfoByDuties(params);

			modelAndView.addObject("ownDelegateList",delegateList);
		}
		return modelAndView;
	}
	@WebLog("仲裁委-添加授权")
	@RequestMapping("/addDelegate")
	public ModelAndView addAuthDelegate(@Valid AuthDelegateDTO dto , BindingResult bindingResult){
    	ModelAndView mav = new ModelAndView();
		String userId = super.getSessionUser().getUserInfoId();
    	//参数验证
		if(bindingResult.hasErrors()){
			mav.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
			mav.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
			return mav;
		}
		dto.setUserId(userId);

		//业务处理
		BusiExecuteResult busiExecuteResult = delegateService.addAuthDelegate(dto);
		if(busiExecuteResult.hasError()){
			mav.addObject("code", ResultVO.Result.ERROR_CODE);
			mav.addObject("message", ResultVO.Result.ERROR_MESSAGE);
			return mav;
		}

		return delegateManager();
	}
	
}
