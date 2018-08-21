package com.zyxy.service.micro.api.service.micro;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ChangeDocDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorPersonalInfoVO;
import com.zyxy.common.vo.CaseCommInfoVO;
import com.zyxy.common.vo.LitigantCaseListVO;
import com.zyxy.common.vo.PayAndCaseInfoVO;
import com.zyxy.common.vo.PayAndChangeInfoVO;
import com.zyxy.common.vo.PayOrderVO;
import com.zyxy.common.vo.RequestVO;

@FeignClient("coreServiceDev")
public interface LitigantCaseService {

	@RequestMapping(value = "/litigant/case", method = RequestMethod.POST)
	ApiResultVO<PageInfo<LitigantCaseListVO>> list(@RequestBody LitigantCaseListDTO formData);

	@RequestMapping(value = "/litigant/case/{caseId}/arbitratorInfo", method = RequestMethod.POST)
	ApiResultVO<List<ArbitratorPersonalInfoVO>> get(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

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

	@RequestMapping(value = "/litigant/case//backChange/{changeId}/doc", method = RequestMethod.POST)
	ApiResultVO<PayAndChangeInfoVO> backChangeDoc(@PathVariable("changeId") String changeId,@RequestBody ChangeDocDTO formData);
}
