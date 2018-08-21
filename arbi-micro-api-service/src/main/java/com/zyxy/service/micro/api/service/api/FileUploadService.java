package com.zyxy.service.micro.api.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.enums.SysEnum;
import com.zyxy.common.service.micro.MicroFileService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqFileUploadDTO;
import com.zyxy.service.micro.api.dto.ResFileUploadDTO;

/**
 * 文件上传
 * @author tanquan
 */
@Service
public class FileUploadService extends BaseService<ReqFileUploadDTO, ResFileUploadDTO>{
    
    @Autowired
    private MicroFileService microFileService;
    @Override
    protected  BuzzResultVO<ResFileUploadDTO> doBuzz(ReqFileUploadDTO dto, String currentIp) {
        ApiResultVO<String> apiRet = microFileService.uploadFile(dto.getOrgNo(), SysEnum.FileBuzzType.CASE_EVIDENCE.getCode(), dto.getMultipartFile());
        if (!super.isApiExcuteSuccess(apiRet)) {
            return super.error(super.getApiExcuteMessage(apiRet));
        }
        ResFileUploadDTO resDTO = new ResFileUploadDTO();
        resDTO.setFileId(apiRet.getBody());
        return super.success(resDTO);
    }
    
}

 