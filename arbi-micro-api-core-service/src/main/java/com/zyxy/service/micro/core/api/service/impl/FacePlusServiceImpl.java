package com.zyxy.service.micro.core.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.dto.FaceIdNotifyDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.service.micro.core.api.service.FacePlusService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FacePlusServiceImpl implements FacePlusService {

    @Override
    public BusiExecuteResult livenessReturnBusiExecuteResult(FaceIdNotifyDTO formData) {
        String data = formData.getData();
        JSONObject dataJson = JSONObject.parseObject(data);
        JSONObject livenessResult = dataJson.getObject("liveness_result", JSONObject.class);
        //活体结果
        String livenessResultStr = livenessResult.getString("result");

        //修改对象
        JSONObject verifyResult = dataJson.getObject("verify_result", JSONObject.class);
        if ("success".equals(livenessResultStr) && StringUtils.isBlank(verifyResult.getString("error_message"))) {
            JSONObject resultFaceid = verifyResult.getObject("result_faceid", JSONObject.class);
            //匹配显示度
            Float confidence = resultFaceid.getFloat("confidence");
            JSONObject thresholds = resultFaceid.getObject("thresholds", JSONObject.class);
            //匹配度阈值
            Float compareNum = thresholds.getFloat("1e-4");
            if (confidence.compareTo(compareNum) >= 0) {
                return BusiExecuteResult.builderSuccessResult();
            } else {
                return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
            }
        } else {
            return BusiExecuteResult.builderErrorResult(ApiResultVO.Coder.ERROR);
        }
    }
}
