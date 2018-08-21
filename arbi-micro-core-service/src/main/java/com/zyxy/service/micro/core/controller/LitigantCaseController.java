package com.zyxy.service.micro.core.controller;

import java.util.List;

import com.zyxy.common.dto.DelayedReplyDTO;
import com.zyxy.common.vo.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ChangeDocDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.dto.ReplyDocDTO;
import com.zyxy.common.vo.PayAndCaseInfoVO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.LitigantCaseSercvice;

@Api(description="当事人案件")
@RestController
@RequestMapping("/litigant/case")
public class LitigantCaseController extends BaseController{

	@Autowired
	private LitigantCaseSercvice litigantCaseSercvice;
	@Autowired
	private CommonService commonService;
	
	@ApiOperation(value ="当事人案件列表")
	@RequestMapping("")
	public ApiResultVO<PageInfo<LitigantCaseListVO>> list(@RequestBody @Valid LitigantCaseListDTO formData,
			BindingResult bindingResult,HttpServletRequest request){
        if (bindingResult.hasErrors()) {
			return super.validError();
		}
        PageInfo<LitigantCaseListVO> pageInfo = litigantCaseSercvice.selectLitigantCaseList(formData);

		return super.ok(pageInfo);
	}
	
	@ApiOperation(value="案件仲裁员")
	@RequestMapping(value="/{caseId}/arbitratorInfo")
	public ApiResultVO<ArbitratorInfoVO> get( @PathVariable String caseId,HttpServletRequest request){
        if (StringUtils.isBlank(caseId)) {
			return super.validError();
		}
        ArbitratorInfoVO info = litigantCaseSercvice.selectArbitratorInfoByCaseId(caseId);
		return super.ok(info);
	}

	@ApiOperation(value="案件缴费信息")
	@RequestMapping(value="/{caseId}/payInfo", method = RequestMethod.POST)
	public ApiResultVO<PayOrderVO> payInfo(@PathVariable String caseId, @RequestParam("userId") String userId) {
		//业务验证
		BusiValidResult busiValidResult = litigantCaseSercvice.casePayInfoBusiValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<PayOrderVO> busiExecuteResult = litigantCaseSercvice.casePayInfoBusiExecute(caseId, userId);
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}

	@ApiOperation("当事人-案件基本信息")
	@RequestMapping(value="/{caseId}/caseInfo")
	public ApiResultVO<PayAndCaseInfoVO> getCaseInfo(@PathVariable("caseId") String caseId,@RequestBody String userId){
		//参数验证
		if (StringUtils.isBlank(caseId)||StringUtils.isBlank(userId)) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = litigantCaseSercvice.litigantCaseInfoBusiValid(caseId,userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<PayAndCaseInfoVO> busiExecuteResult = 
				litigantCaseSercvice.litigantCaseInfoBusiExecute(caseId,userId);
		
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	} 	

	@ApiOperation("当事人-案件反请求基本信息")
	@RequestMapping(value="/{caseId}/backRequest")
	public ApiResultVO<PayAndCaseInfoVO> getBackReqInfo(@PathVariable("caseId") String caseId,@RequestBody String userId){
		//参数验证
		if (StringUtils.isBlank(caseId)||StringUtils.isBlank(userId)) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = litigantCaseSercvice.litigantCaseInfoBusiValid(caseId,userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<PayAndCaseInfoVO> busiExecuteResult = 
				litigantCaseSercvice.litigantBackRequestInfoBusiExecute(caseId,userId);

		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}
	
	 @ApiOperation(value="案件公共部分信息")
	 @RequestMapping(value = "/{caseId}/commInfo")
	 public ApiResultVO<CaseCommInfoVO> caseCommInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
		 //参数验证
		 if (StringUtils.isBlank(caseId)) {
			 return super.validError();
		 }
		 BusiExecuteResult<CaseCommInfoVO> busiExecuteResult = litigantCaseSercvice.caseCommInfoBusiExecute(caseId, userId);
		 return super.busiExecuteSuccess(busiExecuteResult.getBody());
	 }
	 
	 @ApiOperation("请求列表(本请求，本请求变更)")
	 @PostMapping("/{caseId}/request")
	 public ApiResultVO<RequestVO> requestList(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId){
		 if (StringUtils.isBlank(caseId)||StringUtils.isBlank(userId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.requestInfoValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<RequestVO> busiExecuteResult = litigantCaseSercvice.requestInfoExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		 return super.ok(busiExecuteResult.getBody());
	 }
	 
	 @ApiOperation("请求列表(反 请求，反请求变更)")
	 @PostMapping("/back/{caseId}/request")
	 public ApiResultVO<RequestVO> backRequestList(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId){
		 if (StringUtils.isBlank(caseId)||StringUtils.isBlank(userId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.backRequestInfoValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<RequestVO> busiExecuteResult = litigantCaseSercvice.backRequestInfoExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		 return super.ok(busiExecuteResult.getBody());
	 }
	
	 @ApiOperation("变更请求文书内容")
	 @PostMapping("/change/{changeId}/doc")
	 public ApiResultVO<PayAndChangeInfoVO> changeDoc(@PathVariable("changeId") String changeId,@RequestBody ChangeDocDTO formData,
			 BindingResult bindingResult){
		 if (bindingResult.hasErrors()) {
			super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.changeDocValid(formData.getCaseId(), formData.getChangeId(), formData.getUserId());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<PayAndChangeInfoVO> busiExecuteResult = litigantCaseSercvice.changeDocExecute(formData.getCaseId(), formData.getChangeId(), formData.getUserId());
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	 }

	@ApiOperation("延期答辩")
	@PostMapping("/{caseId}/delayedReply")
	public ApiResultVO delayedReply(@RequestBody DelayedReplyDTO formData, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.delayedReplyValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult busiExecuteResult = litigantCaseSercvice.delayedReplyExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}

	 @ApiOperation("变更反请求文书内容")
	 @PostMapping("/backChange/{changeId}/doc")
	 public ApiResultVO<PayAndChangeInfoVO> backChangeDoc(@PathVariable("changeId") String changeId,@RequestBody ChangeDocDTO formData,
			 BindingResult bindingResult){
		 if (bindingResult.hasErrors()) {
				super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.backChangeDocValid(formData.getCaseId(), formData.getChangeId(), formData.getUserId());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<PayAndChangeInfoVO> busiExecuteResult = litigantCaseSercvice.backChangeDocExecute(formData.getCaseId(), formData.getChangeId(), formData.getUserId());
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	 }
	 
	 @ApiOperation("仲裁答辩书")
	 @PostMapping("/{caseId}/replyDoc")
	 public ApiResultVO<ReplyDocVO> replyDoc(@PathVariable("caseId")String caseId,@RequestBody ReplyDocDTO formData ,
			 BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.replyDocValid(caseId, formData.getUserId());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<ReplyDocVO> busiExecuteResult = litigantCaseSercvice.replyDocExecute(caseId,formData.getType());
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody()); 
	}
	 
	 @ApiOperation("反请求答辩书")
	 @PostMapping("/back/{caseId}/replyDoc")
	 public ApiResultVO<ReplyDocVO> backReplyDoc(@PathVariable("caseId")String caseId,@RequestBody ReplyDocDTO formData ,
			 BindingResult bindingResult ) {
		 if (bindingResult.hasErrors()) {
				return super.validError();
		}
		BusiValidResult busiValidResult = litigantCaseSercvice.replyDocValid(caseId, formData.getUserId());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<ReplyDocVO> busiExecuteResult = litigantCaseSercvice.backReplyDocExecute(caseId,formData.getType());
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	 
	 @ApiOperation("倒计时")
	 @PostMapping("/{caseId}/countDown")
	 public ApiResultVO<List<CountDownVO>> countDown(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId){
		 if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		 BusiValidResult busiValidResult = litigantCaseSercvice.countDownValid(caseId, userId);
		 if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		 BusiExecuteResult<List<CountDownVO>> busiExecuteResult = litigantCaseSercvice.countDownExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		 return super.ok(busiExecuteResult.getBody());
	 }
	 
	 @ApiOperation("撤案信息")
	 @PostMapping("/{caseId}/withdrawMsg")
	 public ApiResultVO<WithdrawMessageVO> withdrawMsg(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId){
		 if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = commonService.commonCaseAndUserValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<WithdrawMessageVO> busiExecuteResult = litigantCaseSercvice.withdrawMessageExecute(caseId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	 }
}
