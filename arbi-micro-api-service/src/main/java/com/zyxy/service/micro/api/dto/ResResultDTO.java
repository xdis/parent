package com.zyxy.service.micro.api.dto;

import com.zyxy.service.micro.api.enums.ApiCodeEnum;


public class ResResultDTO {
    
    /**
     * 返回结果代码
     */
    private String code;
    
    /**
     * 返回结果信息
     */
    private String message;
    
    /**
     * 系统当前时间戳
     */
    private String ts;
    
    /**
     * 返回加密内容对象字符串
     */
    private String result;
    
    public ResResultDTO() {};
    
    public ResResultDTO(ApiCodeEnum coder) {
        this.setCode(coder.getCode());
        this.setMessage(coder.getMessage());
    }
    
    public ResResultDTO setCoder(ApiCodeEnum coder) {
        this.setCode(coder.getCode());
        this.setMessage(coder.getMessage());
        return this;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public ResResultDTO setMessage(String message) {
        this.message = message;
        return this;
    }
    
    
    
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getResult() {
        return result;
    }

    public ResResultDTO setResult(String result) {
        this.result = result;
        return this;
    }
}
