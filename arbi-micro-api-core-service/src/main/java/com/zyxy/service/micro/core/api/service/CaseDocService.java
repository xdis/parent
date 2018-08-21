package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseDocVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 案件文书控制层
 */
@FeignClient("coreService")
public interface CaseDocService {

    @RequestMapping(value = "/arbitrator/case/{caseId}/previewArbitramentDoc", method = RequestMethod.POST)
    ApiResultVO<CaseDocVO> get(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

}
