package com.zyxy.service.micro.core.api.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ChangeDocDTO;
import com.zyxy.common.dto.DelayedReplyDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.dto.ReplyDocDTO;
import com.zyxy.common.vo.*;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("coreService")
public interface LitigantCaseService {

	@RequestMapping(value = "/litigant/case", method = RequestMethod.POST)
	ApiResultVO<PageInfo<LitigantCaseListVO>> list(@RequestBody LitigantCaseListDTO formData);

	@RequestMapping(value = "/litigant/case/{caseId}/arbitratorInfo", method = RequestMethod.POST)
	ApiResultVO<ArbitratorInfoVO> get(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

	@RequestMapping(value = "/litigant/case/{caseId}/payInfo", method = RequestMethod.POST)
	ApiResultVO<PayOrderVO> payInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

	@RequestMapping(value = "/litigant/case/{caseId}/caseInfo",method=RequestMethod.POST)
	ApiResultVO<PayAndCaseInfoVO> getCaseInfo(@PathVariable("caseId") String caseId,@RequestBody String userId);
	
	@RequestMapping(value = "/litigant/case/{caseId}/backRequest",method=RequestMethod.POST)
	ApiResultVO<PayAndCaseInfoVO> getBackRequest(@PathVariable("caseId") String caseId,@RequestBody String userId);
	
	@RequestMapping(value = "/litigant/case/{caseId}/commInfo", method = RequestMethod.POST)
	ApiResultVO<CaseCommInfoVO> getCommonInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);
	
	@RequestMapping(value = "/litigant/case/{caseId}/request", method = RequestMethod.POST)
	ApiResultVO<RequestVO> getRequestList(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);
	
	@RequestMapping(value = "/litigant/case/back/{caseId}/request", method = RequestMethod.POST)
	ApiResultVO<RequestVO> getBackRequestList(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

	@RequestMapping(value = "/litigant/case/change/{changeId}/doc", method = RequestMethod.POST)
	ApiResultVO<PayAndChangeInfoVO> changeDoc(@PathVariable("changeId") String changeId,@RequestBody ChangeDocDTO formData);

	@RequestMapping(value = "/litigant/case/{caseId}/delayedReply", method = RequestMethod.POST)
	ApiResultVO delayedReply(@PathVariable("caseId") String caseId, @RequestBody DelayedReplyDTO formData);
	
	@RequestMapping(value = "/litigant/case/backChange/{changeId}/doc", method = RequestMethod.POST)
	ApiResultVO<PayAndChangeInfoVO> backChangeDoc(@PathVariable("changeId") String changeId,@RequestBody ChangeDocDTO formData);
	
	@RequestMapping(value = "/litigant/case/{caseId}/replyDoc", method = RequestMethod.POST)
	ApiResultVO<ReplyDocVO> replyDoc(@PathVariable("caseId") String caseId,@RequestBody ReplyDocDTO formData);
	
	@RequestMapping(value = "/litigant/case/back/{caseId}/replyDoc", method = RequestMethod.POST)
	ApiResultVO<ReplyDocVO> backReplyDoc(@PathVariable("caseId") String caseId,@RequestBody ReplyDocDTO formData);
	
	@RequestMapping(value="/litigant/case/{caseId}/countDown", method = RequestMethod.POST)
	ApiResultVO<List<CountDownVO>> countDown(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId);
	
	@RequestMapping(value="/litigant/case/{caseId}/withdrawMsg", method = RequestMethod.POST)
	ApiResultVO<WithdrawMessageVO> withdrawMsg(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId);
}
