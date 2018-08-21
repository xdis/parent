package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyxy.common.dto.AgencyAuthorDTO;
import com.zyxy.common.dto.ChangeAuthorDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.AuthorDocVO;
import com.zyxy.common.vo.CaseLitigantValidDTO;
import com.zyxy.common.vo.MessageVO;

@FeignClient("coreService")
public interface AgentAuthorService {
	
	@RequestMapping(value="/agent/author/{cardId}/elementVerify",method=RequestMethod.POST)
	ApiResultVO<String> elementVerify(@PathVariable("cardId") String cardId);
	
	@RequestMapping(value="/agent/author/litigantValid",method=RequestMethod.POST)
	ApiResultVO<String> litigantValid(@RequestBody CaseLitigantValidDTO formData);
	
	@RequestMapping(value="/agent/author/author",method=RequestMethod.POST)
	ApiResultVO<String> author(@RequestBody AgencyAuthorDTO formData);
	
	@RequestMapping(value="/agent/author/preview",method=RequestMethod.POST)
	ApiResultVO<AuthorDocVO> preview(@RequestBody AgencyAuthorDTO formData);
	
	@RequestMapping(value="/agent/author/authorMsg",method=RequestMethod.POST)
	ApiResultVO<MessageVO> authorMsg(@RequestBody AgencyAuthorDTO formData);
	
	@RequestMapping(value="/agent/author/changeAuthor",method=RequestMethod.POST)
	ApiResultVO<String> changeAuthor(@RequestBody ChangeAuthorDTO formData);
	
	@RequestMapping(value="/agent/author/cancelAuthor",method=RequestMethod.POST)
	ApiResultVO<String> cancelAuthor(@PathVariable("caseId")String caseId,@RequestParam("userId")String userId);
}
