package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.dto.MessageInsertDTO;
import com.zyxy.common.dto.SysUserPwdDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorCaseBaseInfoVO;
import com.zyxy.common.vo.CaseDocVO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 公共service，调用核心服务
 */
@FeignClient("coreService")
public interface PublicCoreService {
	/**
	 * 调用coreService中的案件基本信息业务处理service
	 * 
	 * @param caseId
	 * @return
	 */
	@RequestMapping(value = "/arbitrator/case/{caseId}", method = RequestMethod.GET)
	ApiResultVO<ArbitratorCaseBaseInfoVO> caseBaseInfoBusiExecuteClient(
			@PathVariable("caseId") String caseId,
			@RequestParam("userId") String userId);

	/**
	 * 调用coreService中的预览裁决书service
	 * 
	 * @param caseId案件ID
	 * @param userId
	 *            仲裁员ID
	 * @return
	 */
	@RequestMapping(value = "/arbitrator/case/{caseId}/previewArbitramentDoc", method = RequestMethod.POST)
	ApiResultVO<CaseDocVO> get(@PathVariable("caseId") String caseId,
			@RequestParam("userId") String userId);


	/**
	 * 调用coreService中MessageController的发送消息
	 * 
	 * @param formData
	 * @return
	 */
	@RequestMapping(value = "/common/message/post", method = RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody MessageInsertDTO formData);

	/**
	 * 调用coreService中CaseAvoidController的公共-申请回避
	 */
	@RequestMapping(value = "/public/case/avoid", method = RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody CaseAvoidRecordInsertDTO formData);

}
