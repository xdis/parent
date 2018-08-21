package com.zyxy.common.service.micro.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.zyxy.common.domain.SysFile;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

@Component
public class MicroFileServiceImpl implements MicroFileService{

    @Override
    public ApiResultVO<String> uploadFile(String userId, String buzzType,
            MultipartFile uploadFile) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("文件服务调用失败，请检查服务是否启动");
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(String id) {
        return null;
    }

    @Override
    public ApiResultVO<SysFile> getFileInfoById(String id) {
        return new ApiResultVO<SysFile>().setCoder(Coder.CALL_SERV_ERROR).setMessage("文件服务调用失败，请检查服务是否启动");
    }

    
}
