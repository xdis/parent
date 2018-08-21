package com.zyxy.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.ArbitratorInfoService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitratorInfoDTO;
import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委后台管理-仲裁员添加
 */
@Controller
@RequestMapping("/arbitrator/info")
public class ArbitratorInfoController extends BaseController {
	
	@Autowired
	private ArbitratorInfoService arbitratorInfoService;
	
	@Autowired
    private MicroFileService fileService;
	
	@WebLog("跳转到仲裁员添加页面")
	@RequestMapping(value = "/addArbitrator")
	public ModelAndView add(){
		ModelAndView modelAndView = new ModelAndView("case/addReferee");
		
		return modelAndView;
	}
	
    @WebLog("仲裁员头像上传")
    @RequestMapping(value = "/uploads")
    @ResponseBody
    public ApiResultVO<String> uploads(
    		@RequestParam(value = "uploadFile") MultipartFile uploadFile){
    	ApiResultVO<String> apiResultVO = fileService.uploadFile(getSessionUserId(), 
    			SysEnum.FileBuzzType.HEAD_PHOTO.getCode(), uploadFile);
    	return apiResultVO;
    }
	
	@WebLog("仲裁委-仲裁员管理-添加")
	@RequestMapping(value = "/addreferee")
	@ResponseBody
	public ApiResultVO addreferee(@Valid ArbitratorInfoDTO formData, BindingResult bingBindingResult){
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
        formData.setCreaterId(sessionUser.getUserInfoId());
		
		//参数验证
        if(bingBindingResult.hasErrors()){
            return super.validError();
        }
		
		//业务验证,是否已经存在该用户
		BusiValidResult busiValidResult = arbitratorInfoService.userRegisterBusiValid(formData);
		if(busiValidResult.hasError()){
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
		
		//业务处理
		boolean flag = arbitratorInfoService.userRegisterBusiExecute(formData);
		
		return flag?super.ok():super.error(ApiResultVO.Coder.DB_INSERT_ERROR);
	}
}
