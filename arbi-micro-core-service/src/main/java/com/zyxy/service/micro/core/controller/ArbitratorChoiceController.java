package com.zyxy.service.micro.core.controller;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.dto.CaseArbitratorOprInsertDTO;
import com.zyxy.common.enums.SysRecommendFlagEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorAvoidRecordVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.ArbitratorChoiceService;

/**
 * 仲裁员选择
 */
@RestController
@RequestMapping("/arbitrator/choice")
public class ArbitratorChoiceController extends BaseController{
	
	@Autowired
	private ArbitratorChoiceService arbitratorChoiceService; 
	
	@ApiModelProperty(value="当事人选择仲裁员")
	@RequestMapping("/add")
	public ApiResultVO<String> add(@RequestBody @Valid CaseArbitratorOprInsertDTO formData,BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		if (SysRecommendFlagEnum.SELF_CHOICE.getValue().equals(formData.getIsSysRecom()) 
				&& StringUtils.isBlank(formData.getArbitratorId())){
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = arbitratorChoiceService.arbitratorChoiceBusiValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = arbitratorChoiceService.arbitratorChoiceBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess();
	}
	
	@ApiModelProperty(value="仲裁员回避列表")
	@RequestMapping("/{caseId}/list")
	public ApiResultVO<List<ArbitratorAvoidRecordVO>> list(@PathVariable("caseId")String caseId,@RequestParam("userId")String userId){
		//参数验证
		if (StringUtils.isBlank(caseId)||StringUtils.isBlank(userId)) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = arbitratorChoiceService.arbitratorAvoidListValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<List<ArbitratorAvoidRecordVO>> busiExecuteResult = arbitratorChoiceService.arbitratorAvoidListExecute(caseId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}	
	
}
