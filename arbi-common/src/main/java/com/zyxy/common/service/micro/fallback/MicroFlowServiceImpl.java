package com.zyxy.common.service.micro.fallback;

import com.zyxy.common.dto.flow.*;
import com.zyxy.common.service.micro.MicroFlowService;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.stereotype.Component;

@Component
public class MicroFlowServiceImpl implements MicroFlowService {
    @Override
    public ApiResultVO<String> audit(String caseId, CaseAuditDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("立案审核流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> pay(String caseId, CasePayDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("缴费流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> compromiseExit(String caseId) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("中途退出和解流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> caseOver(String caseId, CaseOverDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("案件结案流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> compromiseOver(String caseId, CaseCompromiseOverDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("案件结案流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> giveReply(String caseId, CaseGiveReplyDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("案件结案流程控制调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> cancelCase(String caseId, CaseCancelDTO formData) {
        return new ApiResultVO<String>().setCoder(ApiResultVO.Coder.CALL_SERV_ERROR).setMessage("案件结案流程控制调用失败，请检查服务是否启动");
    }
}
