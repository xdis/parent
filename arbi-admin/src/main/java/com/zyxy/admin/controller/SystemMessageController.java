package com.zyxy.admin.controller;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.SysManagementService;
import com.zyxy.common.domain.MessageRecord;
import com.zyxy.common.dto.SysMessageRecordDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.PublicCoreService;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.web.BaseController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 系统消息模块Controller
 */
@Controller
@RequestMapping("/release/message")
public class SystemMessageController extends BaseController {
	
	@Autowired
	private PublicCoreService publicCoreService;

	@Autowired
	private SysManagementService sysManagementService;
	/**
	 * 跳转系统消息管理-发布通知
	 */
	@RequestMapping("")
	public ModelAndView releasemessage() {
		ModelAndView modelAndView = new ModelAndView("case/releaseMessage");
        return modelAndView;
	}
	
	/**
	 * 发布通知
	 * @param formData
	 */
	@RequestMapping("/news")
    @ResponseBody
	public ApiResultVO<String> add(@Valid MessageInsertDTO formData, BindingResult bindingResult) {
        //参数初始化
        formData.setUserId(getSessionUser().getUserInfoId());
        formData.setCreaterId(getSessionUser().getUserInfoId());
        formData.setCreateTime(new Date());

	    //参数验证
        if(bindingResult.hasErrors()){
            return super.validError();
        }

        ApiResultVO<String> apiResultVO = publicCoreService.add(formData);
        return apiResultVO;
	}

	/**
	 * 跳转到系统消息页面
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(){
		//参数初始化返回页面
		ModelAndView modelAndView = new ModelAndView("case/sysMessage");
		return modelAndView;
	}


    /**
     * 查询系统消息列表
     * @param formData
     * @param bindingResult
     * @param response
     * @return
     */
	@RequestMapping("/sysMessageList")
    @ResponseBody
	public PageInfo<MessageRecord> sysMessageList(@Valid SysMessageRecordDTO formData, BindingResult bindingResult,HttpServletResponse response){

		SecurityUserVO sessionUser = super.getSessionUser();

		//参数初始化
		formData.setUserId(sessionUser.getUserInfoId());

		//参数验证
		if (bindingResult.hasErrors()) {
			//返回非法参数
			response.setStatus(Integer.parseInt(ApiResultVO.Coder.VALID_ERROR.getCode()));
			return null;
		}

		//业务处理
        BusiExecuteResult<PageInfo<MessageRecord>> busiExecuteResult = sysManagementService.queryMessageRecordListBusiExecute(formData);

        if(busiExecuteResult.hasError()){
			//返回用户系统异常
			response.setStatus(Integer.parseInt(busiExecuteResult.getCode()));
			return null;
		}
		return busiExecuteResult.getBody();
	}

    /**
     * 根据id查询出系统消息详情
     * @param id
     * @return
     */
	@RequestMapping("/{id}/messageDetail")
	public ModelAndView messageDetail(@PathVariable("id") Integer id){
        //参数初始化返回页面 todo 返回页面
        ModelAndView modelAndView = new ModelAndView("case/sysMessageDetail");

        //参数验证
        if(id==null){
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务处理
        BusiExecuteResult<MessageRecord> busiExecuteResult = sysManagementService.queryMessageRecordDetailBusiExecuteResult(id);

        if(busiExecuteResult.hasError()){
            //返回用户系统异常
            modelAndView.addObject("code", busiExecuteResult.getCode());
            modelAndView.addObject("message", busiExecuteResult.getMsg());
            return modelAndView;
        }

        modelAndView.addObject("messageRecordDetail",busiExecuteResult.getBody());

        return modelAndView;
    }


}
