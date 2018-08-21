package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqFileDownloadDTO;

/**
 * 文件下载
 * @author tanquan
 */
@Service
public class FileDownloadService extends BaseService<ReqFileDownloadDTO, String>{
    
    @Autowired
    private MicroFileService microFileService;
    @Override
    protected  BuzzResultVO<String> doBuzz(ReqFileDownloadDTO dto, String currentIp) {
        return super.success(null);
    }
    
}

