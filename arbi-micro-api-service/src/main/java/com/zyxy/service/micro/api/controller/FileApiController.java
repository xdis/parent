package com.zyxy.service.micro.api.controller;

import java.io.UnsupportedEncodingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.api.dto.ReqFileDownloadDTO;
import com.zyxy.service.micro.api.dto.ReqFileUploadDTO;
import com.zyxy.service.micro.api.dto.ResResultDTO;
import com.zyxy.service.micro.api.enums.ApiCodeEnum;
import com.zyxy.service.micro.api.service.api.FileDownloadService;
import com.zyxy.service.micro.api.service.api.FileUploadService;

@Api(description="文件模块")
@RequestMapping("/api")
@RestController
public class FileApiController extends BaseController{
    
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private FileDownloadService fileDownloadService;
    @Autowired
    private MicroFileService microFileService;
    
	
    @WebLog("文件上传")
    @ApiOperation("文件上传")
    @RequestMapping(value = "/file/upload", method = {RequestMethod.POST})
    public ResResultDTO upload(HttpServletRequest request
            , ReqFileUploadDTO dto
            , MultipartFile uploadFile
            ) {
        dto.setMultipartFile(uploadFile);
        ResResultDTO ret = fileUploadService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
	
    @WebLog("文件下载")
    @ApiOperation("文件下载")
    @RequestMapping(value = "/file/download", method = {RequestMethod.POST})
    public ResponseEntity<byte[]> download(HttpServletRequest request
            , ReqFileDownloadDTO dto
            ) throws UnsupportedEncodingException {
        ResResultDTO ret = fileDownloadService.call(dto, RequestUtil.getIp(request));
        if (!ApiCodeEnum.SUCCESS.getCode().equals(ret.getCode())) {
            return new ResponseEntity<byte[]>(ret.getMessage().getBytes("UTF-8"), HttpStatus.OK);
        }
        ResponseEntity<byte[]> res = microFileService.downloadFile(dto.getFileId());
        return res;
    }
    
}
