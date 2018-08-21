package com.zyxy.service.micro.third.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.FaceIdDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.FaceIdGetTokenVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.third.service.FaceIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "活体认证")
@RequestMapping("/faceId")
@RestController
public class FaceIdController extends BaseController {

    @Autowired
    private FaceIdService faceIdService;

    @ApiOperation(value = "获取faceId的token")
    @RequestMapping(value = "/getToken",method = RequestMethod.POST)
    public ApiResultVO<FaceIdGetTokenVO> getToken(@RequestBody @Valid FaceIdDTO formData, BindingResult bindingResult, HttpServletRequest request){
        logger.info(JSONObject.toJSONString(formData));
        if(bindingResult.hasErrors()){
            return super.validError();
        }

        BusiExecuteResult<FaceIdGetTokenVO> busiExecuteResult=faceIdService.getToken(formData);

        return super.busiExecuteSuccess(busiExecuteResult.getBody());


    }


}
