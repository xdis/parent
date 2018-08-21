package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共文件模块
 */
@Api(description = "公共文件模块")
@RequestMapping("/api/public/file")
@RestController
public class ApiPublicFileController extends BaseController {

    @Autowired
    private MicroFileService fileService;

    @WebLog("文件上传")
    @ApiOperation(value = "文件上传")
    @RequestMapping(value = "/uploads", method = {RequestMethod.POST, RequestMethod.GET})
    public ApiResultVO<String> uploads(
            @ApiParam(value = "业务类型编码 用户头像:S_0001，证据材料:C_0001，文书:C_0002，用户证件照:S_0022") @RequestParam String buzzType,
            @ApiParam(value = "文件") @RequestParam MultipartFile uploadFile
    ) {
        return fileService.uploadFile(getSessionUserId(), buzzType, uploadFile);
    }

    @WebLog("文件下载、预览接口")
    @ApiOperation(value = "文件下载、预览接口")
    @RequestMapping(value = "/downloads", method = RequestMethod.GET, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> downloads(@RequestParam(value = "id") String id) {
        return fileService.downloadFile(id);
    }

}
