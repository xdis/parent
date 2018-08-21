package com.zyxy.common.service.micro;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.domain.SysFile;
import com.zyxy.common.service.micro.fallback.MicroFileServiceImpl;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 文件服务
 * @author tanquan
 *
 */
@FeignClient(value = "fileService", fallback=MicroFileServiceImpl.class)
public interface MicroFileService {
    
    
    /**
     * 文件上传
     * @param userId 上传者
     * @param buzzType 请参考 SysEnum.FileBuzzType
     * @param uploadFile 文件流
     * @return
     */
    @RequestMapping(value = "/file/uploads", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResultVO<String> uploadFile(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "buzzType") String buzzType,
            @RequestPart("uploadFile") MultipartFile uploadFile);
    
    /**
     * 文件下载
     * @param id 文件ID
     * @return
     */
    @RequestMapping(value = "/file/downloads",method = RequestMethod.GET, consumes =MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> downloadFile(
            @RequestParam(value = "id") String id
            );
    
    /**
     * 查看文件摘要信息
     * @param id 文件ID
     * @return
     */
    @RequestMapping(value = "/file/getFileInfoById",method = RequestMethod.POST)
    ApiResultVO<SysFile> getFileInfoById(
            @RequestParam(value = "id") String id
            );
    
}
