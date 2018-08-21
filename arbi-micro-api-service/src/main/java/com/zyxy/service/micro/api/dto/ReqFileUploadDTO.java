package com.zyxy.service.micro.api.dto;

import org.springframework.web.multipart.MultipartFile;


public class ReqFileUploadDTO extends ReqBaseDTO{
    
    /**
     * 文件
     */
    private MultipartFile multipartFile;
    @Override
    public String[] getSecretKeys() {
        return null;
    }


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }


    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
    
    @Override
    public String[] noSignKeys() {
        return new String[] {"multipartFile"};
    }
}
