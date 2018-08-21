package com.zyxy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.zyxy.common.annotation.WebLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.DataStatisticsService;
import com.zyxy.common.domain.DataStatistics;
import com.zyxy.common.dto.ArbitratorInfoDTO;
import com.zyxy.common.dto.DataStatisticsDTO;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DataStatisticsVO;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 *  数据统计控制层
 */
@Controller
@RequestMapping("/data/statistics")
public class DataStatisticsController extends BaseController {

    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**
     * 仲裁委数据统计
     * @param formData
     * @param bindingResult
     * @param request
     * @return
     */
    @WebLog("仲裁委-数据统计")
    @RequestMapping("")
    public ModelAndView statistics(@Valid DataStatisticsDTO formData,
    		BindingResult bindingResult, HttpServletRequest request){
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        formData.setUserId(sessionUser.getUserInfoId());
        
        ModelAndView modelAndView=new ModelAndView("case/dataStatistics");

        //参数验证
        if(bindingResult.hasErrors()){
            modelAndView.addObject("code", ResultVO.Result.VALID_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.VALID_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务验证
        BusiValidResult busiValidResult = dataStatisticsService
        		.queryDataStatisticsBusiValid(formData.getUserId());

        if(busiValidResult.hasError()){
            modelAndView.addObject("code", ResultVO.Result.ACCOUNT_ERROR_CODE);
            modelAndView.addObject("message",ResultVO.Result.ACCOUNT_ERROR_MESSAGE);
            return modelAndView;
        }

        //业务处理
        DataStatisticsVO dataStatisticsVO = dataStatisticsService
        		.queryDataStatisticsBusiBusiExecute(formData);

        //返回对象到页面
        modelAndView.addObject("dataStatisticsVO",dataStatisticsVO);
        return modelAndView;
    }
    
    @WebLog("查询当月数据统计")
	@RequestMapping(value = "/months")
	@ResponseBody
	public DataStatisticsVO selectStatistics(DataStatisticsDTO formData){
		SecurityUserVO sessionUser = super.getSessionUser();
		
		//参数初始化
        formData.setUserId(sessionUser.getUserInfoId());
		
		//业务处理
		DataStatisticsVO dataStatisticsVO = dataStatisticsService
        		.queryDataStatisticsBusiBusiExecute(formData);
		
		return dataStatisticsVO;
	}
}
