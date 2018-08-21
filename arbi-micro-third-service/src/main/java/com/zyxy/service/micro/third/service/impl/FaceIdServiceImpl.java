package com.zyxy.service.micro.third.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.dto.FaceIdDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.util.HttpUtil;
import com.zyxy.common.vo.FaceIdGetTokenVO;
import com.zyxy.service.micro.third.service.FaceIdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Service
public class FaceIdServiceImpl  implements FaceIdService{



    @Value("${faceid.getToken.url}")
    private String url;
    @Value("${faceid.appkey}")
    private String appkey;
    @Value("${faceid.appsecret}")
    private String appsecret;

    @Override
    public BusiExecuteResult<FaceIdGetTokenVO> getToken(FaceIdDTO formData) {


        Map<String,String> paramMap=new HashMap<String,String>();

        paramMap.put("api_key",appkey);
        paramMap.put("api_secret",appsecret);
        paramMap.put("idcard_name",formData.getIdCardName());
        paramMap.put("comparison_type","1");
        paramMap.put("idcard_number",formData.getIdCardNo());
        paramMap.put("return_url",formData.getReturnUrl());
        paramMap.put("notify_url",formData.getNotifyUrl());
        paramMap.put("biz_no",formData.getBizNo());

        String result=HttpUtil.sendPost(url,paramMap);
        FaceIdGetTokenVO faceIdGetTokenVO=JSONObject.parseObject(result,FaceIdGetTokenVO.class);


        return BusiExecuteResult.builderSuccessResult(faceIdGetTokenVO);
    }
}
