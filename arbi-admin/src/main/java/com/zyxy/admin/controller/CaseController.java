package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ArbitrationCaseService;
import com.zyxy.admin.service.CaseListService;
import com.zyxy.admin.service.CaseProcessingService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseListDTO;
import com.zyxy.common.enums.ApproveTypeEnum;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.ArbitrationCaseArbitrationApplyVO;
import com.zyxy.common.vo.CaseListVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;


/**
 * 案件控制层
 */
@Controller
@RequestMapping("/case/caseinfo")
public class CaseController extends BaseController {


    @Autowired
    private CaseListService caseListService;
    
    @Autowired
    private CaseProcessingService caseProcessingService;
    
    @Autowired
    private ArbitrationCaseService arbitrationCaseService;

    @WebLog("仲裁委-跳转案件列表")
    @RequestMapping("")
    public ModelAndView list(){
        //参数初始化返回页面
        ModelAndView modelAndView = new ModelAndView("case/caseHanding");
        return modelAndView;
    }

    /**
     * 案件列表
     *
     * @param formData
     * @param bindingResult
     * @param request
     * @return
     */
    @WebLog("仲裁委-案件列表")
    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<CaseListVO> caseList(@Valid CaseListDTO formData, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        formData.setUserId(sessionUser.getUserInfoId());
        
        //参数验证
        if (bindingResult.hasErrors()) {
        	//返回非法参数
        	response.setStatus(Integer.parseInt(Coder.VALID_ERROR.getCode()));
            return null;
        }

        //业务验证
        BusiValidResult busiValidResult = caseListService.queryArbiCaseListBusiValid(sessionUser.getUserInfoId());

        if (busiValidResult.hasError()) {
        	//返回用户账户异常
            response.setStatus(Integer.parseInt(busiValidResult.getCode()));
            return null;
        }

        //业务处理
        BusiExecuteResult<PageInfo<CaseListVO>> busiExecuteResult = caseListService.queryArbiCaseListBusiExcute(formData);

        if(busiExecuteResult.hasError()){
            //返回用户系统异常
            response.setStatus(Integer.parseInt(busiExecuteResult.getCode()));
            return null;
        }


        return busiExecuteResult.getBody();
    }
    
    /**
     * 查询仲裁请求
     * @param caseId
     * @return
     */
    @WebLog(value="仲裁委-查询仲裁请求")
    @RequestMapping(value="/{caseId}/arbitrationRequest")
    public ModelAndView queryArbitrationRequest(@PathVariable("caseId")String caseId){
    	SecurityUserVO sessionUser = super.getSessionUser();
    	
    	//参数初始化
    	ModelAndView modelAndView=new ModelAndView("case/caseDetail");
    	/*
    	 * 参数验证
    	 */
    	if(StringUtils.isBlank(caseId)){
    		modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
    	}
    	
    	/*
    	 * 业务验证
    	 */

    	
    	/*
    	 * 业务执行
    	 */
    	BusiExecuteResult<ArbitrationCaseArbitrationApplyVO> busiExecute=arbitrationCaseService.queryCaseArbitrationRequestInfoBusiExecute(caseId, sessionUser.getUserInfoId(), RequestTypeEnum.REQUEST.getValue());
    	
    	modelAndView.addObject("caseDetail", busiExecute.getBody());
    	return modelAndView;
    }
    
    
    @WebLog(value="仲裁委-查询仲裁反请求")
    @RequestMapping(value="/{caseId}/arbitrationCounterclaim")
    public ModelAndView queryArbitrationCounterclaim(@PathVariable("caseId")String caseId){
    	SecurityUserVO sessionUser = super.getSessionUser();
    	
    	//参数初始化
    	ModelAndView modelAndView=new ModelAndView("case/caseDeatil");
    	/*
    	 * 参数验证
    	 */
    	if(StringUtils.isBlank(caseId)){
    		modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message", ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
    	}
    	
    	/*
    	 * 业务验证
    	 */
//    	BusiValidResult busiValid=caseProcessingService.auditTheCaseBusiValid(caseId,sessionUser.getUserInfoId(),ApproveTypeEnum.INITIATE_APPROVAL.getTypeName());
//    	if(busiValid.hasError()){
//    		 modelAndView.addObject("code", busiValid.getCode());
//             modelAndView.addObject("message", busiValid.getMsg());
//             return modelAndView;
//    	}
    	
    	/*
    	 * 业务执行
    	 */
    	BusiExecuteResult busiExecute=arbitrationCaseService.queryCaseArbitrationRequestInfoBusiExecute(caseId, sessionUser.getUserInfoId(), RequestTypeEnum.BACK_REQUEST.getValue());
    	
    	modelAndView.addObject("caseDetail", busiExecute.getBody());
    	return modelAndView;
    }
}