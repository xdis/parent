package com.zyxy.admin.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zyxy.admin.service.ArgueRecordService;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ResultVO;
import com.zyxy.common.web.BaseController;

/**
 * 辩论
 */
@Controller
@RequestMapping("/case/argue")
public class ArgueRecordController extends BaseController {
	
	@Autowired
	private ArgueRecordService argueRecordService;
	
	@WebLog("辩论记录列表")
    @RequestMapping("/lists/{caseId}")
	public ModelAndView list(@PathVariable("caseId") String caseId){
		
		ModelAndView modelAndView= new ModelAndView("case/debate");
		
		//参数验证
		if (StringUtils.isBlank(caseId)) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}
		
		//业务处理
		BusiExecuteResult<List<ArgueRecord>> busiExecuteResult = argueRecordService.argueRecordList(caseId);
		if (busiExecuteResult.hasError()) {
			modelAndView.addObject("code", ResultVO.Result.NOT_FOUND_CODE);
			modelAndView.addObject("message", ResultVO.Result.NOT_FOUND_MESSAGE);
			return modelAndView;
		}
		
		modelAndView.addObject("argueRecordList", busiExecuteResult.getBody());
		
		return modelAndView;
	}
}
